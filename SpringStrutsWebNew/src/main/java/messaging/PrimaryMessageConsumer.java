package messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import service.MessagingService;

/**
 * @author lolczak
 */
public class PrimaryMessageConsumer implements MessageHandler {
    
	public static int PRIMARY_SLEEP_TIME = 2000;
	
	@Autowired
	private MessagingService service;
	
	/**
     * slf4j Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(PrimaryMessageConsumer.class.getName());
    

    public void handleMessage(Message<?> message) throws MessagingException {
        
    	String msg= (String)message.getPayload();
    	log.info(" Got message " + msg);
    	if ("Hello wrong world".equalsIgnoreCase(msg))
    	{
    		//skopiuj do kanału drugiego
    		try {
    			log.info("Nieudana próba dostarczenia, kopiuję do drugiego kanału, wstrzymuję pobieranie na " + PRIMARY_SLEEP_TIME + " sekund");
				service.putMessageToSecondaryChannel(msg);
				Thread.sleep(PRIMARY_SLEEP_TIME);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}	
    }
}
