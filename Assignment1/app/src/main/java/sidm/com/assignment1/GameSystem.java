package sidm.com.assignment1;

import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.view.SurfaceView;

import java.util.Random;

public class GameSystem
{
    public final static GameSystem Instance = new GameSystem();
    public final static String SHARED_PREF_ID = "GameSaveFile"; // Game Save File ID

    private boolean isPaused = false;
    private boolean hasStarted = false;

    // Play time before switching stage
    private float time = 30f;
    private float fixTime = 30f;

    // -- For EnemyManager -- //
    int AddEnemy = 0;
    Random rand = new Random();
    int randNumber = 0;

    // This is our save system (using shared preferences for android
    SharedPreferences sharedPref = null;
    SharedPreferences.Editor editor = null;

    // This is to not allow anyone else to create another game
    private GameSystem() {}

    public void Update()
    {
        time += Time.deltaTime;
        if(time > fixTime) // Set next wave of enemies
        {
            time -= fixTime;

            AddEnemy = rand.nextInt(5);
            randNumber = rand.nextInt(2);
            if(randNumber == 0)
                AddEnemy *= -1;
            EnemyManager.Instance.SetMaxEnemies(EnemyManager.Instance.GetMaxEnemies() + AddEnemy);
            EnemyManager.Instance.SetNextStage();
        }
    }

    public void Init(SurfaceView _view)
    {
        // Get our save file
        sharedPref = GamePage.Instance.getSharedPreferences(SHARED_PREF_ID, 0);

        // Game specific stuff here! Eg. Add our game states here!
        SceneManager.Instance.AddState("SplashScreen",SplashScreen.Instance);
        SceneManager.Instance.AddState("MainMenu", Mainmenu.Instance);
        SceneManager.Instance.AddState("SampleGame", SampleGame.Instance);

        PowerUpManager.Instance.SetSurfaceView(_view);
        EnemyManager.Instance.SetSurfaceView(_view);
        PausePage.Instance.SetSurfaceView(_view);
    }

    public void Render(Canvas _canvas)
    {

    }

    // Getters
    final public boolean GetIsPaused()
    {
        return isPaused;
    }

    public int GetIntFromSave(String _key)
    {
        // Attempt to get using key, if fail provide default variable(0) based on our input
        return sharedPref.getInt(_key, 0);
    }

    final public boolean GetHasStarted() { return hasStarted; }

    // Setters
    public void SetIsPaused(final boolean _isPaused)
    {
        isPaused = _isPaused;
    }

    public void SetIntInSave(String _key, int _value)
    {
        // Safety check for editor, only allow saving if editor is present
        if(editor == null)
            return;

        // Save data here
        editor.putInt(_key, _value);
    }

    public void SetHasStarted(final boolean _hasStarted) { hasStarted = _hasStarted; }

    public void SaveEditBegin()
    {
        // Safety check, make sure no one else is doing an edit (eg. have an editor)
        if(editor != null)
            return;

        // Start the editing by providing editor
        editor = sharedPref.edit();
    }

    public void SaveEditEnd()
    {
        // Safety check, only allow if editor is available (eg. currently editing)
        if(editor == null)
            return;

        editor.commit();
        editor = null; // Clean up the editor so that the system can work
    }
}
