package com.bumptech.glide.test

import android.content.res.Resources.Theme
import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.graphics.drawable.Drawable
import androidx.annotation.CheckResult
import androidx.annotation.DrawableRes
import androidx.annotation.FloatRange
import androidx.annotation.IntRange
import com.bumptech.glide.Priority
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.Key
import com.bumptech.glide.load.Option
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
import com.bumptech.glide.request.BaseRequestOptions
import com.bumptech.glide.request.RequestOptions

/**
 * Automatically generated from [com.bumptech.glide.annotation.GlideExtension] annotated classes.
 *
 * @see RequestOptions
 */
class GlideOptions : RequestOptions(), Cloneable {
    @CheckResult
    override fun sizeMultiplier(@FloatRange(from = 0.0, to = 1.0) value: Float): GlideOptions {
        return super.sizeMultiplier(value) as GlideOptions
    }

    @CheckResult
    override fun useUnlimitedSourceGeneratorsPool(flag: Boolean): GlideOptions {
        return super.useUnlimitedSourceGeneratorsPool(flag) as GlideOptions
    }

    @CheckResult
    override fun useAnimationPool(flag: Boolean): GlideOptions {
        return super.useAnimationPool(flag) as GlideOptions
    }

    @CheckResult
    override fun onlyRetrieveFromCache(flag: Boolean): GlideOptions {
        return super.onlyRetrieveFromCache(flag) as GlideOptions
    }

    @CheckResult
    override fun diskCacheStrategy(strategy: DiskCacheStrategy): GlideOptions {
        return super.diskCacheStrategy(strategy) as GlideOptions
    }

    @CheckResult
    override fun priority(priority: Priority): GlideOptions {
        return super.priority(priority) as GlideOptions
    }

    @CheckResult
    override fun placeholder(drawable: Drawable?): GlideOptions {
        return super.placeholder(drawable) as GlideOptions
    }

    @CheckResult
    override fun placeholder(@DrawableRes id: Int): GlideOptions {
        return super.placeholder(id) as GlideOptions
    }

    @CheckResult
    override fun fallback(drawable: Drawable?): GlideOptions {
        return super.fallback(drawable) as GlideOptions
    }

    @CheckResult
    override fun fallback(@DrawableRes id: Int): GlideOptions {
        return super.fallback(id) as GlideOptions
    }

    @CheckResult
    override fun error(drawable: Drawable?): GlideOptions {
        return super.error(drawable) as GlideOptions
    }

    @CheckResult
    override fun error(@DrawableRes id: Int): GlideOptions {
        return super.error(id) as GlideOptions
    }

    @CheckResult
    override fun theme(theme: Theme?): GlideOptions {
        return super.theme(theme) as GlideOptions
    }

    @CheckResult
    override fun skipMemoryCache(skip: Boolean): GlideOptions {
        return super.skipMemoryCache(skip) as GlideOptions
    }

    @CheckResult
    override fun override(width: Int, height: Int): GlideOptions {
        return super.override(width, height) as GlideOptions
    }

    @CheckResult
    override fun override(size: Int): GlideOptions {
        return super.override(size) as GlideOptions
    }

    @CheckResult
    override fun signature(key: Key): GlideOptions {
        return super.signature(key) as GlideOptions
    }

    @CheckResult
    override fun clone(): GlideOptions {
        return clone()
    }

    @CheckResult
    override fun <Y> set(option: Option<Y>, y: Y): GlideOptions {
        return super.set(option, y) as GlideOptions
    }

    @CheckResult
    override fun decode(clazz: Class<*>): GlideOptions {
        return super.decode(clazz) as GlideOptions
    }

    @CheckResult
    override fun encodeFormat(format: CompressFormat): GlideOptions {
        return super.encodeFormat(format) as GlideOptions
    }

    @CheckResult
    override fun encodeQuality(@IntRange(from = 0, to = 100) value: Int): GlideOptions {
        return super.encodeQuality(value) as GlideOptions
    }

    @CheckResult
    override fun frame(@IntRange(from = 0) value: Long): GlideOptions {
        return super.frame(value) as GlideOptions
    }

    @CheckResult
    override fun format(format: DecodeFormat): GlideOptions {
        return super.format(format) as GlideOptions
    }

    @CheckResult
    override fun disallowHardwareConfig(): GlideOptions {
        return super.disallowHardwareConfig() as GlideOptions
    }

    @CheckResult
    override fun downsample(strategy: DownsampleStrategy): GlideOptions {
        return super.downsample(strategy) as GlideOptions
    }

    @CheckResult
    override fun timeout(@IntRange(from = 0) value: Int): GlideOptions {
        return super.timeout(value) as GlideOptions
    }

