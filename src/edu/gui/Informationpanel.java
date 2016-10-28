package edu.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;

public class Informationpanel {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */



	public Informationpanel() {
		initialize();
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	int round (double x) {
		return (int) Math.round(x);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println("I'm here");
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().setForeground(new Color(230, 230, 250));
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize() ;
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.getContentPane().setBackground(new Color(105, 105, 105));
		
		JLabel lblNewLabel_1 = new JLabel("بياناتى");
		lblNewLabel_1.setFont(new Font("MO_Nawel", Font.BOLD, 25));
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		double menuWidth = screenSize.getWidth()*0.1; 
		double menuHeight = screenSize.getHeight()*0.04; 
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("جدول الدروس");
		label.setFont(new Font("MO_Nawel", Font.BOLD, 25));
		label.setForeground(Color.white);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("جدول السياقة");
		label_1.setFont(new Font("MO_Nawel", Font.BOLD, 25));
		label_1.setForeground(Color.white);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("الإحصائيات");
		label_2.setFont(new Font("MO_Nawel", Font.BOLD, 25));
		label_2.setForeground(Color.white);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(label_2);
		
		final JLabel label_3 = new JLabel("");
		label_3.setHorizontalTextPosition(SwingConstants.CENTER);
		label_3.setIcon(new ImageIcon("./src/edu/utils/home.png"));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(label_3);
		label_3.addMouseListener(new MouseAdapter() {
		public void mouseClicked (MouseEvent e) {
			frame.getContentPane().setVisible(false);
			new Home().getFrame1().setVisible(true);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			label_3.setSize(label_3.getSize().width+5,label_3.getSize().height+5);
		}
		public void mouseExited(MouseEvent e) {
			label_3.setSize(label_3.getSize().width-5,label_3.getSize().height-5);
		}
		});
		
		try {
			lblNewLabel_1.setBounds(0, 0,round(menuWidth),round(menuHeight));
			label.setBounds(lblNewLabel_1.getLocation().x+round(menuWidth)+3,0,round(menuWidth),round(menuHeight));
			label_1.setBounds(label.getLocation().x+round(menuWidth)+3, 0,round(menuWidth),round(menuHeight));
			label_2.setBounds(label_1.getLocation().x+round(menuWidth)+3,0,round(menuWidth),round(menuHeight));
			label_3.setBounds(label_2.getLocation().x+round(menuWidth)+3,0,round(menuWidth),round(menuHeight)*4);

			Canvas canvas = new Canvas();
			canvas.setBackground(new Color(220, 20, 60));
			canvas.setBounds(0, 0, 264, screenSize.height);
			//frame.getContentPane().add(canvas);
			MyPannel Pannel = new MyPannel();
			Pannel.setBackground(new Color(105, 105, 105));
			Pannel.setSize(screenSize);
			frame.getContentPane().add(Pannel);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/*public static void main(String[] args) {
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
	}*/
}
