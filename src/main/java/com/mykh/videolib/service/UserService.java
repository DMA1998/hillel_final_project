package com.mykh.videolib.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService {


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
