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
	void createUser(User aUser);
	
	User readUser(Integer anId);
	
	List<User> readUsers(List<Integer> anIds);
	
	/**
	 * Read All Users Paging the retrieve queries.
	 * @param aStart
	 * @param aEnd
	 * @return
	 */
	List<User> readUsers(int aStart, int aEnd);
	
	User updateUser(User aUser);
	
	void deleteUser(User aUser);
	
	List<Role> readRoles();
	
	int countTotalRecord();
}
