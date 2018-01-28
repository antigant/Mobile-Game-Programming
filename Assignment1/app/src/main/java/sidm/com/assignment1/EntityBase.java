package sidm.com.assignment1;

import android.graphics.Canvas;
import android.view.SurfaceView;

public interface EntityBase
{
    // Decides if it still exist in the game world
    boolean IsActive();
    void SetIsActive(boolean _active);

    // Decides if it render on screen
    boolean IsRender();
    void SetIsRender(boolean _isRender);

    boolean GetIsInit();
    int GetRenderLayer();
    void SetRenderLayer(int _newLayer);

    //Vector2 GetPosition(){ return pos;};

    void Init(SurfaceView _view);
    void Update();
    void Render(Canvas _canvas);
}
