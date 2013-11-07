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

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import net.acardenas.wedding.backend.GuestService;
import net.acardenas.wedding.dataservice.entity.Guest;
import net.acardenas.wedding.web.util.LazySorter;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyGuestDataModel extends LazyDataModel<Guest> implements
        Serializable
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
    private transient final static Logger LOG = Logger
            .getLogger(LazyGuestDataModel.class.getName());

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
     * 
     * @param first
     * @param pageSize
     * @param sortField
     * @param sortOrder
     * @param filters
     * @return List<User>
     */
    @Override
    public List<Guest> load(int first, int pageSize, String sortField,
            SortOrder sortOrder, Map<String, String> filters)
    {
        LOG.info("load");
        LOG.info("" + first);
        LOG.info("" + pageSize);
        datasource = crudService.read(first, first + pageSize);
        LOG.info(datasource.toString());
        // if sort field is not null then we sort the field according to
        // sortfield and sortOrder parameter
        if (sortField != null)
        {
            Collections.sort(datasource, new LazySorter(sortField, sortOrder));
        }
        setRowCount(crudService.countTotalRecord());
        LOG.info(datasource.toString());
        return datasource;
    }

    /**
     * Checks if the row is available
     * 
     * @return boolean
     */
    @Override
    public boolean isRowAvailable()
    {
        if (datasource == null)
            return false;
        int index = rowIndex % pageSize;
        return index >= 0 && index < datasource.size();
    }

    /**
     * Gets the user object's primary key
     * 
     * @param aGuest
     * @return Object
     */
    @Override
    public Object getRowKey(Guest aGuest)
    {
        return aGuest.getId().toString();
    }

    /**
     * Returns the user object at the specified position in datasource.
     * 
     * @return
     */
    @Override
    public Guest getRowData()
    {
        if (datasource == null)
            return null;
        int index = rowIndex % pageSize;
        if (index > datasource.size())
        {
            return null;
        }
        return datasource.get(index);
    }

    /**
     * Returns the user object that has the row key.
     * 
     * @param rowKey
     * @return
     */
    @Override
    public Guest getRowData(String rowKey)
    {
        if (datasource == null)
            return null;
        for (Guest myGuest : datasource)
        {
            if (myGuest.getId().toString().equals(rowKey))
                return myGuest;
        }
        return null;
    }

    /*
     * ===== Getters and Setters of LazyUserDataModel fields
     */

    /**
     * 
     * @param pageSize
     */
    @Override
    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    /**
     * Returns page size
     * 
     * @return int
     */
    @Override
    public int getPageSize()
    {
        return pageSize;
    }

    /**
     * Returns current row index
     * 
     * @return int
     */
    @Override
    public int getRowIndex()
    {
        return this.rowIndex;
    }

    /**
     * Sets row index
     * 
     * @param rowIndex
     */
    @Override
    public void setRowIndex(int rowIndex)
    {
        this.rowIndex = rowIndex;
    }

    /**
     * Sets row count
     * 
     * @param rowCount
     */
    @Override
    public void setRowCount(int rowCount)
    {
        this.rowCount = rowCount;
    }

    /**
     * Returns row count
     * 
     * @return int
     */
    @Override
    public int getRowCount()
    {
        return this.rowCount;
    }

    /**
     * Sets wrapped data
     * 
     * @param list
     */
    @Override
    public void setWrappedData(Object list)
    {
        this.datasource = (List<Guest>) list;
    }

    /**
     * Returns wrapped data
     * 
     * @return
     */
    @Override
    public Object getWrappedData()
    {
        return datasource;
    }

}
