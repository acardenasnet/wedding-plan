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

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.CacheRetrieveMode;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import net.acardenas.wedding.dataservice.entity.User;

public abstract class DataAccessService<T, K> 
    implements DataAccessServiceBase<T, K>
{

    private EntityManager entityManager;
    
    private Logger LOG = Logger.getLogger(DataAccessService.class.getName());

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
//        entityManager.setProperty("javax.persistence.cache.retrieveMode", CacheRetrieveMode.USE);
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
    public T find(K id)
    {
        return this.entityManager.find(handles(), id);
    }

    @Override
    public void delete(K id)
    {
        T ref = this.entityManager.getReference(handles(), id);
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

    @Override
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
    
    @Override
    public List<T> findWithNamedQuery(String namedQueryName) 
    {
        LOG.info("findWithNamedQuery - " + namedQueryName );
        return entityManager.createNamedQuery(namedQueryName,handles()).getResultList();
    }    

    /**
     * Returns the number of records with result limit
     * @param queryName
     * @param resultLimit
     * @return List
     */
    public List<T> findWithNamedQuery(String queryName, int resultLimit) 
    {
        return this.entityManager.createNamedQuery(queryName, handles()).
                setMaxResults(resultLimit).
                getResultList();
    }    
    
    /**
     * Returns the number of records that will be used with lazy loading / pagination 
     * @param namedQueryName
     * @param start
     * @param end
     * @return List
     */
    public List<T> findWithNamedQuery(String namedQueryName, 
            int start, int end) 
    {
        TypedQuery<T> query = entityManager.createNamedQuery(namedQueryName, handles());
        query.setMaxResults(end - start);
        query.setFirstResult(start);
        return query.getResultList();
    }
    
    @Override
    public int countTotalRecord(String namedQueryName) 
    {
        Query query = entityManager.createNamedQuery(namedQueryName);
        Number result = (Number) query.getSingleResult();
        return result.intValue();
    }    
}