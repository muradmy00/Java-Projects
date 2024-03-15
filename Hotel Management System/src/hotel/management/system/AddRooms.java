package hotel.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{
    
    JLabel lblroomno,lblavailable,lblclean,lblprice,lbltype;
    JTextField tfroom,tfavailable,tfprice;
    JComboBox availablecombo,cleancombo,typecombo;
    JButton add,cancel;
    
    AddRooms()
    {
         setLayout(null);
         
         
         
        JLabel heading = new JLabel("Add Rooms");
        heading.setBounds(150,20,200,20);
        heading.setFont(new Font("serif",Font.BOLD,18));
        add(heading);
         
          
        lblroomno = new JLabel("Room Number");
        lblroomno.setBounds(60,80,120,30);
        lblroomno.setFont(new Font("serif",Font.PLAIN,16));
        add(lblroomno);
      
        
        tfroom = new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);
        
        
        
        lblavailable = new JLabel("Available");
        lblavailable.setBounds(60,130,120,30);
        lblavailable.setFont(new Font("serif",Font.PLAIN,16));
        add(lblavailable);
      
        
        String availableOptions[] = { "Available","Occupied"};
        availablecombo = new JComboBox(availableOptions);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        
        
        lblclean = new JLabel("Cleaning Status");
        lblclean.setBounds(60,180,120,30);
        lblclean.setFont(new Font("serif",Font.PLAIN,16));
        add(lblclean);
      
        
        String cleanOptions[] = { "Cleaned","Dirty"};
        cleancombo = new JComboBox(cleanOptions);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);
        
        
               
        lblprice = new JLabel("Price");
        lblprice.setBounds(60,230,120,30);
        lblprice.setFont(new Font("serif",Font.PLAIN,16));
        add(lblprice);
      
        
        tfprice = new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);
        
        
        lbltype = new JLabel("Bed Type");
        lbltype.setBounds(60,280,120,30);
        lbltype.setFont(new Font("serif",Font.PLAIN,16));
        add(lbltype);
      
        
        String typeOptions[] = { "Single Bed","Double Bed"};
        typecombo = new JComboBox(typeOptions);
        typecombo.setBounds(200,280,150,30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);
        
        
        
        add = new JButton("Add Room");
        add.setBounds(60,350,120,30);
        add.setBackground(Color.BLACK);
        add.setFont(new Font("serif",Font.PLAIN,17));
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220,350,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setFont(new Font("serif",Font.PLAIN,17));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
        
         ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
         Image i2 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(400,30,500,300);
         add(image);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        
        setBounds(500,300,940,470);
        setVisible(true);
        
    }
    
    
    
    
    
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == add)
        {
            String roomnumber = tfroom.getText();
            
            String availability = (String) availablecombo.getSelectedItem();
            
            String status = (String) cleancombo.getSelectedItem();
            
            String price = tfprice.getText();
            
            String type = (String) typecombo.getSelectedItem();
            
             try{
                 
                 Conn c = new Conn();
                 
                 String query = "insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
                 
                  c.s.executeUpdate(query);
           
                  JOptionPane.showMessageDialog(null, "Room Added Successfully");
           
                   setVisible(false);
                 
             }catch(Exception e)
             {
                 e.printStackTrace();
             }
            
            
        }
        else if(ae.getSource() == cancel)
        {
            setVisible(false);
        }
    }
    
    
    
    public static void main(String[] args)
    {
        new AddRooms();
    }
}
