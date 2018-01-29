package sidm.com.assignment1;

public abstract class Enemy extends GameObject
{
    protected Health health = new Health();
    protected Weapon weapon = null;
    protected boolean isDead = false;
    protected int dmg = 0;
    protected int score = 0;

    public void AddHealth(final int amt)
    {
        health.AddHealth(amt);
        if(health.GetHealth() <= 0.f)
            SetIsDead(true);
    }

    // Getter
    final public boolean GetIsDead() { return isDead; }
    final public Weapon GetWeapon() { return weapon; }
    final public int GetDamage() { return dmg; }
    final public Health GetHealth() { return health; }
    final public int GetScore() { return score; }

    // Setter
    public void SetIsDead(final boolean _isDead) { isDead = _isDead; }
    public void SetWeapon(final Weapon _weapon) { weapon = _weapon; }
    public void SetDamage(final int _dmg) { dmg = _dmg; }
    public void SetScore(final int _score) { score = _score; }

    @Override
    public int GetRenderLayer() { return LayerConstants.GAMEOBJECTS_LAYER; }
}

