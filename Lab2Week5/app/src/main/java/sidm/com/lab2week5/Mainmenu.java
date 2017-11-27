package sidm.com.lab2week5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.view.View.OnClickListener;

public class Mainmenu extends Activity implements OnClickListener
{
    // Define button as an object
    private Button btn_start;

    @Override // Annotation, ensure any sub class method to override properly
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Hide title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Hide top bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // This is using LAYOUTS!!! NOT WHAT WE WANT!
        setContentView(R.layout.mainmenu);
        //setContentView(new GameView(this));

        // Set Listener to button
        btn_start = (Button)findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
    }

    // Invoker a callback on clicked event on a view
    public void onClick(View v)
    {
        Intent intent = new Intent();

        if(v == btn_start)
            intent.setClass(this, SampleGame.class);

        startActivity(intent);
    }
}

