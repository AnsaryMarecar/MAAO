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

import org.secure.retirement.home.frame.Frame.ButonListener;

public class FrameHome extends JFrame {
	
	
	private JPanel pan1, pan2, pan3;
	private JButton analyseB, updateB, risqB;
	private JLabel jl1;
	
	
	
	
	public FrameHome() {
		
		this.setLocationRelativeTo(null);
		this.setSize(300, 200);
		this.setResizable(false);
		
		
		pan1= new JPanel();
		pan2= new JPanel();
		pan3 = new JPanel();
		
		analyseB = new JButton("Analyse");
		updateB= new JButton ("Update");
		risqB = new JButton ("risq");
		
		jl1= new JLabel("Select a button");
		
		
		
		this.setLayout(new BorderLayout());
		this.getContentPane().add(pan1, BorderLayout.NORTH);
		this.getContentPane().add(pan2, BorderLayout.CENTER);
		this.getContentPane().add(pan3, BorderLayout.SOUTH);
		
		pan1.setLayout(new BorderLayout());
		pan1.add(jl1, BorderLayout.CENTER);
		
		pan2.setLayout(new FlowLayout());
		pan2.add(analyseB);
		pan2.add(updateB);
		pan2.add(risqB);
		
		
		this.getAnalyseB().addActionListener(new ButonListener());
		this.getUpdateB().addActionListener(new ButonListener());
		this.getRisqB().addActionListener(new ButonListener());
		
		this.setVisible(true);
		
	}
	
	
	class ButonListener implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	if ("Analyse".equals(e.getActionCommand())) { 
	    		dispose();
	            FrameAnalyse analyseFrm= new FrameAnalyse();
	        }
	    	
	    	
	    	else if ("Update".equals(e.getActionCommand())) { 
	            FrameUpdate analyseFrm= new FrameUpdate();
	            dispose();
	        }
	    	
	    	else if ("Risq".equals(e.getActionCommand())) { 
		    		JOptionPane jo1=new JOptionPane();
		    		jo1.showMessageDialog(null, "Thanks to initialize me", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}



	private AbstractButton getRisqB() {
		// TODO Auto-generated method stub
		return risqB;
	}




	private AbstractButton getUpdateB() {
		// TODO Auto-generated method stub
		return updateB;
	}




	private AbstractButton getAnalyseB() {
		// TODO Auto-generated method stub
		return analyseB;
	}
	
	
	

}

