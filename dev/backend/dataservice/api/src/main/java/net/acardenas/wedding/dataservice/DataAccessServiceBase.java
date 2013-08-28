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

import javax.persistence.Query;

public interface DataAccessServiceBase<T>
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
     * @param T
     *            Object
     * @return
     */
    T create(T t);
    
    /**
     * Retrieves an entity instance that was previously persisted to the
     * database
     * 
     * @param T
     *            Object
     * @param id
     * @return
     */
    T find(Object id);
    
    /**
     * Removes the record that is associated with the entity instance
     * 
     * @param type
     * @param id
     */
    void delete(Object id);
    
    /**
     * Returns the number of records that meet the criteria
     * @param namedQueryName
     * @return List
     */
    public List<T> findWithNamedQuery(String namedQueryName);
    
    /**
     * Returns the number of records that will be used with lazy loading / pagination 
     * @param namedQueryName
     * @param start
     * @param end
     * @return List
     */
    public List<T> findWithNamedQuery(String namedQueryName, int start, int end);
    
    /**
     * Returns the number of total records
     * @param namedQueryName
     * @return int
     */
    public int countTotalRecord(String namedQueryName);

}
