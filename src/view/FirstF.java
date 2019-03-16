package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.mysql.jdbc.Connection;

import controler.DataSource;

/**
 * <p>Window of administration</p>
 * 
 * @author amine.maza
 * @param <T>
 *
 */
public class FirstF extends JFrame implements ActionListener {

	private JPanel pan1, pan2;
	private JButton jb1, jb3;
	/*private JButton jb2; */
	private JLabel jl1;
	public java.sql.Connection c;
	private DataSource dt;
	
	/**
	 * <p>constructor</p>
	 * 
	 * @author amine.maza
	 *
	 */
	public FirstF(){
		
		//General
		super ("Menu");
		this.setSize(500,150);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		// Creation of JPanel 
		pan1= new JPanel();
		pan2= new JPanel();
		
		//Creation of JButton and JLabel
		jb1= new JButton("Open a connection");
		/*jb2= new JButton("Close all connections");*/
		jb3= new JButton("Display Connections");
		
		jl1= new JLabel();
		
		//Insertion of JPanel on the Frame
		this.add(pan1, BorderLayout.NORTH);
		this.add(pan2, BorderLayout.SOUTH);
		
		//Insertion of element on Panels
		pan1.add(jl1);
		jl1.setText("Choose an action");
		
		pan2.add(jb1);
		/*pan2.add(jb2);*/
		pan2.add(jb3);
		
		
		//Button add ActionListener
		jb1.addActionListener(this);
		/*jb2.addActionListener(this);*/
		jb3.addActionListener(this);
		
		this.setVisible(true);
		
	}
	
	/**
	 * <p>evenement</p>
	 * 
	 * @author amine.maza
	 *
	 */
	public void actionPerformed(ActionEvent event) {
		
		// if user choose to create a connection 
		if (event.getSource() ==jb1) {
			try {
			c= dt.returnConex();
			System.out.println(c);
			WindowConnection w= new WindowConnection(c);
			}
			catch (Exception e) {
				JOptionPane jo1= new JOptionPane();
				jo1.showMessageDialog(null,  "No connection available, please try later",  "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		// if user choose to close all connections
		/*else if (event.getSource()== jb2) {
				dt.closeAllConnection();
				System.out.println("test");
		}*/
		
		// if user choose to displays all connections available
		else if (event.getSource()== jb3) {
			JOptionPane jo1= new JOptionPane();
			JTextArea textArea = new JTextArea(dt.displayConnex().toString());
			JScrollPane scrollPane = new JScrollPane(textArea);  
			textArea.setLineWrap(true);  
			textArea.setWrapStyleWord(true); 
			scrollPane.setPreferredSize( new Dimension( 500, 200 ) );
			jo1.showMessageDialog(null, scrollPane, "Connection available", JOptionPane.INFORMATION_MESSAGE);
			}
	}
}