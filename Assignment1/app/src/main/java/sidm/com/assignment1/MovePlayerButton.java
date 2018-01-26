package sidm.com.assignment1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.SurfaceView;

public class MovePlayerButton extends CButton
{
    Matrix transform = new Matrix();
    int dir = 0;

    @Override
    public void SetPosition(Vector2 _pos)
    {
        pos = _pos;
        SetAABB(new Vector2(pos.x + bmp.getWidth() * 0.5f * scale.x, pos.y + bmp.getHeight() * 0.5f * scale.y), new Vector2(pos.x - bmp.getWidth() * 0.5f * scale.x, pos.y - bmp.getHeight() * 0.5f * scale.y));
    }

    @Override
    public void SetScale(Vector2 _scale)
    {
        scale = _scale;
        SetAABB(new Vector2(pos.x + bmp.getWidth() * 0.5f * scale.x, pos.y + bmp.getHeight() * 0.5f * scale.y), new Vector2(pos.x - bmp.getWidth() * 0.5f * scale.x, pos.y - bmp.getHeight() * 0.5f * scale.y));
    }

    @Override
    public void Init(SurfaceView _view)
    {
        SetName("Move player button");
        SetType("button");
        SetIsActive(true);
        SetBitmap(_view,R.drawable.white2 );
        SetPosition(new Vector2(200, 1450.f));
        SetScale(new Vector2(1.f, 1.f));
        SetAABB(new Vector2(pos.x + bmp.getWidth() * 0.5f, pos.y + bmp.getHeight() * 0.5f), new Vector2(pos.x - bmp.getWidth() * 0.5f, pos.y - bmp.getHeight() * 0.5f));

        isInit = true;
    }

    @Override
    public void Update()
    {
        if(TouchManager.Instance.IsDown())
            SetIsClick(true);
        if(TouchManager.Instance.IsUp())
            SetIsClick(false);
        if(Collision.CheckPointAABB(TouchManager.Instance.GetTouchPos(), this))
        {
            if(GetIsClick())
            {
                Player.Instance.SetPosition(new Vector2(Player.Instance.GetPosition().x += Player.Instance.GetMoveSpeed() * Time.deltaTime * dir, Player.Instance.GetPosition().y));
//                SetIsClick(false);
            }
        }
    }

    public void SetDirection(final int _dir)
    {
        dir = _dir;
    }

    @Override
    public void Render(Canvas _canvas)
    {
        //set position

//        transform.setScale(scale.x, scale.y);
//        transform.postTranslate(pos.x - _canvas.getWidth() * 0.5f, pos.y);
//        _canvas.drawBitmap(bmp, transform, null);
    }

    @Override
    public int GetRenderLayer()
    {
        return LayerConstants.BACKGROUND_LAYER;
    }

    @Override
    public GameObject Create()
    {
        EntityManager.Instance.AddEntity(this);
        return this;
    }
}
