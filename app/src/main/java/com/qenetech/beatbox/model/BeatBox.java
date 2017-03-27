package com.qenetech.beatbox.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;

/**
 * Created by davescof on 3/27/17.
 */

public class BeatBox {
    public static final String TAG = "BeatBox";
    public static final String SOUNDS_FOLDER = "sample_sounds";

    private AssetManager mAssets;

    public BeatBox(Context context){
        mAssets = context.getAssets();
        loadSounds();
    }

    private void loadSounds (){
        try {
            String[] sounds = mAssets.list(SOUNDS_FOLDER);
            Log.i(TAG, "Found " + sounds.length + " sounds." );
        } catch (IOException e) {
            Log.i(TAG, "Could not list assets: ", e);
            return;
        }
    }
}
