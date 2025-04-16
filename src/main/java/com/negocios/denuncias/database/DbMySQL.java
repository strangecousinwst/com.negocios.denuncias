package com.negocios.denuncias.database;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DbMySQL {

    private static final String MYSQLDRIVER = "com.mysql.jdbc.Driver";
    private static final String DBNAME = "efa0124_ms_denuncia";
    private static final String SERVER = "62.28.39.135:3306/";
    private static final String USER = "efa0124";
    private static final String PASSWORD = "123.Abc";
    private static final String URL = "jdbc:mysql://" + SERVER + DBNAME;

    public Connection getConnection() throws SQLException {
        try {
            Class.forName(MYSQLDRIVER);
            return DriverManager.getConnection(URL + DBNAME, USER, PASSWORD);
        } catch (Exception e) {
            throw new SQLException("Couldn't connect to database.", e);
        }
    }
}
