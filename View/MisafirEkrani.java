package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.Film;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class MisafirEkrani extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable filmTable;
	private DefaultTableModel filmModel = null;
	private Object[] filmData = null;
	static Film film = new Film();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MisafirEkrani frame = new MisafirEkrani(film);
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
	public MisafirEkrani(Film film) throws SQLException, IOException{
		
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
                    case 2: return Icon.class;
                    default: return Object.class;
                }
		    }
		};
		
		Object[] colName = new Object[3];
		colName[0] = "Film Adi";
		colName[1] = "Tur";
		colName[2] = "Afis";
		filmModel.setColumnIdentifiers(colName);
		filmData = new Object[3];
		for(int i=0;i<film.getFilmList().size();i++) {
			Blob gorsel = film.getFilmList().get(i).getImage();
			int blobLength = (int) gorsel.length();
			byte[] bytes = gorsel.getBytes(1, blobLength);
			gorsel.free();
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytes));
			ImageIcon icon = new ImageIcon(img);
			filmData[0] = film.getFilmList().get(i).getFilmName();
			filmData[1] = film.getFilmList().get(i).getType();
			filmData[2] = icon;
			filmModel.addRow(filmData);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGeri = new JButton("Geri D\u00F6n");
		btnGeri.addActionListener(new ActionListener() {
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
		btnGeri.setBounds(492, 39, 85, 21);
		contentPane.add(btnGeri);
		
		JLabel lblFilmler = new JLabel("Filmler");
		lblFilmler.setBounds(10, 39, 577, 25);
		lblFilmler.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilmler.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblFilmler);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 88, 586, 313);
		contentPane.add(scrollPane);
		
		filmTable = new JTable(filmModel);
		filmTable.setFont(new Font("Tahoma", Font.BOLD, 18));
		filmTable.setRowHeight(100);
		scrollPane.setViewportView(filmTable);
		
		JLabel lblBiletAlabilmekIin = new JLabel("Bilet alabilmek i\u00E7in l\u00FCtfen giri\u015F yap\u0131n veya kaydolun.");
		lblBiletAlabilmekIin.setHorizontalAlignment(SwingConstants.CENTER);
		lblBiletAlabilmekIin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBiletAlabilmekIin.setBounds(0, 417, 577, 25);
		contentPane.add(lblBiletAlabilmekIin);
	}
}
