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

package net.acardenas.wedding.backend;

import java.util.List;

import net.acardenas.wedding.dataservice.entity.Guest;

public interface GuestService
{
    /**
     * Create Guest to event.
     * @param aGuest {@link Guest}
     */
    void createGuest(Guest aGuest);
    
    /**
     * Get a guest from the data source given its Id.
     * @param anId User Id
     * @return {@code Guest}
     */
    Guest readGuest(Integer anId);
    
    /**
     * Get a List of Guests from the data source given a List of Id's. 
     * @param anIds List of Id s to give from the data source
     * @return {@code List<Guest>} 
     */
    List<Guest> readGuests(List<Integer> anIds);
    
    /**
     * Read All Guests Paging the retrieve queries.
     * @param aStart
     * @param aEnd
     * @return
     */
    List<Guest> readGuests(int aStart, int aEnd);
    
    /**
     * Update a guest as part of CRUD operations.
     * @param aGuest {@link Guest}
     * @return {@code Guest}
     */
    Guest updateGuest(Guest aGuest);
    
    /**
     * Remove Guest to the data source, consider as hard delete.
     * @param aGuest {@link Guest}
     */
    void deleteGuest(Guest aGuest);
    
    /**
     * Count the total of guests from the data source.
     * @return Number of guests into the data source.
     */
    int countTotalRecord();
    
    /**
     * Remove a selected guests.
     * @param aGuests array of Guests.
     */
    void deleteGuests(Guest[] aGuests);
}
