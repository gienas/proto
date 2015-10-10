package com.bmchild.pocrestclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Main {
	
	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
	//private static final String CAS_URL = "https://broker.praca.gov.pl/cas/restletTickets/tickets";
	//private static final String CAS_URL = "https://broker.praca.gov.pl/cas/restletTickets/tickets";
	//private static final String REST_BASE_URL = "http://restservice.com"; 
	
	private static final String CAS_URL = "https://localhost:8443//cas/v1/tickets";
	private static final String REST_BASE_URL = "http://restservice.com"; 
	
	
	
	//https://broker.praca.gov.pl/cas/restletTickets/tickets
	
	public static void main(String[] args) throws IOException {
		
		CasLogin casLogin = new CasLogin(CAS_URL);
		RestClient client = new RestClient();
		
		//get TGT
		String tgt = casLogin.getTicketGrantingTicket("admin", "admin");
		
		
		//run service
		String sgt = casLogin.getServiceGrantingTicket(tgt, "http://localhost:8080/cas-client1/j_spring_cas_security_check");
		
		LOGGER.info("SGT = " + sgt);
		 
		//main.printContent( client.get(getSimple + "?ticket=" +) );		
		
		//run Browser http://localhost:8080/cas-client1/j_spring_cas_security_check?ticket=ST-3-tgWcYg04SPrmHXBSZMA1-cas01.example.org
		String url = "http://localhost:8080/cas-client1/j_spring_cas_security_check?ticket=" + sgt;
		LOGGER.info("Run service = " + url);
		Browser.runBrowser(url);
		
//		/* example GET */
//		Main main = new Main();
//		String getSimple =  REST_BASE_URL + "/rest/api/v1/messages";
//		main.printContent( client.get(getSimple + "?ticket=" + casLogin.getServiceTicket(getSimple)) );
//		
//		String getParams =  REST_BASE_URL + "/rest/api/v1/messages?page=1";
//		main.printContent( client.get(getParams + "&ticket=" + casLogin.getServiceTicket(getParams)));
//		
//		String getSimple2 = REST_BASE_URL + "/rest/api/v1/messages/4405078";
//		main.printContent( client.get(getSimple2 + "?ticket=" + casLogin.getServiceTicket(getSimple2)));
//		
//		/* Example POST */
//		// see https://groups.google.com/forum/#!searchin/jasig-cas-user/post$20to$20rest$20resource/jasig-cas-user/NWmFahj9usk/YBECPJULN3sJ
//		// looks like <property name="redirectAfterValidation" value="true" /> should be false in our webapp's spring security context (casContext.xml)
//		String postMessage = REST_BASE_URL + "/rest/api/v1/messages";
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("body", "message body");
//		params.put("toAddress", "11220"); // from address lookup
//		params.put("subject", "message subject");
//		main.printContent( client.post(postMessage + "?ticket=" + casLogin.getServiceTicket(postMessage), params));
	}

	private void printContent(HttpURLConnection con) {
		if (con != null) {

			try {
				
				LOGGER.info("Response Code -> " + con.getResponseCode());
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

				String input;
				StringBuilder content = new StringBuilder();
				while ((input = br.readLine()) != null) {
					content.append(input);
				}
				br.close();
				LOGGER.info("Content -> " + content.toString());

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
