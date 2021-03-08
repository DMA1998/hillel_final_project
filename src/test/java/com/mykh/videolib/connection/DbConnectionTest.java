package com.mykh.videolib.connection;

import junit.framework.TestCase;

import java.sql.SQLException;

public class DbConnectionTest extends TestCase {

    public void testGetConnection() {

        try {
            assertNotNull(DbConnection.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}