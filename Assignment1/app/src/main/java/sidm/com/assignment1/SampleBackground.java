package sidm.com.assignment1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.SurfaceView;

public class SampleBackground implements EntityBase
{
    private Bitmap bmp = null;
    private boolean active = true;

    private float xPos, yPos, offset;
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
        view = _view;
        bmp = BitmapFactory.decodeResource(_view.getResources(), R.drawable.background);
        xPos = 0.5f * view.getWidth() - 50.f;

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
        transform.setScale(1.f, 1.f);
        transform.postTranslate(xPos - _canvas.getWidth() * 0.5f, -200f);
        _canvas.drawBitmap(bmp, transform, null);
    }

    public SampleBackground Create()
    {
//        SampleBackground result = new SampleBackground();
        EntityManager.Instance.AddEntity(this);
        return this;
    }
}
