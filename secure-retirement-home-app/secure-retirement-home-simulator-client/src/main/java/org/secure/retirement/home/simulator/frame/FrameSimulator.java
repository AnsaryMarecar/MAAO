/**
 * 
 */
package org.secure.retirement.home.simulator.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.secure.retirement.home.simulator.client.Simulation;

/**
 * @author Ansary MARECAR
 *
 */
public class FrameSimulator extends JFrame implements ActionListener{
	 
	private JButton button_risk 	= new JButton("Sensor Temperature")		;
	private JButton button_launch 	= new JButton("Launch All simulation")	;
	private JButton button_failure 	= new JButton("Sensor Humidity")		;
	
	/**
	 * 
	 */
	public FrameSimulator() {
		// TODO Auto-generated constructor stub
		//Generality
		this.setSize(350, 150)									 		;
		this.setLocationRelativeTo(null)						 		; 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)		 		;
		
		
		this.setLayout(new BorderLayout())	 							;
		//center placement
		this.getContentPane().add(button_launch, BorderLayout.CENTER)	;
		//left placement
		this.getContentPane().add(button_risk, BorderLayout.LINE_START)	;
		//right placement
		this.getContentPane().add(button_failure, BorderLayout.LINE_END);
		//Action listener for Button
	    this.button_risk.addActionListener		(this)	 				;
	    this.button_failure.addActionListener	(this)	 				;
	    this.button_launch.addActionListener	(this)	 				;
		this.setVisible( true )											;
	}
	
	public void actionPerformed(ActionEvent param_actionevent) {
		// TODO Auto-generated method stub
		Object source = param_actionevent.getSource();
		Thread t;
		if (source == button_launch){
			for(int i=1; i<3;i++) {
				Simulation val_simulation = new Simulation(this, i)		;
				t = new Thread(val_simulation);
				t.start();
			}
		}
		else if (source == button_risk) {
				Simulation val_simulation = new Simulation(this, 1)		;
				t = new Thread(val_simulation);
				t.start();
		}
		else if (source == button_failure) {
			for(int i=1; i<3;i++) {
				Simulation val_simulation = new Simulation(this, i)		;
				t = new Thread(val_simulation);
				t.start();
			}
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
