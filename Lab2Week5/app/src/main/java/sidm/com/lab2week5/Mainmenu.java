package sidm.com.lab2week5;

import android.graphics.Canvas;
import android.view.SurfaceView;

public class Mainmenu implements Scene//extends Activity implements OnClickListener
{
    // Declaration of Singleton
    public final static Mainmenu Instance = new Mainmenu();
    private float time = 0.5f;

    PlayButton a = new PlayButton();
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

        a.Create();
//        a.Init(_view);
//        EntityManager.Instance.AddEntity(a);
       // PlayButton.Init();
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
        EntityManager.Instance.Update(dt);
//
//        if (EntityManager.Instance.entityList.contai== false)
//        {
//            SceneManager.Instance.SetNextState("SampleGame");
//        }
       // if (a.IsActive()==false)
        //{

        //    a.SetIsClick(true);
        //}


    }

    @Override
    public void Render(Canvas _canvas)
    {
//        float width = _canvas.getWidth()* 0.5f;//_view.getWidth() is 0  !!!
//        float height = _canvas.getHeight()* 0.6f;

      //  Play.SetPosition(new Vector2(width,height));
//        Quit.SetPosition(new Vector2(width,_canvas.getHeight()*0.8f));
        //PlayButton.Render(_canvas);

        EntityManager.Instance.Render(_canvas);
    }

    @Override
    public void Exit()
    {
        // Clear the scene before going to the next

    }


}

