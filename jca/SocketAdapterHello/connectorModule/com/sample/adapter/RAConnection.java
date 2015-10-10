package com.sample.adapter;

import java.io.Serializable;

public interface RAConnection extends Serializable
{

	static final long serialVersionUID = 1L;
   /**

    * write

    * @return String

    */

   public String write();


   /**

    * write

    * @param name A name

    * @return String

    */

   public String write(String name);


   /**

    * Close

    */

   public void close();

}

