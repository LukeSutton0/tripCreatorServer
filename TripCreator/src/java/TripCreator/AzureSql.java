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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class AzureSql {
    public static String main(String sql,int executeFunction){
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
        String result="error";
        
        if(executeFunction == 1){ //select user ids from users
            result = azure.ExecuteAzureSqlInsertUserId(userName, userPass, sql, cnnString);
            return result;
        }
        else if(executeFunction == 2){//insert user id into db on account creation
            result = azure.ExecuteAzureSqlInsertUserId(userName, userPass, sql, cnnString);
        }
        else if(executeFunction == 3){//update password
            result = azure.ExecuteAzureSqlInsertUserPass(userName, userPass, sql, cnnString);
        }
        else if(executeFunction == 4){//
            result = azure.ExecuteAzureSqlListTrips(userName, userPass, sql, cnnString);
        }
        else if(executeFunction == 5){//
            result = azure.ExecuteAzureSqlInsertTrip(userName, userPass, sql, cnnString);
        }
        else if(executeFunction == 6){//
            result = azure.ExecuteAzureSqlSelectPreferences(userName, userPass, sql, cnnString);
            //result = azure.ExecuteAzureSqlInsertUserId(userName, userPass, sql, cnnString);
        }
        else if(executeFunction == 7){//
            result = azure.ExecuteAzureSqlUpdatePref(userName, userPass, sql, cnnString);
        }
        
        return result;
 
    }
    
    //select user ids from users
    public String ExecuteAzureSqlSelect(String userName, String userPass, String sql, String cnnStr){
        ResultSet resultSet = null;
        String result = "";
        try(Connection cnn = DriverManager.getConnection(cnnStr);Statement statement = cnn.createStatement();){
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
    
    //insert user id into db
    public String ExecuteAzureSqlInsertUserId(String userName, String userPass, String sql, String cnnStr){
        ResultSet resultSet = null;
        String result = "";
        try(Connection cnn = DriverManager.getConnection(cnnStr);Statement statement = cnn.createStatement();){
                statement.executeUpdate(sql);
                result = "Insert Successful";
        }
        catch(SQLException e){
            //throw new RuntimeException("Error executing sql");
            result = "error";
                e.printStackTrace();
                }  
        return result;
    }
    public String ExecuteAzureSqlInsertUserPass(String userName, String userPass, String sql, String cnnStr){
         ResultSet resultSet = null;
         String result = "";
         try(Connection cnn = DriverManager.getConnection(cnnStr);Statement statement = cnn.createStatement();){
                 statement.executeUpdate(sql);
                 result = "Update Successful";
         }
         catch(SQLException e){
             //throw new RuntimeException("Error executing sql");
             result = "error";
                 e.printStackTrace();
                 }  
         return result;
     }
    public String ExecuteAzureSqlListTrips(String userName, String userPass, String sql, String cnnStr){
            ResultSet resultSet = null;
            String result = "";
            try(Connection cnn = DriverManager.getConnection(cnnStr);Statement statement = cnn.createStatement();){
                    resultSet = statement.executeQuery(sql);
                    String trip_Id = "";
                    String location = "";
                    String date = "";
                    String weather= "";
                    String interested= "";
                    String user_id_owner = "";
                    String jsonString = "";
                    while(resultSet.next()){
                        trip_Id = trip_Id + resultSet.getString(1) + ',';
                        location = location + resultSet.getString(2)+',';
                        date = date + resultSet.getString(3)+',';
                        weather = weather + resultSet.getString(4)+',';
                        interested = interested + resultSet.getString(5)+',';
                        user_id_owner = user_id_owner + resultSet.getString(6)+',';
                        jsonString = jsonString +
                                "{"+ 
                                "\"trip_Id\":"+resultSet.getString(1)+"," + 
                                "\"location\":\"" +resultSet.getString(2)+ "\""  +"," + 
                                "\"date\":\"" +resultSet.getString(3)+ "\""  +"," + 
                                "\"weather\":\"" +resultSet.getString(4)+ "\""  +"," + 
                                "\"interested\":\"" +resultSet.getString(5)+"\"" +"," + 
                                "\"user_id_owner\":" +resultSet.getString(6) + 
                                "},";
                        
                        //result = result+(resultSet.getString(1)+","+resultSet.getString(2));
                    }
                    //result = trip_Id +"|"+ location +"|"+ date +"|"+ weather +"|"+ interested +"|"+ user_id_owner;
                    //System.out.println("Worked");
                    jsonString = jsonString.substring(0,jsonString.length()-1);
                    String jsonArray = "["+jsonString+"]";
                    //System.out.println(jsonArray);
                    result = jsonArray;
            }
            catch(SQLException e){
                //throw new RuntimeException("Error executing sql");
                result = "error";
                    e.printStackTrace();
                    }  
            return result;
        }
    public String ExecuteAzureSqlInsertTrip(String userName, String userPass, String sql, String cnnStr){
       ResultSet resultSet = null;
        String result = "";
        try(Connection cnn = DriverManager.getConnection(cnnStr);Statement statement = cnn.createStatement();){
                statement.executeUpdate(sql);
                result = "Insert Successful";
        }
        catch(SQLException e){
            //throw new RuntimeException("Error executing sql");
            result = "error";
                e.printStackTrace();
                }  
        return result;
    }
    public String ExecuteAzureSqlSelectPreferences(String userName, String userPass, String sql, String cnnStr){
        ResultSet resultSet = null;
        String result = "";
        try(Connection cnn = DriverManager.getConnection(cnnStr);Statement statement = cnn.createStatement();){
                    resultSet = statement.executeQuery(sql);
                    while(resultSet.next()){
                        result = result + resultSet.getString(1);
                        //result = result+(resultSet.getString(1)+","+resultSet.getString(2));
                    }
        }
        catch(SQLException e){
            //result = e.toString();
            e.printStackTrace();
            }  
        
        return result;
    }
    public String ExecuteAzureSqlUpdatePref(String userName, String userPass, String sql, String cnnStr){
       ResultSet resultSet = null;
        String result = "";
        try(Connection cnn = DriverManager.getConnection(cnnStr);Statement statement = cnn.createStatement();){
                statement.executeUpdate(sql);
                result = "Insert Successful";
        }
        catch(SQLException e){
            //throw new RuntimeException("Error executing sql");
            result = "error";
                e.printStackTrace();
                }  
        return result;
    }
}