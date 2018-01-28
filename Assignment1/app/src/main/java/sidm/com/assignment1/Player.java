package sidm.com.assignment1;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.Surface;
import android.view.SurfaceView;

public class Player extends GameObject
{
    public final static Player Instance = new Player();
    private Player() {} // Private constructor to not let other create another instance
    private Health health = new Health();
    private boolean isDead = false;
    Matrix transform = new Matrix();
    private float score = 0f;

    private Weapon weapon = new DefaultWeapon();

    public void AddHealth(float amt)
    {
        health.AddHealth(amt);
        if(health.GetHealth() <= 0.f)
            SetIsDead(true);
    }

    // Getter
    final public boolean GetIsDead() { return isDead; }
    final public Weapon GetWeapon() { return weapon; }
    final public float GetScore() { return score; }

    // Setter
    public void SetIsDead(final boolean _isDead)
    {
        isDead = _isDead;
    }
    public void SetWeapon(final Weapon _weapon) { weapon = _weapon; }
    public void SetScore(final float _score) { score = _score; }

    // -- //
    public void Restart(SurfaceView _view)
    {
        active = true;
        moveSpeed = 100.f;
        SetSpritesheet(_view, R.drawable.player_sprite, 2, 2, 5);

        weapon.Init(_view);
        health.SetMaxHealth(100f);
        health.Init();

        isInit = true;
    }

    @Override
    public void Init(SurfaceView _view)
    {
        active = true;
        moveSpeed = 100.f;
        SetSpritesheet(_view, R.drawable.player_sprite, 2, 2, 5);

        weapon.Init(_view);
        health.SetMaxHealth(100f);
        health.Init();

        isInit = true;
    }

    @Override
    public void Update()
    {
        if(isDead)
            return;

        maxAABB.Set(pos.x + bmp.getWidth() * 0.25f, pos.y + bmp.getHeight() * 0.25f);
        minAABB.Set(pos.x - bmp.getWidth() * 0.25f, pos.y - bmp.getHeight() * 0.25f);
        spritesheet.Update(Time.deltaTime);
        weapon.Update();

        if(pos.y > 1500f)
            pos.y = 1500f;

        if(pos.x < 43.5f)
            pos.x = 43.5f;

        if(pos.x > 1040f)
            pos.x = 1040f;
//        if (TouchManager.Instance.GetSwipeState() == "RIGHT")
//        {
//
//        }
//        else if (TouchManager.Instance.GetSwipeState() == "LEFT")
//        {
//
//        }
    }

    @Override
    public int GetRenderLayer()
    {
        return LayerConstants.GAMEOBJECTS_LAYER;
    }

    @Override
    public void Render(Canvas _canvas)
    {
//        transform.setScale(1f, 1f);
//        transform.postTranslate(pos.x, pos.y);
//        _canvas.drawBitmap(bmp, transform, null);

        spritesheet.Render(_canvas, (int)pos.x, (int)pos.y);
    }

    @Override
    public void OnHit(Collidable collide)
    {
//        if(collide.GetType() == "Platform")
//        {
//            if(m_bFalling)
//            {
//                // Standing on the platform
//                pos.y = collide.GetPosition().y;
//                m_fFallSpeed = 0.f;
//                m_bFalling = false;
//            }
//
//        if(collide instanceof Bullet)
//        {
//            Bullet bullet = (Bullet) collide; // type casting
//            AddHealth(-bullet.GetDamage());
//        }
        if(collide instanceof Enemy)
        {
            Enemy enemy = (Enemy) collide;
            AddHealth(-enemy.GetDamage());
            enemy.SetIsActive(false);
        }
    }
}

