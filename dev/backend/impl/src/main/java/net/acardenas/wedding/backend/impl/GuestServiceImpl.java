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

package net.acardenas.wedding.backend.impl;

import java.util.List;

import net.acardenas.wedding.backend.GuestService;
import net.acardenas.wedding.dataservice.GuestDataService;
import net.acardenas.wedding.dataservice.entity.Guest;

public class GuestServiceImpl
    implements GuestService
{
    private GuestDataService guestDataService;

    public GuestServiceImpl()
    {
        // empty
    }

    public GuestDataService getGuestDataService()
    {
        return guestDataService;
    }

    public void setGuestDataService(GuestDataService aGuestDataService)
    {
        guestDataService = aGuestDataService;
    }

    @Override
    public void create(Guest aGuest)
    {
        guestDataService.create(aGuest);
    }

    @Override
    public Guest read(Integer anId)
    {
        return guestDataService.find(anId);
    }

    @Override
    public List<Guest> read(List<Integer> anIds)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Guest> read(int aStart, int aEnd)
    {
        return guestDataService.findWithNamedQuery(
                Guest.ALL, 
                aStart, 
                aEnd);
    }

    @Override
    public Guest update(Guest aGuest)
    {
        return guestDataService.update(aGuest);
    }

    @Override
    public void delete(Guest aGuest)
    {
        guestDataService.delete(aGuest.getId());
    }

    @Override
    public int countTotalRecord()
    {
        return guestDataService.countTotalRecord(Guest.TOTAL);
    }

    @Override
    public void delete(Guest[] aGuests)
    {
        for (Guest myGuest : aGuests)
        {
            guestDataService.delete(myGuest.getId());
        }
    }
}
