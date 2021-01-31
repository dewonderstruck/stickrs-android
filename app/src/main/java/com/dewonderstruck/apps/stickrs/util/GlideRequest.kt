package com.dewonderstruck.apps.stickrs.util

import android.content.Context
import android.content.res.Resources.Theme
import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.annotation.*
import androidx.annotation.IntRange
import com.bumptech.glide.*
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.Key
import com.bumptech.glide.load.Option
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
import com.bumptech.glide.request.BaseRequestOptions
import com.bumptech.glide.request.RequestListener
import java.io.File
import java.net.URL

/**
 * Contains all public methods from [<], all options from
 * [com.bumptech.glide.request.RequestOptions] and all generated options from
 * [com.bumptech.glide.annotation.GlideOption] in annotated methods in
 * [com.bumptech.glide.annotation.GlideExtension] annotated classes.
 *
 *
 * Generated code, do not modify.
 *
 * @see RequestBuilder<TranscodeType>
 *
 * @see com.bumptech.glide.request.RequestOptions
</TranscodeType> */
class GlideRequest<TranscodeType> : RequestBuilder<TranscodeType>, Cloneable {
    internal constructor(transcodeClass: Class<TranscodeType>, other: RequestBuilder<*>) : super(
        transcodeClass,
        other
    ) {
    }

    internal constructor(
        glide: Glide, requestManager: RequestManager,
        transcodeClass: Class<TranscodeType>, context: Context
    ) : super(glide, requestManager, transcodeClass, context) {
    }

    @CheckResult
    override fun getDownloadOnlyRequest(): GlideRequest<File> {
        return GlideRequest(File::class.java, this).apply(DOWNLOAD_ONLY_OPTIONS)
    }

