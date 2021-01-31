package com.dewonderstruck.apps.stickrs.adapter

import android.view.LayoutInflater
import com.dewonderstruck.apps.stickrs.R
import com.dewonderstruck.apps.stickrs.glide.cache.ApngOptions
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.Request
import com.bumptech.glide.request.RequestCoordinator
import com.dewonderstruck.apps.stickrs.util.DecryptableStreamUriLoader
import com.dewonderstruck.apps.stickrs.util.GlideRequests
import com.dewonderstruck.apps.stickrs.util.StickerManifest
import com.dewonderstruck.apps.stickrs.util.StickerRemoteUri
import java.util.ArrayList;
import java.util.List;


public class StickerPackPreviewAdapter(glideRequests: GlideRequests, eventListener: EventListener,
                                        allowApngAnimation: Boolean) : RecyclerView.Adapter<StickerPackPreviewAdapter.StickerViewHolder>() {
    private val glideRequests: GlideRequests
    private val eventListener: EventListener
    private val list: MutableList<StickerManifest.Sticker>
    private val allowApngAnimation: Boolean
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): StickerViewHolder {
        return StickerViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.sticker_preview_list_item, viewGroup, false))
    }

    override fun onBindViewHolder(stickerViewHolder: StickerViewHolder, i: Int) {
        stickerViewHolder.bind(glideRequests, list[i], eventListener, allowApngAnimation)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onViewRecycled(holder: StickerViewHolder) {
        holder.recycle()
    }

    fun setStickers(stickers: List<StickerManifest.Sticker>?) {
        list.clear()
        list.addAll(stickers!!)
        notifyDataSetChanged()
    }

    class StickerViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView

        @get:Nullable
        var currentGlideModel: Any? = null
            private set

        @get:Nullable
        var currentEmoji: String? = null
            private set

        fun bind(glideRequests: GlideRequests,
                 sticker: StickerManifest.Sticker,
                 eventListener: EventListener,
                 allowApngAnimation: Boolean) {
            currentEmoji = sticker.getEmoji()
            currentGlideModel = if (sticker.getUri().isPresent()) DecryptableStreamUriLoader.DecryptableUri(sticker.getUri().get()) else StickerRemoteUri(sticker.getPackId(), sticker.getPackKey(), sticker.getId())
            glideRequests.load(currentGlideModel)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .set(ApngOptions.ANIMATE, allowApngAnimation)
                    .into(image)
            image.setOnLongClickListener { v ->
                eventListener.onStickerLongPress(v)
                true
            }
        }

        fun recycle() {
            image.setOnLongClickListener(null)
        }

        init {
            image = itemView.findViewById(R.id.sticker_install_item_image)
        }
    }

    interface EventListener {
        fun onStickerLongPress(view: View)
    }

    init {
        this.glideRequests = glideRequests
        this.eventListener = eventListener
        this.allowApngAnimation = allowApngAnimation
        list = ArrayList()
    }
}