package com.evan.window;

import java.awt.EventQueue;

import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import com.evan.database.EvanDatabase;

import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableModel;


public class NewWin {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewWin window = new NewWin();
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
	public NewWin() {
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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EvanDatabase ed= new EvanDatabase();
			try {
				table.setModel(DbUtils.resultSetToTableModel(ed.get()));
//			     JScrollPane pane = new JScrollPane(table);
//		           frame.getContentPane().add(pane);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		btnNewButton.setBounds(324, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 11, 200, 200);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		
	}
}
