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

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class SendEmailUtils.java
 * @author <a href="mailto:jariera@emergya.com">José Alfonso Riera</a>
 * @version 1.0
 * 
 * The functionality of the class is as follows:
 * 
 * Contains the implementation of the methods for sending email to users. 
 * It can send emails to a user or several at once. 
 * Also be attached to the shipping documents or enable blind copy.
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
public class SendEmailUtils {

	/** log **/
	private static Logger log = Logger.getLogger("UtilsSendEmail");
	
	 /**Cte True*/
	 private static final Boolean TRUE = new Boolean(true);
	 
	 /**Cte False*/
	 private static final Boolean FALSE = new Boolean(false);

	 /** Patron validate emails*/
	 private static final String EMAIL = "[\\w_\\.\\-]+@[\\w_\\.\\-]+";

	 /** Patron validate emails*/
	 private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\." +
				"[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +
				"(\\.[A-Za-z]{2,})$";
	 
	/** Pattern*/ 
	private static Pattern pattern;
	
	/** Matcher*/
	private static Matcher matcher;

	 
	/**
	 * Send an email to a single user
	 * @param props
	 * @param message
	 * @param nameReceptor
	 * @param emailReceptor
	 * @return true if is email send
	 */
	public static boolean sendEmailUser(PropertiesEmail props,
			String message,  
			String nameReceptor, 
			String emailReceptor) {
		
		//Send email
		if(emailReceptor != null && !"".equals(emailReceptor)){
			
			String mensajeHTML = message;

			return SendEmailUtils.sendEmail(props, 
					nameReceptor,
					emailReceptor, 
					mensajeHTML);
		}else{
			return false;
		}
	}
	

	/**
	 * Send an email to a single user without attachments
	 * @param props
	 * @param nameDest
	 * @param mailDest
	 * @param mensajeHTML
	 * @return true if is email send
	 */
	private static boolean sendEmail(PropertiesEmail props,
			String nameDest, 
			String mailDest,
			String mensajeHTML) {

		//Origin
		SMTPSession smtp = new SMTPSession(props);
		
		SMTPMail mail = new SMTPMail(props.getMAIL_NAME_SENDER_VALUE(),
				 props.getMAIL_ADDRESS_SENDER_VALUE(), 
				 props.getMAIL_ISSUE_VALUE());
	
		mail.addToAddress(nameDest, mailDest);
		
		//BCC Activate
		if(props.getMAIL_ACTIVATE_BCC_VALUE() != null && 
			((Boolean)props.getMAIL_ACTIVATE_BCC_VALUE()).booleanValue() == true){
			 
			if(props.getMAIL_BCC_NAME_VALUE() != null && !"".equals(props.getMAIL_BCC_NAME_VALUE()) &&
				props.getMAIL_BCC_ADDRESS_VALUE() != null && !"".equals(props.getMAIL_BCC_ADDRESS_VALUE())){
				
				mail.addBccAddress(props.getMAIL_BCC_NAME_VALUE(), 
						props.getMAIL_BCC_ADDRESS_VALUE());
				
			}
		}

		try {
			log.info("Send email " + mailDest + " with issue " + props.getMAIL_ISSUE_VALUE());
			smtp.sendMail(props, mail, mensajeHTML);
			
			return true;
		} catch (Exception e) {
			log.info("Failed send email. " + e);
			e.printStackTrace();
			
			return false;
		}
	}
	
	
	
	/**
	 * Send an email to users with attachaments
	 * @param props
	 * @param message
	 * @param nameReceptor
	 * @param emailReceptor
	 * @param attachments
	 * @param lbccs
	 * @param lccs
	 * @return true if all emails send
	 */
	public static boolean sendEmailUserWithAttachements(PropertiesEmail props,
			String message,  
			String nameReceptor,
			String emailReceptor,  
			List<String> attachments,
			List<UserEmail> lbccs,
			List<UserEmail> lccs) {
		
		
		//Send email
		if(emailReceptor != null && !"".equals(emailReceptor)){
			
			String mensajeHTML = message;

			return SendEmailUtils.sendEmailWithAttachements(props,
					nameReceptor,
					emailReceptor, 
					mensajeHTML,
					attachments, 
					lbccs, 
					lccs);
		}else{
			return false;
		}
	}
	
	
	
