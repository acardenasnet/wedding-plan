package net.acardenas.wedding.web;

import java.io.Serializable;
import java.security.Principal;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String name;
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSayWelcome()
    {
        // check if null?
        if ("".equals(name) || name == null)
        {
            return "";
        }
        else
        {
            return "Ajax message : Welcome " + name;
        }
    }

    public String login()
    {
        String message = "";

        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();

        try
        {

            // Login via the Servlet Context

            request.login(username, password);

            // Retrieve the Principal

            Principal principal = request.getUserPrincipal();

            // Display a message based on the User role

            if (request.isUserInRole("Administrator"))
            {

                message = "Username : "
                        + principal.getName()
                        + " You are an Administrator, you can really f**k things up now";

            }
            else if (request.isUserInRole("Manager"))
            {

                message = "Username : "
                        + principal.getName()
                        + " You are only a Manager, Don't you have a Spreadsheet to be working on??";

            }
            else if (request.isUserInRole("Guest"))
            {
                message = "Username : " + principal.getName()
                        + " You're wasting my resources...";

            }

            // Add the welcome message to the faces context
            FacesContext.getCurrentInstance()
                    .addMessage(
                            null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    message, null));

            return "welcome";
        }
        catch (ServletException e)
        {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "An Error Occured: Login failed", null));

            e.printStackTrace();
        }
        return "hello";
    }
    
    public String logout()
    {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);

        if (session != null)
        {
            session.invalidate();
        }

        return "hello";
    }
}