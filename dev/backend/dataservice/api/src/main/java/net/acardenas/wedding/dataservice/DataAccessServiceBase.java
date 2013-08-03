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
