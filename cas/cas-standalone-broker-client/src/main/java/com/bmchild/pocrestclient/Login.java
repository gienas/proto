package com.bmchild.pocrestclient;

import java.io.IOException;
import java.util.logging.Logger;

public class Login {

	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
	// private static final String CAS_URL =
	// "https://broker.praca.gov.pl/cas/restletTickets/tickets";
	// private static final String CAS_URL =
	// "https://broker.praca.gov.pl/cas/restletTickets/tickets";
	// private static final String REST_BASE_URL = "http://restservice.com";

	private static final String CAS_URL = "https://localhost:8443//cas/v1/tickets";
	private static final String REST_BASE_URL = "http://restservice.com";

	private static String TGT;
	static CasLogin casLogin = new CasLogin(CAS_URL);
	static RestClient client = new RestClient();
	
	
	public static boolean authenticate(String username, String password) {
		// hardcoded username and password
		try {

			Login.TGT = casLogin.getTicketGrantingTicket(username, password);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Login.TGT = null;
		}

		return Login.TGT != null;
	}
	
	public static void runService(int serviceNumber)
	{
		try {
			String sgt = casLogin.getServiceGrantingTicket(TGT, "http://localhost:8080/cas-client" + serviceNumber + "/j_spring_cas_security_check");
			LOGGER.info("SGT = " + sgt);;
			String url = "http://localhost:8080/cas-client"+serviceNumber+"/j_spring_cas_security_check?ticket=" + sgt;
			LOGGER.info("Run service = " + url);
			Browser.runBrowser(url);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
