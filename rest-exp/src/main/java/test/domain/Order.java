package test.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "order")
public class Order
{
  int id;
 
  int customerId;

  @XmlElement(name = "id")
  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  @XmlElement(name = "customer-id")
  public int getCustomerId()
  {
    return customerId;
  }

  public void setCustomerId(int customerId)
  {
    this.customerId = customerId;
  }

}