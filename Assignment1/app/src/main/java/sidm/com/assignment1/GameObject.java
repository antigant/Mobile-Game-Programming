package sidm.com.assignment1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.SurfaceView;

import java.util.Random;

// Game objects can have the same type but different name
// Eg. Pause button : name is pause, type is button
// Play button : name is play, type is button
// Can use type to do the same kind of collision,
// but using the name to differentiate between the function
public class GameObject implements EntityBase, Collidable
{
    protected Bitmap bmp = null;
    protected Sprite spritesheet = null;
    // name : game object name; type : game object type (for collision purpose)
    private String name, type;
    protected Vector2 minAABB = new Vector2(0.f, 0.f);
    protected Vector2 maxAABB = new Vector2(0.f, 0.f);
    protected Vector2 pos = new Vector2(0.f, 0.f);
    protected Vector2 vel = new Vector2(0.f, 0.f);
    protected Vector2 scale = new Vector2(1.f, 1.f);
    protected Vector2 dir = new Vector2(0.f, 0.f);
    protected float moveSpeed;
    protected boolean active;
    protected int renderLayer = 0;
    protected boolean isInit = false;
    protected boolean isRender = true;
    protected float radius = 0f;

    // If don't init the bitmap, will have no image
    public void SetBitmap(SurfaceView _view, int resource)
    {
        bmp = BitmapFactory.decodeResource(_view.getResources(), resource);
    }

    public void SetSpritesheet(SurfaceView _view, int _resource, int _row, int _col, int _fps)
    {
        bmp = BitmapFactory.decodeResource(_view.getResources(), _resource);
        spritesheet = new Sprite(bmp, _row, _col, _fps);
    }

//    public Sprite GetSpritesheet()
//    {
//        return spritesheet;
//    }

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

    // Additional Setter
    public void SetPosition(final float a, final float b)
    {
        pos.x = a;
        pos.y = b;
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

    public void SetScale(final float a, final float b)
    {
        scale.x = a;
        scale.y = b;
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

    public GameObject Create()
    {
        EntityManager.Instance.AddEntity(this);
        return this;
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
//        if(spritesheet == null)
//            return 0f;
//        return spritesheet.GetHeight() * 0.5f;
        return radius;
    }

    @Override
    public void SetRadius(float _radius)
    {
        radius = _radius;
    }

    @Override
    public void OnHit(Collidable _other){
    }

    @Override
    public void SetAABB(Vector2 _maxAABB, Vector2 _minAABB)
    {
        maxAABB = _maxAABB;
        minAABB = _minAABB;
    }

    public void SetAABB(float a1, float b1, float a2, float b2)
    {
        maxAABB.x = a1;
        maxAABB.y = b1;
        minAABB.x = a2;
        minAABB.y = b2;
    }

    @Override
    final public Vector2 GetMaxAABB() {
        return maxAABB;
    }

    @Override
    public Vector2 GetMinAABB() {
        return minAABB;
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
    public boolean IsRender()
    {
        return isRender;
    }

    @Override
    public void SetIsRender(boolean _isRender)
    {
        isRender = _isRender;
    }

    @Override
    public boolean GetIsInit() {
        return isInit;
    }

    @Override
    public int GetRenderLayer() {
        return renderLayer;
    }

    @Override
    public void SetRenderLayer(int _newLayer) {
        renderLayer = _newLayer;
    }

    public void SetIsInit(final boolean _isInit) { isInit = _isInit; }

    @Override
    public void Init(SurfaceView _view) {
    }

    @Override
    public void Update() {
    }

    @Override
    public void Render(Canvas _canvas) {
    }
}
