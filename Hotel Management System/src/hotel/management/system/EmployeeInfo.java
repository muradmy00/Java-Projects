package hotel.management.system;


import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener{

    JTable table;
    
    JButton back;
    
    
    EmployeeInfo(){
        
        getContentPane().setBackground(Color.WHITE); 
        setLayout(null);
        
        
        
         JLabel l1 = new JLabel("Name");
         l1.setBounds(30,10,100,20);
         add(l1);
         
         JLabel l2 = new JLabel("Age");
         l2.setBounds(170,10,100,20);
         add(l2);
         
         JLabel l3 = new JLabel("Gender");
         l3.setBounds(290,10,100,20);
         add(l3);
         
         JLabel l4 = new JLabel("Position");
         l4.setBounds(405,10,100,20);
         add(l4);
         
         JLabel l5 = new JLabel("Salary");
         l5.setBounds(530,10,100,20);
         add(l5);
         
         JLabel l6 = new JLabel("Phone Number");
         l6.setBounds(640,10,100,20);
         add(l6);
         
         JLabel l7 = new JLabel("Email");
         l7.setBounds(780,10,100,20);
         add(l7);
         
         JLabel l8 = new JLabel("ID Number");
         l8.setBounds(900,10,100,20);
         add(l8);
         
         
         
        
         
         
      
         table = new JTable();
         table.setBounds(0,40,1000,400);
         add(table);
         
         try{
          
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from employee");
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
        new EmployeeInfo();
    }
    
}