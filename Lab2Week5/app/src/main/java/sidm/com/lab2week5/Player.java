package sidm.com.lab2week5;

public class Player extends GameObject
{
    private float m_fJumpSpeed, m_fJumpAcceleration, m_fFallSpeed;
    private boolean m_bJump, m_bFalling;

    public void SetToJump(boolean isOnJumpUpwards)
    {
        if(isOnJumpUpwards)
        {
            m_bJump = true;
            m_bFalling = false;
            m_fFallSpeed = 10.0f;
        }
    }

    @Override
    public void Update()
    {

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
}
