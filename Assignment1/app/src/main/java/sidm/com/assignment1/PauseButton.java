package sidm.com.assignment1;

import android.graphics.Canvas;
import android.text.method.Touch;
import android.view.SurfaceView;

public class PauseButton extends CButton
{
    @Override
    public void Init(SurfaceView _view)
    {
        active = true;

        SetName("pause button");
        SetType("button");
        SetIsActive(true);
        SetBitmap(_view,R.drawable.pause );
        SetPosition(1000.f, 100.f);
        SetAABB(pos.x + bmp.getWidth() * 0.5f, pos.y + bmp.getHeight() * 0.5f, pos.x - bmp.getWidth() * 0.5f, pos.y - bmp.getHeight() * 0.5f);

        isInit = true;
    }

    @Override
    public void Update()
    {
            if(TouchManager.Instance.IsDown())
                SetIsClick(true);
            if(Collision.CheckPointAABB(TouchManager.Instance.GetTouchPos(), this))
            {
                if(GetIsClick())
                {
                    GameSystem.Instance.SetIsPaused(true);
                    PausePage.Instance.PauseButtonClicked();
                    SetIsClick(false);
                }
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

//    @Override
//    public int GetRenderLayer() { return LayerConstants.UI_LAYER; }
}