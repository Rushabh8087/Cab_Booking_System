
package Cab_Booking;

import java.awt.*; 
import java.awt.event.*;   //java library imported here so we can use different methods
import javax.swing.*;
import java.sql.*; 
import java.util.*;

public class View_Customer extends JFrame    //here we dot implements actionlistener because we buttons** are not there
{
    Font f;
    JTable t1;
    String x[]={"Username", "Name", "Age", "Date of birth", "Address", "Phone", "Email","Country", "Gender","Aadhar"};
    String y[][]=new String [20] [10];  //10 coloums of x array and 20 rows are there
    int i=0,j=0;  //iteration
    
    View_Customer()
    {
        super("All Customer Details");  //heading
        setSize (1300, 400);
        setLocation(0,10);
        f=new Font ("MS UI Gothic", Font. BOLD, 17);
        
        try
        {
           ConnectionClass obj=new ConnectionClass();
           String q="select * from customer";
           ResultSet rest= obj.stm.executeQuery (q);  //result store here
           while(rest.next())
          { 
            y[i][j++]=rest.getString("username");  //get sting from database
            y[i][j++]=rest.getString("name");
            y[i][j++]=rest.getString("age"); 
            y[i][j++]=rest.getString("dob");
            y[i][j++]=rest.getString("address");
            y[i][j++]=rest.getString("phone"); 
            y[i][j++]=rest.getString("Email");
            y[i][j++]=rest.getString("country"); 
            y[i][j++]=rest.getString("gender"); 
            y[i][j++]=rest.getString("aadhar");
            i++;
            j=0;
           }
           t1=new JTable(y,x);   //we add array in table
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        t1.setFont(f);
        t1.setBackground (Color.BLACK);
        t1.setForeground (Color. WHITE);    //text colour
        
        JScrollPane js=new JScrollPane(t1);   //to apply scroll bar to table1
        add(js);
        
    }
    public static void main(String args[])
    {
        new View_Customer().setVisible(true);
    }
}
