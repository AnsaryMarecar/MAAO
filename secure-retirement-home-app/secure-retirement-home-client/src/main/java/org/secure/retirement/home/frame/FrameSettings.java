package org.secure.retirement.home.frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.MenuListener;

public class FrameSettings extends JFrame {

	JPanel settings_panel = new JPanel();
	JFrame settings_sensor = new JFrame();
	JLabel location = new JLabel("Location :");
	JLabel sensor_type = new JLabel("Sensor's type : ");
	JLabel min_risq = new JLabel("Min risq :");
	JLabel max_risq = new JLabel("Max risq :");
	JLabel mac_address = new JLabel("MAC Address :");
	JLabel IP_address = new JLabel("IP Address: ");
	
	JComboBox sensor_type_box = new JComboBox();
	JTextField location_t = new JTextField();
	JTextField min_risq_t = new JTextField();
	JTextField max_risq_t = new JTextField();
	JTextField mac_address_t = new JTextField();
	JTextField IP_address_t = new JTextField();
	
	public FrameSettings() {
		
		this.setLocationRelativeTo(null);
		this.setSize(500, 600);
		this.setResizable(false);
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		GridBagConstraints c2 = new GridBagConstraints();
		
		c.ipady = 0;      
	//	c.anchor = GridBagConstraints.PAGE_END;
		c.insets = new Insets(2,0,0,0);
		c.gridx = 1;  
		c2.gridx = 1;
		
		
		
		this.add(location, c);
		this.add(location_t, c2);
		this.add(sensor_type, c);
		this.add(sensor_type_box);
		this.add(min_risq, c);
		this.add(min_risq_t);
		this.add(max_risq, c);
		this.add(max_risq_t);
		this.add(mac_address, c);
		this.add(mac_address_t);
		this.add(IP_address, c);
		this.add(IP_address_t);
		
		}
	
	
}
