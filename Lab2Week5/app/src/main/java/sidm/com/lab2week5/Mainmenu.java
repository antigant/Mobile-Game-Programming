package sidm.com.lab2week5;

import android.graphics.Canvas;
import android.view.SurfaceView;

public class Mainmenu implements Scene//extends Activity implements OnClickListener
{
    // Declaration of Singleton
    public final static Mainmenu Instance = new Mainmenu();
    private float time = 0.5f;

    // This is to not allow anyone else to create another game
    private Mainmenu()
    {

    }

    @Override
    public void Init(SurfaceView _view)
    {
        EntityManager.Instance.Init(_view);
        MenuBackground.Create();

//        SampleEntity.Create();
    }

    @Override
    public void Update()
    {
        time -= Time.deltaTime;
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

    }


}

