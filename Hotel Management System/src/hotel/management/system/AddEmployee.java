package hotel.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    
    JButton submit,cancel;
    JTextField tfname,tfemail,tfphone,tfsalary,tfage,tfnid;
    JLabel lblname,lblage,lblgender,lbljob,lblsalay,lblphone,lblemail,lblnid;
    JRadioButton rbmale,rbfemale;
    JComboBox cjob;
    
    AddEmployee()
    {
        
        setLayout(null);
        
        
        
        
        lblname = new JLabel("NANE");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("serif",Font.PLAIN,17));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);
        
        
        lblage = new JLabel("AGE");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("serif",Font.PLAIN,17));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);
        
        
        lblgender = new JLabel("GENDER");
        lblgender.setBounds(60,130,120,30);
        lblgender.setFont(new Font("serif",Font.PLAIN,17));
        add(lblgender);
        
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(190,130,70,30);
        rbmale.setFont(new Font("serif",Font.PLAIN,13));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(270,130,70,30);
        rbfemale.setFont(new Font("serif",Font.PLAIN,13));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        
        ButtonGroup bg =  new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        
        lbljob = new JLabel("JOB");
        lbljob.setBounds(60,180,120,30);
        lbljob.setFont(new Font("serif",Font.PLAIN,17));
        add(lbljob);
        
        
        String str[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter","Manager","Accountant"};
        cjob = new JComboBox(str);
        cjob.setBounds(200,180,150,30);
        cjob.setBackground(Color.WHITE);
        add(cjob);
        
        
        
        lblsalay = new JLabel("SALARY");
        lblsalay.setBounds(60,230,120,30);
        lblsalay.setFont(new Font("serif",Font.PLAIN,17));
        add(lblsalay);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);
        
        lblphone = new JLabel("PHONE");
        lblphone.setBounds(60,280,120,30);
        lblphone.setFont(new Font("serif",Font.PLAIN,17));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200,280,150,30);
        add(tfphone);
        
        
        lblemail = new JLabel("EMAIL");
        lblemail.setBounds(60,330,120,30);
        lblemail.setFont(new Font("serif",Font.PLAIN,17));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,330,150,30);
        add(tfemail);
        
        lblnid = new JLabel("NID NUMBER");
        lblnid.setBounds(60,380,120,30);
        lblnid.setFont(new Font("serif",Font.PLAIN,17));
        add(lblnid);
        
        tfnid = new JTextField();
        tfnid.setBounds(200,380,150,30);
        add(tfnid);
        
        
        submit = new JButton("Submit");
        submit.setBounds(60,450,120,30);
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("serif",Font.PLAIN,20));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220,450,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setFont(new Font("serif",Font.PLAIN,20));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
         ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
         Image i2 = i1.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(380,60,450,370);
         add(image);
         
         
        
        
        getContentPane().setBackground(Color.WHITE);
        
        
        setBounds(520,300,850,540);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
       if(ae.getSource() == submit)
        {
            
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String  nid = tfnid.getText();
        
        
        if (tfname.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Fill in the blanks");
            return;
        }
        
        String gender = null;
        if(rbmale.isSelected())
        {
            gender = "Male";
        }
        else if (rbfemale.isSelected())
        {
             gender = "Female";
        }
        
        
        String job = (String) cjob.getSelectedItem();
        
          
        try{
            Conn conn = new Conn();
            
            String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+nid+"')";
            
            conn.s.executeUpdate(query);
           
           JOptionPane.showMessageDialog(null, "Employee Added Successfully");
           
           setVisible(false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
       }
       else
        {
            setVisible(false);
        }
       
        
        
    }
    
    
    
    
    public static void main(String[] args)
    {
        new AddEmployee();
    }
}
