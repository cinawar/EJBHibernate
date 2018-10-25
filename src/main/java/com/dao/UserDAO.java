package com.dao;

import com.model.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UserDAO {
    User returnUserById(Integer userId);
    List<User> returnAllUsers();
}
