package sidm.com.lab2week5;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.view.View.OnClickListener;

import static android.R.attr.button;
import static android.R.attr.layout_height;
import static android.R.attr.layout_width;

public class Mainmenu implements Scene//extends Activity implements OnClickListener
{
    // Declaration of Singleton
    public final static Mainmenu Instance = new Mainmenu();
    private float time = 0.5f;
    Buttons Play;
//    GameObject Play;
//    GameObject Quit;
    // This is to not allow anyone else to create another game
    private Mainmenu()
    {

    }


    @Override
    public void Init(SurfaceView _view)
    {
        EntityManager.Instance.Init(_view);
        MenuBackground.Create();

//        Play = GameObject.Create();
//        Play.Init(_view);
//        Play.SetName("Play");
//        Play.SetBitmap(_view,R.drawable.start );
//
//        Quit = GameObject.Create();
//        Quit.Init(_view);
//        Quit.SetName("Play");
//        Quit.SetBitmap(_view,R.drawable.back );

       // Play.SetPosition(new Vector2(width,height));
       // Play.SetPosition();
//        SampleEntity.Create();
    }

    @Override
    public void Update(float dt)
    {
        time -= dt;

        //Play.Update(dt);
//        if ()//tap on screen
//        {
//            SceneManager.Instance.SetNextState("SampleGame");
//            //change the scene
//        }
       // if(time <= 0.f)
        //{
           // SampleEntity.Create();
        //    time = 0.5f;
       // }
       // EntityManager.Instance.Update(dt);
    }

    @Override
    public void Render(Canvas _canvas)
    {
        float width = _canvas.getWidth()* 0.5f;//_view.getWidth() is 0  !!!
        float height = _canvas.getHeight()* 0.6f;

//        Play.SetPosition(new Vector2(width,height));
//        Quit.SetPosition(new Vector2(width,_canvas.getHeight()*0.8f));
        EntityManager.Instance.Render(_canvas);
    }

    @Override
    public void Exit()
    {
        // Clear the scene before going to the next

    }


}

