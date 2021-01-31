package com.dewonderstruck.apps.stickrs.util


import java.lang.IllegalArgumentException

/**
 * Generic holder for an object that either holds a result of a desired type,
 * or some exception.
 */

data class DataOrException<out T, out E: Exception?>(val data: T?, val exception: E?) {
    init {
        if (data == null && exception == null) {
            throw IllegalArgumentException("Both data and exception can't be null")
        }
        else if (data != null && exception != null) {
            throw IllegalArgumentException("Both data and exception can't be non-null")
        }
    }
}