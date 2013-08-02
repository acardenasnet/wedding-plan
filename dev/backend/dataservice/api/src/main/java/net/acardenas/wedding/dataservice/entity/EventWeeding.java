package net.acardenas.wedding.dataservice.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;

@Entity
public class EventWeeding
{
    private long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    @OneToMany(mappedBy="eventWeeding")
    @Max(value = 2)
    private List<Grooms> grooms;

}
