package com.dewonderstruck.apps.stickrs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dewonderstruck.apps.stickrs.Bean.StickersBean
import com.dewonderstruck.apps.stickrs.util.FirebaseQueryLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FirstViewModel  : ViewModel() {

    private val BANR_ = FirebaseDatabase.getInstance("https://production-stickrs-default-rtdb.europe-west1.firebasedatabase.app").getReference("signalstickers").child("manifest")

    private val liveData: FirebaseQueryLiveData = FirebaseQueryLiveData(BANR_)

    fun getDataSnapshotLiveData(): LiveData<DataSnapshot?> {
        return liveData
    }


}