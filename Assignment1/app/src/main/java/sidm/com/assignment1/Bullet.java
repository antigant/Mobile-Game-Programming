package sidm.com.assignment1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.SurfaceView;

public class Bullet extends GameObject
{
    private int dmg; // damage
    private float lifeTime;

    Matrix transform = new Matrix();

    private static float MAX_TIME = 10f;
    private static float BULLET_YPOS = 200f;

    // Setter
    public void SetDamage(final int _dmg) { dmg = _dmg; }
    public void SetLifeTime(final float _lifeTime) { lifeTime = _lifeTime; }

    // Getter
    final public int GetDamage() { return dmg; }
    final public float GetLifeTime() { return lifeTime; }

    @Override
    public void Init(SurfaceView _view)
    {
        active = true;
        dmg = 10;
        lifeTime = 0f;
        SetBitmap(_view, R.drawable.bullet );
        moveSpeed = 200f;
        pos.x = Player.Instance.GetPosition().x;
        pos.y = Player.Instance.GetPosition().y - BULLET_YPOS;

        SetRadius(bmp.getHeight());

        isInit = true;
    }

    @Override
    public void Update()
    {
        lifeTime += Time.deltaTime;
        if(lifeTime > MAX_TIME) // bullet dies
        {
            SetIsActive(false);
            return;
        }

        maxAABB.Set(pos.x + bmp.getWidth() * 0.5f, pos.y + bmp.getHeight() * 0.5f);
        minAABB.Set(pos.x - bmp.getWidth() * 0.5f, pos.y - bmp.getHeight() * 0.5f);
        // Update the bullet position
        pos.Set(pos.x, pos.y -= moveSpeed * Time.deltaTime);
    }

    @Override
    public void Render(Canvas _canvas)
    {
        transform.setScale(scale.x, scale.y);
        transform.postTranslate(pos.x, pos.y);
        _canvas.drawBitmap(bmp, transform, null);
    }
}

