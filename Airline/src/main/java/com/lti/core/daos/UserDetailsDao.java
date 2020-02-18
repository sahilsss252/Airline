package com.lti.core.daos;

import com.lti.core.entities.UserDetails;
import com.lti.core.exceptions.HrExceptions;

public interface UserDetailsDao {

	public boolean userRegistration(UserDetails userDetails) throws HrExceptions;

}
