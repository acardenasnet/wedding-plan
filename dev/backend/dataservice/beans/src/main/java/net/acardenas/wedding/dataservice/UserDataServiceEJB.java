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

package net.acardenas.wedding.dataservice;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.acardenas.wedding.dataservice.entity.User;
import net.acardenas.wedding.util.WeddingConstants;

@Stateless(mappedName = UserDataServiceLocator.JNDI_NAME)
@Remote(UserDataService.class)
public class UserDataServiceEJB implements UserDataService<User, Integer>
{
    private UserDataService<User, Integer> delegate;
    private static final Logger LOG = Logger.getLogger(UserDataServiceEJB.class.getName());
    
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
    public User find(Integer anId)
    {
        return delegate.find(anId);
    }

    @Override
    public Class<User> handles()
    {
        return delegate.handles();
    }

    @Override
    public void delete(Integer id)
    {
        delegate.delete(id);
    }

    @Override
    public List<User> findWithNamedQuery(String namedQueryName)
    {
        return delegate.findWithNamedQuery(namedQueryName);
    }

    @Override
    public List<User> findWithNamedQuery(String namedQueryName, int start,
            int end)
    { 
        LOG.info("findWithNamedQuery");
        return delegate.findWithNamedQuery(namedQueryName, start, end);
    }

    @Override
    public int countTotalRecord(String namedQueryName)
    {
        return delegate.countTotalRecord(namedQueryName);
    }

    @Override
    public User update(User anEntity)
    {
        return delegate.update(anEntity);
    }
}
