package sidm.com.lab2week5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceView;

import java.util.Random;

public class SampleEntity implements EntityBase, Collidable
{
    private Bitmap bmp = null;
    boolean isDone = false;
    // Create a Vector2 class
    private float xPos, yPos, xDir, yDir, lifeTime;

    @Override
    public boolean IsDone()
    {
        return isDone;
    }

    @Override
    public void SetIsDone(boolean _isDone)
    {
        isDone = _isDone;
    }

    @Override
    public void Init(SurfaceView _view)
    {
        bmp = BitmapFactory.decodeResource(_view.getResources(), R.drawable.ship2_1);

        lifeTime = 5.0f;

        Random ranGen = new Random();

        // Init variables here
        xPos = ranGen.nextFloat() * _view.getWidth();
        yPos = ranGen.nextFloat() * _view.getHeight();

        xDir = ranGen.nextFloat() * 100.f - 50.f;
        yDir = ranGen.nextFloat() * 100.f - 50.f;
    }

    @Override
    public void Update(float dt)
    {
        lifeTime -= dt;

        xPos += xDir * dt;
        yPos += yDir * dt;

        // We will remove this object on click
        if(TouchManager.Instance.IsDown())
        {
            float imgRadius = bmp.getHeight() * 0.5f;
            // Check our collision here!
            if(Collision.SphereToSphere(TouchManager.Instance.GetPosX(), TouchManager.Instance.GetPosY(), 0.0f, xPos, yPos, imgRadius))
            {
                SetIsDone(true);
            }
        }
    }

    @Override
    public void Render(Canvas _canvas)
    {
        // Is to centralised the image
        _canvas.drawBitmap(bmp, xPos - bmp.getWidth() * 0.5f, yPos - bmp.getHeight() * 0.5f, null);

    }

    public static SampleEntity Create()
    {
        SampleEntity result = new SampleEntity();
        EntityManager.Instance.AddEntity(result);
        return result;
    }

    @Override
    public String GetType()
    {
        return "SampleEntity";
    }

    @Override
    public float GetPosX() {
        return xPos;

    }

    @Override
    public float GetPosY()
    {
        return yPos;
    }

    @Override
    public float GetRadius()
    {
        return bmp.getHeight() * 0.5f;
    }

    @Override
    public void OnHit(Collidable _other)
    {
        if(_other.GetType() == "SampleEntity")
        {
            SetIsDone(true);
        }
    }
}

