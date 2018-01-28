package sidm.com.assignment1;

import android.view.SurfaceView;

import java.util.Random;

public class PowerUpManager
{
    public final static PowerUpManager Instance = new PowerUpManager();

    private float time = 0;
    private float fixTime = 20f; // Time to spawn a power up
    Random rand = new Random(); // rand.nextInt(40) returns random number from 0 - 39
    private int randNumber = 0;
    SurfaceView view = null;

    private float powerupTime = 0;
    private float fixPowerUpTime;
    private boolean poweredUp = false;
    private String powerupType = "no powerup";

    // Private constructor :- Disable anyone from creating another PowerUpGenerator
    private PowerUpManager() {}

    // Setters
    public void SetSurfaceView(SurfaceView _view) { view = _view; }
    public void SetfixPowerUpTime(final float _fixPowerUpTime) { fixPowerUpTime = _fixPowerUpTime; }
    public void SetPoweredUp(final boolean _poweredUp) { poweredUp = _poweredUp; }
    public void SetPowerupType(final String _powerupType) { powerupType = _powerupType; }

    public void Update()
    {
        time += Time.deltaTime;
        if(poweredUp)
            powerupTime += Time.deltaTime;
        if(time > fixTime)
        {   // Start spawning power ups!
            time -= fixTime;
//            randNumber = rand.nextInt(2);
            if(randNumber == 0)
            {
                BulletPowerUp powerup = new BulletPowerUp();
                powerup.Init(view);
                EntityManager.Instance.AddEntity(powerup);
            }
        }

        if(powerupTime >= fixPowerUpTime)
        {
            powerupTime -= fixPowerUpTime;
            if(powerupType == "Weapon")
            {
                Weapon weapon = Player.Instance.GetWeapon();
                weapon.Reset();
            }
            powerupType = "no power up";
        }
    }
}
