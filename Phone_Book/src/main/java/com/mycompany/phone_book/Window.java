package com.mycompany.phone_book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;




public class Window implements ActionListener{
    
    JTextField t1 = new JTextField(25);
    JTextField t2 = new JTextField(25); 
    JLabel name = new JLabel("Name");
    JLabel phone = new JLabel("Phone"); 
    JButton button = new JButton("Add record"); 
    JButton table = new JButton("Table");
    JFrame frame = new JFrame("Phone Book");  
    Connection co = null;
    Statement s = null;

    
    Window(){
    name.setBounds(50,100, 200,30);
    phone.setBounds(50,150, 200,30);
    button.setBounds(100, 250, 100, 30);
    table.setBounds(210, 250, 90, 30);
    t1.setBounds(100,100, 200,30);  
    t2.setBounds(100,150, 200,30);     
   
    frame.add(t1); 
    frame.add(t2);  
    frame.add(name); 
    frame.add(phone);
    frame.add(button); 
    frame.add(table);
   
    button.addActionListener(this);
    table.addActionListener(this); 
   
    frame.setSize(400,400);  
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setVisible(true);
  
    } 
    
 private void Open(){
    try{
        Class.forName("org.sqlite.JDBC");
        co = DriverManager.getConnection("jdbc:sqlite:res/Users.db");
         
    }catch(ClassNotFoundException | SQLException exc){
        System.out.println(exc.getMessage());
    }
    }

 private void Insert(){
       try{
        String query = "INSERT INTO users (name, phone) " + "VALUES ('" + t1.getText() + "', '" + t2.getText() + "')";
        s = co.createStatement();
        s.executeUpdate(query); 
        System.out.println("Rows added");     
        s.close();     
       }catch(SQLException exc){
           System.out.println(exc.getMessage());
    }        
    }
 

        
 private void Close(){
     try{
       s.close();
       co.close();  
       }catch(SQLException exc){
           System.out.println(exc.getMessage());
    }
    } 


    @Override
 public void actionPerformed(ActionEvent ae){
     
     if(ae.getSource() == button){
          Open();
          Insert();
          Close();
     }
     if(ae.getSource() == table){
          new Table(); 
     }
       
   }   


} 