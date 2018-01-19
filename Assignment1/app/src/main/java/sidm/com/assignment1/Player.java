package sidm.com.assignment1;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceView;

public class Player extends GameObject
{
    public final static Player Instance = new Player();
    private Player() {} // Private constructor to not let other create another instance
    private Health playerHealth;
    private boolean isDead = false;

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

    public void SetHealth(float amt)
    {
        playerHealth.AddHealth(amt);

        if(playerHealth.GetHealth() <= 0.f)
            SetIsDead(true);
    }

    public void SetIsDead(final boolean isDead)
    {
        this.isDead = isDead;
    }

    @Override
    public void Init(SurfaceView _view)
    {
        SetBitmap(_view, R.drawable.player);
    }

    @Override
    public void Update()
    {

        if (TouchManager.Instance.GetSwipeState() == "RIGHT")
        {

        }
        else if (TouchManager.Instance.GetSwipeState() == "LEFT")
        {

        }
    }

    @Override
    public void Render(Canvas _canvas)
    {
        _canvas.drawBitmap(bmp, GetPosition().x - bmp.getWidth() * 0.5f, GetPosition().y - bmp.getHeight() * 0.5f, null);
    }

    @Override
    public void OnHit(Collidable collide)
    {
        if(collide.GetType() == "Platform")
        {
            if(m_bFalling)
            {
                // Standing on the platform
                pos.y = collide.GetPosition().y;
                m_fFallSpeed = 0.f;
                m_bFalling = false;
            }
        }
    }
}

