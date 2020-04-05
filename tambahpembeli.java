import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.sql.Connection ;
import java.sql.DriverManager ;
import java.util.Date;
import java.text.SimpleDateFormat;


public class tambahpembeli extends JFrame{
	private JButton btn_reset, btn_simpan, btn_exit;
	private JLabel nopem, nama, noiden, alamat, nohp, tglbeli, carabayar;
	private JLabel tnopem, tnama, tnoiden, talamat, tnohp, ttglbeli, tcarabayar;
	private JLabel no, nopol, merek, tahun, type, jenis, harga, angsuran11x, angsuran23x, angsuran35x, dp;
	private JLabel tno, tnopol, tmerek, ttahun, ttype, tjenis, tharga, tangsuran11x, tangsuran23x, tangsuran35x, tdp;
	private JLabel title = new JLabel ("TAMBAH  PEMBELI  MOTOR");
	private JTextField ino, inopol, imerek, itahun, itype, iharga, i11x, i23x, i35x, idp, ijenis, inopem, inama, inoiden, ialamat, inohp, itglbeli, iket, iketpem, ib11, ib23, ib35;
	private JRadioButton ijenis1, ijenis2, ijenis3, ijenis4, ijenis5;

	private JButton btn_cari;
	private JTextField cari;
	
	Date date;
	SimpleDateFormat sdf ;
	
	public ResultSet getData(String query) {
		ResultSet rs = null;
		try {
			Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
			Statement st = koneksi.createStatement();
			rs = st.executeQuery(query);
		} catch (Exception sql) {
			JOptionPane.showMessageDialog(null, sql);
		}
		return rs;
	}
	
public tambahpembeli(){
	super ("APLIKASI KREDIT MOTOR");
	this.setExtendedState(MAXIMIZED_BOTH);
	setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("unsika.png"));
	
	Container cont = getContentPane();
	cont.setLayout(null);
	cont.setBackground(Color.BLACK);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	title.setBounds(500,-40,500,200);
	title.setFont(new Font("! PEPSI !",2,30));
	title.setForeground(Color.WHITE);
	
	iket = new JTextField("TERJUAL");
	iketpem = new JTextField("BELUM LUNAS");
	
	nopem = new JLabel("KODE PEMBELI");
	nopem.setBounds(190,150,100,20);
	nopem.setForeground(Color.WHITE);
	
	tnopem = new JLabel(":");
	tnopem.setBounds(290,150,10,20);
	tnopem.setForeground(Color.WHITE);
	
	inopem = new JTextField();
	inopem.setBounds(320,150,200,20);
	inopem.setEditable (false);
	
	nama = new JLabel("NAMA");
	nama.setBounds(190,190,100,20);
	nama.setForeground(Color.WHITE);
	
	tnama = new JLabel(":");
	tnama.setBounds(290,190,10,20);
	tnama.setForeground(Color.WHITE);
	
	inama = new JTextField();
	inama.setBounds(320,190,200,20);
	
	noiden = new JLabel("NO IDENTITAS");
	noiden.setBounds(190,230,100,20);
	noiden.setForeground(Color.WHITE);
	
	tnoiden = new JLabel(":");
	tnoiden.setBounds(290, 230,10,20);
	tnoiden.setForeground(Color.WHITE);
	
	inoiden = new JTextField();
	inoiden.setBounds(320,230,200,20);

	nohp = new JLabel("NO HP/TELEPON");
	nohp.setBounds(190,270,100,20);
	nohp.setForeground(Color.WHITE);
	
	tnohp = new JLabel(":");
	tnohp.setBounds(290,270,10,20);
	tnohp.setForeground(Color.WHITE);
	
	inohp = new JTextField();
	inohp.setBounds(320,270,200,20);
	
	alamat = new JLabel("ALAMAT");
	alamat.setBounds(190,310,100,20);
	alamat.setForeground(Color.WHITE);
	
	talamat = new JLabel(":");
	talamat.setBounds(290,310,10,20);
	talamat.setForeground(Color.WHITE);
	
