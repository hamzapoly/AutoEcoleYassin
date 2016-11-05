package edu.gui;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;

import javax.script.ScriptException;
import javax.swing.ImageIcon;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.border.MatteBorder;

import com.sun.tools.internal.ws.processor.generator.GeneratorConstants;

import edu.entities.User;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class Informationpanel {

	private MainFrame frame1;
	private User user;
	private JPanel InfoP;

	/**
	 * Launch the application.
	 */

	public Informationpanel() {
		initialize();
	}
	
	public Informationpanel(User user,MainFrame frame) {
		this.frame1 = frame;
		this.user = user;
		initialize();
	}
	public MainFrame getFrame() {
		System.out.println("Je t'aimes");
		return frame1;
	}

	public void setFrame(MainFrame frame) {
		this.frame1 = frame;
	}
	public JPanel getInfoP() {
		return InfoP;
	}

	public void setInfoP(JPanel infoP) {
		InfoP = infoP;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	int round (double x) {
		return (int) Math.round(x);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * 
	 */
	private void initialize() {
		/*JFrame frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().setForeground(new Color(230, 230, 250));
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);*/
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize() ;

		final JPanel InfoP = new JPanel();
		InfoP.setSize(screenSize);
		InfoP.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("الإحصائيات");
		lblNewLabel_1.setBorder(new MatteBorder(0, 2, 0, 0, Color.white));
		//lblNewLabel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.GRAY));
		lblNewLabel_1.setFont(new Font("Aldhabi", Font.PLAIN, 36));
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("./src/edu/utils/statistics.png"));
		double menuWidth = screenSize.getWidth()*0.16; 
		double menuHeight = screenSize.getHeight()*0.08; 
		InfoP.add(lblNewLabel_1);
		
		JLabel label = new JLabel("جدول السياقة");
		label.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(0, 0, 255)));
		//label.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.GRAY));
		label.setFont(new Font("Aldhabi", Font.PLAIN, 36));
		label.setForeground(Color.white);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("./src/edu/utils/calcond.png"));
		InfoP.add(label);
		
		JLabel label_1 = new JLabel("جدول الدروس");
		label_1.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(0, 0, 255)));
		//label_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.GRAY));
		label_1.setFont(new Font("Aldhabi", Font.PLAIN, 36));
		label_1.setForeground(Color.white);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon("./src/edu/utils/calcode.png"));
		InfoP.add(label_1);
		
		JLabel label_2 = new JLabel("بياناتى");
		label_2.setBorder(new MatteBorder(0, 2, 0, 2, (Color) new Color(0, 0, 255)));
		//label_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.GRAY));
		label_2.setFont(new Font("Aldhabi",Font.PLAIN,36));
		label_2.setForeground(Color.white);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setIcon(new ImageIcon("./src/edu/utils/infoperso1.png"));
		InfoP.add(label_2);

		//Home ICON
		final JLabel label_3 = new JLabel("");
		label_3.setHorizontalTextPosition(SwingConstants.CENTER);
		label_3.setIcon(new ImageIcon("./src/edu/utils/home.png"));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		InfoP.add(label_3);
		
		//ProfilePIC
		JLabel labelpic = new JLabel("");
		labelpic.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.RED, Color.BLACK));
		labelpic.setIcon(new ImageIcon(user.getProfilepic()));
		labelpic.setBounds(round(screenSize.width*0.75), round(screenSize.height*0.12), round(screenSize.width*0.09), round(screenSize.height*0.21));
		labelpic.setFont(new Font("Aldhabi",Font.PLAIN,36));
		labelpic.setForeground(Color.white);
		labelpic.setHorizontalAlignment(SwingConstants.CENTER);
		InfoP.add(labelpic);
		final Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR); 
		//HomeICon action
		label_3.addMouseListener(new MouseAdapter() {
		public void mouseClicked (MouseEvent e) {
				InfoP.removeAll();					
				new Home(user.getLogin(),frame1);
				
		}
				public void mouseEntered(MouseEvent e) {
					InfoP.setCursor(cursor);
		     		}
				public void mouseExited(MouseEvent e) {
					InfoP.setCursor(Cursor.getDefaultCursor());
				}
			
		});
		
		try {
			lblNewLabel_1.setBounds(4, 5,round(menuWidth),round(menuHeight));
			label.setBounds(lblNewLabel_1.getLocation().x+round(menuWidth)+90,5,round(menuWidth),round(menuHeight));
			label_1.setBounds(label.getLocation().x+10+round(menuWidth)+90, 5,round(menuWidth),round(menuHeight));
			label_2.setBounds(label_1.getLocation().x+round(menuWidth)+90,5,round(menuWidth),round(menuHeight));
			label_3.setBounds(label_2.getLocation().x+round(menuWidth),5,round(menuWidth),round(menuHeight)*2);
			
			Canvas canvas = new Canvas();
			canvas.setBackground(new Color(220, 20, 60));
			canvas.setBounds(0, 0, 264, screenSize.height);
			JLabel label_4 = new JLabel("");
			label_4.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.RED));
			label_4.setOpaque(true);
			label_4.setBounds(0, 0, screenSize.width,round(screenSize.height*0.1));
			//label_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.GRAY));
			Color newpink = new Color(227,17, 18);
			label_4.setBackground(Color.DARK_GRAY);
			InfoP.add(label_4);
			//this.setInfoP(InfoP);
			frame1.newPanel(InfoP);
			frame1.getFrame().setVisible(true);
			//frame.getContentPane().add(InfoP);
			//frame.getContentPane().add(canvas);
			/*MyPannel Pannel = new MyPannel();
			Pannel.setBackground(new Color(105, 105, 105));
			Pannel.setSize(screenSize);
			frame.getContentPane().add(Pannel);*/
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
					frame.getContentPane().setForeground(new Color(230, 230, 250));
					frame.setBackground(Color.red);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
					frame.getContentPane().setBackground(Color.red);
					User user = new User();
					user.setLogin("BYassin");
					//frame.getContentPane().add(new Informationpanel(user));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
