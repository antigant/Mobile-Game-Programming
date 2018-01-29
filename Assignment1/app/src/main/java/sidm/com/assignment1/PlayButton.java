package sidm.com.assignment1;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.Display;
import android.view.SurfaceView;

public class PlayButton extends CButton
{
    private boolean playClicked;

    @Override
    public void SetPosition(Vector2 _pos)
    {
        pos = _pos;
        SetAABB(new Vector2(pos.x + bmp.getWidth() * 0.5f, pos.y + bmp.getHeight() * 0.5f), new Vector2(pos.x - bmp.getWidth() * 0.5f, pos.y - bmp.getHeight() * 0.5f));
    }

    @Override
    public void Init(SurfaceView _view)
    {
        SetName("play button");
        SetType("button");
        SetIsActive(true);
        SetBitmap(_view,R.drawable.play_button );
        SetPosition(550.f, 1000.f);
        SetAABB(pos.x + bmp.getWidth() * 0.5f, pos.y + bmp.getHeight() * 0.5f, pos.x - bmp.getWidth() * 0.5f, pos.y - bmp.getHeight() * 0.5f);

        playClicked = false;
        isInit = true;
        //SetScale(new Vector2(0.3f,0.3f));
        //_view.getWidth();
        //_view.getMeasuredWidth();
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
                SetIsClick(false);
                active = false;
                playClicked = true;
            }
        }
    }

    public boolean GetPlayClicked()
    {
        return playClicked;
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
