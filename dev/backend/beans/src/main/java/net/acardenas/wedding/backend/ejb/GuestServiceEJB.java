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
import javax.ejb.Stateless;

import net.acardenas.wedding.backend.GuestService;
import net.acardenas.wedding.backend.GuestServiceLocator;
import net.acardenas.wedding.dataservice.entity.Guest;

@Stateless( mappedName = GuestServiceLocator.JNDI_NAME )
public class GuestServiceEJB
    implements GuestService
{
    private GuestService delegate;

    public GuestServiceEJB()
    {
        // empty
    }
    
    @PostConstruct
    void init()
    {
        
    }

    @Override
    public void createGuest(Guest aGuest)
    {
        delegate.createGuest(aGuest);
    }

    @Override
    public Guest readGuest(Integer anId)
    {
        return delegate.readGuest(anId);
    }

    @Override
    public List<Guest> readGuests(List<Integer> anIds)
    {
        return delegate.readGuests(anIds);
    }

    @Override
    public List<Guest> readGuests(int aStart, int aEnd)
    {
        return delegate.readGuests(aStart, aEnd);
    }

    @Override
    public Guest updateGuest(Guest aGuest)
    {
        return delegate.updateGuest(aGuest);
    }

    @Override
    public void deleteGuest(Guest aGuest)
    {
        delegate.deleteGuest(aGuest);
    }

    @Override
    public int countTotalRecord()
    {
        return delegate.countTotalRecord();
    }

    @Override
    public void deleteGuests(Guest[] aGuests)
    {
        delegate.deleteGuests(aGuests);
    }

}
