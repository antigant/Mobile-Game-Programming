package sidm.com.assignment1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.SurfaceView;

import java.util.Random;

public class SpaceMushroom extends Enemy
{
    Matrix transform = new Matrix();
    Random rand = new Random();

    @Override
    public void Init(SurfaceView _view)
    {
        active = true;
        SetBitmap(_view, R.drawable.space_mushroom );
        moveSpeed = 85f;
        health.SetMaxHealth(10);
        health.Init();

        pos.x = rand.nextInt(600) + 100f;
        pos.y = -10f;

        SetScore(1);
        SetDamage(5);

        SetRadius(bmp.getHeight() * 0.5f);

        isInit = true;
    }

    @Override
    public void Update()
    {
        if(health.GetHealth() <= 0f)
        {
            SetIsActive(false); // dead
            Player.Instance.AddScore(GetScore());
            return;
        }

        maxAABB.Set(pos.x + bmp.getWidth() * 0.5f, pos.y + bmp.getHeight() * 0.5f);
        minAABB.Set(pos.x - bmp.getWidth() * 0.5f, pos.y - bmp.getHeight() * 0.5f);
        pos.Set(pos.x, pos.y += moveSpeed * Time.deltaTime);
    }

    @Override
    public void Render(Canvas _canvas)
    {
        transform.setScale(scale.x, scale.y);
        transform.postTranslate(pos.x, pos.y);
        _canvas.drawBitmap(bmp, transform, null);
    }

    @Override
    public void OnHit(Collidable collide)
    {
        if(collide instanceof Bullet)
        {
            Bullet bullet = (Bullet) collide;
            AddHealth(-bullet.GetDamage());
            bullet.SetIsActive(false);
        }
    }
}

