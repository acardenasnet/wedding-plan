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
