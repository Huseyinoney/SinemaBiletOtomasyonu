package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Model.Admin;
import Model.User;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
//import java.awt.Color;
//import javax.swing.ListSelectionModel;

public class AdminEkrani extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static Admin admin = new Admin();
	private JTable userTable;
	private JTextField adField;
	private JTextField soyadField;
	private JTextField usernameField;
	private JTextField mailField;
	private JPasswordField passwordField;
	private DefaultTableModel userModel = null;
	private Object[] userData = null;
	static User user = new User();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminEkrani frame = new AdminEkrani(admin);
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
	public AdminEkrani(Admin admin) throws SQLException{
		setTitle("Hos geldiniz, " + admin.getAdminname());
		
		userModel = new DefaultTableModel() {
			
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		Object[] colName = new Object[6];
		colName[0] = "Id";
		colName[1] = "Ad";
		colName[2] = "Soyad";
		colName[3] = "Kullanýcý Adý";
		colName[4] = "Þifre";
		colName[5] = "Mail";
		userModel.setColumnIdentifiers(colName);
		userData = new Object[6];
		for(int i=0;i<admin.getUserList().size();i++) {
			userData[0] = admin.getUserList().get(i).getId();
			userData[1] = admin.getUserList().get(i).getAd();
			userData[2] = admin.getUserList().get(i).getSoyad();
			userData[3] = admin.getUserList().get(i).getUserName();
			userData[4] = admin.getUserList().get(i).getPassword();
			userData[5] = admin.getUserList().get(i).getMail();
			userModel.addRow(userData);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCikis = new JButton("\u00C7\u0131k\u0131\u015F");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnaEkran anaekran = new AnaEkran();
				anaekran.setVisible(true);
				dispose();
			}
		});
		btnCikis.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCikis.setBounds(370, 9, 111, 22);
		contentPane.add(btnCikis);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 476, 343);
		contentPane.add(tabbedPane);
		
		JPanel userPanel = new JPanel();
		tabbedPane.addTab("Kullan\u0131c\u0131 Y\u00F6netim Paneli", null, userPanel, null);
		userPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 294, 252);
		userPanel.add(scrollPane);
		
		userTable = new JTable(userModel);
		scrollPane.setViewportView(userTable);
		//scrollPane.setColumnHeaderView(userTable);
		
		JLabel adLabel = new JLabel("Ad\u0131:");
		adLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		adLabel.setBounds(299, 10, 45, 13);
		userPanel.add(adLabel);
		
		JLabel soyadLabel = new JLabel("Soyad\u0131:");
		soyadLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		soyadLabel.setBounds(299, 59, 45, 13);
		userPanel.add(soyadLabel);
		
		JLabel usernameLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131:");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		usernameLabel.setBounds(299, 110, 78, 13);
		userPanel.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("\u015Eifre");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		passwordLabel.setBounds(299, 161, 45, 13);
		userPanel.add(passwordLabel);
		
		JLabel mailLabel = new JLabel("Mail Adresi");
		mailLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		mailLabel.setBounds(299, 210, 78, 13);
		userPanel.add(mailLabel);
		
		adField = new JTextField();
		adField.setBounds(299, 30, 162, 19);
		userPanel.add(adField);
		adField.setColumns(10);
		
		soyadField = new JTextField();
		soyadField.setColumns(10);
		soyadField.setBounds(299, 82, 162, 19);
		userPanel.add(soyadField);
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(299, 133, 162, 19);
		userPanel.add(usernameField);
		
		mailField = new JTextField();
		mailField.setColumns(10);
		mailField.setBounds(299, 233, 162, 19);
		userPanel.add(mailField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(299, 184, 162, 19);
		userPanel.add(passwordField);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usernameField.getText().length()==0) {
					JOptionPane.showMessageDialog(contentPane, "Alanlari doldurun", "Hata", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						boolean control = admin.deleteUser(usernameField.getText());
						if (control) {
							JOptionPane.showMessageDialog(contentPane, "Kullanici Kaldirma Basarili.");
							adField.setText(null);
							soyadField.setText(null);
							usernameField.setText(null);
							passwordField.setText(null);
							mailField.setText(null);
							updateUserModel();
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		btnSil.setForeground(Color.RED);
		btnSil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSil.setBounds(321, 262, 140, 44);
		userPanel.add(btnSil);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String passwordText = new String(passwordField.getPassword());
				if (adField.getText().length()==0||soyadField.getText().length()==0||usernameField.getText().length()==0||passwordField.getPassword().length==0||mailField.getText().length()==0) {
					JOptionPane.showMessageDialog(contentPane, "Tum alanlari doldurun", "Hata", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						boolean control = user.kayitOl(adField.getText(), soyadField.getText(), usernameField.getText(), passwordField.getText(), mailField.getText());
						if (control) {
							JOptionPane.showMessageDialog(contentPane, "Kullanici Ekleme Basarili.");
							updateUserModel();
						}
						else {
							JOptionPane.showMessageDialog(contentPane, "Boyle bir kullanici zaten var", "Hata", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnEkle.setForeground(new Color(0, 153, 0));
		btnEkle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEkle.setBounds(10, 262, 140, 44);
		userPanel.add(btnEkle);
		
		JButton btnGuncelle = new JButton("G\u00FCncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean control = user.updateUser(adField.getText(), soyadField.getText(), usernameField.getText(), passwordField.getText(), mailField.getText());
					if (control) {
						JOptionPane.showMessageDialog(contentPane, "Guncelleme Basarili.");
						updateUserModel();
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "Hata", "Hata", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPane, "sql hatasi: " + e1, "Hata", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGuncelle.setForeground(Color.BLUE);
		btnGuncelle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuncelle.setBounds(165, 262, 140, 44);
		userPanel.add(btnGuncelle);
		
		JPanel filmPanel = new JPanel();
		tabbedPane.addTab("Film Y\u00F6netim Paneli", null, filmPanel, null);
		filmPanel.setLayout(null);
	}
	
	public void updateUserModel() throws SQLException {
		
		DefaultTableModel updateUserModel = (DefaultTableModel) userTable.getModel();
		updateUserModel.setRowCount(0);
		for(int i=0;i<admin.getUserList().size();i++) {
			userData[0] = admin.getUserList().get(i).getId();
			userData[1] = admin.getUserList().get(i).getAd();
			userData[2] = admin.getUserList().get(i).getSoyad();
			userData[3] = admin.getUserList().get(i).getUserName();
			userData[4] = admin.getUserList().get(i).getPassword();
			userData[5] = admin.getUserList().get(i).getMail();
			userModel.addRow(userData);
		}
	}
}
