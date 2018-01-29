package sidm.com.assignment1;

public class Health
{
    private int health;
    private int maxHealth;

    public void SetMaxHealth(final int _maxHealth)
    {
        maxHealth = _maxHealth;
    }

    public void SetHealth(final int _health)
    {
        health = _health;
    }

    public void Init()
    {
        health = maxHealth;
    }

    public void AddHealth(int amt)
    {
        health += amt;
        if(health >= maxHealth)
            health = maxHealth;
    }

    public final int GetHealth()
    {
        return health;
    }
}
