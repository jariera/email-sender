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

import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Class SMTPSession.java
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
 * 02110-1301  USA
 *
 * As a special exception, if you link this library with other files to
 * produce an executable, this library does not by itself cause the
 * resulting executable to be covered by the GNU General Public License.
 * This exception does not however invalidate any other reasons why the
 * executable file might be covered by the GNU General Public License.
 */
public class SMTPSession {

	 /** Log */
	 private Logger log = Logger.getLogger("SMTPSession");
	 
	 /** Smtp auth*/
	 private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
	 
	 /** Smtp host*/
	 private static final String MAIL_SMTP_HOST = "mail.smtp.host";
	 
	 /**Cte True*/
	 private static final Boolean TRUE = new Boolean(true);
	 
	 /**Cte False*/
	 private static final Boolean FALSE = new Boolean(false);
	
	 /**Cte True*/
	 private static final String TRUE_STRING = new String("true");
	 
	 /**Cte False*/
	 private static final String FALSE_STRING = new String("false");
	 
	 /** Properties */
	 private PropertiesEmail props = null;

	 /** Properties */
	 private Properties properties= null;
	 
	/** Debug */
	private boolean debug = false;
	
	/** Format UTF 8*/
	private static final String TYPE_HTML_UTF_8 = "text/html; charset=UTF-8";
	
	/** Format ISO*/
	private static final String TYPE_HTML_ISO_88591 = "text/html; charset=ISO-8859-1";
	
	/** SMTP*/
	private static final String SMTP = "smtp";
	
	/** Host */
	private String host;
	
	/** User */
	private String user;
	
	/** Password */
	private String password;
	
	/** Port*/
	private int port = 25;
	
	/** Default port */
	private static int DEFAULT_PORT = 25;
	

	/**
	 * Constructor
	 */
	public SMTPSession() {
	}

	/**
	 * Constructor
	 * @param props 
	 */
	public SMTPSession(PropertiesEmail props) {
		
		this(props.getMAIL_SERVER_VALUE(), 
				props.getMAIL_PORT_VALUE() != null ? (Integer)props.getMAIL_PORT_VALUE() : DEFAULT_PORT  , 
				null, 
				null);
		
		this.props = props;
		this.properties = new Properties();
	}

	/**
	 * Constructor
	 * @param host
	 */
	public SMTPSession(String host) {
		this(host, DEFAULT_PORT, null, null);
	}

	/**
	 * Constructor
	 * @param host
	 * @param user
	 * @param password
	 */
	public SMTPSession(String host, String user, String password) {
		this(host, DEFAULT_PORT, user, password);
	}

	/**
	 * Constructor
	 * @param host
	 * @param port
	 * @param user
	 * @param password
	 */
	public SMTPSession(String host, int port, String user, String password) {
		this.host = host;
		this.user = user;
		this.password = password;
		this.port = port;
	}
	
	/**
	 * Constructor
	 * @param props
	 * @param host
	 * @param port
	 * @param user
	 * @param password
	 */
	public SMTPSession(PropertiesEmail props, String host, int port, String user, String password) {
		this.props = props;
		this.host = host;
		this.user = user;
		this.password = password;
		this.port = port;
	}

	/**
	 * Sets the debug
	 * @param value
	 */
	public void setDebug(boolean value) {
		debug = value;
	}
	

	/**
	 * Send a email
	 * @param props
	 * @param mail
	 * @param mensajeHTML
	 * @throws Exception
	 */
	public void sendMail(PropertiesEmail props, SMTPMail mail, String mensajeHTML) throws Exception {

			properties.put(MAIL_SMTP_HOST, host);
			
			//Required Autentication
			if(props.getMAIL_AUTENTICATION_VALUE() != null && 
					((Boolean)props.getMAIL_AUTENTICATION_VALUE()).booleanValue() == true){
				
				properties.put(MAIL_SMTP_AUTH, TRUE_STRING);
			}
			
			
			AutenticacionSMTP auth = new AutenticacionSMTP(this.props); 
			Session session = Session.getDefaultInstance(properties, auth);
			session.setDebug(debug);

			//Create message
			MimeMessage message = new MimeMessage(session);

			//Body email
			MimeMultipart mm = new MimeMultipart();
			MimeBodyPart bp = new MimeBodyPart();

			//Content
			bp.setContent(mensajeHTML, TYPE_HTML_UTF_8);
			mm.addBodyPart(bp);

			// Attachment files
			for (SMTPAttachment attachment : mail.getAttachments()) {
				MimeBodyPart att = new MimeBodyPart();
				att.setDataHandler(attachment.getDataHandler());
				att.setFileName(attachment.getFileName());
				mm.addBodyPart(att);
			}

			message.setContent(mm);

			//Fill email
			this.prepareMessage(message, mail);

			//Connect and send email
			Transport transport = session.getTransport(SMTP);
			if (user != null && password != null) {
				transport.connect(host, user, password);
			} else {
				transport.connect();
			}
			
			transport.send(message);
			transport.close();
			
	}

	/**
	 * Prepared message for send
	 * @param message
	 * @param mail
	 * @return
	 * @throws Exception
	 */
	private MimeMessage prepareMessage(MimeMessage message, SMTPMail mail)
			throws Exception {

		// Properties of message
		message.setFrom(mail.getFrom());
		message.setSubject(mail.getSubject());
		message.setSentDate(new java.util.Date());
		// message.setText(mail.getMessageText());

		// Address to send
		InternetAddress[] addresses = mail.getReplyToAddresses();
		if (addresses != null) {
			message.setReplyTo(addresses);
		}
		addresses = mail.getToAddresses();
		if (addresses != null) {
			message.setRecipients(Message.RecipientType.TO, addresses);
		}
		addresses = mail.getCcAddresses();
		if (addresses != null) {
			message.setRecipients(Message.RecipientType.CC, addresses);
		}
		addresses = mail.getBccAddresses();
		if (addresses != null) {
			message.setRecipients(Message.RecipientType.BCC, addresses);
		}

		
		message.saveChanges();
		return message;
	}

	
	
	
}





/**
 * Class  for authentication with  the mail server
 * @author jariera
 * @version 1.0
 */
class AutenticacionSMTP extends Authenticator {
	 
	 /** Log */
	 private Logger log = Logger.getLogger("AutenticacionSMTP");

	 /** Properties email */
	 private PropertiesEmail props = null;
	 
	 /**
	  * Constructor
	  * @param props
	  */
	 public AutenticacionSMTP(PropertiesEmail props){
		 this.props = props; 
	 }
	 
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		log.info("Send autentication server SMTP");
		
		return new PasswordAuthentication(
				props.getMAIL_USER_VALUE(),
				props.getMAIL_PASSWORD_VALUE());
		
	}
}
