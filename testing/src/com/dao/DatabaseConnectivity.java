package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectivity {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/upshot?autoReconnect=true&useSSL=false","root","root");  
        }catch(Exception e){
        	e.printStackTrace();
        }  
        return con;  
    } 
	
    
}
