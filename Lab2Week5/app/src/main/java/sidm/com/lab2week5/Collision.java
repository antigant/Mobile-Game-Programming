package sidm.com.lab2week5;


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

//    public static boolean CheckOverlap(Vector2 thisMinAABB, Vector2 thisMaxAABB, Vector2 thatMinAABB, Vector2 thatMaxAABB)
//    {
//        // Check if this object is overlapping that object
//        if (thatMinAABB >= thisMinAABB && thatMinAABB <= thisMaxAABB
//                ||
//                thatMaxAABB >= thisMinAABB && thatMaxAABB <= thisMaxAABB)
//            return true;
//
//        // Check if that object is overlapping this object
//        if (thisMinAABB >= thatMinAABB && thisMinAABB <= thatMaxAABB
//                ||
//                thisMaxAABB >= thatMinAABB && thisMaxAABB <= thatMaxAABB)
//            return true;
//
//        // Check if this object is within that object
//        if (thisMinAABB >= thatMinAABB && thisMinAABB <= thatMaxAABB
//                &&
//                thisMaxAABB >= thatMinAABB && thisMaxAABB <= thatMaxAABB)
//            return true;
//
//        // Check if that object is within this object
//        if (thatMinAABB >= thisMinAABB && thatMinAABB <= thisMaxAABB
//                &&
//                thatMaxAABB >= thisMinAABB && thatMaxAABB <= thisMaxAABB)
//            return true;
//
//        return false;
//    }
//    // Check if this entity collided with another entity, but both must have collider
//    public static boolean AABB(EntityBase ThisEntity, EntityBase ThatEntity)
//    {
//        Vector2 thisMinAABB =ThisEntity
//    }

//{
//    // Get the colliders for the 2 entties
//    CCollider *thisCollider = dynamic_cast<CCollider*>(ThisEntity);
//    CCollider *thatCollider = dynamic_cast<CCollider*>(ThatEntity);
//
//    // Get the minAABB and maxAABB for each entitiy
//    Vector3 thisMinAABB = ThisEntity->GetPosition() + thisCollider->GetMinAABB();
//    Vector3 thisMaxAABB = ThisEntity->GetPosition() + thisCollider->GetMaxAABB();
//    Vector3 thatMinAABB = ThatEntity->GetPosition() + thatCollider->GetMinAABB();
//    Vector3 thatMaxAABB = ThatEntity->GetPosition() + thatCollider->GetMaxAABB();
//
//    // Check for overlap
//    if (CheckOverlap(thisMinAABB, thisMaxAABB, thatMinAABB, thatMaxAABB))
//        return true;
//
//    // if AABB collision check fails, then we need to check the other corners of the bounding boxes to
//    // do more collision checks with other points on each bounding box
//
//    //Vector3 altThisMinAABB, altThisMaxAABB;
//    //altThisMaxAABB.Set(thisMaxAABB.x - thisCollider->GetMaxAABB().x, thisMaxAABB.y - thisCollider->GetMaxAABB().y, thisMaxAABB.z - thisCollider->GetMaxAABB().z);
//    //altThisMinAABB.Set(thisMinAABB.x - thisCollider->GetMinAABB().x, thisMinAABB.y - thisCollider->GetMinAABB().y, thisMinAABB.z - thisCollider->GetMinAABB().z);
//
//    Vector3 altXThisMinAABB, altXThisMaxAABB, altYThisMinAABB, altYThisMaxAABB, altZThisMinAABB, altZThisMaxAABB;
//    altXThisMinAABB.Set(thisMaxAABB.x, thisMinAABB.y, thisMinAABB.z);
//    altXThisMaxAABB.Set(thisMinAABB.x, thisMaxAABB.y, thisMaxAABB.z);
//
//    altYThisMinAABB.Set(thisMinAABB.x, thisMaxAABB.y, thisMinAABB.z);
//    altYThisMaxAABB.Set(thisMaxAABB.x, thisMinAABB.y, thisMaxAABB.z);
//
//    altZThisMinAABB.Set(thisMinAABB.x, thisMinAABB.y, thisMaxAABB.z);
//    altZThisMaxAABB.Set(thisMaxAABB.x, thisMaxAABB.y, thisMinAABB.z);
//    // Check for overlap
//    if (CheckOverlap(altXThisMinAABB, altXThisMaxAABB, thatMinAABB, thatMaxAABB))
//        return true;
//    if (CheckOverlap(altYThisMinAABB, altYThisMaxAABB, thatMinAABB, thatMaxAABB))
//        return true;
//    if (CheckOverlap(altZThisMinAABB, altZThisMaxAABB, thatMinAABB, thatMaxAABB))
//        return true;
//
//    return false;
//}

}
