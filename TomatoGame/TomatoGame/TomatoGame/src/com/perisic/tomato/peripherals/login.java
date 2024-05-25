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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;

public class login extends JPanel {
    private static final long serialVersionUID = 1L;
    private Image backgroundImage;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel aboveUsernameLabel; 
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel additionalTextLabel; 
    private JButton signInButton;
	private int id;
    
    
    public login(String imagePath) {
        this.backgroundImage = new ImageIcon(imagePath).getImage();

        aboveUsernameLabel = new JLabel("QUIZ BUZZ");
        aboveUsernameLabel.setForeground(Color.red);
        aboveUsernameLabel.setFont(new Font("Cambria Math", Font.BOLD, 70));
        
        usernameLabel = new JLabel("USERNAME:");
        usernameLabel.setForeground(Color.black);
        usernameLabel.setFont(new Font("Cambria Math", Font.BOLD, 30));
      
        usernameField = new JTextField();
        int usernameX = (getWidth() - 150) / 2;
        int usernameY = (getHeight() - 30) / 2 - 50;
        usernameField.setBounds(usernameX, usernameY, 150, 30);

        passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setForeground(Color.black);
        passwordLabel.setFont(new Font("Cambria Math", Font.BOLD, 30));
       
        passwordField = new JPasswordField();
        int passwordX = (getWidth() - 150) / 2;
        int passwordY = (getHeight() - 30) / 2 - 10;
        passwordField.setBounds(passwordX, passwordY, 150, 30);

        loginButton = new JButton("LOGIN");
        int loginButtonX = (getWidth() - 80) / 2;
        int loginButtonY = (getHeight() - 30) / 2 + 30;
        loginButton.setBounds(loginButtonX, loginButtonY, 80, 30);
        loginButton.setFont(new Font("Cambria Math", Font.BOLD, 20));
        
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                try {
                    int id = Database.validateLogin(username, password);
                    if (id != -1) {
                        JOptionPane.showMessageDialog(login.this, "Login successful!");
                        new GameGUI(id).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(login.this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();  // Handle the exception based on your application's needs
                }

                usernameField.setText("");
                passwordField.setText("");
            }
        });


        additionalTextLabel = new JLabel("Need an Account?");
        additionalTextLabel.setForeground(Color.black);
        additionalTextLabel.setFont(new Font("Cambria Math", Font.BOLD, 25));
        int additionalTextLabelX = (getWidth() - 150) / 2 - 80;
        int additionalTextLabelY = (getHeight() - 30) / 2 + 70;
        additionalTextLabel.setBounds(additionalTextLabelX, additionalTextLabelY, 150, 30);

        signInButton = new JButton("SIGNIN");
        signInButton.setFont(new Font("Cambria Math", Font.BOLD, 20));
        int signInButtonX = (getWidth() - 80) / 2;
        int signInButtonY = (getHeight() - 30) / 2 + 110;
        signInButton.setBounds(signInButtonX, signInButtonY, 80, 30);
       
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Signin signin = new Signin();
            	signin.setVisible(true);
                //dispose(); 
            }
        });
      
    

        setLayout(null);
        add(aboveUsernameLabel);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(additionalTextLabel);
        add(signInButton);
        
       
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        // Draw the text in front of the background image
        g.setColor(Color.WHITE); // Set the text color
        g.setFont(new Font("Arial", Font.BOLD, 20)); // Set the font and size

       
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Call this method to update the positions after the panel is painted
        updateComponentPositions();
    }

    private void updateComponentPositions() {
        // Update the positions after the panel is painted
        int aboveUsernameLabelX = (getWidth() - 400) / 2;
        int aboveUsernameLabelY = (getHeight() - 170) / 2 - 90;
        aboveUsernameLabel.setBounds(aboveUsernameLabelX, aboveUsernameLabelY, 450, 70);

        int usernameLabelX = (getWidth() - 270) / 2 - 80;
        int usernameLabelY = (getHeight() - 30) / 2 - 70;
        usernameLabel.setBounds(usernameLabelX, usernameLabelY, 370, 30);

        int usernameX = (getWidth() - 70) / 2;
        int usernameY = (getHeight() - 30) / 2 - 70;
        usernameField.setBounds(usernameX, usernameY, 200, 30);

        int passwordLabelX = (getWidth() - 270) / 2 - 80;
        int passwordLabelY = (getHeight() - 30) / 2 - 10;
        passwordLabel.setBounds(passwordLabelX, passwordLabelY, 370, 30);

        int passwordX = (getWidth() - 70) / 2;
        int passwordY = (getHeight() - 30) / 2 - 10;
        passwordField.setBounds(passwordX, passwordY, 200, 30);

        int loginButtonX = (getWidth() - 200) / 2;
        int loginButtonY = (getHeight() - 20) / 2 + 40;
        loginButton.setBounds(loginButtonX, loginButtonY, 150, 40);
        loginButton.setBackground(Color.blue);
        loginButton.setForeground(Color.white);

        int additionalTextLabelX = (getWidth() - 100) / 2 - 80;
        int additionalTextLabelY = (getHeight() - 5) / 2 + 80;
        additionalTextLabel.setBounds(additionalTextLabelX, additionalTextLabelY, 200, 30);

        int signInButtonX = (getWidth() - 200) / 2;
        int signInButtonY = (getHeight() - 30) / 2 + 130;
        signInButton.setBounds(signInButtonX, signInButtonY, 150, 40);
        signInButton.setBackground(Color.green);
        signInButton.setForeground(Color.black);
    }
    
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("login");
            frame.setSize(1920, 1080);

            login imagePanel = new login("E:\\Year-3 Semester-1\\CIS\\Game\\image\\5.png");
            frame.setContentPane(imagePanel);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    public void GameGUI(int userID) {
        this.id = id;
    }
}




