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
import java.util.logging.Logger;

import net.acardenas.wedding.backend.UserService;
import net.acardenas.wedding.dataservice.RoleDataService;
import net.acardenas.wedding.dataservice.UserDataService;
import net.acardenas.wedding.dataservice.entity.Role;
import net.acardenas.wedding.dataservice.entity.User;

public class UserServiceImpl
    implements UserService
{
    private UserDataService<User, Integer> userDataService;
    
    private RoleDataService roleDataService;
    private Logger LOG = Logger.getLogger(UserServiceImpl.class.getName());
    
    public void setUserDataService(UserDataService<User, Integer> aUserDataService)
    {
        userDataService = aUserDataService;
    }
    
    public void setRoleDataService(RoleDataService aRoleDataService)
    {
        roleDataService = aRoleDataService;
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
    public List<User> readUsers(int aStart, int aEnd)
    {
        return userDataService.findWithNamedQuery(User.ALL, aStart, aEnd);
    }

    @Override
    public User updateUser(User aUser)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteUser(User aUser)
    {
        userDataService.delete(aUser.getId());
    }

    @Override
    public List<Role> readRoles()
    {
        LOG.info("readRoles");
        LOG.info(roleDataService.findWithNamedQuery(Role.ALL).toString());
        return roleDataService.findWithNamedQuery(Role.ALL);
    }

    @Override
    public int countTotalRecord()
    {
        return userDataService.countTotalRecord(User.TOTAL);
    }
}
