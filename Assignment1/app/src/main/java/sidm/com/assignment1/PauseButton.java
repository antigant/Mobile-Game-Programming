package sidm.com.assignment1;

import android.graphics.Canvas;
import android.text.method.Touch;
import android.view.SurfaceView;

public class PauseButton extends CButton
{

    @Override
    public void Init(SurfaceView _view)
    {
        SetName("pause button");
        SetType("button");
        SetIsActive(true);
        SetBitmap(_view,R.drawable.pause );
        SetPosition(new Vector2(100.f, 100.f));
        SetAABB(new Vector2(pos.x + bmp.getWidth() * 0.5f, pos.y + bmp.getHeight() * 0.5f), new Vector2(pos.x - bmp.getWidth() * 0.5f, pos.y - bmp.getHeight() * 0.5f));
    }

    @Override
    public void Update()
    {
        if(TouchManager.Instance.IsDown())
        {
            if(Collision.CheckPointAABB(TouchManager.Instance.GetTouchPos(), this))
                GameSystem.Instance.SetIsPaused(!GameSystem.Instance.GetIsPaused());

        }
    }

    @Override
    public void Render(Canvas _canvas)
    {
        //set position

        _canvas.drawBitmap(bmp, GetPosition().x - bmp.getWidth() * 0.5f, GetPosition().y - bmp.getHeight() * 0.5f, null);
    }

    @Override
    public GameObject Create()
    {
        EntityManager.Instance.AddEntity(this);
        return this;
    }
}
