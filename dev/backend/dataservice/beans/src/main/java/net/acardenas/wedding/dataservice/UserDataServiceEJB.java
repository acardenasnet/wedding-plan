package net.acardenas.wedding.dataservice;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.acardenas.wedding.dataservice.entity.User;
import net.acardenas.wedding.util.WeddingConstants;

@Stateless
@Remote(UserDataService.class)
public class UserDataServiceEJB implements UserDataService<User>
{
    private UserDataService<User> delegate;
    
    @PersistenceContext(name = WeddingConstants.PERSISTENCE_CONTEXT_NAME)
    private EntityManager entityManager;

    public UserDataServiceEJB()
    {
        // empty
    }
    
    @PostConstruct
    void init()
    {
        UserDataServiceImpl myDataServiceImpl = new UserDataServiceImpl();
        myDataServiceImpl.setEntityManager(entityManager);
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
