package Cab_Booking;

import java.sql.*;

public class ConnectionClass
{
    Connection con;
    Statement stm;   //query fire form this variable
    ConnectionClass()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_management","root","Jinal#");
            stm=con.createStatement();
            if(con.isClosed())
            {
                System.out.println("yes");
            }
            else
            {
                System.out.println("No");    //if connection is created already
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace(); 
                    
        }   
    }
    public static void main(String args[])
    {
        new ConnectionClass();
    }
}
