package sidm.com.assignment1;

import android.graphics.Canvas;
import android.text.method.Touch;
import android.view.Surface;
import android.view.SurfaceView;

import java.util.LinkedList;
import java.util.Random;
import java.util.Vector;

// Game instance (Put all game variables in here)
public class SampleGame implements Scene
{
    // Declaration of Singleton
    public final static SampleGame Instance = new SampleGame();
    private float time = 0.5f;

//    PlayButton playButton;
    Random ranGen = new Random();
    LinkedList<SampleBackground> backgroundList = new LinkedList<>();
    float backgroundSpeed = 80f;

    MovePlayerButton leftButton;
    MovePlayerButton rightButton;

    // This is to not allow anyone else to create another of this class
    private SampleGame()
    {

    }


    @Override
    public String GetName()
    {
        return "Sample Game";
    }

    @Override
    public void Init(SurfaceView _view)
    {
        EntityManager.Instance.Init(_view);
        for(int i = 0; i < 4; ++i)
        {
            SampleBackground background = new SampleBackground();
            EntityManager.Instance.AddEntity(background);

            background.SetPosition(new Vector2(background.GetPosition().x, -SampleBackground.CONSTANT * i + 500f));
            backgroundList.add(background);
        }

        leftButton = new MovePlayerButton();
        leftButton.Init(_view);
        leftButton.SetPosition(new Vector2(300, 1500.f));
        EntityManager.Instance.AddEntity(leftButton);
        rightButton = new MovePlayerButton();
        rightButton.Init(_view);
        rightButton.SetPosition(new Vector2(800f, 1500.f));
        EntityManager.Instance.AddEntity(rightButton);
        Player.Instance.SetPosition(new Vector2(580f, 1500f));

        GameSystem.Instance.SetHasStarted(true);
    }

    @Override
    public void Update()
    {
        if(GameSystem.Instance.GetIsPaused())
            return;
        if(Player.Instance.GetIsDead())
            return; // TODO: For now just return

        EntityManager.Instance.Update();
        // Update the background to make it loop
        for(int i = 0; i < backgroundList.size(); ++i)
            backgroundList.get(i).SetPosition(new Vector2(backgroundList.get(i).GetPosition().x, backgroundList.get(i).GetPosition().y += backgroundSpeed * Time.deltaTime));
        // To update the player's position
        if(leftButton.GetIsClick())
            leftButton.SetDirection(-1);
        if(rightButton.GetIsClick())
            rightButton.SetDirection(1);
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
        for(int i = 0; i < backgroundList.size(); ++i)
        {
            backgroundList.get(i).SetIsActive(false);
            backgroundList.remove(i);
        }

        if(GameSystem.Instance.GetHasStarted())
        {
            Player.Instance.SetIsInit(false);
        }

        // Do save file here

        // Possible solution 1:
        // Clean up all our entities
        // EntityManager.Instance.Destory(SamplePauseButton)
        // .. Do the same for all others
        // Step 1 : Write all the delete and clean up functions for all other managers
        // Step 2 : Call them here~
        // Step 3 :

    }

    @Override
    public void Reset() {
        // Potential Solution 2 :
        // Add reset functions or use the SceneManager to update all entities
        // Get all our objects to reset

    }
}