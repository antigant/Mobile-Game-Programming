package sidm.com.assignment1;

import android.graphics.Canvas;
import android.view.SurfaceView;

public interface EntityBase
{
    boolean IsActive();
    void SetIsActive(boolean _active);

    //Vector2 GetPosition(){ return pos;};

    void Init(SurfaceView _view);
    void Update();
    void Render(Canvas _canvas);
}
