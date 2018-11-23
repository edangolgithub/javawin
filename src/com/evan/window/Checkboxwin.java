package com.evan.window;

import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Checkboxwin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checkboxwin window = new Checkboxwin();
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
	public Checkboxwin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 652, 447);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCheckBox momocheck = new JCheckBox("MOMO");
		momocheck.setBounds(136, 34, 97, 23);
		frame.getContentPane().add(momocheck);
		
		JCheckBox chowcheck = new JCheckBox("CHowmien");
		chowcheck.setBounds(136, 76, 97, 23);
		frame.getContentPane().add(chowcheck);
		
		JCheckBox thukpacheck = new JCheckBox("Thukpa");
		thukpacheck.setBounds(136, 118, 97, 23);
		frame.getContentPane().add(thukpacheck);
		
		JList list = new JList();
		list.setForeground(Color.WHITE);
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(138, 210, 102, 141);
		frame.getContentPane().add(list);
		
		JButton btnOrdere = new JButton("Ordere");
		btnOrdere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				DefaultListModel<String> l1 = new DefaultListModel<>();  	
				
				if(momocheck.isSelected())
				{
					
					l1.addElement("Mo Mo");
					
				}
				if(chowcheck.isSelected())
				{
					l1.addElement("Chowmien");
				}
				if(thukpacheck.isSelected())
				{
					l1.addElement("Thukpa");
				}
				
				list.setListData(l1.toArray());
			   
			}
		});
		btnOrdere.setBounds(136, 165, 89, 23);
		frame.getContentPane().add(btnOrdere);
		
		
	}
}
