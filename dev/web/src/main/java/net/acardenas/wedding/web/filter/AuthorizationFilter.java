package net.acardenas.wedding.web.filter;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/user/*")
public class AuthorizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {    
        HttpServletRequest myRequest = (HttpServletRequest) request;
        
        Principal principal = myRequest.getUserPrincipal();
        
        if (principal != null && principal.getName() != null && !principal.getName().isEmpty()) 
        {
            // User is logged in, so just continue request.
            chain.doFilter(request, response);
        } 
        else 
        {
            // User is not logged in, so redirect to index.
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendRedirect(myRequest.getContextPath() + "/index.xhtml");
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