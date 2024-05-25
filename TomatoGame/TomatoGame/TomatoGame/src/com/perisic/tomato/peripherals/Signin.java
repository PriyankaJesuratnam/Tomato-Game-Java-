package com.perisic.tomato.peripherals;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Signin extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextField text;
    private TextField text1;
    private TextField text2;
    private TextField text3;
	private String String;
    

    public Signin() {
        setTitle("Login Interface");
        setSize(950, 600);
        setLayout(null);
    
        
        Panel panel = new Panel();
        panel.setBounds(0, 0, 300, 600);
        add(panel);
        
   
        String imagePath = "E:\\Year-3 Semester-1\\CIS\\Game\\TomatoGame\\bin\\image\\boy.jpeg";

        File imageFile = new File(imagePath);

        try {
            if (imageFile.exists()) {
                ImageIcon imageIcon = new ImageIcon(imagePath);
                Image image = imageIcon.getImage().getScaledInstance(300, 600, Image.SCALE_DEFAULT);
                ImageIcon scaledImageIcon = new ImageIcon(image);

                // Create a label to display the image
                JLabel imageLabel = new JLabel(scaledImageIcon);
                imageLabel.setBounds(100, 40, 300, 200);
                panel.add(imageLabel);
            } else {
                System.err.println("Image file not found: " + imagePath);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Error loading the image: " + ex.getMessage());
        }

       

        Panel panel1 = new Panel();
        panel1.setBounds(300, 0, 700, 600);
        panel1.setLayout(null);
        panel1.setBackground(Color.black);
        add(panel1);

        text = new TextField();
        text.setBounds(375, 140, 230, 40);
        panel1.add(text);
        
        text1 = new TextField();
        text1.setBounds(375, 200, 230, 40);
        panel1.add(text1);
        
        text2 = new TextField();
        text2.setBounds(375, 260, 230, 40);
        panel1.add(text2);
        
        text3 = new TextField();
        text3.setBounds(375, 320, 230, 40);
        panel1.add(text3);
        
        Label lab1 = new Label();
        lab1.setBounds(130, 40, 400, 100);
        lab1.setText("QUIZ BUZZ"); 
        lab1.setForeground(Color.pink); 
        Font font = new Font("Arial", Font.BOLD, 70); 
        lab1.setFont(font);
        panel1.add(lab1);
        
        Label lab2 = new Label();
        lab2.setBounds(30, 140, 230, 70);
        lab2.setText("USERNAME"); 
        lab2.setForeground(Color.white); 
        Font font1 = new Font("Arial", Font.BOLD, 30); 
        lab2.setFont(font1);
        panel1.add(lab2);

        Label lab3 = new Label();
        lab3.setBounds(30, 200, 230, 70);
        lab3.setText("EMAIL"); 
        lab3.setForeground(Color.white); 
        Font font2 = new Font("Arial", Font.BOLD, 30); 
        lab3.setFont(font2);
        panel1.add(lab3);
        
        Label lab5 = new Label();
        lab5.setBounds(30, 260, 230, 70);
        lab5.setText("PASSWORD"); 
        lab5.setForeground(Color.white); 
        Font font4 = new Font("Arial", Font.BOLD, 30); 
        lab5.setFont(font4);
        panel1.add(lab5);
        
        Label lab6 = new Label();
        lab6.setBounds(30, 320, 350, 70);
        lab6.setText("CONFIRM PASSWORD"); 
        lab6.setForeground(Color.white); 
        Font font5 = new Font("Arial", Font.BOLD, 30); 
        lab6.setFont(font5);
        panel1.add(lab6);
        
        Button btn = new Button("SUBMIT");
        btn.setBounds(200, 400, 150, 60);
        btn.setBackground(Color.blue);
        btn.addActionListener(this);
        panel1.add(btn);
        
        Label lab4 = new Label();
        lab4.setBounds(150, 470, 200, 50);
        lab4.setText("Back to Login?");
        lab4.setForeground(Color.white); 
        Font font3 = new Font("Arial", Font.BOLD, 20); 
        lab4.setFont(font3);
        panel1.add(lab4);
        
        Button uri = new Button("Login");
        uri.setBounds(350, 480, 80, 30);
        uri.setForeground(Color.black);
        uri.setBackground(Color.green);
        Font font51 = new Font("Arial", Font.BOLD, 30);

        
        uri.addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	new login(imagePath).setVisible(true);
                dispose();            }
        });

        panel1.add(uri);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = text.getText();
        String email = text1.getText();

        String passwordChars = text2.getText();
        String password = new String(passwordChars);
        String confirmPassword = text3.getText();
        
        if (!isValidUsername(username)) {
            JOptionPane.showMessageDialog(this, "Invalid username. Please enter a valid username.");
            return;
        }

      
        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Invalid email. Please enter a valid email address.");
            return;
        }

       
        if (!isValidPassword(password)) {
            JOptionPane.showMessageDialog(this, "Invalid password. Password must be at least 8 characters long.");
            return;
        }
        
        
        
        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match. Please try again.");
            return;
        }

        
        if (Database.validateLogin1(username, email, password)) {
            JOptionPane.showMessageDialog(this, "Sign up successful!");
            new login(String).setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error signing up. Please try again.");
        }
        text1.setText("");
        text.setText("");
        text2.setText("");
        text3.setText("");
       
    }
    
    

    private boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z0-9]{3,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    private boolean isValidEmail(String email) {
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()-_=+\\[\\]{}|;:'\",.<>?/]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }


	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Signin().setVisible(true));
    }
    
}