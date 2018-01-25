package sidm.com.assignment1;

import android.graphics.Canvas;
import android.text.method.Touch;
import android.view.Surface;
import android.view.SurfaceView;

import java.util.Random;

// Game instance (Put all game variables in here)
public class SampleGame implements Scene
{
    // Declaration of Singleton
    public final static SampleGame Instance = new SampleGame();
    private float time = 0.5f;

//    PlayButton playButton;
    SampleBackground background;
    Random ranGen = new Random();

    // This is to not allow anyone else to create another of this class
    private SampleGame()
    {

    }


    @Override
    public String GetName()
    {
        return "Sample Game";
    }

    @Override
    public void Init(SurfaceView _view)
    {
        EntityManager.Instance.Init(_view);
        background = new SampleBackground();
        EntityManager.Instance.AddEntity(background);

        Player.Instance.SetPosition(new Vector2(580f, 1500f));
    }

    @Override
    public void Update()
    {
        EntityManager.Instance.Update();
    }

    @Override
    public void Render(Canvas _canvas)
    {
        EntityManager.Instance.Render(_canvas);
    }

    @Override
    public void Exit()
    {
        // Clear the scene before going to the next
        time = 0.0f;
//        playButton.SetIsActive(false);
        background.SetIsActive(false);

        // Do save file here

        // Possible solution 1:
        // Clean up all our entities
        // EntityManager.Instance.Destory(SamplePauseButton)
        // .. Do the same for all others
        // Step 1 : Write all the delete and clean up functions for all other managers
        // Step 2 : Call them here~
        // Step 3 :

    }

    @Override
    public void Reset() {
        // Potential Solution 2 :
        // Add reset functions or use the SceneManager to update all entities
        // Get all our objects to reset

    }
}