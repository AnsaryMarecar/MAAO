package org.secure.retirement.home.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import org.secure.retirement.home.common.Type_sensor;

public class FrameTableAnalysis extends Frame{
	
	
	
	
	
	public FrameTableAnalysis() {
		super();
		this.setTitle("Analyse");
		this.setSize(1700,1000);
		this.setResizable(false);
		
		//Design
		sensor.setForeground(Color.WHITE);
		sensor.setBackground(new Color(153,190,204));
		
		date.setForeground(Color.WHITE);
		date.setBackground(new Color(153,190,204));
		
		zone.setForeground(Color.WHITE);
		zone.setBackground(new Color(153,190,204));
		
		type_sensor.setForeground(Color.WHITE);
		type_sensor.setBackground(new Color(153,190,204));
		
		menu_panel.setBackground(new Color(153,190,204));
		left_panel.setBackground(new Color(153,190,204));

		
		
		
		//Adding CheckBox to the top of the Frame
		menu_panel.add(sensor);
		menu_panel.add(date);
		menu_panel.add(zone);
		menu_panel.add(type_sensor);
		
		//Adding ComboBox to the Left of the Frame
	    left_panel.setLayout(new FlowLayout());
		left_panel.add(list_typesensor);
		left_panel.add(list_zone);
		component_panel.add(this.left_panel, BorderLayout.WEST);

		
		
		
		
		this.setVisible(true);
		
	}
	
	public void add_table(Type_sensor param_type_sensor) {
		this.getW_dtm().addRow(
				new String[]{
					String.valueOf(param_type_sensor.getType_sensor_id())
				,	param_type_sensor.getType_sensor_name()
				}); 
	}
	
	public static void main (String[] args) {
		FrameTableAnalysis frameHome = new FrameTableAnalysis();
		System.out.println("FRAMEHome was launched");
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
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
	public void initialise_table(Object[] obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add_table(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update_table() {
		// TODO Auto-generated method stub
		
	}

}
