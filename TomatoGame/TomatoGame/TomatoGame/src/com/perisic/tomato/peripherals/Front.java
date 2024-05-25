package com.perisic.tomato.peripherals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Front extends JPanel {
    private static final long serialVersionUID = 1L;
    private Image backgroundImage;
    private JButton startbutton;
    private String text = "QUIZ BUZZ";

    public Front(String imagePath) {
        this.backgroundImage = new ImageIcon(imagePath).getImage();

        startbutton = new JButton("LOGIN");
        startbutton.setFont(new Font("Cambria Math", Font.BOLD, 20));

        // Add action listener to the button
        startbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the Login window when the button is clicked
                login Login= new login(imagePath);
                Login.setVisible(true);
            }
        });

        // Add the button to the panel
        add(startbutton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        // Draw the text in front of the background image
        g.setColor(Color.WHITE);
        g.setFont(new Font("Cambria Math", Font.BOLD, 80));

        // Calculate the position to center the text
        int x = (getWidth() - g.getFontMetrics().stringWidth(text)) / 2;
        int y = getHeight() / 2;

        g.drawString(text, x, y);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Call this method to update the positions after the panel is painted
        updateComponentPositions();
    }

    private void updateComponentPositions() {
        int startbuttonX = (getWidth() - 200) / 2;
        int startbuttonY = (getHeight() - 20) / 2 + 40;
        startbutton.setBounds(startbuttonX, startbuttonY, 150, 40);
        startbutton.setBackground(Color.blue);
        startbutton.setForeground(Color.white);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Background Image with Text Example");
                frame.setSize(1920, 1080);

                Front imagePanel = new Front("E:\\\\Year-3 Semester-1\\\\CIS\\\\Game\\\\image\\\\11.jpeg");
                frame.setContentPane(imagePanel);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}