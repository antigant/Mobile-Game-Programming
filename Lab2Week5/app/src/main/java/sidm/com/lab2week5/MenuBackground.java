package sidm.com.lab2week5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceView;

/**
 * Created by janra on 4/12/2017.
 */

public class MenuBackground implements EntityBase
{
    private Bitmap bmp = null;
    private boolean isDone = false;

    private float xPos, yPos, offset;
    private SurfaceView view = null;

    @Override
    public boolean IsActive() {
        return isDone;
    }

    @Override
    public void SetIsActive(boolean _isDone)
    {
        isDone = _isDone;
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

    public static MenuBackground Create()
    {
        MenuBackground result = new MenuBackground();
        EntityManager.Instance.AddEntity(result);
        return result;
    }
}
