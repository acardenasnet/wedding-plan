package net.acardenas.wedding.dataservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Address extends BaseEntity implements Serializable
{

    private static final long serialVersionUID = -5089900447558483228L;

    @Column(length = 50)
    private String street;

    @Column(length = 50)
    private String suburb;

    @Column(length = 50)
    private String city;

    @Column(length = 50)
    private String country;

    public Address()
    {
    }

    public String getStreet()
    {
        return this.street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getSuburb()
    {
        return this.suburb;
    }

    public void setSuburb(String suburb)
    {
        this.suburb = suburb;
    }

    public String getCity()
    {
        return this.city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCountry()
    {
        return this.country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }
}