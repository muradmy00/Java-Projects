package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener{
    
    Dashboard()
    {
        
        setBounds(200,30,1550,1000);
        
        
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
         Image i2 = i1.getImage().getScaledInstance(1550, 1000,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,1550,1000);
         add(image);

        
        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("serif",Font.PLAIN,46));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,35);
        mb.setBackground(Color.WHITE);
        image.add(mb);
        
        
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setFont(new Font("Tohoma",Font.BOLD,13));
        
        hotel.setForeground(Color.red);
        mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.setFont(new Font("Tohoma",Font.BOLD,13));
        reception.addActionListener(this);
        hotel.add(reception);
        
        
        JMenu admin = new JMenu("ADMIN");
        admin.setFont(new Font("Tohoma",Font.BOLD,13));
        admin.setForeground(Color.blue);
        mb.add(admin);
        
        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.setFont(new Font("Tohoma",Font.BOLD,13));
        addemployee.addActionListener(this);
        admin.add(addemployee);
        
        JMenuItem addroom = new JMenuItem("ADD ROOM");
        addroom.setFont(new Font("Tohoma",Font.BOLD,13));
        addroom.addActionListener(this);
        admin.add(addroom);
        
        JMenuItem adddriver = new JMenuItem("ADD DRIVER");
        adddriver.setFont(new Font("Tohoma",Font.BOLD,13));
        adddriver.addActionListener(this);
        admin.add(adddriver);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("ADD EMPLOYEE"))
        {
            new AdminLogin();
        }
        else if(ae.getActionCommand().equals("ADD ROOM"))
        {
            new AdminLogin2();
        }
        
        else if(ae.getActionCommand().equals("ADD DRIVER"))
        {
          new AdminLogin3();
        }
        else if(ae.getActionCommand().equals("RECEPTION"))
        {
         new Reception();
        }
        
        
    }
    

    public static void main(String[] args) {
        new Dashboard();
    }
}