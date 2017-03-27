package com.qenetech.beatbox.model;

/**
 * Created by davescof on 3/27/17.
 */

public class Sound {
    private String mAssetPath;
    private String mName;

    public Sound (String assetPath){
        mAssetPath = assetPath;
        String[] components = assetPath.split("/");
        String fileName = components[components.length - 1 ];

        mName = fileName.replace(".wav", "");
    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public String getName() {
        return mName;
    }
}
