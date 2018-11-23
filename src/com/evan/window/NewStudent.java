package com.evan.window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.evan.database.StudentDao1;
import com.evan.database.student;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class NewStudent {

	private JFrame frame;
	private JTextField stidtext;
	private JTextField stnametext;
	StudentDao1 d= new StudentDao1();
	
	/**
	 * Create the application.
	 */
	public NewStudent() {
		initialize();
		
frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("studentid");
		label.setBounds(127, 88, 46, 14);
		frame.getContentPane().add(label);
		
		stidtext = new JTextField();
		stidtext.setEditable(false);
		stidtext.setColumns(10);
		stidtext.setBounds(199, 85, 86, 20);
		frame.getContentPane().add(stidtext);
		
		JLabel label_1 = new JLabel("Student name");
		label_1.setBounds(106, 119, 67, 14);
		frame.getContentPane().add(label_1);
		
		stnametext = new JTextField();
		stnametext.setColumns(10);
		stnametext.setBounds(199, 116, 86, 20);
		frame.getContentPane().add(stnametext);
		
		JButton button = new JButton("Save");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=stnametext.getText();
				student s= new student();
				s.studentname=name;
				try {
					if(d.insertstudent(s)>0)
					{
						JOptionPane.showMessageDialog(null, "Inserted");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "error");
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setBounds(199, 147, 89, 23);
		frame.getContentPane().add(button);
	}
}
