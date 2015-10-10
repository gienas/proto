package service;

import java.util.List;

import security.MyUserDetails;

import domain.User;

public interface UserService
{
  public List<User> getAll();
  public void saveOrUpdate( User u);
  public User get( User u);
  public void delete(User u);
  public MyUserDetails find( String email, String password );
  public String getHello();
  
}
