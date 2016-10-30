package edu.gui;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;


import javax.swing.JTextField;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;


import edu.dao.classes.UserDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Index {

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index window = new Index();
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
	public Index() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Yassin");
		frame.getContentPane().setForeground(new Color(139, 0, 139));
		frame.getContentPane().setFont(new Font("Andalus", frame.getContentPane().getFont().getStyle(), frame.getContentPane().getFont().getSize()));
		frame.setSize(1600, 900);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel( );
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 0, 128), new Color(255, 0, 255), new Color(0, 255, 255), new Color(0, 191, 255)));
		panel.setBackground(new Color(230, 230, 250));
		panel.setForeground(new Color(230, 230, 250));
		panel.setBounds(0, 0, 0, 0);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		Insets insets = panel.getInsets();
		JLabel lblNewLabel_1 = new JLabel("مرحبا بكم");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(220, 20, 60));
		//lblNewLabel_1.setFont(new Font("Arabic Typesetting", Font.BOLD, 12));
		lblNewLabel_1.setBounds(700 , 70 + insets.top, 352, 115);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(220, 20, 60));
		lblNewLabel_1.setFont(new Font("AL-Majd", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 60));
		//USERNAME Field
		username = new JTextField();
		username.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				username.setBorder(BorderFactory.createLineBorder(Color.red, 2));
			}
		});
		username.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				username.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			}
		});
		
		JLabel label_1 = new JLabel("تسجيل الدخول ...");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Andalus", label_1.getFont().getStyle() | Font.BOLD, 28));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(850 + insets.left, 280 + insets.top, 192, 33);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("اسم المستخدم");
		label_2.setFont(new Font("MO_Nawel", Font.BOLD, 20));
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(1000 + insets.left, 330 + insets.top, 156, 33);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("كلمة العبور");
		label_3.setFont(new Font("MO_Nawel", Font.BOLD, 20));
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(1000 + insets.left, 370 + insets.top, 146, 33);
		frame.getContentPane().add(label_3);
		
		username.setBounds(870 + insets.left, 335 + insets.top, 167, 33);
		frame.getContentPane().add(username);
		username.setColumns(10);
		username.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		//PASSWORD Field
		password = new JPasswordField();
		password.setBounds(870 + insets.left, 375 + insets.top, 167, 33);
		frame.getContentPane().add(password);
		password.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				password.setBorder(BorderFactory.createLineBorder(Color.red, 2));
			}
		});
		password.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				password.setBorder(BorderFactory.createLineBorder(new Color(255,255,255), 1));
			}
		});
		password.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		
		JButton btnNewButton = new JButton("دخول");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setFont(new Font("Mohammad Laha", Font.PLAIN, 17));
		btnNewButton.setBounds(872, 421, 89, 33);
		frame.getContentPane().add(btnNewButton);
		JLabel label = new JLabel("");
		label.setBorder(BorderFactory.createRaisedBevelBorder());
		Dimension size = label.getPreferredSize();
		label.setBounds(852, 322,
	             318, 168);
		frame.getContentPane().add(label);
		
		//JLabel label = new JLabel("");
		//label.setBorder(BorderFactory.createRaisedBevelBorder());
		//label.setBounds(1188, 280, 361, 174);
		//frame.getContentPane().add(label);
		final JOptionPane optionPane = new JOptionPane();
		Toolkit toolkit =  Toolkit.getDefaultToolkit ();
		Dimension dim = toolkit.getScreenSize();
		int width = (int) dim.getWidth();
		int height = (int) dim.getHeight();
	
		final JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setIcon(new ImageIcon("./src/edu/utils/carinterior.jpg"));
		lblNewLabel_2.setBounds(0, 0, width, height);
		frame.getContentPane().add(lblNewLabel_2);
		
		UIManager.put("OptionPane.font", new Font("Mohammad Laha", Font.BOLD, 50));	
		final JLabel lblNewLabel_msg = new JLabel("الرجاء التثبت من البيانات");
		lblNewLabel_msg.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel_msg.setAlignmentX(SwingConstants.RIGHT);
		final ImageIcon stopicon = new ImageIcon("./src/edu/utils/errors/stopicon.png");
		lblNewLabel_msg.setFont(new Font("MO_Nawel",Font.CENTER_BASELINE,18));
		lblNewLabel_msg.setForeground(Color.red);
		//lblNewLabel_msg.setIcon(stopicon);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDao userdao = new UserDao();
				 UIManager UI=new UIManager();
				 UI.put("OptionPane.background", Color.white);
				 UI.put("Panel.background", Color.white);
				 
				 if (userdao.authentification(username.getText(), password.getText())) {
				frame.dispose();
				Home window = new Home(username.getText());
				window.getFrame1().setVisible(true);
				} 
				else {
					//lblNewLabel_3.setEnabled(true);
					//optionPane.showMessaْgeDialog(null,lblNewLabel_msg,"Ouuups",optionPane.WARNING_MESSAGE);
 					 JOptionPane.showMessageDialog(null,lblNewLabel_msg,"",JOptionPane.INFORMATION_MESSAGE,stopicon);

			 	}

			}
		});
	}
}
