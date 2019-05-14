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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import org.secure.retirement.home.client.ClientTransmission;
import org.secure.retirement.home.common.Analysis;
import org.secure.retirement.home.common.Historic;
import org.secure.retirement.home.common.Room;
import org.secure.retirement.home.common.Sensor;
import org.secure.retirement.home.common.Type_sensor;

public class FrameTableAnalysis extends Frame {

	private JCalendar cal, cal2, cal3, cal4;
	private JPanel panFilter, panComboFilter, panDateFilt, panDateFilt2, panDateFilt3, panCompare, panObjectComp,
			panObjectCompDate1, panObjectCompDate2, tablePanPrincip, tablePanComp, tablePan;
	private JButton validate1, validate2, compareButton;
	private JLabel label1, label2, label3, label4;
	// ComboBox
	private JComboBox list_typesensor = new JComboBox();
	private JComboBox list_room = new JComboBox();

	// CheckBox
	private JCheckBox date = new JCheckBox("Date");
	private JCheckBox room = new JCheckBox("Room");
	private JCheckBox type_sensor = new JCheckBox("Type Sensors");

	private ArrayList<Room> arrRoom = new ArrayList<Room>();
	private ArrayList<Type_sensor> typeSensor = new ArrayList<Type_sensor>();

	private String date1 = null, date2 = null, date3 = null, date4 = null;
	private String table = null;
	private String strRoom = null;
	private String strType = null;

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
		panComboFilter = new JPanel();
		panComboFilter.setBackground(new Color(153, 190, 204));
		panCompare = new JPanel();
		panCompare.setBackground(new Color(153, 190, 204));
		panObjectComp = new JPanel();
		panObjectComp.setBackground(new Color(153, 190, 204));

		left_panel.setLayout(new GridLayout(3, 1));
		left_panel.add(panFilter);
		left_panel.add(panCompare);
		left_panel.add(panObjectComp);

		panFilter.setLayout(new GridLayout(2, 1));
		panFilter.add(panComboFilter);
		panFilter.add(panDateFilt);

		panComboFilter.add(list_typesensor);
		list_typesensor.setEnabled(false);

		panComboFilter.add(list_room);
		list_room.setEnabled(false);

		panDateFilt.setLayout(new GridLayout(5, 1));
		panDateFilt.add(label1 = new JLabel("From"));
		panDateFilt.add(panDateFilt2 = new JPanel());
		cal = new JCalendar(panDateFilt2);
		panDateFilt.add(label2 = new JLabel("To"));
		panDateFilt.add(panDateFilt3 = new JPanel());
		cal2 = new JCalendar(panDateFilt3);
		panDateFilt.add(validate1 = new JButton("validate"));
		validate1.addActionListener(new ButtonListener());
		panDateFilt2.setVisible(false);
		panDateFilt3.setVisible(false);
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
		panObjectComp.setLayout(new GridLayout(5, 1));
		panObjectComp.add(label3 = new JLabel("From"));
		panObjectComp.add(panObjectCompDate1 = new JPanel());
		cal3 = new JCalendar(panObjectCompDate1);
		panObjectComp.add(label4 = new JLabel("To"));
		panObjectComp.add(panObjectCompDate2 = new JPanel());
		cal4 = new JCalendar(panObjectCompDate2);
		panObjectComp.add(validate2 = new JButton("Do comparaison"));
		validate2.addActionListener(new ButtonListener());
		panObjectComp.setVisible(false);

		// Adding the Left panel with all filters at the left of the screen

		component_panel.add(this.left_panel, BorderLayout.WEST);

		// Panel which will contain the tables
		tablePan = new JPanel();
		tablePan.setLayout(new GridLayout(2, 1));
		tablePan.setBackground(new Color(191, 195, 210));
		component_panel.add(tablePan, BorderLayout.CENTER);

		// The principal table of datas will be there
		tablePanPrincip = new JPanel();
		tablePanPrincip.setLayout(new BorderLayout());
		tablePanPrincip.setBackground(new Color(215, 240, 245));

		// If users want to compare datas by date it will be there
		tablePanComp = new JPanel();
		tablePanComp.setBackground(new Color(200, 210, 240));
		tablePanComp.setVisible(false);

