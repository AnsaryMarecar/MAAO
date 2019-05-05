package org.secure.retirement.home.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.secure.retirement.home.common.Type_sensor;

public class FrameTableAnalysis extends Frame {

	private JCalendar cal, cal2;
	private JPanel panFilter, panCompare, panObjectComp, tablePanPrincip, tablePanComp;
	private JButton validate1, validate2, compareButton;
	private JPanel tablePan;

	public FrameTableAnalysis() {
		super();
		this.setTitle("Analyse");
		this.setSize(1700, 1000);
		this.setResizable(false);

		// Design
		date.setForeground(Color.WHITE);
		date.setBackground(new Color(153, 190, 204));

		zone.setForeground(Color.WHITE);
		zone.setBackground(new Color(153, 190, 204));

		type_sensor.setForeground(Color.WHITE);
		type_sensor.setBackground(new Color(153, 190, 204));

		menu_panel.setBackground(new Color(153, 190, 204));
		left_panel.setBackground(new Color(153, 190, 204));

		// Adding CheckBox to the top of the Frame
		menu_panel.add(date);
		menu_panel.add(zone);
		menu_panel.add(type_sensor);

		// Item Listener for JCheckBox
		date.addItemListener(new ItemListen());
		zone.addItemListener(new ItemListen());
		type_sensor.addItemListener(new ItemListen());

		// Adding ComboBox to the Left of the Frame
		panFilter = new JPanel();
		panFilter.setBackground(new Color(153, 190, 204));
		panCompare = new JPanel();
		panCompare.setBackground(new Color(153, 190, 204));
		panObjectComp = new JPanel();
		panObjectComp.setBackground(new Color(153, 190, 204));

		left_panel.setLayout(new GridLayout(3, 1));
		left_panel.add(panFilter);
		left_panel.add(panCompare);
		left_panel.add(panObjectComp);

		panFilter.add(list_typesensor, BorderLayout.PAGE_START);
		panFilter.add(list_zone, BorderLayout.AFTER_LINE_ENDS);
		cal = new JCalendar(panFilter);
		panFilter.add(validate1 = new JButton("validate"), BorderLayout.SOUTH);
		validate1.addActionListener(new ButtonListener() {
			public void actionPerformed(ActionEvent e) {
				tablePanPrincip.setVisible(true);
			}
		});

		// Add button Compare to its pan
		compareButton = new JButton("Compare");
		compareButton.addActionListener(new ButtonListener() {
			public void actionPerformed(ActionEvent e) {
				panObjectComp.setVisible(true);
			}
		});
		panCompare.add(compareButton);

		// Adding Component to panObjectComp which will appear after pushing button
		// compare
		cal2 = new JCalendar(panObjectComp);
		panObjectComp.add(validate2 = new JButton("Do comparaison"));
		validate2.addActionListener(new ButtonListener() {
			public void actionPerformed(ActionEvent e) {
				tablePanComp.setVisible(true);
			}
		});
		panObjectComp.setVisible(false);

		component_panel.add(this.left_panel, BorderLayout.WEST);

		tablePan = new JPanel();
		tablePan.setLayout(new GridLayout(2, 1));
		tablePan.setBackground(new Color(191, 195, 210));
		component_panel.add(tablePan, BorderLayout.CENTER);

		tablePanPrincip = new JPanel();
		tablePanPrincip.setBackground(new Color(215, 240, 245));
		tablePanPrincip.setVisible(false);

		tablePanComp = new JPanel();
		tablePanComp.setBackground(new Color(200, 210, 240));
		tablePanComp.setVisible(false);

		tablePan.add(tablePanPrincip);

		tablePan.add(tablePanComp);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	private class ItemListen implements ItemListener {

		public void itemStateChanged(ItemEvent arg0) {
        
			// Sensor CheckBox Actions
			if (type_sensor.isSelected()==true) {
				type_sensor.removeAll();
				Object[] elementSensor = new Object[]{"Sensor 1", "Sensor 2", "Sensor 3", "Sensor 4", "Sensor 5"};
				for (int i=0; i<elementSensor.length; i++) {
					String sens=elementSensor[i].toString();
					list_typesensor.addItem(sens);
				}
			}else {list_typesensor.setEnabled(false);}
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
