package hotel.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener{
    
    Choice ccustomer;
    JTextField tfroom,tfname,tfcheckin,tfpaid,tfpending;
    JButton check,update,back;
    
    UpdateCheck(){
        
        getContentPane().setBackground(Color.WHITE); 
        setLayout(null);
        
        JLabel text = new JLabel("Update Status");
        text.setBounds(90,20,200,30);
        text.setFont(new Font("serif",Font.BOLD,20));
        add(text);
        
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,80,100,20);
        add(lblid);
        
        ccustomer = new Choice();
        
        try{
            Conn conn = new Conn();
            String query = "select * from customer";
           ResultSet rs = conn.s.executeQuery(query);
           while(rs.next()){
               ccustomer.add(rs.getString("number"));
           }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);
        
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,120,100,20);
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200,120,150,25);
        add(tfroom);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,160,100,20);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
        
        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30,200,100,20);
        add(lblcheckin);
        
        tfcheckin = new JTextField();
        tfcheckin.setBounds(200,200,150,25);
        add(tfcheckin);
        
        JLabel lblpaid = new JLabel("Amount Paid");
        lblpaid.setBounds(30,240,100,20);
        add(lblpaid);
        
        tfpaid = new JTextField();
        tfpaid.setBounds(200,240,150,25);
        add(tfpaid);
        
        JLabel lblpending = new JLabel("Pending Amount");
        lblpending.setBounds(30,280,130,20);
        add(lblpending);
        
        tfpending = new JTextField();
        tfpending.setBounds(200,280,150,25);
        add(tfpending);
        
        
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,340,100,30);
        check.addActionListener(this);
        add(check);
        
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,340,100,30);
        update.addActionListener(this);
        add(update);
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,340,100,30);
        back.addActionListener(this);
        add(back);
        
        
         ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
         Image i2 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(400,50,500,300);
         add(image);
        
         
         
        
        
        setBounds(490,310,980,500);
        setVisible(true);
    }
    
    
     public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == check)
        {
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";
            try{
                
                Conn c = new Conn();
                ResultSet rs1 = c.s.executeQuery(query);
                while(rs1.next())
                {
                    tfroom.setText(rs1.getString("room"));
                    tfname.setText(rs1.getString("name"));
                    tfcheckin.setText(rs1.getString("checkintime"));
                    tfpaid.setText(rs1.getString("deposit"));
                   }
                    ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+tfroom.getText()+"'");
                    while(rs2.next())
                    {
                    
                       String price = rs2.getString("price");
                       int amountpaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                       
                       tfpending.setText("" + amountpaid);
                       
                       
                   }
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == update)
        {
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String name = tfname.getText();
            String checkin = tfcheckin.getText();
            String deposit = tfpaid.getText();
            
            
            try{
                
              Conn c = new Conn();
              c.s.executeUpdate("update customer set room = '"+room+"', name = '"+name+"', checkintime = '"+checkin+"', deposit = '"+deposit+"' where number = '"+number+"'");
              
              JOptionPane.showMessageDialog(null, "Data Update Successfully");
              
              setVisible(false);
              new Reception();
                
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
        
        new UpdateCheck();
    }
}
