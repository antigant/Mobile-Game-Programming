package sidm.com.lab2week5;

public interface Collidable
{
    String GetType();
    void SetType(String _type);
    Vector2 GetPosition();
    float GetRadius();

    void OnHit(Collidable _other);
    void SetAABB(Vector2 _maxAABB, Vector2 _minAABB);
    Vector2 GetMaxAABB();
    Vector2 GetMinAABB();
}
