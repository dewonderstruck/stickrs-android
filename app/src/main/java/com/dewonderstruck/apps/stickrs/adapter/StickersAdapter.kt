package com.dewonderstruck.apps.stickrs.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.dewonderstruck.apps.stickrs.Bean.StickersBean
import com.dewonderstruck.apps.stickrs.R
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions


internal class StickersAdapter(options: FirebaseRecyclerOptions<StickersBean>) : FirebaseRecyclerAdapter<StickersBean, StickersAdapter.eventsViewholder>(
    options
) {
    protected override fun onBindViewHolder(
        holder: eventsViewholder,
        position: Int,
        model: StickersBean
    ) {
        holder.title.setText(model.title)
        holder.author.setText(model.author)
        val id = model.id
        val key = model.key
        val context =holder.title.context
        holder.addbtn.setOnClickListener { view ->
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("sgnl://addstickers/?pack_id=$id&pack_key=$key")
            )
            context.startActivity(browserIntent)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): eventsViewholder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_eventlist,
            parent,
            false
        )
        return eventsViewholder(view)
    }

    internal inner class eventsViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var author: TextView
        var addbtn: Button

        init {
            title = itemView.findViewById(R.id.item_title)
            author = itemView.findViewById(R.id.item_descrp)
            addbtn = itemView.findViewById(R.id.addbutton)

        }
    }
}