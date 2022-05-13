package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class UserUpdate extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JPasswordField passwordUser;
	private JButton btnKaydet;
	private JButton btnIptal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserUpdate frame = new UserUpdate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bilgilerinizi D\u00FCzenleyin");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 12, 466, 30);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(112, 52, 364, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(112, 92, 364, 30);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(112, 134, 364, 30);
		contentPane.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(112, 214, 364, 30);
		contentPane.add(textField_4);
		
		JLabel lblAd = new JLabel("Ad\u0131n\u0131z");
		lblAd.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAd.setBounds(10, 52, 466, 30);
		contentPane.add(lblAd);
		
		JLabel lblSoyad = new JLabel("Soyad\u0131n\u0131z");
		lblSoyad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSoyad.setBounds(10, 92, 466, 30);
		contentPane.add(lblSoyad);
		
		JLabel lblUsername = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(10, 134, 466, 30);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("\u015Eifre");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(10, 174, 466, 30);
		contentPane.add(lblPassword);
		
		JLabel lblMail = new JLabel("Mail Adresiniz");
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMail.setBounds(10, 214, 466, 30);
		contentPane.add(lblMail);
		
		passwordUser = new JPasswordField();
		passwordUser.setBounds(112, 174, 364, 30);
		contentPane.add(passwordUser);
		
		btnKaydet = new JButton("Kaydet");
		btnKaydet.setForeground(new Color(0, 153, 0));
		btnKaydet.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnKaydet.setBounds(317, 278, 159, 37);
		contentPane.add(btnKaydet);
		
		btnIptal = new JButton("\u0130ptal");
		btnIptal.setForeground(Color.RED);
		btnIptal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnIptal.setBounds(112, 278, 159, 37);
		contentPane.add(btnIptal);
	}

}
