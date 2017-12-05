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

    final boolean IsGreater(float a, float b)
    {
        return (a > b - EPSILON);
    }

    final Boolean IsGreaterEqual(float a, float b)
    {
        return IsGreater(a, b) || IsEqual(a, b);
    }

    final boolean IsLesser(float a, float b)
    {
        return (a < b + EPSILON);
    }

    final boolean IsLesserEqual(float a, float b)
    {
        return IsLesser(a, b) || IsEqual(a, b);
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

    // Greater than or equals to >=
    final boolean TwoVectorGreaterEqual(final Vector2 rhs)
    {
        return IsGreaterEqual(x, rhs.x) && IsGreaterEqual(y, rhs.y);
    }

    // Greater than >
    final boolean TwoVectorGreat(final Vector2 rhs)
    {
        return IsGreater(x, rhs.x) && IsGreater(y, rhs.y);
    }

    // Lesser than or equals to <=
    final boolean TwoVectorLesserEqual(final Vector2 rhs)
    {
        return IsLesserEqual(x, rhs.x) && IsLesserEqual(y, rhs.y);
    }

    // Lesser than <
    final boolean TwoVectorLesser(final Vector2 rhs)
    {
        return IsLesser(x, rhs.x) && IsLesser(y, rhs.y);
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

    final boolean IsGreater(float a , float b)
    {
        return (a > b - EPSILON);
    }
    final boolean IsLesser(float a ,float b)
    {
        return (a < b + EPSILON);
    }
//    bool operator==( const Vector3& rhs ) const; //Equality check
//    bool operator!= ( const Vector3& rhs ) const; //Inequality check
//    bool operator>=(const Vector3& rhs) const;	// Check if LHS is >= RHS
//    bool operator>(const Vector3& rhs) const;	// Check if LHS is > RHS
//    bool operator<=(const Vector3& rhs) const;	// Check if LHS is <= RHS
//    bool operator<(const Vector3& rhs) const;	// Check if LHS is < RHS

}

