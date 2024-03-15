package hotel.management.system;


import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener{

    JTable table;
    
    JButton back,submit;
    JComboBox bedtype;
    JCheckBox available;
    
    SearchRoom(){
        
        getContentPane().setBackground(Color.WHITE); 
        setLayout(null);
        
        
        JLabel text = new JLabel("Search for Room");
        text.setBounds(430,30,200,30);
        text.setFont(new Font("serif",Font.BOLD,20));
        add(text);
        
         JLabel lblbed = new JLabel("Bed Type");
         lblbed.setBounds(50,100,100,20);
         add(lblbed);
        
         bedtype = new JComboBox(new String[]{"Single Bed","Double Bed"});
         bedtype.setBounds(150,100,150,25);
         bedtype.setBackground(Color.WHITE);
         add(bedtype);
         
         available = new JCheckBox("Only display Available");
         available.setBounds(650,100,160,20);
         available.setBackground(Color.WHITE);
         add(available);
         
         
         
         JLabel l1 = new JLabel("Room Number");
         l1.setBounds(50,160,100,20);
         add(l1);
         
         JLabel l2 = new JLabel("Availability");
         l2.setBounds(260,160,100,20);
         add(l2);
         
         JLabel l3 = new JLabel("Cleaning Status");
         l3.setBounds(450,160,100,20);
         add(l3);
         
         JLabel l4 = new JLabel("Price");
         l4.setBounds(670,160,100,20);
         add(l4);
         
         JLabel l5 = new JLabel("Bed Type");
         l5.setBounds(870,160,100,20);
         add(l5);
         
         
         
        
         
         
      
         table = new JTable();
         table.setBounds(0,200,1000,300);
         add(table);
         
         try{
          
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
             
         }catch(Exception e){
             e.printStackTrace();
         }
         
        submit = new JButton("Search");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300,520,120,30);
        submit.addActionListener(this);
        add(submit);
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(500,520,120,30);
        back.addActionListener(this);
        add(back);
        
        
        
        setBounds(450,270,1000,600);
        setVisible(true);
        
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == submit){
         
            try{
                
               String query1 = "select * from room where bed_type = '"+bedtype.getSelectedItem()+"'"  ;
               String query2 = "select * from room where availability = 'Available' AND bed_type = '"+bedtype.getSelectedItem()+"'";
               ResultSet rs;
               Conn conn = new Conn();
               
               if(available.isSelected()){
                   rs = conn.s.executeQuery(query2);
               }
               else{
                   rs = conn.s.executeQuery(query1);
               }
              
               table.setModel(DbUtils.resultSetToTableModel(rs));
               
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == back)
        {
              setVisible(false);
              new Reception();
        }
    }
    
    
    public static void main(String[] args){
        new SearchRoom();
    }
    
}