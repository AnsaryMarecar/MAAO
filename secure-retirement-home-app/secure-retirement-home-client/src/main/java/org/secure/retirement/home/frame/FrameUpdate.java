package org.secure.retirement.home.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.secure.retirement.home.frame.FrameHome.ButonListener;

public class FrameUpdate extends JFrame{
	

	private JPanel pan1, pan2, pan3;
	private JButton typeSensorB, userB, placeB, returnB;
	private JLabel jl1;
	
	
	public FrameUpdate() {
		
		
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		pan1= new JPanel();
		pan2=new JPanel();
		pan3= new JPanel();
		
		
		typeSensorB= new JButton("Type Sensor");
		userB = new JButton ("Users");
		placeB = new JButton ("Place");
		returnB= new JButton("⟵");
		
		jl1= new JLabel ("choose a button");
		
		
		this.setLayout(new BorderLayout());
		this.getContentPane().add(pan1, BorderLayout.NORTH);
		this.getContentPane().add(pan2, BorderLayout.CENTER);
		this.getContentPane().add(pan3, BorderLayout.SOUTH);
		
		pan1.setLayout(new FlowLayout());
		pan1.add(returnB);
		pan1.add(jl1);
		
		
		pan2.setLayout(new FlowLayout());
		pan2.add(typeSensorB);
		pan2.add(userB);
		pan2.add(placeB);
		
		this.getTypeSensorB().addActionListener(new ButonListener());
		this.getUserB().addActionListener(new ButonListener());
		this.getPlaceB().addActionListener(new ButonListener());
		this.getReturnB().addActionListener(new ButonListener());
		
		
		 
		
		this.setVisible(true);
		
		
		
		
		
	}
	
	
	



	class ButonListener implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	if ("Type Sensor".equals(e.getActionCommand())){
	    		dispose();
	    		FrameType_sensor type_sensorFrame = new FrameType_sensor();
	    	}
	    	else if ("Users".equals(e.getActionCommand())) {
	    		JOptionPane jo1=new JOptionPane();
	    		jo1.showMessageDialog(null, "Thanks to initialize me", "Error", JOptionPane.ERROR_MESSAGE);
	    	}
	    	else if ("Place".equals(e.getActionCommand())) {
	    		JOptionPane jo1=new JOptionPane();
	    		jo1.showMessageDialog(null, "Thanks to initialize me", "Error", JOptionPane.ERROR_MESSAGE);
	    	}
	    	else if ("⟵".equals(e.getActionCommand())) {
	    		FrameHome frameHome= new FrameHome();
	    		dispose();
	    	}
	    }
	}


	private AbstractButton getPlaceB() {
		// TODO Auto-generated method stub
		return placeB;
	}


	private AbstractButton getUserB() {
		// TODO Auto-generated method stub
		return userB;
	}


	private AbstractButton getTypeSensorB() {
		// TODO Auto-generated method stub
		return typeSensorB;
	}
	
	private AbstractButton getReturnB() {
		// TODO Auto-generated method stub
		return returnB;
	}

	

}
