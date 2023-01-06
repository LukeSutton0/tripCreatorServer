/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TripCreator;

/**
 *
 * @author Luke Sutton
 */
import java.sql.*;
public class AzureSql {
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
        AzureSql azure = new AzureSql();
        String sql = SqlFunction+" "+TableHeaders+ " From "+ TableName + ";";
        String result = null;
        
        if(SqlFunction.equals("SELECT")){
            result = azure.SelectAzureSql(userName, userPass, sql, cnnString);
        }
        else if(SqlFunction.equals("INSERTINTO")){
        }
        return result;
 
    }
    
    
    public String SelectAzureSql(String userName, String userPass, String sql, String cnnStr){
        System.out.println("selecting data..");
        ResultSet resultSet = null;
        try(Connection cnn = DriverManager.getConnection(cnnStr);
                Statement statement = cnn.createStatement();){
                    resultSet = statement.executeQuery(sql);
                    String result;
                    while(resultSet.next()){
                        //result = result.append(resultSet.getString();
                        System.out.println(resultSet.getString(1)+","+resultSet.getString(2));
                    }
        }
        catch(SQLException e){
                e.printStackTrace();
                }  
        
        return "a";
    }
}
