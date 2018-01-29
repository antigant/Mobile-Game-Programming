package sidm.com.assignment1;

import android.graphics.Canvas;
import android.provider.MediaStore;
import android.text.method.Touch;
import android.view.Menu;
import android.view.SurfaceView;

public class Mainmenu implements Scene//extends Activity implements OnClickListener
{
    // Declaration of Singleton
    public final static Mainmenu Instance = new Mainmenu();
    private SurfaceView view;
    private float time = 0.5f;
    PlayButton playButton;
    MenuBackground backGround;
    MenuShip ship;

    boolean a;

//    GameObject Play;
//    GameObject Quit;
    // This is to not allow anyone else to create another game
    private Mainmenu()
    {

    }

    @Override
    public String GetName()
    {
        return "Main Menu";
    }

    @Override
    public void Init(SurfaceView _view)
    {
        view = _view;
        a = true;

        EntityManager.Instance.Init(_view);
        backGround = new MenuBackground();
        EntityManager.Instance.AddEntity(backGround);
        playButton = new PlayButton();
        EntityManager.Instance.AddEntity(playButton);
        // Static ship for show on main menu screen
        ship = new MenuShip();
        EntityManager.Instance.AddEntity(ship);

        if(GameSystem.Instance.GetHasStarted())
            Player.Instance.Restart(_view);

        AudioManager.Instance.PlayBackgroundAudio(R.raw.henesys);

        // Restart or anything
        GameSystem.Instance.SetHasStarted(false);
    }

    @Override
    public void Update()
    {
        EntityManager.Instance.Update();

        if(playButton.GetPlayClicked() && a)
        {
            ship.SetIsActive(false);
            backGround.SetBitmap(R.drawable.background1);
            Player.Instance.Init(view);
            Player.Instance.SetPosition(new Vector2(580f, 1550.f));
            EntityManager.Instance.AddEntity(Player.Instance);

            a = false;
        }

        if(!a)
        {
            Player.Instance.SetPosition(new Vector2(Player.Instance.GetPosition().x, Player.Instance.GetPosition().y -= Player.Instance.GetMoveSpeed() * Time.deltaTime));
            if(Player.Instance.GetPosition().y <= -110f)
                SceneManager.Instance.SetNextState("SampleGame");
        }
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
//        playButton.SetIsActive(false);
//        backGround.SetIsActive(false);

        EntityManager.Instance.ClearEntityManager();
        AudioManager.Instance.StopAudio(R.raw.henesys);
    }

    @Override
    public void Reset() {

    }
}

