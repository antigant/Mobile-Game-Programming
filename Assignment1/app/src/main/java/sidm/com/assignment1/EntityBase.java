package sidm.com.assignment1;

import android.graphics.Canvas;
import android.view.SurfaceView;

public interface EntityBase
{
    boolean IsActive();
    void SetIsActive(boolean _active);

    boolean GetIsInit();
    void SetIsInit(boolean _isInit);

    //Vector2 GetPosition(){ return pos;};

    void Init(SurfaceView _view);
    void Update();
    void Render(Canvas _canvas);
}
