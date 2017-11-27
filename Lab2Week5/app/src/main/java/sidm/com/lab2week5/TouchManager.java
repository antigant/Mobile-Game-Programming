package sidm.com.lab2week5;

import android.view.MotionEvent;

public class TouchManager
{
    public final static TouchManager Instance = new TouchManager();

    public enum TouchState
    {
        NONE,
        DOWN,
        MOVE
    }

    private TouchState status = TouchState.NONE;
    private int posX, posY; // Getting the position base on pixels

    private TouchManager()
    {
    }

    public boolean HasTouch()
    {
        return status == TouchState.DOWN || status == TouchState.MOVE;
    }

    public boolean IsDown()
    {
        // #if ANDROID Write Android Version #endif
        // #if iOS Write iOS version #endif
        // ... so on so forth...

        return status == TouchState.DOWN;
    }

    public int GetPosX()
    {
        return posX;
    }

    public int GetPosY()
    {
        return posY;
    }

    public void Update(int _posX, int _posY, int motionEventStatus)
    {
        posX = _posX;
        posY = _posY;

        // Android version of stuff here
        switch(motionEventStatus)
        {
            case MotionEvent.ACTION_DOWN:
                status = TouchState.DOWN;
                break;

            case MotionEvent.ACTION_MOVE:
                status = TouchState.MOVE;
                break;

            case MotionEvent.ACTION_UP:
                status = TouchState.NONE;
                break;
        }
    }
}
