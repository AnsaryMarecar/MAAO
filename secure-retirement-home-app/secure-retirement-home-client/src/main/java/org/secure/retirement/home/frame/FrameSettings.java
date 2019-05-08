package org.secure.retirement.home.frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.MenuListener;
import javax.swing.*;
import java.awt.*;

import org.secure.retirement.home.client.ClientTransmission;
import org.secure.retirement.home.common.Sensor;

public class FrameSettings extends JFrame implements ActionListener{

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
	JButton confirm = new JButton("Confirm");
	JButton cancel = new JButton("Cancel");

	public FrameSettings() {

		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.setSize(500, 600);
		this.setResizable(false);
		this.setVisible(true);


		sensor_type_box.addItem("smoke");
		sensor_type_box.addItem("humidity");
		sensor_type_box.addItem("motion");
		sensor_type_box.addItem("position");
		sensor_type_box.addItem("brightness");
		sensor_type_box.addItem("occupancy");


		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		GridBagConstraints c2 = new GridBagConstraints();
		location_t.setPreferredSize(new Dimension(100, 30));
		min_risq_t.setPreferredSize(new Dimension(100, 30));
		max_risq_t.setPreferredSize(new Dimension(100, 30));
		mac_address_t.setPreferredSize(new Dimension(100, 30));
		IP_address_t.setPreferredSize(new Dimension(100, 30));
		sensor_type_box.setPreferredSize(new Dimension(100,30));


		c.gridx = 1;  
		c2.gridx = 2;



		this.add(location, c);
		this.add(location_t, c2);
		this.add(sensor_type, c);
		this.add(sensor_type_box, c2);
		this.add(min_risq, c);
		this.add(min_risq_t, c2);
		this.add(max_risq, c);
		this.add(max_risq_t, c2);
		this.add(mac_address, c);
		this.add(mac_address_t, c2);
		this.add(IP_address, c);
		this.add(IP_address_t, c2);
		this.add(confirm, c);
		this.add(cancel, c2);

		confirm.addActionListener(this);
		cancel.addActionListener(this);
	}


	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource()==confirm) {
			if(min_risq_t.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "The field \"Min risq\" cannot be empty", "MAAO - Error message", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(ev.getSource()==cancel) {
			int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel your entry ?", "MAAO - Warning message", JOptionPane.YES_NO_CANCEL_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				this.dispose();
			}


		}
	}
}