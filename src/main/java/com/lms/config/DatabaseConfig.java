package com.lms.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConfig {
    private static HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/lms");
        config.setUsername("root");
        config.setPassword("root");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        // Connection pool settings
        config.setMaximumPoolSize(10); // Maximum number of connections
        config.setMinimumIdle(2); // Minimum number of idle connections
        config.setIdleTimeout(30000); // Idle timeout in milliseconds
        config.setConnectionTimeout(30000); // Connection timeout in milliseconds
        config.setMaxLifetime(1800000); // Maximum lifetime of a connection in milliseconds

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    
    // Optional: Shutdown method for closing the data source when the application is stopped
    public static void shutdown() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}
