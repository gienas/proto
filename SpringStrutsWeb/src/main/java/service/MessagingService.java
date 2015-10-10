package service;

public interface MessagingService {

	public void putMessageToPrimaryChannel(String msg) throws Exception;
	public void putMessageToSecondaryChannel(String msg) throws Exception;
}
