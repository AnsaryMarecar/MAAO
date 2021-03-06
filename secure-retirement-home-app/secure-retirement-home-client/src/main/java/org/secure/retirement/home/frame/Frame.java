package org.secure.retirement.home.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author Ansary MARECAR
 *
 */
public abstract class Frame<T> extends JFrame implements ActionListener{
	
	//Panel 
	protected 	JPanel 				menu_panel	 		= new JPanel()				 ;
	protected 	JPanel				component_panel		= new JPanel()				 ;
	protected 	JPanel				left_panel			= new JPanel()				 ;
	protected	JPanel				addform_panel		= new JPanel()				 ;
	protected	JPanel				updateform_panel	= new JPanel()			     ;
	private 	JPanel				top_panel			= new JPanel()				 ;

	
	//Button
	protected 	JButton 			add_button 			= new JButton("Add"			);
	protected 	JButton 			update_button 		= new JButton("Update"		);
	private 	JButton 			fupdate_button 		= new JButton("Submit"		);
	protected 	JButton 			delete_button 		= new JButton("Delete"		);
	protected 	JButton 			disconnect_button 	= new JButton("Refresh"	);
	
	//Other element
	protected 	JLabel				title_label			= new JLabel()				 ;
	protected 	JTable				w_table											 ;
	
	private 	JOptionPane			att_optionpane = new JOptionPane();
	
	//table element
	private 	DefaultTableModel 	w_dtm 				= new DefaultTableModel() {
		@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
	};
	
	/**
	 * 
	 * @param c
	 */
	public Frame(){
		//Generality
		this.setSize(1000, 500)									 			 ;
	    this.setLocationRelativeTo(null)						 			 ;               
	    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE)		 			 ;
	    
	    //north placement
	    addform_panel.setLayout(new FlowLayout())				 			 ;
	    updateform_panel.setLayout(new FlowLayout())			 			 ;
	    top_panel.setLayout(new BorderLayout())					 			 ;
	    top_panel.add(menu_panel		, BorderLayout.NORTH	)			 ;
	    top_panel.add(addform_panel		, BorderLayout.CENTER	)			 ;
	    top_panel.add(updateform_panel	, BorderLayout.SOUTH	)			 ;
	    
	    //principal placement
	    this.setLayout(new BorderLayout())									 ;
	    this.getContentPane().add(top_panel			, BorderLayout.NORTH	);
	    this.getContentPane().add(component_panel	, BorderLayout.CENTER);
	    
	    //content page placement
	    component_panel.setLayout(new BorderLayout())						 ;
	    
	    //Action listener for Button
	    this.getAdd_button().addActionListener		(new ButtonListener())	 ;
	    this.getUpdate_button().addActionListener	(new ButtonListener())	 ;
	    this.getDelete_button().addActionListener	(new ButtonListener())	 ;
	    this.getFupdate_button().addActionListener	(new ButtonListener())	 ;
	    this.getFDisconnect_button().addActionListener	(new ButtonListener());	    
	}
	
	/**
	 *	@Override ButonListener ActionListener
	 *	@author melissa.oussadi
	 */
	class ButtonListener implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	if ("Add".equals(e.getActionCommand())) { // Add button actioned
	            // method add
	        	add_action()										;
	        	System.out.println("add")							;
	        	setVisible(true)									;
	        } 
	        else if ("Update".equals(e.getActionCommand())) { // update button actioned
	        	int line_number = getW_table().getSelectedRow()		;
		    	if(line_number>=0) {
		    		update_on(line_number)							;
		    	}
	        }
	        else if ("Delete".equals(e.getActionCommand())) { //delete button actioned
	            // method delete line number
	        	delete_action()										;
	        	System.out.println("delete")						;
	        	setVisible(true)									;
	        }
	        else if("Submit".equals(e.getActionCommand())){ // submit button of the delete form actioned
	        	// method update line number
	        	update_action()										;
	        	System.out.println("update")						;
	        	setVisible(true)									;
	        }
	        else if("Actualise".equals(e.getActionCommand())) { // actualise button actionned
				System.out.println("actualise")						;
				call_initialise_table()								;
				setVisible(true)									;
			}
	    }
	}
	
	private class ItemListen implements ItemListener {

        public void itemStateChanged(ItemEvent arg0) {
        	
        }
	}
	
	
	
    public abstract boolean add_action		(				)		;
    public abstract boolean update_action	(				)		;
    public abstract boolean delete_action	(				)		;
    public abstract void 	update_on		(int line_number)		;
    
    /**
	 *	JMenu
	 */
	public void menu() {
		
	}
	
	/**
	 * @return the component_panel
	 */
	public JPanel getComponent_panel() {
		return this.component_panel									;
	}
	/**
	 * @return the add_button
	 */
	public JButton getAdd_button() {
		return this.add_button										;
	}
	/**
	 * @return the update_button
	 */
	public JButton getUpdate_button() {
		return this.update_button									;
	}
	/**
	 * @return the delete_button
	 */
	public JButton getDelete_button() {	
		return this.delete_button									;
	}
	/**
	 * @return the disconnect_button
	 */
	public JButton getFDisconnect_button() {
		
		return this.disconnect_button								;
	}
	/**
	 * @return the w_table
	 */
	public JTable getW_table() {
		
		return this.w_table											;
	}

	/**
	 * @return the DefaultTableModel
	 */
	public  DefaultTableModel getW_dtm() {
		return this.w_dtm											;
	}
	/**
	 * @param w_table the w_table to set
	 */
	public void setW_table(JTable the_table) {
		this.w_table = the_table									;
	}
	
	/**
	 * Init the JTable
	 */
	public abstract void initialise_table	(T[] obj)				;
	
	public abstract void initialise(String param_json, String param_class)throws IOException;
	
	/**
	 * add a line of the JTable
	 */
	public abstract void add_table 			(T obj)					;
	
	/**
	 * delete a line of the JTable
	 */
	public void delete_table(int ligne_number) {
		this.getW_dtm().removeRow(ligne_number)						;
	}
	
	/**
	 * update a line of the JTable
	 */
	public abstract void update_table 		()						;

	/**
	 * @return the title_label
	 */
	public JLabel getTitle_label() {
		return title_label											;
	}

	/**
	 * @param title_label the title_label to set
	 */
	public void setTitle_label(String title_string) {
		this.title_label.setText(title_string)						;
	}
	/**
	 * @return the fupdate_button
	 */
	public JButton getFupdate_button() {
		return fupdate_button										;
	}
	/**
	 * @param fupdate_button the fupdate_button to set
	 */
	public void setFupdate_button(JButton fupdate_button) {
		this.fupdate_button = fupdate_button						;
	}
	public void call_initialise_table() {
	}
	
	public void setOptionpane(JOptionPane param_optionpane) {
		this.att_optionpane = param_optionpane;
	}
	
	public JOptionPane getOptionpane() {
		return this.att_optionpane;
	}
	
	
	
}
