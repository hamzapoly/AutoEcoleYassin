package edu.gui;


	import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.dao.classes.UserDao;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

	public class MainFrame  {

		private JFrame frame;
		private JPanel panel;
		private UserDao userdao;
		private String login;
		/**
		 * Create the application.
		 */
		public MainFrame(UserDao userdao,String login) {
			this.login = login;
			this.userdao = userdao;
			initialize();
		}
		/*public MainFrame(JPanel panel) {
			this.panel = panel;
			initialize();
		}*/

		public JFrame getFrame() {
			return frame;
		}

		public void setFrame(JFrame frame) {
			this.frame = frame;
		}
		
		
		public JPanel getPanel() {
			return panel;
		}

		public void setPanel(JPanel panel) {
			this.panel = panel;
		}

		public void newPanel (JPanel NPanel){
			frame.getContentPane().removeAll();
			frame.getContentPane().add(NPanel);
			frame.getContentPane().repaint();
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
			
			frame = new JFrame(userdao.findUserByLogin(login).getPrenom()+" "+userdao.findUserByLogin(login).getNom());
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			frame.setUndecorated(true);
			Toolkit toolkit =  Toolkit.getDefaultToolkit ();
			Dimension dim = toolkit.getScreenSize();
			//frame.getContentPane().setForeground(Color.WHITE);
			frame.getContentPane().setFont(new Font("Andalus", frame.getContentPane().getFont().getStyle(), frame.getContentPane().getFont().getSize()));
			frame.setSize(dim);
			frame.setResizable(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			BufferedImage imageB = null;
			try{
			imageB = ImageIO.read(new File("./src/edu/utils/iconFrame.png"));
			imageB = resizeImage(imageB, 200, 200);
			} catch (IOException e) {
				// TODO: handle exception
				e.getMessage();
			}
			frame.setIconImage(imageB);
			Window window = new Window(frame);
			window.setIconImage(imageB);;
		}

		/*public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MainFrame window = new MainFrame();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}*/
	}



