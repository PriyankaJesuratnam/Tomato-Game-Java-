package com.perisic.tomato.peripherals;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import com.perisic.tomato.engine.GameEngine;import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GameGUI extends Frame implements ActionListener {

    private static final long serialVersionUID = -107785653906635L;

	private static final int[] levelScore = null;
     
    GameEngine myGame = null;
    BufferedImage currentGame = null;
    Label infoArea = null;
    JLabel timer1=null;
    private int overallScore = 0;
    private static int currentLevel = 1;
    private int levelOneScore = 0;
    private int levelTwoScore = 0;
    private int levelThreeScore = 0;
    
   
    private int id;

 private JLabel levelLabel;
 private JLabel questArea;
 private JLabel titleLabel;

private void initGame(String player) {
        setSize(1550, 1000);
        setLayout(null);
       
        myGame = new GameEngine(player);
        currentGame = myGame.nextGame();
       
     // Panel 1 - Left panel with a black background and an image
        Panel panel1 = new Panel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                // Load and draw an image on panel1
                Image image1 = Toolkit.getDefaultToolkit().getImage("E:\\Year-3 Semester-1\\CIS\\Game\\image\\9.jpg");
                g.drawImage(image1, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel1.setBounds(0, 0, 425, 1000);
        add(panel1);
        
        ImageIcon ii = new ImageIcon(currentGame);
        questArea = new JLabel(ii);
        questArea.setBounds(425, 250, 700, 330);
        questArea.setOpaque(true);
        setLayout(null);
        add(questArea);
        
        setLayout(null);
        titleLabel = new JLabel("QUIZ BUZZ");
        titleLabel.setBounds(600, 70, 350, 70);
        titleLabel.setForeground(Color.black);
        titleLabel.setFont(new Font("Cambria Math", Font.BOLD, 70));
        add(titleLabel);
        
        levelLabel = new JLabel("Level: " + currentLevel);
        levelLabel.setBounds(1000, 40, 70, 30);
        levelLabel.setForeground(Color.black);
        levelLabel.setFont(new Font("Cambria Math", Font.BOLD, 18));
        add(levelLabel);
        
        Panel panel2 = new ImagePanel("E:\\\\Year-3 Semester-1\\\\CIS\\\\Game\\\\image\\\\10.png");
        panel2.setBounds(425, 0, 700, 1000);
        add(panel2);
     

        // Panel 3 - Right panel with a black background and an image
        Panel panel3 = new Panel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                // Load and draw an image on panel3
                Image image3 = Toolkit.getDefaultToolkit().getImage("E:\\\\Year-3 Semester-1\\\\CIS\\\\Game\\\\image\\\\9.jpg");
                g.drawImage(image3, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel3.setBounds(1125, 0, 425, 1000);
        add(panel3);
               
                        
        Button btn = new Button("0");
        btn.setBounds(40, 600, 40, 50);
        btn.setBackground(Color.white);
        btn.addActionListener(this);
        panel2.add(btn);

        Button btn1 = new Button("1");
        btn1.setBounds(100, 600, 40, 50);
        btn1.setBackground(Color.white);
        btn1.addActionListener(this);
        panel2.add(btn1);

        Button btn2 = new Button("2");
        btn2.setBounds(160, 600, 40, 50);
        btn2.setBackground(Color.white);
        btn2.addActionListener(this);
        panel2.add(btn2);

        Button btn3 = new Button("3");
        btn3.setBounds(220, 600, 40, 50);
        btn3.setBackground(Color.white);
        btn3.addActionListener(this);
        panel2.add(btn3);

        Button btn4 = new Button("4");
        btn4.setBounds(280, 600, 40, 50);
        btn4.setBackground(Color.white);
        btn4.addActionListener(this);
        panel2.add(btn4);

        Button btn5 = new Button("5");
        btn5.setBounds(340, 600, 40, 50);
        btn5.setBackground(Color.white);
        btn5.addActionListener(this);
        panel2.add(btn5);

        Button btn6 = new Button("6");
        btn6.setBounds(400, 600, 40, 50);
        btn6.setBackground(Color.white);
        btn6.addActionListener(this);
        panel2.add(btn6);

        Button btn7 = new Button("7");
        btn7.setBounds(460, 600, 40, 50);
        btn7.setBackground(Color.white);
        btn7.addActionListener(this);
        panel2.add(btn7);

        Button btn8 = new Button("8");
        btn8.setBounds(520, 600, 40, 50);
        btn8.setBackground(Color.white);
        btn8.addActionListener(this);
        panel2.add(btn8);

        Button btn9 = new Button("9");
        btn9.setBounds(580, 600, 40, 50);
        btn9.setBackground(Color.white);
        btn9.addActionListener(this);
        panel2.add(btn9);

        infoArea = new Label();
        infoArea.setBounds(50, 170, 450, 50);
        panel2.add(infoArea);
        infoArea.setText("Find the value of Tomato?   Score: 0");
        Font font = new Font("Arial", Font.BOLD, 25);
        infoArea.setFont(font);
        infoArea.setForeground(Color.black);
        
            
        timer1 = new JLabel();
        timer1.setBounds(550, 170, 45, 50);
        timer1.setForeground(Color.white);
        timer1.setFont(new Font("Arial", Font.PLAIN, 30));

        timer1.setOpaque(true);
        timer1.setBackground(Color.black);

        panel2.setLayout(null);
        panel2.add(timer1);
       
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
       
        startTimer(20, "Level 1");
    }

   
    private void startTimer(int initialTime, String levelMessage) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int i = initialTime;

            public void run() {
                 timer1.setText(String.valueOf(i--));

                if (i < 0) {
                    int levelScore = myGame.getScore();
                    overallScore = levelScore;
                   
                        switch (currentLevel) {
                        case 1:
                            levelOneScore = levelScore;
                            break;
                        case 2:
                            levelTwoScore = levelScore;
                            break;
                        case 3:
                            levelThreeScore = levelScore;
                            break;
                    }

                   JOptionPane.showMessageDialog(GameGUI.this,
                            levelMessage + " completed!\nLevel score: " + levelScore);

                    if (currentLevel < 3) {
                        currentLevel++;
                        levelLabel.setText("Level: " + currentLevel);
                       
                        switch (currentLevel) {
                            case 2:
                                levelTwo();
                                break;
                            case 3:
                                levelThree();
                                break;
                        }
                        
                        
                    } else {
                           JOptionPane.showMessageDialog(GameGUI.this,
                                "Congratulations! Game Over!\nYour overall score is: " + overallScore );
                       
                       
Database.saveOverallScore(id, levelOneScore, levelTwoScore, levelThreeScore, overallScore);

new Leaderboard().setVisible(true);

                     
                        dispose();
                    }

                   
                    timer.cancel();
                }
            }
        };

       
        timer.schedule(task, 1000, 1000);
    }
    
    
   

   
    @Override
    public void actionPerformed(ActionEvent e) {
        int solution = Integer.parseInt(e.getActionCommand());
        boolean correct = myGame.checkSolution(solution);
        int score = myGame.getScore();

        if (correct) {
            System.out.println("Correct solution entered!");
            currentGame = myGame.nextGame();
            ImageIcon ii = new ImageIcon(currentGame);
            questArea.setIcon(ii);

            // Reset score to 0 when level changes
            myGame.resetScore();
                     
            infoArea.setText("Good!  Score: " + myGame.getScore());
            
         // Update level score
            levelScore[currentLevel - 1] = score;
        } else {
        
            System.out.println("Not Correct");
            infoArea.setText("Oops. Try again!  Score: " + score);
        }
    }



    public GameGUI(int id) {
        super();
        initGame(null);
        this.id=id;
    }

    public GameGUI(String player) {
        super();
        initGame(player);
    }

    public static void main(String[] args) {
        new GameGUI(currentLevel);
    }
   
    public void startGame() {
         levelOne();
    }

    private void levelOne() {
       
        JOptionPane.showMessageDialog(this, "Level 1: Get ready!");

        startTimer(20, "Level 1");

       
    }

    private void levelTwo() {
       
        JOptionPane.showMessageDialog(this, "Level 2: Keep going!");

       
        startTimer(15, "Level 2");

       
    }

    private void levelThree() {
        JOptionPane.showMessageDialog(this, "Level 3: Final round!");

       
        startTimer(10, "Level 3");
  
    }
    
    class ImagePanel extends Panel {
        private Image backgroundImage;

        public ImagePanel(String imagePath) {
            this.backgroundImage = Toolkit.getDefaultToolkit().getImage(imagePath);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            // Draw the background image
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
   
}