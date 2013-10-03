package net.acardenas.wedding.web;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;

public abstract class BaseBean< CrudServiceBase extends S , E> implements Serializable
{

    private static final long serialVersionUID = 6882728156467941395L;
    protected @Inject
    transient Logger logger;
    private S service;
    private LazyDataModel<E> lazyDataModel;

    private Class<E> myClass;
    private E newEntity;
    private E selectedEntity;
    private E[] selectedEntities;

    public BaseBean()
    {
        selectedEntity = factoryEntity();
        newEntity = factoryEntity();
    }
    
    protected E factoryEntity()
    {
        try
        {
            return myClass.newInstance();
        }
        catch (InstantiationException e)
        {
            logger.severe("InstantiationException ");
        }
        catch (IllegalAccessException e)
        {
            logger.severe("IllegalAccessException ");
        }
        return null;
    }
    
    /**
     * Getters, Setters
     * @return 
     */
    public E getSelectedEntity() 
    {  
        return selectedEntity;  
    }  

    /**
     *
     * @param aSelectedEntity
     */
    public void setSelectedEntity(E aSelectedEntity) 
    {  
        selectedEntity = aSelectedEntity;  
    } 
        
    /**
     *
     * @return
     */
    public E[] getSelectedEntities() 
    {  
            return selectedEntities;  
    }  
        
    /**
     *
     * @param aSelectedEntities
     */
    public void setSelectedUsers(E[] aSelectedEntities) 
    {  
        selectedEntities = aSelectedEntities;  
    }

    /**
     *
     * @return
     */
    public E getNewEntity() 
    {
            return newEntity;
    }

    /**
     *
     * @param aNewEntity
     */
    public void setNewUser(E aNewEntity) 
    {
        newEntity = aNewEntity; 
    }
    
    /**
     * Create, Update and Delete operations
     */
    public void doCreateEntity() 
    {
        userService.createUser(newEntity);
    }
        
    /**
     *
     * @param actionEvent
     */
    public void doUpdateUser(ActionEvent actionEvent)
    {
        logger.info("doUpdateUser " + selectedEntity);
        userService.updateUser(selectedEntity);
    }
        
    /**
     *
     * @param actionEvent
     */
    public void doDeleteUsers(ActionEvent actionEvent)
    {
        logger.info("doDeleteUsers " + selectedEntities);
        userService.deleteUsers(selectedEntities);
    }    
}
