package sidm.com.assignment1;

import android.content.Intent;
import android.graphics.Canvas;
import android.view.SurfaceView;

public class ShareButton extends CButton
{
    Intent intent = new Intent();

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
                EntityManager.Instance.ClearEntityManager();
                intent.setClass(GamePage.class, Scorepage.class);
                startActivity(intent);
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
}
