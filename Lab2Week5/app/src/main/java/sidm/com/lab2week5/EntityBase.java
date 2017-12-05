package sidm.com.lab2week5;

import android.graphics.Canvas;
import android.view.SurfaceView;

public interface EntityBase
{
    boolean IsActive();
    void SetIsActive(boolean _active);

    void Init(SurfaceView _view);
    void Update(float dt);
    void Render(Canvas _canvas);
}
