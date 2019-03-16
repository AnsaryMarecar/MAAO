/**
 * 
 */
package view;

/**
 * <p>Frame of connexion</p>
 * 
 * @author oussama.bouachrine 
 *
 */
import javax.swing.*;

import controler.ReadFileXML;

import java.awt.*;
import java.awt.event.*;


import java.sql.*;

public class WindowConnection extends JFrame implements ActionListener {
	
	// panel attribut
	private	JPanel panelHead, panelMiddle, panelFoot			;
		
	// form component attribut
	private	JButton 	connection_button, erase_button			;
	private	JTextField 	id_textfield							;
	private	JTextField 	password_textfield						;
	private	JLabel 		title_label,login_label,passw_label		;
	private	String		champ1,champ2							;
	
	// other attribut
	public	static Connection c									;
	public	ReadFileXML r										;
	
	/**
	 * <p>constructor</p>
	 * 
	 * @author oussama.bouachrine 
	 */
	public WindowConnection(Connection c) {
		// General
		super("Data Connection Interface")			;
		this.setSize(300,300)									;
		this.setLocationRelativeTo(null)						;
		this.setResizable(false);
		
		// Label use in the interface connection
		title_label	= new JLabel("Welcome To MAAO Interface",SwingConstants.CENTER)	;
		login_label	= new JLabel("Login 	: ",SwingConstants.LEFT)				;
		passw_label	= new JLabel("Password  : ",SwingConstants.LEFT)				;
	
		// Other element of the Window
		id_textfield 		= new JTextField("")				;
		password_textfield 	= new JPasswordField("")			;
		connection_button 	= new JButton("Connexion")			;
		erase_button 		= new JButton("Cancel the entry")	;
		
		// creation panel placement
		this.setLayout(new BorderLayout())						;
		panelHead	=	new JPanel()							;
		panelMiddle =	new JPanel()							;
		panelFoot	= 	new JPanel()							;
		
		// panel Head
		panelHead.add(title_label)								;
		panelHead.setBackground(Color.LIGHT_GRAY)				;
		
		// panel in the Middle 
		panelMiddle.setLayout(new GridLayout(8, 4))				;
		panelMiddle.add(login_label)							;
		panelMiddle.add(id_textfield)							;
		panelMiddle.add(passw_label)							;
		panelMiddle.add(password_textfield)						;
		
		// panel footer
		panelFoot.add(connection_button)						;
		panelFoot.add(erase_button)								;
		
		//placement of panels
		this.add(panelHead	,	BorderLayout.NORTH	)			;
		this.add(panelMiddle,	BorderLayout.CENTER	)			;
		this.add(panelFoot	,	BorderLayout.SOUTH	)			;	
		
		// button action listener
		connection_button.addActionListener(this)				;
		erase_button.addActionListener(this)					;
		
		this.setVisible(true);
	}
	
	/**
	 * <p>evenement</p>
	 * 
	 * @author oussama.bouachrine 
	 *
	 */
	public void actionPerformed(ActionEvent event) {
		// if connection clicked
		if(event.getSource() == connection_button) {
			champ1 	= id_textfield.getText()					;
			champ2 	= password_textfield.getText()				;
			r		= new ReadFileXML()							;
			// read XML File
			try {
				if(r.readFile(champ1,champ2))	{
					this.dispose();
				}
			} catch (Exception e) {
			}			
		}
		// if erase button clicked
		else if(event.getSource() == erase_button) {
			id_textfield.setText("")							;
			password_textfield.setText("")						;
		}
	}
}