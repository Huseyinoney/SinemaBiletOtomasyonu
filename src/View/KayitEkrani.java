package View;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class KayitEkrani extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField mailField;
	private JTextField usernameField;
	private JTextField soyadField;
	private JTextField adField;
	private JPasswordField passwordField;
	static User user = new User();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KayitEkrani frame = new KayitEkrani();
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
	public KayitEkrani() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKayitOl = new JLabel("Kay\u0131t Olun");
		lblKayitOl.setHorizontalAlignment(SwingConstants.CENTER);
		lblKayitOl.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblKayitOl.setBounds(179, 10, 159, 70);
		contentPane.add(lblKayitOl);
		
		JLabel lblAd = new JLabel("Ad\u0131n\u0131z");
		lblAd.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAd.setBounds(10, 90, 466, 30);
		contentPane.add(lblAd);
		
		JLabel lblSoyad = new JLabel("Soyad\u0131n\u0131z");
		lblSoyad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSoyad.setBounds(10, 130, 466, 30);
		contentPane.add(lblSoyad);
		
		JLabel lblUsername = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(10, 172, 466, 30);
		contentPane.add(lblUsername);
		
		JLabel lblMail = new JLabel("Mail Adresiniz");
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMail.setBounds(10, 252, 466, 30);
		contentPane.add(lblMail);
		
		mailField = new JTextField();
		mailField.setColumns(10);
		mailField.setBounds(112, 252, 364, 30);
		contentPane.add(mailField);
		
		JLabel lblPassword_1 = new JLabel("\u015Eifre");
		lblPassword_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword_1.setBounds(10, 212, 466, 30);
		contentPane.add(lblPassword_1);
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(112, 172, 364, 30);
		contentPane.add(usernameField);
		
		soyadField = new JTextField();
		soyadField.setColumns(10);
		soyadField.setBounds(112, 130, 364, 30);
		contentPane.add(soyadField);
		
		adField = new JTextField();
		adField.setColumns(10);
		adField.setBounds(112, 90, 364, 30);
		contentPane.add(adField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(112, 212, 364, 30);
		contentPane.add(passwordField);
		
		JButton btnKaytOl = new JButton("Kay\u0131t Ol");
		btnKaytOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String passwordText = new String(passwordField.getPassword());
				if (adField.getText().length()==0||soyadField.getText().length()==0||usernameField.getText().length()==0||passwordField.getPassword().length==0||mailField.getText().length()==0) {
					JOptionPane.showMessageDialog(contentPane, "Tum alanlari doldurun", "Hata", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						boolean control = user.kayitOl(adField.getText(), soyadField.getText(), usernameField.getText(), passwordField.getText(), mailField.getText());
						if (control) {
							JOptionPane.showMessageDialog(contentPane, "Kayit Basarili.");
							AnaEkran login = new AnaEkran();
							login.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(contentPane, "Boyle bir kullanici zaten var", "Hata", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException | IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnKaytOl.setForeground(new Color(0, 153, 0));
		btnKaytOl.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnKaytOl.setBounds(317, 316, 159, 37);
		contentPane.add(btnKaytOl);	
		
		JButton btnIptal = new JButton("\u0130ptal");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaEkran anaekran;
				try {
					anaekran = new AnaEkran();
					anaekran.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnIptal.setForeground(Color.RED);
		btnIptal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnIptal.setBounds(112, 316, 159, 37);
		contentPane.add(btnIptal);
	}	
}
