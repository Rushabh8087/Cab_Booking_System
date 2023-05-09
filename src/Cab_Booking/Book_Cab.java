
package Cab_Booking;

import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.sql.*; 
import java.util.*;

public class Book_Cab extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9 ;
    Font f,f1;
    Choice ch1,ch2,ch3;
    JButton bt1, bt2;
    JPanel p1,p2,p3;
    
    Book_Cab()
    {
       super("Book Intracity Cab"); 
       setLocation (50,10); 
       setSize (1100,700); 
       
       f=new Font("Arial", Font. BOLD, 20);
       f1=new Font("Arial", Font. BOLD, 15);
       
       ch1=new Choice();
       ch2=new Choice();//choice 2 is destination which depends on the choice 1 which is source 
       ch3=new Choice();
       
       try
       {
           ConnectionClass obj=new ConnectionClass();
           String q="select source from intercity_driver";
           ResultSet rest=obj.stm.executeQuery(q);
           while(rest.next())
           {
               ch1.add(rest.getString("source"));    
           }
           rest.close();
       }
       catch(Exception ee)
       {
            ee.printStackTrace();
       }
       try
       {
           ConnectionClass obj=new ConnectionClass();
           String q="select source from customer";
           ResultSet rest=obj.stm.executeQuery(q);
           while(rest.next())
           {
               ch3.add(rest.getString("customer"));    
           }
           rest.close();
       }
       catch(Exception e)
       {
            e.printStackTrace();
       }
       
       l1=new JLabel("Book Intracity Cab");
       l2=new JLabel("Book ID");
       l3=new JLabel("Source"); 
       l4=new JLabel ("Destination"); 
       l5=new JLabel("Username"); 
       l6=new JLabel("Name");
       l7=new JLabel("Driver Name"); 
       l8=new JLabel ("car"); 
       l9=new JLabel ("Destination from");
       l10=new JLabel("Destination to");
       l11=new JLabel ("Price");
       
       tf1=new JTextField();
       tf3=new JTextField(); 
       tf4=new JTextField(); 
       tf5=new JTextField(); 
       tf6=new JTextField();
       tf7=new JTextField();
       tf8=new JTextField();
       
       tf1.setEditable(false);
       tf3.setEditable(false); 
       tf4.setEditable(false); 
       tf5.setEditable(false); 
       tf6.setEditable (false); 
       tf7.setEditable (false); 
       tf8.setEditable (false);
       bt1=new JButton("Book Cab"); 
       bt2=new JButton("Back");
       
       bt1.addActionListener(this);
       bt2.addActionListener(this);
       
       bt1.setBackground(Color.YELLOW);
       bt2.setBackground(Color.RED);
       
       bt1.setForeground(Color.BLACK);
       bt1.setForeground(Color.WHITE);
       
       Random rm=new Random();
       tf1.setText(""+Math.abs(rm.nextInt() %100000)); 
       tf1.setForeground(Color.RED);
       
       l1.setFont(f);
       l2.setFont(f1);
       l3.setFont(f1);
       l4.setFont(f1);
       l5.setFont(f1);
       l6.setFont(f1);
       l7.setFont(f1);
       l8.setFont(f1);
       l9.setFont(f1);
       l10.setFont(f1);
       l11.setFont(f1);
       ch1.setFont(f1);
       ch2.setFont(f1);
       ch3.setFont(f1);
       
       l1.setHorizontalAlignment(JLabel.CENTER);
       
       tf1.setFont(f1);
       tf2.setFont(f1);
       tf3.setFont(f1);
       tf4.setFont(f1);
       tf5.setFont(f1);
       tf6.setFont(f1);
       tf7.setFont(f1);
       tf8.setFont(f1);
       
       bt1.setFont(f1);
       bt2.setFont(f1);
       
       p1=new JPanel();
       p1.setLayout(new GridLayout(1,1,10,10));  
       p1.add(l1);
       
       p2=new JPanel();
       p2.setLayout(new GridLayout(11,2,10,10));  
       
       p2.add(l2);
       p2.add(tf1);
       p2.add(l3);
       p2.add(ch1);
       p2.add(l4);
       p2.add(ch2);
       p2.add(l5);
       p2.add(ch3);
       p2.add(l6);
       p2.add(tf3);
       p2.add(l7);
       p2.add(tf4);
       p2.add(l8);
       p2.add(tf5);
       p2.add(l9);
       p2.add(tf6);
       p2.add(l10);
       p2.add(tf7);
       p2.add(l11);
       p2.add(tf8);
       p2.add(bt1);
       p2.add(bt2);
       
       ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Cab_Booking/Icons/signin.jpg"));
       Image img=ic.getImage().getScaledInstance (300,800, Image.SCALE_DEFAULT);   //to set size of image
       ImageIcon ic1=new ImageIcon (img);
       l12=new JLabel(ic1);
       
       p3=new JPanel();
       p3.setLayout(new GridLayout(1,1,10,10));  
       p3.add(l12);
       
       setLayout(new BorderLayout(10,10));
       add(p1,"North");
       add(p2,"Center");
       add(p3,"West");
       
       
       
    }
    public static void main(String[] args)
    {
        new Book_Cab().setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        
    }
    
}
