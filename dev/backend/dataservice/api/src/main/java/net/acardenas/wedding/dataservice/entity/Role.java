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