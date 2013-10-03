package net.acardenas.wedding.backend;

import java.util.List;

import net.acardenas.wedding.dataservice.entity.Guest;

public interface CrudServiceBase <E, K>
{
    /**
     * Create E to event.
     * @param anEntity {@link E}
     */
    void create(E anEntity);
    
    /**
     * Get a guest from the data source given its Id.
     * @param anId User Id
     * @return {@code Guest}
     */
    E read(K anId);
    
    /**
     * Get a List of Guests from the data source given a List of Id's. 
     * @param anIds List of Id s to give from the data source
     * @return {@code List<E>} 
     */
    List<E> read(List<K> anIds);
    
    /**
     * Read All Guests Paging the retrieve queries.
     * @param aStart
     * @param aEnd
     * @return
     */
    List<E> read(int aStart, int aEnd);
    
    /**
     * Update a guest as part of CRUD operations.
     * @param anEntity {@link Guest}
     * @return {@code Guest}
     */
    E update(E anEntity);
    
    /**
     * Remove Guest to the data source, consider as hard delete.
     * @param anEntity {@link Guest}
     */
    void delete(E anEntity);
    
    /**
     * Remove a selected guests.
     * @param anEntity array of Guests.
     */
    void delete(E[] anEntity);
    
    /**
     * Count the total of guests from the data source.
     * @return Number of guests into the data source.
     */
    int countTotalRecord();
}
