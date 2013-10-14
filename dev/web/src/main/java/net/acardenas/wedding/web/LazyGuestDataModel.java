package net.acardenas.wedding.web;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.inject.Inject;

import net.acardenas.wedding.backend.GuestService;
import net.acardenas.wedding.dataservice.entity.Guest;
import net.acardenas.wedding.web.util.LazySorter;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyGuestDataModel
    extends LazyDataModel<Guest> 
    implements Serializable
{
    private static final long serialVersionUID = -3037551964646626173L;

    // Data Source for binding data to the DataTable
    private List<Guest> datasource;
    // Selected Page size in the DataTable
    private int pageSize;
    // Current row index number
    private int rowIndex;
    // Total row number
    private int rowCount;
    // Data Access Service for create read update delete operations
    private GuestService crudService;
    private @Inject transient Logger LOG;

    /**
    *
    * @param crudService
    */
   public LazyGuestDataModel(GuestService aCrudService) 
   {
       crudService = aCrudService;
   }

   /**
    * Lazy loading user list with sorting ability
    * @param first
    * @param pageSize
    * @param sortField
    * @param sortOrder
    * @param filters
    * @return List<User>
    */ 
   @Override
   public List<Guest> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) 
   {
       LOG.info("load");
       LOG.info("" + first);
       LOG.info("" + pageSize);
       datasource = crudService.read(first, first + pageSize);
       LOG.info(datasource.toString());
       // if sort field is not null then we sort the field according to sortfield and sortOrder parameter
       if(sortField != null) 
       {  
           Collections.sort(datasource, new LazySorter(sortField, sortOrder));  
       } 
       setRowCount(crudService.countTotalRecord());
       LOG.info(datasource.toString());
       return datasource;
   }

}
