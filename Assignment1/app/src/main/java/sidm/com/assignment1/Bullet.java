package sidm.com.assignment1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.SurfaceView;

public class Bullet extends GameObject
{
    private float dmg; // damage
    private float lifeTime;

    Matrix transform = new Matrix();

    private static float MAX_TIME = 10f;
    private static float BULLET_YPOS = 200f;

    // Setter
    public void SetDamage(final float _dmg) { dmg = _dmg; }
    public void SetLifeTime(final float _lifeTime) { lifeTime = _lifeTime; }

    // Getter
    final public float GetDamage() { return dmg; }
    final public float GetLifeTime() { return lifeTime; }

    @Override
    public void Init(SurfaceView _view)
    {
        active = true;
        dmg = 10f;
        lifeTime = 0f;
        SetBitmap(_view, R.drawable.bullet );
        moveSpeed = 200f;
        pos.x = Player.Instance.GetPosition().x;
        pos.y = Player.Instance.GetPosition().y - BULLET_YPOS;
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

        // Update the bullet position
        SetPosition(new Vector2(pos.x, pos.y -= moveSpeed * Time.deltaTime));
    }

    @Override
    public void Render(Canvas _canvas)
    {
        transform.setScale(scale.x, scale.y);
        transform.postTranslate(pos.x, pos.y);
        _canvas.drawBitmap(bmp, transform, null);
    }
}

