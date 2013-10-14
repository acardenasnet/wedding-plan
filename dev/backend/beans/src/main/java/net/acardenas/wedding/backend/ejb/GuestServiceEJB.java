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

package net.acardenas.wedding.backend.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import net.acardenas.wedding.backend.GuestService;
import net.acardenas.wedding.backend.GuestServiceLocator;
import net.acardenas.wedding.backend.impl.GuestServiceImpl;
import net.acardenas.wedding.dataservice.GuestDataService;
import net.acardenas.wedding.dataservice.GuestDataServiceLocator;
import net.acardenas.wedding.dataservice.entity.Guest;

@Remote(GuestService.class)
@Stateless( mappedName = GuestServiceLocator.JNDI_NAME )
public class GuestServiceEJB
    implements GuestService
{
    @EJB(mappedName = GuestDataServiceLocator.JNDI_NAME)
    private GuestDataService guestDataService;
    
    private GuestService delegate;

    public GuestServiceEJB()
    {
        // empty
    }
    
    @PostConstruct
    void init()
    {
        GuestServiceImpl myGuestServiceImpl = new GuestServiceImpl();
        myGuestServiceImpl.setGuestDataService(guestDataService);
        delegate = myGuestServiceImpl;
    }

    @Override
    public void create(Guest aGuest)
    {
        delegate.create(aGuest);
    }

    @Override
    public Guest read(Integer anId)
    {
        return delegate.read(anId);
    }

    @Override
    public List<Guest> read(List<Integer> anIds)
    {
        return delegate.read(anIds);
    }

    @Override
    public List<Guest> read(int aStart, int aEnd)
    {
        return delegate.read(aStart, aEnd);
    }

    @Override
    public Guest update(Guest aGuest)
    {
        return delegate.update(aGuest);
    }

    @Override
    public void delete(Guest aGuest)
    {
        delegate.delete(aGuest);
    }

    @Override
    public int countTotalRecord()
    {
        return delegate.countTotalRecord();
    }

    @Override
    public void delete(Guest[] aGuests)
    {
        delegate.delete(aGuests);
    }

}
