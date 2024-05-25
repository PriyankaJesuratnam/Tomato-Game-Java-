package com.perisic.tomato.peripherals;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Leaderboard extends JFrame implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

    public Leaderboard() {
        setTitle("Leaderboard");
        setSize(500, 1000);
        setLayout(new BorderLayout());

        String[] columns = {"Username",  "OverallScore"};
        DefaultTableModel model = new DefaultTableModel(null, columns);
        table = new JTable(model);
        table.setBackground(Color.black);
        table.setForeground(Color.white);
        table.setRowHeight(35);
        table.setFont(new Font("Cambria Math", Font.BOLD, 15));
        
        JButton btn9 = new JButton("EXIT");
        Font font1 = new Font("Arial", Font.BOLD, 22);
        btn9.setFont(font1);
        btn9.setBounds(150, 600, 150, 50);
        btn9.setForeground(Color.white);
        btn9.setBackground(Color.red); 
        btn9.addActionListener(this);
        add(btn9);
        
        try {
            // Establish database connection
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT login.id, login.username, score.score from login INNER JOIN score ON login.id = score.id ORDER BY score DESC");

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                
                String score = resultSet.getString("score");
                model.addRow(new Object[]{username, score});
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                JButton clickedButton = (JButton) e.getSource();
                if (clickedButton.getText().equals("EXIT")) {
                	setVisible(true);
               	       dispose();
                } 
            
        }
    	}
    
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Leaderboard().setVisible(true));
    }
    
}