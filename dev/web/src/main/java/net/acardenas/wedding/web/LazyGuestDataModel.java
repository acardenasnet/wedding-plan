package net.acardenas.wedding.web;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import net.acardenas.wedding.backend.GuestService;
import net.acardenas.wedding.dataservice.entity.Guest;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyGuestDataModel
    extends LazyDataModel<Guest> 
    implements Serializable
{
    private static final long serialVersionUID = -3037551964646626173L;

    public LazyGuestDataModel(GuestService aCrudService)
    {
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<Guest> load(int first, int pageSize, String sortField,
            SortOrder sortOrder, Map<String, String> filters)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
