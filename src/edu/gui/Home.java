package edu.gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import java.awt.Font;

public class Home {

	private JFrame frame1;
	public JFrame getFrame1() {
		return frame1;
	}

	public void setFrame1(JFrame frame1) {
		this.frame1 = frame1;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.getContentPane().setForeground(new Color(139, 0, 139));
		frame1.getContentPane().setFont(new Font("Andalus", frame1.getContentPane().getFont().getStyle(), frame1.getContentPane().getFont().getSize()));
		frame1.setSize(1600, 900);
		frame1.setResizable(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		JPanel panel = new JPanel( );
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 0, 128), new Color(255, 0, 255), new Color(0, 255, 255), new Color(0, 191, 255)));
		panel.setBackground(new Color(230, 230, 250));
		panel.setForeground(new Color(230, 230, 250));
		panel.setBounds(0, 0, 0, 0);
		panel.setLayout(null);
		frame1.getContentPane().add(panel);
		final JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setIcon(new ImageIcon("D:\\ESPRIT\\WEB World\\WorkSpace\\YassinSchool\\src\\edu\\utils\\home.jpg"));
		lblNewLabel_2.setBounds(0, 0, 1584, 862);
		frame1.getContentPane().add(lblNewLabel_2);

	}
}
