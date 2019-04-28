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
		private JPanel	top_panel		= new JPanel()	;
		private JPanel	bottom_panel	= new JPanel()	;
		private JButton button_stop 	= new JButton("Stop");
		private JButton button_launch = new JButton("Launch");
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
		this.top_panel.add(button_launch);
		this.getContentPane().add(top_panel	, BorderLayout.NORTH	)	;
		
		//south placement
		this.bottom_panel.add(button_stop);
		this.getContentPane().add(bottom_panel	, BorderLayout.SOUTH)	;
		
		//Action listener for Button
	    this.button_stop.addActionListener		(this)	 ;
	    this.button_launch.addActionListener	(this)	 ;
		
		this.setVisible( true )											;
	}
	
	public void actionPerformed(ActionEvent param_actionevent) {
		// TODO Auto-generated method stub
		Object source = param_actionevent.getSource();
		
		if (source == button_stop) {
			
		}
		else if (source == button_launch){
			
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FrameSimulator();
	}

}
