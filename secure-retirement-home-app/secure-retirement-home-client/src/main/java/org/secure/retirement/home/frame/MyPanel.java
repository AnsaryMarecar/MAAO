package org.secure.retirement.home.frame;


import javax.swing.JPanel;

import com.sun.prism.Graphics;

class MyPanel extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent( (java.awt.Graphics) g);
		    g.drawLine(15, 10, 100, 50);
	}
}