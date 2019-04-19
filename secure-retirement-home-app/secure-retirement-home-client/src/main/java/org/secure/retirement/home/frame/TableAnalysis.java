package org.secure.retirement.home.frame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class TableAnalysis  {

	public TableAnalysis(JPanel pan) {

		Object[][] donnees = {
				{ "Johnathan", "Sykes", Color.red}, 
				{ "Nicolas", "Van de Kampf", Color.black },
				{ "Damien", "Cuthbert", Color.cyan },
				{ "Corinne", "Valance", Color.blue },
				{ "Emilie", "Schrödinger", Color.magenta },
				{ "Delphine", "Duke", Color.yellow },
				{ "Eric", "Trump", Color.pink },
				};

		String[] entetes = { "Prénom", "Nom", "Couleur favorite", "Homme", "Sport" };

		JTable tableau = new JTable(donnees, entetes);

		
		pan.add(tableau.getTableHeader());
		// ERRORIN LAYOUT MANAGER 
		//pan.add(tableau, BorderLayout.CENTER);


	}

}
