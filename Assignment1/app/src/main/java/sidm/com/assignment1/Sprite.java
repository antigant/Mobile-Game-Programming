package sidm.com.assignment1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite
{
    private int row = 0;
    private int col = 0;
    private int width = 0;
    private int height = 0;

    private Bitmap bmp = null;

    private int currentFrame = 0;
    private int startFrame = 0;
    private int endFrame = 0;

    private float timePerFrame = 0.f;
    private float timeAcc = 0.f;

    public Sprite(Bitmap _bmp, int _row, int _col, int _fps)
    {
        bmp = _bmp;
        row = _row;
        col = _col;

        width = bmp.getWidth() / _col;
        height = bmp.getHeight() / _row;

        timePerFrame = 1.f / (float)_fps;

        endFrame = _col * _row;
    }

    public void Update(float dt)
    {
        timeAcc += dt;
        if(timeAcc > timePerFrame)
        {
            ++currentFrame;
            if(currentFrame >= endFrame)
                currentFrame = startFrame;
            timeAcc = 0.f;
        }
    }

    public void Render(Canvas _canvas, int x, int y)
    {
        int frameX = currentFrame % col;
        int frameY = currentFrame / col;
        int srcX = frameX * width;
        int srcY = frameY * height;

        x -= 0.5f * width;
        y -= 0.5f * height;

        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
        Rect dst = new Rect(x, y, x + width, y + height);
        _canvas.drawBitmap(bmp, src, dst, null);
    }

    public void SetAnimationFrames(int _start, int _end)
    {
        timeAcc = 0.f;
        currentFrame = _start;
        endFrame = _end;
    }

    final public int GetHeight()
    {
        return height;
    }

    final public int GetWidth()
    {
        return width;
    }
}
