package net.acardenas.wedding.dataservice;

import java.util.MissingResourceException;

import net.acardenas.wedding.external.api.ServiceLocator;

public class GuestDataServiceLocator
{
    /**
     * The JNDI mapped name of the GuestDataService.
     */
    public static final String JNDI_NAME = "ejb/GuestDataService";

    private GuestDataServiceLocator()
    {
        // Empty
    }

    /**
     * lookup the service in the EJB JNDI.
     * @return {@link GuestDataService}
     * @throws MissingResourceException {@code}
     */
    public static GuestDataService lookup() throws MissingResourceException
    {
        return ServiceLocator.lookup(JNDI_NAME, GuestDataService.class);
    }
}
