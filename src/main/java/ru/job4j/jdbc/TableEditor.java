package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Class.forName(properties.getProperty("driver_class"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = properties.getProperty("url");
        String login = properties.getProperty("username");
        String password = properties.getProperty("password");
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendQuery(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public void createTable(String tableName) throws SQLException {
        sendQuery(String.format("CREATE TABLE IF NOT EXISTS %s();", tableName));
    }

    public void dropTable(String tableName) throws SQLException {
        sendQuery(String.format("DROP TABLE IF EXISTS %s;", tableName));
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        sendQuery(String.format("ALTER TABLE %s ADD COLUMN IF NOT EXISTS %s %s;", tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        sendQuery(String.format("ALTER TABLE %s DROP COLUMN IF EXISTS %s;", tableName, columnName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        sendQuery(String.format("ALTER TABLE IF EXISTS %s RENAME COLUMN %s TO %s;", tableName, columnName, newColumnName));
    }


    public String getTableScheme(String tableName) throws SQLException {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s WHERE tablename = '%s' LIMIT 1", tableName, tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        try (var ted = new TableEditor(new Properties())) {
            ted.createTable("demo_table");
            System.out.println(ted.getTableScheme("demo_table"));
            ted.addColumn("demo_table", "name", "text");
            System.out.println(ted.getTableScheme("demo_table"));
            ted.renameColumn("demo_table", "name", "person_name");
            System.out.println(ted.getTableScheme("demo_table"));
            ted.dropColumn("demo_table", "person_name");
            System.out.println(ted.getTableScheme("demo_table"));
            ted.dropTable("demo_table");
            System.out.println(ted.getTableScheme("demo_table"));
        }
    }
}
