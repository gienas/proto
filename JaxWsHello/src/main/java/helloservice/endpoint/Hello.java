package helloservice.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class Hello
{
  private String message = new String("Hello Hello Hello, ");

  public void Hello()
  {
	  
  }

  @WebMethod()
  public String sayHello(String name) throws Exception
  {
    if (1 == 2)
    {
      throw new Exception("Hello by Exception");
    }
    return message + name + ".";
  }
}
