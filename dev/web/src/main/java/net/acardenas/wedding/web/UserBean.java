package net.acardenas.wedding.web;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import net.acardenas.wedding.dataservice.UserDataService;
import net.acardenas.wedding.dataservice.UserDataServiceLocator;
import net.acardenas.wedding.dataservice.entity.User;

import org.primefaces.model.LazyDataModel;

@Named
@SessionScoped
public class UserBean implements Serializable
{

    private static final long serialVersionUID = 7297659416873277642L;
    private @Inject transient Logger logger;
    private UserDataService<User> userService;
    private LazyDataModel<User> lazyDataModel;
    
    // Creating new user
    private User newUser = new User();
    // Selected user that will be updated
    private User selectedUser = new User();
    private User[] selectedUsers; 
    
    /**
     * Initializing Data Access Service for LazyUserDataModel class
     * role list for UserContoller class
     */
    @PostConstruct
    public void init()
    {
        logger.log(Level.INFO, "UserController is initializing");
        lazyDataModel = new LazyUserDataModel(getDelegate());
    }
    
    public LazyDataModel<User> getLazyDataModel()
    {
        return lazyDataModel;
    }
    
    private synchronized UserDataService<User> getDelegate()
    {
        if (userService == null)
        {
            userService = UserDataServiceLocator.lookup();
        }
        return userService;
    }
 
    /**
     * Getters, Setters
     * @return 
     */

    public User getSelectedUser() {  
        return selectedUser;  
    }  

    /**
     *
     * @param selectedUser
     */
    public void setSelectedUser(User selectedUser) {  
            this.selectedUser = selectedUser;  
    } 
        
    /**
     *
     * @return
     */
    public User[] getSelectedUsers() {  
            return selectedUsers;  
    }  
        
    /**
     *
     * @param selectedUsers
     */
    public void setSelectedUsers(User[] selectedUsers) {  
            this.selectedUsers = selectedUsers;  
    }

    /**
     *
     * @return
     */
    public User getNewUser() {
            return newUser;
    }

    /**
     *
     * @param newUser
     */
    public void setNewUser(User newUser) {
            this.newUser = newUser; 
    }

}
