package org.secure.retirement.home.frame;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import org.secure.retirement.home.client.ClientTransmission;
import org.secure.retirement.home.common.Room;
import org.secure.retirement.home.common.Sensor;
import org.secure.retirement.home.common.Type_sensor;

/**

 *
 */

public class FrameSensor extends Frame<Sensor> {
	
	// forms atribut add name
	private JComboBox nameadd_comboBox 			= new JComboBox()							;
	private JLabel 		nameadd_label				= new JLabel("Add a type of sensor : ")		;
	
	// forms atribut update name
	private JTextField 	nameupdate_textField 		= new JTextField()							;
	private JLabel 		nameupdate_label			= new JLabel("Update the type of sensor: ")	;
	
	
	private JTextField 	sensor_min_textField 		= new JTextField()							;
	private JLabel 		sensor_min_label			= new JLabel("add sensor_min: ")	;
	
	private JTextField 	sensor_max_textField 		= new JTextField()							;
	private JLabel 		sensor_max_label			= new JLabel("add sensor_max: ")	;
	
	private JTextField 	xadd_textField 		= new JTextField(" "+FrameSensorMap.position_x)							;
	private JLabel 		xadd_label			= new JLabel("add position_x: ")	;
	
	private JTextField 	yadd_textField 		= new JTextField(" "+FrameSensorMap.position_y)							;
	private JLabel 		yadd_label			= new JLabel("add position_y: ")	;
	
	private JTextField 	address_ip_textField 		= new JTextField()							;
	private JLabel 		address_ip_label			= new JLabel("add address_ip: ")	;
	
	private JTextField address_mac_textField 		= new JTextField()							;
	private JLabel 		address_mac_label			= new JLabel("add adress_mac: ")	;
	
	
	public static int sensor_id;
	public static double position_x, position_y, sensor_min, sensor_max;
	public static int [] tabId = new int [40];
	public static String  address_ip, address_mac;
	public static Type_sensor type_sensor;
	public static Float [] tabx = new Float [40];
	public static Float [] tabsensor_min= new Float [40];
	public static Float [] taby = new Float [40];
	public static Float [] tabsensor_max = new Float [40];
	public static String [] tabtype= new String [40];
	public static String [] tabIp = new String [40];
	public static String [] tabMac= new String [40];
	
	
	
	
	private JOptionPane joptionpane_information;
	
	public FrameSensor() {
		
		// general use
		super()															;
		this.setTitle( "MAAO - Sensor " )			;
		this.setTitle_label( "Sensor" )	;   
		this.setSize(1300,600);
		Font police = new Font( "Arial" , Font.BOLD , 14 )				;
		
		// form add
		nameadd_comboBox.addItem("smoke");
		nameadd_comboBox.addItem("humidity");
		nameadd_comboBox.addItem("motion");
		nameadd_comboBox.addItem("position");
		nameadd_comboBox.addItem("brightness");
		nameadd_comboBox.addItem("occupancy");
		
		nameadd_comboBox.setFont(police)								;
		nameadd_comboBox.setPreferredSize(new Dimension(110, 30))		;
		nameadd_comboBox.setForeground(Color.BLUE)						;
		super.addform_panel.add(nameadd_label)							;
		super.addform_panel.add(nameadd_comboBox)      				;
		
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
		
		sensor_min_textField.setFont(police)								;
		sensor_min_textField .setPreferredSize(new Dimension(60,30))	;
		sensor_min_textField .setForeground(Color.BLUE)						;
		super.addform_panel.add(sensor_min_label)							;
		super.addform_panel.add(sensor_min_textField );
		
		sensor_max_textField .setFont(police)								;
		sensor_max_textField .setPreferredSize(new Dimension(60, 30))		;
		sensor_max_textField .setForeground(Color.BLUE)						;
		super.addform_panel.add(sensor_max_label)							;
		super.addform_panel.add(sensor_max_textField );
		
		address_ip_textField  .setFont(police)								;
		address_ip_textField  .setPreferredSize(new Dimension(60, 30))		;
		address_ip_textField  .setForeground(Color.BLUE)						;
		super.addform_panel.add(	address_ip_label)							;
		super.addform_panel.add(address_ip_textField );
		
		address_mac_textField  .setFont(police)								;
		address_mac_textField  .setPreferredSize(new Dimension(60, 30))		;
		address_mac_textField .setForeground(Color.BLUE)						;
		super.addform_panel.add(	address_mac_label)							;
		super.addform_panel.add(	address_mac_textField );
		
		
	    //placement in the grid layout
	    left_panel.setLayout(new GridLayout(10,1))						 ;
	    left_panel.add(	this.add_button			)						 ;
	    left_panel.add(	this.update_button		)						 ;
	    left_panel.add(	this.delete_button		)						 ;
	    left_panel.add(	this.disconnect_button	)						 ;
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
		this.getW_dtm().addColumn( "Type_Sensor"	)							;
		this.getW_dtm().addColumn( "Position_X"	)							;
		this.getW_dtm().addColumn( "Position_Y"	)							;
		this.getW_dtm().addColumn( "Sensor_Min"	)							;
		this.getW_dtm().addColumn( "Sensor_Max"	)							;
		this.getW_dtm().addColumn( "Address_Ip"	)							;
		this.getW_dtm().addColumn( "Address_Mac")							;
		
		
		
		
		this.call_initialise_table()									;
		w_table = new JTable(this.getW_dtm())							; 
		super.getComponent_panel().add( super.getW_table() 
				, BorderLayout.CENTER 
				)														;
		
		// visibility
		this.setVisible( true )											;
		

	} 
	
	
	
	class BoutonListener implements ActionListener{
		  public void actionPerformed(ActionEvent e) {		

		  }
	}
	

