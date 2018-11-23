package com.evan.window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class RadioButtonWin {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioButtonWin window = new RadioButtonWin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RadioButtonWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton malrad = new JRadioButton("Male");
		
		malrad.setSelected(true);
		buttonGroup.add(malrad);
		malrad.setBounds(100, 44, 109, 23);
		frame.getContentPane().add(malrad);
		
		JRadioButton femrad = new JRadioButton("Female");
		
		buttonGroup.add(femrad);
		femrad.setBounds(100, 91, 109, 23);
		frame.getContentPane().add(femrad);
		
		JLabel label = new JLabel("");
		label.setBounds(285, 73, 46, 14);
		frame.getContentPane().add(label);
		
		JButton btnCheck = new JButton("check");
		//button click event handler
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(malrad.isSelected())
				{
					label.setText("Male");
				}
				else
				{
					label.setText("Female");
				}
			}
		});
		
		//radio change event handler
		malrad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			label.setText("");
			if(malrad.isSelected())
			{
				label.setText("Male");
			}
			else
			{
				label.setText("Female");
			}
			}
		});
		
		femrad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText("");
			}
		});
		btnCheck.setBounds(98, 139, 89, 23);
		frame.getContentPane().add(btnCheck);
		
		
	}
}