		// Adding the two panel of data's to the frame
		tablePan.add(tablePanPrincip);
		tablePan.add(tablePanComp);

		// table
		this.getW_dtm().addColumn("sensor_mac");
		this.getW_dtm().addColumn("sensor_ip");
		this.getW_dtm().addColumn("type_sensor_name");
		this.getW_dtm().addColumn("room_name");
		this.getW_dtm().addColumn("historic_datetime");
		this.getW_dtm().addColumn("historic_value");
		this.call_initialise_table("Analysis", "SELECT ALL");

		w_table = new JTable(this.getW_dtm());
		tablePanPrincip.add(super.getW_table());

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	private class ItemListen implements ItemListener {

		public void itemStateChanged(ItemEvent arg0) {

			// Sensor CheckBox Actions
			if (type_sensor.isSelected() == true & list_typesensor.getItemCount() < 1) {
				list_typesensor.setEnabled(true);
				table = "Type_sensor";
				call_initialise_table(table, "SELECT ALL");
			}
			if (type_sensor.isSelected() == false) {
				list_typesensor.removeAllItems();
				list_typesensor.setEnabled(false);
			}

			if (date.isSelected() == true) {
				panDateFilt2.setVisible(true);
				panDateFilt3.setVisible(true);
				compareButton.setEnabled(true);
			}
			if (date.isSelected() == false) {
				panDateFilt2.setVisible(false);
				panDateFilt3.setVisible(false);
				compareButton.setEnabled(false);
			}

			if (room.isSelected() == true & list_room.getItemCount() < 1) {
				list_room.setEnabled(true);
				table = "Room";
				call_initialise_table(table, "SELECT ALL");
			}
			if (room.isSelected() == false) {
				list_room.removeAllItems();
				list_room.setEnabled(false);
			}
		}
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if ("validate".equals(e.getActionCommand())) {
				tablePanPrincip.setVisible(true);
				// we get the value selected in the jcombobox if its enable
				if (list_typesensor.isEnabled()) {
					strType = list_typesensor.getSelectedItem().toString();
				}
				if (list_room.isEnabled()) {
					strRoom = list_room.getSelectedItem().toString();
				}
				// We get the two date
				if (date.isSelected()) {
					String date1 = cal.getDate();
					String date2 = cal2.getDate();
				}

				if (strType.equals("All Type sensor")) {

				} else {
					table = "Analysis";
				}

			}

			if ("Do comparaison".equals(e.getActionCommand())) {
				tablePanComp.setVisible(true);
				String date3 = cal4.getDate();
				String date4 = cal3.getDate();
			}
		}

	}

	public void call_initialise_table(String table, String action) {
		try {
			ClientTransmission.transmission(table, action, null, this);
		} catch (Exception e) {
			e.printStackTrace();
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
	public void add_table(Object obj) {
		// TODO Auto-generated method stub
		if ((Analysis) obj != null) {
			this.getW_dtm()
					.addRow(new String[] { String.valueOf(((Analysis) obj).getSensor_mac()),
							((Analysis) obj).getSensor_ip(), ((Analysis) obj).getType_sensor_name(),
							((Analysis) obj).getRoom_name(), ((Analysis) obj).getHistoric_datetime(),
							((Analysis) obj).getHistoric_value().toString() });

		}
	}

	@Override
	public void update_table() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initialise_table(Object[] obj) {

		if (type_sensor.isSelected() == true & list_typesensor.getItemCount() < 1) {
			list_typesensor.removeAllItems();
			list_typesensor.addItem("All Type sensor");
			for (int i = 0; i < obj.length; i++) {
				typeSensor.add((Type_sensor) obj[i]);
				this.list_typesensor.addItem(typeSensor.get(i).getType_sensor_name());
			}

			if (room.isSelected() == true & list_room.getItemCount() < 1) {
				list_room.removeAllItems();
				list_room.addItem("All rooms");
				for (int i = 0; i < obj.length; i++) {
					arrRoom.add((Room) obj[i]);
					this.list_room.addItem(arrRoom.get(i).getRoom_name());
				}
			}

			if (room.isSelected() == false & type_sensor.isSelected() == false & date.isSelected() == false) {

				for (int i = 0; i < obj.length; i++) {
					this.add_table(obj[i]);
				}
			}
		}
	}
}
