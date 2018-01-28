package sidm.com.assignment1;

public abstract class Enemy extends GameObject
{
    protected Health health = new Health();
    protected Weapon weapon = null;
    protected boolean isDead = false;
    protected float dmg = 0f;
    protected float score = 0f;

    public void AddHealth(final float amt)
    {
        health.AddHealth(amt);
        if(health.GetHealth() <= 0.f)
            SetIsDead(true);
    }

    // Getter
    final public boolean GetIsDead() { return isDead; }
    final public Weapon GetWeapon() { return weapon; }
    final public float GetDamage() { return dmg; }
    final public Health GetHealth() { return health; }
    final public float GetScore() { return score; }

    // Setter
    public void SetIsDead(final boolean _isDead) { isDead = _isDead; }
    public void SetWeapon(final Weapon _weapon) { weapon = _weapon; }
    public void SetDamage(final float _dmg) { dmg = _dmg; }
    public void SetScore(final float _score) { score = _score; }

    @Override
    public int GetRenderLayer() { return LayerConstants.GAMEOBJECTS_LAYER; }
}

