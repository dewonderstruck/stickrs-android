package com.dewonderstruck.apps.stickrs.util

import com.bumptech.glide.load.Key
import java.nio.ByteBuffer
import java.security.MessageDigest
import java.util.*


/**
 * Used as a model to be given to Glide for a sticker that isn't present locally.
 */
class StickerRemoteUri(val packId: String, val packKey: String, val stickerId: Int) :
    Key {

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {
        messageDigest.update(packId.toByteArray())
        messageDigest.update(packKey.toByteArray())
        messageDigest.update(ByteBuffer.allocate(4).putInt(stickerId).array())
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as StickerRemoteUri
        return stickerId == that.stickerId &&
                packId == that.packId &&
                packKey == that.packKey
    }

    override fun hashCode(): Int {
        return Objects.hash(packId, packKey, stickerId)
    }
}
