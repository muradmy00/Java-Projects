package hotel.management.system;


import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    
   JButton cancel,login;
   JTextField username;
   JPasswordField password;

    Login(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
       JLabel user = new JLabel("Username");
       user.setBounds(40,30,100,30);
       user.setFont(new Font("serif",Font.BOLD,18));
       add(user);
       
       
       username = new JTextField();
       username.setBounds(150,32,155,30);
       add(username);
        
       
       JLabel pass = new JLabel("Password");
       pass.setBounds(40,90,100,30);
       pass.setFont(new Font("serif",Font.BOLD,18));
       add(pass);
       
       password = new JPasswordField();
       password.setBounds(150,90,155,30);
       add(password);
       
       
       
        login = new JButton("Login");
        login.setBounds(40,150,100,30);
        login.setBackground(Color.BLACK);
        login.setFont(new Font("serif",Font.PLAIN,20));
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180,150,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setFont(new Font("serif",Font.PLAIN,20));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
         ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
         Image i2 = i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(350,10,200,200);
         add(image);

        
        setSize(600,300);
        setLocation(680,400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== login)
        {
           String user = username.getText();
           String pass = password.getText();
           
           
        if (username.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Fill in the blanks");
            return;
        }
            
           try{
               
               Conn c = new Conn();
               
               String query = "select * from login where username='"+user+"' and password='"+pass+"'";
               
              ResultSet rs = c.s.executeQuery(query);
              
              if(rs.next())
              {
                  setVisible(false);
                  new Dashboard();
              }
              else
              {
                  JOptionPane.showMessageDialog(null, "Invalid username or password");
                  setVisible(false);
              }
               
           }catch(Exception e){
               e.printStackTrace();
           }
        
        }
        else if(ae.getSource()== cancel)
        {
            setVisible(false);
        }
    }
    public static void main(String[] arg){
        new Login();
    }
}
