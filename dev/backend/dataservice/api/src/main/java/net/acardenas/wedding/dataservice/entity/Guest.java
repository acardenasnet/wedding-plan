package net.acardenas.wedding.dataservice.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "G")
public class Guest extends User
{
    private static final long serialVersionUID = -3009856100292961183L;
    
    private int quantity;
    
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

}
