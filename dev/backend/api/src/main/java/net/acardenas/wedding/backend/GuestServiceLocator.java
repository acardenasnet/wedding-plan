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

package net.acardenas.wedding.backend;

import java.util.MissingResourceException;

import net.acardenas.wedding.external.api.ServiceLocator;

public class GuestServiceLocator
{
    /**
     * The JNDI mapped name of the GuestService.
     */
    public static final String JNDI_NAME = "ejb/GuestService";

    private GuestServiceLocator()
    {
        // Empty
    }

    /**
     * lookup the service in the EJB JNDI.
     * @return {@link GuestService}
     * @throws MissingResourceException {@code}
     */
    public static GuestService lookup() throws MissingResourceException
    {
        return ServiceLocator.lookup(JNDI_NAME, GuestService.class);
    }

}