	public void add_table(Sensor param_sensor) {

				this.getW_dtm().addRow(
						new Object[]{
						 param_sensor.getSensor_id()
						,param_sensor.getType_sensor().getType_sensor_name() 
						,param_sensor.getSensor_positionX()
						,param_sensor.getSensor_positionY()
						,param_sensor.getSensor_min()
						,param_sensor.getSensor_max()
						,param_sensor.getSensor_ip() 
						,param_sensor.getSensor_mac() 
						
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
			sensor_id	=param_sensor[i].getSensor_id() ;
			type_sensor	=param_sensor[i].getType_sensor() ;
			position_x	=param_sensor[i].getSensor_positionX() ;
			position_y	=param_sensor[i].getSensor_positionY();
			sensor_min	=param_sensor[i].getSensor_min() ;
			sensor_max	=param_sensor[i].getSensor_max() ;
			address_ip	=param_sensor[i].getSensor_ip() ;
			address_mac	=param_sensor[i].getSensor_mac();
			
			
			
			tabId[i]=sensor_id;
			tabtype[i]=type_sensor.getType_sensor_name();
			// ces valeurs sont des double et non des int
			tabx[i]=position_x;
			taby[i]=position_y;
			tabsensor_min[i]=sensor_min;
			tabsensor_max[i]=sensor_max;
			//
			tabIp[i]=address_ip;
			tabMac[i]=address_mac;
			
			System.out.println(tabx[i]+"     "+taby[i]);
			
			
			
			
	
			
		}
		FrameSensorMap f = new FrameSensorMap();
		f.setVisible(true);

	}
	public void call_initialise_table() {
		this.getW_dtm().setRowCount(0)									;
		try {
			ClientTransmission.transmission("Sensor", "SELECT ALL", null, this);	
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
		//j'ai mis comme type type_sensor, mais je ne sais pas ce que tu recupère
		Type_sensor	 var_typesensor	= this.nameupdate_textField.getText().trim();
		//
		int 	 var_position_x	= Integer.decode( (String) this.getW_dtm().getValueAt(var_line_number, 0) );
		int 	 var_position_y		= Integer.decode( (String) this.getW_dtm().getValueAt(var_line_number, 0) );
		int 	 var_sensor_min	= Integer.decode( (String) this.getW_dtm().getValueAt(var_line_number, 0) );
		int 	 var_sensor_max	= Integer.decode( (String) this.getW_dtm().getValueAt(var_line_number, 0) );
		String	 var_address_ip	= (String) this.address_ip_textField.getText().trim();
		String	 var_address_mac	= (String) this.address_mac_textField.getText().trim();

		Sensor	 var_sensor						;		
		if(var_line_number>=0) {
			try {
				if(!var_typesensor.trim().equals("")) {
					// A revoir par vos soins
					var_sensor= new Sensor(var_sensor_id,var_typesensor, var_position_x	,var_position_y	,var_sensor_min,var_sensor_max, var_address_ip, var_address_mac	)	;
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
	 * @author ansary.marecar

	 */

	public boolean delete_action() {
		boolean to_return 			= false								;
		int var_line_number 	= this.getW_table().getSelectedRow();
		int var_id				= -1								;
		int	var_x				= 0								;
		int 	var_y				= 0								;
		int 	var_min				= 0						;
		int 	var_max				= 0;
		
		String var_ip=null;
		String var_mac=null;
		String 	var_name = null								;
		if(var_line_number>=0) {
			try {
				
				var_id 		= Integer.decode(this.getW_dtm().getValueAt(var_line_number, 0).toString() );
				var_name 	= (String) this.getW_dtm().getValueAt(var_line_number, 1)	;
				//A revoir par vos soins
				Sensor var_sensor = new Sensor(var_id,var_name, var_x , var_y, var_min, var_max,var_ip,var_mac)			;
				//
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
		String 	val_text  = (String)nameadd_comboBox.getSelectedItem();

		String	var_x				=xadd_textField .getText().trim();  
		int v_x = Integer.parseInt(var_x);
		
		String	var_y				=yadd_textField .getText().trim(); 
		int v_y = Integer.parseInt(var_y);
		String	var_sensor_min				=sensor_min_textField.getText().trim();  
		int v_sensor_min = Integer.parseInt(var_sensor_min	);
		String	var_sensor_max		=sensor_max_textField.getText().trim();  
		int v_sensor_max = Integer.parseInt(var_sensor_max);
		String	var_ip				=address_ip_textField.getText().trim();  
	
		String	var_mac				=address_mac_textField.getText().trim();  
		
		
		
									;
		if(var_x.equals("") || var_y.equals("") || var_sensor_min.equals("") || var_sensor_max.equals("") || var_ip.equals("") || var_mac.equals("")) {
			JOptionPane.showMessageDialog(null, "You must put an entry in every field", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
		}
		else {
		
			ArrayList<Sensor> val_sensors = new ArrayList<Sensor>();
			/// A revoir par vos soins
			val_sensors.add(new Sensor(0,val_text,v_x,v_y,v_sensor_min ,v_sensor_max, var_ip, var_mac ));
			/// A revoir par vos soins
			try {
				ClientTransmission.transmission("Sensor", "ADD", val_sensors, this);	
				//this.call_initialise_table()				;
					this.update_table()						;
					to_return = true						;
					JOptionPane.showMessageDialog(null, "The sensor " + val_text + " is successfully set", "MAAO - Success Message" , JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "You must put an entry in every field", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace()							;
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

	public static void main (String[] args) {
		FrameSensor framesensor = new FrameSensor();
		framesensor.setVisible(true);
		
	}
}