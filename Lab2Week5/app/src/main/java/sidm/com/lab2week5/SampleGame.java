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
    private SurfaceView view = null;

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
        view = _view;

        GameObject go = new GameObject();
        go.SetIsActive(true);
        go.SetBitmap(view, R.drawable.ship2_1);
//        go.SetPosition(new Vector2(ranGen.nextFloat() * view.getWidth(), ranGen.nextFloat() * view.getHeight()));
//        go.SetDirection(new Vector2(ranGen.nextFloat() * 100.f - 50.f, ranGen.nextFloat() * 100.f - 50.f));
        EntityManager.Instance.AddEntity(go);
    }

    @Override
    public void Update(float dt)
    {
        time -= dt;

//        if(time <= 0.f)
//        {
//            time = 0.5f;
//        }
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