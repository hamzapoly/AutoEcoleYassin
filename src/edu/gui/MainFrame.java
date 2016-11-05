package edu.gui;


	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;

	import java.awt.Font;

	import java.awt.Toolkit;

	public class MainFrame  {

		private JFrame frame;
		private JPanel panel;
		/**
		 * Create the application.
		 */
		public MainFrame() {
			initialize();
		}
		public MainFrame(JPanel panel) {
			this.panel = panel;
			initialize();
		}

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

		public void newPanel (JFrame frame1,JPanel NPanel){
			frame1.getContentPane().add(NPanel);
	      //  System.out.println("in4");
		  //frame1.setVisible(false);
		}
		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			Toolkit toolkit =  Toolkit.getDefaultToolkit ();
			Dimension dim = toolkit.getScreenSize();
			frame.getContentPane().setForeground(Color.WHITE);
			frame.getContentPane().setFont(new Font("Andalus", frame.getContentPane().getFont().getStyle(), frame.getContentPane().getFont().getSize()));
			frame.setSize(dim);
			frame.setResizable(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(panel);
			frame.setVisible(true);
		}

		public static void main(String[] args) {
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
		}
	}



