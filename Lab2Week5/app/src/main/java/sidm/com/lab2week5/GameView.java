package sidm.com.lab2week5;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView
{
    private SurfaceHolder holder = null;
    private UpdateThread updateThread = new UpdateThread(this);

    public GameView(Context _context)
    {
        super(_context);
        holder = getHolder();

        if(holder != null)
        {
            holder.addCallback(new SurfaceHolder.Callback() {
                @Override
                public void surfaceCreated(SurfaceHolder holder) {
                    // Setup out stuff
                    if(!updateThread.IsRunning())
                        updateThread.Initialize();

                    if(!updateThread.isAlive())
                        updateThread.start();
                }

                @Override
                public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                    // Do nothing here : UpdateThread will handle this

                }

                @Override
                public void surfaceDestroyed(SurfaceHolder holder) {
                     updateThread.Terminate();
                }
            });
        }
    }
}



/*import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

// A canvas to draw stuff
public class GameView extends SurfaceView
{
    private SurfaceHolder holder = null;
    private UpdateThread updateThread = new UpdateThread(this);

    // Base constructor
    public GameView(Context _context)
    {
        // super means get base class
        // Do what the base surface view will do to setup
        super(_context);
        holder = getHolder();

        if(holder != null)
        {
            holder.addCallback(new SurfaceHolder.Callback()
            {
                @Override
                public void surfaceCreated(SurfaceHolder holder)
                {
                    // INIT
                    if(!updateThread.IsRunning())
                        updateThread.Initialize();

                    // Kick start the thread if it is not alive
                    if(!updateThread.isAlive())
                        updateThread.start();
                }

                @Override
                public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
                {
                    // NOTHING TO DO HERE! :)
                }

                @Override
                public void surfaceDestroyed(SurfaceHolder holder)
                {
                    // CLEAN UP
                    updateThread.Terminate();
                }
            });
        }
    }
}*/

