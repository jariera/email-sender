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



/**
 * Class PropertiesServerEmail.java
 * @author <a href="mailto:jariera@emergya.com">José Alfonso Riera</a>
 * @version 1.0
 * 
 * The functionality of the class is as follows:
 * 
 * Contains the properties needed to send mail.
 *
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
 * 02110-1301  USA
 *
 * As a special exception, if you link this library with other files to
 * produce an executable, this library does not by itself cause the
 * resulting executable to be covered by the GNU General Public License.
 * This exception does not however invalidate any other reasons why the
 * executable file might be covered by the GNU General Public License.
 */
public class PropertiesEmail {
		
	  		
		//Properties
		/** Default Port 
		* Default value for the mail server port 
		* The default is 25 */ 
		public  final Integer MAIL_PORT_DEFAULT_VALUE = 25;
		
		
		/** Port 
		*  Value for the mail server port 
		*  The default is 25 */
		public  Integer MAIL_PORT_VALUE = MAIL_PORT_DEFAULT_VALUE;
		
		
	    /** Server email
	    * Name for email server*/
		public  String MAIL_SERVER_VALUE = null;
		
		
		/** Name account email
		* User for authentication on the mail server 
		* If the property MAIL_AUTENTICATION_VALUE is enabled (true), 
		* you must enter the field MAIL_USER_VALUE and MAIL_PASSWORD_VALUE */
		public  String MAIL_USER_VALUE =  null;
		
		
		/**Password server email
		* Password for authentication on the mail server  
		* If the property MAIL_AUTENTICATION_VALUE is enabled (true), 
		* you must enter the field MAIL_USER_VALUE and MAIL_PASSWORD_VALUE */
		public  String MAIL_PASSWORD_VALUE =  null;
		
		
		/** Email address sender */
		public  String MAIL_ADDRESS_SENDER_VALUE =  null;
		
		
		/** Name email sender */
		public  String MAIL_NAME_SENDER_VALUE = null;
		
		
		/** Issues email */
		public  String MAIL_ISSUE_VALUE =  null;
		
		
		/** Autentication server email
		* If authentication is enabled (true),
		* you must enter values ​​for properties:
		* MAIL_PASSWORD_VALUE 
		* MAIL_USER_VALUE
		* */
		public  Boolean MAIL_AUTENTICATION_VALUE =  null;
		
		/** Copy email */
		public  String MAIL_CC_VALUE =  null;
		
		/** Copy email. Name*/
		public  String MAIL_CC_NAME_VALUE =  null;
		
		/** Copy email. Address email */
		public  String MAIL_CC_ADDRESS_VALUE =  null;
		
		
		/** Copy hide bcc 
		* Must be enabled (true)  MAIL_ACTIVATE_BCC_VALUE property */
		public  String MAIL_BCC_VALUE =  null;
		
		
		/** Copy hide bcc. Name bcc
		* Must be enabled (true)  MAIL_ACTIVATE_BCC_VALUE property */
		public String MAIL_BCC_NAME_VALUE = null;
		
		
		/** Copy hide bcc. Address email bcc 
		* Must be enabled (true)  MAIL_ACTIVATE_BCC_VALUE property*/
		public String MAIL_BCC_ADDRESS_VALUE = null;
		
		
		/** Activate bcc 
		* Alpha To activate the email sending blind copy, must be activated (true) 
		* field MAIL_ACTIVATE_BCC_VALUE
		* The blind copy was sent to the email address provided on the property: 
		* MAIL_BCC_VALUE
		* MAIL_BCC_NAME_VALUE 
		* MAIL_BCC_ADDRESS_VALUE
		* */
		public  Boolean MAIL_ACTIVATE_BCC_VALUE = new Boolean(true);
		
		
		
		 //Others properties
		/** Key MAIL_SERVER */
		public  final String MAIL_SERVER = "mail.server";
		
		/** Key MAIL_FROM */
		public  final String MAIL_FROM = "mail.from";
		
		/** Key MAIL_PORT */
		public  final String MAIL_PORT = "mail.port";
		
		/** Key MAIL_USER */
		public  final String MAIL_USER = "mail.user";
		
		/** Key MAIL_PASSWORD */
		public  final String MAIL_PASSWORD = "mail.password";
		
		/** Key MAIL_AUTENTICATION */
		public  final String MAIL_AUTENTICATION = "mail.autentication";
		
		/** Key MAIL_ISSUE */
		public  final String MAIL_ISSUE = "mail.issue";
		
		/** Key MAIL_CC */
		public  final String MAIL_CC = "mail.cc";
		
		/** Key MAIL_BCC */
		public  final String MAIL_BCC = "mail.bcc";
		
		/** Key MAIL_ACTIVATE_BCC */
		public  final String MAIL_ACTIVATE_BCC = "mail.activatebcc";
		
		/** Key MAIL_USER_SENDER */
		public  final String MAIL_ADDRESS_SENDER = "mail.address.sender";
		
		/** Key MAIL_NAME_SENDER */
		public  final String MAIL_NAME_SENDER = "mail.name.sender";
		
		
		
	/**
	 * Static Method	
	 */
	static{}

	/**
	 * Constructor
	 */
	public PropertiesEmail(){
		
	}

	public Integer getMAIL_PORT_VALUE() {
		return MAIL_PORT_VALUE;
	}

	public void setMAIL_PORT_VALUE(Integer mAIL_PORT_VALUE) {
		MAIL_PORT_VALUE = mAIL_PORT_VALUE;
	}

	public String getMAIL_SERVER_VALUE() {
		return MAIL_SERVER_VALUE;
	}

