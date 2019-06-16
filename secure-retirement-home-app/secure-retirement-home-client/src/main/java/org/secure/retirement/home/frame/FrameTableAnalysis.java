package org.secure.retirement.home.frame;

import java.awt.BorderLayout;
import java.awt.Button;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.secure.retirement.home.client.ClientTransmission;
import org.secure.retirement.home.common.Analysis;
import org.secure.retirement.home.common.Historic;
import org.secure.retirement.home.common.Room;
import org.secure.retirement.home.common.Sensor;
import org.secure.retirement.home.common.Type_sensor;

import com.toedter.calendar.JCalendar;

public class FrameTableAnalysis extends Frame {

	private JCalendar jcal, jcal2;

	private Calendar cal, cal2, cal3, cal4;
	private JPanel panFilter, panComboFilter, panDateFilt, panDateFilt2, panDateFilt3, tablePanPrincip, tablePan;

	private JPanel numbSensor, numbType_sensor, numbRoom, numbDate, numbAll;
	private JButton validate1, validate2;
	private JLabel label1, label2, label3, label4;

	// ComboBox
	private JComboBox list_typesensor = new JComboBox();

	// CheckBox
	private JCheckBox date = new JCheckBox("Date");
	private JCheckBox type_sensor = new JCheckBox("Type Sensors");
	private JCheckBox sensorSelect = new JCheckBox("count by sensor");

	private JLabel bJcal1, bJcal2;

	private ArrayList<Type_sensor> typeSensor = new ArrayList<Type_sensor>();
	private ArrayList<Analysis> arrAnalysis;

	private Date date1 = null, date2 = null;

	private String table = null;
	private String strType = null;
	private String sDate1 = null;
	private String sDate2 = null;

	// Int that permits to know what to activate or not

	// For the First JTable
	private static int countAll = 0;

	// For the second JTable
	private static int countSensorA = 0;
	private static int countSensorB = 0;

	// For the third JTable
	private static int validateCount = 0;

	// For the fourth JTable
	private static int dateCount = 0;

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

