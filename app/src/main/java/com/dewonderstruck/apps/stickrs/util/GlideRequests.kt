package com.dewonderstruck.apps.stickrs.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.annotation.CheckResult
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.manager.Lifecycle
import com.bumptech.glide.manager.RequestManagerTreeNode
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.test.GlideOptions
import java.io.File
import java.net.URL

/**
 * Includes all additions from methods in [com.bumptech.glide.annotation.GlideExtension]s
 * annotated with [com.bumptech.glide.annotation.GlideType]
 *
 *
 * Generated code, do not modify
 */
class GlideRequests(
    glide: Glide, lifecycle: Lifecycle,
    treeNode: RequestManagerTreeNode, context: Context
) :
    RequestManager(glide, lifecycle, treeNode, context) {
    @CheckResult
    override fun <ResourceType> `as`(resourceClass: Class<ResourceType>): GlideRequest<ResourceType> {
        return GlideRequest(glide, this, resourceClass, context)
    }

    @Synchronized
    override fun applyDefaultRequestOptions(options: RequestOptions): GlideRequests {
        return super.applyDefaultRequestOptions(options) as GlideRequests
    }

    @Synchronized
    override fun setDefaultRequestOptions(options: RequestOptions): GlideRequests {
        return super.setDefaultRequestOptions(options) as GlideRequests
    }

    override fun addDefaultRequestListener(listener: RequestListener<Any>): GlideRequests {
        return super.addDefaultRequestListener(listener) as GlideRequests
    }

    @CheckResult
    override fun asBitmap(): GlideRequest<Bitmap> {
        return super.asBitmap() as GlideRequest<Bitmap>
    }

    @CheckResult
    override fun asGif(): GlideRequest<GifDrawable> {
        return super.asGif() as GlideRequest<GifDrawable>
    }

    @CheckResult
    override fun asDrawable(): GlideRequest<Drawable> {
        return super.asDrawable() as GlideRequest<Drawable>
    }

    @CheckResult
    override fun load(bitmap: Bitmap?): GlideRequest<Drawable> {
        return super.load(bitmap) as GlideRequest<Drawable>
    }

    @CheckResult
    override fun load(drawable: Drawable?): GlideRequest<Drawable> {
        return super.load(drawable) as GlideRequest<Drawable>
    }

    @CheckResult
    override fun load(string: String?): GlideRequest<Drawable> {
        return super.load(string) as GlideRequest<Drawable>
    }

    @CheckResult
    override fun load(uri: Uri?): GlideRequest<Drawable> {
        return super.load(uri) as GlideRequest<Drawable>
    }

    @CheckResult
    override fun load(file: File?): GlideRequest<Drawable> {
        return super.load(file) as GlideRequest<Drawable>
    }

    @CheckResult
    override fun load(@RawRes @DrawableRes id: Int?): GlideRequest<Drawable> {
        return super.load(id) as GlideRequest<Drawable>
    }

    @Deprecated("")
    @CheckResult
    override fun load(url: URL?): GlideRequest<Drawable> {
        return super.load(url) as GlideRequest<Drawable>
    }

    @CheckResult
    override fun load(bytes: ByteArray?): GlideRequest<Drawable> {
        return super.load(bytes) as GlideRequest<Drawable>
    }

    @CheckResult
    override fun load(o: Any?): GlideRequest<Drawable> {
        return super.load(o) as GlideRequest<Drawable>
    }

    @CheckResult
    override fun downloadOnly(): GlideRequest<File> {
        return super.downloadOnly() as GlideRequest<File>
    }

    @CheckResult
    override fun download(o: Any?): GlideRequest<File> {
        return super.download(o) as GlideRequest<File>
    }

    @CheckResult
    override fun asFile(): GlideRequest<File> {
        return super.asFile() as GlideRequest<File>
    }

    override fun setRequestOptions(toSet: RequestOptions) {
        if (toSet is com.bumptech.glide.test.GlideOptions) {
            super.setRequestOptions(toSet)
        } else {
            super.setRequestOptions(GlideOptions().apply(toSet))
        }
    }
}