package sidm.com.assignment1;

import android.graphics.Canvas;
import android.view.SurfaceView;

public class PausePage
{
    public static final PausePage Instance = new PausePage();

    private SurfaceView view = null;

    // I will need 3 buttons - Pause button, resume button and menu button
    private PauseButton pauseButton = new PauseButton();
    private ResumeButton resumeButton = new ResumeButton();
    private MenuButton menuButton = new MenuButton();

    // Private constructor
    private PausePage(){}

    // Setter
    public void SetSurfaceView(final SurfaceView _view) { view = _view; }

    public void Init()
    {
        pauseButton.Init(view);
        EntityManager.Instance.AddEntity(pauseButton);

        // Don't have to render if it's not paused
        resumeButton.SetIsRender(false);
        resumeButton.Init(view);
        EntityManager.Instance.AddEntity(resumeButton);
        menuButton.SetIsRender(false);
        menuButton.Init(view);
        EntityManager.Instance.AddEntity(menuButton);
    }

    public void Update()
    {
        resumeButton.Update();
        menuButton.Update();
    }

    public void PauseButtonClicked()
    {
        pauseButton.SetIsRender(false);
        resumeButton.SetIsRender(true);
        menuButton.SetIsRender(true);
    }

    public void ResumeButtonClicked()
    {
        pauseButton.SetIsRender(true);
        resumeButton.SetIsRender(false);
        menuButton.SetIsRender(false);
    }

    public void MenuButtonClicked()
    {
        GameSystem.Instance.SetIsPaused(false);
        pauseButton.SetIsRender(true);
    }
}

