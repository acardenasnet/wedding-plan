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

    public GuestDataService getUserDataService()
    {
        return guestDataService;
    }

    public void setUserDataService(GuestDataService aUserDataService)
    {
        guestDataService = aUserDataService;
    }

    @Override
    public void createGuest(Guest aGuest)
    {
        guestDataService.create(aGuest);
    }

    @Override
    public Guest readGuest(Integer anId)
    {
        return guestDataService.find(anId);
    }

    @Override
    public List<Guest> readGuests(List<Integer> anIds)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Guest> readGuests(int aStart, int aEnd)
    {
        return guestDataService.findWithNamedQuery(
                Guest.ALL, 
                aStart, 
                aEnd);
    }

    @Override
    public Guest updateGuest(Guest aGuest)
    {
        return guestDataService.update(aGuest);
    }

    @Override
    public void deleteGuest(Guest aGuest)
    {
        guestDataService.delete(aGuest.getId());
    }

    @Override
    public int countTotalRecord()
    {
        return guestDataService.countTotalRecord(Guest.TOTAL);
    }

    @Override
    public void deleteGuests(Guest[] aGuests)
    {
        for (Guest myGuest : aGuests)
        {
            guestDataService.delete(myGuest.getId());
        }
    }

}
