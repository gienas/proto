package actions;

import java.util.HashMap;
import java.util.Map;

import messaging.MyDefaultMessageListenerContainer;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import service.MessagingService;

@ParentPackage(value = "json-default")
@Namespace(value = "/str")
@Results({ @Result(name = "success", location = "/str/index.jsp"),
		@Result(name = "json", type = "json") })
public class MessagingAction {

	@Autowired
	MessagingService service;
	
	@Autowired
	private MyDefaultMessageListenerContainer primaryMessageListenerContainer;
	
	public String result = "OK";
	
	public Map<String, String> map = new HashMap<String, String>();
	
	@Action(value = "sendRightEmail")
	public final String sendRightEmail() {
				
		try {
			// send message
			service.putMessageToPrimaryChannel("---Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world Hello right world---");
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "BLAD";
		}
		map.put("result", result);
		return "json";
	}

	
	@Action(value = "sendWrongEmail")
	public final String sendWrongEmail() {
				
		boolean ret = true;
		try {
			// send message
			service.putMessageToPrimaryChannel("Hello wrong world");
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "BLAD";
		}
		map.put("result", result);
		return "json";
	}


	@Action(value = "msgstop")
	public final String stop() {
		try {
			
			if (primaryMessageListenerContainer != null) 
			{
				primaryMessageListenerContainer.stop();
			}
			else
			{ 
				result = "BLAD";
				System.out.println("primaryMessageListenerContainer is null");
			}
		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "BLAD";
		}
		map.put("result", result);
		return "json";
	}

	@Action(value = "msgstart")
	public final String start() {
		try {
			if (primaryMessageListenerContainer != null) 
			{
				primaryMessageListenerContainer.start();
			}
			else
			{ 
				result = "BLAD";
				System.out.println("primaryMessageListenerContainer is null");
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "BLAD";
		}
		map.put("result", result);
		return "json";
	}
	
	
	@Action(value = "msgstatus")
	public final String status() {
		try {
			if (primaryMessageListenerContainer != null) 
			{
				if (primaryMessageListenerContainer.isRunning())
				{
					result = "ACTIVE";
				}	
				else
				{
					result = "NOT ACTIVE";
				}	
			}
			else
			{ 
				result = "BLAD";
				System.out.println("primaryMessageListenerContainer is null");
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "BLAD";
		}
		map.put("result", result);
		return "json";
	}


	public Map<String, String> getMap() {
		return map;
	}


	public void setMap(Map<String, String> map) {
		this.map = map;
	}
}
