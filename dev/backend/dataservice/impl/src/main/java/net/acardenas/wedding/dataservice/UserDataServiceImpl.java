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

package net.acardenas.wedding.dataservice;

import net.acardenas.wedding.dataservice.entity.User;

public class UserDataServiceImpl extends DataAccessService<User, Integer> 
    implements UserDataService
{

    /** Constructor. */
    public UserDataServiceImpl()
    {
        // empty
    }
    
    @Override
    public Class<User> handles()
    {
        return User.class;
    }
    
}
