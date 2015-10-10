package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
public class MessagingServiceImpl implements MessagingService {

	private static final Logger log = LoggerFactory.getLogger(MessagingServiceImpl.class.getName());
	
    @Autowired
    @Qualifier("primaryQueueChannel")
    private MessageChannel primaryChannel;
	
    @Autowired
    @Qualifier("secondaryQueueChannel")
    private MessageChannel secondaryChannel;
    
	public void putMessageToPrimaryChannel(String msg) throws Exception
	{
		   GenericMessage<String> message = new GenericMessage<String>(msg);
           this.primaryChannel.send(message);
           log.info("\"" +msg + "\"" + "was sent to primary channel");
	}
	
	
	public void putMessageToSecondaryChannel(String msg) throws Exception
	{
		   GenericMessage<String> message = new GenericMessage<String>("Hello Wrong World");
           this.secondaryChannel.send(message);
           log.info("\"" +msg + "\"" + "was sent to secondary channel");
	}
}
