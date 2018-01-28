package sidm.com.assignment1;

import android.graphics.Canvas;
import android.view.SurfaceView;

import java.util.LinkedList;

public abstract class Weapon
{
//    protected LinkedList<Bullet> bulletList;
    // After t seconds weapon go back to default
    protected float lifeTime = 0;
    protected float MAX_TIME;
    protected float bulletSpawnRate = 0;
    protected float fixBulletSpawnRate;

    protected SurfaceView view = null;

    public void Init(SurfaceView _view)
    {
        view = _view;

        MAX_TIME = -100f;
        fixBulletSpawnRate = -100f;
    }

    public void Update()
    {
        lifeTime += Time.deltaTime;
        if(lifeTime > MAX_TIME)
            return;
    }

    // Setter
    public void SetLifeTime(final float _lifeTime) { lifeTime = _lifeTime; }
    public void SetMaxTime(final float _MAX_TIME) { MAX_TIME = _MAX_TIME; }
    public void SetFixBulletSpawnRate(final float _fixBulletSpawnRate) { fixBulletSpawnRate = _fixBulletSpawnRate; }

    // Getter
    final public float GetLifeTime() { return lifeTime; }
    final public float GetMaxTime() { return MAX_TIME; }
    final public float GetFixBulletSpawnRate() { return fixBulletSpawnRate; }

    // -- //
    public void Reset() { }
}

