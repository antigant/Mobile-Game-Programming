package sidm.com.lab2week5;

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
    private boolean clicks;

    PlayButton playButton;
    SampleBackground background;
    Random ranGen = new Random();

    // This is to not allow anyone else to create another of this class
    private SampleGame()
    {

    }


    @Override
    public void Init(SurfaceView _view)
    {
        EntityManager.Instance.Init(_view);
        background = new SampleBackground();
        EntityManager.Instance.AddEntity(background);
        playButton = new PlayButton();
        EntityManager.Instance.AddEntity(playButton);
    }

    @Override
    public void Update()
    {
        EntityManager.Instance.Update();
        if(TouchManager.Instance.IsDown())
            clicks = true;

         if(Collision.CheckPointAABB(TouchManager.Instance.GetTouchPos(), playButton))
        {
            if(clicks)
            {
                SceneManager.Instance.SetNextState("MainMenu");
                clicks = false;
            }
            //playButton.SetIsClick(true);
        }
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
        playButton.SetIsActive(false);
        background.SetIsActive(false);

    }
}