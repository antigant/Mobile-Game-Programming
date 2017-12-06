package sidm.com.lab2week5;

import android.graphics.Canvas;
import android.view.SurfaceView;

public interface Scene
{
    void Init(SurfaceView _view);
    void Update();
    void Render(Canvas _canvas);
    void Exit();
}
