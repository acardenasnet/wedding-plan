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

package net.acardenas.wedding.dataservice.entity;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import net.acardenas.wedding.dataservice.enums.GromsType;
import net.acardenas.wedding.dataservice.enums.GuestType;

@Entity
@Cacheable(value = true)
@DiscriminatorValue(value = "G")
@NamedQueries
({ 
    @NamedQuery(name = Guest.ALL, query = "SELECT g FROM Guest g "),
    @NamedQuery(name = Guest.TOTAL, query = "SELECT COUNT(g) FROM Guest g") 
})
public class Guest extends User
{
    private static final long serialVersionUID = -3009856100292961183L;
    
    public final static String ALL = "Guest.populateGuest";
    public final static String TOTAL = "Guest.countGuestsTotal";
    
    private int quantity;
    private GuestType guestType;
    private GromsType gromsType;
    
    public Guest()
    {
        // empty
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int aQuantity)
    {
        quantity = aQuantity;
    }

    public GuestType getGuestType()
    {
        return guestType;
    }

    public void setGuestType(GuestType aGuestType)
    {
        guestType = aGuestType;
    }

    public GromsType getGromsType()
    {
        return gromsType;
    }

    public void setGromsType(GromsType aGromsType)
    {
        gromsType = aGromsType;
    }
    

}
