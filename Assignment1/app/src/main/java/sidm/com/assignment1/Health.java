package sidm.com.assignment1;

public class Health
{
    private float health, maxHealth;

    public void SetMaxHealth(final float _maxHealth)
    {
        maxHealth = _maxHealth;
        health = _maxHealth;
    }

    public void AddHealth(float amt)
    {
        health += amt;
    }

    public final float GetHealth()
    {
        return health;
    }
}
