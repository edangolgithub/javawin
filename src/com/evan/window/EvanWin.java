package com.evan.window;

import javax.swing.JFrame;

public class EvanWin extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
             EvanWin win= new EvanWin();
             win.setBounds(100, 100, 300, 300);
             win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     		 win.getContentPane().setLayout(null);
             win.setVisible(true);
	}

}
