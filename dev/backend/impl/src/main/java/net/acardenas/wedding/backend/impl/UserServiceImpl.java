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
import net.acardenas.wedding.dataservice.entity.User;

public class UserServiceImpl
    implements UserService
{

    @Override
    public void createUser(User aUser)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public User readUser(Integer anId)
    {
        // TODO Auto-generated method stub
        return null;
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
