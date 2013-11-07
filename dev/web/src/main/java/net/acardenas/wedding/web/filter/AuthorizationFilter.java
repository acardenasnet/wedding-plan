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

package net.acardenas.wedding.web.filter;

import java.io.IOException;
import java.security.Principal;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/login*")
public class AuthorizationFilter implements Filter {
    
    protected @Inject
    transient Logger logger;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest myRequest = (HttpServletRequest) request;
        HttpServletResponse myResponse = (HttpServletResponse) response;
        
        Principal principal = myRequest.getUserPrincipal();
        
        if (principal != null && principal.getName() != null && !principal.getName().isEmpty()) 
        {
            logger.info("User logged");
            myResponse.sendRedirect(myRequest.getContextPath() + "/admin/AdminHome.xhtml");
            // User is logged in, so just continue request.
            chain.doFilter(request, response);
        } 
        else 
        {
            logger.info("User must login");
            // User is not logged in, so redirect to index.
            myResponse.sendRedirect(myRequest.getContextPath() + "/login.xhtml");
        }
    }

    @Override
    public void destroy()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException
    {
        // TODO Auto-generated method stub
        
    }
}