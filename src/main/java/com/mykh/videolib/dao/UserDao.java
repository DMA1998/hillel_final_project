package com.mykh.videolib.dao;

import com.mykh.videolib.connection.ConnectionPool;
import com.mykh.videolib.entity.User;
import com.mykh.videolib.service.UserService;
import com.mykh.videolib.utils.SqlQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.mykh.videolib.utils.ColumnConstants.*;

public class UserDao implements IUserDao {

    private static final UserService service = new UserService();

    @Override
    public  List<User> users() {
        List<User> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {

            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(SqlQuery.FIND_USERS_IN_DATABASE.getQuery());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User(resultSet.getString(USER_LOGIN), resultSet.getInt(USER_PASSWORD));
                result.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        service.close(connection, statement, resultSet);
        return result;
    }
}




