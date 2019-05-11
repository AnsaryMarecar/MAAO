package org.secure.retirement.home.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.secure.retirement.home.common.Type_sensor;

public class FrameTableAnalysis extends Frame {

	private JCalendar cal, cal2, cal3, cal4;
	private JPanel panFilter,panComboFilter, panDateFilt,panDateFilt2,panDateFilt3, panCompare, panObjectComp, panObjectCompDate1, panObjectCompDate2, tablePanPrincip, tablePanComp,tablePan;
	private JButton validate1, validate2, compareButton;
	private JLabel label1, label2, label3, label4;	
	//ComboBox
	private JComboBox list_typesensor=new JComboBox();
	private JComboBox list_room=new JComboBox();
	
	//CheckBox
	private JCheckBox date = new JCheckBox("Date");
	private JCheckBox room = new JCheckBox("Room");
	private JCheckBox type_sensor = new JCheckBox("Type Sensors");
	

	public FrameTableAnalysis() {
		super();
		this.setTitle("Analyse");
		this.setSize(1700, 1000);
		this.setResizable(false);

		// Design
		date.setForeground(Color.WHITE);
		date.setBackground(new Color(153, 190, 204));

		room.setForeground(Color.WHITE);
		room.setBackground(new Color(153, 190, 204));

		type_sensor.setForeground(Color.WHITE);
		type_sensor.setBackground(new Color(153, 190, 204));

		menu_panel.setBackground(new Color(153, 190, 204));
		left_panel.setBackground(new Color(153, 190, 204));

		// Adding CheckBox to the top of the Frame
		menu_panel.add(date);
		menu_panel.add(room);
		menu_panel.add(type_sensor);

		// Item Listener for JCheckBox
		date.addItemListener(new ItemListen());
		room.addItemListener(new ItemListen());
		type_sensor.addItemListener(new ItemListen());

		// Adding ComboBox to the Left of the Frame
		panFilter = new JPanel();
		panFilter.setBackground(new Color(153, 190, 204));
		panDateFilt = new JPanel();
		panDateFilt.setBackground(new Color(153, 190, 204));
		panComboFilter =new JPanel();
		panComboFilter.setBackground(new Color(153,190,204));
		panCompare = new JPanel();
		panCompare.setBackground(new Color(153, 190, 204));
		panObjectComp = new JPanel();
		panObjectComp.setBackground(new Color(153, 190, 204));

		left_panel.setLayout(new GridLayout(3, 1));
		left_panel.add(panFilter);
		left_panel.add(panCompare);
		left_panel.add(panObjectComp);

		panFilter.setLayout(new GridLayout(2,1));
		panFilter.add(panComboFilter);
		panFilter.add(panDateFilt);
		
		panComboFilter.add(list_typesensor);
		list_typesensor.setEnabled(false);
		panComboFilter.add(list_room);
		list_room.setEnabled(false);
		
		panDateFilt.setLayout(new GridLayout(5,1));
		panDateFilt.add(label1=new JLabel("From"));
		panDateFilt.add(panDateFilt2= new JPanel());
		cal = new JCalendar(panDateFilt2);
		panDateFilt.add(label2=new JLabel("To"));
		panDateFilt.add(panDateFilt3= new JPanel());
		cal2=new JCalendar(panDateFilt3);
		panDateFilt.add(validate1 = new JButton("validate"));
		validate1.addActionListener(new ButtonListener());
		panDateFilt.setVisible(false);
		// Add button Compare to its pan
		compareButton = new JButton("Compare");
		compareButton.addActionListener(new ButtonListener() {
			public void actionPerformed(ActionEvent e) {
				panObjectComp.setVisible(true);
			}
		});
		panCompare.add(compareButton);
		compareButton.setEnabled(false);

		// Adding Component to panObjectComp which will appear after pushing button
		// compare
		panObjectComp.setLayout(new GridLayout(5,1));
		panObjectComp.add(label3=new JLabel("From"));
		panObjectComp.add(panObjectCompDate1=new JPanel());
		cal3 = new JCalendar(panObjectCompDate1);
		panObjectComp.add(label4=new JLabel("To"));
		panObjectComp.add(panObjectCompDate2=new JPanel());
		cal4=new JCalendar(panObjectCompDate2);
		panObjectComp.add(validate2 = new JButton("Do comparaison"));
		validate2.addActionListener(new ButtonListener());
		panObjectComp.setVisible(false);
		
		//Adding the Left panel with all filters at the left of the screen
		
		component_panel.add(this.left_panel, BorderLayout.WEST);

		
		//Panel which will contain the tables
		tablePan = new JPanel();
		tablePan.setLayout(new GridLayout(2, 1));
		tablePan.setBackground(new Color(191, 195, 210));
		component_panel.add(tablePan, BorderLayout.CENTER);

		//The principal table of datas will be there
		tablePanPrincip = new JPanel();
		tablePanPrincip.setBackground(new Color(215, 240, 245));
		tablePanPrincip.setVisible(false);

		//If users want to compare datas by date it will be there
		tablePanComp = new JPanel();
		tablePanComp.setBackground(new Color(200, 210, 240));
		tablePanComp.setVisible(false);
		
		//Adding the two panel of data's to the frame
		tablePan.add(tablePanPrincip);
		tablePan.add(tablePanComp);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	private class ItemListen implements ItemListener {

		public void itemStateChanged(ItemEvent arg0) {
        
			// Sensor CheckBox Actions
			if (type_sensor.isSelected()==true  & list_typesensor.getItemCount()<1) {
				list_typesensor.setEnabled(true);
				Object[] elementSensor = new Object[]{"Sensor 1", "Sensor 2", "Sensor 3", "Sensor 4", "Sensor 5"};
				for (int i=0; i<elementSensor.length; i++) {
					String sens=elementSensor[i].toString();
					list_typesensor.addItem(sens);
				}
			}
			if (type_sensor.isSelected()==false){
				list_typesensor.removeAllItems();
				list_typesensor.setEnabled(false);
				}
			if (date.isSelected()==true) {
				panDateFilt.setVisible(true);
				compareButton.setEnabled(true);
			}
			if (date.isSelected()==false) {
				panDateFilt.setVisible(false);
				compareButton.setEnabled(false);
			}
			if (room.isSelected()==true& list_room.getItemCount()<1) {
				list_room.setEnabled(true);
				
			}
			if (room.isSelected()==false) {
				list_room.removeAllItems();
				list_room.setEnabled(false);
			}
		}
	}
	
	class ButtonListener implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	if("validate".equals(e.getActionCommand())) {
				tablePanPrincip.setVisible(true);
				
				if(date.isSelected()==true) {
				String date1 = cal.getDate();
				String date2=cal2.getDate();
				}
				
	    	}
	    	
	    	
	    	
	    	if("Do comparaison".equals(e.getActionCommand())) {
	    		tablePanComp.setVisible(true);

				String date3 = cal4.getDate();
				String date4=cal3.getDate();
	    	}
	    	
	    	
	    	
		}
	}
		
		public static void main(String[] args) {
			FrameTableAnalysis frameHome = new FrameTableAnalysis();
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
