package hotel.management.system;


import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{

    JTable table;
    
    JButton back;
    
    
    CustomerInfo(){
        
        getContentPane().setBackground(Color.WHITE); 
        setLayout(null);
        
        
        
         JLabel l1 = new JLabel("Document Type");
         l1.setBounds(20,10,100,20);
         add(l1);
         
         JLabel l2 = new JLabel("Number");
         l2.setBounds(160,10,100,20);
         add(l2);
         
         JLabel l3 = new JLabel("Name");
         l3.setBounds(290,10,100,20);
         add(l3);
         
         JLabel l4 = new JLabel("Gender");
         l4.setBounds(410,10,100,20);
         add(l4);
         
         JLabel l5 = new JLabel("Country");
         l5.setBounds(530,10,100,20);
         add(l5);
         
         JLabel l6 = new JLabel("Room Number");
         l6.setBounds(640,10,100,20);
         add(l6);
         
         JLabel l7 = new JLabel("Checkintime");
         l7.setBounds(780,10,100,20);
         add(l7);
         
         JLabel l8 = new JLabel("Deposit");
         l8.setBounds(900,10,100,20);
         add(l8);
         
         
         
        
         
         
      
         table = new JTable();
         table.setBounds(0,40,1000,400);
         add(table);
         
         try{
          
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
             
         }catch(Exception e){
             e.printStackTrace();
         }
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(420,500,120,30);
        back.addActionListener(this);
        add(back);
        
        
        
        setBounds(450,270,1000,600);
        setVisible(true);
        
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == back)
        {
              setVisible(false);
              new Reception();
        }
    }
    
    
    public static void main(String[] args){
        new CustomerInfo();
    }
    
}