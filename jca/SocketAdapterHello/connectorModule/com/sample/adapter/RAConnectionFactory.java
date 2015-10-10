package com.sample.adapter;

import java.io.Serializable;


import javax.resource.Referenceable;

import javax.resource.ResourceException;


/**

 * RAConnectionFactory

 *

 * @version $Revision: $

 */

public interface RAConnectionFactory extends Serializable, Referenceable

{

	static final long serialVersionUID = 1L;
	
   /** 

    * Get connection from factory

    *

    * @return RAConnection instance

    * @exception ResourceException Thrown if a connection can't be obtained

    */

   public RAConnection getConnection() throws ResourceException;


}
