package test.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "orders")
public class Orders
{ 
  @XmlElement(name="order")
  public List<Order> Orders = new ArrayList<Order>();

  public List<Order> getOrders()
  {
    return Orders;
  }

  public void setOrders(List<Order> orders)
  {
    Orders = orders;
  }
  
  
}
