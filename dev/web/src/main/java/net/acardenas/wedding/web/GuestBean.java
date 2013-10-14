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
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import net.acardenas.wedding.backend.GuestService;
import net.acardenas.wedding.backend.GuestServiceLocator;
import net.acardenas.wedding.dataservice.entity.Guest;

@Named
@SessionScoped
@ManagedBean
public class GuestBean extends BaseBean<Guest, Integer>
{

    private static final long serialVersionUID = 2297293679064300413L;
    private Guest selectedEntity;
    private Guest newEntity;

    public GuestBean()
    {
        selectedEntity = new Guest();
        newEntity = new Guest();
    }

    /**
     * Initializing Data Access Service for LazyUserDataModel class role list
     * for UserContoller class
     */
    @PostConstruct
    public void init()
    {
        logger.log(Level.INFO, "Controller is initializing");
        lazyDataModel = new LazyGuestDataModel(getDelegate());
    }

    protected synchronized GuestService getDelegate()
    {
        if (getService() == null)
        {
            setService(GuestServiceLocator.lookup());
        }
        return (GuestService) getService();
    }

    /**
     * Getters, Setters
     * 
     * @return
     */
    public Guest getSelectedEntity()
    {
        return selectedEntity;
    }

    /**
     * 
     * @param aSelectedEntity
     */
    public void setSelectedEntity(Guest aSelectedEntity)
    {
        selectedEntity = aSelectedEntity;
    }

    /**
     * 
     * @return
     */
    public Guest getNewEntity()
    {
        return newEntity;
    }

    /**
     * 
     * @param aNewEntity
     */
    public void setNewEntity(Guest aNewEntity)
    {
        newEntity = aNewEntity;
    }

    /**
     * Create, Update and Delete operations
     */
    public void doCreate()
    {
        getDelegate().create(newEntity);
    }

    /**
     * 
     * @param actionEvent
     */
    public void doUpdate(ActionEvent actionEvent)
    {
        logger.info("doUpdateGuest " + selectedEntity);
        getDelegate().update(selectedEntity);
    }

}
