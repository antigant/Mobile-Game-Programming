package sidm.com.assignment1;

import android.graphics.Canvas;
import android.view.SurfaceView;

public interface Scene
{
    String GetName();

    void Init(SurfaceView _view);
    void Update();
    void Render(Canvas _canvas);
    void Exit();
}
