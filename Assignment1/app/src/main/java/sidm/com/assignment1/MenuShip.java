package sidm.com.assignment1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.SurfaceView;

public class MenuShip implements EntityBase
{
    private Bitmap bmp = null;
    private boolean active;

    private Vector2 pos;
    private Vector2 scale;
    private SurfaceView view = null;
    private boolean isInit = false;

    Matrix transform = new Matrix();

    @Override
    public boolean IsActive() { return active; }

    @Override
    public void SetIsActive(boolean _active)
    {
        active = _active;
    }

    @Override
    public boolean GetIsInit()
    {
        return isInit;
    }

    @Override
    public int GetRenderLayer() {
        return LayerConstants.GAMEOBJECTS_LAYER;
    }

    @Override
    public void SetRenderLayer(int _newLayer) {
        return;
    }

    @Override
    public void Init(SurfaceView _view)
    {
        active = true;
        view = _view;
        bmp = BitmapFactory.decodeResource(_view.getResources(), R.drawable.player);
        pos = new Vector2(500f, 1350f);
        isInit = true;
    }

    @Override
    public void Update() {

    }

    @Override
    public void Render(Canvas _canvas)
    {
        transform.setScale(1f, 1f);
        transform.postTranslate(pos.x, pos.y);
        _canvas.drawBitmap(bmp, transform, null);
    }
}