	ialamat = new JTextField();
	ialamat.setBounds(320,310,200,20);

	tglbeli = new JLabel("TANGGAL BELI");
	tglbeli.setBounds(190,350,100,20);
	tglbeli.setForeground(Color.WHITE);

	ttglbeli = new JLabel(":");
	ttglbeli.setBounds(290,350,10,20);
	ttglbeli.setForeground(Color.WHITE);
	
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat ("dd-MM-yyyy") ;
	itglbeli = new JTextField(sdf.format(date));
	itglbeli.setBounds(320,350,200,20);
	itglbeli.setEditable(false);
	
	carabayar = new JLabel ("CARA PEMBAYARAN");
	carabayar.setBounds(190,390,200,20);
	carabayar.setForeground(Color.WHITE);
	
	tcarabayar = new JLabel (":");
	tcarabayar.setBounds(290,390,50,20);
	tcarabayar.setForeground(Color.WHITE);
	
	ijenis1 = new JRadioButton("CASH");
	ijenis1.setBounds(320,390,130,20);
	ijenis1.setBackground(Color.BLACK);
	ijenis1.setForeground(Color.WHITE);
	
	ijenis2 = new JRadioButton("ANGSURAN 11X");
	ijenis2.setBounds(320,420,130,20);
	ijenis2.setBackground(Color.BLACK);
	ijenis2.setForeground(Color.WHITE);
	
	ijenis3 = new JRadioButton("ANGSURAN 23X");
	ijenis3.setBounds(320,450,130,20);
	ijenis3.setBackground(Color.BLACK);
	ijenis3.setForeground(Color.WHITE);
	
	ijenis4 = new JRadioButton("ANGSURAN 35x");
	ijenis4.setBounds(320,480,130,20);
	ijenis4.setBackground(Color.BLACK);
	ijenis4.setForeground(Color.WHITE);
	
	no = new JLabel("NO MOTOR");
	no.setBounds(690,150,75,20);
	no.setForeground(Color.WHITE);
	
	tno = new JLabel(":");
	tno.setBounds(790,150,10,20);
	tno.setForeground(Color.WHITE);
	
	ino = new JTextField();
	ino.setBounds(820,150,145,20);
	
	nopol = new JLabel("NO POLISI");
	nopol.setBounds(690,190,200,20);
	nopol.setForeground(Color.WHITE);
	
	tnopol = new JLabel(":");
	tnopol.setBounds(790,190,10,20);
	tnopol.setForeground(Color.WHITE);
	
	inopol = new JTextField();
	inopol.setBounds(820,190,200,20);
	inopol.setEditable (false);
	
	merek = new JLabel ("MEREK");
	merek.setBounds(690,230,200,20);
	merek.setForeground(Color.WHITE);
	
	tmerek = new JLabel (":");
	tmerek.setBounds(790,230,10,20);
	tmerek.setForeground(Color.WHITE);
	
	imerek = new JTextField();
	imerek.setBounds(820,230,200,20);
	imerek.setEditable (false);
	
	tahun = new JLabel("TAHUN");
	tahun.setBounds(690,270,200,20);
	tahun.setForeground(Color.WHITE);
	
	ttahun = new JLabel(":");
	ttahun.setBounds(790,270,10,20);
	ttahun.setForeground(Color.WHITE);
	
	itahun = new JTextField();
	itahun.setBounds(820,270,200,20);
	itahun.setEditable (false);
	
	type = new JLabel ("TYPE");
	type.setBounds(690,310,200,20);
	type.setForeground(Color.WHITE);
	
	ttype = new JLabel (":");
	ttype.setBounds(790,310,200,20);
	ttype.setForeground(Color.WHITE);
	
	itype = new JTextField();
	itype.setBounds(820,310,200,20);
	itype.setEditable (false);

	jenis = new JLabel ("JENIS");
	jenis.setBounds(690,350,200,20);
	jenis.setForeground(Color.WHITE);
	
	tjenis = new JLabel (":");
	tjenis.setBounds(790,350,50,20);
	tjenis.setForeground(Color.WHITE);
	
