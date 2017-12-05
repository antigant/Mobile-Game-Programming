package sidm.com.lab2week5;

import android.view.MotionEvent;

public class TouchManager
{
    public final static TouchManager Instance = new TouchManager();

    public enum TouchState
    {
        NONE,
        UP,
        DOWN,
        MOVE
    }

    private TouchState status = TouchState.NONE;
    private Vector2 touchPos = new Vector2(0.f, 0.f); // Getting the position base on pixels (there for using int)
    // Swipes
    private String swipeState = "NONE"; // NONE, UP, DOWN, LEFT, RIGHT
    private float startTime = 0.f, endTime = 0.f, maxTime, minSwipeDist;
    private Vector2 startPos = new Vector2(0.f, 0.f), endPos = new Vector2(0.f, 0.f);

    public void SetMaxTime(final float _maxTime)
    {
        maxTime = _maxTime;
    }

    public void SetMinSwipeDist(final float _minSwipeDist)
    {
        minSwipeDist = _minSwipeDist;
    }

    final public String GetSwipeState()
    {
        return swipeState;
    }

    private void UpdateSwipe()
    {
        // User finger is on screen
        if(IsDown())
        {
            startTime = Time.time;
            startPos = touchPos;
        }
        else if (IsUp())
        {
            float swipeDistance;
            float swipeTime;
            endTime = Time.time;
            endPos = touchPos;

            swipeDistance = (endPos.Minus(startPos)).Length();
            swipeTime = endTime - startTime;

            if(swipeTime <= maxTime && swipeDistance >= minSwipeDist)
                swipe();
        }
    }

    private void swipe()
    {
        Vector2 distance = endPos.Minus(startPos);
        if(Math.abs(distance.x) > Math.abs(distance.y))
        {
            if(distance.x > 0.f)
                swipeState = "RIGHT";
            else if (distance.x < 0.f)
                swipeState = "LEFT";
        }

        else if(Math.abs(distance.x) < Math.abs(distance.y))
        {
            if(distance.y > 0.f)
                swipeState = "UP";
            else if(distance.y < 0.f)
                swipeState = "DOWN";
        }
    }

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

    public boolean IsUp()
    {
        return status == TouchState.UP;
    }

    public int GetPosX()
    {
        return (int)touchPos.x;
    }

    public int GetPosY()
    {
        return (int)touchPos.y;
    }

    public void Update(int _posX, int _posY, int motionEventStatus)
    {
        touchPos.Set(_posX, _posY);
        UpdateSwipe();

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
                status = TouchState.UP;
                break;
        }
    }
}
