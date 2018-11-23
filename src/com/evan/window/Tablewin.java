package com.evan.window;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;

import com.evan.database.CloudDatabase;
import com.evan.database.EvanDatabase;
import com.evan.database.StudentDao1;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tablewin {

	private JFrame frame;
	private JTable table;
	private JTextField stidtext;
	private JTextField stnametext;
	  StudentDao1 d= new StudentDao1();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tablewin window = new Tablewin();
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
	public Tablewin() {
		initialize();
		
	    
	    JLabel lblNewLabel = new JLabel("studentid");
	    lblNewLabel.setBounds(407, 116, 46, 14);
	    frame.getContentPane().add(lblNewLabel);
	    
	    stidtext = new JTextField();
	    stidtext.setEditable(false);
	    stidtext.setBounds(479, 113, 86, 20);
	    frame.getContentPane().add(stidtext);
	    stidtext.setColumns(10);
	    
	    JLabel lblStudentName = new JLabel("Student name");
	    lblStudentName.setBounds(386, 147, 67, 14);
	    frame.getContentPane().add(lblStudentName);
	    
	    stnametext = new JTextField();
	    stnametext.setBounds(479, 144, 86, 20);
	    stnametext.setColumns(10);
	    frame.getContentPane().add(stnametext);
	    
	    JButton btnSave = new JButton("Save");
	    btnSave.setBounds(479, 175, 89, 23);
	    btnSave.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    		int id=Integer.parseInt(stidtext.getText());
	    		String namne=stnametext.getText();
	    		
	    	if(	d.SaveData(id,namne)>0)
	    	{
	    		JOptionPane.showMessageDialog(null, "updated");
	    	}
	    	else
	    	{
	    		JOptionPane.showMessageDialog(null, "not updaterd");
	    	}
	    	}
	    });
	    frame.getContentPane().add(btnSave);
	    
	    JButton btnNewStudent = new JButton("New Student");
	    btnNewStudent.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		NewStudent ns= new NewStudent();
	    
	    	}
	    });
	    btnNewStudent.setBounds(476, 44, 89, 23);
	    frame.getContentPane().add(btnNewStudent);
	    
	    
	    putdataintotable();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 908, 633);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 122, 245, 237);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				 Integer id =(Integer) table.getValueAt(row, 0);
				// JOptionPane.showMessageDialog(null, id.toString());
				try {
				ResultSet rs=	d.getsingle(id);
			rs.next();
              stidtext.setText(String.valueOf(rs.getInt("studentid")));
			stnametext.setText(rs.getString("studentname"));
			
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				
			
		});
		scrollPane.setViewportView(table);
	}
	
	private void putdataintotable()
	{
		try{
						
				
				  table.setModel(DbUtils.resultSetToTableModel(d.getStudents()));
				 
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
		
	}
}