	public void setMAIL_SERVER_VALUE(String mAIL_SERVER_VALUE) {
		MAIL_SERVER_VALUE = mAIL_SERVER_VALUE;
	}

	public String getMAIL_USER_VALUE() {
		return MAIL_USER_VALUE;
	}

	public void setMAIL_USER_VALUE(String mAIL_USER_VALUE) {
		MAIL_USER_VALUE = mAIL_USER_VALUE;
	}

	public String getMAIL_PASSWORD_VALUE() {
		return MAIL_PASSWORD_VALUE;
	}

	public void setMAIL_PASSWORD_VALUE(String mAIL_PASSWORD_VALUE) {
		MAIL_PASSWORD_VALUE = mAIL_PASSWORD_VALUE;
	}

	public String getMAIL_ADDRESS_SENDER_VALUE() {
		return MAIL_ADDRESS_SENDER_VALUE;
	}

	public void setMAIL_ADDRESS_SENDER_VALUE(String mAIL_ADDRESS_SENDER_VALUE) {
		MAIL_ADDRESS_SENDER_VALUE = mAIL_ADDRESS_SENDER_VALUE;
	}

	public String getMAIL_NAME_SENDER_VALUE() {
		return MAIL_NAME_SENDER_VALUE;
	}

	public void setMAIL_NAME_SENDER_VALUE(String mAIL_NAME_SENDER_VALUE) {
		MAIL_NAME_SENDER_VALUE = mAIL_NAME_SENDER_VALUE;
	}

	public String getMAIL_ISSUE_VALUE() {
		return MAIL_ISSUE_VALUE;
	}

	public void setMAIL_ISSUE_VALUE(String mAIL_ISSUE_VALUE) {
		MAIL_ISSUE_VALUE = mAIL_ISSUE_VALUE;
	}

	public Boolean getMAIL_AUTENTICATION_VALUE() {
		return MAIL_AUTENTICATION_VALUE;
	}

	public void setMAIL_AUTENTICATION_VALUE(Boolean mAIL_AUTENTICATION_VALUE) {
		MAIL_AUTENTICATION_VALUE = mAIL_AUTENTICATION_VALUE;
	}

	public String getMAIL_CC_VALUE() {
		return MAIL_CC_VALUE;
	}

	public void setMAIL_CC_VALUE(String mAIL_CC_VALUE) {
		MAIL_CC_VALUE = mAIL_CC_VALUE;
	}

	public String getMAIL_BCC_VALUE() {
		return MAIL_BCC_VALUE;
	}

	public void setMAIL_BCC_VALUE(String mAIL_BCC_VALUE) {
		MAIL_BCC_VALUE = mAIL_BCC_VALUE;
	}

	public Boolean getMAIL_ACTIVATE_BCC_VALUE() {
		return MAIL_ACTIVATE_BCC_VALUE;
	}

	public void setMAIL_ACTIVATE_BCC_VALUE(Boolean mAIL_ACTIVATE_BCC_VALUE) {
		MAIL_ACTIVATE_BCC_VALUE = mAIL_ACTIVATE_BCC_VALUE;
	}

	public String getMAIL_SERVER() {
		return MAIL_SERVER;
	}

	public String getMAIL_FROM() {
		return MAIL_FROM;
	}

	public String getMAIL_PORT() {
		return MAIL_PORT;
	}

	public String getMAIL_USER() {
		return MAIL_USER;
	}

	public String getMAIL_PASSWORD() {
		return MAIL_PASSWORD;
	}

	public String getMAIL_AUTENTICATION() {
		return MAIL_AUTENTICATION;
	}

	public String getMAIL_ISSUE() {
		return MAIL_ISSUE;
	}

	public String getMAIL_CC() {
		return MAIL_CC;
	}

	public String getMAIL_BCC() {
		return MAIL_BCC;
	}

	public String getMAIL_ACTIVATE_BCC() {
		return MAIL_ACTIVATE_BCC;
	}

	public String getMAIL_ADDRESS_SENDER() {
		return MAIL_ADDRESS_SENDER;
	}

	public String getMAIL_NAME_SENDER() {
		return MAIL_NAME_SENDER;
	}

	public Integer getMAIL_PORT_DEFAULT_VALUE() {
		return MAIL_PORT_DEFAULT_VALUE;
	}

	public String getMAIL_BCC_NAME_VALUE() {
		return MAIL_BCC_NAME_VALUE;
	}

	public void setMAIL_BCC_NAME_VALUE(String mAIL_BCC_NAME_VALUE) {
		MAIL_BCC_NAME_VALUE = mAIL_BCC_NAME_VALUE;
	}

	public String getMAIL_BCC_ADDRESS_VALUE() {
		return MAIL_BCC_ADDRESS_VALUE;
	}

	public void setMAIL_BCC_ADDRESS_VALUE(String mAIL_BCC_ADDRESS_VALUE) {
		MAIL_BCC_ADDRESS_VALUE = mAIL_BCC_ADDRESS_VALUE;
	}

	public String getMAIL_CC_NAME_VALUE() {
		return MAIL_CC_NAME_VALUE;
	}

	public void setMAIL_CC_NAME_VALUE(String mAIL_CC_NAME_VALUE) {
		MAIL_CC_NAME_VALUE = mAIL_CC_NAME_VALUE;
	}

	public String getMAIL_CC_ADDRESS_VALUE() {
		return MAIL_CC_ADDRESS_VALUE;
	}

	public void setMAIL_CC_ADDRESS_VALUE(String mAIL_CC_ADDRESS_VALUE) {
		MAIL_CC_ADDRESS_VALUE = mAIL_CC_ADDRESS_VALUE;
	}

	

	
	
}

