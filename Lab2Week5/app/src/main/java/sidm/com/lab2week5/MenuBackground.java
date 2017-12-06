package sidm.com.lab2week5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceView;


public class MenuBackground implements EntityBase
{
    private Bitmap bmp = null;
    private boolean active = true;

    private float xPos, yPos;
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
        bmp = BitmapFactory.decodeResource(_view.getResources(), R.drawable.ship2_2);
    }

    @Override
    public void Update()
    {
    }

    @Override
    public void Render(Canvas _canvas)
    {
        _canvas.drawBitmap(bmp, xPos - bmp.getWidth() * 0.5f, yPos - bmp.getHeight() * 0.5f, null);
    }

    public MenuBackground Create()
    {
        EntityManager.Instance.AddEntity(this);
        return this;
    }
}