	ijenis = new JTextField();
	ijenis.setBounds(820,350,200,20);
	ijenis.setEditable (false);
	
	harga = new JLabel ("HARGA");
	harga.setBounds(690,390,200,20);
	harga.setForeground(Color.WHITE);
	
	tharga = new JLabel (":");
	tharga.setBounds(790,390,200,20);
	tharga.setForeground(Color.WHITE);
	
	iharga = new JTextField();
	iharga.setBounds(820,390,200,20);
	iharga.setEditable (false);
	
	angsuran11x = new JLabel ("ANGSURAN 11X");
	angsuran11x.setBounds(690,430,200,20);
	angsuran11x.setForeground(Color.WHITE);
	
	tangsuran11x = new JLabel (":");
	tangsuran11x.setBounds(790,430,200,20);
	tangsuran11x.setForeground(Color.WHITE);
	
	i11x = new JTextField();
	i11x.setBounds(820,430,200,20);
	i11x.setEditable (false);
	
	angsuran23x = new JLabel ("ANGSURAN 23X");
	angsuran23x.setBounds(690,470,200,20);
	angsuran23x.setForeground(Color.WHITE);
	
	tangsuran23x = new JLabel (":");
	tangsuran23x.setBounds(790,470,200,20);
	tangsuran23x.setForeground(Color.WHITE);
	
	i23x = new JTextField();
	i23x.setBounds(820,470,200,20);
	i23x.setEditable (false);
	
	angsuran35x = new JLabel ("ANGSURAN 35X");
	angsuran35x.setBounds(690,510,200,20);
	angsuran35x.setForeground(Color.WHITE);
	
	tangsuran35x = new JLabel (":");
	tangsuran35x.setBounds(790,510,200,20);
	tangsuran35x.setForeground(Color.WHITE);
	
	i35x = new JTextField();
	i35x.setBounds(820,510,200,20);
	i35x.setEditable (false);
	
	dp = new JLabel ("UANG MUKA");
	dp.setBounds(690,550,200,20);
	dp.setForeground(Color.WHITE);
	
	tdp = new JLabel (":");
	tdp.setBounds(790,550,200,20);
	tdp.setForeground(Color.WHITE);
	
	idp = new JTextField("");
	idp.setBounds(820,550,200,20);
	idp.setEditable (false);
	
	ib11 = new JTextField();
	ib23 = new JTextField();
	ib35 = new JTextField();
	
	btn_cari = new JButton("CARI");
	btn_cari.setBounds(965,150,65,20);
	btn_cari.setToolTipText("MENAMPILKAN DATA MOTOR YANG TERSEDIA");
	btn_cari.setBackground(Color.RED);
	btn_cari.setForeground(Color.WHITE);
	cont.add(btn_cari);
	
	btn_simpan = new JButton ("SIMPAN");
	btn_simpan.setBounds(1100,150,100,40);
	btn_simpan.setToolTipText("MENYIMPAN DATA");
	btn_simpan.setBackground(Color.RED);
	btn_simpan.setForeground(Color.WHITE);
	
	btn_reset = new JButton ("RESET");
	btn_reset.setBounds(1100,250,100,40);
	btn_reset.setToolTipText("MERESET DATA");
	btn_reset.setBackground(Color.RED);
	btn_reset.setForeground(Color.WHITE);
	
	btn_exit = new JButton ("EXIT");
	btn_exit.setBounds(1100,350,100,40);
	btn_exit.setToolTipText("MENUJU HALAMAN UTAMA");
	btn_exit.setBackground(Color.RED);
	btn_exit.setForeground(Color.WHITE);
	
