package sidm.com.assignment1;

public abstract class PowerUp extends GameObject
{
    protected float lifeTime;
    protected Vector2 checkPos = new Vector2(-1000f, -1000f);

    // Getters
    final public float GetLifeTime() { return lifeTime; }

    // Setters
    public void SetLifeTime(final float _lifeTime) { lifeTime = _lifeTime; }
}

