package com.epam.elena_paveleva.java.database;

import java.sql.*;
import java.util.ArrayList;

import static com.epam.elena_paveleva.java.database.MainDB.*;

public class DatabaseService {

    //private Connection conn = null;
    //private PreparedStatement st = null;

    public static ArrayList<User> retrieveUsersByName(String name) {
        ResultSet rs = null;
        ArrayList users = new ArrayList<User>();
        try (PreparedStatement st = MainDB.conn.prepareStatement("SELECT * FROM users " +
                "WHERE name = ? ")) {
            st.setString(1, name);
            rs = st.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setBirthday(rs.getDate("birthdate").toLocalDate());
                users.add(user);
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    /* public static boolean isFriendshipExists(String userid1, String userid2) {
        ResultSet rs = null;
        boolean isExists = false;
        try (Connection conn = getConnection();
             PreparedStatement st = conn.prepareStatement("SELECT * FROM friendships " +
                     "WHERE userid1 = ? AND userid2 = ?")) {
            st.setString(1, userid1);
            st.setString(2, userid2);
            rs = st.executeQuery();
            isExists = rs.next();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return isExists;
    }
 */

}
