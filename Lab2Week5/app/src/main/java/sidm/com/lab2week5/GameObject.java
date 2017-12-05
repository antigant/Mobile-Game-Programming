package sidm.com.lab2week5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceView;

import java.util.Random;

// Game objects can have the same type but different name
// Eg. Pause button : name is pause, type is button
// Play button : name is play, type is button
// Can use type to do the same kind of collision,
// but using the name to differentiate between the function
public class GameObject implements EntityBase, Collidable
{
    private Bitmap bmp = null;
    // name : game object name; type : game object type (for collision purpose)
    private String name, type;
    protected Vector2 pos = new Vector2(0.f, 0.f), vel = new Vector2(0.f, 0.f), scale = new Vector2(0.f, 0.f), dir = new Vector2(0.f, 0.f);
    protected float moveSpeed;
    protected boolean active;

    // If don't init the bitmap, will have no image
    public void SetBitmap(SurfaceView _view, int resource)
    {
        bmp = BitmapFactory.decodeResource(_view.getResources(), resource);
    }

    public void SetName(String _name)
    {
        name = _name;
    }

    public String GetName()
    {
        return name;
    }

    public void SetPosition(final Vector2 _pos)
    {
        pos.Assignment(_pos);
    }

    @Override
    public Vector2 GetPosition()
    {
        return pos;
    }

    public void SetVelocity(final Vector2 _vel)
    {
        vel.Assignment(_vel);
    }

    final public Vector2 GetVelocity()
    {
        return vel;
    }

    public void SetScale(final Vector2 _scale)
    {
        scale.Assignment(_scale);
    }

    final public Vector2 GetScale()
    {
        return scale;
    }

    public void SetDirection(final Vector2 _dir)
    {
        dir = _dir;
    }

    final public Vector2 GetDirection()
    {
        return dir;
    }

    public void SetMoveSpeed(final float _moveSpeed)
    {
        moveSpeed = _moveSpeed;
    }

    final public float GetMoveSpeed()
    {
        return moveSpeed;
    }

    public static GameObject Create()
    {
        GameObject result = new GameObject();
        EntityManager.Instance.AddEntity(result);
        return result;
    }

    @Override
    final public String GetType()
    {
        return type;
    }

    @Override
    public void SetType(String _type)
    {
        type = _type;
    }

    @Override
    final public float GetRadius()
    {
        return bmp.getHeight() * 0.5f;
    }

    @Override
    public void OnHit(Collidable _other){
    }

    @Override
    final public boolean IsActive()
    {
        return active;
    }

    @Override
    public void SetIsActive(final boolean _active)
    {
        active = _active;
    }

    @Override
    public void Init(SurfaceView _view) {
    }

    @Override
    public void Update(float dt) {
    }

    @Override
    public void Render(Canvas _canvas) {
    }
}
