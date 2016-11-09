package edu.gui;


	import java.awt.Dimension;

	import javax.swing.JFrame;
	import javax.swing.JPanel;

import edu.dao.classes.UserDao;

import java.awt.Font;

	import java.awt.Toolkit;

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
		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			
			frame = new JFrame(userdao.findUserByLogin(login).getNom()+" "+userdao.findUserByLogin(login).getPrenom());
			Toolkit toolkit =  Toolkit.getDefaultToolkit ();
			Dimension dim = toolkit.getScreenSize();
			//frame.getContentPane().setForeground(Color.WHITE);
			frame.getContentPane().setFont(new Font("Andalus", frame.getContentPane().getFont().getStyle(), frame.getContentPane().getFont().getSize()));
			frame.setSize(dim);
			frame.setResizable(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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



