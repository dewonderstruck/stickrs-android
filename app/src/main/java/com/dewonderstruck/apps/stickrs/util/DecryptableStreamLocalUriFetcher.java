package com.dewonderstruck.apps.stickrs.util;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

import com.bumptech.glide.load.data.StreamLocalUriFetcher;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class DecryptableStreamLocalUriFetcher extends StreamLocalUriFetcher {

    private static final String TAG = DecryptableStreamLocalUriFetcher.class.getSimpleName();

    private Context context;

    DecryptableStreamLocalUriFetcher(Context context, Uri uri) {
        super(context.getContentResolver(), uri);
        this.context = context;
    }
}
