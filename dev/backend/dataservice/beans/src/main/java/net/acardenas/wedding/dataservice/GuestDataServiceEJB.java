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

import net.acardenas.wedding.dataservice.entity.Guest;

/**
 * @author acardenas
 *
 */
public class GuestDataServiceEJB implements GuestDataService
{

    private GuestDataService delegate;
    
    /** Constructor. */
    public GuestDataServiceEJB()
    {
        // empty
    }

    /* (non-Javadoc)
     * @see net.acardenas.wedding.dataservice.DataAccessServiceBase#handles()
     */
    @Override
    public Class<Guest> handles()
    {
        return delegate.handles();
    }

    /* (non-Javadoc)
     * @see net.acardenas.wedding.dataservice.DataAccessServiceBase#create(java.lang.Object)
     */
    @Override
    public Guest create(Guest anEntity)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see net.acardenas.wedding.dataservice.DataAccessServiceBase#find(java.lang.Object)
     */
    @Override
    public Guest find(Integer anId)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see net.acardenas.wedding.dataservice.DataAccessServiceBase#delete(java.lang.Object)
     */
    @Override
    public void delete(Integer anId)
    {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see net.acardenas.wedding.dataservice.DataAccessServiceBase#update(java.lang.Object)
     */
    @Override
    public Guest update(Guest anEntity)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see net.acardenas.wedding.dataservice.DataAccessServiceBase#findWithNamedQuery(java.lang.String)
     */
    @Override
    public List<Guest> findWithNamedQuery(String aNamedQueryName)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see net.acardenas.wedding.dataservice.DataAccessServiceBase#findWithNamedQuery(java.lang.String, int, int)
     */
    @Override
    public List<Guest> findWithNamedQuery(String aNamedQueryName, int aStart,
            int anEnd)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see net.acardenas.wedding.dataservice.DataAccessServiceBase#countTotalRecord(java.lang.String)
     */
    @Override
    public int countTotalRecord(String aNamedQueryName)
    {
        // TODO Auto-generated method stub
        return 0;
    }

}
