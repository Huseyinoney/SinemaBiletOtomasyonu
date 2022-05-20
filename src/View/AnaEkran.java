package View;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.DBConnection;
import Model.Admin;
import Model.Film;
import Model.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class AnaEkran extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DBConnection connection = new DBConnection();
	private JTextField txtUsername;
	private JPasswordField passwordUser;
	private JTextField textAdmin;
	private JPasswordField passwordAdmin;
	static User user = new User();
	static Admin admin = new Admin();
	static Film film = new Film();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaEkran frame = new AnaEkran();
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
	public AnaEkran() throws IOException{
		setResizable(false);
		setTitle("Sinema Bilet Otomasyonu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sinema Bilet Otomasyonu");
		lblNewLabel.setBounds(100, 25, 300, 32);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Banner", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 89, 466, 264);
		contentPane.add(tabbedPane);
		
		JPanel userPanel = new JPanel();
		tabbedPane.addTab("Kullanýcý Giriþi", null, userPanel, null);
		userPanel.setLayout(null);
		
		JLabel lbl_user = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lbl_user.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_user.setBounds(30, 35, 92, 34);
		lbl_user.setHorizontalAlignment(SwingConstants.CENTER);
		userPanel.add(lbl_user);
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("");
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsername.setBounds(144, 36, 166, 34);
		userPanel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lbl_password = new JLabel("\u015Eifre");
		lbl_password.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_password.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_password.setBounds(30, 105, 92, 34);
		userPanel.add(lbl_password);
		
		passwordUser = new JPasswordField();
		passwordUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordUser.setBounds(144, 106, 166, 34);
		userPanel.add(passwordUser);
		
		JButton btnGiris = new JButton("Giri\u015F");
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtUsername.getText().length()==0||passwordUser.getPassword().length==0) {
					JOptionPane.showMessageDialog(contentPane, "Tum alanlari doldurun", "Hata", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						
						Connection con = DBConnection.DBCon();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM user WHERE username = '" + txtUsername.getText() + "' ");
						System.out.println(rs);
						if (rs.next() && passwordUser.getText().equals(rs.getString("password"))) {
								User user = new User();
								user.setAd(rs.getString("ad"));
								user.setSoyad(rs.getString("soyad"));
								user.setUserName(rs.getString("username"));
								user.setPassword(rs.getString("password"));
								user.setMail(rs.getString("mail"));
								UserEkrani giris = new UserEkrani(user);
								giris.setVisible(true);
								dispose();
						}
						else {
							JOptionPane.showMessageDialog(contentPane, "Girilen bilgiler hatali", "Hata", JOptionPane.ERROR_MESSAGE);
						}
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
 			}
		});
		btnGiris.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGiris.setBounds(144, 168, 166, 34);
		userPanel.add(btnGiris);
		
		JButton btnMisafir = new JButton("Misafir Giri\u015Fi");
		btnMisafir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MisafirEkrani giris;
				try {
					giris = new MisafirEkrani(film);
					giris.setVisible(true);
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnMisafir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMisafir.setBounds(341, 168, 92, 34);
		userPanel.add(btnMisafir);
		
		JButton btnKayit = new JButton("Kay\u0131t Ol");
		btnKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KayitEkrani giris = new KayitEkrani();
				giris.setVisible(true);
				dispose();
			}
		});
		btnKayit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnKayit.setBounds(30, 168, 92, 34);
		userPanel.add(btnKayit);
		
		JPanel adminPanel = new JPanel();
		tabbedPane.addTab("Yönetici Giriþi", null, adminPanel, null);
		adminPanel.setLayout(null);
		
		JLabel lbl_admin = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lbl_admin.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_admin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_admin.setBounds(30, 35, 92, 34);
		adminPanel.add(lbl_admin);
		
		JLabel lbl_adminpassword = new JLabel("\u015Eifre");
		lbl_adminpassword.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_adminpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_adminpassword.setBounds(30, 105, 92, 34);
		adminPanel.add(lbl_adminpassword);
		
		textAdmin = new JTextField();
		textAdmin.setToolTipText("");
		textAdmin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAdmin.setColumns(10);
		textAdmin.setBounds(144, 36, 166, 34);
		adminPanel.add(textAdmin);
		
		passwordAdmin = new JPasswordField();
		passwordAdmin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordAdmin.setBounds(144, 106, 166, 34);
		adminPanel.add(passwordAdmin);
		
		JButton btnAdmin = new JButton("Giri\u015F");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textAdmin.getText().length()==0||passwordAdmin.getPassword().length==0) {
					JOptionPane.showMessageDialog(contentPane, "Tum alanlari doldurun", "Hata", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						
						Connection con = DBConnection.DBCon();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM admin WHERE adminname = '" + textAdmin.getText() + "' ");
						if (rs.next() && passwordAdmin.getText().equals(rs.getString("password"))) {
								Admin admin = new Admin();
								admin.setAdminname(rs.getString("adminname"));
								admin.setPassword(rs.getString("password"));
								AdminEkrani adminekran = new AdminEkrani(admin);
								adminekran.setVisible(true);
								dispose();
						}
						else {
							JOptionPane.showMessageDialog(contentPane, "Girilen bilgiler hatali", "Hata", JOptionPane.ERROR_MESSAGE);
						}
					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
 			}
		});
		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdmin.setBounds(144, 168, 166, 34);
		adminPanel.add(btnAdmin);
	}
}