	cont.add(title);
	cont.add(no);
	cont.add(nopol);
	cont.add(merek);
	cont.add(type);
	cont.add(tahun);
	cont.add(jenis);
	cont.add(harga);
	cont.add(angsuran11x);
	cont.add(angsuran23x);
	cont.add(angsuran35x);
	cont.add(dp);
	cont.add(nopem);
	cont.add(nama);
	cont.add(noiden);
	cont.add(alamat);
	cont.add(nohp);
	cont.add(tglbeli);
	cont.add(carabayar);
	cont.add(tno);
	cont.add(tnopol);
	cont.add(tmerek);
	cont.add(ttype);
	cont.add(ttahun);
	cont.add(tjenis);
	cont.add(tharga);
	cont.add(tangsuran11x);
	cont.add(tangsuran23x);
	cont.add(tangsuran35x);
	cont.add(tdp);
	cont.add(tnopem);
	cont.add(tnama);
	cont.add(tnoiden);
	cont.add(talamat);
	cont.add(tnohp);
	cont.add(ttglbeli);
	cont.add(tcarabayar);
	cont.add(ino);
	cont.add(inopol);
	cont.add(imerek);
	cont.add(itype);
	cont.add(ijenis);
	cont.add(itahun);
	cont.add(iharga);
	cont.add(i11x);
	cont.add(i23x);
	cont.add(i35x);
	cont.add(idp);
	cont.add(inopem);
	cont.add(inama);
	cont.add(inoiden);
	cont.add(ialamat);
	cont.add(inohp);
	cont.add(itglbeli);
	cont.add(ijenis1);
	cont.add(ijenis2);
	cont.add(ijenis3);
	cont.add(ijenis4);
	cont.add(btn_simpan);
	cont.add(btn_reset);
	cont.add(btn_exit);
	setVisible(true);
	
