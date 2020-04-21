package db;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Ashish Jaiswal
 */
public class dbConnect {
    public static Connection c;
    public static Statement st;
    public static PreparedStatement insert;
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");

             try{
                 c = DriverManager.getConnection("jdbc:mysql://localhost:3306/library1","root","Incapp");
//                 System.out.println("Connected");
                 st = c.createStatement();
             }catch(Exception e){
                 c = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","Incapp");
                 st = c.createStatement();
                 st.executeUpdate("CREATE DATABASE library1");
                 c = DriverManager.getConnection("jdbc:mysql://localhost:3306/library1","root","Incapp");
                 st=c.createStatement();
                 st.executeUpdate("create table admin_login(username varchar(100) primary key, password varchar(50) not null)");
                 st.executeUpdate("create table student_login(username varchar(100) primary key, password varchar(50) not null)");
                 st.executeUpdate("insert into admin_login(username, password) values(\"admin\", \"admin\")");
                 st.executeUpdate("insert into student_login(username,password) values(\"Ashish\",\"ashish\") ");
//                 System.out.println("Created");
             }
             
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
       }
    }
    static public void dbClose(){
        try{
            c.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
//    public static void main(String[] a){
//        System.out.println("hello");
//        
//    }
}
