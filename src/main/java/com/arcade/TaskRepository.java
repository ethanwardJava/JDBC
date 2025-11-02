package com.arcade;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private static final String URL = "jdbc:h2:./toDo;AUTO_SERVER=TRUE";

    private static DataSource getDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        return new HikariDataSource(config);
    }


    public static void create(Task task) throws Exception {
        try (Connection conn = getDataSource().getConnection()) {
            String sql = "INSERT INTO Task (name) VALUES (?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, task.getName());
            statement.executeUpdate();
        }
    }

    public static void update(Task task) throws Exception {
        try (Connection conn = getDataSource().getConnection()) {
            String sql = "UPDATE Task SET name=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, task.getName());
            statement.setLong(2, task.getId());
            statement.executeUpdate();
        }
    }

    public static void deleteAll() throws Exception {
        try (Connection conn = getDataSource().getConnection()) {
            String sql = "DELETE FROM Task";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeUpdate();
        }
    }


    public static List<Task> findAll() throws Exception {
        List<Task> tasks = new ArrayList<>();
        try (Connection conn = getDataSource().getConnection()) {
            String sql = "SELECT * FROM Task";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task(resultSet.getInt(1), resultSet.getString(2));
                tasks.add(task);
            }
        }
        return tasks;
    }
}
