package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Model.Admin;
import Model.Film;
import Model.User;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import Controller.DBConnection;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.Image;
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
	private DefaultTableModel filmModel = null;
	private Object[] filmData = null;
	static User user = new User();
	static Film film = new Film();
	private JTable filmTable;
	private JTextField filmField;
	private JTextField turField;
	private JTextField gorselField;
	ImageIcon myImage = new ImageIcon();
	DBConnection conn = new DBConnection();
	Connection con = conn.DBCon();
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

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
	public AdminEkrani(Admin admin) throws SQLException, IOException{
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
		
		filmModel = new DefaultTableModel() {
			
			private static final long serialVersionUID = 1L;
			

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				switch (columnIndex)
                {
                    case 3: return Icon.class;
                    default: return Object.class;
                }
		    }
		};
		
		Object[] colNameFilm = new Object[4];
		colNameFilm[0] = "Id";
		colNameFilm[1] = "Film Adi";
		colNameFilm[2] = "Tur";
		colNameFilm[3] = "Afis";
		filmModel.setColumnIdentifiers(colNameFilm);
		filmData = new Object[4];
		for(int i=0;i<film.getFilmList().size();i++) {
			Blob gorsel = film.getFilmList().get(i).getImage();
			int blobLength = (int) gorsel.length();
			byte[] bytes = gorsel.getBytes(1, blobLength);
			gorsel.free();
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytes));
			ImageIcon icon = new ImageIcon(img);
			filmData[0] = film.getFilmList().get(i).getFilmId();
			filmData[1] = film.getFilmList().get(i).getFilmName();
			filmData[2] = film.getFilmList().get(i).getType();
			filmData[3] = icon;
			filmModel.addRow(filmData);
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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 294, 252);
		filmPanel.add(scrollPane_1);
		
		filmTable = new JTable(filmModel);
		filmTable.setFont(new Font("Tahoma", Font.PLAIN, 10));
		filmTable.setRowHeight(100);
		scrollPane_1.setViewportView(filmTable);
		
		filmField = new JTextField();
		filmField.setColumns(10);
		filmField.setBounds(304, 35, 162, 19);
		filmPanel.add(filmField);
		
		turField = new JTextField();
		turField.setColumns(10);
		turField.setBounds(304, 120, 162, 19);
		filmPanel.add(turField);
		
		JLabel lblFilmAd = new JLabel("Film Ad\u0131");
		lblFilmAd.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFilmAd.setBounds(304, 12, 67, 13);
		filmPanel.add(lblFilmAd);
		
		JLabel lblFilmTr = new JLabel("Film T\u00FCr\u00FC");
		lblFilmTr.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFilmTr.setBounds(304, 97, 67, 13);
		filmPanel.add(lblFilmTr);
		
		gorselField = new JTextField();
		gorselField.setColumns(10);
		gorselField.setBounds(304, 172, 162, 19);
		filmPanel.add(gorselField);
		
		JLabel lblGrselUrl = new JLabel("G\u00F6rsel URL");
		lblGrselUrl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGrselUrl.setBounds(304, 149, 67, 13);
		filmPanel.add(lblGrselUrl);
		
		JButton btnEkle_1 = new JButton("Ekle");
		btnEkle_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String passwordText = new String(passwordField.getPassword());
				if (filmField.getText().length()==0||turField.getText().length()==0) {
					JOptionPane.showMessageDialog(contentPane, "Tum alanlari doldurun", "Hata", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						boolean control = admin.addFilm(filmField.getText(), turField.getText());
						if (control) {
							JOptionPane.showMessageDialog(contentPane, "Film Ekleme Basarili.");
							updateUserModel();
						}
						else {
							JOptionPane.showMessageDialog(contentPane, "Bu film zaten var", "Hata", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnEkle_1.setForeground(new Color(0, 153, 0));
		btnEkle_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEkle_1.setBounds(10, 262, 140, 44);
		filmPanel.add(btnEkle_1);
		
		JButton btnGuncelle_1 = new JButton("G\u00FCncelle");
		btnGuncelle_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuncelle_1.setForeground(Color.BLUE);
		btnGuncelle_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean control = admin.updateFilm(filmField.getText(), turField.getText());
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
		btnGuncelle_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuncelle_1.setBounds(176, 262, 140, 44);
		filmPanel.add(btnGuncelle_1);
		
		JButton btnSil_1 = new JButton("Sil");
		btnSil_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usernameField.getText().length()==0) {
					JOptionPane.showMessageDialog(contentPane, "Alanlari doldurun", "Hata", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						boolean control = admin.deleteFilm(filmField.getText());
						if (control) {
							JOptionPane.showMessageDialog(contentPane, "Film Kaldirma Basarili.");
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
		btnSil_1.setForeground(Color.RED);
		btnSil_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSil_1.setBounds(326, 262, 140, 44);
		filmPanel.add(btnSil_1);
		
		JButton btnGorselEkle = new JButton("G\u00F6rsel Ekle");
		btnGorselEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfile = new JFileChooser();
				jfile.setCurrentDirectory(new File(System.getProperty("user.home")));
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image","jpg","png");
				jfile.addChoosableFileFilter(filter);
				
				int result = jfile.showSaveDialog(null);
				System.out.println(result);
				
				File selectedFile = jfile.getSelectedFile();
				String filename  =  selectedFile.getName(); 
				
				if (result == JFileChooser.APPROVE_OPTION) {
					String path = selectedFile.getAbsolutePath();
					ImageIcon image = new ImageIcon(path);
					Image img = image.getImage();
					Image newImage = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
					ImageIcon myImage = new ImageIcon(newImage);
					FileInputStream fis = null;
					
					try {
						
						fis = new FileInputStream(path);
						try {
							preparedStatement = con.prepareStatement("INSERT INTO film (Gorsel) VALUES (?)");
							preparedStatement.setBinaryStream(1, fis);
							preparedStatement.executeUpdate();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnGorselEkle.setBounds(304, 211, 162, 21);
		filmPanel.add(btnGorselEkle);
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
