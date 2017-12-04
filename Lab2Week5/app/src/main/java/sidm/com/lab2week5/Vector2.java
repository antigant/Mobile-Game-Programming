package sidm.com.lab2week5;

public class Vector2
{
    public float x = 0.f, y = 0.f;
    private float EPSILON = 0.00001f;  ///Used for error checking

    final boolean IsEqual(float a, float b)
    {
        return a - b <= EPSILON && b - a <= EPSILON;
    }

    Vector2(float a, float b)
    {
        x = a;
        y = b;
    }

    Vector2(final Vector2 rhs)
    {
        x = rhs.x;
        y = rhs.y;
    }

    void Set( float a, float b)
{
    x = a;
    y = b;
}

    void SetZero()
{
    x = y = 0.0f;
}

    final boolean IsZero()
    {
        return IsEqual(x, 0.f) && IsEqual(y, 0.f);
    }

    final Vector2 AddCopy(final Vector2 rhs)
    {
        return new Vector2(x + rhs.x, y + rhs.y);
    }

    Vector2 Add(final Vector2 rhs)
    {
        x += rhs.x;
        y += rhs.y;
        return this;
    }

    final Vector2 MinusCopy(final Vector2 rhs)
    {
        return new Vector2(x - rhs.x, y - rhs.y);
    }

    Vector2 Minus(final Vector2 rhs)
    {
        x -= rhs.x;
        y -= rhs.y;
        return this;
    }

    final Vector2 NegativeVector()
    {
        return new Vector2(-x, -y);
    }

    final Vector2 MultiplyCopy(float scalar)
    {
        return new Vector2(scalar * x, scalar * y);
    }

    Vector2 Multiply(float scalar)
    {
        x *= scalar;
        y *= scalar;
        return this;
    }

    final boolean TwoVectorEqual(final Vector2 rhs)
    {
        return IsEqual(x, rhs.x) && IsEqual(y, rhs.y);
    }

    final boolean TwoVectorNotEqual (final Vector2 rhs)
    {
        return !IsEqual(x, rhs.x) || !IsEqual(y, rhs.y);
    }

    Vector2 Assignment(final Vector2 rhs)
    {
        x = rhs.x;
        y = rhs.y;
        return this;
    }

    final float Length()
    {
        return (float)Math.sqrt(x * x + y * y);
    }

    final float LengthSquared ()
    {
        return x * x + y * y;
    }

    final float Dot(final Vector2 rhs)
    {
        return x * rhs.x + y * rhs.y;
    }

    final Vector2 Normalized() throws DivideByZero
    {
        float d = Length();
        if(d <= EPSILON && -d <= EPSILON)
            throw new DivideByZero();
        return new Vector2(x / d, y / d);
    }

    Vector2 Normalize() throws DivideByZero
    {
        float d = Length();
        if(d <= EPSILON && -d <= EPSILON)
            throw new DivideByZero();
        x /= d;
        y /= d;
        return this;
    }

    Vector2 MultiplyTwoVector(float scalar, final Vector2 rhs)
    {
        return new Vector2(rhs.x * scalar, rhs.y * scalar);
    }

}

