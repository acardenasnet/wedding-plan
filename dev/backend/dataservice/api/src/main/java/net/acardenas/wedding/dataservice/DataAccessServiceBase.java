package net.acardenas.wedding.dataservice;

public interface DataAccessServiceBase<T>
{
    /**
     * Stores an instance of the entity class in the database
     * 
     * @param T
     *            Object
     * @return
     */
    public T create(T t);
    
    /**
     * Retrieves an entity instance that was previously persisted to the
     * database
     * 
     * @param T
     *            Object
     * @param id
     * @return
     */
    public T find(Object id);
}
