package sidm.com.assignment1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.SurfaceView;


public class MenuBackground implements EntityBase
{
    private Bitmap bmp = null;
    private boolean active;

    private float xPos, yPos;
    private SurfaceView view = null;
    Matrix transform = new Matrix();

    private boolean isInit = false;

    @Override
    public boolean IsActive() {
        return active;
    }

    @Override
    public void SetIsActive(boolean _active)
    {
        active = _active;
    }

    @Override
    public boolean GetIsInit() {
        return isInit;
    }

    @Override
    public int GetRenderLayer() {
        return LayerConstants.BACKGROUND_LAYER;
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
        bmp = BitmapFactory.decodeResource(_view.getResources(), R.drawable.menu_background);
        xPos = 0.5f * _view.getWidth() - 50.f;
        yPos = 0.5f * _view.getHeight();
        isInit = true;
    }

    @Override
    public void Update()
    {
    }

    @Override
    public void Render(Canvas _canvas)
    {
        transform.setScale(1.f, 1.f);
        transform.postTranslate(xPos - _canvas.getWidth() * 0.5f, yPos -  _canvas.getHeight() * 0.5f);
        _canvas.drawBitmap(bmp, transform, null);
    }

    public void SetBitmap(int _resource)
    {
        bmp = BitmapFactory.decodeResource(view.getResources(), _resource);
    }

    public MenuBackground Create()
    {
        EntityManager.Instance.AddEntity(this);
        return this;
    }
}
