package org.secure.retirement.home.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;


public class FrameAnalysis extends JFrame {
	
	private JCheckBox sensor, room, historic;
	private JPanel pan1, pan2, pan3, pan4, pan5;
	private JLabel jl1;
	private JLayeredPane jlp, jlp2;
	private JComboBox sensorList, roomList, historicList;
	private JTable table;
	private TableAnalysis tablet;
	private String arrHeaders;
	
	public FrameAnalysis() {
		
		jl1= new JLabel();
		sensorList=new JComboBox();
		roomList= new JComboBox();
		historicList= new JComboBox();
		
		this.setLocationRelativeTo(null);
		this.setSize(1700, 1000);
		this.setResizable(false);
		
		sensor = new JCheckBox("Sensors");
		sensor.setForeground(Color.WHITE);
		sensor.setBackground(new Color(153,190,204));
		sensor.addItemListener(new ItemListen());
		
		
		room = new JCheckBox("Room");
		room.setForeground(Color.WHITE);
		room.setBackground(new Color(153,190,204));
		room.addItemListener(new ItemListen());
		
		historic = new JCheckBox("Historic");
		historic.setForeground(Color.WHITE);
		historic.setBackground(new Color(153,190,204));
		historic.addItemListener(new ItemListen());
		
		
		
		pan1= new JPanel();
		pan1.setBackground(new Color(153,190,204));
		
		pan2=new JPanel();
		pan2.setBackground(Color.LIGHT_GRAY);
		
		pan3= new JPanel();
		pan3.setBackground(new Color(153,190,204));
		
		pan4= new JPanel();
		pan4.setBackground(new Color(173,216,230));
		
		pan5=new JPanel();
		
		
		
		jlp= new JLayeredPane();
		jlp2= new JLayeredPane();
		
		jlp.add(pan1);
		jlp.add(pan3);
		jlp.add(jlp2);
		
		this.setLayout(new BorderLayout()); 
		this.getContentPane().add(jlp); 
		
		pan1.setBounds(0,0,1700, 100);
		pan1.add(sensor);
		pan1.add(room);
		pan1.add(historic);
		
		
		pan3.setBounds(0,100,150,1000);
		pan3.setLayout(new FlowLayout());
		pan3.add(sensorList);
		sensorList.setVisible(false);
		pan3.add(roomList);
		roomList.setVisible(false);
		pan3.add(historicList);
		historicList.setVisible(false);
		

		jlp2.setBounds(150,100,1550,1000);
		jlp2.setLayout(new GridLayout(2,1));
		jlp2.add(pan4);
		jlp2.add(pan2);
		
		table= new JTable();
		table.setVisible(true);
		
		pan4.setLayout(new BorderLayout());
		
		
		this.setVisible(true);
	}
	

	private class ItemListen implements ItemListener {

        public void itemStateChanged(ItemEvent arg0) {
        
        // Sensor CheckBox Actions
		if (sensor.isSelected()==true && sensorList.getItemCount()<1) {
			Object[] elementSensor = new Object[]{"Sensor 1", "Sensor 2", "Sensor 3", "Sensor 4", "Sensor 5"};
			for (int i=0; i<elementSensor.length; i++) {
				String sens=elementSensor[i].toString();
				sensorList.addItem(sens);
			}
			
			// TODO RETURN AN ERROR PROBABLY COMING FROM THREAD2
			sensorList.setVisible(true);
			arrHeaders=("headers");
			tablet.getHeaders().addColumn(arrHeaders);
			table= new JTable(tablet.getHeaders());
			
			pan4.add(table, BorderLayout.NORTH);
			
		}
		if (sensor.isSelected()==false) {
			sensorList.removeAllItems();
			sensorList.setVisible(false);
		}
		
		
		// Hictoric CheckBox Actions
		if(historic.isSelected()==true && historicList.getItemCount()<1) {	
			Object[] elementHistoric = new Object[]{"Historic 1", "Historic 2", "Historic 3", "Historic 4", "Historic 5"};
			for (int i=0; i<elementHistoric.length; i++) {
				String hist = elementHistoric[i].toString();
				historicList.addItem(hist);
			}
			historicList.setVisible(true);
        }
		if (historic.isSelected()==false) {
			historicList.removeAllItems();
			historicList.setVisible(false);
		}
		
		// Room CheckBox Actions
		if(room.isSelected()==true && roomList.getItemCount()<1) {
			Object[] elementRoom = new Object[]{"room 1", "room 2", "room 3", "room 4", "room 5"};
			for (int i=0; i<elementRoom.length; i++) {
				String room=elementRoom[i].toString();
				roomList.addItem(room);
				
			}
			roomList.setVisible(true);
		}
		if (room.isSelected()==false) {
			roomList.removeAllItems();
			roomList.setVisible(false);
		}
		
        }

	
	}
}
