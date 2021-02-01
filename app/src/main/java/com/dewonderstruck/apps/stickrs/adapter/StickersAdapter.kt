package com.dewonderstruck.apps.stickrs.adapter

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.webp.decoder.WebpDrawable
import com.bumptech.glide.integration.webp.decoder.WebpDrawableTransformation
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.dewonderstruck.apps.stickrs.Bean.StickersBean
import com.dewonderstruck.apps.stickrs.R
import com.firebase.ui.database.paging.DatabasePagingOptions
import com.firebase.ui.database.paging.FirebaseRecyclerPagingAdapter
import com.firebase.ui.database.paging.LoadingState


internal class StickersAdapter(options: DatabasePagingOptions<StickersBean>) : FirebaseRecyclerPagingAdapter<StickersBean, StickersAdapter.eventsViewholder>(
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
        val pm = context.packageManager
        val isInstalled = isPackageInstalled("org.thoughtcrime.securesms", pm)
        holder.addbtn.setOnClickListener { view ->
            if (isInstalled) {
                val browserIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("sgnl://addstickers/?pack_id=$id&pack_key=$key")
                )
                context.startActivity(browserIntent)
            } else {
                val url = "https://signal.art/addstickers/#pack_id=$id&pack_key=$key"
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                context.startActivity(i)
            }

        }

        val circleCrop: Transformation<Bitmap> = CircleCrop()
        Glide.with(context)
            .asBitmap()
            .load(model.cover)
            .optionalTransform(circleCrop)
            .optionalTransform(WebpDrawable::class.java, WebpDrawableTransformation(circleCrop))
            .into(holder.coverimg)
        //Glide.with(context).load(imageByteArray).asBitmap().into(holder.coverimg)
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
        var coverimg: ImageView

        init {
            title = itemView.findViewById(R.id.item_title)
            author = itemView.findViewById(R.id.item_descrp)
            addbtn = itemView.findViewById(R.id.addbutton)
            coverimg = itemView.findViewById(R.id.imageView3)

        }
    }

    override fun onLoadingStateChanged(state: LoadingState) {
    }

    private fun isPackageInstalled(packageName: String, packageManager: PackageManager): Boolean {
        return try {
            packageManager.getPackageInfo(packageName, 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }
}