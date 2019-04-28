/**
 * 
 */
package org.secure.retirement.home.simulator.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Ansary MARECAR
 *
 */
public class FrameSimulator extends JFrame implements ActionListener{
	
	//Panel 
		protected 	JPanel				top_panel		= new JPanel()	;
		protected 	JPanel				bottom_panel	= new JPanel()	;
		
		
	/**
	 * 
	 */
	public FrameSimulator() {
		// TODO Auto-generated constructor stub
		//Generality
		this.setSize(120, 120)									 		;
		this.setLocationRelativeTo(null)						 		;               
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)		 		;
		
		
		//principal placement
		this.setLayout(new BorderLayout())								;
		
		//north placement
		JButton button_launch = new JButton("Launch");
		top_panel.add(button_launch);
		this.getContentPane().add(top_panel	, BorderLayout.NORTH	)	;
		
		//south placement
		JButton button_stop = new JButton("Stop");
		bottom_panel.add(button_stop);
		this.getContentPane().add(bottom_panel	, BorderLayout.SOUTH)	;	 
		this.setVisible( true )											;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FrameSimulator();
	}

}
