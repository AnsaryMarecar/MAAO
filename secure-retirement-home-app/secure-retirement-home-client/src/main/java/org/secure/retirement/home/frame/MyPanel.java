package org.secure.retirement.home.frame;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;




class MyPanel extends JPanel{
	public void paintComponent(Graphics g) {
		try {
		super.paintComponent(g);
		for (int i=0 ; i< 60 ; i++) {
			int x = (int)FrameSensorMap.tabsensor_x[i];
			int y=(int)FrameSensorMap.tabsensor_y[i];
			int min = (int) FrameSensorMap.tabsensor_min[i];
			int max= (int) FrameSensorMap.tabsensor_max[i];
			int value = FrameSensorMap.tabhistoric_value[i];
			
				g.setColor(Color.GRAY);
				g.fillOval(x, y, 10, 10);
			
		
		}
		
		}
		catch (Exception e) {}
		
		for (int i=0 ; i<60; i++) {
			 String name = FrameSensorMap.tabName[i];
			 int position_X = FrameSensorMap.tabx[i];
			int  position_XX =FrameSensorMap.tabxx[i];
			int position_Y=FrameSensorMap.taby[i];
			int  position_YY=FrameSensorMap.tabyy[i];
			
			g.setColor(Color.BLACK);
			drawRectangle(g,position_X,position_Y,position_XX,position_YY);
			
			try {
			if(position_XX==0 && position_YY==0) {
				drawStr(g,name,position_X,position_Y);
				}
			
			}catch (Exception e) {}
		}
		}
		
	// Draw Rectangle 
	public void drawRectangle(Graphics g,int x , int y , int z, int f ) {
		g.drawRect( x ,  y ,  z, f);
	}
	// Draw String Room name
	public void drawStr(Graphics g,String text, int x, int y ) {
		g.drawString(text, x,y) ;
	}
	
}


