package com.evan.window;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CombowWin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CombowWin window = new CombowWin();
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
	public CombowWin() {
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedItem()=="Samsung")
				{
					JOptionPane.showMessageDialog(null, "Samsung");
				}
				if(comboBox.getSelectedItem()=="Lava")
				{
					JOptionPane.showMessageDialog(null, "Lava");
				}
				if(comboBox.getSelectedItem()=="Nokia")
				{
					JOptionPane.showMessageDialog(null, "Nokia");
				}
				if(comboBox.getSelectedItem()=="Vivo")
				{
					JOptionPane.showMessageDialog(null, "Vivo");
				}
				if(comboBox.getSelectedItem()=="Oppo")
				{
					JOptionPane.showMessageDialog(null, "Oppo");
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Samsung", "Nokia", "Lava", "Vivo", "Oppo"}));
		comboBox.setBounds(103, 67, 160, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox combo2 = new JComboBox();
		combo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(combo2.getSelectedItem()=="Default")
				{
					frame.getContentPane().setBackground(null);
				}
				if(combo2.getSelectedItem()=="Red")
				{
					frame.getContentPane().setBackground(Color.red);

			}
				if(combo2.getSelectedItem()=="Green")
				{
					frame.getContentPane().setBackground(Color.green);
				}
				if(combo2.getSelectedItem()=="Blue")
				{
					frame.getContentPane().setBackground(Color.blue);
				}
				
				
			}
		});
		
		String[] colors= {"Default","Red","Blue","Green"};
		
		combo2.setModel(new DefaultComboBoxModel(colors));
		combo2.setBounds(103, 152, 145, 20);
		frame.getContentPane().add(combo2);
	}
}
