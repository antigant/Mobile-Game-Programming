package sidm.com.lab2week5;

import android.graphics.Canvas;
import android.view.SurfaceView;

import java.util.LinkedList;

public class EntityManager
{
    public static final EntityManager Instance = new EntityManager();
    private SurfaceView view = null;
    private LinkedList<EntityBase> entityList = new LinkedList<>();
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

    public void Update(float dt)
    {
        // Update Everything!
        for(EntityBase currEntity : entityList)
        {
            currEntity.Update(dt);

            if(currEntity.IsActive())
            {
                // We need to remove this!
                removalList.add(currEntity);
            }
        }

        RemoveEntity();

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
                        Collidable second = (Collidable) otherEntity;
                        // We got our 2 collideables! Check collision here!
                        if(Collision.SphereToSphere(first.GetPosition().x, first.GetPosition().y, first.GetRadius(), second.GetPosition().x, second.GetPosition().y, second.GetRadius()))
                        {
                            // COLLIDED! We notify the both of them
                            first.OnHit(second);
                            second.OnHit(first);
                        }
                    }
                }
            }
            if(currEntity.IsActive())
            {
                // We need to remove this!
                removalList.add(currEntity);
            }
        }
        RemoveEntity();

    }

    public void Render(Canvas _canvas)
    {
        // TODO render @ EntityManager
        for(EntityBase currEntity : entityList)
        {
            currEntity.Render(_canvas);
        }
    }

    private void RemoveEntity()
    {
        for (EntityBase currEntity : removalList)
            entityList.remove(currEntity);

        removalList.clear();
    }

    public void AddEntity(EntityBase _newEntity)
    {
        _newEntity.Init(view);
        entityList.add(_newEntity);
    }
}

