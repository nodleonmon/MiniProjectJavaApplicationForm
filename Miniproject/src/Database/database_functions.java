/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import  java.sql.*;


public class database_functions {
    
    public static String[] DatabaseNames = {"Users","Biodata"};
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    public static int database_connection(){
        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
        }
        catch(ClassNotFoundException cnfex) {

            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
            return 1;
        }
        try{
            //C:\Users\User\Desktop\School\SPG0422_JAVA\code\JAVA_miniproject\MiniProjectJavaApplicationForm\Miniproject\src\Database\Java_Miniproject.accdb
            String msAccDB = System.getProperty("user.dir") + "\\src\\Database\\Java_Miniproject.accdb";
            String dbURL = "jdbc:ucanaccess://"
                    + msAccDB;
 
            // Step 2.A: Create and
            // get connection using DriverManager class
            connection = DriverManager.getConnection(dbURL);
            // Step 2.B: Creating JDBC Statement 
            statement = connection.createStatement();
        }
        catch(SQLException sqlex){
            sqlex.printStackTrace();
            return 2;
        }
        
        return 0;
    }

    public static int database_list_all(String Table){
        try {
            
            database_connection();
            // Step 2.C: Executing SQL & retrieve data into ResultSet
            resultSet = statement.executeQuery("SELECT * FROM " + Table);

            System.out.println("ID\tName\t\t\tAge\tMatches");
            System.out.println("==\t================\t===\t=======");

            // processing returned data and printing into console
            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "\t" + 
                        resultSet.getString(2) + "\t" + 
                        resultSet.getString(3) + "\t" +
                        resultSet.getString(4));
            }
        }
        catch(SQLException sqlex){
            sqlex.printStackTrace();
            return 1;
        }
        database_close();
        return 0;
    }
    public static void database_Add(String Table, String Name, String IC_Num, int Age , String Profile_pic,
                                    String Education, String Edu_Attac, String Course1, String Course2, String Course3,
                                    String Phone_Num, String Email, String Address, String Supporting_Att){
        try{
            database_connection();
            if (Table == DatabaseNames[0] || Table == DatabaseNames[1]){
                PreparedStatement prestatement = connection.prepareCall(
                        "INSERT INTO " + Table + 
                        " ( [ID], [FullName], [IC], [Age], [Profile_Picture], [Education], "
                         + "[Education_Attachment], [Course_1], [Course_2], [Course_3],"
                        + " [Phone_Number], [Email], [Home_Address], [Supporting_Attachment] ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                
                prestatement.setInt(1, 6);
                prestatement.setString(2, Name);
                prestatement.setString(3, IC_Num);
                prestatement.setInt(4, Age);
                prestatement.setString(5, Profile_pic);
                prestatement.setString(6, Education);
                prestatement.setString(7, Edu_Attac);
                prestatement.setString(8, Course1);
                prestatement.setString(9, Course2);
                prestatement.setString(10, Course3);
                prestatement.setString(11, Phone_Num);
                prestatement.setString(12, Email);
                prestatement.setString(13, Address);
                prestatement.setString(13, Supporting_Att);
                
                prestatement.executeUpdate();    
                prestatement.close();
            }
        }
        //FullName	IC	Age	Profile_Picture	Education	Education_Attachment	Course_1	Course_2	Course_3	Phone_Number	Email	Home_Address	Supporting_Attachment
										
        catch(SQLException sqlex){
            sqlex.printStackTrace();
        }
    }
    public static void database_Add(String Table, String Name, String Password){
        try{
            database_connection();
            if (Table == DatabaseNames[0] || Table == DatabaseNames[1]){
                PreparedStatement prestatement = connection.prepareStatement(
                        "INSERT INTO " + Table 
                      + " ([ID], [Full_Name], [Password], [Admin_Check]) VALUES ( ? , ?, ?, ?)");
                prestatement.setInt(1, 6);
                prestatement.setString(2, Name);
                prestatement.setString(3, Password);
                prestatement.setBoolean(4, false);
                prestatement.executeUpdate();    
                prestatement.close();
            }
        }
        catch(SQLException sqlex){
            sqlex.printStackTrace();
        }
    }
    public static String[] database_search(String Table, String Username, String Password ){
        try{
            database_connection();
            if (Table == DatabaseNames[0]){
            
            String str = "SELECT * FROM " + Table + " WHERE "
                    + "Full_Name=\'" + Username + "\' AND "
                    + "Password=\'" + Password + "\' ";
            System.out.println(str);
            resultSet =  statement.executeQuery(str);  
            String[] search_result = new String[4];
            while(resultSet.next()){
                search_result[0] = resultSet.getString(1);
                search_result[1] = resultSet.getString(2);
                search_result[2] = resultSet.getString(3);
                search_result[3] = resultSet.getString(4);
            }
            //String[] search_result = {resultSet.getString(2),resultSet.getString(3) }; 
            database_close();
            return search_result;
            }
            if (Table == DatabaseNames[1]){
                
            String str = "SELECT * FROM " + DatabaseNames[0] + " WHERE "
                    + "Full_Name=\'" + Username + "\' AND "
                    + "Password=\'" + Password + "\' ";
            System.out.println(str);
            resultSet =  statement.executeQuery(str);  
            String[] first_search_result = new String[4];
            while(resultSet.next()){
                first_search_result[0] = resultSet.getString(1);
                first_search_result[1] = resultSet.getString(2);
                first_search_result[2] = resultSet.getString(3);
                first_search_result[3] = resultSet.getString(4);
            }
            
            resultSet = statement.executeQuery( "SELECT * FROM " + Table + " WHERE "
                    + " ID=\'" +
                    first_search_result[0] 
                    + "\' AND Full_Name=\'"
                    + first_search_result[1] +"\' ");
            String[] search_result = new String[14];
            while(resultSet.next()){
                search_result[0] = resultSet.getString(1);
                search_result[1] = resultSet.getString(2);
                search_result[2] = resultSet.getString(3);
                search_result[3] = resultSet.getString(4);
                search_result[4] = resultSet.getString(5);
                search_result[5] = resultSet.getString(6);
                search_result[6] = resultSet.getString(7);
                search_result[7] = resultSet.getString(8);
                search_result[8] = resultSet.getString(9);
                search_result[9] = resultSet.getString(10);
                search_result[10] = resultSet.getString(11);
                search_result[11] = resultSet.getString(12);
                search_result[12] = resultSet.getString(13);
                search_result[13] = resultSet.getString(14);
            }
            database_close();
            return search_result;
            }
            else{
                database_close();
                return null;
            }
            
        }
        catch(SQLException sqlex){
            sqlex.printStackTrace();
            database_close();
            return null;
        }
    }
    
    
    public static int database_close(){
        try {
            if(null != connection) {

                // cleanup resources, once after processing
                resultSet.close();
                statement.close();

                // and then finally close connection
                connection.close();
            }
        }
        catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
        return 0;
    }
    public static void main(String[] args) {

        database_list_all("Users");
        String[] results = database_search("Biodata", "aqip", "123");
        System.out.println(results[2]);
        //database_Add("Users", "Test_Add", "1234");
        
    }

    
}

