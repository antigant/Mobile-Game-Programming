package sidm.com.assignment1;

public interface Collidable
{
    String GetType();
    void SetType(String _type);
    Vector2 GetPosition();
    float GetRadius();
    void SetRadius(float _radius);

    void OnHit(Collidable _other);
    void SetAABB(Vector2 _maxAABB, Vector2 _minAABB);
    Vector2 GetMaxAABB();
    Vector2 GetMinAABB();
}
