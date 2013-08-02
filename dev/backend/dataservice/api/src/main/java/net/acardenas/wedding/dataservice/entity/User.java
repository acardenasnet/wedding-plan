package net.acardenas.wedding.dataservice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.CHAR, name = "userType")
@DiscriminatorValue(value = "U")
@NamedQueries({ @NamedQuery(name = User.ALL, query = "SELECT u FROM User u "),
        @NamedQuery(name = User.TOTAL, query = "SELECT COUNT(u) FROM User u") })
public class User extends BaseEntity
{

    private static final long serialVersionUID = 8068393702221208112L;

    public final static String ALL = "User.populateUsers";
    public final static String TOTAL = "User.countUsersTotal";

    @Column(nullable = false, length = 50)
    private String username;

    @Column(length = 50)
    private String firstname;

    @Column(length = 50)
    private String lastname;

    @Column(length = 50)
    private String email;

    @Column(length = 64)
    private String password;

    @OneToOne(cascade = { CascadeType.ALL })
    private Address address;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "User_userid") }, inverseJoinColumns = { @JoinColumn(name = "Role_roleid") })
    private List<Role> roles;

    public User()
    {
        roles = new ArrayList<Role>();
        address = new Address();
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getFirstname()
    {
        return this.firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return this.lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Address getAddress()
    {
        return this.address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public List<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(List<Role> roles)
    {
        this.roles = roles;
    }
}
