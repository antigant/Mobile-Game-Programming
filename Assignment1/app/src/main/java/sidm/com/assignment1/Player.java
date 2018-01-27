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

    private Weapon weapon = new DefaultWeapon();

    // Variables
    private float m_fJumpSpeed, m_fJumpAcceleration, m_fFallSpeed, m_fFallAcceleration;
    private boolean m_bJump, m_bFalling;

    public void SetJumpSpeed(final float m_fJumpSpeed)
    {
        this.m_fJumpSpeed = m_fJumpSpeed;
    }

    public void SetJumpAcceleration(final float m_fJumpAcceleration)
    {
        this.m_fJumpAcceleration = m_fJumpAcceleration;
    }

    public void SetFallSpeed(final float m_fFallSpeed)
    {
        this.m_fFallSpeed = m_fFallSpeed;
    }

    public void SetFallAcceleration(final float m_fFallAcceleration)
    {
        this.m_fFallAcceleration = m_fFallAcceleration;
    }

    public void SetToJump(boolean isOnJumpUpwards)
    {
        if(isOnJumpUpwards)
        {
            m_bJump = true;
            m_bFalling = false;
            m_fFallSpeed = 10.0f;
        }
    }

    private void SetFreeFall(boolean isOnFreeFall)
    {
        if(isOnFreeFall)
        {
            m_bJump = false;
            m_bFalling = true;
            m_fJumpSpeed = 40.0f;
        }
    }

    private void UpdateFreeFall()
    {
        if (!m_bFalling)
            return;

        // Update position and target y value
        pos.y += (float)(m_fFallSpeed * Time.deltaTime + 0.5f * m_fJumpAcceleration * Time.deltaTime * Time.deltaTime);
        m_fFallSpeed = m_fFallSpeed + m_fFallAcceleration * Time.deltaTime;
    }

    public void AddHealth(float amt)
    {
        health.AddHealth(amt);
        if(health.GetHealth() <= 0.f)
            SetIsDead(true);
    }

    // Getter
    public boolean GetIsDead() { return isDead; }
    public Weapon GetWeapon() { return weapon; }

    // Setter
    public void SetIsDead(final boolean _isDead)
    {
        isDead = _isDead;
    }
    public void SetWeapon(final Weapon _weapon) { weapon = _weapon; }

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

        SetAABB(new Vector2(pos.x + bmp.getWidth() * 0.25f, pos.y + bmp.getHeight() * 0.25f), new Vector2(pos.x - bmp.getWidth() * 0.25f, pos.y - bmp.getHeight() * 0.25f));
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
        weapon.Render(_canvas);
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
        if(collide instanceof Bullet)
        {
            Bullet temp = (Bullet) collide; // type casting
            AddHealth(-temp.GetDamage());
        }
    }
}

