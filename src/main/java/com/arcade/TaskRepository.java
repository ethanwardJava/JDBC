package com.arcade;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
            statement.setLong(2,task.getId());
            statement.executeUpdate();
        }
    }

    public static void deleteAll() throws Exception {
        try (Connection conn = getDataSource().getConnection()) {

        }
    }


    public static List<Task> findAll() throws Exception {
        try (Connection conn = getDataSource().getConnection()) {

        }
        return List.of();
    }
}
