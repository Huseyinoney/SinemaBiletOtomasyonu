package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Model.Film;
import Model.User;

import java.awt.Color;
import java.awt.Component;



public class FilmEkrani extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel filmModel = null;
	private Object[] filmData = null;
	static Film film = new Film();
	private JTable filmTable;
	private JLabel myLabel = new JLabel("aaa");
	private String[] seanslar = {"10:00", "16:00", "21:00"};
	static User user = new User();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FilmEkrani frame = new FilmEkrani(film, user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public FilmEkrani(Film film, User user) throws SQLException, IOException {
		setTitle("Hosgeldiniz, Misafir");
		
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
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFilmler = new JLabel("Filmler");
		lblFilmler.setBounds(10, 10, 566, 38);
		lblFilmler.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilmler.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblFilmler);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 58, 586, 313);
		contentPane.add(scrollPane);
		
		filmTable = new JTable(filmModel);
		filmTable.setFont(new Font("Tahoma", Font.BOLD, 18));
		filmTable.setRowHeight(100);
		scrollPane.setViewportView(filmTable);
		
		JComboBox filmSec = new JComboBox();
		filmSec.setModel(new DefaultComboBoxModel(new String[] {"Film Seciniz"}));
		filmSec.setBounds(10, 381, 172, 38);
		for (int i = 0; i < film.getFilmList().size(); i++) {
			filmSec.addItem(film.getFilmList().get(i).getFilmName());
		}
		contentPane.add(filmSec);
		
		JComboBox seansSec = new JComboBox();
		seansSec.setModel(new DefaultComboBoxModel(new String[] {"Seans Seciniz"}));
		for (int i = 0; i < seanslar.length; i++) {
			seansSec.addItem(seanslar[i]);
		}
		seansSec.setBounds(208, 381, 172, 38);
		contentPane.add(seansSec);
		
		JButton btnKoltukSec = new JButton("Koltuk Sec");
		btnKoltukSec.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String film = filmSec.getSelectedItem().toString();
				String seans = seansSec.getSelectedItem().toString();
				KoltukEkrani koltukekran = new KoltukEkrani(film,seans,user);
				koltukekran.setVisible(true);
				dispose();
			}
		});
		btnKoltukSec.setForeground(new Color(0, 153, 0));
		btnKoltukSec.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnKoltukSec.setBounds(404, 381, 172, 38);
		contentPane.add(btnKoltukSec);
		
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
		btnGeri.setBounds(491, 23, 85, 21);
		contentPane.add(btnGeri);
		
	}
}
