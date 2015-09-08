// ---------------------------------------------------------------------------
// COPYRIGHT Alejandro Cardenas, acardenas.net, Saltillo,Coah, MX 2013
// All rights reserved.
//
// The Copyright to the computer program(s) herein is the property of
// Alejandro Raul Cardenas
// The program(s) may be used and/or copied only with the written
// permission from Alejandro Cardenas, or in
// accordance with the terms and conditions stipulated in the
// agreement/contract under which the program(s) have been supplied.
// ---------------------------------------------------------------------------

package net.acardenas.wedding.dataservice;

import javax.persistence.EntityManager;

import net.acardenas.wedding.dataservice.entity.User;

public abstract class DataAccessService<T> implements DataAccessServiceBase<T>
{

    private EntityManager entityManager;

    /** Constructor . */
    public DataAccessService()
    {
        
    }
    
    public EntityManager getEntityManager()
    {
        return entityManager;
    }

    public void setEntityManager(EntityManager anEntityManager)
    {
        entityManager = anEntityManager;
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
        return this.entityManager.find(handles(), id);
    }

    /**
     * Removes the record that is associated with the entity instance
     * 
     * @param type
     * @param id
     */
    public void delete(Object id)
    {
        Object ref = this.entityManager.getReference(handles(), id);
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