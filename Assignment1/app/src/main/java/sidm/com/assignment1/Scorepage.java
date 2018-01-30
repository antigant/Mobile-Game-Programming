package sidm.com.assignment1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;
import com.facebook.share.ShareApi;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareButton;

import java.util.Arrays;
import java.util.List;

public class Scorepage extends Activity implements OnClickListener
{
    private Button btn_back;

    // Facebook UI
    private Button btn_fbLogin;
    private Button btn_sharescore; // Define in xml

    boolean loggedIn = false;
    private CallbackManager callbackManager;
    private LoginManager loginManager;

    ProfilePictureView profilePicture;

    int highscore = 0;

    List<String> PERMISSIONS = Arrays.asList("publish_actions"); // used by the login manager to identify to facebook a user login

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Init for FB content use
        FacebookSdk.setApplicationId(getString(R.string.app_id));
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(R.layout.scorepage);

        // Get highscore
        highscore = GameSystem.Instance.GetIntFromSave("highscore");

        // Define for back button
        btn_back = (Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);

        // Define FB login button which is from FB SDK widget
        btn_fbLogin = (LoginButton)findViewById(R.id.fb_login_button);
        btn_fbLogin.setOnClickListener(this);

        // The share button
        btn_sharescore = (Button)findViewById(R.id.btn_sharescore);
        btn_sharescore.setOnClickListener(this);

        // Define profile picutre to be displayed
        profilePicture = (ProfilePictureView)findViewById(R.id.picture);
        callbackManager = CallbackManager.Factory.create();


        AccessTokenTracker accessTokenTracker = new AccessTokenTracker()
        {
            @Override
            protected void onCurrentAccessTokenChanged(
                    AccessToken oldAccessToken,
                    AccessToken currentAccessToken) {

                if (currentAccessToken == null){
                    //User logged out
                    profilePicture.setProfileId("");
                }
                else{
                    profilePicture.setProfileId(Profile.getCurrentProfile().getId());
                }
            }
        };
        accessTokenTracker.startTracking();

        loginManager = LoginManager.getInstance();
        loginManager.logInWithPublishPermissions(this, PERMISSIONS);

        loginManager.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                profilePicture.setProfileId(Profile.getCurrentProfile().getId());
                // Call method to share score -- TBD
                shareScore();
            }

            @Override
            public void onCancel() {
                System.out.println("Login attempt cancelled");
                // Or print text on your screen using Paint()
            }

            @Override
            public void onError(FacebookException error) {
                System.out.println("Login attempt failed");
                // Or print text on your screen using Paint()

            }
        });
    }

    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent();
        if(v == btn_back)
        {
            intent.setClass(this, Mainmenu.class);
            startActivity(intent);
        }
        else if (v == btn_sharescore)
        {
            AlertDialog.Builder alert_builder = new AlertDialog.Builder(Scorepage.this);
            alert_builder.setTitle("Share your score on Facebook?");
            alert_builder.setMessage("Do you want to share your score of " + String.valueOf(highscore))
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            shareScore();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });


            alert_builder.show();
        }
    }

    // New - Share score onto Facebook
    public void shareScore() {
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round); // The post on FB will have your app icon

        SharePhoto photo = new SharePhoto.Builder()
                .setBitmap(image)
                .setCaption("Thank you for playing Spaceshooter! Your highscore is " + highscore)
                .build();

        // Share it out
        SharePhotoContent content = new SharePhotoContent.Builder()
                .addPhoto(photo)
                .build();

        ShareApi.share(content, null);

    }

    // FB to use the callback Manager to manage login
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        //finish();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        //finish();
        super.onStop();
    }
}

