package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.Bilet;
import Model.User;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class BiletEkrani extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel biletModel = null;
	private Object[] biletData = null;
	static User user = new User();
	static Bilet bilet = new Bilet();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BiletEkrani frame = new BiletEkrani(bilet, user);
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
	public BiletEkrani(Bilet bilet, User user) throws SQLException{
		
		biletModel = new DefaultTableModel() {
			
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		Object[] colName = new Object[4];
		colName[0] = "Film Adi";
		colName[1] = "Seans";
		colName[2] = "Koltuk Numaraniz";
		colName[3] = "Musteri Adi";
		biletModel.setColumnIdentifiers(colName);
		biletData = new Object[4];
		for(int i=0;i<user.getBiletList().size();i++) {
			biletData[0] = user.getBiletList().get(i).getFilmAdi();
			biletData[1] = user.getBiletList().get(i).getSeans();
			biletData[2] = user.getBiletList().get(i).getKoltukNumara();
			biletData[3] = user.getBiletList().get(i).getMusteri();
			biletModel.addRow(biletData);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Biletlerim");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(54, 22, 314, 49);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 416, 172);
		contentPane.add(scrollPane);
		
		table = new JTable(biletModel);
		scrollPane.setViewportView(table);
		
		JButton btnGeri = new JButton("Geri D\u00F6n");
		btnGeri.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserEkrani userekran;
				try {
					userekran = new UserEkrani(user);
					userekran.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dispose();
			}
		});
		btnGeri.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGeri.setBounds(10, 38, 85, 21);
		contentPane.add(btnGeri);
	}

}
