package org.secure.retirement.home.frame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JPanel;
import javax.swing.JRadioButton;



public class FrameSensorMap extends JFrame implements ActionListener{
	

	
		
		
		private JPanel pan1, pan2, pan3, pan4;
		private JButton add, update, delete;
		private JLabel jl1;
		private JRadioButton b1, b2,b3, b4, b5;
		
		private JMenuBar menuBar 						= new JMenuBar();
		private JMenu settings 							= new JMenu("Settings");
		private JMenu map							= new JMenu("Notification");
		private JMenu analysis 							= new JMenu("Analysis");
		private JMenuItem settings_type_sensor = new JMenuItem("Add a type sensor");
		private JMenuItem settings_add_user = new JMenuItem("Add a user");
		
		
		
		public FrameSensorMap() {
			
			this.setLocationRelativeTo(null);
			this.setSize(1200, 650);
			this.setResizable(false);
			
			
			pan1= new JPanel();
			pan2= new JPanel();
			pan3 = new JPanel();
			pan4 = new JPanel();
			
				add= new JButton("ADD");
			update= new JButton ("UPDATE");
			delete = new JButton ("DELETE");
			b1 = new JRadioButton("Danger");
			b2= new JRadioButton("Middle");
			b3= new JRadioButton("Low");
			b4= new JRadioButton("Normal");
			b5= new JRadioButton("No Reponse");
			
			
			jl1= new JLabel("left-click on the sensor position");
			
			
			
			this.setLayout(new BorderLayout());
			this.getContentPane().add(pan1, BorderLayout.NORTH);
			this.getContentPane().add(pan2, BorderLayout.CENTER);
			this.getContentPane().add(pan3, BorderLayout.SOUTH);
		//	this.getContentPane().add(pan4, BorderLayout.SOUTH);
			
			// adding a menu 
			this.menuBar.add(map);
			this.menuBar.add(settings);
			this.menuBar.add(analysis);
			this.setJMenuBar(menuBar);
			
			// adding a submenu
			 this.settings.add(settings_type_sensor);
			 this.settings.add(settings_add_user);
			
			pan1.setLayout(new BorderLayout());
			pan1.add(jl1, BorderLayout.CENTER);
			
			
			pan3.setLayout(new FlowLayout());
			pan3.add(b1);
			pan3.add(b2);
			pan3.add(b3);
			pan3.add(b4);
			pan3.add(b5);
			
		//	pan3.setLayout(new FlowLayout());
			pan3.add(add);
			pan3.add(update);
			pan3.add(delete);
			
			
			add.addActionListener(this);
			update.addActionListener(this);
			delete.addActionListener(this);
				
			
			this.setVisible(true);
			
		}
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource()==add) {
			 
								
			}

			if(event.getSource()==update) {
			 
								
			}

			if(event.getSource()==delete) {
			 
								
			}
			
		
		
		}
		}

		
		


