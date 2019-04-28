package org.secure.retirement.home.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableAnalysis{
	
	private String[] headers;
	private JTable tableau;
	private 	DefaultTableModel 	w_dtm 				= new DefaultTableModel() {
		@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
	};

	public TableAnalysis(JPanel pan) {

		Object[][] data = {};

		String[] headers= {};

		tableau = new JTable(data, headers);

		tableau.setBackground(new Color(173,216,230));
		pan.add(tableau.getTableHeader(), BorderLayout.NORTH);
		pan.add(tableau, BorderLayout.CENTER);
		tableau.setVisible(false);

	}
	

	
	private JTable getTable() {
		return tableau;
	}
	
	public DefaultTableModel getHeaders() {
		return this.w_dtm;
	}
	
	
	public void setData() {
		
	}

}
	

