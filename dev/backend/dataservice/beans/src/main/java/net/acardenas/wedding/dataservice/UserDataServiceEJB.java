package net.acardenas.wedding.dataservice;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import net.acardenas.wedding.dataservice.entity.User;

@Stateless
@Remote(UserDataService.class)
public class UserDataServiceEJB implements UserDataService<User>
{
    private UserDataService<User> delegate;

    public UserDataServiceEJB()
    {
        // empty
    }
    
    @PostConstruct
    void init()
    {
        UserDataServiceImpl myDataServiceImpl = new UserDataServiceImpl();
        delegate = myDataServiceImpl;
    }

    @Override
    public User create(User t)
    {
        return delegate.create(t);
    }

    @Override
    public User find(Object anId)
    {
        return delegate.find(anId);
    }

    @Override
    public Class<User> handles()
    {
        return delegate.handles();
    }

}
