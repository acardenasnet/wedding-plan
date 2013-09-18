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

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.acardenas.wedding.dataservice.entity.Guest;
import net.acardenas.wedding.util.WeddingConstants;

/**
 * @author acardenas
 *
 */
public class GuestDataServiceEJB implements GuestDataService
{

    @PersistenceContext(name = WeddingConstants.PERSISTENCE_CONTEXT_NAME)
    private EntityManager entityManager;
    
    private GuestDataService delegate;
    
    /** Constructor. */
    public GuestDataServiceEJB()
    {
        // empty
    }
    
    @PostConstruct
    void init()
    {
        GuestDataServiceImpl myGuestDataServiceImpl = new GuestDataServiceImpl();
        myGuestDataServiceImpl.setEntityManager(entityManager);
        delegate = myGuestDataServiceImpl;
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
        return delegate.create(anEntity);
    }

    /* (non-Javadoc)
     * @see net.acardenas.wedding.dataservice.DataAccessServiceBase#find(java.lang.Object)
     */
    @Override
    public Guest find(Integer anId)
    {
        return delegate.find(anId);
    }

    /* (non-Javadoc)
     * @see net.acardenas.wedding.dataservice.DataAccessServiceBase#delete(java.lang.Object)
     */
    @Override
    public void delete(Integer anId)
    {
        delegate.delete(anId);
    }

    /* (non-Javadoc)
     * @see net.acardenas.wedding.dataservice.DataAccessServiceBase#update(java.lang.Object)
     */
    @Override
    public Guest update(Guest anEntity)
    {
        return delegate.update(anEntity);
    }

    /* (non-Javadoc)
     * @see net.acardenas.wedding.dataservice.DataAccessServiceBase#findWithNamedQuery(java.lang.String)
     */
    @Override
    public List<Guest> findWithNamedQuery(String aNamedQueryName)
    {
        return delegate.findWithNamedQuery(aNamedQueryName);
    }

    /* (non-Javadoc)
     * @see net.acardenas.wedding.dataservice.DataAccessServiceBase#findWithNamedQuery(java.lang.String, int, int)
     */
    @Override
    public List<Guest> findWithNamedQuery(String aNamedQueryName, int aStart,
            int anEnd)
    {
        return delegate.findWithNamedQuery(aNamedQueryName, aStart, anEnd);
    }

    /* (non-Javadoc)
     * @see net.acardenas.wedding.dataservice.DataAccessServiceBase#countTotalRecord(java.lang.String)
     */
    @Override
    public int countTotalRecord(String aNamedQueryName)
    {
        return delegate.countTotalRecord(aNamedQueryName);
    }

}
