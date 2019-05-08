package org.secure.retirement.home.frame;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import org.secure.retirement.home.client.ClientTransmission;
import org.secure.retirement.home.common.Room;

/**

 *
 */

public class FrameRoom extends Frame<Room> {
	
	// forms atribut add name
	private JTextField 	nameadd_textField 			= new JTextField()							;
	private JLabel 		nameadd_label				= new JLabel("Add a name of Room : ")		;
	
	// forms atribut update name
	private JTextField 	nameupdate_textField 		= new JTextField()							;
	private JLabel 		nameupdate_label			= new JLabel("Update the name of Room: ")	;
	
	
	private JTextField 	x_minadd_textField 		= new JTextField()							;
	private JLabel 		x_minadd_label			= new JLabel("add x_min: ")	;
	
	private JTextField 	x_maxadd_textField 		= new JTextField()							;
	private JLabel 		x_maxadd_label			= new JLabel("add x_max: ")	;
	
	private JTextField 	y_minadd_textField 		= new JTextField()							;
	private JLabel 		y_minadd_label			= new JLabel("add y_min: ")	;
	
	private JTextField 	y_maxadd_textField 		= new JTextField()							;
	private JLabel 		y_maxadd_label			= new JLabel("add y_max: ")	;
	
	
	
	
	
	
	private JOptionPane joptionpane_information;
	
