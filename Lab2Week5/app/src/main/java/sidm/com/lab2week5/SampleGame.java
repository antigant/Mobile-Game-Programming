package sidm.com.lab2week5;

import android.graphics.Canvas;
import android.view.SurfaceView;

// Game instance (Put all game variables in here)
public class SampleGame implements State
{
    // Declaration of Singleton
    public final static SampleGame Instance = new SampleGame();
    private float time = 0.5f;

    // This is to not allow anyone else to create another game
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
            SampleEntity.Create();
            time = 0.5f;
        }
        EntityManager.Instance.Update(dt);
    }

    @Override
    public void Render(Canvas _canvas)
    {
        EntityManager.Instance.Render(_canvas);
    }
}

