package sidm.com.lab2week5;

import android.view.SurfaceView;

public class Button extends GameObject
{
    protected boolean isClick;

    public void SetIsClick(final boolean _isClick)
    {
        isClick = _isClick;
    }

    final public boolean GetIsClick()
    {
        return isClick;
    }
}

