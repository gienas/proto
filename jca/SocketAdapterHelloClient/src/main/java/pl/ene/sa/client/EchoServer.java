package pl.ene.sa.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public EchoServer(int portnum) {
		try {
			server = new ServerSocket(portnum);
		} catch (Exception err) {
			System.out.println(err);
		}
	}

	public void serve() {
		try {
			while (true) {
				Socket client = server.accept();
				BufferedReader r = new BufferedReader(new InputStreamReader(
						client.getInputStream()));
				String line;

				line = r.readLine();
				if (line != null) {
					PrintWriter w = new PrintWriter(client.getOutputStream(),
							true);
					w.println("Got: " + line);
				}

				client.close();
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	public static void main(String[] args) {
		EchoServer s = new EchoServer(6789);
		s.serve();
	}

	private ServerSocket server;
}
