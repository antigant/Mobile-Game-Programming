package sidm.com.assignment1;

import android.graphics.Canvas;
import android.view.SurfaceView;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class EntityManager
{
    public static final EntityManager Instance = new EntityManager();
    private SurfaceView view = null;
    // Main list to update it
    private LinkedList<EntityBase> entityList = new LinkedList<>();
    // List to add entity after first frame
    private LinkedList<EntityBase> additionalList = new LinkedList<>();
    // List to remove entity
    private LinkedList<EntityBase> removalList = new LinkedList<>();


    private EntityManager()
    {
    }
    // This is only called one
    // At the start of our game update thread!
    // Cannot be used to init our objects
    public void Init(SurfaceView _view)
    {
        view = _view;
    }

    public void Update()
    {
        // Add entity into entity list
        AdditionalEntity();

        // Update Everything!
        for(EntityBase currEntity : entityList)
        {
            if(!currEntity.GetIsInit())
                currEntity.Init(view);

            currEntity.Update();

            if(!currEntity.IsActive())
            {
                // We need to remove this!
                removalList.add(currEntity);
            }
        }

        RemoveEntity();
        AdditionalEntity();

        for(int i = 0; i < entityList.size(); ++i)
        {
            EntityBase currEntity = entityList.get(i);

            // to check if the entity is collidable
            if(currEntity instanceof Collidable)
            {
                Collidable first = (Collidable) currEntity;

                for(int j = i + 1; j < entityList.size(); ++j)
                {
                    EntityBase otherEntity = entityList.get(j);

                    if(otherEntity instanceof Collidable)
                    {
                        Collidable second = (Collidable) otherEntity; // type casting
                        // We got our 2 collideables! Check collision here!
                        if(Collision.SphereToSphere(first.GetPosition().x, first.GetPosition().y, first.GetRadius(), second.GetPosition().x, second.GetPosition().y, second.GetRadius()))
                        {
                            GameObject first1 = (GameObject) first;
                            GameObject second2 = (GameObject) second;

//                            if(Collision.CheckAABBCollision(first1, second2))
//                            {
                                // COLLIDED! We notify the both of them
                                first.OnHit(second);
                                second.OnHit(first);
//                            }
                        }
                    }
                }
            }
            if(!currEntity.IsActive())
            {
                // We need to remove this!
                removalList.add(currEntity);
            }
        }
        RemoveEntity();
    }

    public void Render(Canvas _canvas)
    {
        // We will use the new "rendering layer" to sort the render order
        Collections.sort(entityList, new Comparator<EntityBase>() {
            @Override
            public int compare(EntityBase o1, EntityBase o2) {
                return o1.GetRenderLayer() - o2.GetRenderLayer();
            }
        });

        // TODO render @ EntityManager
        for(EntityBase currEntity : entityList)
        {
            if(!currEntity.IsRender()) // Check if the current entity needs to be rendered
                continue;
            if(currEntity.GetIsInit()) // Check if the entity has been initialised
                currEntity.Render(_canvas);
        }
    }

    private void RemoveEntity()
    {
        for (EntityBase currEntity : removalList)
            entityList.remove(currEntity);
        removalList.clear();
    }

    private void AdditionalEntity()
    {
        for(EntityBase currEntity : additionalList)
            entityList.add(currEntity);
        additionalList.clear();
    }

    public void AddEntity(EntityBase _newEntity)
    {
        additionalList.add(_newEntity);
    }
}

