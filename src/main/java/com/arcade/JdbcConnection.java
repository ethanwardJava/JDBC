package com.arcade;

import java.sql.*;

public class JdbcConnection {
    public static void operate() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:./toDo;AUTO_SERVER=TRUE");
        String sqlCreate = "CREATE TABLE IF NOT EXISTS Task (id identity primary key , name varchar)";
        var statement = connection.createStatement();
        statement.execute(sqlCreate);

        String sqlInsert = "INSERT INTO Task (name) VALUES ('Learn Java !')";
        statement.execute(sqlInsert);

        String dynamicInsert = "INSERT INTO Task (name) VALUES (?)";
        PreparedStatement ps = connection.prepareStatement(dynamicInsert);
        ps.setString(1, "Learn Spring!");
        ps.executeUpdate();

        String updateStatement = "UPDATE Task SET name = ?  WHERE name = 'Learn Java !'";
        ps = connection.prepareStatement(updateStatement);
        ps.setString(1, "Jakarta EE!");
        ps.executeUpdate();

//        String deleteStatement = "DELETE FROM Task WHERE name = 'Jakarta EE!'";
//        ps = connection.prepareStatement(deleteStatement);
//        ps.executeUpdate();


        String query = "SELECT * FROM Task";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("============================");
            System.out.println("ID: " + id + " NAME: " + name);
        }


    }
}
