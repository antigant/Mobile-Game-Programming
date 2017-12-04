package sidm.com.lab2week5;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;

// WE WILL HAVE OUR GAME LOOP!!!!
public class UpdateThread extends Thread
{
    static final long targetFPS = 60;
    private GameView view = null;
    private SurfaceHolder holder = null;
    private boolean isRunning = false;

    public UpdateThread(GameView _view)
    {
        view = _view;
        holder = _view.getHolder();

        // THIS IS WHERE WE SHOULD INIT OUR GAME STUFF
        // TODO : Hahaha so cool right :D

        // TODO: REMEMBER TO FIRST INIT THE SCENE (FOR MC)
//        SampleGame.Instance.Init(_view);
        SceneManager.Instance.SetGameView(_view);
        AddScene();
    }

    public boolean IsRunning()
    {
        return isRunning;
    }

    public void Initialize()
    {
        isRunning = true;
    }

    public void Terminate()
    {
        isRunning = false;
    }

    private void AddScene()
    {
        // Init all the scene in this function, any changes just change here can alr
        SceneManager.Instance.AddState("SampleGame", SampleGame.Instance);
    }

    @Override
    public void run()
    {
        // Start up stuff
        long framePerSecond = 1000 / targetFPS; // 1000 is in milliseconds
        long startTime = 0;

        // We need another variable to calculate delta time
        long prevTime = System.nanoTime();

        while(IsRunning())
        {
            // Update
            startTime = System.currentTimeMillis();

            // This part is to get delta time using prev time vs curr time
            long currTime = System.nanoTime();
            float deltaTime = (float)((currTime - prevTime) / 1000000000.0f); // to convert it back to seconds from nanoseconds
            prevTime = currTime;

            // We wanna have this awesome update ^_^
//            SampleGame.Instance.Update(deltaTime);
            SceneManager.Instance.Update(deltaTime);

            // Render
            Canvas canvas = holder.lockCanvas(null);
            if(canvas != null)
            {
                // We have canvas, we render! :D
                synchronized (holder) // Toilet, Lock (respectively)
                {
                    // Only one may be in here!!! We draw
                    canvas.drawColor(Color.WHITE);

                    // Can think of canvas as the buffer
                    // Render our other stuff here
//                    SampleGame.Instance.Render(canvas);

                    SceneManager.Instance.Render(canvas);
                }

                // This is the part dat du de renders!
                holder.unlockCanvasAndPost(canvas);
            }

            // Post Update/Render
            try
            {
                long sleepTime = framePerSecond - (System.currentTimeMillis() - startTime);

                if(sleepTime > 0)
                    sleep(sleepTime);
            }
            catch(InterruptedException e)
            {
                Terminate();
            }
        }
    }
}
