package net.acardenas.wedding.web;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;

public class BaseBean<S, E>
{
    private static final long serialVersionUID = 7297659416873277642L;
    private @Inject
    transient Logger logger;
    private S service;
    private LazyDataModel<E> lazyDataModel;

    private Class<E> myClass;
    private E newUser;
    private E selectedUser;
    private E[] selectedUsers;

    public BaseBean()
    {
        try
        {
            selectedUser = myClass.newInstance();
            newUser = myClass.newInstance();
        } catch (InstantiationException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
