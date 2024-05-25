package com.perisic.tomato.peripherals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gamedb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);

        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
       
    static boolean validateLogin1(String username, String email, String password) {
        try {
            String query = "INSERT INTO login (username, email, password) VALUES (?, ?, ?)";
            try (Connection connection = Database.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, username);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, password);

                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        }
    
    public static boolean insertScoreIntoDatabase(int id, int level1, int level2, int level3, int score) {
        try {
            Connection connection = Database.getConnection();
            String query = "INSERT INTO score (id, level1, level2, level3, score) VALUES (?, ?)"; 
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, level1);
            preparedStatement.setInt(3, level2);
            preparedStatement.setInt(4, level3);
            preparedStatement.setInt(5, score);            
            int rowsAffected = preparedStatement.executeUpdate();
            connection.close();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    static void saveOverallScore(int id, int level1, int level2, int level3, int score) {

        try  {
            Connection connection = Database.getConnection();

            String sql = "INSERT INTO score (id, level1, level2, level3, score) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setInt(2, level1);
            statement.setInt(3, level2);
            statement.setInt(4, level3);
            statement.setInt(5, score);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    static void saveLevelScore(int id, int level, int score) {
        try {
           Connection connection = Database.getConnection();

            
            String sql = "INSERT INTO level_score (id, level, score) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            	preparedStatement.setInt(1, id);
            	preparedStatement.setInt(2, level);
                preparedStatement.setInt(3, score);
                preparedStatement.executeUpdate();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        
    
    static int validateLogin(String username, String password) {
        String query = "SELECT id FROM login WHERE username = ? AND password = ?";
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id"); 
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1; 
    }
    

    public static void main(String[] args) {
        Connection connection = null;

        try {
            
            connection = getConnection();

            

            System.out.println("Database connection successful!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
            closeConnection(connection);
        }
    }
}