    @CheckResult
    override fun optionalCenterCrop(): GlideOptions {
        return super.optionalCenterCrop() as GlideOptions
    }

    @CheckResult
    override fun centerCrop(): GlideOptions {
        return super.centerCrop() as GlideOptions
    }

    @CheckResult
    override fun optionalFitCenter(): GlideOptions {
        return super.optionalFitCenter() as GlideOptions
    }

    @CheckResult
    override fun fitCenter(): GlideOptions {
        return super.fitCenter() as GlideOptions
    }

    @CheckResult
    override fun optionalCenterInside(): GlideOptions {
        return super.optionalCenterInside() as GlideOptions
    }

    @CheckResult
    override fun centerInside(): GlideOptions {
        return super.centerInside() as GlideOptions
    }

    @CheckResult
    override fun optionalCircleCrop(): GlideOptions {
        return super.optionalCircleCrop() as GlideOptions
    }

    @CheckResult
    override fun circleCrop(): GlideOptions {
        return super.circleCrop() as GlideOptions
    }

    @CheckResult
    override fun transform(transformation: Transformation<Bitmap>): GlideOptions {
        return super.transform(transformation) as GlideOptions
    }

    @SafeVarargs
    @CheckResult
    override fun transform(vararg transformations: Transformation<Bitmap>): GlideOptions {
        return super.transform(*transformations) as GlideOptions
    }

    @SafeVarargs
    @Deprecated("")
    @CheckResult
    override fun transforms(vararg transformations: Transformation<Bitmap>): GlideOptions {
        return super.transforms(*transformations) as GlideOptions
    }

    @CheckResult
    override fun optionalTransform(transformation: Transformation<Bitmap>): GlideOptions {
        return super.optionalTransform(transformation) as GlideOptions
    }

    @CheckResult
    override fun <Y> optionalTransform(
        clazz: Class<Y>,
        transformation: Transformation<Y>
    ): GlideOptions {
        return super.optionalTransform(clazz, transformation) as GlideOptions
    }

    @CheckResult
    override fun <Y> transform(
        clazz: Class<Y>,
        transformation: Transformation<Y>
    ): GlideOptions {
        return super.transform(clazz, transformation) as GlideOptions
    }

    @CheckResult
    override fun dontTransform(): GlideOptions {
        return super.dontTransform() as GlideOptions
    }

    @CheckResult
    override fun dontAnimate(): GlideOptions {
        return super.dontAnimate() as GlideOptions
    }

    @CheckResult
    override fun apply(options: BaseRequestOptions<*>): GlideOptions {
        return super.apply(options) as GlideOptions
    }

    override fun lock(): GlideOptions {
        return super.lock() as GlideOptions
    }

    override fun autoClone(): GlideOptions {
        return super.autoClone() as GlideOptions
    }

