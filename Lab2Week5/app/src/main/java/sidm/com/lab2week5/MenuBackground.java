package sidm.com.lab2week5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.SurfaceView;


public class MenuBackground implements EntityBase
{
    private Bitmap bmp = null;
    private boolean active;

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
        active = true;
        view = _view;
        bmp = BitmapFactory.decodeResource(_view.getResources(), R.drawable.angrybirds_drawbackground325);
    }

    @Override
    public void Update()
    {

    }

    @Override
    public void Render(Canvas _canvas)
    {
        xPos = 0.5f * view.getWidth();
        yPos = 0.5f * view.getHeight();

        float xOffset = (float)Math.sin(offset) * bmp.getWidth() * 0.3f;

        transform.setTranslate(_canvas.getWidth() * 0.5f, _canvas.getHeight() * 0.5f);
        transform.setScale(1.25f, 3f);
//        transform.postTranslate(bmp.getWidth() * 0.5f, bmp.getHeight() * 0.5f + offset);
        _canvas.drawBitmap(bmp, transform, null);

//        _canvas.drawBitmap(bmp, xPos - bmp.getWidth() * 0.5f, yPos - bmp.getHeight() * 0.5f + offset, null);



    }

    public MenuBackground Create()
    {
//        MenuBackground result = new MenuBackground();
        EntityManager.Instance.AddEntity(this);
        return this;
    }
}
