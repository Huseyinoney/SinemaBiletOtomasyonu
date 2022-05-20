package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Film;
import Model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JButton;
import Model.Bilet;
import javax.swing.JToggleButton;

public class KoltukEkrani extends JFrame {

	private JPanel contentPane;
	private static String film;
	private static String seans;
	static Film film1 = new Film();
	private String koltuk = null;
	static User user = new User();
	private boolean kontrol = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KoltukEkrani frame = new KoltukEkrani(film, seans, user);
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
	/*public KoltukEkrani () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblFilm = new JLabel("");
		lblFilm.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilm.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblFilm.setBounds(10, 10, 564, 77);
		getContentPane().add(lblFilm);
		}*/
	
	public KoltukEkrani(String film, String seans, User musteri) {
		setTitle("Koltuk Se\u00E7imi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToggleButton btn1 = new JToggleButton("");
		JToggleButton btn1_1 = new JToggleButton("");
		JToggleButton btn1_2 = new JToggleButton("");
		JToggleButton btn1_3 = new JToggleButton("");
		JToggleButton btn1_4 = new JToggleButton("");
		JToggleButton btn1_5 = new JToggleButton("");
		JToggleButton btn1_6 = new JToggleButton("");
		JToggleButton btn1_7 = new JToggleButton("");
		JToggleButton btn1_8 = new JToggleButton("");
		JToggleButton btn1_9 = new JToggleButton("");
		JToggleButton btn1_10 = new JToggleButton("");
		JToggleButton btn1_11 = new JToggleButton("");	
		
		JButton btnBiletAl = new JButton("B\u0130LET AL");
		btnBiletAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println(koltuk);
					boolean control = Bilet.biletAl(film, seans, koltuk, musteri.getUserName());
					if (control && koltuk.length()==2) {
						JOptionPane.showMessageDialog(contentPane, "Kayit Basarili.");
						UserEkrani userekran = new UserEkrani(musteri);
						userekran.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "Lutfen ayni anda sadece 1 koltuk seciniz", "Hata", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBiletAl.setForeground(new Color(0, 102, 0));
		btnBiletAl.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBiletAl.setBounds(436, 10, 117, 42);
		contentPane.add(btnBiletAl);
		
		JButton btnGeri = new JButton("Geri D\u00F6n");
		btnGeri.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 try {
					FilmEkrani filmekran = new FilmEkrani(film1, musteri);
					filmekran.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	 
	         }
		});     
		btnGeri.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGeri.setBounds(32, 10, 85, 30);
		contentPane.add(btnGeri);
		
		JLabel lblFilmAdi = new JLabel(film);
		lblFilmAdi.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblFilmAdi.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilmAdi.setBounds(10, 10, 566, 53);
		contentPane.add(lblFilmAdi);
		
		btn1.setHorizontalAlignment(SwingConstants.CENTER);
		btn1.setToolTipText("C1");
		String koltuk1 = btn1.getToolTipText();
		if (Bilet.biletKontrol(film, seans, koltuk1)) {
			btn1.setContentAreaFilled(false);
            //btn1.setOpaque(true);
			btn1.setBackground(Color.red);
			btn1.setEnabled(false);
		}
		btn1.setBounds(32, 73, 85, 85);
		btn1.setIcon(new ImageIcon(KoltukEkrani.class.getResource("/View/koltuk.png")));
		contentPane.add(btn1);
		btn1.setBackground(Color.GREEN); 
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JToggleButton tBtn = (JToggleButton)e.getSource();
		        while (btn1.isSelected() && kontrol == false) {
		        	kontrol = true;
		            btn1.setContentAreaFilled(false);
		            btn1.setOpaque(true);
		            btn1.setBackground(Color.red);
		            koltuk = btn1.getToolTipText();
		            System.out.println("kontrolBtn1: " + kontrol);
		            btn1.setEnabled(false);
		            btn1_1.setEnabled(false);
		            btn1_2.setEnabled(false);
		            btn1_3.setEnabled(false);
		            btn1_4.setEnabled(false);
		            btn1_5.setEnabled(false);
		            btn1_6.setEnabled(false);
		            btn1_7.setEnabled(false);
		            btn1_8.setEnabled(false);
		            btn1_9.setEnabled(false);
		            btn1_10.setEnabled(false);
		            btn1_11.setEnabled(false);
		        }
		        if (!btn1.isSelected() && kontrol == true)
	            {
		        	kontrol = false;
	            	System.out.println("kontrolBtn1 cikis " + kontrol);
	            	tBtn.setBackground(Color.green);
	            }
		     }
		 });
		
		
		btn1_1.setHorizontalAlignment(SwingConstants.CENTER);
		btn1_1.setToolTipText("C2");
		String koltuk2 = btn1_1.getToolTipText();
		if (Bilet.biletKontrol(film, seans, koltuk2)) {
			btn1_1.setContentAreaFilled(false);
            //btn1.setOpaque(true);
			btn1_1.setBackground(Color.red);
			btn1_1.setEnabled(false);
			
		}
		btn1_1.setBackground(Color.GREEN);
		btn1_1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            JToggleButton tBtn = (JToggleButton)e.getSource();
	            while (btn1_1.isSelected() && kontrol == false) {
	            	kontrol = true;
	            	btn1_1.setContentAreaFilled(false);
	            	btn1_1.setOpaque(true);
	            	btn1_1.setBackground(Color.red);
	            	koltuk = btn1_1.getToolTipText();
	            	System.out.println("kontrolBtn2: " + kontrol);
	            	btn1.setEnabled(false);
	            	btn1_1.setEnabled(false);
		            btn1_2.setEnabled(false);
		            btn1_3.setEnabled(false);
		            btn1_4.setEnabled(false);
		            btn1_5.setEnabled(false);
		            btn1_6.setEnabled(false);
		            btn1_7.setEnabled(false);
		            btn1_8.setEnabled(false);
		            btn1_9.setEnabled(false);
		            btn1_10.setEnabled(false);
		            btn1_11.setEnabled(false);
	            }
	            System.out.println(kontrol);
	            if (!btn1_1.isSelected() && kontrol == true)
	            {
	            	kontrol = false;
	            	System.out.println("kontrolBtn2 cikis " + kontrol);
	            	tBtn.setBackground(Color.green);
	            }
	         }
	      });
		btn1_1.setIcon(new ImageIcon(KoltukEkrani.class.getResource("/View/koltuk.png")));
		btn1_1.setBounds(176, 73, 85, 85);
		contentPane.add(btn1_1);
		
		btn1_2.setHorizontalAlignment(SwingConstants.CENTER);
		btn1_2.setToolTipText("C3");
		String koltuk3 = btn1_2.getToolTipText();
		if (Bilet.biletKontrol(film, seans, koltuk3)) {
			btn1_1.setContentAreaFilled(false);
            //btn1.setOpaque(true);
			btn1_1.setBackground(Color.red);
			btn1_1.setEnabled(false);
			
		}
		btn1_2.setBackground(Color.GREEN);
		btn1_2.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            JToggleButton tBtn = (JToggleButton)e.getSource();
	            while (btn1_2.isSelected() && kontrol == false) {
	            	kontrol = true;
	            	btn1_2.setContentAreaFilled(false);
	            	btn1_2.setOpaque(true);
	            	btn1_2.setBackground(Color.red);
	            	koltuk = btn1_1.getToolTipText();
	            	btn1.setEnabled(false);
		            btn1_1.setEnabled(false);
		            btn1_2.setEnabled(false);
		            btn1_3.setEnabled(false);
		            btn1_4.setEnabled(false);
		            btn1_5.setEnabled(false);
		            btn1_6.setEnabled(false);
		            btn1_7.setEnabled(false);
		            btn1_8.setEnabled(false);
		            btn1_9.setEnabled(false);
		            btn1_10.setEnabled(false);
		            btn1_11.setEnabled(false);
	            }
	            if (!btn1_2.isSelected() && kontrol == true)
	            {
	            	kontrol = false;
	            	tBtn.setBackground(Color.green);
	            }
	         }
	      });
		btn1_2.setIcon(new ImageIcon(KoltukEkrani.class.getResource("/View/koltuk.png")));
		btn1_2.setBounds(317, 73, 85, 85);
		contentPane.add(btn1_2);
		
		btn1_3.setHorizontalAlignment(SwingConstants.CENTER);
		btn1_3.setToolTipText("C4");
		String koltuk4 = btn1_3.getToolTipText();
		if (Bilet.biletKontrol(film, seans, koltuk4)) {
			btn1_3.setContentAreaFilled(false);
            //btn1.setOpaque(true);
			btn1_3.setBackground(Color.red);
			btn1_3.setEnabled(false);
			
		}
		btn1_3.setBackground(Color.GREEN);
		btn1_3.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            JToggleButton tBtn = (JToggleButton)e.getSource();
	            while (btn1_3.isSelected() && kontrol == false) {
	            	kontrol = true;
	            	btn1_3.setContentAreaFilled(false);
	            	btn1_3.setOpaque(true);
	            	btn1_3.setBackground(Color.red);
	            	koltuk = btn1_3.getToolTipText();
	            	btn1.setEnabled(false);
		            btn1_1.setEnabled(false);
		            btn1_2.setEnabled(false);
		            btn1_3.setEnabled(false);
		            btn1_4.setEnabled(false);
		            btn1_5.setEnabled(false);
		            btn1_6.setEnabled(false);
		            btn1_7.setEnabled(false);
		            btn1_8.setEnabled(false);
		            btn1_9.setEnabled(false);
		            btn1_10.setEnabled(false);
		            btn1_11.setEnabled(false);
	            }
	            if (!btn1_3.isSelected())
	            {
	            	kontrol = false;
	            	tBtn.setBackground(Color.green);
	            }
	         }
	      });
		btn1_3.setIcon(new ImageIcon(KoltukEkrani.class.getResource("/View/koltuk.png")));
		btn1_3.setBounds(468, 73, 85, 85);
		contentPane.add(btn1_3);
		
		btn1_4.setHorizontalAlignment(SwingConstants.CENTER);
		btn1_4.setToolTipText("B1");
		String koltuk5 = btn1_4.getToolTipText();
		if (Bilet.biletKontrol(film, seans, koltuk5)) {
			btn1_4.setContentAreaFilled(false);
            //btn1.setOpaque(true);
			btn1_4.setBackground(Color.red);
			btn1_4.setEnabled(false);
			
		}
		btn1_4.setBackground(Color.GREEN);
		btn1_4.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            JToggleButton tBtn = (JToggleButton)e.getSource();
	            while (btn1_4.isSelected() && kontrol == false) {
	            	kontrol = true;
	            	btn1_4.setContentAreaFilled(false);
	            	btn1_4.setOpaque(true);
	            	btn1_4.setBackground(Color.red);
	            	koltuk = btn1_4.getToolTipText();
	            	btn1.setEnabled(false);
		            btn1_1.setEnabled(false);
		            btn1_2.setEnabled(false);
		            btn1_3.setEnabled(false);
		            btn1_4.setEnabled(false);
		            btn1_5.setEnabled(false);
		            btn1_6.setEnabled(false);
		            btn1_7.setEnabled(false);
		            btn1_8.setEnabled(false);
		            btn1_9.setEnabled(false);
		            btn1_10.setEnabled(false);
		            btn1_11.setEnabled(false);
	            }
	            if (!btn1_4.isSelected() && kontrol == true)
	            {
	            	kontrol = false;
	            	tBtn.setBackground(Color.green);
	            }
	         }
	      });
		btn1_4.setIcon(new ImageIcon(KoltukEkrani.class.getResource("/View/koltuk.png")));
		btn1_4.setBounds(32, 213, 85, 85);
		contentPane.add(btn1_4);
		
		btn1_5.setHorizontalAlignment(SwingConstants.CENTER);
		btn1_5.setToolTipText("B2");
		String koltuk6 = btn1_5.getToolTipText();
		if (Bilet.biletKontrol(film, seans, koltuk6)) {
			btn1_5.setContentAreaFilled(false);
            //btn1.setOpaque(true);
			btn1_5.setBackground(Color.red);
			btn1_5.setEnabled(false);
			
		}
		btn1_5.setBackground(Color.GREEN);
		btn1_5.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            JToggleButton tBtn = (JToggleButton)e.getSource();
	            while (btn1_5.isSelected() && kontrol == false) {
	            	kontrol = true;
	            	btn1_5.setContentAreaFilled(false);
	            	btn1_5.setOpaque(true);
	            	btn1_5.setBackground(Color.red);
	            	koltuk = btn1_5.getToolTipText();
	            	btn1.setEnabled(false);
		            btn1_1.setEnabled(false);
		            btn1_2.setEnabled(false);
		            btn1_3.setEnabled(false);
		            btn1_4.setEnabled(false);
		            btn1_5.setEnabled(false);
		            btn1_6.setEnabled(false);
		            btn1_7.setEnabled(false);
		            btn1_8.setEnabled(false);
		            btn1_9.setEnabled(false);
		            btn1_10.setEnabled(false);
		            btn1_11.setEnabled(false);
	            }
	            if (!btn1_5.isSelected() && kontrol == true)
	            {
	            	kontrol = false;
	            	tBtn.setBackground(Color.green);
	            }
	         }
	      });
		btn1_5.setIcon(new ImageIcon(KoltukEkrani.class.getResource("/View/koltuk.png")));
		btn1_5.setBounds(176, 213, 85, 85);
		contentPane.add(btn1_5);
		
		btn1_6.setHorizontalAlignment(SwingConstants.CENTER);
		btn1_6.setToolTipText("B3");
		String koltuk7 = btn1_6.getToolTipText();
		if (Bilet.biletKontrol(film, seans, koltuk7)) {
			btn1_6.setContentAreaFilled(false);
            //btn1.setOpaque(true);
			btn1_6.setBackground(Color.red);
			btn1_6.setEnabled(false);
			
		}
		btn1_6.setBackground(Color.GREEN);
		btn1_6.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            JToggleButton tBtn = (JToggleButton)e.getSource();
	            while (btn1_6.isSelected() && kontrol == false) {
	            	kontrol = true;
	            	btn1_6.setContentAreaFilled(false);
	            	btn1_6.setOpaque(true);
	            	btn1_6.setBackground(Color.red);
	            	koltuk = btn1_6.getToolTipText();
	            	btn1.setEnabled(false);
		            btn1_1.setEnabled(false);
		            btn1_2.setEnabled(false);
		            btn1_3.setEnabled(false);
		            btn1_4.setEnabled(false);
		            btn1_5.setEnabled(false);
		            btn1_6.setEnabled(false);
		            btn1_7.setEnabled(false);
		            btn1_8.setEnabled(false);
		            btn1_9.setEnabled(false);
		            btn1_10.setEnabled(false);
		            btn1_11.setEnabled(false);
	            }
	            if (!btn1_6.isSelected() && kontrol == true)
	            {
	            	kontrol = false;
	            	tBtn.setBackground(Color.green);
	            }
	         }
	      });
		btn1_6.setIcon(new ImageIcon(KoltukEkrani.class.getResource("/View/koltuk.png")));
		btn1_6.setBounds(317, 213, 85, 85);
		contentPane.add(btn1_6);
		
		btn1_7.setHorizontalAlignment(SwingConstants.CENTER);
		btn1_7.setToolTipText("B4");
		String koltuk8 = btn1_7.getToolTipText();
		if (Bilet.biletKontrol(film, seans, koltuk8)) {
			btn1_7.setContentAreaFilled(false);
            //btn1.setOpaque(true);
			btn1_7.setBackground(Color.red);
			btn1_7.setEnabled(false);
			
		}
		btn1_7.setBackground(Color.GREEN);
		btn1_7.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            JToggleButton tBtn = (JToggleButton)e.getSource();
	            while (btn1_7.isSelected() && kontrol == false) {
	            	kontrol = true;
	            	btn1_7.setContentAreaFilled(false);
	            	btn1_7.setOpaque(true);
	            	btn1_7.setBackground(Color.red);
	            	koltuk = btn1_7.getToolTipText();
	            	btn1.setEnabled(false);
		            btn1_1.setEnabled(false);
		            btn1_2.setEnabled(false);
		            btn1_3.setEnabled(false);
		            btn1_4.setEnabled(false);
		            btn1_6.setEnabled(false);
		            btn1_5.setEnabled(false);
		            btn1_7.setEnabled(false);
		            btn1_8.setEnabled(false);
		            btn1_9.setEnabled(false);
		            btn1_10.setEnabled(false);
		            btn1_11.setEnabled(false);
	            }
	            if (!btn1_7.isSelected() && kontrol == true)
	            {
	            	kontrol = false;
	            	tBtn.setBackground(Color.green);
	            }
	         }
	      });
		btn1_7.setIcon(new ImageIcon(KoltukEkrani.class.getResource("/View/koltuk.png")));
		btn1_7.setBounds(468, 213, 85, 85);
		contentPane.add(btn1_7);
		
		btn1_8.setHorizontalAlignment(SwingConstants.CENTER);
		btn1_8.setToolTipText("A1");
		String koltuk9 = btn1_8.getToolTipText();
		if (Bilet.biletKontrol(film, seans, koltuk9)) {
			btn1_8.setContentAreaFilled(false);
            //btn1.setOpaque(true);
			btn1_8.setBackground(Color.red);
			btn1_8.setEnabled(false);
			
		}
		btn1_8.setBackground(Color.GREEN);
		btn1_8.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            JToggleButton tBtn = (JToggleButton)e.getSource();
	            while (btn1_8.isSelected() && kontrol == false) {
	            	kontrol = true;
	            	btn1_8.setContentAreaFilled(false);
	            	btn1_8.setOpaque(true);
	            	btn1_8.setBackground(Color.red);
	            	koltuk = btn1_8.getToolTipText();
	            	btn1.setEnabled(false);
		            btn1_1.setEnabled(false);
		            btn1_2.setEnabled(false);
		            btn1_3.setEnabled(false);
		            btn1_4.setEnabled(false);
		            btn1_6.setEnabled(false);
		            btn1_5.setEnabled(false);
		            btn1_8.setEnabled(false);
		            btn1_7.setEnabled(false);
		            btn1_9.setEnabled(false);
		            btn1_10.setEnabled(false);
		            btn1_11.setEnabled(false);
	            }
	            if (!btn1_8.isSelected() && kontrol == true)
	            {
	            	kontrol = false;
	            	tBtn.setBackground(Color.green);
	            }
	         }
	      });
		btn1_8.setIcon(new ImageIcon(KoltukEkrani.class.getResource("/View/koltuk.png")));
		btn1_8.setBounds(32, 348, 85, 85);
		contentPane.add(btn1_8);
		
		btn1_9.setHorizontalAlignment(SwingConstants.CENTER);
		btn1_9.setToolTipText("A2");
		String koltuk10 = btn1_9.getToolTipText();
		if (Bilet.biletKontrol(film, seans, koltuk10)) {
			btn1_9.setContentAreaFilled(false);
            //btn1.setOpaque(true);
			btn1_9.setBackground(Color.red);
			btn1_9.setEnabled(false);
			
		}
		btn1_9.setBackground(Color.GREEN);
		btn1_9.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            JToggleButton tBtn = (JToggleButton)e.getSource();
	            if (btn1_9.isSelected()) {
	            	btn1_9.setContentAreaFilled(false);
	            	btn1_9.setOpaque(true);
	            	btn1_9.setBackground(Color.red);
	            	koltuk = btn1_9.getToolTipText();
	            	btn1.setEnabled(false);
		            btn1_1.setEnabled(false);
		            btn1_2.setEnabled(false);
		            btn1_3.setEnabled(false);
		            btn1_4.setEnabled(false);
		            btn1_6.setEnabled(false);
		            btn1_5.setEnabled(false);
		            btn1_8.setEnabled(false);
		            btn1_7.setEnabled(false);
		            btn1_9.setEnabled(false);
		            btn1_10.setEnabled(false);
		            btn1_11.setEnabled(false);
	            }
	            else if (!btn1_9.isSelected())
	            {
	            	tBtn.setBackground(Color.green);
	            }
	         }
	      });
		btn1_9.setIcon(new ImageIcon(KoltukEkrani.class.getResource("/View/koltuk.png")));
		btn1_9.setBounds(176, 348, 85, 85);
		contentPane.add(btn1_9);
		
		btn1_10.setHorizontalAlignment(SwingConstants.CENTER);
		btn1_10.setToolTipText("A3");
		String koltuk11 = btn1_10.getToolTipText();
		if (Bilet.biletKontrol(film, seans, koltuk11)) {
			btn1_10.setContentAreaFilled(false);
            //btn1.setOpaque(true);
			btn1_10.setBackground(Color.red);
			btn1_10.setEnabled(false);
		}
		btn1_10.setBackground(Color.GREEN);
		btn1_10.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            JToggleButton tBtn = (JToggleButton)e.getSource();
	            if (btn1_10.isSelected()) {
	            	btn1_10.setContentAreaFilled(false);
	            	btn1_10.setOpaque(true);
	            	btn1_10.setBackground(Color.red);
	            	koltuk = btn1_10.getToolTipText();
	            	btn1.setEnabled(false);
		            btn1_1.setEnabled(false);
		            btn1_2.setEnabled(false);
		            btn1_3.setEnabled(false);
		            btn1_4.setEnabled(false);
		            btn1_6.setEnabled(false);
		            btn1_5.setEnabled(false);
		            btn1_8.setEnabled(false);
		            btn1_7.setEnabled(false);
		            btn1_9.setEnabled(false);
		            btn1_10.setEnabled(false);
		            btn1_11.setEnabled(false);
	            }
	            else if (!btn1_10.isSelected())
	            {
	            	tBtn.setBackground(Color.green);
	            }
	         }
	      });
		btn1_10.setIcon(new ImageIcon(KoltukEkrani.class.getResource("/View/koltuk.png")));
		btn1_10.setBounds(317, 348, 85, 85);
		contentPane.add(btn1_10);
		
		btn1_11.setHorizontalAlignment(SwingConstants.CENTER);
		btn1_11.setToolTipText("A4");
		String koltuk12 = btn1_11.getToolTipText();
		if (Bilet.biletKontrol(film, seans, koltuk12)) {
			btn1_11.setContentAreaFilled(false);
            //btn1.setOpaque(true);
			btn1_11.setBackground(Color.red);
			btn1_11.setEnabled(false);
		}
		btn1_11.setBackground(Color.GREEN);
		btn1_11.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            JToggleButton tBtn = (JToggleButton)e.getSource();
	            if (btn1_11.isSelected()) {
	            	btn1_11.setContentAreaFilled(false);
	            	btn1_11.setOpaque(true);
	            	btn1_11.setBackground(Color.red);
	            	koltuk = btn1_11.getToolTipText();
	            	btn1.setEnabled(false);
		            btn1_1.setEnabled(false);
		            btn1_2.setEnabled(false);
		            btn1_3.setEnabled(false);
		            btn1_4.setEnabled(false);
		            btn1_6.setEnabled(false);
		            btn1_5.setEnabled(false);
		            btn1_8.setEnabled(false);
		            btn1_7.setEnabled(false);
		            btn1_9.setEnabled(false);
		            btn1_10.setEnabled(false);
		            btn1_11.setEnabled(false);
	            }
	            else if (!btn1_11.isSelected())
	            {
	            	tBtn.setBackground(Color.green);
	            }
	         }
	      });
		btn1_11.setIcon(new ImageIcon(KoltukEkrani.class.getResource("/View/koltuk.png")));
		btn1_11.setBounds(468, 348, 85, 85);
		contentPane.add(btn1_11);
		
		JLabel lblNewLabel = new JLabel("C1");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(60, 168, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblC = new JLabel("C2");
		lblC.setFont(new Font("Arial", Font.BOLD, 20));
		lblC.setBounds(200, 168, 45, 13);
		contentPane.add(lblC);
		
		JLabel lblC_2 = new JLabel("C3");
		lblC_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblC_2.setBounds(341, 168, 45, 13);
		contentPane.add(lblC_2);
		
		JLabel lblC_1 = new JLabel("C4");
		lblC_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblC_1.setBounds(491, 168, 45, 13);
		contentPane.add(lblC_1);
		
		JLabel lblB = new JLabel("B1");
		lblB.setFont(new Font("Arial", Font.BOLD, 20));
		lblB.setBounds(60, 308, 45, 13);
		contentPane.add(lblB);
		
		JLabel lblB_1 = new JLabel("B2");
		lblB_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblB_1.setBounds(200, 308, 45, 13);
		contentPane.add(lblB_1);
		
		JLabel lblB_2 = new JLabel("B3");
		lblB_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblB_2.setBounds(341, 308, 45, 13);
		contentPane.add(lblB_2);
		
		JLabel lblB_3 = new JLabel("B4");
		lblB_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblB_3.setBounds(491, 308, 45, 13);
		contentPane.add(lblB_3);
		
		JLabel lblA = new JLabel("A1");
		lblA.setFont(new Font("Arial", Font.BOLD, 20));
		lblA.setBounds(60, 440, 45, 13);
		contentPane.add(lblA);
		
		JLabel lblA_1 = new JLabel("A2");
		lblA_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblA_1.setBounds(200, 443, 45, 13);
		contentPane.add(lblA_1);
		
		JLabel lblA_2 = new JLabel("A3");
		lblA_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblA_2.setBounds(341, 443, 45, 13);
		contentPane.add(lblA_2);
		
		JLabel lblA_3 = new JLabel("A4");
		lblA_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblA_3.setBounds(491, 443, 45, 13);
		contentPane.add(lblA_3);
	}
}
