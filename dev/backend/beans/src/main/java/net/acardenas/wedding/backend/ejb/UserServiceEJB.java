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

package net.acardenas.wedding.backend.ejb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import net.acardenas.wedding.backend.UserService;
import net.acardenas.wedding.backend.UserServiceLocator;
import net.acardenas.wedding.backend.impl.UserServiceImpl;
import net.acardenas.wedding.dataservice.RoleDataService;
import net.acardenas.wedding.dataservice.RoleDataServiceLocator;
import net.acardenas.wedding.dataservice.UserDataService;
import net.acardenas.wedding.dataservice.UserDataServiceLocator;
import net.acardenas.wedding.dataservice.entity.Role;
import net.acardenas.wedding.dataservice.entity.User;

@Remote(UserService.class)
@Stateless(mappedName = UserServiceLocator.JNDI_NAME)
public class UserServiceEJB
    implements UserService
{
    private UserService delegate;
    
    @EJB( mappedName = RoleDataServiceLocator.JNDI_NAME )
    private RoleDataService roleDataService;
    
    @EJB( mappedName = UserDataServiceLocator.JNDI_NAME )
    private UserDataService userDataService;

    @PostConstruct
    void init()
    {
        UserServiceImpl myUserServiceImpl = new UserServiceImpl();
        myUserServiceImpl.setUserDataService(userDataService);
        myUserServiceImpl.setRoleDataService(roleDataService);
        delegate = myUserServiceImpl;
    }

    @Override
    public void createUser(User aUser)
    {
        delegate.createUser(aUser);
    }
    
    @Override
    public User readUser(Integer anId)
    {
        return delegate.readUser(anId);
    }

    @Override
    public List<User> readUsers(List<Integer> anIds)
    {
        return delegate.readUsers(anIds);
    }

    @Override
    public List<User> readUsers(int aStart, int aEnd)
    {
        return delegate.readUsers(aStart, aEnd);
    }

    @Override
    public User updateUser(User aUser)
    {
        return delegate.updateUser(aUser);
    }

    @Override
    public void deleteUser(User aUser)
    {
        delegate.deleteUser(aUser);
    }

    @Override
    public List<Role> readRoles()
    {
        return delegate.readRoles();
    }

    @Override
    public int countTotalRecord()
    {
        return delegate.countTotalRecord();
    }

    @Override
    public void deleteUsers(User[] aUsers)
    {
        delegate.deleteUsers(aUsers);
    }
}
