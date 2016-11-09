package edu.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import edu.dao.classes.UserDao;
import edu.entities.User;

public class InfoEdit {

	//private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel internalFrame;
	private User user;
	private UserDao userdao;
	public JLabel getinternalFrame(){
		return this.internalFrame;
	}
	public void setInternalFrame(JLabel internalFrame){
		this.internalFrame = internalFrame;
	}
	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public InfoEdit() throws IOException {
		initialize();
	}
	public InfoEdit(User user) throws IOException {
		this.user = user;
		initialize();
	}
	int round (double x) {
		return (int) Math.round(x);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize() ;
		internalFrame = new JLabel("");
		//internalFrame.setOpaque(true);
		File img = new File("./src/edu/utils/jesuis.png");
		File img1 = new File("./src/edu/utils/backinfoedit.png");
	    int type = ImageIO.read(img).getTransparency() == Transparency.OPAQUE ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
		BufferedImage sourceImage = ImageIO.read(img);
		Image thumbnail = sourceImage.getScaledInstance(round(screenSize.getWidth()*0.5), round(screenSize.getHeight()*0.8), Image.SCALE_SMOOTH);
		BufferedImage bufferedThumbnail = new BufferedImage(thumbnail.getWidth(null),
		                                                    thumbnail.getHeight(null),
		                                                    type);
		bufferedThumbnail.getGraphics().drawImage(thumbnail, 0, 0, null);
		ImageIO.write(bufferedThumbnail, "png", img1);

		
		
		//internalFrame.setBorder(new LineBorder(Color.DARK_GRAY, 6));
		//internalFrame.setBackground(new Color(0,155,255));
		internalFrame.setIcon(new ImageIcon("./src/edu/utils/backinfoedit.png"));
		//frame.getContentPane().add(internalFrame, BorderLayout.CENTER);
		internalFrame.setBounds(150, 150, round(screenSize.width*0.7), round(screenSize.height*0.8));

		JLabel lblNewLabel = new JLabel("الإسم");
		lblNewLabel.setBackground(new Color(0,155,255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Andalus", Font.PLAIN, 26));
		lblNewLabel.setBounds(internalFrame.getLocation().x+300, internalFrame.getLocation().y-80,170, 40);
		lblNewLabel.setForeground(new Color(0,155,255));
		//lblNewLabel.setBorder(new MatteBorder(4, 0, 3, 0,(Color) new Color(209,15,15)));

		internalFrame.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(internalFrame.getLocation().x, internalFrame.getLocation().y-70, 200, 26);
		textField.setText(user.getPrenom());
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Mohammad Laha", Font.PLAIN, 18));
		textField.setBorder(BorderFactory.createLineBorder(Color.gray, 1));


		internalFrame.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("اللقب");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Andalus", Font.PLAIN, 26));
		label.setBounds(lblNewLabel.getLocation().x, lblNewLabel.getLocation().y+60,170, 26);
		label.setForeground(new Color(0,155,255));
		//label.setBorder(new MatteBorder(2, 0, 1, 0,(Color) new Color(225,23,23)));

		internalFrame.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setText(user.getNom());
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Mohammad Laha", Font.PLAIN, 18));
		textField_1.setBounds(textField.getLocation().x, textField.getLocation().y+60, 200, 26);
		textField_1.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		internalFrame.add(textField_1);
		
		JLabel lblTraduire = new JLabel("البريد الإلكتروني");
		lblTraduire.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTraduire.setFont(new Font("Andalus", Font.PLAIN, 26));
		lblTraduire.setBounds(label.getLocation().x, label.getLocation().y+60,170, 26);
		//lblTraduire.setBorder(new MatteBorder(1, 1,1 ,1, (Color) new Color(244,26,26)));
		lblTraduire.setForeground(new Color(0,155,255));

		internalFrame.add(lblTraduire);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setText(user.getEmail());
		textField_2.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);

		textField_2.setBounds(textField_1.getLocation().x, textField_1.getLocation().y+60, 200, 26);
		internalFrame.add(textField_2);
		
		JLabel label_1 = new JLabel("اسم الحساب");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Andalus", Font.PLAIN, 26));
		label_1.setBounds(lblTraduire.getLocation().x, lblTraduire.getLocation().y+60,170, 26);
		//label_1.setBorder(new MatteBorder(3, 0, 4, 0,(Color) new Color(251,69,69)));
		label_1.setForeground(new Color(0,155,255));

		internalFrame.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setText(user.getLogin());
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("", Font.PLAIN,18));
		textField_3.setBorder(BorderFactory.createLineBorder(Color.gray, 1));


		textField_3.setBounds(textField_2.getLocation().x, textField_2.getLocation().y+60, 200, 26);
		internalFrame.add(textField_3);
		
		JButton btnNewButton = new JButton("تأكيد");
		btnNewButton.setFont(new Font("Aldhabi", Font.BOLD, 27));
		btnNewButton.setBounds(textField_3.getLocation().x-100, textField_3.getLocation().y+30, 99, 34);
		/*btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if verif(textField.getText()) {
					if verif(textField_1.getText()) {
						if verif(textField_2.getText()) {
							if verif(textField_3.getText()) {
								user.setNom(textField.getText());
								user.setPrenom(textField_1.getText());
								user.setEmail(textField_2.getText());
								user.setLogin(textField_3.getText());
								userdao.updateUserInfo(user);
							} else throw  ("")
						}
					}
				}
				user.setNom(textField.getText());
				user.setPrenom(textField_1.getText());
				user.setEmail(textField_2.getText());
				user.setLogin(textField_3.getText());
			}
		});*/
		internalFrame.add(btnNewButton);
	}
}
