package net.acardenas.wedding.dataservice;

import java.util.MissingResourceException;
import net.acardenas.wedding.external.api.ServiceLocator;

public class ContractDataServiceLocator
{

    /**
     * The JNDI mapped name of the ContractDataService.
     */
    public static final String JNDI_NAME = "ejb/ContractDataService";

    private ContractDataServiceLocator()
    {
        // Empty
    }

    /**
     * lookup the service in the EJB JNDI.
     * @return {@link ContractDataService}
     * @throws MissingResourceException {@code}
     */
    public static ContractDataService lookup() throws MissingResourceException
    {
        return ServiceLocator.lookup(JNDI_NAME, ContractDataService.class);
    }
}
