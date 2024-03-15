package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{

      
        
        public HotelManagementSystem() {
		
                setSize(1366,565);
                setLayout(null);
                setLocation(300,250);
                	
                
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
                JLabel image = new JLabel(i1);
                image.setBounds(0,0,1366,565);
                add(image);
           
                JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
                text.setBounds(30,450,1500,100);
                text.setFont(new Font("serif",Font.PLAIN,40));
                text.setForeground(Color.LIGHT_GRAY);
                image.add(text);
                
                
                JButton next = new JButton("Next");
                next.setBounds(1150,450,150,45);
                next.setBackground(Color.LIGHT_GRAY);
                next.setFont(new Font("serif",Font.PLAIN,20));
                next.setForeground(Color.BLACK);
                next.addActionListener(this);
                image.add(next);
                
                
                setVisible(true);
                
                while(true)
                {
                    text.setVisible(false);
                    try{
                        Thread.sleep(500);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    text.setVisible(true);
                    
                        try{
                        Thread.sleep(500);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                
                
            
                
        }
    
        public void actionPerformed(ActionEvent ae){
               
               setVisible(false);
               new Login();
                
        }
        
        public static void main(String[] args) {
                new HotelManagementSystem();
                			
	}
}