package sidm.com.assignment1;

public class Health
{
    private float health, maxHealth;

    public void SetMaxHealth(final float maxHealth)
    {
        this.maxHealth = maxHealth;
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
