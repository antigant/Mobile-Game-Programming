package sidm.com.assignment1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceView;

public class SampleBackground implements EntityBase
{
    private Bitmap bmp = null;
    private boolean active = true;

    private float xPos, yPos, offset;
    private SurfaceView view = null;

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
        bmp = BitmapFactory.decodeResource(_view.getResources(), R.drawable.gamescene);
    }

    @Override
    public void Update()
    {
        offset += Time.deltaTime * 0.1f;
    }

    @Override
    public void Render(Canvas _canvas)
    {
        xPos = 0.5f * view.getWidth();
        yPos = 0.5f * view.getHeight();

        float xOffset = (float)Math.sin(offset) * bmp.getWidth() * 0.3f;

        _canvas.drawBitmap(bmp, xPos - bmp.getWidth() * 0.5f, yPos - bmp.getHeight() * 0.5f + offset, null);
    }

    public SampleBackground Create()
    {
//        SampleBackground result = new SampleBackground();
        EntityManager.Instance.AddEntity(this);
        return this;
    }
}
