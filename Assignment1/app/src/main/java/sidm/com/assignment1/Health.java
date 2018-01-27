package sidm.com.assignment1;

public class Health
{
    private float health;
    private float maxHealth;

    public void SetMaxHealth(final float _maxHealth)
    {
        maxHealth = _maxHealth;
    }

    public void SetHealth(final float _health)
    {
        health = _health;
    }

    public void Init()
    {
        health = maxHealth;
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
