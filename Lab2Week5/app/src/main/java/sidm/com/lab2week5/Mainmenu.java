package sidm.com.lab2week5;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.view.View.OnClickListener;

import static android.R.attr.button;
import static android.R.attr.layout_width;

public class Mainmenu implements State//extends Activity implements OnClickListener
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

        SampleEntity.Create();
    }

    @Override
    public void Update(float dt)
    {
        time -= dt;


        if (true)//tap on screen
        {
            //change the scene
        }
       // if(time <= 0.f)
        //{
           // SampleEntity.Create();
        //    time = 0.5f;
       // }
        //EntityManager.Instance.Update(dt);
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

