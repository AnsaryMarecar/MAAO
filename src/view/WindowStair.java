package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.lang.model.element.Element;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controler.DAO;
import controler.DAOStair;
import model.Stair;

/**
 * 
 */

/**
 * @author mansa
 *
 */
public class WindowStair extends Window<Stair>{
	
	private JTextField 	nameadd_textField 			= new JTextField();
	private JLabel 		nameadd_label				= new JLabel("Add a stair name : ");
	
	private JTextField 	nameupdate_textField 		= new JTextField();
	private JLabel 		nameupdate_label			= new JLabel("Update a stair name : ");
	
	
	  
	public WindowStair() {
		super();
		this.setTitle("MAAO - Configuration stair");
		this.setTitle_label("Configuration stair");
	   
		Font police = new Font("Arial", Font.BOLD, 14);
		// form add
		nameadd_textField.setFont(police);
		nameadd_textField.setPreferredSize(new Dimension(150, 30));
		nameadd_textField.setForeground(Color.BLUE);
		super.addform_panel.add(nameadd_label);
		super.addform_panel.add(nameadd_textField);
		
		// form update
		nameupdate_textField.setFont(police);
		nameupdate_textField.setPreferredSize(new Dimension(150, 30));
		nameupdate_textField.setForeground(Color.BLUE);
		super.updateform_panel.add(nameupdate_label);
		super.updateform_panel.add(nameupdate_textField);
		super.updateform_panel.add(this.getFupdate_button());
		this.nameupdate_textField.setVisible(false);
		this.nameupdate_label.setVisible(false);
		this.getFupdate_button().setVisible(false);
		
		// table
		this.getW_dtm().addColumn("Id"	);
		this.getW_dtm().addColumn("Nom"	);
		this.initialise_table();
		w_table = new JTable(this.getW_dtm()); 
		//table placement (study how to put in window class) ?
	    super.getComponent_panel().add(super.getW_table(), BorderLayout.CENTER);
		
	    this.setVisible(true);
	    
	}
	class BoutonListener implements ActionListener{
		  public void actionPerformed(ActionEvent e) {
			  /**
		    DAOStair daoStair;
			try {
				daoStair = new DAOStair();
				Stair stair = new Stair(name_textField.getText());
		        try {
					if(daoStair.create(stair)) {
						information_label.setOpaque(true);
						information_label.setBackground(Color.green);
						information_label.setText("Congratulation, your value is added");
						//actualis JTab
					}else {
						information_label.setOpaque(true);
						information_label.setBackground(Color.red);
						information_label.setText("Sorry, but you can't insert an existant data.");
						//error_optionpane = new JOptionPane();
					    //JOptionPane.showMessageDialog(null, "Sorry, but you can't insert an existant data.", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} */
		  }	 
	}
	
	@Override
	public void add_table(Stair obj) {
		// TODO Auto-generated method stub
		this.getW_dtm().addRow(new String[]{String.valueOf(obj.getStair_id()),obj.getStair_name()}); 
	}
	@Override
	public void update_table() {
		// TODO Auto-generated method stub
		this.nameupdate_textField.setVisible(false);
		this.nameupdate_label.setVisible(false);
		this.getFupdate_button().setVisible(false);
	}
	@Override
	public void initialise_table() {
		// TODO Auto-generated method stub
		DAOStair daostair;
		this.getW_dtm().setRowCount(0);
		ArrayList<Stair> list;
		try {
			daostair = new DAOStair();
			list = daostair.presentData();
			for(int i = 0 ; i<list.size(); i++) {
				this.add_table(list.get(i));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean update_action() {
		// TODO Auto-generated method stub
		boolean  to_return 		= false;
		int 	 line_number 	= this.getW_table().getSelectedRow();
		int 	 id_stair		= Integer.decode( (String) this.getW_dtm().getValueAt(line_number, 0) );
		String	 name_stair		= (String) this.nameupdate_textField.getText().trim();
		DAOStair daostair;
		Stair	 stair;
		if(line_number>=0) {
			try {
				if(name_stair.trim() !="") {
					System.out.println("update action");
					stair = new Stair(id_stair,name_stair);
					daostair = new DAOStair();
					if(daostair.update(stair)) {
						System.out.println("update action daostair");
						this.initialise_table();
						to_return = true;
					}else {
						JOptionPane.showMessageDialog(null, "Sorry, but you can't insert an existant data.", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Sorry, but you can't add without a name.", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
		}
		return to_return;
	}
	
	@Override
	public boolean delete_action() {
		// TODO Auto-generated method stub
		boolean to_return 	= false;
		int line_number 	= this.getW_table().getSelectedRow();
		int id_stair		= -1;
		if(line_number>=0) {
			DAO daostair;
			try {
				daostair = new DAOStair();
				
				id_stair = Integer.decode( (String) this.getW_dtm().getValueAt(line_number, 0) );
				if(daostair.delete(id_stair)) {
					delete_table(line_number);
					to_return = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return to_return;
	}
	
	@Override
	public boolean add_action() {
		// TODO Auto-generated method stub
		boolean to_return = false;
		String text = nameadd_textField.getText().trim();
		if(text=="") {
			JOptionPane.showMessageDialog(null, "Sorry, but you can't add without a name.", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
		}
		else {
			Stair stair = new Stair(text);
			DAO daostair;
			try {
				daostair = new DAOStair();
				if(daostair.create(stair)) {
					this.initialise_table();
					this.update_table();
					to_return = true; 
				}
				else {
					JOptionPane.showMessageDialog(null, "Sorry, but you can't insert an existant data.", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return to_return;
	}
	@Override
	public void update_on(int line_number) {
		// TODO Auto-generated method stub
		int 	 id_stair		= Integer.decode( (String) this.getW_dtm().getValueAt(line_number, 0) );
		String	 name_stair		= (String) this.getW_dtm().getValueAt(line_number, 1);
		this.nameupdate_textField.setText(name_stair);
		this.nameupdate_label.setVisible(true);
		this.nameupdate_textField.setVisible(true);
		this.getFupdate_button().setVisible(true);
	}

}