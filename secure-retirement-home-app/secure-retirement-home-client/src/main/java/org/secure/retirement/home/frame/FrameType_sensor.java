package org.secure.retirement.home.frame;

/**
 * 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.secure.retirement.home.client.ClientTransmission;
import org.secure.retirement.home.common.Encode;
import org.secure.retirement.home.common.Type_sensor;
import org.secure.retirement.home.service.*;

/**
 * @author Ansary MARECAR
 *
 */

public class FrameType_sensor extends Frame<Type_sensor> {
	
	// forms atribut add name
	private JTextField 	nameadd_textField 			= new JTextField()							;
	private JLabel 		nameadd_label				= new JLabel("Add a type of sensor : ")		;
	
	// forms atribut update name
	private JTextField 	nameupdate_textField 		= new JTextField()							;
	private JLabel 		nameupdate_label			= new JLabel("Update the name of the type sensor : ")	;

	
	public FrameType_sensor() {
		// TODO Auto-generated constructor stub
		
		// general use
		super()															;
		this.setTitle( "MAAO - Configuration  Type Sensor " )			;
		this.setTitle_label( "Configuration type sensor" )				;   
		Font police = new Font( "Arial" , Font.BOLD , 14 )				;
		
		// form add
		nameadd_textField.setFont(police)								;
		nameadd_textField.setPreferredSize(new Dimension(150, 30))		;
		nameadd_textField.setForeground(Color.BLUE)						;
		super.addform_panel.add(nameadd_label)							;
		super.addform_panel.add(nameadd_textField)						;
			
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
		this.getW_dtm().addColumn( "Nom"	)							;
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
	
	@Override
	/**
	 * <p>Add a row</p>
	 * 
	 * @author ansary.marecar
	 */
	public void add_table(Type_sensor param_type_sensor) {
		// TODO Auto-generated method stub
		this.getW_dtm().addRow(
				new String[]{
					String.valueOf(param_type_sensor.getType_sensor_id())
				,	param_type_sensor.getType_sensor_name()
				}); 
	}
	
	@Override
	/**
	 * <p>After the validation of an update, take element update non visible</p>
	 * 
	 * @author ansary.marecar
	 */
	public void update_table() {
		// TODO Auto-generated method stub
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
	public void initialise_table(Type_sensor[]  param_type_sensors) {
		for(int i = 0 ; i<param_type_sensors.length; i++) {
			this.add_table(param_type_sensors[i])						;
			System.out.println("initialise table good")					;
		}
	}
	public void call_initialise_table() {
		// TODO Auto-generated method stub
		Type_sensor[] val_list									 		;	
		
		this.getW_dtm().setRowCount(0)									;
		try {
			ClientTransmission.transmission("Type_sensor", "SELECT ALL", null, this);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		// TODO Auto-generated method stub
		boolean  to_return 				= false;
		int 	 var_line_number 		= this.getW_table().getSelectedRow();
		int 	 var_type_sensor_id		= Integer.decode( (String) this.getW_dtm().getValueAt(var_line_number, 0) );
		String	 var_type_sensor_name	= (String) this.nameupdate_textField.getText().trim();

		Type_sensor	 var_type_sensor						;		
		if(var_line_number>=0) {
			try {
				if(!var_type_sensor_name.trim().equals("")) {
					var_type_sensor = new Type_sensor(var_type_sensor_id,var_type_sensor_name)	;
					ArrayList<Type_sensor> val_type_sensors = new ArrayList<Type_sensor>();
					val_type_sensors.add(var_type_sensor)	;
					ClientTransmission.transmission("Type_sensor", "UPDATE",val_type_sensors , this);	
					
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
		// TODO Auto-generated method stub
		boolean to_return 			= false								;
		int 	var_line_number 	= this.getW_table().getSelectedRow();
		int 	var_id				= -1								;
		String 	var_name 			= null								;
		if(var_line_number>=0) {
			try {
				
				var_id 		= Integer.decode( (String) this.getW_dtm().getValueAt(var_line_number, 0) );
				var_name 	= (String) this.getW_dtm().getValueAt(var_line_number, 1)	;
				Type_sensor var_type_sensor = new Type_sensor(var_id,var_name)			;
				ArrayList<Type_sensor> var_type_sensors = new ArrayList<Type_sensor>()	;
				var_type_sensors.add(var_type_sensor)									;
				ClientTransmission.transmission("Type_sensor", "DELETE",var_type_sensors , this);	
				this.update_table()							;
				this.call_initialise_table()				;
				to_return = true							;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace()							;
			}
		}	
		return to_return;
	}
	
	@Override
	/**
	 * <p>action do after add button</p>
	 * 
	 * @author ansary.marecar
	 */
	public boolean add_action() {
		// TODO Auto-generated method stub
		boolean to_return = false							;
		String val_text = nameadd_textField.getText().trim();
		
		if(val_text.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Sorry, but you can't add without a name.", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
		}
		else {
			ArrayList<Type_sensor> val_type_sensors = new ArrayList<Type_sensor>();
			val_type_sensors.add(new Type_sensor(0,val_text));
			try {
				ClientTransmission.transmission("Type_sensor", "ADD", val_type_sensors, this);	
				this.call_initialise_table()				;
					this.update_table()						;
					to_return = true						;
			} catch (Exception e) {
				// TODO Auto-generated catch block
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
		// TODO Auto-generated method stub
		int 	 val_type_sensor_id		= Integer.decode( (String) this.getW_dtm().getValueAt(param_line_number, 0) )	;
		String	 val_type_sensor_name		= (String) this.getW_dtm().getValueAt(param_line_number, 1)					;
		this.nameupdate_textField.setText(val_type_sensor_name)															;
		this.nameupdate_label.setVisible(true)																			;
		this.nameupdate_textField.setVisible(true)																		;
		this.getFupdate_button().setVisible(true)																		;
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}

}
