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

package net.acardenas.wedding.backend.impl;

import java.util.List;

import net.acardenas.wedding.backend.UserService;
import net.acardenas.wedding.dataservice.UserDataService;
import net.acardenas.wedding.dataservice.entity.User;

public class UserServiceImpl
    implements UserService
{
    private UserDataService<User> userDataService;
    
    public void setUserDataService(UserDataService<User> aUserDataService)
    {
        userDataService = aUserDataService;
    }

    @Override
    public void createUser(User aUser)
    {
        userDataService.create(aUser);
    }

    @Override
    public User readUser(Integer anId)
    {
        return userDataService.find(anId);
    }

    @Override
    public List<User> readUsers(List<Integer> anIds)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User updateUser(User aUser)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteUser(User aUser)
    {
        // TODO Auto-generated method stub
        return false;
    }

}
