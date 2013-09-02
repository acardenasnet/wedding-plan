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

import java.util.MissingResourceException;

import net.acardenas.wedding.dataservice.entity.User;
import net.acardenas.wedding.external.api.ServiceLocator;

public class UserDataServiceLocator
{
    /**
     * The JNDI mapped name of the UserDataService.
     */
    public static final String JNDI_NAME = "ejb/UserDataService";

    private UserDataServiceLocator()
    {
        // Empty
    }

    /**
     * lookup the service in the EJB JNDI.
     * @return {@link UserDataService}
     * @throws MissingResourceException {@code}
     */
    public static UserDataService<User, Integer> lookup() throws MissingResourceException
    {
        return ServiceLocator.lookup(JNDI_NAME, UserDataService.class);
    }

}
