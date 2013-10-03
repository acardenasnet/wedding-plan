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

package net.acardenas.wedding.web;

import java.util.logging.Level;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import net.acardenas.wedding.backend.GuestService;
import net.acardenas.wedding.backend.GuestServiceLocator;
import net.acardenas.wedding.dataservice.entity.Guest;

@Named
@SessionScoped
public class GuestBean extends BaseBean<GuestService, Guest, Integer>
{

    private static final long serialVersionUID = 2297293679064300413L;


    /**
     * Initializing Data Access Service for LazyUserDataModel class
     * role list for UserContoller class
     */
    @PostConstruct
    public void init()
    {
        logger.log(Level.INFO, "UserController is initializing");
        lazyDataModel = new LazyGuestDataModel(getDelegate());
    }
    
    
    protected synchronized GuestService getDelegate()
    {
        if (getService() == null)
        {
            setService(GuestServiceLocator.lookup());
        }
        return getService();
    }
   
}
