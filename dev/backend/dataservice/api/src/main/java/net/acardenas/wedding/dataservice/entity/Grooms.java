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

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import net.acardenas.wedding.dataservice.enums.GromsType;

@Entity
@DiscriminatorValue(value = "W")
public class Grooms 
    extends Guest
{

    private static final long serialVersionUID = -2788641573123090801L;
    
    @Enumerated(EnumType.STRING)
    private GromsType type;
    @ManyToOne
    private EventWeeding eventWeeding;

    public GromsType getType()
    {
        return type;
    }

    public void setType(GromsType aType)
    {
        type = aType;
    }

    public EventWeeding getEventWeeding()
    {
        return eventWeeding;
    }

    public void setEventWeeding(EventWeeding aEventWeeding)
    {
        eventWeeding = aEventWeeding;
    } 

}
