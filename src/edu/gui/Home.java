package edu.gui;
import edu.dao.classes.*;
import edu.entities.User;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;


import java.awt.Font;

import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.CardLayout;
import javax.swing.border.EtchedBorder;

import javax.swing.border.CompoundBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home {

	private static JFrame frame1;
	private String username;
	private JPanel mainP;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	public Home(String username){
		this.username = username;
		initialize();
	}
	public JFrame getFrame1() {
		return frame1;
	}

	public void setFrame1(JFrame frame1) {
		Home.frame1 = frame1;
	}
	
	public JPanel getmainP() {
		return mainP;
	}

	public void setInfoP(JPanel mainP) {
		this.mainP = mainP;
	}
	
	public void newPanel (JFrame frame1,JPanel NPanel){
		frame1.getContentPane().add(NPanel);
      //  System.out.println("in4");
		//frame1.setVisible(false);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.getContentPane().setForeground(Color.WHITE);
		frame1.getContentPane().setFont(new Font("Andalus", frame1.getContentPane().getFont().getStyle(), frame1.getContentPane().getFont().getSize()));
		frame1.setSize(1600, 900);
		frame1.setResizable(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(new CardLayout(0, 0));
		Color borderc = new Color(79, 139, 156);
		UIManager UI = new UIManager();
		UI.put("OptionPane.background",borderc);
		UI.put("Panel.background", borderc);

		Toolkit toolkit =  Toolkit.getDefaultToolkit ();
		Dimension dim = toolkit.getScreenSize();
		int width = (int) dim.getWidth();
		int height = (int) dim.getHeight();
		
		
		final JPanel panel = new JPanel( );
		//panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 0, 128), new Color(255, 0, 255), new Color(0, 255, 255), new Color(0, 191, 255)));
		panel.setBackground(Color.WHITE);
		panel.setForeground(new Color(230, 230, 250));
		frame1.getContentPane().add(panel, "name_1483415348374009");
		panel.setLayout(null);
		Insets insets = panel.getInsets();
		
		JLabel lblNewLabel = new JLabel("",SwingConstants.CENTER);
		lblNewLabel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.RAISED, null, null)));
		lblNewLabel.setIcon(new ImageIcon("./src/edu/utils/homebackground.jpg"));
		lblNewLabel.setHorizontalTextPosition(JLabel.CENTER);
		lblNewLabel.setBackground(borderc);
		lblNewLabel.setBounds(548 , 26, 120, 120);
		panel.add(lblNewLabel);
		//JLabel label = new JLabel("",SwingConstants.CENTER);
		//label.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new //EtchedBorder(EtchedBorder.RAISED, null, null)));
		//label.setIcon(new ImageIcon("./src/edu/utils/tests1.png"));
		//label.setHorizontalTextPosition(JLabel.CENTER);
		//label.setBackground(borderc);
		//label.setBounds(732 , 26, 120, 120);
		//panel.add(label);
		final JButton label = new JButton("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setSize(125, 125);
			}
			public void mouseExited(MouseEvent e) {
				label.setSize(120, 120);
			}
		});

		label.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.RAISED, null, null)));
		label.setIcon(new ImageIcon("./src/edu/utils/tests1.png"));
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setBackground(borderc);
		label.setBounds(732 , 26, 120, 120);
		panel.add(label);

		UserDao userDao = new UserDao();
		final User user = userDao.findUserByLogin(username);
		JLabel label_6 = new JLabel("");
		label_6.setBounds(round(dim.width*0.88), 0, 134, 88);
		label_6.setHorizontalTextPosition(JLabel.CENTER);
		label_6.setVerticalTextPosition(JLabel.CENTER);
		label_6.setText(user.getPrenom()+" "+user.getNom());
		label_6.setFont(new Font("Simplified Arabic", Font.PLAIN, 30));
		panel.add(label_6);
	
		final JButton label_1 = new JButton("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_1.setSize(125, 125);
			}
			public void mouseExited(MouseEvent e) {
				label_1.setSize(120, 120);
			}
			public void mouseClicked(MouseEvent e) {
				try {
					frame1.getContentPane().removeAll();							
					frame1.getContentPane().add(new Informationpanel(user).getInfoP());
					frame1.getContentPane().validate();
					//frame1.getContentPane().repaint();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		label_1.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.RAISED, null, null)));
		label_1.setIcon(new ImageIcon("./src/edu/utils/profile.png"));
		label_1.setBackground(borderc);
		label_1.setBounds(1071 , 26, 120, 120);
		panel.add(label_1);
		
		final JButton label_2 = new JButton("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_2.setSize(125, 125);
			}
			public void mouseExited(MouseEvent e) {
				label_2.setSize(120, 120);
			}
		});
		label_2.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.RAISED, null, null)));
		label_2.setIcon(new ImageIcon("./src/edu/utils/cours1.png"));
		label_2.setBackground(borderc);
		label_2.setBounds(905 , 26, 120, 120);
		panel.add(label_2);
		

		final JLabel lblNewLabel_2 = new JLabel("");
		
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setIcon(new ImageIcon("./src/edu/utils/homebackground2.jpg"));
		lblNewLabel_2.setHorizontalTextPosition(JLabel.CENTER);
		lblNewLabel_2.setBounds(0, 0, width, height);
		
		JLabel lblNewLabel_1 = new JLabel("الدروس");
		lblNewLabel_1.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(548, 149, 120, 23);
		panel.add(lblNewLabel_1);
		
		JLabel label_3 = new JLabel("الاختبارات");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		label_3.setBounds(732, 149, 120, 23);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("الدروس");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		label_4.setBounds(905, 149, 120, 23);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("البيانات");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Simplified Arabic", Font.BOLD, 20));
		label_5.setBounds(1071, 149, 120, 23);
		panel.add(label_5);
		this.mainP = panel;
		System.out.println( mainP);



	}

	private int round(double d) {
		// TODO Auto-generated method stub
		return (int) Math.round(d);
	}
}
