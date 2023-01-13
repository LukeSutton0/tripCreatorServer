/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Luke Sutton
 */
public class AzureSql1 {
    public static void main(String[] args) {

        String userName = "tripcreatoradmin";
        String userPass = "tripPass#";
        String cnnString = 
                "jdbc:sqlserver://tripcreatorserver.database.windows.net;"
                +"database=tripcreatortripsdb;"
                +"user=" + userName + ";"
                +"password=" + userPass + ";"
                +"encyption=true;"
                +"trustServerCertificate=false;"
                +"loginTimeout=30;";
        AzureSql1 azure = new AzureSql1();
        String sql = "SELECT user_id FROM users;";
        
        System.out.println(cnnString);
        azure.SelectAzureSql(userName, userPass, sql, cnnString);

 
    }
    
    
    private void SelectAzureSql(String userName, String userPass, String sql, String cnnStr){
        
        ResultSet resultSet = null;
        try(Connection cnn = DriverManager.getConnection(cnnStr);Statement statement = cnn.createStatement();){
                    resultSet = statement.executeQuery(sql);
                    while(resultSet.next()){
                        System.out.println(resultSet.getString(1));
                        //result = result+(resultSet.getString(1)+","+resultSet.getString(2));
                    }
        }
        catch(SQLException e){
                    e.printStackTrace();
                    System.out.println("SQLException: " + e.getMessage());
                    System.out.println("SQLState: " + e.getSQLState());
                    System.out.println("VendorError: " + e.getErrorCode());
                }  
        
    }
}

