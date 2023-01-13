package TripCreator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Luke Sutton
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AzureSql2 {
    public static String main(String SqlFunction,String TableName,String TableHeaders){
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
        AzureSql2 azure = new AzureSql2();
        String sql = SqlFunction+" "+TableHeaders+ " From "+ TableName + ";";
        String result = null;
        result = sql;
        
        if(SqlFunction.equals("SELECT")){
            //set sql here
            result = azure.SelectAzureSql(userName, userPass, sql, cnnString);
            
        }
        else if(SqlFunction.equals("INSERTINTO")){
        }
        
       
        
        return result;
 
    }
    
    
    public String SelectAzureSql(String userName, String userPass, String sql, String cnnStr){
        
        ResultSet resultSet = null;
        String result = "";
        try(Connection cnn = DriverManager.getConnection(cnnStr);
                Statement statement = cnn.createStatement();){
                    resultSet = statement.executeQuery(sql);
                    while(resultSet.next()){
                        result = result + resultSet.getString(1) + ',';
                        //result = result+(resultSet.getString(1)+","+resultSet.getString(2));
                    }
        }
        catch(SQLException e){
            result = e.toString();
                e.printStackTrace();
                }  
        
        return result;
    }
}