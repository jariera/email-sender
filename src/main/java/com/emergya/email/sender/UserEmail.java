/*
 * Copyright (C) 2011, Emergya (http://www.emergya.es)
 *
 * @author <a href="mailto:jariera@emergya.com">José Alfonso Riera</a>
 *
 * This file is Component email-sender
 *
 * This software is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 *
 * As a special exception, if you link this library with other files to
 * produce an executable, this library does not by itself cause the
 * resulting executable to be covered by the GNU General Public License.
 * This exception does not however invalidate any other reasons why the
 * executable file might be covered by the GNU General Public License.
 */
package com.emergya.email.sender;

import java.util.logging.Logger;

/**
 * Class UserEmail.java
 * @author <a href="mailto:jariera@emergya.com">José Alfonso Riera</a>
 * @version 1.0
 * 
 * The functionality of the class is as follows:
 *
 * This software is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
	02110-1301  USA
 *
 * As a special exception, if you link this library with other files to
 * produce an executable, this library does not by itself cause the
 * resulting executable to be covered by the GNU General Public License.
 * This exception does not however invalidate any other reasons why the
 * executable file might be covered by the GNU General Public License.
 */
public class UserEmail {

	/** log **/
	private static Logger log = Logger.getLogger("UserEmail");
	
	/**Name user*/
	private String nameUser;
	
	/**Email user*/
	private String emailUser;
	
	/**
	 * Constructor
	 */
	public  UserEmail(){
		this.nameUser = new String();
		this.emailUser = new String();
	}
	
	/**
	 * Constructor
	 * @param nameUser
	 * @param emailUser
	 */
	public  UserEmail(String nameUser, String emailUser){
		this.nameUser = nameUser;
		this.emailUser = emailUser;
	}
	
	/**
	 * get name user
	 * @return
	 */
	public String getNameUser() {
		return nameUser;
	}
	
	/**
	 * set name user
	 * @param nameUser
	 */
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	
	/**
	 * get email user
	 * @return
	 */
	public String getEmailUser() {
		return emailUser;
	}
	
	/**
	 * set email user
	 * @param emailUser
	 */
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}
	
	
	/**
	 * Compares  if the objects are equal, 
	 * if the name and email are equal to the object passed as a parameter
	 * @param object USerEmail
	 * @return
	 */
	public boolean equals(UserEmail object){
		 if (this == object) return true;
	      
		 if (!(object instanceof UserEmail)) return false;
		 
	     final UserEmail o = (UserEmail) object;
	     return (this.nameUser.equals(o.nameUser)) && (this.emailUser.equals(o.emailUser));

	}
	
	
	/**
	 * Cloned an EmailUser
	 */
	public UserEmail clone(){
		UserEmail u = null;
		
		if(this != null){
			u = new UserEmail();
			u.setEmailUser(new String(this.getEmailUser()));
			u.setNameUser(new String(this.getNameUser()));
		}
		
		return u;
	}
	
}
