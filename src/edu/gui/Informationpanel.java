package edu.gui;


import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.border.MatteBorder;

import org.apache.commons.io.FileUtils;


import edu.dao.classes.UserDao;
import edu.entities.User;
import javax.swing.border.EtchedBorder;

public class Informationpanel {

	private MainFrame frame1;
	private User user;
	private UserDao userdao;
	private JPanel InfoP;

	/**
	 * Launch the application.
	 */

	public Informationpanel() {
		initialize();
	}
	
	public Informationpanel(UserDao userdao,User user,MainFrame frame) {
		this.userdao = userdao;
		this.frame1 = frame;
		this.user = user;
		initialize();
	}
	public MainFrame getFrame() {
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
	File imageresize (File src,File dest,int width,int height) throws IOException{
	    int type = ImageIO.read(src).getTransparency() == Transparency.OPAQUE ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
		BufferedImage sourceImage = ImageIO.read(src);
		Image thumbnail = sourceImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage bufferedThumbnail = new BufferedImage(thumbnail.getWidth(null),
		                                                    thumbnail.getHeight(null),
		                                                    type);
		bufferedThumbnail.getGraphics().drawImage(thumbnail, 0, 0, null);
		ImageIO.write(bufferedThumbnail, "png", dest);
		return dest;

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
	
	
	ImageIcon changePic(JLabel labelpic) {
		JFileChooser fileChooser = new JFileChooser();	
		fileChooser.setCurrentDirectory(new File("./src"));
		int returnValue = fileChooser.showOpenDialog(null);
		File dest = new File("./src/edu/utils/"+user.getLogin()+"/profile.png");
        if (returnValue == JFileChooser.APPROVE_OPTION) {
	       }
          File selectedFile = fileChooser.getSelectedFile();
			try {
				FileUtils.copyFile(selectedFile, dest);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				File newI = new File(user.getProfilepic());
				BufferedImage newIBuff = ImageIO.read(newI);
			//	labelpic.setIcon(new ImageIcon(ImageIO.read(newI)));
			//	File NewIm = imageresize(newI, newI, labelpic.getWidth(), labelpic.getHeight());
			//	labelpic.setIcon(new ImageIcon(ImageIO.read(NewIm)));
				BufferedImage NewIm = resizeImage(newIBuff, labelpic.getWidth(), labelpic.getHeight());
				ImageIcon eNewImIcon = new ImageIcon(NewIm);
				return eNewImIcon;
				
			} catch (IOException e1) {
	// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}

	}
	/**
	 * Initialize the contents of the frame.
	 */
	/**
	 * @throws IOException 
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
		final Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR); 

		final JPanel InfoP = new JPanel();
		//InfoP.setBackground(new Color(240,240,242));
		InfoP.setSize(screenSize);
		InfoP.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("الإحصائيات");
		lblNewLabel_1.setBorder(new MatteBorder(0, 2, 0, 2,(Color) new Color(0, 0, 255)));
		//lblNewLabel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.GRAY));
		lblNewLabel_1.setFont(new Font("Aldhabi", Font.PLAIN, 36));
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("./src/edu/utils/statistics.png"));
		double menuWidth = screenSize.getWidth()*0.19; 
		double menuHeight = screenSize.getHeight()*0.08; 
		
		/*JLabel label = new JLabel("جدول السياقة");
		label.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(0, 0, 255)));
		//label.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.GRAY));
		label.setFont(new Font("Aldhabi", Font.PLAIN, 36));
		label.setForeground(Color.white);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("./src/edu/utils/calcond.png"));
		InfoP.add(label);*/
		
		JLabel label_1 = new JLabel("جدول الدروس");
		label_1.setBorder(new MatteBorder(0, 2, 0, 2, (Color) new Color(0, 0, 255)));
		//label_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.GRAY));
		label_1.setFont(new Font("Aldhabi", Font.PLAIN, 36));
		label_1.setForeground(Color.white);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon("./src/edu/utils/calcode.png"));
		
		JLabel label_2 = new JLabel("بياناتى");
		label_2.setBorder(new MatteBorder(0, 2, 0, 2, (Color) new Color(0, 0, 255)));
		//label_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.GRAY));
		label_2.setFont(new Font("Aldhabi",Font.PLAIN,36));
		label_2.setForeground(Color.white);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setIcon(new ImageIcon("./src/edu/utils/infoperso1.png"));
		//Information Action
		label_2.addMouseListener(new MouseAdapter() {
		public void mouseClicked (MouseEvent e) {
					try {
					InfoP.add(new InfoEdit(user, userdao).getinternalFrame());
					} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}			
				InfoP.repaint();
				}
				public void mouseEntered(MouseEvent e) {
				InfoP.setCursor(cursor);
				}
				public void mouseExited(MouseEvent e) {
					InfoP.setCursor(Cursor.getDefaultCursor());
				}
			
		});

		//Home ICON
		final JLabel label_3 = new JLabel("");
		label_3.setHorizontalTextPosition(SwingConstants.CENTER);
		label_3.setIcon(new ImageIcon("./src/edu/utils/home.png"));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);

