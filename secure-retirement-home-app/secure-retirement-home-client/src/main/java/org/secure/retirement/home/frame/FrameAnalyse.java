package org.secure.retirement.home.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class FrameAnalyse extends JFrame {
	
	private JRadioButton nbSensor, nbRisq, historic;
	private JPanel pan1, pan2, pan3, pan4, pan5, pan6;
	private JLabel jl1;
	
	
	
	public FrameAnalyse() {
		
		
		this.setLocationRelativeTo(null);
		this.setSize(600, 600);
		this.setResizable(false);
		
		
		nbSensor = new JRadioButton();
		nbRisq = new JRadioButton();
		historic = new JRadioButton();
		
		
		pan1= new JPanel();
		pan1.setBackground(Color.RED);
		pan2= new JPanel();
		pan2.setBackground(Color.YELLOW);
		pan3= new JPanel();
		pan3.setBackground(Color.GREEN);
		pan4= new JPanel();
		pan4.setBackground(Color.BLACK);
		
		jl1= new JLabel();
		
		
		this.setLayout(new BorderLayout()); 
		this.getContentPane().add(pan1, BorderLayout.NORTH); 
		this.getContentPane().add(pan2, BorderLayout.CENTER);
		
		pan1.setSize(300, 600);
		pan1.add(nbSensor);
		pan1.add(nbRisq);
		pan1.add(historic);
		
		pan2.setLayout(new BorderLayout());
		pan2.setSize(200,600);
		pan2.add(pan3, BorderLayout.WEST);
		pan2.add(pan4);
		
		
		
		
		
		
		
		
		
		
		
		
		this.setVisible(true);
		
		
		
		
	}
	
	
	
	
	
	
	

}
