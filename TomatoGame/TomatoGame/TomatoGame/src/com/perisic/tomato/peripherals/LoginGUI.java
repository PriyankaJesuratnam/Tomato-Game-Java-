package com.perisic.tomato.peripherals;
/*
 * Code adapted from from https://best-programming-tricks.blogspot.com/2011/07/how-to-make-login-form-with-java-gui.html
 */

import javax.swing.*;
import java.awt.event.*;

public class LoginGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6921462126880570161L;

	public static void main(String[] args) {
		LoginGUI frameTabel = new LoginGUI();
	}

	JButton blogin = new JButton("Login");
	JPanel panel = new JPanel();
	JTextField txuser = new JTextField(15);
	JPasswordField pass = new JPasswordField(15);
	
	LoginData ldata = new LoginData(); 

	LoginGUI() {
		super("Login Autentification");
		setSize(300, 200);
		setLocation(500, 280);
		panel.setLayout(null);

		txuser.setBounds(70, 30, 150, 20);
		pass.setBounds(70, 65, 150, 20);
		blogin.setBounds(110, 100, 80, 20);

		panel.add(blogin);
		panel.add(txuser);
		panel.add(pass);

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		actionlogin();
	}

	public void actionlogin() {
		blogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String puname = txuser.getText();
				String ppaswd = String.valueOf(pass.getPassword()); // https://stackoverflow.com/questions/10443308/why-gettext-in-jpasswordfield-was-deprecated
				if( ldata.checkPassword(puname, ppaswd)) { 
					GameGUI theGame = new GameGUI(puname); 
					theGame.setVisible(true); 
					dispose();
				} else {

					JOptionPane.showMessageDialog(null, "Wrong Password / Username");
					txuser.setText("");
					pass.setText("");
					txuser.requestFocus();
				}

			}
		});
	}
}
