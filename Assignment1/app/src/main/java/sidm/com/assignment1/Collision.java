package sidm.com.assignment1;


public class Collision
{
    public static boolean SphereToSphere(float x1, float y1, float radius1, float x2, float y2, float radius2)
    {
        // Get distance squared
        float xVec = x2 - x1;
        float yVec = y2 - y1;
        float distSquared = xVec * xVec + yVec * yVec;

        // Get radius squared
        float rSquared = radius1 + radius2;
        rSquared *= rSquared;

        // Compare, if dist greater than radius -> no collision
        if(distSquared > rSquared)
            return false;

        return true;
    }

    private static boolean CheckOverLap(Vector2 thisMinAABB, Vector2 thisMaxAABB, Vector2 thatMinAABB, Vector2 thatMaxAABB)
    {
        // Check if this object is overlapping that object
        if (thatMinAABB.TwoVectorGreaterEqual(thisMinAABB)  && thatMinAABB.TwoVectorLesserEqual(thisMaxAABB)
                || thatMaxAABB.TwoVectorGreaterEqual(thisMinAABB) && thatMaxAABB.TwoVectorLesserEqual(thisMaxAABB))
            return true;

        // Check if that object is overlapping this object
        if (thisMinAABB.TwoVectorGreaterEqual(thatMinAABB) && thisMinAABB.TwoVectorLesserEqual(thatMaxAABB)
                || thisMaxAABB.TwoVectorGreaterEqual(thatMinAABB) && thisMaxAABB.TwoVectorLesserEqual(thatMaxAABB))
            return true;

        // Check if this object is within that object
        if (thisMinAABB.TwoVectorGreaterEqual(thatMinAABB)  && thisMinAABB.TwoVectorLesserEqual(thatMaxAABB)
                && thisMaxAABB.TwoVectorGreaterEqual(thatMinAABB) && thisMaxAABB.TwoVectorLesserEqual(thatMaxAABB))
            return true;

        // Check if that object is within this object
        if (thatMinAABB.TwoVectorGreaterEqual(thisMinAABB) && thatMinAABB.TwoVectorLesserEqual(thisMaxAABB)
                && thatMaxAABB.TwoVectorGreaterEqual(thisMinAABB)  && thatMaxAABB.TwoVectorLesserEqual(thisMaxAABB))
            return true;

        return false;
    }

    public static boolean CheckAABBCollision(GameObject thisGO, GameObject thatGO)
    {
        Vector2 thisMinAABB = thisGO.GetPosition().Add(thisGO.GetMinAABB());
        Vector2 thisMaxAABB = thisGO.GetPosition().Add(thisGO.GetMaxAABB());
        Vector2 thatMinAABB = thatGO.GetPosition().Add(thatGO.GetMinAABB());
        Vector2 thatMaxAABB = thatGO.GetPosition().Add(thatGO.GetMaxAABB());

        // Check for overlap
        if(CheckOverLap(thisMinAABB, thisMaxAABB, thatMinAABB, thatMaxAABB))
            return true;
        return false;
    }

    public static boolean CheckPointAABB(Vector2 position, GameObject go)
    {
        return (position.x <= go.GetMaxAABB().x && position.x >= go.GetMinAABB().x)
                && (position.y <= go.GetMaxAABB().y && position.y >= go.GetMinAABB().y);
    }
}
