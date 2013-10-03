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

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import net.acardenas.wedding.backend.GuestService;
import net.acardenas.wedding.backend.GuestServiceLocator;
import net.acardenas.wedding.backend.UserService;
import net.acardenas.wedding.backend.UserServiceLocator;
import net.acardenas.wedding.dataservice.entity.Guest;
import net.acardenas.wedding.dataservice.entity.Role;
import net.acardenas.wedding.dataservice.entity.User;

import org.primefaces.model.LazyDataModel;

@Named
@SessionScoped
public class GuestBean extends BaseBean<GuestService, Guest>
{
    
    /**
     * Initializing Data Access Service for LazyUserDataModel class
     * role list for UserContoller class
     */
    @PostConstruct
    public void init()
    {
        logger.log(Level.INFO, "UserController is initializing");
        setLazyDataModel(new LazyUserDataModel(getDelegate()));
    }
    
    
    private synchronized GuestService getDelegate()
    {
        if (getService() == null)
        {
            setService(GuestServiceLocator.lookup());
        }
        return getService();
    }
 
    /**
     * Getters, Setters
     * @return 
     */

    public User getSelectedUser() 
    {  
        return selectedUser;  
    }  

    /**
     *
     * @param selectedUser
     */
    public void setSelectedUser(User selectedUser) 
    {  
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

    public List<Role> getRoleList()
    {
        return roleList;
    }

    public void setRoleList(List<Role> aRoleList)
    {
        roleList = aRoleList;
    }
    
    /**
     * Create, Update and Delete operations
     */
    public void doCreateUser() 
    {
        userService.createUser(newUser);
    }
        
    /**
     *
     * @param actionEvent
     */
    public void doUpdateUser(ActionEvent actionEvent)
    {
        logger.info("doUpdateUser " + selectedUser);
        userService.updateUser(selectedUser);
    }
        
    /**
     *
     * @param actionEvent
     */
    public void doDeleteUsers(ActionEvent actionEvent)
    {
        logger.info("doDeleteUsers " + selectedUsers);
        userService.deleteUsers(selectedUsers);
    }    
}