		//ProfilePIC
		final JLabel labelpic = new JLabel("");
		labelpic.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.DARK_GRAY, Color.LIGHT_GRAY));
		labelpic.setBounds(round(screenSize.width*0.75), round(screenSize.height*0.12), round(screenSize.width*0.09), round(screenSize.height*0.21));
		labelpic.setFont(new Font("Aldhabi",Font.PLAIN,36));
		labelpic.setForeground(Color.white);
		labelpic.setOpaque(true);
		labelpic.setBackground(Color.WHITE);
		labelpic.setHorizontalAlignment(SwingConstants.CENTER);

		File newI = new File(user.getProfilepic());
		BufferedImage newIBuff;
		try {
			newIBuff = ImageIO.read(newI);
			BufferedImage NewIm = resizeImage(newIBuff, labelpic.getWidth(), labelpic.getHeight());
			labelpic.setIcon(new ImageIcon(NewIm));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		final JLabel changepic = new JLabel();
		changepic.setBounds(labelpic.getLocation().x+labelpic.getWidth()-32,labelpic.getLocation().y+labelpic.getHeight()-16 , round(labelpic.getWidth()*0.4), round(labelpic.getHeight()*0.4));
	
		changepic.setIcon(new ImageIcon("./src/edu/utils/editpic.png"));
		changepic.setToolTipText("إضغط هنا لتغيير الصورة");

		changepic.addMouseListener(new MouseAdapter() {
			public void mouseClicked (MouseEvent e) {
							labelpic.setIcon(changePic(labelpic));
							InfoP.remove(labelpic);
							InfoP.add(labelpic);
							InfoP.validate();
							InfoP.repaint();
							
			}
					public void mouseEntered(MouseEvent e) {
						InfoP.setCursor(cursor);
			     		}
					public void mouseExited(MouseEvent e) {
						InfoP.setCursor(Cursor.getDefaultCursor());
					}
				
			});
		
		//HomeICon action
		label_3.addMouseListener(new MouseAdapter() {
		public void mouseClicked (MouseEvent e) {
				InfoP.removeAll();					
				new Home(userdao,user.getLogin(),frame1);
				
		}
				public void mouseEntered(MouseEvent e) {
					InfoP.setCursor(cursor);
		     		}
				public void mouseExited(MouseEvent e) {
					InfoP.setCursor(Cursor.getDefaultCursor());
				}
			
		});
		
		try {
			lblNewLabel_1.setBounds(90, 5,round(menuWidth),round(menuHeight));
			//label.setBounds(lblNewLabel_1.getLocation().x+round(menuWidth)+90,5,round(menuWidth),round(menuHeight));
			label_1.setBounds(lblNewLabel_1.getLocation().x+10+round(menuWidth)+90, 5,round(menuWidth),round(menuHeight));
			label_2.setBounds(label_1.getLocation().x+10+round(menuWidth)+90,5,round(menuWidth),round(menuHeight));
			label_3.setBounds(label_2.getLocation().x+10+round(menuWidth),5,round(menuWidth),round(menuHeight)*2);
			InfoP.add(changepic);
			
			InfoP.add(label_2);
			InfoP.add(label_3);
			InfoP.add(labelpic);
			InfoP.add(lblNewLabel_1);
			InfoP.add(label_1);

			Canvas canvas = new Canvas();
			canvas.setBackground(new Color(220, 20, 60));
			canvas.setBounds(0, 0, 264, screenSize.height);
			JLabel label_4 = new JLabel("");
			label_4.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.RED));
			label_4.setOpaque(true);
			label_4.setBounds(0, 0, screenSize.width,round(screenSize.height*0.1));
			//label_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, Color.GRAY));
			//Color newpink = new Color(227,17, 18);
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
	/*public static void main(String[] args) {
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
					frame.getContentPane().add(new Informationpanel(userdao,user,new MainFrame(userdao)).getInfoP());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
}
