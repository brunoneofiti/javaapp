package br.com.brunoneofiti.app.common.business;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BusinessException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Log log = LogFactory.getLog(BusinessException.class);

	public BusinessException(String message) {
		
		super(message);
		
		if(log.isDebugEnabled()){
			log.debug(message);
		}
	}

}
