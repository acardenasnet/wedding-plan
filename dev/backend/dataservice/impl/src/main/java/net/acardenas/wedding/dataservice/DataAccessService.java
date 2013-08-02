package net.acardenas.wedding.dataservice;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.acardenas.wedding.dataservice.entity.User;

public abstract class DataAccessService<T> implements DataAccessServiceBase<T>
{

    @PersistenceContext
    private EntityManager entityManager;

    /** Constructor . */
    public DataAccessService()
    {
        
    }

    private Class<T> type;

    /**
     * Default constructor
     * 
     * @param aType
     *            entity class
     */
    public DataAccessService(Class<T> aType)
    {
        type = aType;
    }

    @Override
    public T create(T t)
    {
        this.entityManager.persist(t);
        this.entityManager.flush();
        this.entityManager.refresh(t);
        return t;
    }

    @Override
    public T find(Object id)
    {
        return this.entityManager.find(this.type, id);
    }

    /**
     * Removes the record that is associated with the entity instance
     * 
     * @param type
     * @param id
     */
    public void delete(Object id)
    {
        Object ref = this.entityManager.getReference(this.type, id);
        this.entityManager.remove(ref);
    }

    /**
     * Removes the number of entries from a table
     * 
     * @param <T>
     * @param items
     * @return
     */
    public boolean deleteItems(T[] items)
    {
        for (T item : items)
        {
            if (item instanceof User)
            {
                User user = (User) item;
                if (user.getId() == 1)
                {
                    continue;
                }
            }
            entityManager.remove(entityManager.merge(item));
        }
        return true;
    }

    /**
     * Updates the entity instance
     * 
     * @param <T>
     * @param t
     * @return the object that is updated
     */
    public T update(T item)
    {
        if (item instanceof User)
        {
            User user = (User) item;
            if (user.getId() == 1)
            {
                return item;
            }
        }
        return (T) this.entityManager.merge(item);

    }
}