	try
				{
					Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
					String sql = "SELECT  max(id)FROM data_pembeli ORDER BY id";
					Statement stat = koneksi.createStatement();
					ResultSet res = stat.executeQuery(sql);
					
					while (res.next()) 
					{
						int a = res.getInt(1) ;
						inopem.setText ("P00" + Integer.toString(a+1));
					}
					
					res.close();
					koneksi.close();
				}
				catch (SQLException ex){
						JOptionPane.showMessageDialog(rootPane, ex, "AUTO NUMBER ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}
				
btn_simpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){	
			
			try {
					Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
					String sql = "SELECT  max(id)FROM data_pembeli ORDER BY id";
					Statement stat = koneksi.createStatement();
					ResultSet res = stat.executeQuery(sql);
					
					String p_nopem, p_nama, p_noiden, p_alamat, p_nohp, p_tglbeli, p_bayar, p_sisa, p_ket, p_harga, p_dp, p_kdmtr, p_jmlbayar, p_ketpem, p_angke, p_bunga;
					p_nopem= inopem.getText();
					p_nama = inama.getText();
					p_noiden = inoiden.getText();
					p_alamat = ialamat.getText();
					p_nohp = inohp.getText();
					p_tglbeli = itglbeli.getText();;
					p_kdmtr = ino.getText();
					p_harga = iharga.getText();
					p_dp = idp.getText();
					p_jmlbayar="";
					if (ijenis1.isSelected()){ p_jmlbayar =iharga.getText();}
					else if (ijenis2.isSelected()){ p_jmlbayar = i11x.getText();}
						else if (ijenis3.isSelected()){ p_jmlbayar = i23x.getText();}
							else if (ijenis4.isSelected()){ p_jmlbayar = i35x.getText();}
					p_bunga = "";
					if (ijenis1.isSelected()){ p_bunga ="0";}
					else if (ijenis2.isSelected()){ p_bunga = ib11.getText();}
						else if (ijenis3.isSelected()){ p_bunga = ib23.getText();}
							else if (ijenis4.isSelected()){ p_bunga = ib35.getText();}
					p_bayar = "";
					if (ijenis1.isSelected()){ p_bayar = "CASH";}
					else if (ijenis2.isSelected()){ p_bayar = "ANGSURAN 11X";}
						else if (ijenis3.isSelected()){ p_bayar = "ANSGURAN 23X";}
							else if (ijenis4.isSelected()){ p_bayar = "ANGSURAN 35x";}
					p_angke = "0";
					p_sisa = "";
					if (ijenis1.isSelected()){ p_sisa= "1";}
					else if (ijenis2.isSelected()){ p_sisa = "12";}
						else if (ijenis3.isSelected()){ p_sisa = "24";}
							else if (ijenis4.isSelected()){ p_sisa = "36";}
					p_ket = iharga.getText();
					p_ketpem = iketpem.getText();
					koneksi.createStatement().execute("INSERT INTO data_pembeli (xnopem, xnama, xno_iden, x_alamat, x_nohp, xtgl_beli, xkode_mtr, xharga, xdp, xkredit, xbunga, xangsuran, xangke, xsisa, xket, xketerangan) VALUES ('" + p_nopem + "', '" + p_nama + "', '" + p_noiden + "', '" + p_alamat + "', '" + p_nohp + "', '" + p_tglbeli + "', '" +p_kdmtr+ "', '" + p_harga + "', '" + p_dp + "', '" + p_jmlbayar + "', '" + p_bunga+ "', '" + p_bayar + "', '" + p_angke + "', '" + p_sisa + "', '" + p_ket + "', '" + p_ketpem + "')");
			
					res.close();
					koneksi.close();

				}
				catch (SQLException d){
						JOptionPane.showMessageDialog(rootPane, d, "SIMPAN DATA KE PEMBELI ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}
			
				
				String x_no, x_nopol, x_merek, x_tahun, x_type, x_harga, x_11x, x_23x, x_35x, x_jenis, x_dp, x_ket;
					x_no= ino.getText();
					x_nopol = inopol.getText();
					x_merek = imerek.getText();
					x_tahun = itahun.getText();
					x_type = itype.getText();
					x_jenis = ijenis.getText();;
					x_harga = iharga.getText();
					x_11x = i11x.getText();
					x_23x = i23x.getText();
					x_35x = i35x.getText();
					x_dp = idp.getText();
					x_ket = iket.getText();
					
				try {
					ResultSet data = getData("SELECT * FROM data_motor WHERE mkode = '" + x_no + "'");
					if(data.next()) {
						String sql = "UPDATE data_motor SET mkode = '" + x_no + "', mnopol = '" + x_nopol + "', mmerek = '" + x_merek + "', mtahun = '" + x_tahun + "', mtype = '" + x_type + "', mjenis = '" + x_jenis + "', mharga = '" + x_harga + "',  ma_11x = '" + x_11x + "',  ma_23x = '" + x_23x + "', ma_35x = '" + x_35x + "',  mdp = '" + x_dp + "',  mketerangan = '" + x_ket + "'  WHERE mkode = '" + x_no + "'";
						try {
							Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
							koneksi.createStatement().execute(sql);
							
						} catch (Exception sqlerror) {
							JOptionPane.showMessageDialog(null, sqlerror);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Data tidak ada");
					}
				} catch(Exception nodata) {
					JOptionPane.showMessageDialog(null, "Data tidak ada");	
				}
				
			
				try {
					Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
					String sql = "SELECT  max(id)FROM data_terjual ORDER BY id";
					Statement stat = koneksi.createStatement();
					ResultSet res = stat.executeQuery(sql);
					
					String y_no, y_nopol, y_merek, y_tahun, y_type, y_harga, y_35x, y_11x, y_23x, y_jenis, y_dp, y_ket;
					y_no= ino.getText();
					y_nopol = inopol.getText();
					y_merek = imerek.getText();
					y_tahun = itahun.getText();
					y_type = itype.getText();
					y_jenis = ijenis.getText();;
					y_harga = iharga.getText();
					y_11x = i11x.getText();
					y_23x = i23x.getText();
					y_35x = i35x.getText();
					y_dp = idp.getText();
					y_ket = iket.getText();
					koneksi.createStatement().execute("INSERT INTO data_terjual (nkode, nnopol, nmerek, ntahun, ntype, njenis, nharga, na_11x, na_23x, na_35x, ndp, nketerangan) VALUES ('" + y_no + "', '" + y_nopol + "', '" + y_merek + "', '" + y_tahun + "', '" + y_type + "', '" + y_jenis + "', '" + y_harga + "', '" + y_11x + "', '" + y_23x +"', '" + y_35x + "', '" + y_dp + "', '" + y_ket+ "')");
					JOptionPane.showMessageDialog(rootPane, "DATA BERHASIL DISIMPAN", "SUKSES", JOptionPane.INFORMATION_MESSAGE);
			
					res.close();
					koneksi.close();
					

				}
				catch (SQLException d){
						JOptionPane.showMessageDialog(rootPane, d, "SIMPAN DATA KE JUAL ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}
				
				
					
					inama.setText("");
					inoiden.setText("");
					inohp.setText("");
					ialamat.setText("");
					ijenis1.setSelected(false);
					ijenis2.setSelected(false);
					ijenis3.setSelected(false);
					ijenis4.setSelected(false);
					
					ino.setText("");
					inopol.setText("");
					imerek.setText("");
					itahun.setText("");
					ijenis.setText("");
					itype.setText("");
					iharga.setText("");
					i11x.setText("");
					i23x.setText("");
					i35x.setText("");
					idp.setText("");
		
	try
				{
					Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
					String sql = "SELECT  max(id)FROM data_pembeli ORDER BY id";
					Statement stat = koneksi.createStatement();
					ResultSet res = stat.executeQuery(sql);
					
					while (res.next()) 
					{
						int a = res.getInt (01) ;
						inopem.setText ("P00" + Integer.toString (a+01));
					}
					
					res.close();
					koneksi.close();
				}
				catch (SQLException ex){
						JOptionPane.showMessageDialog(rootPane, ex, "ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}
			
				}
		});
	
btn_cari.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			Connection connection = null;
			
				try{
				Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
				Statement stat = koneksi.createStatement();
				String sql = "Select * from data_motor where mkode like '%" + ino.getText() + "%'";
				ResultSet res = stat.executeQuery(sql);
					

					while(res.next()){
					String tampilkode = res.getString("mkode");
						String tampilnopol = res.getString("mnopol");
						String tampilmerek = res.getString("mmerek");
						String tampiltahun = res.getString("mtahun");
						String tampiltype = res.getString("mtype");
						String tampiljenis = res.getString("mjenis");
						String tampilharga = res.getString("mharga");
						String tampilang11x = res.getString ("ma_11x") ;
						String tampilb11 = res.getString ("mbunga11") ;
						String tampilang23x = res.getString ("ma_23x") ;
						String tampilb23 = res.getString ("mbunga23") ;
						String tampilang35x = res.getString ("ma_35x") ;
						String tampilb35 = res.getString ("mbunga35") ;
						String tampildp = res.getString ("mdp") ;			
						String tampilket = res.getString ("mketerangan") ;
						
					if(tampilket.equals("TERJUAL")) { JOptionPane.showMessageDialog(null, "MOTOR SUDAH TERJUAL"); }
					else {
					ino.setText(tampilkode);
					inopol.setText(tampilnopol);
					imerek.setText(tampilmerek);
					itahun.setText(tampiltahun);
					itype.setText(tampiltype);
					ijenis.setText(tampiljenis);
					iharga.setText(tampilharga);
					i11x.setText(tampilang11x);
					i23x.setText(tampilang23x);
					i35x.setText(tampilang35x);
					ib11.setText(tampilb11);
					ib23.setText(tampilb23);
					ib35.setText(tampilb35);
					idp.setText(tampildp);
					
					}
					}
				res.close();
				koneksi.close();
			} 
			catch(SQLException x){
						JOptionPane.showMessageDialog(rootPane, x, "ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
						}	
			}
		});
		
btn_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					inama.setText("");
					inoiden.setText("");
					inohp.setText("");
					ialamat.setText("");
					
					ino.setText("");
					inopol.setText("");
					imerek.setText("");
					itahun.setText("");
					ijenis.setText("");
					itype.setText("");
					iharga.setText("");
					i11x.setText("");
					i23x.setText("");
					i35x.setText("");
					idp.setText("");
			}
		});

btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					utama utm = new utama();	
					utm.setVisible(true);
					dispose();
			}
		});
}
	
public static void main (String args[]) {
	tambahpembeli beli = new tambahpembeli();
	utama utm = new utama();	
	beli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}