package net.acardenas.wedding.dataservice.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import net.acardenas.wedding.dataservice.enums.GromsType;

@Entity
public class Grooms 
    extends Guest
{
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
