package sidm.com.assignment1;

import android.view.Menu;
import android.view.SurfaceView;

public class RestartPage
{
    public final static RestartPage Instance = new RestartPage();

    SurfaceView view = null;

    // Need two buttons :- Restart and Menu
    RestartButton restartButton = new RestartButton();
    MenuButton menuButton = new MenuButton();

    // Private constructor
    private RestartPage() {}

    public void SetSurfaceView(SurfaceView _view) { view = _view; }

    public void Init()
    {
        restartButton.SetIsRender(false);
        restartButton.Init(view);
        EntityManager.Instance.AddEntity(restartButton);
        menuButton.SetIsRender(false);
        menuButton.Init(view);
        EntityManager.Instance.AddEntity(menuButton);
    }

    public void Update()
    {
        restartButton.Update();
        menuButton.Update();
    }

    public void RestartButtonClicked()
    {
        SampleGame.Instance.Reset(view);
        restartButton.SetIsRender(false);
        menuButton.SetIsRender(false);

        Player.Instance.Restart(view);
    }

    public void MenuButtonClicked()
    {

    }

    public void SpawnButtons()
    {
        restartButton.SetIsRender(true);
        menuButton.SetIsRender(true);
    }
}

