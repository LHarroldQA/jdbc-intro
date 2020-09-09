package com.qa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.qa.util.DatabaseConfiguration;

public class DatabaseConnector {
	
	private Connection conn;
	private Statement st;
	
	public DatabaseConnector() throws SQLException{
		 conn = DriverManager.getConnection(DatabaseConfiguration.URL, DatabaseConfiguration.USER, DatabaseConfiguration.PASSWORD);
	}
	
	public void close() throws SQLException {
        conn.close();
    }
	
    public void createActor(String forename, String surname) throws SQLException {
        st.executeUpdate(String.format("INSERT INTO actor(`first_name`, `last_name`)" + " VALUES('%s', '%s')", forename, surname));
    }

    public void readAllActors() throws SQLException {
        String sql = "SELECT * FROM actor";
        this.st = conn.createStatement();
        ResultSet rs = this.st.executeQuery(sql);

        while (rs.next()) {
            System.out.println(rs.getString("actor_id") + " " + rs.getString("first_name") + " " + rs.getString("last_name"));
        }
    }
    
    public void readActor(int readId) throws SQLException {
        String sql = String.format("SELECT * FROM actor where `actor_id` = '%d'", readId);
        this.st = conn.createStatement();
        ResultSet rs = this.st.executeQuery(sql);
        while (rs.next()) {
        	System.out.println(rs.getString("actor_id") + " " + rs.getString("first_name") + " " + rs.getString("last_name"));
        }
    }

    public void updateActor(int updateId,String oldforename,String oldsurname) throws SQLException {
    	st.executeUpdate(String.format("UPDATE actor set `first_name` = '%s',`last_name` = '%s'   where `actor_id` = '%d'", oldforename, oldsurname,updateId));
    }

    public void deleteActor(int deleteId) throws SQLException {
        st.executeUpdate(String.format("DELETE from actor  where `actor_id` = '%d'", deleteId));
    }
}

