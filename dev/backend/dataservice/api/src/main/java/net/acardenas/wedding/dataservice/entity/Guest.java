package net.acardenas.wedding.dataservice.entity;

import javax.persistence.Entity;

@Entity

public class Guest extends User
{
    private static final long serialVersionUID = -3009856100292961183L;
    
    private int quantity;
    
    public Guest()
    {
        // empty
    }

}
