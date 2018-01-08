package sidm.com.assignment1;

import android.view.SurfaceView;

public abstract class Button extends GameObject
{
    protected boolean isClick = false ;

    public void SetIsClick(final boolean _isClick)
    {
        isClick = _isClick;
    }

    final public boolean GetIsClick()
    {
        return isClick;
    }
}

