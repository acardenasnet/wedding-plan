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

public interface DataAccessServiceBase<T, K>
{
    /**
     * Returns the type that is handled by this handler. This type is equal to
     * the type as specified in the generic part of this class. This method is
     * required runtime because the generic information is not available
     * anymore at that time.
     * 
     * @return the handled type.
     */
    Class<T> handles();
    
    /**
     * Stores an instance of the entity class in the database
     * 
     * @param T Object
     * @return
     */
    T create(T anEntity);
    
    /**
     * Retrieves an entity instance that was previously persisted to the
     * database
     * 
     * @param anId
     * @return
     */
    T find(K anId);
    
    /**
     * Removes the record that is associated with the entity instance
     * 
     * @param anId
     */
    void delete(K anId);
    
    /**
     * Updates the entity instance
     * 
     * @param <T>
     * @param anEntity
     * @return the object that is updated
     */
    public T update(T anEntity);    
    
    /**
     * Returns the number of records that meet the criteria
     * @param aNamedQueryName
     * @return List
     */
    public List<T> findWithNamedQuery(String aNamedQueryName);
    
    /**
     * Returns the number of records that will be used with lazy loading / pagination 
     * @param aNamedQueryName
     * @param start
     * @param end
     * @return List
     */
    public List<T> findWithNamedQuery(String aNamedQueryName, int start, int end);
    
    /**
     * Returns the number of total records
     * @param aNamedQueryName
     * @return int
     */
    public int countTotalRecord(String aNamedQueryName);

}
