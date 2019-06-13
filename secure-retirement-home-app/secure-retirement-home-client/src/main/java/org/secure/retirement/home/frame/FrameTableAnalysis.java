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
import java.io.IOException;
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
import javax.swing.table.DefaultTableModel;

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

	private JPanel numbSensor, numbType_sensor, numbDate, numbAll;
	private JButton validate1, validate2, compareButton;
	private JLabel label1, label2, label3, label4;

	private JLabel lbNumbSensor, lbNumbSensor2, lbNumbAll, lbNumbAll2, lbNumbType_sensor, lbNumbType_sensor2,
			lbNumbDate, lbNumbDate2;
	// ComboBox
	private JComboBox list_typesensor = new JComboBox();
	private JComboBox list_room = new JComboBox();

	// CheckBox
	private JCheckBox date = new JCheckBox("Date");
	private JCheckBox room = new JCheckBox("Room");
	private JCheckBox type_sensor = new JCheckBox("Type Sensors");
	private JCheckBox sensorSelect = new JCheckBox("count by sensor");

	private ArrayList<Room> arrRoom = new ArrayList<Room>();
	private ArrayList<Type_sensor> typeSensor = new ArrayList<Type_sensor>();

	private String date1 = null, date2 = null, date3 = null, date4 = null;
	private String table = null;
	private String strRoom = null;
	private String strType = null;

	// Int that permits to know what to activate or not
	private static int countAll = 0;
	private static int countSensorA = 0;
	private static int countSensorB = 0;
	private static int validateCount = 0;

	private JTable w_table1 = new JTable();
	private DefaultTableModel w_dtm1 = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			// all cells false
			return false;
		}
	};

	private JTable w_table2 = new JTable();
	private DefaultTableModel w_dtm2 = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			// all cells false
			return false;
		}
	};

	private JTable w_table3 = new JTable();
	private DefaultTableModel w_dtm3 = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			// all cells false
			return false;
		}
	};

	private JTable w_table4 = new JTable();
	private DefaultTableModel w_dtm4 = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			// all cells false
			return false;
		}
	};

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

		sensorSelect.setForeground(Color.WHITE);
		sensorSelect.setBackground(new Color(153, 190, 204));

		menu_panel.setBackground(new Color(153, 190, 204));
		left_panel.setBackground(new Color(153, 190, 204));

		// Adding CheckBox to the top of the Frame
		menu_panel.add(date);
		menu_panel.add(room);
		menu_panel.add(type_sensor);
		menu_panel.add(sensorSelect);

		// Item Listener for JCheckBox
		date.addItemListener(new ItemListen());
		room.addItemListener(new ItemListen());
		type_sensor.addItemListener(new ItemListen());
		sensorSelect.addItemListener(new ItemListen());
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
		tablePan.setBackground(new Color(191, 195, 210));
		tablePan.setLayout(new BorderLayout());
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

		tablePanPrincip.setLayout(new GridLayout(4, 1, 20, 20));

		tablePanPrincip.add(numbAll = new JPanel());
		numbAll.setLayout(new BorderLayout());
		call_initialise_table("Analysis", "SELECT COUNT *");
		w_dtm2.addColumn("Total Number out of interval");
		w_dtm2.addColumn("Number");
		w_table2 = new JTable(w_dtm2);
		numbAll.add(w_table2, BorderLayout.NORTH);
		numbAll.add(numbType_sensor = new JPanel(), BorderLayout.CENTER);

		// tablePanPrincip.add(numbType_sensor = new JPanel());
		numbType_sensor.setLayout(new GridLayout(2, 1));
		numbType_sensor.add(lbNumbType_sensor = new JLabel("Sensors not in their interval"));
		numbType_sensor.add(lbNumbType_sensor2 = new JLabel());
		w_dtm1.addColumn("sensor_mac");
		w_dtm1.addColumn("Number out of interval");
		w_table1 = new JTable(w_dtm1);
		numbType_sensor.add(w_table1);

		tablePanPrincip.add(numbSensor = new JPanel());
		numbSensor.setLayout(new GridLayout(2, 1));
		numbSensor.add(lbNumbSensor = new JLabel("Number of values out of interval order by type_sensor"));
		w_dtm3.addColumn("Type sensor name");
		w_dtm3.addColumn("Values Type sensor");
		w_table3 = new JTable(w_dtm3);
		numbSensor.add(w_table3);

		tablePanPrincip.add(numbDate = new JPanel());
		numbDate.add(lbNumbDate = new JLabel());
		numbDate.add(lbNumbDate2 = new JLabel());

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	private class ItemListen implements ItemListener {

		public void itemStateChanged(ItemEvent arg0) {

			// Sensor CheckBox Actions
			if (type_sensor.isSelected() == true & list_typesensor.getItemCount() < 1) {
				countSensorA = 0;
				list_typesensor.setEnabled(true);
				table = "Type_sensor";
				call_initialise_table(table, "SELECT ALL");
			}
			if (type_sensor.isSelected() == false) {
				list_typesensor.removeAllItems();
				list_typesensor.setEnabled(false);
			}
			if (sensorSelect.isSelected() == true & countSensorA==0) {
				countSensorA = 1;
				call_initialise_table("Analysis", "SELECT COUNT");
			}
			if (sensorSelect.isSelected() == false) {
				countSensorA=0;
				int n = w_dtm1.getRowCount();
				for (int i = n - 1; i >= 0; --i) {
					w_dtm1.removeRow(i);
				}

			}

			if (date.isSelected() == true) {
				panDateFilt2.setVisible(true);
				panDateFilt3.setVisible(true);
			}
			if (date.isSelected() == false) {
				panDateFilt2.setVisible(false);
				panDateFilt3.setVisible(false);
				compareButton.setEnabled(true);
			}

			if (room.isSelected() == true & list_room.getItemCount() < 1) {
				countSensorA = 0;
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
					validateCount = 1;
					call_initialise_table("Analysis", "SELECT COUNT TYPE");
				}
				if (list_room.isEnabled()) {
					strRoom = list_room.getSelectedItem().toString();
				}
				// We get the two date
				if (date.isSelected()) {
					String date1 = cal.getDate();
					String date2 = cal2.getDate();
				}

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
		System.out.println("FrameTableAnalysis> add_table");
		if ((Analysis) obj != null) {

			System.out.println("FrameTableAnalysis> add_table>Analysis Object is not null");

			System.out.println("FrameTableAnalysis> add_table> countAll =" + countAll);
			System.out.println("FrameTableAnalysis> add_table> countSensorA =" + countSensorA);
			System.out.println("FrameTableAnalysis> add_table> countSensorB =" + countSensorB);
			
			//First JTable
			if (countAll<1) {
				System.out.println("FrameTableAnalysis> add_table> count C =1");
				w_dtm2.addRow(new String[] { ("Total values out of interval"),
						String.valueOf(((Analysis) obj).getCountAll()) });

			}

			
			//Third JTable (contain values ordered by type_sensor)
			if (validateCount == 1) {
				w_dtm3.addRow(new String[] { String.valueOf(((Analysis) obj).getType_sensor_name()),
						((Analysis) obj).getCountType() });
			}
			
			
			//Second JTable (contain value ordered by sensors
			if (countSensorA==1) {
				w_dtm1.addRow(new String[] { String.valueOf(((Analysis) obj).getSensor_mac()),
						((Analysis) obj).getCountAnal() });
			}
			
			

		}
	}

	@Override
	public void update_table() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initialise_table(Object[] obj) {

		System.out.println("FrameTableAnalysis> initialise_table");

		// To instantiate the first JTable that contains the total numbers of value out
		// of interval
		if (countAll == 0) {
			System.out.println("U are in CountAll condition on initialise_table");
			for (int i = 0; i < obj.length; i++) {
				System.out.println("FrameTableAnalysis> initialise_table>countAll =" + countAll);
				this.add_table(obj[i]);
				countAll = 1;
			}
		}

		// To instantiante the second JTable which will contain the number of value out
		// of interval group by sensors
		if (countSensorA == 1) {

			for (int i = 0; i < obj.length; i++) {
				System.out.println("FrameTableAnalysis> initialise_table>countSensorA =" + countSensorA + "countSensorB"
						+ countSensorB);
				this.add_table(obj[i]);
			}
		}

		System.out.println("validateCount =" + validateCount);
		if (validateCount == 1) {

			for (int i = 0; i < obj.length; i++) {
				System.out.println("validateCountt =" + validateCount);
				this.add_table(obj[i]);
				if (i == obj.length - 1) {
					validateCount = 0;
				}
			}
			System.out.println("validateCount =" + validateCount);
		}

		// Instantiate the checkBox with database's data
		if (type_sensor.isSelected() == true & list_typesensor.getItemCount() < 1) {
			list_typesensor.removeAllItems();
			list_typesensor.addItem("All Type sensor");
			for (int i = 0; i < obj.length; i++) {
				typeSensor.add((Type_sensor) obj[i]);
				this.list_typesensor.addItem(typeSensor.get(i).getType_sensor_name());
			}
		}

		if (room.isSelected() == true & list_room.getItemCount() < 1) {
			list_room.removeAllItems();
			list_room.addItem("All rooms");
			for (int i = 0; i < obj.length; i++) {
				arrRoom.add((Room) obj[i]);

				// TODO VERIFICATION TO NOT INSERT INEXISTANT ROOM
				if (!arrRoom.get(i).getRoom_name().equals(null) || !arrRoom.get(i).getRoom_name().equals("")) {
					System.out.println(arrRoom.get(i));
					this.list_room.addItem(arrRoom.get(i).getRoom_name());
				}
			}
		}

	}

	@Override
	public void initialise(String param_json, String param_class) throws IOException {
		// TODO Auto-generated method stub

	}
}
