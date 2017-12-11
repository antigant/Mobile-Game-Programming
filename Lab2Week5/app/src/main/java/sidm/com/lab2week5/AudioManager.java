package sidm.com.lab2week5;

import android.media.MediaPlayer;
import android.view.SurfaceView;

import java.util.HashMap;

public class AudioManager
{
    public final static AudioManager Instance = new AudioManager();
    private SurfaceView view = null;
    private HashMap<Integer, MediaPlayer> audioMap = new HashMap<>();
    private boolean isPlaying = false;

    private AudioManager(){}

    public void Init(SurfaceView _view)
    {
        view = _view;
    }

    // 1) We do not want to have duplicate sound clips
    // 2) 1 effect 1 sound, only at one instance
    public void PlayAudio(int _id)
    {
        // Check if the audio is loaded or not
        if(audioMap.containsKey(_id))
        {
            // We got it!
            MediaPlayer curr = audioMap.get(_id);
            curr.reset();
            curr.start();
        }
        MediaPlayer newAudio = MediaPlayer.create(view.getContext(),_id);
        audioMap.put(_id,newAudio);
        newAudio.start(); // Just play the audio
    }

    public boolean IsPlaying()
    {
        return isPlaying;
    }
}
