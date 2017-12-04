package sidm.com.lab2week5;

public interface Collidable
{
    String GetType();
    void SetType(String _type);
    Vector2 GetPosition();
    float GetRadius();

    void OnHit(Collidable _other);
}
