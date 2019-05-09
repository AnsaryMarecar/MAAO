package org.secure.retirement.home.frame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;




public class FrameSensorMap extends JFrame implements ActionListener, MouseListener{
	
		
		private JPanel pan1, pan3, pan4;
		private JButton add, update, delete;
		private JLabel jlabel,jlabel1, jlabel2,jlabel3, jlabel4, jlabel5;
		
		
		
		private JMenuBar menuBar = new JMenuBar();
		private JMenu settings = new JMenu("Settings");
		private JMenu map = new JMenu("Notification");
		private JMenu analysis 	= new JMenu("Analysis"); 
		private JMenuItem settings_type_sensor = new JMenuItem("Add a type sensor");
		private JMenuItem settings_add_user = new JMenuItem("Add a user");
		private JMenuItem settings_sensors = new JMenuItem("Set a sensor");
		
		 private JPanel pan2;
		  public static int position_x, position_y;
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
			jlabel1 = new JLabel("Danger");
			jlabel2= new JLabel("Middle");
			jlabel3= new JLabel("Low");
			jlabel4= new JLabel("Normal");
			jlabel5= new JLabel("No Reponse");
			
			
			
			jlabel= new JLabel("left-click on the sensor position");
			
			
			
		
			
			// adding a menu 
			menuBar.add(map);
			menuBar.add(settings);
			menuBar.add(analysis);
			
			
			analysis.addMenuListener(new MenuListener() {

			      public void menuSelected(MenuEvent e) {
			        System.out.println("menuSelected");
			        FrameTableAnalysis frm= new FrameTableAnalysis();
			      }

			      public void menuDeselected(MenuEvent e) {
			        System.out.println("menuDeselected");

			      }

			      public void menuCanceled(MenuEvent e) {
			        System.out.println("menuCanceled");

			      }
			    });
			
			settings.addMenuListener(new MenuListener() {

			      public void menuSelected(MenuEvent e) {
			        FrameSettings sets = new FrameSettings();
			      }

			      public void menuDeselected(MenuEvent e) {
			      }

			      public void menuCanceled(MenuEvent e) {

			      }
			    });
			this.setJMenuBar(menuBar);
			
			// adding a submenu
			 this.settings.add(settings_type_sensor);
			 this.settings.add(settings_add_user);
			 this.settings.add(settings_sensors);
			
			pan1.setLayout(new BorderLayout());
			pan1.add(jlabel, BorderLayout.CENTER);
			this.setLayout(new BorderLayout());
			this.getContentPane().add(pan1, BorderLayout.NORTH);
			this.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//create and draw a map
		
		
		pan2 = new MyPanel();
		
		pan2.setBackground(Color.WHITE);
		pan2.setPreferredSize(new Dimension(1100,500));
		pan2.addMouseListener(this);

	
		this.getContentPane().add(pan2, BorderLayout.CENTER);
		this.getContentPane().add(pan3, BorderLayout.CENTER);
		this.getContentPane().add(pan4, BorderLayout.SOUTH);
		
		
			pan3.setLayout(new FlowLayout());
			jlabel1.setOpaque(true);
			jlabel1.setBackground(Color.RED);
			jlabel2.setOpaque(true);
			jlabel2.setBackground(Color.ORANGE);
			jlabel3.setOpaque(true);
			jlabel3.setBackground(Color.yellow);
			jlabel4.setOpaque(true);
			jlabel4.setBackground(Color.green);
			jlabel5.setOpaque(true);
			jlabel5.setBackground(Color.gray);
			
			
			pan3.add(jlabel1);
			pan3.add(jlabel2);
			pan3.add(jlabel3);
			pan3.add(jlabel4);
			pan3.add(jlabel5);
			
		
			
			
			pan4.setLayout(new FlowLayout());
			pan4.add(add);
			pan4.add(update);
			pan4.add(delete);
			
			
			add.addActionListener(this);
			update.addActionListener(this);
			delete.addActionListener(this);
				
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			
		}
		public void actionPerformed(ActionEvent event) {
			//à mettre dans la classe de melissa 
			if(event.getSource()==add) {
				 g = pan2.getGraphics();
				g.setColor(Color.RED);
			g.fillOval(this.position_x, this.position_y,8,8);
			
	
	
			}

			if(event.getSource()==update) {
				
					
				
								
			}

			if(event.getSource()==delete) {
			 repaint(this.position_x,this.position_y,1,1);
								
			}
			
		
		
		}
		   public void mouseClicked(MouseEvent e) {
		    	  int x,y;
		          x = e.getX();
		          y = e.getY();
		          position_x=x; position_y=y;
		        
		          if (position_x>= 180 && position_x <=1000 && position_y >= 0 && position_y<= 200 ) {
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
		FrameSensorMap f = new FrameSensorMap();
		f.setVisible(true);
	
		
	
		
	}
		}

		
		


