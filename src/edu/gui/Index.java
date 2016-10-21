package edu.gui;

import java.applet.Applet;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import java.awt.Button;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import com.sun.tools.javac.util.Warner;

import edu.dao.classes.UserDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Index {

	private JFrame frame;
	private final JLabel lblNewLabel = new JLabel("مرحبا بكم");
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
		JLabel lblNewLabel_1 = new JLabel("مرحبا بكم");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(220, 20, 60));
		//lblNewLabel_1.setFont(new Font("Arabic Typesetting", Font.BOLD, 12));
		lblNewLabel_1.setBounds(1029, 85, 352, 115);
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
		label_1.setBounds(1280, 286, 192, 33);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("اسم المستخدم");
		label_2.setFont(new Font("MO_Nawel", Font.BOLD, 20));
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(1388, 327, 94, 33);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("كلمة العبور");
		label_3.setFont(new Font("MO_Nawel", Font.BOLD, 20));
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(1367, 368, 115, 33);
		frame.getContentPane().add(label_3);
		
		username.setBounds(1211, 330, 167, 33);
		frame.getContentPane().add(username);
		username.setColumns(10);
		username.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		//PASSWORD Field
		password = new JPasswordField();
		password.setBounds(1211, 371, 167, 33);
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
		btnNewButton.setFont(new Font("Mohammad Laha", Font.PLAIN, 17));
		btnNewButton.setBounds(1211, 412, 89, 33);
		frame.getContentPane().add(btnNewButton);

		JLabel label = new JLabel("");
		label.setBorder(BorderFactory.createRaisedBevelBorder());
		label.setBounds(1188, 280, 361, 174);
		frame.getContentPane().add(label);
		final JOptionPane optionPane = new JOptionPane();
		//lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		//lblNewLabel_3.setForeground(Color.RED);
		//lblNewLabel_3.setBounds(1321, 423, 215, 14);
		//frame.getContentPane().add(lblNewLabel_3);
		//lblNewLabel_3.setEnabled(false);
		
		final JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setIcon(new ImageIcon("D:\\ESPRIT\\WEB World\\WorkSpace\\YassinSchool\\src\\edu\\utils\\carinterior.jpg"));
		lblNewLabel_2.setBounds(0, 0, 1584, 862);
		frame.getContentPane().add(lblNewLabel_2);
		
		UIManager.put("OptionPane.font", new Font("Mohammad Laha", Font.BOLD, 50));	
		final JLabel lblNewLabel_msg = new JLabel("الرجاء التثبت من البيانات");
		lblNewLabel_msg.setFont(new Font("MO_Nawel",Font.CENTER_BASELINE,23));
		lblNewLabel_msg.setForeground(Color.red);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDao userdao = new UserDao();
				System.out.println(userdao.authentification(username.getText(), password.getText()));
				if (userdao.authentification(username.getText(), password.getText())) {
				System.out.println("Utilisateur existe");
				frame.dispose();
				Home window = new Home();
				window.getFrame1().setVisible(true);
				} 
				else {
					//lblNewLabel_3.setEnabled(true);
					optionPane.showMessageDialog(null,lblNewLabel_msg,"Ouuups",optionPane.WARNING_MESSAGE);
			 	}

			}
		});
	}
}
