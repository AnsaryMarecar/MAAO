package org.secure.retirement.home.frame;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import org.secure.retirement.home.client.ClientTransmission;
import org.secure.retirement.home.common.Room;
import org.secure.retirement.home.common.Sensor;
import org.secure.retirement.home.common.Sensors;
import org.secure.retirement.home.common.Type_sensor;

/**

 *
 */

public class FrameSensor extends Frame<Sensor> {
	
	// forms atribut add name
	private JComboBox nameadd_comboBox 			= new JComboBox()							;
	private JLabel 		nameadd_label				= new JLabel("Choose your sensor's type : ")		;
	private JTextField type_sensor_id_textField        = new JTextField();
	
	// forms atribut update name
	private JTextField 	nameupdate_textField 		= new JTextField()							;
	private JLabel 		nameupdate_label			= new JLabel("Update the type of sensor: ")	;
	
	
	private JTextField 	sensor_min_textField 		= new JTextField()							;
	private JLabel 		sensor_min_label			= new JLabel("Sensor min: ")	;
	
	private JTextField 	sensor_max_textField 		= new JTextField()							;
	private JLabel 		sensor_max_label			= new JLabel("Sensor max: ")	;
	
	private JTextField address_mac_textField 		= new JTextField()							;
	private JLabel 		address_mac_label			= new JLabel("Mac Address: ")	;
	
	private JTextField 	address_ip_textField 		= new JTextField()							;
	private JLabel 		address_ip_label			= new JLabel("IP Address:")	;
	
	private JTextField 	xadd_textField 		= new JTextField(" "+FrameSensorMap.position_x)							;
	private JLabel 		xadd_label			= new JLabel("Position X: ")	;
	
	private JTextField 	yadd_textField 		= new JTextField(" "+FrameSensorMap.position_y)							;
	private JLabel 		yadd_label			= new JLabel("Position Y: ")	;
	
	private JButton generate_random_ip = new JButton ("Generate IP");
	private JButton generate_random_mac = new JButton ("Generate MAC Address");
	

	
	
	public static int sensor_id;
	public double position_x, position_y, sensor_min, sensor_max;
	public static String pos_x, pos_y, sen_min, sen_max;
	public static String  address_ip, address_mac;
	public static String type_sensor;
	
	public static int [] tabId = new int [40];
	
	public static int type_sensor_id;
	public static double [] tabx = new double [40];
	public static double [] tabsensor_min= new double[40];
	public static double [] taby = new double [40];
	public static double [] tabsensor_max = new double [40];
	public static String [] tabtype= new String [40];
	public static String [] tabIp = new String [40];
	public static String [] tabMac= new String [40];
	public static int [] tabtypesensor_id= new int [40];
	
	private ArrayList<Type_sensor> att_type_sensors;
	
	/**
	 * @return the att_type_sensors
	 */
	public final ArrayList<Type_sensor> getAtt_type_sensors() {
		return att_type_sensors;
	}





	/**
	 * @param att_type_sensors the att_type_sensors to set
	 */
	public final void setAtt_type_sensors(ArrayList<Type_sensor> att_type_sensors) {
		this.att_type_sensors = att_type_sensors;
	}

	private JOptionPane joptionpane_information;
	
