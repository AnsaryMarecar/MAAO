package org.secure.retirement.home.frame;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.secure.retirement.home.common.Room;
import org.secure.retirement.home.common.Sensor;




class MyPanel extends JPanel{
	public void paintComponent(Graphics g) {
		try {
		super.paintComponent(g);
		
		/*
		for (int i = 0 ; i< sensors.size(); i++) {
			sensors.get(i).getSensor_positionX();
			sensors.get(i).getSensor_positionY();
			double value;
			Historic 
			//dessine
			if(sensors.get(i).getSensor_min() <=value <=sensors.get(i).getSensor_max() ) {
				//green
			}
			else if(historic_id elle est dans risque) {
				//red
			}
			if(Risque.datetime Instant.now() ) {
				//grey
			}
			
		}
	
		
		
		
		
		//
		
		
		
			/*
		 String name = FrameRoom.tabName[i];
		 int position_X = FrameRoom.tabx[i];
		int  position_XX =FrameRoom.tabxx[i];
		int position_Y=FrameRoom.taby[i];
		int  position_YY=FrameRoom.tabyy[i];
		*/
		
		for (int i=0 ; i<40; i++) {
		 String name = FrameSensorMap.tabName[i];
		 int position_X = FrameSensorMap.tabx[i];
		int  position_XX =FrameSensorMap.tabxx[i];
		int position_Y=FrameSensorMap.taby[i];
		int  position_YY=FrameSensorMap.tabyy[i];
		
		drawRectangle(g,position_X,position_Y,position_XX,position_YY);
		
		if(position_XX==0 && position_YY==0) {
		drawStr(g,name,position_X,position_Y);
		}
		}}
		catch(Exception e) {}
	
	for (int i=0 ; i<40; i++) {
	double position_x1= FrameSensor.tabx[i];
	double  position_y1= FrameSensor.taby[i];
	double sensor_min = FrameSensor.tabsensor_min[i];
	g.setColor(Color.WHITE);
	g.fillOval((int)position_x1, (int)position_y1,10,10);
	if (sensor_min <10) {
		g.setColor(Color.RED);
		g.fillOval((int)position_x1, (int)position_y1,10,10);
	}
	else if  (sensor_min >10) {
		g.setColor(Color.GREEN);
		g.fillOval((int)position_x1, (int)position_y1,10,10);
	}
	else {
		g.setColor(Color.GRAY);
		g.fillOval((int)position_x1, (int)position_y1,10,10);
	}
	}
	}
	/*
	for (int i = 0 ; i< rooms.size(); i++) {
		rooms.get(i).getX_max();
		rooms.get(i).getY_max();
		rooms.get(i).getX_min();
		rooms.get(i).getY_min();
	}
	}*/
		/*for (int i =0 ; i<40 ; i++) {
			int position_x1= FrameSensor.tabx[i];
			int position_y1= FrameSensor.taby[i];
@ -51,6 +90,7 @@ class MyPanel extends JPanel{
			}
	}
	}*/
	
	// Draw Rectangle 
	public void drawRectangle(Graphics g,int x , int y , int z, int f ) {
		g.drawRect( x ,  y ,  z, f);
	}
	public void drawStr(Graphics g,String text, int x, int y ) {
		g.drawString(text, x,y) ;
	}

	
}
		   // g.drawRect(0,0,200,500);

	/*
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
*/


