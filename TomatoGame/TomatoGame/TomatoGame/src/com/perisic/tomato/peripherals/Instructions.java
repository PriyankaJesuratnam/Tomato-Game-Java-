package com.perisic.tomato.peripherals;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;




public class Instructions extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;

	private String imagePath;


    public Instructions() {
        setTitle("Login Interface");
        setSize(950, 600);
        setLayout(null);
    
        Panel panel = new Panel();
        panel.setBounds(0, 0, 400, 600);
        panel.setBackground(Color.gray);
        add(panel);

        Panel panel1 = new Panel();
        panel1.setBounds(400, 0, 650, 600);
        panel1.setBackground(Color.white); 
        panel1.setLayout(null);
        add(panel1);
        
        Panel panel3 = new Panel();
        panel3.setBounds(100, 90, 350, 350);
        panel3.setBackground(Color.white); 
        panel3.setLayout(null);
        panel1.add(panel3);
        
        JLabel headingLabel = new JLabel("INSTRUCTIONS\n");
        headingLabel.setBounds(50, 10, 200, 50);
        headingLabel.setForeground(Color.black);
        headingLabel.setFont(new Font("Cambria Math", Font.BOLD, 25));
        panel3.add(headingLabel);

       
        String instructionText = "1. This is a Quiz Game where players need to find the hidden number behind the tomato.\n"
                + "2. If the player finds the correct answer, they will earn points and advance to the next level.\n"
                + "3. If the player answers incorrectly, they can keep trying until the time runs out.\n"
                + "4. Upon finishing the game, players can view their scores on the scoreboard.";
        JTextArea instructionArea = new JTextArea(instructionText);
        instructionArea.setBounds(20, 50, 300, 300);
        instructionArea.setForeground(Color.black);
        instructionArea.setBackground(Color.white);  
        instructionArea.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        instructionArea.setLineWrap(true);
        instructionArea.setWrapStyleWord(true);
        instructionArea.setEditable(false);
        panel3.add(instructionArea);
       
        JButton btn9 = new JButton("START");
        Font font1 = new Font("Arial", Font.BOLD, 22);
        btn9.setFont(font1);
        btn9.setBounds(180, 470, 150, 50);
        btn9.setForeground(Color.white);
        btn9.setBackground(Color.red); 
        btn9.addActionListener(this);
        panel1.add(btn9);
        
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	login Login = new login(imagePath);
            	Login.setVisible(true);
                //dispose(); 
            }
        });	
        
        
        String imagePath1 ="E:\\Year-3 Semester-1\\CIS\\Game\\image\\4.png";
        File imageFile1 = new File(imagePath1);

        try {
            if (imageFile1.exists()) {
                ImageIcon imageIcon = new ImageIcon(imagePath1);
                Image image = imageIcon.getImage().getScaledInstance(400, 600, Image.SCALE_DEFAULT);
                ImageIcon scaledImageIcon = new ImageIcon(image);

                // Create a label to display the image
                JLabel imageLabel = new JLabel(scaledImageIcon);
                imageLabel.setBounds(0, 0, 300, 600);
                panel.add(imageLabel);
            } else {
                System.err.println("Image file not found: " + imagePath1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Error loading the image: " + ex.getMessage());
        }
		
    }
    
   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Instructions().setVisible(true));
    }

	@Override
	 
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) e.getSource();
            if (clickedButton.getText().equals("START")) {
            	new login(imagePath).setVisible(true);
           	       dispose();
            } 
        
    }
	}
          
    }