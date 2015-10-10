package messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.MessagingException;
import org.springframework.integration.core.MessageHandler;

import service.MessagingService;

/**
 * @author lolczak
 */
public class SecondaryMessageConsumer implements MessageHandler {
    
	public static int SECONDARY_SLEEP_TIME = 1000 * 30;
	
	@Autowired
	private MessagingService service;
	
	/**
     * slf4j Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(SecondaryMessageConsumer.class.getName());
    

    public void handleMessage(Message<?> message) throws MessagingException {
        
    	String msg= (String)message.getPayload();
    	log.info(" got message " + msg);
    	
    }
}
