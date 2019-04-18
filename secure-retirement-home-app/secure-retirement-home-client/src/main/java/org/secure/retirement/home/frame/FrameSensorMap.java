package org.secure.retirement.home.frame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import com.sun.prism.Graphics;



public class FrameSensorMap extends JFrame implements ActionListener, MouseListener{
	

	
		
		
		private JPanel pan1, pan3, pan4;
		private JButton add, update, delete;
		private JLabel jl1;
		private JRadioButton b1, b2,b3, b4, b5, test;
		
		private JMenuBar menuBar 						= new JMenuBar();
		private JMenu settings 							= new JMenu("Settings");
		private JMenu map							= new JMenu("Notification");
		private JMenu analysis 							= new JMenu("Analysis");
		private JMenuItem settings_type_sensor = new JMenuItem("Add a type sensor");
		private JMenuItem settings_add_user = new JMenuItem("Add a user");
		MyPanel pan2 = new MyPanel();
		protected static int x1, x2;
		
		public FrameSensorMap() {
			
			this.setLocationRelativeTo(null);
			this.setSize(1200, 650);
			this.setResizable(false);
			
			
			pan1= new JPanel();
			
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
			
			
			
		
			
			// adding a menu 
			this.menuBar.add(map);
			this.menuBar.add(settings);
			this.menuBar.add(analysis);
			analysis.addMenuListener(new MenuListener() {

			      public void menuSelected(MenuEvent e) {
			        System.out.println("menuSelected");
			        FrameAnalysis frm= new FrameAnalysis();
			      }

			      public void menuDeselected(MenuEvent e) {
			        System.out.println("menuDeselected");

			      }

			      public void menuCanceled(MenuEvent e) {
			        System.out.println("menuCanceled");

			      }
			    });
			this.setJMenuBar(menuBar);
			
			// adding a submenu
			 this.settings.add(settings_type_sensor);
			 this.settings.add(settings_add_user);
			
			pan1.setLayout(new BorderLayout());
			pan1.add(jl1, BorderLayout.CENTER);
			this.setLayout(new BorderLayout());
			this.getContentPane().add(pan1, BorderLayout.NORTH);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
		pan2.setBackground(Color.WHITE);
		pan2.setPreferredSize(new Dimension(1000,500));
		pan2.addMouseListener(this);
		/*
	Scanner x= new Scanner(System.in);
	 x1 = x.nextInt();
	Scanner y= new Scanner(System.in);
	y1 = y.nextInt();
	Scanner xx= new Scanner(System.in);
	 x2= xx.nextInt();
	Scanner yy= new Scanner(System.in);
	y2 = yy.nextInt();
	*/
	
		this.getContentPane().add(pan2, BorderLayout.CENTER);
		this.getContentPane().add(pan3, BorderLayout.CENTER);
		this.getContentPane().add(pan4, BorderLayout.SOUTH);
			pan3.setLayout(new FlowLayout());
			pan3.add(b1);
			pan3.add(b2);
			pan3.add(b3);
			pan3.add(b4);
			pan3.add(b5);
			
			b1.setSelected(true);
			b2.setSelected(true);
			b3.setSelected(true);
			b4.setSelected(true);
			b5.setSelected(true);
			
			
			pan4.setLayout(new FlowLayout());
			pan4.add(add);
			pan4.add(update);
			pan4.add(delete);
			
			
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
		public void mouseClicked(MouseEvent event) {
		        System.out.println("Voici les coordonnées : "+ 
		event.getX()+" "+event.getY()+ " ");
		       
		}
	    public void mousePressed(MouseEvent e) {}
	    public void mouseExited(MouseEvent e) {}
	    public void mouseReleased(MouseEvent e) {}
	    public void mouseEntered(MouseEvent e) {}
	

	public static void main(String [] args) {
		FrameSensorMap sensormap = new FrameSensorMap ();
		sensormap.setVisible(true);
	}
	
	
		}

		
		


