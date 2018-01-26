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
    float backgroundSpeed = 50f;

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

        Player.Instance.SetPosition(new Vector2(580f, 1500f));
    }

    @Override
    public void Update()
    {
        EntityManager.Instance.Update();
        for(int i = 0; i < backgroundList.size(); ++i)
            backgroundList.get(i).SetPosition(new Vector2(backgroundList.get(i).GetPosition().x, backgroundList.get(i).GetPosition().y += backgroundSpeed * Time.deltaTime));
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