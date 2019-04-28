package org.secure.retirement.home.frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class JCalendar {

	static JComboBox comboYear;
	private JComboBox comboMonth;
	private JComboBox comboDay;
	public static int year, month, day;

	public JCalendar(JPanel pan1) {
		
		//Creation of ComboBoxes
		comboDay = new JComboBox();
		comboDay.setEnabled(false);
		JComboBox comboYear = new JComboBox();
		comboYear.removeAllItems();
		final JComboBox comboMonth = new JComboBox();
		comboMonth.removeAllItems();
		
		
		//ActionListener for comboYear
		// When user select a new Year he have to select the month to use comboDay
		comboYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JComboBox comboYear = (JComboBox) event.getSource();
				year = Integer.parseInt(comboYear.getSelectedItem().toString());
				
				if (event.getActionCommand().equals("comboBoxChanged")) {
					comboDay.setEnabled(false);
			}
			}
		});

		
		//ActionListener for comboMonth 
		//According to month and year, number of day change
		comboMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				comboDay.setEnabled(true);
				JComboBox comboMonth = (JComboBox) event.getSource();
				month = Integer.parseInt(comboMonth.getSelectedItem().toString());
				comboDay.removeAllItems();
				comboDay.addItem("01");
				int k = 1;
				while (k < 31) {
					GregorianCalendar calendar = new GregorianCalendar();
					calendar.set(year, month - 1, 01);
					calendar.roll(GregorianCalendar.DAY_OF_MONTH, k);
					if (!comboDay.getItemAt(0).equals(DayFormat(calendar.getTime()))) {
						comboDay.addItem(DayFormat(calendar.getTime()));
					} 
					else {
						k = k + 100;
					}
					k++;
				}

			}
		});
		
		
		//ActionListener for ComboDay
		comboDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JComboBox comboDay = (JComboBox) event.getSource();
				if (comboDay.getItemCount()>1) {
				day = Integer.parseInt(comboDay.getSelectedItem().toString());
				GregorianCalendar calendar = new GregorianCalendar();
				calendar.set(year,month -1,day);
				System.out.println(new DateItem(calendar.getTime()));
				}
			}
		});

		
		//Initialize of number of year user can choose
		int i = -20;
		while (i < 1) {
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.roll(GregorianCalendar.YEAR, i);
			comboYear.addItem(this.YearFormat(calendar.getTime()));
			comboYear.setSelectedItem(this.YearFormat(calendar.getTime()));
			i++;
		}
		
		//Initialise of Months
		int j = 01;
		while (j < 13) {
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.roll(GregorianCalendar.MONTH, j);
			if (j < 10)
				comboMonth.addItem("0" + j);
			else
				comboMonth.addItem(j);
			comboMonth.setSelectedItem(this.MonthFormat(calendar.getTime()));
			j++;
		}
		
		
		//Adding Comboboxes to panel
		pan1.add(comboYear);
		pan1.add(comboMonth);
		pan1.add(comboDay);
	}

	
	
	private String YearFormat(Date date) {
		DateFormat dateYearFormat = new SimpleDateFormat("yyyy");
		return dateYearFormat.format(date.getTime());
	}

	private String MonthFormat(Date date) {
		DateFormat dateYearFormat = new SimpleDateFormat("MM");
		return dateYearFormat.format(date.getTime());
	}

	private String DayFormat(Date date) {
		DateFormat dateDayFormat = new SimpleDateFormat("dd");
		return dateDayFormat.format(date.getTime());
	}
	


}
