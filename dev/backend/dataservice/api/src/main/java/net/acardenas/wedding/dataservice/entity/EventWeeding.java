package net.acardenas.wedding.dataservice.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;

@Entity
public class EventWeeding extends BaseEntity
{   
    private static final long serialVersionUID = 7484568927100980294L;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    @OneToMany(mappedBy="eventWeeding")
    @Max(value = 2)
    private List<Grooms> grooms;

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public List<Grooms> getGrooms()
    {
        return grooms;
    }

    public void setGrooms(List<Grooms> grooms)
    {
        this.grooms = grooms;
    }

    
}
