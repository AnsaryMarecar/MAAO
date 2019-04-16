package org.secure.retirement.home.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
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


public class FrameAnalysis extends JFrame {
	
	private JCheckBox sensor, room, historic;
	private JPanel pan1, pan2, pan3, pan4;
	private JLabel jl1;
	private JLayeredPane jlp, jlp2;
	private JComboBox sensorList, roomList, historicList;
	
	
	
	public FrameAnalysis() {
		
		jl1= new JLabel();
		sensorList=new JComboBox();
		roomList= new JComboBox();
		historicList= new JComboBox();
		
		this.setLocationRelativeTo(null);
		this.setSize(1000, 1000);
		this.setResizable(false);
		
		sensor = new JCheckBox("Sensors");
		sensor.setForeground(Color.WHITE);
		sensor.setBackground(Color.DARK_GRAY);
		sensor.addItemListener(new ItemListen());
		
		
		room = new JCheckBox("Room");
		room.setForeground(Color.WHITE);
		room.setBackground(Color.DARK_GRAY);
		room.addItemListener(new ItemListen());
		
		historic = new JCheckBox("Historic");
		historic.setForeground(Color.WHITE);
		historic.setBackground(Color.DARK_GRAY);
		historic.addItemListener(new ItemListen());
		
		
		
		pan1= new JPanel();
		pan1.setBackground(Color.DARK_GRAY);
		
		pan2=new JPanel();
		pan2.setBackground(Color.WHITE);
		
		pan3= new JPanel();
		pan3.setBackground(Color.DARK_GRAY);
		
		pan4= new JPanel();
		pan4.setBackground(Color.LIGHT_GRAY);
		
		
		
		jlp= new JLayeredPane();
		
		jlp.add(pan1);
		jlp.add(pan3);
		jlp.add(pan4);
		
		this.setLayout(new BorderLayout()); 
		this.getContentPane().add(jlp); 
		
		pan1.setBounds(0,0,1000, 200);
		pan1.add(sensor);
		pan1.add(room);
		pan1.add(historic);
		
		
		pan3.setBounds(0,200,300,800);
		pan3.setLayout(new FlowLayout());
		pan3.add(sensorList);
		sensorList.setVisible(false);
		pan3.add(historicList);
		historicList.setVisible(false);
		pan3.add(roomList);
		roomList.setVisible(false);
		

		pan4.setBounds(300,200,700,800);

		
		
		
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

			System.out.println("salut je vais bien ");
			sensorList.setVisible(true);
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
