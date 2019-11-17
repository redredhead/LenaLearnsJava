package com.epam.elena_paveleva.java.database;

import java.sql.*;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;

public class MainDB {

    public static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_NAME = "vepamke";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "P@ssw0rd";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

            DatabaseService dbservice = new DatabaseService();
            List<User> users = dbservice.retrieveUsersByName("Andy");
            for (User user:users) {
                user.printInfo();
            }
        }



    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL + DB_NAME, USER_NAME, PASSWORD);
    }

}
