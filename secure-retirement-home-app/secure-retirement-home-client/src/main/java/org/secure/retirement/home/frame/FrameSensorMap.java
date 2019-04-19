package org.secure.retirement.home.frame;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;




public class FrameSensorMap extends JFrame implements ActionListener, MouseListener{
	

	
		
		
		private JPanel pan1, pan3, pan4;
		private JButton add, update, delete;
		private JLabel jl1,b1, b2,b3, b4, b5;
		private JRadioButton test;
		
		
		private JMenuBar menuBar 						= new JMenuBar();
		private JMenu settings 							= new JMenu("Settings");
		private JMenu map							= new JMenu("Notification");
		private JMenu analysis 							= new JMenu("Analysis");
		private JMenuItem settings_type_sensor = new JMenuItem("Add a type sensor");
		private JMenuItem settings_add_user = new JMenuItem("Add a user");
		MyPanel pan2 = new MyPanel();
		  private int x1, y1;
		    Graphics g;
		 
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
			b1 = new JLabel("Danger");
			b2= new JLabel("Middle");
			b3= new JLabel("Low");
			b4= new JLabel("Normal");
			b5= new JLabel("No Reponse");
			
			
			
			jl1= new JLabel("left-click on the sensor position");
			
			
			
		
			
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
			this.setLayout(new BorderLayout());
			this.getContentPane().add(pan1, BorderLayout.NORTH);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
		pan2.setBackground(Color.WHITE);
		pan2.setPreferredSize(new Dimension(1000,500));
		pan2.addMouseListener(this);

	
		this.getContentPane().add(pan2, BorderLayout.CENTER);
		this.getContentPane().add(pan3, BorderLayout.CENTER);
		this.getContentPane().add(pan4, BorderLayout.SOUTH);
		
		
			pan3.setLayout(new FlowLayout());
			b1.setOpaque(true);
			b1.setBackground(Color.RED);
			b2.setOpaque(true);
			b2.setBackground(Color.ORANGE);
			b3.setOpaque(true);
			b3.setBackground(Color.yellow);
			b4.setOpaque(true);
			b4.setBackground(Color.green);
			b5.setOpaque(true);
			b5.setBackground(Color.gray);
			
			
			pan3.add(b1);
			pan3.add(b2);
			pan3.add(b3);
			pan3.add(b4);
			pan3.add(b5);
			
		
			
			
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
			//à mettre dans la classe de melissa 
			if(event.getSource()==add) {
				 g = pan2.getGraphics();
				g.setColor(Color.RED);
			g.drawOval(this.x1, this.y1,5,5);
			
			
	
			}

			if(event.getSource()==update) {
				
					
				
								
			}

			if(event.getSource()==delete) {
			 
								
			}
			
		
		
		}
		   public void mouseClicked(MouseEvent e) {
		    	  int x,y;
		          x = e.getX();
		          y = e.getY();
		          x1=x; y1=y;
		        
		          if (x1>= 180 && x1 <=1000 && y1 >= 0 && y1 <= 200 ) {
		        	  JOptionPane.showMessageDialog(null, "Sorry, but you can't add sensor in this zone", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
		          }
		          if (e.getClickCount()!=1) {
		        	  System.out.println(e.getClickCount());
		        	  JOptionPane.showMessageDialog(null, "Sorry, but you have already click once", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
		          }
		          if(SwingUtilities.isRightMouseButton(e)) { 
		                /** Bouton DROIT */ 
		         
		             JOptionPane.showMessageDialog(null, "Sorry, but you should to do left-click", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
		        } else if(SwingUtilities.isMiddleMouseButton(e) ) { 
		                /** Bouton du MILIEU */   JOptionPane.showMessageDialog(null, "Sorry, but you should to do left-click", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
		        }
		          
		   }
	
			  public void mousePressed(MouseEvent e) {}
		    public void mouseEntered(MouseEvent event) {}  
		    public void mouseExited(MouseEvent evt){}
			public void mouseReleased(MouseEvent arg0) {}
			
	public static void main(String [] args) {
		FrameSensorMap sensormap = new FrameSensorMap ();
		sensormap.setVisible(true);
	}
		}

		
		


