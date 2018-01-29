package sidm.com.assignment1;

import android.graphics.Canvas;
import android.view.SurfaceView;


public class SplashScreen implements Scene
{
    // Declaration of Singleton
    public final static SplashScreen Instance = new SplashScreen();
    private float time = 5.0f;



    SplashBackground backGround = new SplashBackground();
    // This is to not allow anyone else to create another game
    private SplashScreen()
    {

    }


    @Override
    public String GetName() {
        return "Splash Screen";
    }

    @Override
    public void Init(SurfaceView _view)
    {
        EntityManager.Instance.Init(_view);
        backGround.Init(_view);
        EntityManager.Instance.AddEntity(backGround);
    }

    @Override
    public void Update()
    {
        time -= Time.deltaTime;
        if (time<= 0)
            SceneManager.Instance.SetNextState("MainMenu");
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
//        backGround.SetIsActive(false);

        EntityManager.Instance.ClearEntityManager();
    }

    @Override
    public void Reset() {

    }
}

