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
