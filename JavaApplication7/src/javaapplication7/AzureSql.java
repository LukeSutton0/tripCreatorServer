/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Luke Sutton
 */
public class AzureSql {
    public static void main(String[] args) {
        
        int executeFunction = 6;
        
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
        
        String test = "123123123";
        String test2 = "'mypass3333' ";
        String sql = "";
        System.out.println(sql);
        
        String result = null;
        
//        String id = "{\"id\":\"6443\"}";
//        id = id.substring(7,id.length()-2);
//        System.out.println(id);
        
        
        if(executeFunction == 1){
           result = azure.SelectAzureSql(userName, userPass, sql, cnnString);
           //return result;
           System.out.println(result);
        }
        else if(executeFunction == 2){
            result = azure.ExecuteAzureSqlInsertUserId(userName, userPass, sql, cnnString);
            System.out.println(result);
        }
        else if(executeFunction == 3){
            sql = "UPDATE users SET pass="+test2+"WHERE user_id =123123123;";
            result = azure.ExecuteAzureSqlInsertUserPass(userName, userPass, sql, cnnString);
            System.out.println(result);
        }
        else if(executeFunction == 4){
            sql = "SELECT * FROM trips WHERE user_id_owner="+1+";";
            result = azure.ExecuteAzureSqlListTrips(userName, userPass, sql, cnnString);
            System.out.println(result);
        }
        else if(executeFunction ==5){
            String test11 = "Test";
            sql = "INSERT INTO trips (location,date,weather,userIdOwner)VALUES('"+test11+"',20220901,'clear',5)";
            System.out.println(sql);
            result = azure.ExecuteAzureInsertTrip(userName, userPass, sql, cnnString);
            System.out.println("end");
        }
        else if(executeFunction == 6){//
            int tripId = 24;
            sql = "SELECT interested FROM trips WHERE trip_id ="+tripId+"";
            System.out.println(sql);
            //sql = "SELECT interested FROM trips WHERE trip_id = 24";
            result = azure.ExecuteAzureSqlSelectPreferences(userName, userPass, sql, cnnString);
            System.out.println(result);
            //result = azure.ExecuteAzureSqlInsertUserId(userName, userPass, sql, cnnString);
        }

    }
    
    
    public String SelectAzureSql(String userName, String userPass, String sql, String cnnStr){
        
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
            result = "error";
                e.printStackTrace();
                }  
        return result;
    }
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
                    System.out.println("Worked");
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
                                "\"interested\":" +resultSet.getString(5) +"," + 
                                "\"user_id_owner\":" +resultSet.getString(6) + 
                                "},";
                        
                        //result = result+(resultSet.getString(1)+","+resultSet.getString(2));
                    }
                    //result = trip_Id +"|"+ location +"|"+ date +"|"+ weather +"|"+ interested +"|"+ user_id_owner;
                    System.out.println("Worked");
                    jsonString = jsonString.substring(0,jsonString.length()-1);
                    String jsonArray = "["+jsonString+"]";
                    System.out.println(jsonArray);
                    result = jsonArray;
            }
            catch(SQLException e){
                //throw new RuntimeException("Error executing sql");
                result = "error";
                    e.printStackTrace();
                    }  
            return result;
        }

    public String ExecuteAzureInsertTrip(String userName, String userPass, String sql, String cnnStr){
           ResultSet resultSet = null;
            String result = "";
            System.out.println("test1");
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
                        System.out.println(result);
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

