package com.dewonderstruck.apps.stickrs.util

import com.google.firebase.database.*

typealias DataSnapshotOrException = DataOrException<DataSnapshot?, DatabaseException?>

class RealtimeDatabaseQueryLiveData : LingeringLiveData<DataSnapshotOrException>, ValueEventListener {

    private val query: Query
    private val displayPath: String

    constructor(ref: DatabaseReference) {
        this.query = ref
        this.displayPath = refToPath(ref)
    }

    constructor(query: Query) {
        this.query = query
        this.displayPath = "query@${refToPath(query.ref)}"
    }

    private fun refToPath(ref: DatabaseReference): String {
        var r = ref
        val parts = mutableListOf<String>()
        while (r.key != null) {
            parts.add(r.key!!)
            r = r.parent!!
        }
        return parts.asReversed().joinToString("/")
    }

    override fun beginLingering() {
        query.addValueEventListener(this)
    }

    override fun endLingering() {
        query.removeEventListener(this)
    }

    override fun onDataChange(snap: DataSnapshot) {
        value = DataSnapshotOrException(snap, null)
    }

    override fun onCancelled(e: DatabaseError) {
        value = DataSnapshotOrException(null, e.toException())
    }

}