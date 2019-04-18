package org.secure.retirement.home.frame;


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;



class MyPanel extends JPanel{
	public void paintComponent(Graphics g ) {
		super.paintComponent(g);
	
		
		   // g.drawRect(0,0,200,500);

	
		g.drawLine(200,0,0,0);
		g.drawLine(0,400,0,0);
		g.drawLine(0,470,0,500);
		g.drawRect(180,200,20,100);
		    g.drawRect(0,400,20,70);	//porte salle d'annimation
		    g.drawRect(20,20,160,460);  // linterieur de la salle
		    g.drawRect(200,0,800,200);
		    g.drawString("salle d'animation", 60, 200);
		    g.drawString("couloir", 500, 250);
		    g.drawString("Ascenseur/Escaliers", 520, 40);
		    g.drawString("Salle de soins", 350, 420);
		    g.drawString("Blanchisserie ", 750, 420);
		    g.drawString("Chambre ", 230, 60);
		    g.drawString("Chambre ", 330, 60);
		    g.drawString("Chambre ", 430, 60);
		    g.drawString("Chambre ", 730, 60);
		    g.drawString("Chambre ", 830, 60);
		    g.drawString("Chambre ", 930, 60);
		    g.drawRect(210,10,80,180);// linterieur de la chambre
		    g.drawRect(410,10,80,180);//chambre
		    g.drawRect(310,10,80,180);//chambre
		    g.drawRect(510,20,180,180);//escalier
		    g.drawRect(620,0,50,20);
		    g.drawRect(710,10,80,180);//chambre  zone interdit 
		    g.drawRect(810,10,80,180);//chambre
		    g.drawRect(910,10,80,180);//chambre
		    g.drawRect(200,0,100,200);
		    g.drawRect(200,0,200,200);
		    g.drawRect(200,0,300,200);
		    g.drawRect(200,0,500,200);
		    g.drawRect(200,0,600,200);
		    g.drawRect(200,0,700,200);
		    
		    g.drawRect(200,0,800,200);
		    g.drawRect(200,300,350,200);
		    g.drawRect(220,320,310,160);//salle de soin
		    g.drawRect(350,300,70,20);// porte sale de soins
		    g.drawRect(385,480,60,20);//fenetre sale de soins
		//    g.drawRect(550,300,100,200);
		    g.drawRect(650,300,350,200);
		    g.drawRect(650,375,20,70);//porte blanchisserie
		    g.drawRect(980,375,20,50);//fenetre
		    g.drawRect(670,320,310,160);//blanchisserie
		   
		
	}


}

