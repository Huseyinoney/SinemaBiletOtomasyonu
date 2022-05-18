package View;

//import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Model.User;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;


public class UserEkrani extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static User user = new User();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserEkrani frame = new UserEkrani(user);
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
	public UserEkrani(User user) {
		setResizable(false);
		setTitle(" ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBaslik = new JLabel("Sinema Otomasyonuna Ho\u015F Geldiniz, " + user.getUserName());
		lblBaslik.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBaslik.setBounds(50, 50, 400, 50);
		contentPane.add(lblBaslik);
		
		JButton btnFilm = new JButton("Filmlere G\u00F6z At");
		btnFilm.setForeground(new Color(0, 153, 51));
		btnFilm.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFilm.setBounds(260, 250, 190, 70);
		contentPane.add(btnFilm);
		
		JButton btnBilet = new JButton("Biletlerim");
		btnBilet.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBilet.setBounds(260, 150, 190, 70);
		contentPane.add(btnBilet);
		
		JButton btnCikis = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btnCikis.setForeground(Color.RED);
		btnCikis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCikis.setBounds(50, 250, 190, 70);
		contentPane.add(btnCikis);
		
		JButton btnUserUpdate = new JButton("Bilgilerimi G\u00FCncelle");
		btnUserUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUserUpdate.setBounds(50, 150, 190, 70);
		contentPane.add(btnUserUpdate);
	}

}
