package com.mykh.videolib.service;

import com.mykh.videolib.entities.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserService {

    public boolean isAuthorized(User currentUser,List<User> users) {
        for (User user : users) {
            if (user.getLogin().equals(currentUser.getLogin()) && user.getPassword() == currentUser.getPassword())
                return true;
        }
        return false;
    }

    public void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            connection.close();
            statement.close();
            resultSet.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
