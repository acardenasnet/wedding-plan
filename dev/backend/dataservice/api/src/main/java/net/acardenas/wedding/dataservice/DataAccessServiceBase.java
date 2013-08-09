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
}
