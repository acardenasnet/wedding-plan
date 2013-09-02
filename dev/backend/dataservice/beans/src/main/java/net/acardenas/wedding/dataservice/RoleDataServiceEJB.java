package net.acardenas.wedding.dataservice;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import net.acardenas.wedding.dataservice.entity.Role;

@Remote( RoleDataService.class )
@Stateless( mappedName = RoleDataServiceLocator.JNDI_NAME )
public class RoleDataServiceEJB
    implements RoleDataService
{
    private RoleDataService delegate;
    private Logger LOG = Logger.getLogger(RoleDataServiceEJB.class.getName());
    
    @PostConstruct
    void init()
    {
        RoleDataServiceImpl myRoleDataServiceImpl = new RoleDataServiceImpl();
        delegate = myRoleDataServiceImpl;
    }

    @Override
    public Class<Role> handles()
    {
        return delegate.handles();
    }

    @Override
    public Role create(Role t)
    {
        return delegate.create(t);
    }

    @Override
    public Role find(Integer id)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Integer id)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Role update(Role anEntity)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Role> findWithNamedQuery(String namedQueryName)
    {
        LOG.info("findWithNamedQuery - " + delegate);
        LOG.info(delegate.findWithNamedQuery(Role.ALL).toString());
        return delegate.findWithNamedQuery(Role.ALL);
    }

    @Override
    public List<Role> findWithNamedQuery(String namedQueryName, int start,
            int end)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int countTotalRecord(String namedQueryName)
    {
        // TODO Auto-generated method stub
        return 0;
    }

}
