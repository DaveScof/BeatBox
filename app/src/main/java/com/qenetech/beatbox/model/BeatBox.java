package com.qenetech.beatbox.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by davescof on 3/27/17.
 */

public class BeatBox {
    public static final String TAG = "BeatBox";
    public static final String SOUNDS_FOLDER = "sample_sounds";
    public static final int MAX_SOUNDS = 5;

    private AssetManager mAssets;
    private List<Sound> mSounds = new ArrayList<>();
    private SoundPool mSoundPool;

    public BeatBox(Context context){
        mAssets = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0);
        loadSounds();
    }

    private void loadSounds (){
        String[] soundNames = null;
        try {
            soundNames = mAssets.list(SOUNDS_FOLDER);
            Log.i(TAG, soundNames.toString());
            for (String soundName :
                    soundNames) {
                Sound sound = new Sound(SOUNDS_FOLDER + "/" + soundName);
                load(sound);
                mSounds.add(sound);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    private void load (Sound sound) throws IOException{
        AssetFileDescriptor afd = mAssets.openFd(sound.getAssetPath());
        int soundID = mSoundPool.load(afd,1);
        sound.setSoundID(soundID);
    }

    public void play (Sound sound){
        Integer soundId = sound.getSoundID();
        if (soundId == null)
            return;

        mSoundPool.play(soundId, 1f , 1f , 1 , 0, 1f);
    }

    public List<Sound> getSounds() {
        return mSounds;
    }

    public void release (){
        mSoundPool.release();
    }
}
