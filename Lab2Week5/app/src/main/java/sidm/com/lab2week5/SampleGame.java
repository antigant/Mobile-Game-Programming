package sidm.com.lab2week5;

import android.graphics.Canvas;
import android.view.Surface;
import android.view.SurfaceView;

import java.util.Random;

// Game instance (Put all game variables in here)
public class SampleGame implements Scene
{
    // Declaration of Singleton
    public final static SampleGame Instance = new SampleGame();
    private float time = 0.5f;

    Random ranGen = new Random();

    // This is to not allow anyone else to create another of this class
    private SampleGame()
    {

    }


    @Override
    public void Init(SurfaceView _view)
    {
        EntityManager.Instance.Init(_view);
        SampleBackground.Create();

    }

    @Override
    public void Update(float dt)
    {

        time -= dt;

        if(time <= 0.f)
        {


            //GameObject.Create();
            time = 1.5f;
        }
        EntityManager.Instance.Update(dt);
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
    }
}