    /**
     * @see GlideOptions.sizeMultiplier
     */
    @CheckResult
    override fun sizeMultiplier(
        @FloatRange(
            from = 0.0,
            to = 1.0
        ) value: Float
    ): GlideRequest<TranscodeType> {
        return super.sizeMultiplier(value) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.useUnlimitedSourceGeneratorsPool
     */
    @CheckResult
    override fun useUnlimitedSourceGeneratorsPool(flag: Boolean): GlideRequest<TranscodeType> {
        return super.useUnlimitedSourceGeneratorsPool(flag) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.useAnimationPool
     */
    @CheckResult
    override fun useAnimationPool(flag: Boolean): GlideRequest<TranscodeType> {
        return super.useAnimationPool(flag) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.onlyRetrieveFromCache
     */
    @CheckResult
    override fun onlyRetrieveFromCache(flag: Boolean): GlideRequest<TranscodeType> {
        return super.onlyRetrieveFromCache(flag) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.diskCacheStrategy
     */
    @CheckResult
    override fun diskCacheStrategy(strategy: DiskCacheStrategy): GlideRequest<TranscodeType> {
        return super.diskCacheStrategy(strategy) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.priority
     */
    @CheckResult
    override fun priority(priority: Priority): GlideRequest<TranscodeType> {
        return super.priority(priority) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.placeholder
     */
    @CheckResult
    override fun placeholder(drawable: Drawable?): GlideRequest<TranscodeType> {
        return super.placeholder(drawable) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.placeholder
     */
    @CheckResult
    override fun placeholder(@DrawableRes id: Int): GlideRequest<TranscodeType> {
        return super.placeholder(id) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.fallback
     */
    @CheckResult
    override fun fallback(drawable: Drawable?): GlideRequest<TranscodeType> {
        return super.fallback(drawable) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.fallback
     */
    @CheckResult
    override fun fallback(@DrawableRes id: Int): GlideRequest<TranscodeType> {
        return super.fallback(id) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.error
     */
    @CheckResult
    override fun error(drawable: Drawable?): GlideRequest<TranscodeType> {
        return super.error(drawable) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.error
     */
    @CheckResult
    override fun error(@DrawableRes id: Int): GlideRequest<TranscodeType> {
        return super.error(id) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.theme
     */
    @CheckResult
    override fun theme(theme: Theme?): GlideRequest<TranscodeType> {
        return super.theme(theme) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.skipMemoryCache
     */
    @CheckResult
    override fun skipMemoryCache(skip: Boolean): GlideRequest<TranscodeType> {
        return super.skipMemoryCache(skip) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.override
     */
    @CheckResult
    override fun override(width: Int, height: Int): GlideRequest<TranscodeType> {
        return super.override(width, height) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.override
     */
    @CheckResult
    override fun override(size: Int): GlideRequest<TranscodeType> {
        return super.override(size) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.signature
     */
    @CheckResult
    override fun signature(key: Key): GlideRequest<TranscodeType> {
        return super.signature(key) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.set
     */
    @CheckResult
    override fun <Y> set(option: Option<Y>, y: Y): GlideRequest<TranscodeType> {
        return super.set(option, y) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.decode
     */
    @CheckResult
    override fun decode(clazz: Class<*>): GlideRequest<TranscodeType> {
        return super.decode(clazz) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.encodeFormat
     */
    @CheckResult
    override fun encodeFormat(format: CompressFormat): GlideRequest<TranscodeType> {
        return super.encodeFormat(format) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.encodeQuality
     */
    @CheckResult
    override fun encodeQuality(
        @IntRange(
            from = 0,
            to = 100
        ) value: Int
    ): GlideRequest<TranscodeType> {
        return super.encodeQuality(value) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.frame
     */
    @CheckResult
    override fun frame(@IntRange(from = 0) value: Long): GlideRequest<TranscodeType> {
        return super.frame(value) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.format
     */
    @CheckResult
    override fun format(format: DecodeFormat): GlideRequest<TranscodeType> {
        return super.format(format) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.disallowHardwareConfig
     */
    @CheckResult
    override fun disallowHardwareConfig(): GlideRequest<TranscodeType> {
        return super.disallowHardwareConfig() as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.downsample
     */
    @CheckResult
    override fun downsample(strategy: DownsampleStrategy): GlideRequest<TranscodeType> {
        return super.downsample(strategy) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.timeout
     */
    @CheckResult
    override fun timeout(@IntRange(from = 0) value: Int): GlideRequest<TranscodeType> {
        return super.timeout(value) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.optionalCenterCrop
     */
    @CheckResult
    override fun optionalCenterCrop(): GlideRequest<TranscodeType> {
        return super.optionalCenterCrop() as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.centerCrop
     */
    @CheckResult
    override fun centerCrop(): GlideRequest<TranscodeType> {
        return super.centerCrop() as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.optionalFitCenter
     */
    @CheckResult
    override fun optionalFitCenter(): GlideRequest<TranscodeType> {
        return super.optionalFitCenter() as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.fitCenter
     */
    @CheckResult
    override fun fitCenter(): GlideRequest<TranscodeType> {
        return super.fitCenter() as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.optionalCenterInside
     */
    @CheckResult
    override fun optionalCenterInside(): GlideRequest<TranscodeType> {
        return super.optionalCenterInside() as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.centerInside
     */
    @CheckResult
    override fun centerInside(): GlideRequest<TranscodeType> {
        return super.centerInside() as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.optionalCircleCrop
     */
    @CheckResult
    override fun optionalCircleCrop(): GlideRequest<TranscodeType> {
        return super.optionalCircleCrop() as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.circleCrop
     */
    @CheckResult
    override fun circleCrop(): GlideRequest<TranscodeType> {
        return super.circleCrop() as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.transform
     */
    @CheckResult
    override fun transform(transformation: Transformation<Bitmap>): GlideRequest<TranscodeType> {
        return super.transform(transformation) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.transform
     */
    @CheckResult
    override fun transform(vararg transformations: Transformation<Bitmap>): GlideRequest<TranscodeType> {
        return super.transform(*transformations) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.transforms
     */
    @Deprecated("")
    @CheckResult
    override fun transforms(vararg transformations: Transformation<Bitmap>): GlideRequest<TranscodeType> {
        return super.transforms(*transformations) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.optionalTransform
     */
    @CheckResult
    override fun optionalTransform(transformation: Transformation<Bitmap>): GlideRequest<TranscodeType> {
        return super.optionalTransform(transformation) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.optionalTransform
     */
    @CheckResult
    override fun <Y> optionalTransform(
        clazz: Class<Y>,
        transformation: Transformation<Y>
    ): GlideRequest<TranscodeType> {
        return super.optionalTransform(clazz, transformation) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.transform
     */
    @CheckResult
    override fun <Y> transform(
        clazz: Class<Y>,
        transformation: Transformation<Y>
    ): GlideRequest<TranscodeType> {
        return super.transform(clazz, transformation) as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.dontTransform
     */
    @CheckResult
    override fun dontTransform(): GlideRequest<TranscodeType> {
        return super.dontTransform() as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.dontAnimate
     */
    @CheckResult
    override fun dontAnimate(): GlideRequest<TranscodeType> {
        return super.dontAnimate() as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.lock
     */
    override fun lock(): GlideRequest<TranscodeType> {
        return super.lock() as GlideRequest<TranscodeType>
    }

    /**
     * @see GlideOptions.autoClone
     */
    override fun autoClone(): GlideRequest<TranscodeType> {
        return super.autoClone() as GlideRequest<TranscodeType>
    }

    @CheckResult
    override fun apply(options: BaseRequestOptions<*>): GlideRequest<TranscodeType> {
        return super.apply(options) as GlideRequest<TranscodeType>
    }

    @CheckResult
    override fun transition(options: TransitionOptions<*, in TranscodeType>): GlideRequest<TranscodeType> {
        return super.transition(options) as GlideRequest<TranscodeType>
    }

    @CheckResult
    override fun listener(listener: RequestListener<TranscodeType>?): GlideRequest<TranscodeType> {
        return super.listener(listener) as GlideRequest<TranscodeType>
    }

    @CheckResult
    override fun addListener(listener: RequestListener<TranscodeType>?): GlideRequest<TranscodeType> {
        return super.addListener(listener) as GlideRequest<TranscodeType>
    }

    override fun error(builder: RequestBuilder<TranscodeType>?): GlideRequest<TranscodeType> {
        return super.error(builder) as GlideRequest<TranscodeType>
    }

//    @CheckResult
//    fun error(o: Any?): GlideRequest<TranscodeType> {
//        return super.error(o) as GlideRequest<TranscodeType>
//    }

    @CheckResult
    override fun thumbnail(builder: RequestBuilder<TranscodeType>?): GlideRequest<TranscodeType> {
        return super.thumbnail(builder) as GlideRequest<TranscodeType>
    }

    @CheckResult
    @SafeVarargs
    override fun thumbnail(vararg builders: RequestBuilder<TranscodeType>?): GlideRequest<TranscodeType> {
        return super.thumbnail(*builders) as GlideRequest<TranscodeType>
    }

//    @CheckResult
//    fun thumbnail(list: List<RequestBuilder<TranscodeType>?>?): GlideRequest<TranscodeType> {
//        return super.thumbnail(list) as GlideRequest<TranscodeType>
//    }

    @CheckResult
    override fun thumbnail(sizeMultiplier: Float): GlideRequest<TranscodeType> {
        return super.thumbnail(sizeMultiplier) as GlideRequest<TranscodeType>
    }

    @CheckResult
    override fun load(o: Any?): GlideRequest<TranscodeType> {
        return super.load(o) as GlideRequest<TranscodeType>
    }

    @CheckResult
    override fun load(bitmap: Bitmap?): GlideRequest<TranscodeType> {
        return super.load(bitmap) as GlideRequest<TranscodeType>
    }

    @CheckResult
    override fun load(drawable: Drawable?): GlideRequest<TranscodeType> {
        return super.load(drawable) as GlideRequest<TranscodeType>
    }

    @CheckResult
    override fun load(string: String?): GlideRequest<TranscodeType> {
        return super.load(string) as GlideRequest<TranscodeType>
    }

    @CheckResult
    override fun load(uri: Uri?): GlideRequest<TranscodeType> {
        return super.load(uri) as GlideRequest<TranscodeType>
    }

    @CheckResult
    override fun load(file: File?): GlideRequest<TranscodeType> {
        return super.load(file) as GlideRequest<TranscodeType>
    }

    @CheckResult
    override fun load(@RawRes @DrawableRes id: Int?): GlideRequest<TranscodeType> {
        return super.load(id) as GlideRequest<TranscodeType>
    }

    @Deprecated("")
    @CheckResult
    override fun load(url: URL?): GlideRequest<TranscodeType> {
        return super.load(url) as GlideRequest<TranscodeType>
    }

    @CheckResult
    override fun load(bytes: ByteArray?): GlideRequest<TranscodeType> {
        return super.load(bytes) as GlideRequest<TranscodeType>
    }

    @CheckResult
    override fun clone(): GlideRequest<TranscodeType> {
        return clone()
    }

    /**
     * @see Extension.test
     */
    @CheckResult
    fun test(): GlideRequest<TranscodeType> {
        return Extension.test(this) as GlideRequest<TranscodeType>
    }
}