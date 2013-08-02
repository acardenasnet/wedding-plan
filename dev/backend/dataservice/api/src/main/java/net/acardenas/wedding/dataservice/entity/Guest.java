package net.acardenas.wedding.dataservice.entity;

import javax.persistence.Entity;

@Entity
public class Guest 
{
    private long id;
    private String name;
    private int quantity;
    
    public Guest()
    {
        // empty
    }

}
