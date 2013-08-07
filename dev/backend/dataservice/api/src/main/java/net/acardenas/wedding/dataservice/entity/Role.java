package net.acardenas.wedding.dataservice.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Role extends BaseEntity
{
    private static final long serialVersionUID = 8776361482125696661L;

    public final static String ALL = "Role.populateRoles";

    private String roledesc;
    private String rolename;

    public Role()
    {
    }

    public Role(Integer roleid, String rolename)
    {
        this.rolename = rolename;
    }

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public String getRoledesc()
    {
        return this.roledesc;
    }

    public void setRoledesc(String roledesc)
    {
        this.roledesc = roledesc;
    }

    public String getRolename()
    {
        return this.rolename;
    }

    public void setRolename(String rolename)
    {
        this.rolename = rolename;
    }

    public List<User> getUsers()
    {
        return users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }
}