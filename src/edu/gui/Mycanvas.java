package edu.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;

class Mycanvas extends JComponent{
	private String src;
	
	public Mycanvas(String src) {
		this.src = src;
	}

	public void paint(Graphics g) {
		Graphics2D g1 = (Graphics2D) g;
		Image img = Toolkit.getDefaultToolkit().getImage(this.src); 
	    Dimension screend = Toolkit.getDefaultToolkit().getScreenSize();
		g.drawImage(img, 0, 0, (int) screend.getWidth(),(int) screend.getHeight(),  this);
		g1.finalize();
	}
}