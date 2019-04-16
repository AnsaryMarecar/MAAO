package org.secure.retirement.home.frame;


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;



class MyPanel extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		    g.drawRect(0,0,120,160);
		    g.drawRect(120,160,200,200);
		    
		   
	}
}