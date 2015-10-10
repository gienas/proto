package messaging;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.core.MessageHandler;
import org.springframework.integration.jms.DefaultJmsHeaderMapper;
import org.springframework.integration.jms.JmsHeaderMapper;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

/**
 * @author lolczak
 */
public class JmsMessageListenerAdapter implements MessageListener {

	/**
	 * slf4j Logger.
	 */
	private static final Logger log = LoggerFactory
			.getLogger(JmsMessageListenerAdapter.class.getName());

	private MessageHandler delegate;

	private JmsHeaderMapper headerMapper = new DefaultJmsHeaderMapper();

	private MessageConverter messageConverter = new SimpleMessageConverter();

	public void onMessage(Message jmsMessage) {
		log.debug("Invoking message handler");
		org.springframework.integration.Message<?> message = null;
		try {
			message = convertMsg(jmsMessage);
		} catch (JMSException e) {
			throw new IllegalStateException("JMS API method failed", e);
		}

		delegate.handleMessage(message);
	}

	protected org.springframework.integration.Message<?> convertMsg(
			Message jmsMessage) throws JMSException {
		Object result = jmsMessage;
		result = this.messageConverter.fromMessage(jmsMessage);
		log.debug(
				"converted JMS Message [{}] to integration Message payload [{}]",
				jmsMessage, result);

		Map<String, Object> headers = headerMapper.toHeaders(jmsMessage);
		org.springframework.integration.Message<?> requestMessage = (result instanceof org.springframework.integration.Message<?>) ? MessageBuilder
				.fromMessage(
						(org.springframework.integration.Message<?>) result)
				.copyHeaders(headers).build()
				: MessageBuilder.withPayload(result).copyHeaders(headers)
						.build();

		return requestMessage;
	}

	public void setDelegate(MessageHandler delegate) {
		this.delegate = delegate;
	}

	public void setHeaderMapper(JmsHeaderMapper headerMapper) {
		this.headerMapper = headerMapper;
	}

	public void setMessageConverter(MessageConverter messageConverter) {
		this.messageConverter = messageConverter;
	}

}
