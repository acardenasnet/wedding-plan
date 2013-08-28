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

import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.acardenas.wedding.web.util.Resources;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable, Resources
{

    private static final long serialVersionUID = 1L;
    
    @Inject
    private transient Logger logger;
    private String username;
    private String password;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * Listen for button clicks on the #{loginController.login} action,
     * validates the username and password entered by the user and navigates to
     * the appropriate page.
     *
     * @param actionEvent
     */
    public void login(ActionEvent actionEvent) {

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            String navigateString = "";
            // Checks if username and password are valid if not throws a ServletException
            request.login(username, password);
            
            // gets the user principle and navigates to the appropriate page
            Principal principal = request.getUserPrincipal();
            if (request.isUserInRole("Administrator")) 
            {
                navigateString = "/admin/AdminHome.xhtml";
            } 
            else if (request.isUserInRole("Manager")) 
            {
                navigateString = "/manager/ManagerHome.xhtml";
            } 
            else if (request.isUserInRole("User")) 
            {
                navigateString = "/user/UserHome.xhtml";
            }
            
            try 
            {
                logger.log(Level.INFO, "User ({0}) loging in #" , principal.getName());
                logger.log(Level.INFO, "Role Administrator ({0})  #" , request.isUserInRole("Administrator"));

                context.getExternalContext().redirect(request.getContextPath() + navigateString);
            } 
            catch (IOException ex) 
            {
                logger.log(Level.SEVERE, "IOException, Login Controller" + "Username : " + principal.getName(), ex);
                context.addMessage(null, new FacesMessage("Error!", "Exception occured"));
            }
        } catch (ServletException e) {
            logger.log(Level.SEVERE, e.toString());
            context.addMessage(null, new FacesMessage("Error!", "The username or password you provided does not match our records."));
        }
    }
    
//    public String login(ActionEvent actionEvent)
//    {
//        String message = "";
//
//        HttpServletRequest request = (HttpServletRequest) FacesContext
//                .getCurrentInstance().getExternalContext().getRequest();
//
//        try
//        {
//
//            // Login via the Servlet Context
//
//            request.login(username, password);
//
//            // Retrieve the Principal
//
//            Principal principal = request.getUserPrincipal();
//
//            // Display a message based on the User role
//
//            if (request.isUserInRole("Administrator"))
//            {
//
//                message = "Username : "
//                        + principal.getName()
//                        + " You are an Administrator, you can really f**k things up now";
//
//            }
//            else if (request.isUserInRole("Manager"))
//            {
//
//                message = "Username : "
//                        + principal.getName()
//                        + " You are only a Manager, Don't you have a Spreadsheet to be working on??";
//
//            }
//            else if (request.isUserInRole("Guest"))
//            {
//                message = "Username : " + principal.getName()
//                        + " You're wasting my resources...";
//
//            }
//
//            // Add the welcome message to the faces context
//            FacesContext.getCurrentInstance()
//                    .addMessage(
//                            null,
//                            new FacesMessage(FacesMessage.SEVERITY_INFO,
//                                    message, null));
//
//            return "welcome";
//        }
//        catch (ServletException e)
//        {
//            FacesContext.getCurrentInstance().addMessage(
//                    null,
//                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                            "An Error Occured: Login failed", null));
//
//            e.printStackTrace();
//        }
//        return LOGIN_NAV;
//    }
    
    public String logout()
    {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);

        if (session != null)
        {
            session.invalidate();
        }

        return LOGIN_NAV;
    }
}