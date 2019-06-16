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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
import org.secure.retirement.home.common.Sensors;
import org.secure.retirement.home.common.Type_sensor;
import org.secure.retirement.home.common.transmission.json.Decode;




public class FrameSensorMap extends Frame<Room>implements ActionListener, MouseListener{
	
		
		private JPanel pan1, pan3, pan4, pan5;
		private JButton configuration, refresh;
		private JLabel jlabel,jlabel1, jlabel4, jlabel5, jlabel6;
		public static ArrayList<Sensor> att_sensors; 
		
		private JMenuBar menuBar = new JMenuBar();
		private JMenu map = new JMenu("Notification");
		private JMenu analysis 	= new JMenu("Analysis"); 
		
		
		 private JPanel pan2;
		 private String value;
		  public static double position_x, position_y,x,y,min,max;
		    Graphics g;
			public static int room_id, x_min, x_max, y_min, y_max,historic_value;
			public static int [] tabId = new int [60];
			public static String  names;
			public static int [] tabx = new int [60];
			public static int [] tabxx= new int [60];
			public static int [] taby = new int [60];   
			public static int [] tabyy = new int [60];
			public static String [] tabName= new String [60];
			public static double [] tabsensor_x = new double [60];
			public static double [] tabsensor_y = new double [60];
			public static double [] tabsensor_min= new double [60];
			public static double [] tabsensor_max= new double [60];
			
			public static int  [] tabhistoric_value = new int [60];
			
		    
		    public FrameSensorMap() {
			
			this.setLocationRelativeTo(null);
			this.setSize(1200, 650);
			this.setResizable(false);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
			
			pan1= new JPanel();
			
			pan3 = new JPanel();
			pan4 = new JPanel();
			pan5 = new JPanel();
			
			configuration= new JButton("ConfigurationSensor");
			
			refresh = new JButton ("REFRESH");
			jlabel1 = new JLabel("Danger");
			jlabel4= new JLabel("Normal");
			jlabel5= new JLabel("No Reponse");
			jlabel6 = new JLabel("STATE");
			
			
			jlabel= new JLabel("left-click on the sensor position");
			pan5 = new JPanel();
			pan5.setLayout(new BorderLayout());
			pan5.add(jlabel6, BorderLayout.WEST);
			pan5.setBorder(new BevelBorder (BevelBorder.LOWERED));
			pan5.setBackground(Color.CYAN);
			
			// adding a menu 
			menuBar.add(map);
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

			this.setJMenuBar(menuBar);
			this.call_initialise_table()									;
	
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
			jlabel4.setOpaque(true);
			jlabel4.setBackground(Color.green);
			jlabel5.setOpaque(true);
			jlabel5.setBackground(Color.gray);
			
			
			pan3.add(jlabel1);
			pan3.add(jlabel4);
			pan3.add(jlabel5);
		
			pan4.setLayout(new FlowLayout());
			pan4.add(configuration);
			pan4.add(refresh);
			
			configuration.addActionListener(this);
			refresh.addActionListener(this);
		
			//FrameSensorMap f = new FrameSensorMap();
			
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			
		}
		 public void actionPerformed(ActionEvent event) {
			//à mettre dans la classe de melissa 
			    if(event.getSource()==configuration) {
				FrameSensor f= new FrameSensor();
			}
			if(event.getSource()==refresh) {
				pan2.repaint();		
				FrameSensorMap f= new FrameSensorMap();
			}
		}
		public void mouseClicked(MouseEvent e) {
		    	  double x,y;
		          x = e.getX();
		          y = e.getY();
		          position_x=x; position_y=y;
		          jlabel6.setText(" " +position_x + " " +position_y);
		         
		          if (position_x>= 180 && position_x <=500 && position_y >= 0 && position_y<= 200 ) {
		        	  JOptionPane.showMessageDialog(null, "Sorry, but you can't add sensor in this zone", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
		          }
		          if (position_x>= 700 && position_x <=1000 && position_y >= 0 && position_y<= 200 ) {
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
		    public void mouseEntered(MouseEvent e) {}   
		    public void mouseExited(MouseEvent e){}
			public void mouseReleased(MouseEvent e) {}
			

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

	public void initialise_tableSensors(Sensors[] param_sensor) {
		// TODO Auto-generated method stub
	
		for(int i = 0 ; i<param_sensor.length; i++) {
			x=param_sensor[i].getSensor_positionX();
			y=param_sensor[i].getSensor_positionY();
			min =param_sensor[i].getSensor_min();
			max=param_sensor[i].getSensor_max();
			
			tabsensor_x[i]=x;
			tabsensor_y[i]=y;
			tabsensor_min[i]=min;
			tabsensor_max[i]=max;
			
		}
		}
		
		public void initialise_tableHistorics(String[] param) {
			// TODO Auto-generated method stub
			ArrayList<String> list_string;
			for(int i =0; i<=param.length; i++) {
		int j= i*4;
				System.out.println		  ("sensor_value    "+ param[i]  );
				list_string = new ArrayList<String>(Arrays.asList(param));	
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
			System.out.println("sensors select all");
			ClientTransmission.transmission("Sensors", "SELECT ALL", null, this);	
		} catch (Exception e) {
			e.printStackTrace()											;
		}
		try {
			System.out.println("room select all");
			ClientTransmission.transmission("Room", "SELECT ALL", null, this);	
		} catch (Exception e) {
			e.printStackTrace()											;
		}
		
	}
	
	/**
	 * @return the att_sensors
	 */
	public static ArrayList<Sensor> getAtt_sensors() {
		return att_sensors;
	}
	/**
	 * @param att_sensors the att_sensors to set
	 */
	public static void setAtt_sensors(ArrayList<Sensor> att_sensors) {
		att_sensors = att_sensors;
	}
	
	@Override
	public void initialise(String param_json, String param_class) throws IOException {
		// TODO Auto-generated method stub
		switch(param_class) {
		case "Sensors":
			System.out.println("swith sensors begin" );
			this.initialise_tableSensors(Decode.to_decodeSensors(param_json, param_class));
			System.out.println("swith sensors end");
			break;
		case "Room":
			System.out.println("swith room begin");
			//this.initialise_table((Room[]) val_object);
			System.out.println("swith room end");
			break;
		}
		
	}
	public static void main(String [] args) {
		FrameSensorMap f = new FrameSensorMap();
		f.setVisible(true);	
	}
}

		
		


