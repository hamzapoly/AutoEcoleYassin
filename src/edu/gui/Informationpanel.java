package edu.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Canvas;
import java.awt.ComponentOrientation;

public class Informationpanel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Informationpanel window = new Informationpanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Informationpanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Menu1");
		lblNewLabel_1.setBorder(new LineBorder(Color.BLUE));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 99, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("Menu1");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBorder(new LineBorder(Color.BLUE));
		label.setBounds(96, 0, 99, 37);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Menu1");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBorder(new LineBorder(Color.BLUE));
		label_1.setBounds(192, 0, 99, 37);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Menu1");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBorder(new LineBorder(Color.BLUE));
		label_2.setBounds(287, 0, 99, 37);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setHorizontalTextPosition(SwingConstants.CENTER);
		label_3.setIcon(new ImageIcon("P:\\ESPRIT\\Nouveau dossier\\WorkSpace\\AutoEcoleYassinDell\\src\\edu\\utils\\home.png"));

		
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBorder(new LineBorder(Color.BLUE));
		label_3.setBounds(382, 0, 52, 37);
		frame.getContentPane().add(label_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(UIManager.getBorder("DesktopIcon.border"));
		lblNewLabel.setBounds(0, 0, 434, 37);
		frame.getContentPane().add(lblNewLabel);
	}
}
