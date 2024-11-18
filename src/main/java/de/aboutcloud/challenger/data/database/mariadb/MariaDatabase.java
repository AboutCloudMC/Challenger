package de.aboutcloud.challenger.data.database.mariadb;

import java.sql.*;

public class MariaDatabase {

    private final String URL;
    private final String USER;
    private final String PASSWORD;

    private final Connection CON;

    public MariaDatabase(String host, String name, String user, String password) {
        this.URL = "jdbc:mariadb://" + host + ":3306/" + name;
        this.USER = user;
        this.PASSWORD = password;


        this.CON = this.connect();
        if (CON != null) {
            createTable();
        }
    }

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS timer (" +
                "id VARCHAR(255) PRIMARY KEY," +
                "startTime BIGINT," +
                "endTime BIGINT," +
                "running BOOLEAN)";
        try {
            this.CON.prepareStatement(sql).execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return CON;
    }
}
