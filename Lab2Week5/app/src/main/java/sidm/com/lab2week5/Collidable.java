package sidm.com.lab2week5;

public interface Collidable
{
    String GetType();
    float GetPosX();
    float GetPosY();
    float GetRadius();

    void OnHit(Collidable _other);


}