	public FrameSensor() {
		
		// general use
		super()															;
		this.setTitle( "MAAO - Sensor " )			;
		this.setTitle_label( "Sensor" )	;   
		this.setSize(1300,600);
		Font police = new Font( "Arial" , Font.BOLD , 14 )				;
		
		// form add
		att_type_sensors = new ArrayList<Type_sensor>();
		att_type_sensors.add(new Type_sensor(1,"Temperature"));
		att_type_sensors.add(new Type_sensor(2,"Humidity"));
		att_type_sensors.add(new Type_sensor(3,"Motion"));
		att_type_sensors.add(new Type_sensor(4,"Position"));
		att_type_sensors.add(new Type_sensor(5,"Brigthness"));
		att_type_sensors.add(new Type_sensor(6,"Occupancy"));
		for (int i = 0 ; i<att_type_sensors.size(); i++) {
			nameadd_comboBox.addItem(att_type_sensors.get(i));
		}
		/**
		nameadd_comboBox.addItem("smoke");
		nameadd_comboBox.addItem("humidity");
		nameadd_comboBox.addItem("motion");
		nameadd_comboBox.addItem("position");
		nameadd_comboBox.addItem("brightness");
		nameadd_comboBox.addItem("occupancy");
		**/
		nameadd_comboBox.setFont(police)								;
		nameadd_comboBox.setPreferredSize(new Dimension(120, 30))		;
		nameadd_comboBox.setForeground(Color.BLUE)						;
		super.addform_panel.add(nameadd_label)							;
		super.addform_panel.add(nameadd_comboBox)      					;
		
		sensor_min_textField.setFont(police)								;
		sensor_min_textField .setPreferredSize(new Dimension(40,30))	;
		sensor_min_textField .setForeground(Color.BLUE)						;
		super.addform_panel.add(sensor_min_label)							;
		super.addform_panel.add(sensor_min_textField );
		
		sensor_max_textField .setFont(police)								;
		sensor_max_textField .setPreferredSize(new Dimension(40, 30))		;
		sensor_max_textField .setForeground(Color.BLUE)						;
		super.addform_panel.add(sensor_max_label)							;
		super.addform_panel.add(sensor_max_textField );
		
		address_mac_textField  .setFont(police)								;
		address_mac_textField  .setPreferredSize(new Dimension(130, 30))		;
		address_mac_textField .setForeground(Color.BLUE)						;
		super.addform_panel.add(	address_mac_label)							;
		super.addform_panel.add(	address_mac_textField );
		
		address_ip_textField  .setFont(police)								;
		address_ip_textField  .setPreferredSize(new Dimension(120, 30))		;
		address_ip_textField  .setForeground(Color.BLUE)						;
		super.addform_panel.add(	address_ip_label)							;
		super.addform_panel.add(address_ip_textField );
		
		
		xadd_textField .setFont(police)								;
		xadd_textField .setPreferredSize(new Dimension(60, 30))		;
		xadd_textField .setForeground(Color.BLUE)						;
		super.addform_panel.add(	xadd_label)							;
		super.addform_panel.add(xadd_textField );
		
		yadd_textField .setFont(police)								;
		yadd_textField .setPreferredSize(new Dimension(60, 30))		;
		yadd_textField .setForeground(Color.BLUE)						;
		super.addform_panel.add(	yadd_label)							;
		super.addform_panel.add(	yadd_textField );
		
		super.addform_panel.add(generate_random_ip);
		super.addform_panel.add(generate_random_mac);
		
		
		
	    //placement in the grid layout
	    left_panel.setLayout(new GridLayout(10,1))						 ;
	    left_panel.add(	this.add_button			)						 ;
	    left_panel.add(	this.update_button		)						 ;
	    left_panel.add(	this.delete_button		)						 ;
	    left_panel.add(	this.disconnect_button	)						 ;
	    left_panel.add(this.generate_random_mac);
	    left_panel.add(this.generate_random_ip);
	    component_panel.add(this.left_panel, BorderLayout.WEST)			 ;
	    component_panel.add(title_label, BorderLayout.NORTH)			 ;
		
			
		// form update
		nameupdate_textField.setFont(police)							;
		nameupdate_textField.setPreferredSize(new Dimension(150, 30))	;
		nameupdate_textField.setForeground(Color.BLUE)					;
		super.updateform_panel.add(nameupdate_label)					;
		super.updateform_panel.add(nameupdate_textField)				;
		super.updateform_panel.add(this.getFupdate_button())			;
		this.nameupdate_textField.setVisible(false)						;
		this.nameupdate_label.setVisible(false)							;
		this.getFupdate_button().setVisible(false)						;
			
		// table
		this.getW_dtm().addColumn( "Id"		)							;
		this.getW_dtm().addColumn( "Type_Sensor"	)						;
		this.getW_dtm().addColumn( "Sensor_Min"	)							;
		this.getW_dtm().addColumn( "Sensor_Max"	)							;
		this.getW_dtm().addColumn( "Address_Mac")							;
		this.getW_dtm().addColumn( "Address_Ip"	)							;
		this.getW_dtm().addColumn( "Position_X"	)							;
		this.getW_dtm().addColumn( "Position_Y"	)							;
		
		
		
		
		this.call_initialise_table()									;
		w_table = new JTable(this.getW_dtm())							; 
		super.getComponent_panel().add( super.getW_table() 
				, BorderLayout.CENTER 
				)														;
		
		// visibility
		this.setVisible( true )											;
		
		
		generate_random_ip.addActionListener(new java.awt.event.ActionListener() {
		        public void actionPerformed(java.awt.event.ActionEvent evt) {
		            randomnumip();
		        }
		    });
		
		generate_random_mac.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            randomnummac();
	        }
	    });
	} 	
	
	class BoutonListener implements ActionListener{
		  public void actionPerformed(ActionEvent e) {		

		  }
	}
	

	public void add_table(Sensor param_sensor) {

				this.getW_dtm().addRow(
						new Object[]{
						 param_sensor.getSensor_id()
						,param_sensor.getType_sensor()
						,param_sensor.getSensor_min()
						,param_sensor.getSensor_max()
						,param_sensor.getSensor_mac() 
						,param_sensor.getSensor_ip() 
						,param_sensor.getSensor_positionX()
						,param_sensor.getSensor_positionY()
						
						});
			}

	
	@Override
	/**
	 * <p>After the validation of an update, take element update non visible</p>
	 * 
	 * @author ansary.marecar
	 */
	public void update_table() {
		this.nameupdate_textField.setVisible(false)						 ;
		this.nameupdate_label.setVisible(false)							 ;
		this.getFupdate_button().setVisible(false)						 ;
	}
	
	@Override
	/**
	 * <p> initialize the table after an extraction in the database </p>
	 * 
	 * @author ansary.marecar
	 */
	
	public void initialise_table(Sensor[]  param_sensor) {
		for(int i = 0 ; i<param_sensor.length; i++) {
			this.add_table(param_sensor[i])	;
			sensor_id	= param_sensor[i].getSensor_id() ;
			type_sensor	= param_sensor[i].getType_sensor().getType_sensor_name() ;
			position_x	= param_sensor[i].getSensor_positionX() ;
			position_y	= param_sensor[i].getSensor_positionY();
			sensor_min	= param_sensor[i].getSensor_min() ;
			sensor_max	= param_sensor[i].getSensor_max() ;
			address_ip	= param_sensor[i].getSensor_ip() ;
			address_mac	= param_sensor[i].getSensor_mac();
			type_sensor_id = param_sensor[i].getType_sensor().getType_sensor_id();
			
			tabId[i]=sensor_id;
			tabtype[i]=type_sensor;
			tabtypesensor_id[i] = type_sensor_id;
			tabx[i]=position_x;
			taby[i]=position_y;
			tabsensor_min[i]=sensor_min;
			tabsensor_max[i]=sensor_max;
			//
			tabIp[i]=address_ip;
			tabMac[i]=address_mac;
			
			System.out.println(tabx[i]+"     "+taby[i]);
		}
	//	FrameSensorMap f = new FrameSensorMap();
	//	f.setVisible(true);

	}
	public void call_initialise_table() {
		this.getW_dtm().setRowCount(0)									;
		try {
			ClientTransmission.transmission("Sensors", "SELECT ALL", null, this);	
		} catch (Exception e) {
			e.printStackTrace()											;
		}
	}
	
	@Override
	/**
	 * <p>action do after push the update button</p>
	 *
	 * @author ansary.marecar
	 */
	public boolean update_action() {
		boolean  to_return 				= false;
		int 	 var_line_number 		= this.getW_table().getSelectedRow();
		int 	 var_sensor_id		= Integer.decode( (String) this.getW_dtm().getValueAt(var_line_number, 0) );

		String	 var_typesensor	= null;
		//
		double	 var_position_x	= Integer.decode(this.getW_dtm().getValueAt(var_line_number, 0).toString() );
		double	 var_position_y		= Integer.decode(this.getW_dtm().getValueAt(var_line_number, 0).toString() );
		double	 var_sensor_min	= Integer.decode(this.getW_dtm().getValueAt(var_line_number, 0).toString() );
		double	 var_sensor_max	= Integer.decode(this.getW_dtm().getValueAt(var_line_number, 0).toString() );
		String	 var_address_ip	= this.address_ip_textField.getText().trim().toString();
		String	 var_address_mac	= this.address_mac_textField.getText().trim().toString();
		int 	 var_type_sensor_id = this.type_sensor_id;
		
		Sensor	 var_sensor						;		
		if(var_line_number>=0) {
			try {
				if(!var_typesensor.equals("")) {
					// A revoir par vos soins
					Type_sensor type_sensor_structure = new Type_sensor(var_type_sensor_id,var_typesensor);
					var_sensor= new Sensor(var_sensor_id,type_sensor_structure	,var_sensor_min,var_sensor_max,var_address_mac, var_address_ip	,var_position_x	,var_position_y)	;
					//var_sensor= new Sensor(var_sensor_id,var_typesensor	,var_sensor_min,var_sensor_max,var_address_mac, var_address_ip	,var_position_x	,var_position_y)	;
					//
					ArrayList<Sensor> val_sensors = new ArrayList<Sensor>();
					val_sensors.add(var_sensor)	;
					ClientTransmission.transmission("Sensor", "UPDATE",val_sensors , this);	
					
						this.update_table()					;
						this.call_initialise_table()		;
						to_return = true					;
				}
				else {
					JOptionPane.showMessageDialog(null, "Sorry, but you can't update without a name.", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Please, select a line for update", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
		} 
		return to_return;
	}
	
	@Override
	/**
	 * <p>action do after a click of a delete button</p>
	 * 

	 */

	public boolean delete_action() {
		boolean to_return 			= false								;
		int var_line_number 	= this.getW_table().getSelectedRow();
		int var_id				= -1								;
		double	var_x				= 0								;
		double	var_y				= 0								;
		double	var_min				= 0								;
		double	var_max				= 0								;
		int var_type_sensor_id = 0;
		String var_ip=null;
		String var_mac=null;
		String 	var_name = null								;
		if(var_line_number>=0) {
			try {
				
				var_id 		= Integer.decode(this.getW_dtm().getValueAt(var_line_number, 0).toString() );
				var_name 	= this.getW_dtm().getValueAt(var_line_number, 1).toString()	;
				//!!!
				var_type_sensor_id = Integer.decode(this.getW_dtm().getValueAt(var_line_number, 2).toString() );
				//!!!
				Type_sensor type_sensor_structure = new Type_sensor(var_type_sensor_id,var_name);
				Sensor var_sensor= new Sensor(var_id,type_sensor_structure	,var_min,var_max,var_mac, var_ip	,var_x	,var_y)	;
				
				//Sensor var_sensor = new Sensor(var_id,var_name, var_min ,var_max, var_mac,var_ip,var_x,var_y)			;
				//!!!
				ArrayList<Sensor> var_sensors = new ArrayList<Sensor>()	; 
				var_sensors.add(var_sensor)									;
				ClientTransmission.transmission("Sensor", "DELETE",var_sensors , this);	
				this.update_table()							;
				//this.call_initialise_table()				;
				to_return = true							;
				JOptionPane.showMessageDialog(null, "Success", "MAAO - Error message", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace()							;
				JOptionPane.showMessageDialog(null, "Fail", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
				
			}
		}	
		return to_return;
	}


	public boolean add_action() {
		boolean to_return = false								;
		
		
		
		String	val_type_sensor_name  = nameadd_comboBox.getSelectedItem().toString(); //type_sensor.name

		
		pos_x 	= (xadd_textField .getText().toString())			;
		pos_y 	= (yadd_textField .getText())			; 
		sen_min 	= (sensor_min_textField .getText().toString())	; 
		sen_max 	= (sensor_max_textField .getText().toString())	; 
		address_ip 	= address_ip_textField.getText()						;
		address_mac	= address_mac_textField.getText()						;
		
		if ((pos_x.trim().equals("") || pos_y.trim().equals("") || sen_min.trim().equals("") || sen_max.trim().equals("") ||address_ip.trim().equals("") || address_mac.trim().equals(""))) {
			JOptionPane.showMessageDialog(null, "You must put an entry in every field", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
		} else if (!sen_min.matches("[0-9]*") || (!sen_max.matches("[0-9]*"))) { 
			JOptionPane.showMessageDialog(null, "You can only enter a number for your sensor's min and max", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
		}    
		else {
			ArrayList<Sensors> val_sensors = new ArrayList<Sensors>();
			int val_type_sensor_id = 0;
			for (int i = 0; i < this.getAtt_type_sensors().size(); i++) {
				if(this.getAtt_type_sensors().get(i).getType_sensor_name() == val_type_sensor_name) {
					val_type_sensor_id = this.getAtt_type_sensors().get(i).getType_sensor_id();
				}
			}
			
			Type_sensor type_sensor_structure = new Type_sensor(val_type_sensor_id,val_type_sensor_name);
			val_sensors.add(new Sensors(type_sensor_structure.getType_sensor_id()
					,sensor_min
					,sensor_max
					,address_mac
					, address_ip
					,position_x
					,position_y));
			
			
			try {
				ClientTransmission.transmission("Sensors", "ADD", val_sensors, this);	
				this.call_initialise_table()			;
				this.update_table()						;
				to_return = true						;
				JOptionPane.showMessageDialog(null, "The sensor " + val_type_sensor_name + " is successfully set", "MAAO - Success Message" , JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "You must put an entry in every field", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace()						;
			}
		}
		return to_return;
	}
	
	@Override
	/**
	 * 
	 * <p>do visible update form when update button is clicked</p>
	 * 
	 * @author ansary.marecar
	 */
	public void update_on(int param_line_number) {
		String	 val_type_sensor		= (String) this.getW_dtm().getValueAt(param_line_number, 1)					;
		this.nameupdate_textField.setText(val_type_sensor)															;
		this.nameupdate_label.setVisible(true)																			;
		this.nameupdate_textField.setVisible(true)																		;
		this.getFupdate_button().setVisible(true)																		;
	}

	public void actionPerformed(ActionEvent arg0) {
	}

	public JOptionPane getJoptionpane_information() {
		return joptionpane_information;
	}
	
	public void randomnumip() {
		Random r = new Random();
		String v = r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);
		address_ip_textField.setText(v);
		}
	
	
	private void randomnummac(){
	    Random rand = new Random();
	    byte[] macAddr = new byte[6];
	    rand.nextBytes(macAddr);

	    macAddr[0] = (byte)(macAddr[0] & (byte)254);

	    StringBuilder sb = new StringBuilder(18);
	    for(byte b : macAddr){

	        if(sb.length() > 0)
	            sb.append(":");
	        sb.append(String.format("%02x", b));
	    }
	    address_mac_textField.setText(sb.toString());
	}

	public static void main (String[] args) {
		FrameSensor framesensor = new FrameSensor();
		framesensor.setVisible(true);
		
	}





	@Override
	public void initialise(String param_json, String param_class) throws IOException {
		// TODO Auto-generated method stub
		
	}
}