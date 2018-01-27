package sidm.com.assignment1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.SurfaceView;

import java.util.LinkedList;

public class DefaultWeapon extends Weapon
{
    LinkedList<Bullet> bulletList = new LinkedList<>();
    Matrix transform = new Matrix();

    public void Init(SurfaceView _view)
    {
        view = _view;

        MAX_TIME = -100f;
        fixBulletSpawnRate = 3f;
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
            bulletList.add(bullet);
        }

        for(int i = 0; i < bulletList.size(); ++i)
        {
            bulletList.get(i).Update();
            if(!bulletList.get(i).IsActive())
                bulletList.remove(i);
        }
    }

    public void Render(Canvas _canvas)
    {
        for(int i = 0; i < bulletList.size(); ++i)
        {
            transform.setScale(bulletList.get(i).GetScale().x, bulletList.get(i).GetScale().y);
            transform.postTranslate(bulletList.get(i).GetPosition().x, bulletList.get(i).GetPosition().y);
            _canvas.drawBitmap(bulletList.get(i).bmp, transform, null);
        }
    }

    @Override
    public void Reset()
    {
        fixBulletSpawnRate = 3f;
        PowerUpManager.Instance.SetPoweredUp(false);
    }
}
