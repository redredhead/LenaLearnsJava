package com.epam.elena_paveleva.java.database;

import java.sql.*;
import java.util.ArrayList;

import static com.epam.elena_paveleva.java.database.MainDB.*;

public class DatabaseService {

    private Connection conn = null;
    private PreparedStatement st = null;

    ArrayList<User> retrieveUsersByName(String name) {
        ResultSet rs = null;
        ArrayList users = new ArrayList<User>();
        try {
            conn = getConnection();
            st = conn.prepareStatement("SELECT * FROM users " +
                    "WHERE name = ?");
            st.setString(1, name);
            rs = st.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt(1)
                        , rs.getString(2)
                        , rs.getString(3)
                        , rs.getDate(4).toLocalDate()));
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL + DB_NAME, USER_NAME, PASSWORD);
    }
}
