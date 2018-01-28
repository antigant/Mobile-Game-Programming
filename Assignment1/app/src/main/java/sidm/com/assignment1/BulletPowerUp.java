package sidm.com.assignment1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.SurfaceView;

import java.util.Random;

public class BulletPowerUp extends PowerUp
{
    Matrix transform = new Matrix();
    private float dir = 1f;

    private Random rand = new Random();

    @Override
    public void Init(SurfaceView _view)
    {
        active = true;
        SetName("bullet power up");
        SetType("power up");
        SetBitmap(_view,R.drawable.bullet_powerup );

        pos.x = rand.nextInt(700) + 200;
        pos.y = -10f;
        checkPos.x = pos.x;
        checkPos.y = pos.y;

        moveSpeed = 50f;
        PowerUpManager.Instance.SetPowerupType("Weapon");

        isInit = true;
    }

    @Override
    public void Update()
    {
        if(pos.y >= 1750f)
            SetIsActive(false);

        pos.Set(pos.x += moveSpeed * Time.deltaTime * dir, pos.y += moveSpeed * Time.deltaTime);
        maxAABB.Set(pos.x + bmp.getWidth() * 0.5f, pos.y + bmp.getHeight() * 0.5f);
        minAABB.Set(pos.x - bmp.getWidth() * 0.5f, pos.y - bmp.getHeight() * 0.5f);
        float result = pos.x - checkPos.x;
        if( result >= 300f || result <= -300)
        {
            dir *= -1;
            checkPos.Set(pos.x, pos.y);
        }
    }

    @Override
    public void Render(Canvas _canvas)
    {
        transform.setScale(scale.x, scale.y);
        transform.postTranslate(pos.x, pos.y);
        _canvas.drawBitmap(bmp, transform, null);
    }

    @Override
    public void OnHit(Collidable _other)
    {   // Disable the power up
        if(_other instanceof Player)
        {
            SetIsActive(false);
            Weapon weapon = Player.Instance.GetWeapon();
            weapon.SetFixBulletSpawnRate(1f);
            PowerUpManager.Instance.SetfixPowerUpTime(20f);
            PowerUpManager.Instance.SetPoweredUp(true);
        }
    }
}

