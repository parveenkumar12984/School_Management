package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

    public Connection c;
    public Statement s;

    public conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql:///school_management","root","root");
            s= c.createStatement();
            System.out.println("Connected");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


    public static void main(String args){
        new conn();
    }

}