    companion object {
        private var fitCenterTransform0: GlideOptions? = null
        private var centerInsideTransform1: GlideOptions? = null
        private var centerCropTransform2: GlideOptions? = null
        private var circleCropTransform3: GlideOptions? = null
        private var noTransformation4: GlideOptions? = null
        private var noAnimation5: GlideOptions? = null

        /**
         * @see RequestOptions.sizeMultiplierOf
         */
        @CheckResult
        fun sizeMultiplierOf(@FloatRange(from = 0.0, to = 1.0) value: Float): GlideOptions {
            return GlideOptions().sizeMultiplier(value)
        }

        /**
         * @see RequestOptions.diskCacheStrategyOf
         */
        @CheckResult
        fun diskCacheStrategyOf(strategy: DiskCacheStrategy): GlideOptions {
            return GlideOptions().diskCacheStrategy(strategy)
        }

        /**
         * @see RequestOptions.priorityOf
         */
        @CheckResult
        fun priorityOf(priority: Priority): GlideOptions {
            return GlideOptions().priority(priority)
        }

        /**
         * @see RequestOptions.placeholderOf
         */
        @CheckResult
        fun placeholderOf(drawable: Drawable?): GlideOptions {
            return GlideOptions().placeholder(drawable)
        }

        /**
         * @see RequestOptions.placeholderOf
         */
        @CheckResult
        fun placeholderOf(@DrawableRes id: Int): GlideOptions {
            return GlideOptions().placeholder(id)
        }

        /**
         * @see RequestOptions.errorOf
         */
        @CheckResult
        fun errorOf(drawable: Drawable?): GlideOptions {
            return GlideOptions().error(drawable)
        }

        /**
         * @see RequestOptions.errorOf
         */
        @CheckResult
        fun errorOf(@DrawableRes id: Int): GlideOptions {
            return GlideOptions().error(id)
        }

        /**
         * @see RequestOptions.skipMemoryCacheOf
         */
        @CheckResult
        fun skipMemoryCacheOf(skipMemoryCache: Boolean): GlideOptions {
            return GlideOptions().skipMemoryCache(skipMemoryCache)
        }

        /**
         * @see RequestOptions.overrideOf
         */
        @CheckResult
        fun overrideOf(width: Int, height: Int): GlideOptions {
            return GlideOptions().override(width, height)
        }

        /**
         * @see RequestOptions.overrideOf
         */
        @CheckResult
        fun overrideOf(size: Int): GlideOptions {
            return GlideOptions().override(size)
        }

        /**
         * @see RequestOptions.signatureOf
         */
        @CheckResult
        fun signatureOf(key: Key): GlideOptions {
            return GlideOptions().signature(key)
        }

        /**
         * @see RequestOptions.fitCenterTransform
         */
        @CheckResult
        fun fitCenterTransform(): GlideOptions {
            if (fitCenterTransform0 == null) {
                fitCenterTransform0 = GlideOptions().fitCenter().autoClone()
            }
            return fitCenterTransform0!!
        }

        /**
         * @see RequestOptions.centerInsideTransform
         */
        @CheckResult
        fun centerInsideTransform(): GlideOptions {
            if (centerInsideTransform1 == null) {
                centerInsideTransform1 = GlideOptions().centerInside().autoClone()
            }
            return centerInsideTransform1!!
        }

        /**
         * @see RequestOptions.centerCropTransform
         */
        @CheckResult
        fun centerCropTransform(): GlideOptions {
            if (centerCropTransform2 == null) {
                centerCropTransform2 = GlideOptions().centerCrop().autoClone()
            }
            return centerCropTransform2!!
        }

        /**
         * @see RequestOptions.circleCropTransform
         */
        @CheckResult
        fun circleCropTransform(): GlideOptions {
            if (circleCropTransform3 == null) {
                circleCropTransform3 = GlideOptions().circleCrop().autoClone()
            }
            return circleCropTransform3!!
        }

        /**
         * @see RequestOptions.bitmapTransform
         */
        @CheckResult
        fun bitmapTransform(transformation: Transformation<Bitmap>): GlideOptions {
            return GlideOptions().transform(transformation)
        }

        /**
         * @see RequestOptions.noTransformation
         */
        @CheckResult
        fun noTransformation(): GlideOptions {
            if (noTransformation4 == null) {
                noTransformation4 = GlideOptions().dontTransform().autoClone()
            }
            return noTransformation4!!
        }

        /**
         * @see RequestOptions.option
         */
        @CheckResult
        fun <T> option(option: Option<T>, t: T): GlideOptions {
            return GlideOptions().set(option, t)
        }

        /**
         * @see RequestOptions.decodeTypeOf
         */
        @CheckResult
        fun decodeTypeOf(clazz: Class<*>): GlideOptions {
            return GlideOptions().decode(clazz)
        }

        /**
         * @see RequestOptions.formatOf
         */
        @CheckResult
        fun formatOf(format: DecodeFormat): GlideOptions {
            return GlideOptions().format(format)
        }

        /**
         * @see RequestOptions.frameOf
         */
        @CheckResult
        fun frameOf(@IntRange(from = 0) value: Long): GlideOptions {
            return GlideOptions().frame(value)
        }

        /**
         * @see RequestOptions.downsampleOf
         */
        @CheckResult
        fun downsampleOf(strategy: DownsampleStrategy): GlideOptions {
            return GlideOptions().downsample(strategy)
        }

        /**
         * @see RequestOptions.timeoutOf
         */
        @CheckResult
        fun timeoutOf(@IntRange(from = 0) value: Int): GlideOptions {
            return GlideOptions().timeout(value)
        }

        /**
         * @see RequestOptions.encodeQualityOf
         */
        @CheckResult
        fun encodeQualityOf(@IntRange(from = 0, to = 100) value: Int): GlideOptions {
            return GlideOptions().encodeQuality(value)
        }

        /**
         * @see RequestOptions.encodeFormatOf
         */
        @CheckResult
        fun encodeFormatOf(format: CompressFormat): GlideOptions {
            return GlideOptions().encodeFormat(format)
        }

        /**
         * @see RequestOptions.noAnimation
         */
        @CheckResult
        fun noAnimation(): GlideOptions {
            if (noAnimation5 == null) {
                noAnimation5 = GlideOptions().dontAnimate().autoClone()
            }
            return noAnimation5!!
        }
    }
}