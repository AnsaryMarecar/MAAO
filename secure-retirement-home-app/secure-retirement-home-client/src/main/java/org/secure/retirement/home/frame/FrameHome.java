package org.secure.retirement.home.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MenuListener;

import org.secure.retirement.home.frame.Frame.ButtonListener;

public class FrameHome extends JFrame {
	

	private JPanel pan1, pan2, pan3;
	private JButton analyseB, updateB, risqB;
	private JLabel jl1;
	
	
	private JMenuBar menuBar 						= new JMenuBar();
	private JMenu settings 							= new JMenu("Settings");
	private JMenu notifications							= new JMenu("Notifications");
	private JMenuItem analysis 							= new JMenuItem("Analysis");
	private JMenuItem settings_type_sensor = new JMenuItem("Add a type sensor");
	private JMenuItem settings_add_user = new JMenuItem("Add a user");
	private JMenuItem exitItem = new JMenuItem("Exit");
	
	
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
		// adding a menu 
		this.menuBar.add(notifications);
		this.menuBar.add(settings);
		this.menuBar.add(analysis);
		this.setJMenuBar(menuBar);
		
		// adding a submenu
		 this.settings.add(settings_type_sensor);
		 this.settings.add(settings_add_user);
		 this.menuBar.add(exitItem);
		
		pan1.setLayout(new BorderLayout());
		pan1.add(jl1, BorderLayout.CENTER);
		
		pan2.setLayout(new FlowLayout());
		pan2.add(analyseB);
		pan2.add(updateB);
		pan2.add(risqB);
		
		
		this.getAnalyseB().addActionListener(new ButtonListener());
		this.getUpdateB().addActionListener(new ButtonListener());
		this.getRisqB().addActionListener(new ButtonListener());
		
		this.setVisible(true);
		
		// Menu's action listeners
		   settings_type_sensor.addActionListener(new ActionListener() {
			      public void actionPerformed(ActionEvent ev) {
			        dispose();
			        FrameType_sensor newFrame = new FrameType_sensor();
			      }
			    });
		   
		   settings_add_user.addActionListener(new ActionListener() {
			      public void actionPerformed(ActionEvent ev) {
			 // classe à créer?
			      }
			    });
		
		   analysis.addActionListener(new ActionListener() {
			      public void actionPerformed(ActionEvent ev) {
			  //      dispose();
			        FrameAnalysis analyseFrm= new FrameAnalysis();
			      }
			    });
			
	
		    exitItem.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent ev) {
		    	  JOptionPane jop = new JOptionPane();    	
		          int option = jop.showConfirmDialog(null, "Would you like to quit ?", "Quitting", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		          
		          if(option != JOptionPane.NO_OPTION) {
		        	  System.exit(0);
		          }              	  
		      }
		    });
		
	}
	
	
	class ButtonListener implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	if ("Analyse".equals(e.getActionCommand())) { 
	    		dispose();
	            FrameAnalysis analyseFrm= new FrameAnalysis();
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

