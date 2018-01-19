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
    public void Init(SurfaceView _view)
    {

        view = _view;
        bmp = BitmapFactory.decodeResource(_view.getResources(), R.drawable.background2);
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
//        yPos = 0.5f * view.getHeight();
//
//        float xOffset = (float)Math.sin(offset) * bmp.getWidth() * 0.3f;
//        _canvas.drawBitmap(bmp, xPos - bmp.getWidth() * 0.5f + 50.f, -2230, null);

        transform.setScale(1.f, 1.f);
        transform.postTranslate(xPos - _canvas.getWidth() * 0.5f, -2230.f);
        _canvas.drawBitmap(bmp, transform, null);
    }

    public SampleBackground Create()
    {
//        SampleBackground result = new SampleBackground();
        EntityManager.Instance.AddEntity(this);
        return this;
    }
}
