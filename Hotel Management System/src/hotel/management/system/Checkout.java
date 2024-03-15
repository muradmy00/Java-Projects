package hotel.management.system;


import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener{
    
    
    Choice ccustomerid;
    JLabel lblroomnumber,lblcheckintime,lblcheckouttime;
    JButton checkout,back;
    
    Checkout(){
        
        getContentPane().setBackground(Color.WHITE); 
        setLayout(null);
        
        
        
        JLabel text = new JLabel("Checkout");
        text.setBounds(100,20,100,30);
        text.setFont(new Font("serif",Font.BOLD,20));
        add(text);
        
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,80,100,30);
        add(lblid);
 
                
        ccustomerid = new Choice();
        ccustomerid.setBounds(150,80,150,25);
        add(ccustomerid);
        
        
         ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
         Image i2 = i1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(310,80,20,20);
         add(image);
        
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);
        
        
        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150,130,100,20);
        add(lblroomnumber);
         
        
        
        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);
        
        
        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150,180,100,20);
        add(lblcheckintime);
        
        
        JLabel lblcheckout = new JLabel("Checkout Time");
        lblcheckout.setBounds(30,230,100,30);
        add(lblcheckout);
        
        Date date = new Date();
        
        lblcheckouttime = new JLabel(""+date);
        lblcheckouttime.setBounds(150,230,150,20);
        add(lblcheckouttime);
        
        
        
        checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(30,280,120,30);
        checkout.addActionListener(this);
        add(checkout);
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(170,280,120,30);
        back.addActionListener(this);
        add(back);
        
        
        try{
            Conn conn = new Conn();
            String query = "select * from customer";
           ResultSet rs = conn.s.executeQuery(query);
           while(rs.next()){
               ccustomerid.add(rs.getString("number"));
               lblroomnumber.setText(rs.getString("room"));
               lblcheckintime.setText(rs.getString("checkintime"));
           }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }

        
        
         ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
         Image i5 = i4.getImage().getScaledInstance(400, 250,Image.SCALE_DEFAULT);
         ImageIcon i6 = new ImageIcon(i5);
         JLabel tick = new JLabel(i6);
         tick.setBounds(350,50,400,250);
         add(tick);
         
         
         
        
        
        setBounds(550,350,800,400);
        setVisible(true);
    }
    
    
    
    
      public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == checkout)
        {
               String query1 = "delete from customer where number = '"+ccustomerid.getSelectedItem()+"'"  ;
               String query2 = "update room set availability = 'Available' where roomnumber = '"+lblroomnumber.getText()+"'";
    
               try{
                   
                   Conn c = new Conn();
                   c.s.executeUpdate(query1);
                   c.s.executeUpdate(query2);
                      
                   JOptionPane.showMessageDialog(null, "Checkout Successfully");
                   
                    setVisible(false);
                    new Reception();
                    
               }catch(Exception e){
                   e.printStackTrace();
               }
        }
        else{
            setVisible(false);
            new Reception();
        }
        
    }
      
    
    
    public static void main(String[] args){
        new Checkout();
    }
}
