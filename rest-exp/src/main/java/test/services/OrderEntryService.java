package test.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import test.domain.Order;
import test.domain.Orders;

@Path("/orders")
public class OrderEntryService
{

  @GET
  @Produces("application/xml")
  public Orders getOrders(@QueryParam("size") @DefaultValue("50") int size)
  {
    List<Order> list = new ArrayList<Order>();
    for (int i = 0; i < 10; i++)
    {
      Order order = new Order();
      order.setCustomerId(123456);
      order.setId(i);
      list.add(order);
    }
    
     Orders orders = new Orders();
     orders.setOrders(list);
     return orders;
  }

  @GET
  @Path("{id}")
  @Produces("application/xml")
  public Order getOrder(@PathParam("id") int orderId)
  {
    Order order = new Order();
    order.setCustomerId(123456);
    order.setId(orderId);
    if (order == null)
    {

    }
    return order;
  }

  @POST
  public void setOrder( Order order)
  {
	  
  }

}