	public FrameRoom() {
		
		// general use
		super()															;
		this.setTitle( "MAAO - Room " )			;
		this.setTitle_label( "Room" )	;   
		this.setSize(1200,600);
		Font police = new Font( "Arial" , Font.BOLD , 14 )				;
		
		// form add
		nameadd_textField.setFont(police)								;
		nameadd_textField.setPreferredSize(new Dimension(150, 30))		;
		nameadd_textField.setForeground(Color.BLUE)						;
		super.addform_panel.add(nameadd_label)							;
		super.addform_panel.add(nameadd_textField)      				;
		
		x_minadd_textField .setFont(police)								;
		x_minadd_textField .setPreferredSize(new Dimension(100,30))	;
		x_minadd_textField .setForeground(Color.BLUE)						;
		super.addform_panel.add(x_minadd_label)							;
		super.addform_panel.add(x_minadd_textField );
		
		x_maxadd_textField.setFont(police)								;
		x_maxadd_textField.setPreferredSize(new Dimension(100, 30))		;
		x_maxadd_textField.setForeground(Color.BLUE)						;
		super.addform_panel.add(x_maxadd_label)							;
		super.addform_panel.add(x_maxadd_textField);
		
		y_minadd_textField.setFont(police)								;
		y_minadd_textField.setPreferredSize(new Dimension(100, 30))		;
		y_minadd_textField.setForeground(Color.BLUE)						;
		super.addform_panel.add(y_minadd_label)							;
		super.addform_panel.add(y_minadd_textField);
		
		y_maxadd_textField.setFont(police)								;
		y_maxadd_textField.setPreferredSize(new Dimension(100, 30))		;
		y_maxadd_textField.setForeground(Color.BLUE)						;
		super.addform_panel.add(y_maxadd_label)							;
		super.addform_panel.add(y_maxadd_textField);
		
		
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
		this.getW_dtm().addColumn( "Nom"	)							;
		this.getW_dtm().addColumn( "X_MIN"	)							;
		this.getW_dtm().addColumn( "X_MAX"	)							;
		this.getW_dtm().addColumn( "Y_MIN"	)							;
		this.getW_dtm().addColumn( "Y_MAX"	)							;
		
		
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
	

	public void add_table(Room param_room) {

				this.getW_dtm().addRow(
						new Object[]{
							param_room.getRoom_id()
						,	param_room.getRoom_name(),
						param_room.getX_min(),
						param_room.getX_max(),
						param_room.getY_min(),
						param_room.getY_max(),
						
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
	public void initialise_table(Room[]  param_room) {
		for(int i = 0 ; i<param_room.length; i++) {
			this.add_table(param_room[i])						;
		}
	}
	public void call_initialise_table() {
		this.getW_dtm().setRowCount(0)									;
		try {
			ClientTransmission.transmission("Room", "SELECT ALL", null, this);	
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
		int 	 var_room_id		= Integer.decode( (String) this.getW_dtm().getValueAt(var_line_number, 0) );
		String	 var_room_name	= (String) this.nameupdate_textField.getText().trim();
		int 	 var_room_xmin		= Integer.decode( (String) this.getW_dtm().getValueAt(var_line_number, 0) );
		int 	 var_room_xmax		= Integer.decode( (String) this.getW_dtm().getValueAt(var_line_number, 0) );
		int 	 var_room_ymin		= Integer.decode( (String) this.getW_dtm().getValueAt(var_line_number, 0) );
		int 	 var_room_ymax		= Integer.decode( (String) this.getW_dtm().getValueAt(var_line_number, 0) );

		Room	 var_room						;		
		if(var_line_number>=0) {
			try {
				if(!var_room_name.trim().equals("")) {
					var_room= new Room(var_room_id,var_room_name,var_room_xmin,var_room_xmax,var_room_ymin,var_room_ymax)	;
					ArrayList<Room> val_romms = new ArrayList<Room>();
					val_romms.add(var_room)	;
					ClientTransmission.transmission("Room", "UPDATE",val_romms , this);	
					
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
		int 	var_line_number 	= this.getW_table().getSelectedRow();
		int 	var_id				= -1								;
		int 	var_xmin				= 0								;
		int 	var_xmax				= 0								;
		int 	var_ymin				= 0						;
		int 	var_ymax				= 0								;
		
		String 	var_name 			= null								;
		if(var_line_number>=0) {
			try {
				
				var_id 		= Integer.decode( (String) this.getW_dtm().getValueAt(var_line_number, 0) );
				var_name 	= (String) this.getW_dtm().getValueAt(var_line_number, 1)	;
				Room var_room = new Room(var_id,var_name, var_xmin , var_xmax, var_ymin, var_ymax)			;
				ArrayList<Room> var_rooms = new ArrayList<Room>()	;
				var_rooms.add(var_room)									;
				ClientTransmission.transmission("Room", "DELETE",var_rooms , this);	
				this.update_table()							;
				this.call_initialise_table()				;
				to_return = true							;
			} catch (Exception e) {
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
		boolean to_return = false								;
		String 	val_text  = nameadd_textField.getText().trim()	;

		String	var_xmin				=x_minadd_textField.getText().trim();  
		int v_xmin = Integer.parseInt(var_xmin);
		
		String	var_xmax				=x_maxadd_textField.getText().trim(); 
		int v_xmax = Integer.parseInt(var_xmax);
		String	var_ymin				=y_minadd_textField.getText().trim();  
		int v_ymin = Integer.parseInt(var_ymin);
		String	var_ymax				=y_maxadd_textField.getText().trim();  
		int v_ymax = Integer.parseInt(var_ymax);
									;
		if(val_text.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Sorry, but you can't add without a name.", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
		}
		else {
			ArrayList<Room> val_rooms = new ArrayList<Room>();
			val_rooms.add(new Room(0,val_text,v_xmin,v_xmax,v_ymin ,v_ymax ));
			try {
				ClientTransmission.transmission("Room", "ADD", val_rooms, this);	
				//this.call_initialise_table()				;
					this.update_table()						;
					to_return = true						;
			} catch (Exception e) {
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
		String	 val_room_name		= (String) this.getW_dtm().getValueAt(param_line_number, 1)					;
		this.nameupdate_textField.setText(val_room_name)															;
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
		FrameRoom framerome = new FrameRoom();
		System.out.println("FRAMEHome was launched");
	}
}