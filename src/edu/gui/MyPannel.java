package edu.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;

class MyPannel extends JComponent{
	
	public MyPannel() {
	}
	int round (double x) {
		return (int) Math.round(x);
	}
	public void paint(Graphics g) {
		Graphics2D g1 = (Graphics2D) g;
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		double x1 = d.width*0.75;
        int xPoly[] = {round(d.width*0.60), d.width,round(d.width*0.40),0};
        int yPoly[] = {0,round(d.height*0.60),round(d.height*0.80),round(d.height*0.65)};
        Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);
		//g.drawPolygon(poly);
		Color newpink = new Color(252,14, 65);
        g.setColor(newpink);
		g.fillPolygon(poly);
		
		g1.finalize();
	}

}