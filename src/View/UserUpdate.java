package View;

//import java.awt.BorderLayout;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserUpdate extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField adField;
	private JTextField soyadField;
	private JTextField usernameField;
	private JTextField mailField;
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bilgilerinizi D\u00FCzenleyin");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 40, 466, 30);
		contentPane.add(lblNewLabel);
		
		adField = new JTextField();
		adField.setBounds(112, 98, 364, 30);
		contentPane.add(adField);
		adField.setColumns(10);
		
		soyadField = new JTextField();
		soyadField.setColumns(10);
		soyadField.setBounds(112, 138, 364, 30);
		contentPane.add(soyadField);
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(112, 180, 364, 30);
		contentPane.add(usernameField);
		
		mailField = new JTextField();
		mailField.setColumns(10);
		mailField.setBounds(112, 260, 364, 30);
		contentPane.add(mailField);
		
		JLabel lblAd = new JLabel("Ad\u0131n\u0131z");
		lblAd.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAd.setBounds(10, 98, 466, 30);
		contentPane.add(lblAd);
		
		JLabel lblSoyad = new JLabel("Soyad\u0131n\u0131z");
		lblSoyad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSoyad.setBounds(10, 138, 466, 30);
		contentPane.add(lblSoyad);
		
		JLabel lblUsername = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(10, 180, 466, 30);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("\u015Eifre");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(10, 220, 466, 30);
		contentPane.add(lblPassword);
		
		JLabel lblMail = new JLabel("Mail Adresiniz");
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMail.setBounds(10, 260, 466, 30);
		contentPane.add(lblMail);
		
		passwordUser = new JPasswordField();
		passwordUser.setBounds(112, 220, 364, 30);
		contentPane.add(passwordUser);
		
		btnKaydet = new JButton("Kaydet");
		btnKaydet.setForeground(new Color(0, 153, 0));
		btnKaydet.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnKaydet.setBounds(317, 316, 159, 37);
		contentPane.add(btnKaydet);
		
		btnIptal = new JButton("\u0130ptal");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIptal.setForeground(Color.RED);
		btnIptal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnIptal.setBounds(112, 317, 159, 37);
		contentPane.add(btnIptal);
	}

}
