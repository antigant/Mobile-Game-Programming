package sidm.com.assignment1;

import android.view.SurfaceView;

import java.util.Random;

// A class to manage all the enemy being spawn
public class EnemyManager
{
    public final static EnemyManager Instance = new EnemyManager();

    private enum Stage
    {
        NONE,
        STAGE1,
        MAX,
    }

    private SurfaceView view = null;
    private Random rand = new Random();
    private int randNumer = 0;

    private int maxEnemies = 0;
    private int enemies = 0;
    private final int capEnemies = 15;

    private float time = 0;
    private final float fixTime = 7.5f;

    private Stage stage = Stage.NONE;

    // private constructor
    private EnemyManager() {}

    // Setter
    public void SetSurfaceView(SurfaceView _view) { view = _view; }
    // Set the total amount of enemy spawn every time
    public void SetMaxEnemies(final int _maxEnemies)
    {
        maxEnemies = _maxEnemies;
        if(maxEnemies > capEnemies)
            maxEnemies = capEnemies;
        else if(maxEnemies <= 0)
            maxEnemies = 1;
    }
    public void SetNextStage()
    {
        stage = Stage.values()[stage.ordinal() + 1];
        if(stage == Stage.MAX)
            stage = Stage.values()[stage.ordinal() - 1];
    }

    // Getter
    final public int GetMaxEnemies() { return maxEnemies; }

    public void Update()
    {
        time += Time.deltaTime;
        if(time > fixTime) // Start spawning enemy
        {
            time -= fixTime;
            SpawnEnemy();
        }
    }

    private void SpawnEnemy()
    {
        switch(stage)
        {
            case STAGE1:
                // Start spawning x amount of Space Mushroom(s)
                randNumer = maxEnemies;
                enemies = rand.nextInt(randNumer) + 1;
                for(int i = 0; i < enemies; ++i)
                {   // Start spawning Space Mushroom(s)
                    SpaceMushroom enemy = new SpaceMushroom();
                    enemy.Init(view);
                    EntityManager.Instance.AddEntity(enemy);
                }
                break;
        }
    }
}
