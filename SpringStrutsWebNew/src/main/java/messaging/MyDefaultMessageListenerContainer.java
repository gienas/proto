package messaging;

import org.springframework.jms.listener.DefaultMessageListenerContainer;

public class MyDefaultMessageListenerContainer extends DefaultMessageListenerContainer {

	
	public MyDefaultMessageListenerContainer()
	{
		setReceiveTimeout(10000);
	}
	
}
