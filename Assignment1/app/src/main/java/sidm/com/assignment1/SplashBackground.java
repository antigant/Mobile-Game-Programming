package sidm.com.assignment1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.SurfaceView;

public class SplashBackground implements EntityBase
{
    private Bitmap bmp = null;
    private boolean active = true;

    private float xPos, yPos, offset;
    private SurfaceView view = null;
    Matrix transform = new Matrix();

    private boolean isInit = false;
    private boolean isRender = true;

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
    public boolean IsRender() {
        return isRender;
    }

    @Override
    public void SetIsRender(boolean _isRender) {
        isRender = _isRender;
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
        view = _view;
        bmp = BitmapFactory.decodeResource(_view.getResources(), R.drawable.splash_screen);
        isInit = true;
    }

    @Override
    public void Update()
    {
        offset += Time.deltaTime * 0.1f;
    }

    @Override
    public void Render(Canvas _canvas)
    {
        xPos = 0.5f * view.getWidth() - 50.f;
        yPos = 0.5f * view.getHeight();
//
//        float xOffset = (float)Math.sin(offset) * bmp.getWidth() * 0.3f;
//
//        _canvas.drawBitmap(bmp, xPos - bmp.getWidth() * 0.5f, yPos - bmp.getHeight() * 0.5f + offset, null);
        transform.setScale(1.f, 1.f);
        transform.postTranslate(xPos - _canvas.getWidth() * 0.5f, yPos -  _canvas.getHeight() * 0.5f);
        _canvas.drawBitmap(bmp, transform, null);
    }

    public  SplashBackground Create()
    {
        //SplashBackground result = new SplashBackground();
        EntityManager.Instance.AddEntity(this);
        return this;
    }
}

