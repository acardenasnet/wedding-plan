package net.acardenas.wedding.web;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import net.acardenas.wedding.backend.CrudServiceBase;

import org.primefaces.model.LazyDataModel;

public abstract class BaseBean<E, K> implements Serializable
{

    private static final long serialVersionUID = 6882728156467941395L;
    protected @Inject
    transient Logger logger;
    private CrudServiceBase<E, K> service;
    protected LazyDataModel<E> lazyDataModel;

    private Class<E> myClass;


    private E[] selectedEntities;
    
    protected E factoryEntity()
    {
        try
        {
            myClass = (Class<E>) ((E) new Object()).getClass();
            return myClass.newInstance();
        }
        catch (InstantiationException e)
        {
            logger.severe(e.getMessage());
        }
        catch (IllegalAccessException e)
        {
            logger.severe(e.getMessage());
        }
        return null;
    }
    
    protected abstract CrudServiceBase<E, K> getDelegate();
    
    public LazyDataModel<E> getLazyDataModel()
    {
        return lazyDataModel;
    }

    public void setLazyDataModel(LazyDataModel<E> lazyDataModel)
    {
        this.lazyDataModel = lazyDataModel;
    }

//    /**
//     * Getters, Setters
//     * @return 
//     */
//    public E getSelectedEntity() 
//    {  
//        return selectedEntity;  
//    }  
//
//    /**
//     *
//     * @param aSelectedEntity
//     */
//    public void setSelectedEntity(E aSelectedEntity) 
//    {  
//        selectedEntity = aSelectedEntity;  
//    } 
    
    public CrudServiceBase<E, K> getService()
    {
        return service;
    }

    public void setService(CrudServiceBase<E, K> aService)
    {
        this.service = aService;
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
    public void setSelectedEntities(E[] aSelectedEntities) 
    {  
        selectedEntities = aSelectedEntities;  
    }

//    /**
//     *
//     * @return
//     */
//    public E getNewEntity() 
//    {
//        return newEntity;
//    }
//
//    /**
//     *
//     * @param aNewEntity
//     */
//    public void setNewEntity(E aNewEntity) 
//    {
//        newEntity = aNewEntity; 
//    }
    
//    /**
//     * Create, Update and Delete operations
//     */
//    public void doCreate() 
//    {
//        getDelegate().create(newEntity);
//    }
        
//    /**
//     *
//     * @param actionEvent
//     */
//    public void doUpdate(ActionEvent actionEvent)
//    {
//        logger.info("doUpdateUser " + selectedEntity);
//        getDelegate().update(selectedEntity);
//    }
        
    /**
     *
     * @param actionEvent
     */
    public void doDelete(ActionEvent actionEvent)
    {
        logger.info("doDeleteUsers " + selectedEntities);
        getDelegate().delete(selectedEntities);
    }    
}
