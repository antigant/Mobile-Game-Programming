package sidm.com.lab2week5;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.Display;
import android.view.SurfaceView;

public class PlayButton extends Button
{

    @Override
    public void Init(SurfaceView _view)
    {
        this.SetName("Play");
        this.SetType("button");
        this.SetIsActive(true);
        this.SetBitmap(_view,R.drawable.start );
        //SetScale(new Vector2(0.3f,0.3f));
        //_view.getWidth();
        //_view.getMeasuredWidth();
    }

    @Override
    public void Update(float dt)
    {
        if (this.GetIsClick()==true)
        {
            SceneManager.Instance.SetNextState("SampleGame");
        }
    }

    @Override
    public void Render(Canvas _canvas)
    {
        //set position
        this.SetPosition(new Vector2(_canvas.getWidth() * 0.5f,_canvas.getHeight() * 0.7f));
        //draws the image
        //bmp is the image
        //this.SetScale(new Vector2 (_canvas.getWidth(),_canvas.getHeight()));
        _canvas.drawBitmap(bmp, GetPosition().x - bmp.getWidth() * 0.5f, GetPosition().y - bmp.getHeight() * 0.5f, null);
//        _canvas.drawBitmap(bmp,bmp.getWidth() * 0.5f,bmp.getHeight() * 0.5f, null);

        //Matrix transform;
        //transform.
    }

    @Override
    public GameObject Create()
    {
        PlayButton result = new PlayButton();
        EntityManager.Instance.AddEntity(result);
        return result;
    }
}
