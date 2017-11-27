package sidm.com.lab2week5;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceView;

// Game instance (Put all game variables in here)
public class SampleGame
{
    public final static SampleGame Instance = new SampleGame();

    private Bitmap bmp;
    float offset = 0.0f;

    // This is to not allow anyone else to create another game
    private SampleGame()
    {

    }

    public void Update(float _deltaTime)
    {
        offset += _deltaTime;
    }

    public void Init(SurfaceView _view)
    {
        bmp = BitmapFactory.decodeResource(_view.getResources(), R.drawable.ship2_1);
    }

    public void Render(Canvas _canvas)
    {
        int currOffset = (int)(offset * 100.0f);
        _canvas.drawBitmap(bmp, (10 + currOffset) % 500, 10, null);
    }
}

/*import android.graphics.Canvas;
import android.view.SurfaceView;

public class SampleGame
{
    public final static SampleGame Instance = new SampleGame();

    private SampleGame()
    {

    }

    public void Init(SurfaceView _view)
    {

    }

    public void Update (float _deltaTime)
    {

    }

    protected void Render(Canvas _canvas)
    {

    }
}*/
