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
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Contract")
public class Contract
    extends BaseEntity
{
    private static final long serialVersionUID = 123643602436644148L;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSign;
    private String description;
    private Double total;
    @OneToMany(orphanRemoval = true, 
            fetch = FetchType.LAZY)
    private List<Payment> payments;

    public Contract()
    {
        // empty
    }

    public Date getDateSign()
    {
        return dateSign;
    }

    public void setDateSign(Date aDateSign)
    {
        dateSign = aDateSign;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String aDescription)
    {
        description = aDescription;
    }

    public Double getTotal()
    {
        return total;
    }

    public void setTotal(Double aTotal)
    {
        total = aTotal;
    }

    public List<Payment> getPayments()
    {
        return payments;
    }

    public void setPayments(List<Payment> aPayments)
    {
        payments = aPayments;
    }
}
