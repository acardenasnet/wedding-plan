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

package net.acardenas.wedding.backend;

import java.util.List;

import net.acardenas.wedding.dataservice.entity.Role;
import net.acardenas.wedding.dataservice.entity.User;

public interface UserService 
{
    /**
     * Create User to access the system.
     * @param aUser {@link User}
     */
	void createUser(User aUser);
	
	/**
	 * Get a user from the data source given its Id.
	 * @param anId User Id
	 * @return {@code User}
	 */
	User readUser(Integer anId);
	
	/**
	 * Get a List of Users from the data source given a List of Id's. 
	 * @param anIds List of Id s to give from the data source
	 * @return {@code List<User>} 
	 */
	List<User> readUsers(List<Integer> anIds);
	
	/**
	 * Read All Users Paging the retrieve queries.
	 * @param aStart
	 * @param aEnd
	 * @return
	 */
	List<User> readUsers(int aStart, int aEnd);
	
	/**
	 * Update a user as part of CRUD operations.
	 * @param aUser {@link User}
	 * @return {@code User}
	 */
	User updateUser(User aUser);
	
	/**
	 * Remove User to the data source, consider as hard delete.
	 * @param aUser {@link User}
	 */
	void deleteUser(User aUser);
	
	/**
	 * Retrieve all the roles that can be related with any user.
	 * @return {@code List<Role>}
	 */
	List<Role> readRoles();
	
	/**
	 * Count the total of users from the data source.
	 * @return Number of users into the data source.
	 */
	int countTotalRecord();
}
