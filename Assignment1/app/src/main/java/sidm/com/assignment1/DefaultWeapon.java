package sidm.com.assignment1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.SurfaceView;

import java.util.LinkedList;

public class DefaultWeapon extends Weapon
{
    Matrix transform = new Matrix();

    private float a = 3f;

    public void Init(SurfaceView _view)
    {
        view = _view;

        MAX_TIME = -100f;
        fixBulletSpawnRate = a;
    }

    public void Update()
    {   // Default weapon should never die
//        lifeTime += Time.deltaTime;
//        if(lifeTime > MAX_TIME)
//            return;
        if(!GameSystem.Instance.GetHasStarted()) // If game have not started (not in game page)
            return;

        bulletSpawnRate += Time.deltaTime;
        if(bulletSpawnRate > fixBulletSpawnRate) // Spawn bullets
        {
            bulletSpawnRate -= fixBulletSpawnRate;
            // Start spawning bullets and add it into the list
            Bullet bullet = new Bullet();
            bullet.Init(view);
            EntityManager.Instance.AddEntity(bullet);
        }
    }

    @Override
    public void Reset()
    {
        fixBulletSpawnRate = a;
        PowerUpManager.Instance.SetPoweredUp(false);
    }
}
