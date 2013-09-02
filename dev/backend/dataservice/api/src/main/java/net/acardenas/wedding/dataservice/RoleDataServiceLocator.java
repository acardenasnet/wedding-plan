package net.acardenas.wedding.dataservice;

import java.util.MissingResourceException;

import net.acardenas.wedding.dataservice.entity.Role;
import net.acardenas.wedding.external.api.ServiceLocator;

public class RoleDataServiceLocator
{
    /**
     * The JNDI mapped name of the RoleDataService.
     */
    public static final String JNDI_NAME = "ejb/RoleDataService";

    private RoleDataServiceLocator()
    {
        // Empty
    }

    /**
     * lookup the service in the EJB JNDI.
     * @return {@link RoleDataService}
     * @throws MissingResourceException {@code}
     */
    public static RoleDataService lookup() throws MissingResourceException
    {
        return ServiceLocator.lookup(JNDI_NAME, RoleDataService.class);
    }
}
