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
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import org.secure.retirement.home.client.ClientTransmission;
import org.secure.retirement.home.common.Room;
import org.secure.retirement.home.common.Sensor;




public class FrameSensorMap extends Frame<Room> implements ActionListener, MouseListener{
	
		
		private JPanel pan1, pan3, pan4, pan5;
		private JButton add, update, delete;
		private JLabel jlabel,jlabel1, jlabel2,jlabel3, jlabel4, jlabel5, jlabel6;
		
		
		
		private JMenuBar menuBar = new JMenuBar();
		private JMenu settings = new JMenu("Settings");
		private JMenu map = new JMenu("Notification");
		private JMenu analysis 	= new JMenu("Analysis"); 
		private JMenuItem settings_type_sensor = new JMenuItem("Add a type sensor");
		private JMenuItem settings_add_user = new JMenuItem("Add a user");
		private JMenuItem settings_sensors = new JMenuItem("Set a sensor");
		
		 private JPanel pan2;
		  public static double position_x, position_y;
		    Graphics g;
			public static int room_id, x_min, x_max, y_min, y_max;
			public static int [] tabId = new int [40];
			public static String  names;
			public static int [] tabx = new int [40];
			public static int [] tabxx= new int [40];
			public static int [] taby = new int [40];
			public static int [] tabyy = new int [40];
			public static String [] tabName= new String [40];
		   
		    
		public FrameSensorMap() {
			
			this.setLocationRelativeTo(null);
			this.setSize(1200, 650);
			this.setResizable(false);
			
			
		
			
			pan1= new JPanel();
			
			pan3 = new JPanel();
			pan4 = new JPanel();
			pan5 = new JPanel();
			
			add= new JButton("ADD");
			update= new JButton ("UPDATE");
			delete = new JButton ("DELETE");
			jlabel1 = new JLabel("Danger");
			jlabel2= new JLabel("Middle");
			jlabel3= new JLabel("Low");
			jlabel4= new JLabel("Normal");
			jlabel5= new JLabel("No Reponse");
			jlabel6 = new JLabel("Etat");
			
			
			jlabel= new JLabel("left-click on the sensor position");
			pan5 = new JPanel();
			pan5.setLayout(new BorderLayout());
			pan5.add(jlabel6, BorderLayout.WEST);
			pan5.setBorder(new BevelBorder (BevelBorder.LOWERED));
			pan5.setBackground(Color.CYAN);
			
			
			
		
			
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
			 this.call_initialise_table()									;
			
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
		pan2.setPreferredSize(new Dimension(1200,500));
		pan2.addMouseListener(this);

		this.getContentPane().add(pan2, BorderLayout.CENTER);
		this.getContentPane().add(pan3, BorderLayout.CENTER);
		this.getContentPane().add(pan4, BorderLayout.SOUTH);
		this.add(pan5, BorderLayout.SOUTH);
		
		
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
			
FrameSensorMap f = new FrameSensorMap();
	
			}

			if(event.getSource()==update) {
				
					
				
								
			}

			if(event.getSource()==delete) {
				 {
					 
			 
				}
								
			}
			
		
		
		}
		   public void mouseClicked(MouseEvent e) {
		    	  double x,y;
		          x = e.getX();
		          y = e.getY();
		          position_x=x; position_y=y;
		          jlabel6.setText(" " +position_x + " " +position_y);
		         
		          System.out.println( pan2.getHeight());
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
		    public void mouseEntered(MouseEvent e) {
		    	if (e.getX()==position_x && e.getY()==position_y) {
		  pan2.setToolTipText("jkbjk");
		    	}
		    	}  
		    
		    public void mouseExited(MouseEvent e){}
			public void mouseReleased(MouseEvent e) {}
			
	public static void main(String [] args) {
		FrameSensorMap f = new FrameSensorMap();
		f.setVisible(true);
	}
	@Override
	public boolean add_action() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update_action() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete_action() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void update_on(int line_number) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void initialise_table(Room[] param_room) {
		// TODO Auto-generated method stub
		//
		for(int i = 0 ; i<param_room.length; i++) {
			room_id=param_room[i].getRoom_id() ;
			names=param_room[i].getRoom_name() ;
			x_min=param_room[i].getX_min() ;
			x_max=param_room[i].getX_max() ;
			y_min=param_room[i].getY_min() ;
			y_max=param_room[i].getY_max() ;
			
			
			System.out.println(room_id);
			tabId[i]=room_id;
			tabName[i]=names;
			tabx[i]=x_min;
			tabxx[i]=x_max;
			taby[i]=y_min;
			tabyy[i]=y_max;
			
		}
		
	}
	
	public void initialise_table(Sensor[] param_sensor) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i<param_sensor.length; i++) {
			System.out.println(param_sensor);
		}
		
	}
	@Override
	public void add_table(Room obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update_table() {
		// TODO Auto-generated method stub
		
	}
	public void call_initialise_table() {
		try {
			ClientTransmission.transmission("Sensor", "SELECT ALL", null, this);	
		} catch (Exception e) {
			e.printStackTrace()											;
		}
		try {
			ClientTransmission.transmission("Room", "SELECT ALL", null, this);	
		} catch (Exception e) {
			e.printStackTrace()											;
		}
		
	}

}