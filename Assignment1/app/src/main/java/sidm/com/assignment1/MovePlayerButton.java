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
        maxAABB.Set(pos.x + bmp.getWidth() * 0.5f * scale.x, pos.y + bmp.getHeight() * 0.5f * scale.y);
        minAABB.Set(pos.x - bmp.getWidth() * 0.5f * scale.x, pos.y - bmp.getHeight() * 0.5f * scale.y);
    }

    @Override
    public void SetScale(Vector2 _scale)
    {
        scale = _scale;
        maxAABB.Set(pos.x + bmp.getWidth() * 0.5f * scale.x, pos.y + bmp.getHeight() * 0.5f * scale.y);
        minAABB.Set(pos.x - bmp.getWidth() * 0.5f * scale.x, pos.y - bmp.getHeight() * 0.5f * scale.y);
    }

    @Override
    public void Init(SurfaceView _view)
    {
        SetName("Move player button");
        SetType("button");
        SetIsActive(true);
        SetBitmap(_view,R.drawable.white2 );
        SetPosition(200, 1450.f);
        SetScale(1.f, 1.f);
        maxAABB.Set(pos.x + bmp.getWidth() * 0.5f * scale.x, pos.y + bmp.getHeight() * 0.5f * scale.y);
        minAABB.Set(pos.x - bmp.getWidth() * 0.5f * scale.x, pos.y - bmp.getHeight() * 0.5f * scale.y);

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
                Player.Instance.SetPosition(Player.Instance.GetPosition().x += Player.Instance.GetMoveSpeed() * Time.deltaTime * dir, Player.Instance.GetPosition().y);
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
