package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Helper.Helper;
import Model.Admin;
import Model.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SifremiUnuttumGUI extends JFrame {

	private JPanel contentPane;
	private JPasswordField fld_userPass;
	private JTextField fld_userKullaniciAdi;
	private User user = new User();
	static Admin admin = new Admin();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SifremiUnuttumGUI frame = new SifremiUnuttumGUI(admin);
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
	public SifremiUnuttumGUI(Admin admin) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_SifreDegistir = new JButton("\u015Eifre De\u011Fi\u015Ftir");
		btn_SifreDegistir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_userKullaniciAdi.getText().length()==0||fld_userPass.getText().length()==0) {
					Helper.showMsg("fill");
				}
				else {					
					try {
						boolean control = user.changeUserpassword(fld_userKullaniciAdi.getText(), fld_userPass.getText());
						if (control) {
							Helper.showMsg("sifre");
							LoginGUI login = new LoginGUI();
							login.setVisible(true);
							dispose();
						}
						else {
							Helper.showMsg("unsuccess");
						}
						
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		btn_SifreDegistir.setBounds(247, 196, 115, 23);
		contentPane.add(btn_SifreDegistir);
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131n\u0131 Giriniz:");
		lblNewLabel.setBounds(51, 86, 120, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Yeni \u015Eifreyi Giriniz:");
		lblNewLabel_1.setBounds(51, 140, 120, 23);
		contentPane.add(lblNewLabel_1);
		
		fld_userPass = new JPasswordField();
		fld_userPass.setBounds(247, 141, 115, 20);
		contentPane.add(fld_userPass);
		
		fld_userKullaniciAdi = new JTextField();
		fld_userKullaniciAdi.setColumns(10);
		fld_userKullaniciAdi.setBounds(247, 87, 115, 20);
		contentPane.add(fld_userKullaniciAdi);
		
		JButton btn_Geri = new JButton("Geri");
		btn_Geri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI login = new LoginGUI();
				login.setVisible(true);
				dispose();
			}
		});
		btn_Geri.setBounds(10, 11, 58, 21);
		contentPane.add(btn_Geri);
	}
}