	private JTable w_table5 = new JTable();
	private DefaultTableModel w_dtm5 = new DefaultTableModel() {
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


		type_sensor.setForeground(Color.WHITE);
		type_sensor.setBackground(new Color(153, 190, 204));

		sensorSelect.setForeground(Color.WHITE);
		sensorSelect.setBackground(new Color(153, 190, 204));

		menu_panel.setBackground(new Color(153, 190, 204));
		left_panel.setBackground(new Color(0, 190, 204));

		// Adding CheckBox to the top of the Frame
		menu_panel.add(date);
		menu_panel.add(type_sensor);
		menu_panel.add(sensorSelect);

		// Item Listener for JCheckBox
		date.addItemListener(new ItemListen());
		type_sensor.addItemListener(new ItemListen());
		sensorSelect.addItemListener(new ItemListen());
		// Adding ComboBox to the Left of the Frame
		panFilter = new JPanel();
		panFilter.setBackground(new Color(153, 190, 204));
		panDateFilt = new JPanel();
		panDateFilt.setBackground(new Color(153, 190, 204));
		panComboFilter = new JPanel();
		panComboFilter.setBackground(new Color(153, 190, 204));

		left_panel.setLayout(new BorderLayout());
		left_panel.add(panFilter);

		panFilter.setLayout(new BorderLayout());
		panFilter.add(panComboFilter, BorderLayout.NORTH);
		panFilter.add(panDateFilt, BorderLayout.CENTER);

		panComboFilter.add(list_typesensor);
		panComboFilter.add(validate2=new JButton("Go"));
		list_typesensor.setEnabled(false);
		validate2.addActionListener(new ButtonListener());

		panDateFilt.setLayout(new GridLayout(3, 1));
		panDateFilt.add(panDateFilt2 = new JPanel());
		panDateFilt.add(panDateFilt3 = new JPanel());

		panDateFilt2.setLayout(new GridLayout(2, 1));
		panDateFilt2.setBackground(new Color(153, 190, 204));
		panDateFilt2.add(bJcal1 = new JLabel("FROM"));
		jcal = new JCalendar();
		panDateFilt2.add(jcal);

		panDateFilt3.setLayout(new GridLayout(2, 1));
		panDateFilt3.setBackground(new Color(153, 190, 204));
		panDateFilt3.add(bJcal2 = new JLabel("TO"));
		jcal2 = new JCalendar();
		panDateFilt3.add(jcal2);

		panDateFilt2.setVisible(false);
		panDateFilt3.setVisible(false);

		JPanel valPan = new JPanel();
		JPanel valpan2 = new JPanel();
		valPan.setLayout(new GridLayout(2, 1));
		valPan.setBackground(new Color(153, 190, 204));
		valPan.add(valpan2);
		valpan2.setLayout(new BorderLayout());
		valpan2.setBackground(new Color(153, 190, 204));
		valpan2.add(validate1 = new JButton("validate"), BorderLayout.NORTH);
		validate1.addActionListener(new ButtonListener());

		panDateFilt.add(valPan);

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


		// Adding the two panel of data's to the frame
		tablePan.add(tablePanPrincip);

		tablePanPrincip.setLayout(new GridLayout(4, 1, 20, 20));

		tablePanPrincip.add(numbAll = new JPanel());
		numbAll.setLayout(new BorderLayout());
		call_initialise_table("Analysis", "SELECT COUNT *");
		w_dtm2.addColumn("Total Number out of interval");
		w_dtm2.addColumn("Number");
		w_table2 = new JTable(w_dtm2);
		JScrollPane sc1=new JScrollPane(w_table2);
		numbAll.add(sc1, BorderLayout.NORTH);

		tablePanPrincip.add(numbType_sensor = new JPanel());
		numbType_sensor.setLayout(new BorderLayout());
		w_dtm1.addColumn("sensor_mac");
		w_dtm1.addColumn("Number out of interval");
		w_table1 = new JTable(w_dtm1);
		JScrollPane sc=new JScrollPane(w_table1);
		numbType_sensor.add(sc);
		
		tablePanPrincip.add(numbSensor = new JPanel());
		numbSensor.setLayout(new BorderLayout());
		w_dtm3.addColumn("Type sensor name");
		w_dtm3.addColumn("Values Type sensor");
		w_table3 = new JTable(w_dtm3);
		JScrollPane sc3= new JScrollPane(w_table3);
		numbSensor.add(sc3);


		tablePanPrincip.add(numbDate = new JPanel());
		numbDate.setLayout(new BorderLayout());
		w_dtm5.addColumn("FROM");
		w_dtm5.addColumn("TO");
		w_dtm5.addColumn("Value");
		w_table5 = new JTable(w_dtm5);
		JScrollPane sc4= new JScrollPane(w_table5);
		numbDate.add(sc4);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	private class ItemListen implements ItemListener {

		public void itemStateChanged(ItemEvent arg0) {

			// Sensor CheckBox Actions
			if (type_sensor.isSelected() == true & list_typesensor.getItemCount() < 1) {
				countSensorA = 0;
				validateCount=0;
				dateCount=0;
				list_typesensor.setEnabled(true);
				table = "Type_sensor";
				call_initialise_table(table, "SELECT ALL");
			}
			if (type_sensor.isSelected() == false) {
				list_typesensor.removeAllItems();
				list_typesensor.setEnabled(false);
				validateCount=0;
			}
			if (sensorSelect.isSelected() == true & countSensorB == 0) {
				countSensorA = 1;
				countSensorB = 1;
				call_initialise_table("Analysis", "SELECT COUNT");
			}
			if (sensorSelect.isSelected() == false) {
				countSensorA = 0;
				countSensorB = 0;
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

			}

			
		}
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if ("Go".equals(e.getActionCommand())) {
				dateCount=0;
				int n = w_dtm3.getRowCount();
				for (int i = n - 1; i >= 0; --i) {
					w_dtm3.removeRow(i);
				}
				// we get the value selected in the jcombobox if its enable
				if (list_typesensor.isEnabled()) {
					strType = list_typesensor.getSelectedItem().toString();
					validateCount = 1;
					call_initialise_table("Analysis", "SELECT COUNT TYPE");
					
				}
			}
			
			else if ("validate".equals(e.getActionCommand())) {
				validateCount=0;
				// We get the two date
				if (date.isSelected()) {

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");

					Date date1 = jcal.getDate();
					sDate1 = sdf.format(date1);
					Analysis anal1 = new Analysis(null, null, null, null, sDate1, null, null, null, null, null, null);

					Date date2 = jcal2.getDate();
					sDate2 = sdf.format(date2);
					Analysis anal2 = new Analysis(null, null, null, null, sDate2, null, null, null, null, null, null);

					arrAnalysis = new ArrayList<Analysis>();
					arrAnalysis.add(anal1);
					arrAnalysis.add(anal2);

					if (date2.before(date1)) {
						JOptionPane pan1 = new JOptionPane();
						pan1.showMessageDialog(null, "Please choose a good date interval", "error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						call_initialiseDate("Analysis", "SELECT DATE", arrAnalysis);
						dateCount = 1;
					}
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

	public void call_initialiseDate(String table, String action, ArrayList<Analysis> arrAnalysis) {
		try {
			ClientTransmission.transmission(table, action, arrAnalysis, this);
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

			// First JTable
			if (countAll < 1) {
				w_dtm2.addRow(new String[] { ("Total values out of interval"),
						String.valueOf(((Analysis) obj).getCountAll()) });

			}

			// Third JTable (contain values ordered by type_sensor)
			if (validateCount == 1) {
				if (!((Analysis) obj).getCountType().equals(null)) {
					if (strType.equals("All Type sensor")) {
						w_dtm3.addRow(new String[] { String.valueOf(((Analysis) obj).getType_sensor_name()),
								((Analysis) obj).getCountType() });
					} else {
						if (strType.equals(((Analysis) obj).getType_sensor_name())) {
							w_dtm3.addRow(new String[] { String.valueOf(((Analysis) obj).getType_sensor_name()),
									((Analysis) obj).getCountType() });
						}
					}
				}
			}
			
			if (dateCount == 1) {
				w_dtm5.addRow(new String[] { sDate1, sDate2, ((Analysis) obj).getCountDate() });
			}


			// Second JTable (contain value ordered by sensors
			if (countSensorA == 1 & countSensorB==1) {
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
			// To instantiate the first JTable that contains the total numbers of value out
			// of interval
			if (countAll == 0) {
				for (int i = 0; i < obj.length; i++) {
					this.add_table(obj[i]);
					countAll = 1;
				}
			}

			// To instantiante the second JTable which will contain the number of value out
			// of interval group by sensors
			if (countSensorA == 1) {

				for (int i = 0; i < obj.length; i++) {
					this.add_table(obj[i]);
				}
				countSensorA=0;
				countSensorB=1;
			}

			if (validateCount == 1) {

				for (int i = 0; i < obj.length; i++) {
					this.add_table(obj[i]);
					if (i == obj.length - 1) {
						validateCount = 0;
					}
				}
				validateCount = 0;
			}
			
			
			if (dateCount == 1) {

				for (int i = 0; i < obj.length; i++) {
					this.add_table(obj[i]);
				}
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

	}

	@Override
	public void initialise(String param_json, String param_class) throws IOException {
		// TODO Auto-generated method stub

	}
}
