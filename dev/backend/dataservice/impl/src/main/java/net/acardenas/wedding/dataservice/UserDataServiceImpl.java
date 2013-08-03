package net.acardenas.wedding.dataservice;

import net.acardenas.wedding.dataservice.entity.User;

public class UserDataServiceImpl extends DataAccessService<User> 
    implements UserDataService<User>
{

    @Override
    public Class<User> handles()
    {
        return User.class;
    }
    
}
