package com.sample.adapter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.logging.Logger;


/**

 * RAConnectionImpl

 *

 * @version $Revision: $

 */

public class RAConnectionImpl implements RAConnection

{

	static final long serialVersionUID = 1L;
	
   /** The logger */

   private static Logger log = Logger.getLogger("RAConnectionImpl");


   /** ManagedConnection */

   private RAManagedConnection mc;


   /** ManagedConnectionFactory */

   private RAManagedConnectionFactory mcf;


   
   

   
   Socket  socket = null;
   
 


public Socket getSocket() {
	return socket;
}


public void setSocket(Socket socket) {
	this.socket = socket;
}


public RAConnectionImpl(RAManagedConnection mc,

                                   RAManagedConnectionFactory mcf)

   {

      this.mc = mc;

      this.mcf = mcf;
      
      try {
    	  socket = new Socket("127.0.0.1", 6789);
		 

		 
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
      
    

   }


    

   public String write()

   {

	   
      return write(((SocketResourceAdapter)mcf.getResourceAdapter()).getName());

   }


 

   public String write(String name)

   {

      return mc.write(name);

   }


   /**

    * Close

    */

   public void close()

   {

      mc.closeHandle(this);
      try {
		this.socket.close();
		log.info("Socket closed!");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

   }

}
