package org.secure.retirement.home.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class FrameAnalysis extends JFrame {
	
	private JRadioButton sensor, risq, historic;
	private JPanel pan1, pan2, pan3, pan4;
	private JLabel jl1;
	private JLayeredPane jlp, jlp2;
	private JCheckBox sensorList;
	
	
	
	public FrameAnalysis() {
		
		jl1= new JLabel();
		sensorList= new JCheckBox();
		
		this.setLocationRelativeTo(null);
		this.setSize(600, 600);
		this.setResizable(false);
		
		sensor = new JRadioButton("Sensors");
		sensor.setForeground(Color.WHITE);
		sensor.setBackground(Color.DARK_GRAY);
		
		
		risq = new JRadioButton("Risq");
		risq.setForeground(Color.WHITE);
		risq.setBackground(Color.DARK_GRAY);
		sensor.setActionCommand("Risq");
		
		historic = new JRadioButton("Historic");
		historic.setForeground(Color.WHITE);
		historic.setBackground(Color.DARK_GRAY);
		sensor.setActionCommand("Historic");
		
		
		pan1= new JPanel();
		pan1.setBackground(Color.DARK_GRAY);
		pan2= new JPanel();
		pan2.setBackground(Color.LIGHT_GRAY);
		pan3= new JPanel();
		pan3.setBackground(Color.DARK_GRAY);
		pan4= new JPanel();
		pan4.setBackground(Color.LIGHT_GRAY);
		

		
		
		
		jlp= new JLayeredPane();
		jlp2= new JLayeredPane();
		
		jlp.add(pan1);
		jlp.add(pan3);
		jlp.add(pan4);
		
		this.setLayout(new BorderLayout()); 
		this.getContentPane().add(jlp); 
		
		pan1.setBounds(0,0,600, 100);
		pan1.add(sensor);
		pan1.add(risq);
		pan1.add(historic);
		
		pan2.setBounds(0,100, 600, 500);
		
		pan3.setBounds(0,100,200,500);
		pan4.setBounds(200,100,400,500);
		
		
		
		
		
		
		
		this.setVisible(true);
		

	}
	
	
	public void actionPerformed (ActionEvent e) {
		String ac=new String();
		ac=e.getActionCommand();
		
		if (sensor.isSelected()) {
			pan3.add(sensorList);
		}
	}



	private Object getSensor() {
		// TODO Auto-generated method stub
		return sensor;
	}
	
	
	
	
	
	
	

}
