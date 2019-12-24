package com.epam.elena_paveleva.java.database.client;

import com.epam.elena_paveleva.java.database.DatabaseService;
import com.epam.elena_paveleva.java.database.user.User;
import com.epam.elena_paveleva.java.database.user.UserDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MainDB {

    public static final String URL = "jdbc:mysql://localhost:3306/";
  //  public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_NAME = "vepamke";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "P@ssw0rd";
    public static Connection conn;

    public static void main(String[] args) throws SQLException {
            try  {
                conn = getConnection();
                DatabaseService dbservice = new DatabaseService();
                User user1 = new User();
                user1.setName("Judy");
                user1.setSurname("Smolton");
              //  user1.setBirthday(LocalDate.parse("1990-05-17"));


                UserDaoImpl userDaoImpl = new UserDaoImpl();
                userDaoImpl.insertUser(user1);
                List <User> users = userDaoImpl.selectUsersFromTask(0,0,1);

                // List<User> users = dbservice.retrieveUsersByName("Andy");
                for (User user : users) {
                    user.printInfo();
                }

            } finally {
                if (!conn.isClosed()) {
                    conn.close();
                }
            }
        }
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL + DB_NAME, USER_NAME, PASSWORD);
    }



}