	/**
	 * Send an email to users with attachments
	 * @param props
	 * @param nameDest
	 * @param mailDest
	 * @param mensajeHTML
	 * @param attachments
	 * @param lbccs
	 * @param lccs
	 * @return true if all emails send
	 */
	private static boolean sendEmailWithAttachements(PropertiesEmail props,
			String nameDest, 
			String mailDest,
			String mensajeHTML, 
			List<String> attachments,
			List<UserEmail> lbccs,
			List<UserEmail> lccs) {

		SMTPSession smtp = new SMTPSession(props);
		
		//Origin
		SMTPMail mail = new SMTPMail(props.getMAIL_NAME_SENDER_VALUE(),
						 props.getMAIL_ADDRESS_SENDER_VALUE(), 
						 props.getMAIL_ISSUE_VALUE());
	
		mail.addToAddress(nameDest, mailDest);
		
		//BCC
		if(props.getMAIL_ACTIVATE_BCC_VALUE() != null && 
				((Boolean)props.getMAIL_ACTIVATE_BCC_VALUE()).booleanValue() == true){
			
			//Defined in properties. Only one user
			if(props.getMAIL_BCC_NAME_VALUE() != null && !"".equals(props.getMAIL_BCC_NAME_VALUE()) &&
					props.getMAIL_BCC_ADDRESS_VALUE() != null && !"".equals(props.getMAIL_BCC_ADDRESS_VALUE())){
					
					mail.addBccAddress(props.getMAIL_BCC_NAME_VALUE(), 
							props.getMAIL_BCC_ADDRESS_VALUE());
			}
			
			//List Bccs
			if(lbccs != null && lbccs.size() > 0){
				for (UserEmail copiaOculta : lbccs) {
					mail.addBccAddress(copiaOculta.getNameUser(), copiaOculta.getEmailUser());	
				}
			}
		}
		
		//List CCs
		if(lccs != null && lccs.size() > 0){
			for (UserEmail cc : lccs) {
				mail.addCcAddress(cc.getNameUser(), cc.getEmailUser());	
			}
		}
		
		
		//List attactments
		if(attachments != null){
			for (String smtpAttachment : attachments) {
				SMTPAttachment smtpAtt = new SMTPAttachment(smtpAttachment);
				mail.addAttachment(smtpAtt);
			}
		}
		
		try {
			log.info("Send email " + mailDest + " with issue " + props.getMAIL_ISSUE_VALUE());
			smtp.sendMail(props, mail, mensajeHTML);
		
			return true;
		} catch (Exception e) {
			log.info("Failed send email. " + e);
			e.printStackTrace();
			
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Send email an groups users, without attachments
	 * @param props
	 * @param message
	 * @param listUsersToSend
	 * @return true if all emails send
	 */
	public static boolean sendEmailUsers(PropertiesEmail props,
			String message, 
			List<UserEmail> listUsersToSend) {
		
		//Send email
		boolean b = true;
		
		if(listUsersToSend != null && listUsersToSend.size() > 0){
			
			String mensajeHTML = message;

			for (UserEmail userEmail : listUsersToSend) {
				 b = SendEmailUtils.sendEmail(props, 
						 userEmail.getNameUser(),
						 userEmail.getEmailUser(), 
						 mensajeHTML);
				 
				 if(!b){
					 return false;
				 }
			
			}
		}else{
			return false;
		}
		
		return b;
	}
	
	
	
	
	
	/**
	 * Send email with attachaments
	 * @param props
	 * @param message
	 * @param listUsersToSend
	 * @param attachments
	 * @param lbccs
	 * @return true if is email send
	 */
	public static boolean sendEmailUsersWithAttachements(PropertiesEmail props,
			String message,  
			List<UserEmail> listUsersToSend, 
			List<String> attachments,
			List<UserEmail> lbccs,
			List<UserEmail> lccs) {
		
		boolean b = true;
		
		//Send email
		if(listUsersToSend != null && listUsersToSend.size() > 0){
			
			String mensajeHTML = message;

			for (UserEmail userEmail : listUsersToSend) {
				 b = SendEmailUtils.sendEmailWithAttachements(props,
					userEmail.getNameUser(),
					userEmail.getEmailUser(), 
					mensajeHTML,
					attachments, 
					lbccs, 
					lccs);

				 
				 if(!b){
					 return false;
				 }
				 
				 //The first time send a blind copy todos.EL other times longer
				 lbccs = new LinkedList<UserEmail>();
				 lccs = new LinkedList<UserEmail>();
			}
		}else{
			return false;
		}
		
		return b;
	}
	
	
	
	
	
	
	
	/**
	 * Validates  an email. The email must be in a correct format
	 * @param field
	 * @return true if is valid email
	 */
	private static boolean validEmail(String field){
		if(field != null)
			return (validateEmail(field) && validateEmail2(field));
		else
			return false;
	}
	
	
	/**
	 * Validates  an email. The email must be in a correct format
	 * @param field
	 * @return true if is valid email
	 */
	private static boolean validateEmail(String field){
		if(field != null)
			return validatorGeneric(EMAIL, field);
		else
			return false;
	}
	
	
	/**
	 * Validates an email. The email must be in a correct format
	 * @param patron
	 * @param field
	 * @return true if is valid email
	 */
	private static boolean validatorGeneric(String patron, String field){
		Pattern pattern = Pattern.compile(patron);
		Matcher comprobador = pattern.matcher(field);
		return comprobador.matches();
	}
	
	/**
	 * Validates an email. The email must be in a correct format
	 * @param field
	 * @return true if is valid email
	 */
	private static boolean validateEmail2(String field){
		if(field != null){
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(field.toString());
			
			if(!matcher.matches()){
				return false;
			}
			
			return true;
		}else
			return false;
	}
}
