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

import javax.ejb.Remote;
import javax.ejb.Stateless;

import net.acardenas.wedding.backend.UserService;
import net.acardenas.wedding.backend.UserServiceLocator;
import net.acardenas.wedding.backend.impl.UserServiceImpl;
import net.acardenas.wedding.dataservice.entity.User;

@Remote(UserService.class)
@Stateless(mappedName = UserServiceLocator.JNDI_NAME)
public class UserServiceEJB
    implements UserService
{
    private UserService delegate;

    @Override
    public void createUser(User aUser)
    {
        // empty
    }
    
    void init()
    {
        UserServiceImpl myUserServiceImpl = new UserServiceImpl();
        delegate = myUserServiceImpl;
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
    public User updateUser(User aUser)
    {
        return delegate.updateUser(aUser);
    }

    @Override
    public boolean deleteUser(User aUser)
    {
        return delegate.deleteUser(aUser);
    }
}
