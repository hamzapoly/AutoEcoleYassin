package edu.gui;
import edu.dao.classes.*;
import edu.entities.User;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;


import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Transparency;
import javax.swing.border.EtchedBorder;

import javax.swing.border.CompoundBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Home {

	private MainFrame frame1;
	private String username;
	private JPanel mainP;
	private UserDao userdao;
	private int snd;

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
					//window.frame1.setVisible(true);
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
	public Home(UserDao userdao,String username,MainFrame HFrame,int snd){
		this.snd = snd;
		this.userdao=userdao;
		this.username = username;
		this.frame1=HFrame;
		initialize();
	}
	public MainFrame getFrame1() {
		return frame1;
	}

	public void setFrame1(MainFrame frame1) {
		this.frame1 = frame1;
	}
	
	public JPanel getmainP() {
		return mainP;
	}

	public void setmainP(JPanel mainP) {
		this.mainP = mainP;
	}
	
	public static BufferedImage resizeImage (BufferedImage image, int areaWidth, int areaHeight) {
	    float scaleX = (float) areaWidth / image.getWidth();
	    float scaleY = (float) areaHeight / image.getHeight();
	    float scale = Math.min(scaleX, scaleY);
	    int w = Math.round(image.getWidth() * scale);
	    int h = Math.round(image.getHeight() * scale);

	    int type = image.getTransparency() == Transparency.OPAQUE ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;

	    boolean scaleDown = scale < 1;

	    if (scaleDown) {
	        // multi-pass bilinear div 2
	        int currentW = image.getWidth();
	        int currentH = image.getHeight();
	        BufferedImage resized = image;
	        while (currentW > w || currentH > h) {
	            currentW = Math.max(w, currentW / 2);
	            currentH = Math.max(h, currentH / 2);

	            BufferedImage temp = new BufferedImage(currentW, currentH, type);
	            Graphics2D g2 = temp.createGraphics();
	            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	            g2.drawImage(resized, 0, 0, currentW, currentH, null);
	            g2.dispose();
	            resized = temp;
	        }
	        return resized;
	    } else {
	        Object hint = scale > 2 ? RenderingHints.VALUE_INTERPOLATION_BICUBIC : RenderingHints.VALUE_INTERPOLATION_BILINEAR;

	        BufferedImage resized = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2 = resized.createGraphics();
	        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
	        g2.drawImage(image, 0, 0, w, h, null);
	        g2.dispose();
	        return resized;
	    }
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame1 = new JFrame("Bonjour");
		//frame1.getContentPane().setForeground(Color.WHITE);
		//frame1.getContentPane().setFont(new Font("Andalus", frame1.getContentPane().getFont().getStyle(), frame1.getContentPane().getFont().getSize()));
		//frame1.setSize(1600, 900);
		//frame1.setResizable(true);
		//frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame1.getContentPane().setLayout(new CardLayout(0, 0));
		Color borderc = new Color(79, 139, 156);
		/*UIManager UI = new UIManager();
		UIManager.put("OptionPane.background",borderc);
		UIManager.put("Panel.background", borderc);*/
		
		Toolkit toolkit =  Toolkit.getDefaultToolkit ();
		final Dimension dim = toolkit.getScreenSize();
		int width = (int) dim.getWidth();
		int height = (int) dim.getHeight();
		
		
		final JPanel panel = new JPanel();
		//panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 0, 128), new Color(255, 0, 255), new Color(0, 255, 255), new Color(0, 191, 255)));
		panel.setBackground(Color.WHITE);
		panel.setForeground(new Color(230, 230, 250));
		final Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR); 
		
		//frame1.getContentPane().add(panel, "name_1483415348374009");
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
				label.setCursor(cursor);
				label.setSize(125, 125);
			}
			public void mouseExited(MouseEvent e) {
				label.setSize(120, 120);
				label.setCursor(Cursor.getDefaultCursor());
			}
		});

		label.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.RAISED, null, null)));
		label.setIcon(new ImageIcon("./src/edu/utils/tests1.png"));
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setBackground(borderc);
		label.setBounds(732 , 26, 120, 120);
		panel.add(label);

		final User user = userdao.findUserByLogin(username);
		final JLabel label_6 = new JLabel("");
		label_6.setBounds(round(dim.width*0.88), 200, 134, 88);
		label_6.setHorizontalTextPosition(JLabel.CENTER);
		label_6.setVerticalTextPosition(JLabel.CENTER);
		label_6.setText(user.getPrenom()+" "+user.getNom());
		label_6.setFont(new Font("Simplified Arabic", Font.PLAIN, 30));
		//panel.add(label_6);
	
		final JButton label_1 = new JButton("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_1.setCursor(cursor);
				label_1.setSize(125, 125);
			}
			public void mouseExited(MouseEvent e) {
				label_1.setSize(120, 120);
				label_1.setCursor(Cursor.getDefaultCursor());

			}
			public void mouseClicked(MouseEvent e) {
				try {
					panel.removeAll();
					new Informationpanel(userdao,user, frame1);
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
		
		
		final JLabel close= new JLabel("");
		final JLabel close1= new JLabel("");

		close.setLocation(dim.width-50 , 20);
		close1.setLocation(dim.width-50 , 20);

		BufferedImage closeI = null;

		try {
			closeI = ImageIO.read(new File("./src/edu/utils/exitFullscreen.png"));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		closeI = resizeImage(closeI, 50, 20);
		close.setSize(closeI.getWidth(),closeI.getHeight());
		final ImageIcon imgclose = new ImageIcon(closeI);
		close.setIcon(imgclose);
		panel.add(close);
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				panel.setCursor(cursor);
				BufferedImage closeI1 = null;
				try {
				closeI1 = ImageIO.read(new File("./src/edu/utils/exitFullscreen1.png"));
				} catch (IOException e3) {
					// TODO: handle exception
					e3.printStackTrace();
				}
				closeI1 = resizeImage(closeI1, 55, 25);
				ImageIcon imgclose1 = new ImageIcon(closeI1);
				close1.setIcon(imgclose1);
				close1.setSize(closeI1.getWidth(),closeI1.getHeight());
				panel.remove(close);
				panel.add(close1, 5);
				panel.repaint();
				close1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						panel.setCursor(Cursor.getDefaultCursor());
						panel.remove(close1);
						panel.add(close,5);
						panel.repaint();
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						frame1.getFrame().dispose();
					}
				});
			}
			
	
		});
		final JButton label_2 = new JButton("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label_2.setSize(125, 125);
				label_2.setCursor(cursor);

			}
			public void mouseExited(MouseEvent e) {
				label_2.setSize(120, 120);
				label_2.setCursor(Cursor.getDefaultCursor());

			}
		});
		label_2.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.RAISED, null, null)));
		label_2.setIcon(new ImageIcon("./src/edu/utils/cours1.png"));
		label_2.setBackground(borderc);
		label_2.setBounds(905 , 26, 120, 120);
		panel.add(label_2);
		
		
		final JLabel lblNewLabel_2 = new JLabel("");
		File newI = new File("./src/edu/utils/HomeBackground.png");
		BufferedImage newIBuff;
		try {
			newIBuff = ImageIO.read(newI);
			BufferedImage NewIm = resizeImage(newIBuff,round(dim.getWidth()), round(dim.getHeight()));
			lblNewLabel_2.setIcon(new ImageIcon(NewIm));
			panel.add(lblNewLabel_2);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		//lblNewLabel_2.setIcon(new ImageIcon(newIBuff.));
		lblNewLabel_2.setHorizontalTextPosition(JLabel.CENTER);
		lblNewLabel_2.setVerticalAlignment(JLabel.CENTER);
		lblNewLabel_2.setHorizontalAlignment(JLabel.CENTER);
		
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
		
		BufferedImage imageB = null;
		JLabel labelIcon = new JLabel();
		try {
			imageB = ImageIO.read(new File("./src/edu/utils/iconFrame1.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		labelIcon.setBounds(round(dim.width*0.01) , 10, 60, 60);
		imageB = resizeImage(imageB, 60, 60);
		labelIcon.setIcon(new ImageIcon(imageB));
		panel.add(labelIcon,5);
		
		if (snd == 1){
		try {
			
			AudioInputStream startUp = AudioSystem.getAudioInputStream(new File("./src/edu/utils/Sounds/CarStarting.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(startUp);
			clip.start();

		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}

		
		this.mainP = panel;
		this.frame1.newPanel(panel);
		//this.frame1.getFrame().getContentPane().add(panel);
		frame1.getFrame().setVisible(true);
	}
		
	private int round(double d) {
		// TODO Auto-generated method stub
		return (int) Math.round(d);
	}
}
