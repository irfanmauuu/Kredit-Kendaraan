import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.sql.Connection ;
import java.sql.DriverManager ;
import java.util.Date;
import java.text.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.*;



public class kredit extends JFrame{
	private JLabel title = new JLabel ("PEMBAYARAN MOTOR");
	private JLabel nopem, nama, nomotor, tglbeli, carabayar, uangmuka, harga, angsuran, sisalama, sisa_angsuran, ket;
	private JLabel tnopem, tnama, tnomotor, ttglbeli, tcarabayar, tuangmuka,tharga, tangsuran, tsisalama, tsisa_angsuran, tket;
	private JTextField inopem, inama, inomotor, itglbeli, icarabayar, iuangmuka,iharga, iangsuran, isisalama, isisa_angsuran;
	
	private JLabel tglbayar, pembayaran, angsuranke, telat, denda, total, bayar, kembalian;
	private JLabel ttglbayar, tangsuranke, ttelat, thari, tdenda, ttotal, tbayar, tkembalian;
	private JTextField itglbayar, ipembayaran, iangsuranke, iangsuranke2, idenda, itelat, itotal, ibayar, ikembalian, iket, ibunga;
	private JRadioButton ijenis1, ijenis2, ijenis3;
	
	private JButton btn_reset, btn_simpan, btn_exit, btn_hitung,btn_cari;
	private JTextField cari;
	
	DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	Date date;
	SimpleDateFormat sdf;
	
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
	
public kredit(){
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
	
	nopem = new JLabel("KODE PEMBELI");
	nopem.setBounds(170,150,100,20);
	nopem.setForeground(Color.WHITE);
	
	tnopem = new JLabel(":");
	tnopem.setBounds(310,150,10,20);
	tnopem.setForeground(Color.WHITE);
	
	inopem = new JTextField();
	inopem.setBounds(330,150,135,20);
	
	nama = new JLabel("NAMA");
	nama.setBounds(170,190,100,20);
	nama.setForeground(Color.WHITE);
	
	tnama = new JLabel(":");
	tnama.setBounds(310,190,10,20);
	tnama.setForeground(Color.WHITE);
	
	inama = new JTextField();
	inama.setBounds(330,190,200,20);
	inama.setEditable (false);
	
	nomotor = new JLabel("KODE MOTOR");
	nomotor.setBounds(170,230,100,20);
	nomotor.setForeground(Color.WHITE);
	
	tnomotor = new JLabel(":");
	tnomotor.setBounds(310, 230,10,20);
	tnomotor.setForeground(Color.WHITE);
	
	inomotor = new JTextField();
	inomotor.setBounds(330,230,200,20);
	inomotor.setEditable (false);

	tglbeli = new JLabel("TANGGAL BELI");
	tglbeli.setBounds(170,270,100,20);
	tglbeli.setForeground(Color.WHITE);
	
	ttglbeli = new JLabel(":");
	ttglbeli.setBounds(310,270,10,20);
	ttglbeli.setForeground(Color.WHITE);
	
	itglbeli = new JTextField();
	itglbeli.setBounds(330,270,200,20);
	itglbeli.setEditable (false);
	
	harga = new JLabel("HARGA");
	harga.setBounds(170,310,100,20);
	harga.setForeground(Color.WHITE);
	
	tharga = new JLabel(":");
	tharga.setBounds(310,310,10,20);
	tharga.setForeground(Color.WHITE);
	
	iharga = new JTextField();
	iharga.setBounds(330,310,200,20);
	iharga.setEditable (false);

	carabayar = new JLabel("CARA BAYAR");
	carabayar.setBounds(170,350,100,20);
	carabayar.setForeground(Color.WHITE);

	tcarabayar = new JLabel(":");
	tcarabayar.setBounds(310,350,10,20);
	tcarabayar.setForeground(Color.WHITE);
	
	icarabayar = new JTextField();
	icarabayar.setBounds(330,350,200,20);
	icarabayar.setEditable(false);
	
	uangmuka = new JLabel ("UANG MUKA");
	uangmuka.setBounds(170,390,200,20);
	uangmuka.setForeground(Color.WHITE);
	
	tuangmuka = new JLabel (":");
	tuangmuka.setBounds(310,390,200,20);
	tuangmuka.setForeground(Color.WHITE);
	
	iuangmuka = new JTextField();
	iuangmuka.setBounds(330,390,200,20);
	iuangmuka.setEditable(false);
	
	angsuran = new JLabel ("ANGSURAN / BULAN");
	angsuran.setBounds(170,430,200,20);
	angsuran.setForeground(Color.WHITE);
	
	tangsuran = new JLabel (":");
	tangsuran.setBounds(310,430,50,20);
	tangsuran.setForeground(Color.WHITE);
	
	iangsuran = new JTextField();
	iangsuran.setBounds(330,430,200,20);
	iangsuran.setEditable(false);
	
	sisalama = new JLabel ("SISA LAMA ANGSURAN");
	sisalama.setBounds(170,470,200,20);
	sisalama.setForeground(Color.WHITE);
	
	tsisalama = new JLabel (":");
	tsisalama.setBounds(310,470,50,20);
	tsisalama.setForeground(Color.WHITE);
	
	isisalama = new JTextField();
	isisalama.setBounds(330,470,200,20);
	isisalama.setEditable(false);
	
	sisa_angsuran = new JLabel ("SISA ANGSURAN");
	sisa_angsuran.setBounds(170,510,200,20);
	sisa_angsuran.setForeground(Color.WHITE);
	
	tsisa_angsuran = new JLabel (":");
	tsisa_angsuran.setBounds(310,510,50,20);
	tsisa_angsuran.setForeground(Color.WHITE);
	
	isisa_angsuran = new JTextField();
	isisa_angsuran.setBounds(330,510,200,20);
	isisa_angsuran.setEditable(false);
	
	ket = new JLabel ("KETERANGAN");
	ket.setBounds(170,550,200,20);
	ket.setForeground(Color.WHITE);
	
	tket = new JLabel (":");
	tket.setBounds(310,550,50,20);
	tket.setForeground(Color.WHITE);
	
	iket = new JTextField();
	iket.setBounds(330,550,200,20);
	iket.setEditable(false);
	
	
	pembayaran = new JLabel ("PEMBAYARAN");
	pembayaran.setBounds(650,150,200,20);
	pembayaran.setForeground(Color.WHITE);
	
	ijenis1 = new JRadioButton("CASH");
	ijenis1.setBounds(820,150,130,20);
	ijenis1.setBackground(Color.BLACK);
	ijenis1.setForeground(Color.WHITE);
	
	ijenis2 = new JRadioButton("UANG MUKA");
	ijenis2.setBounds(820,180,130,20);
	ijenis2.setBackground(Color.BLACK);
	ijenis2.setForeground(Color.WHITE);
	
	ijenis3 = new JRadioButton("ANGSURAN");
	ijenis3.setBounds(820,210,130,20);
	ijenis3.setBackground(Color.BLACK);
	ijenis3.setForeground(Color.WHITE);
	
	tglbayar = new JLabel("TANGGAL TRANSAKSI");
	tglbayar.setBounds(650,250,200,20);
	tglbayar.setForeground(Color.WHITE);
	
	ttglbayar = new JLabel(":");
	ttglbayar.setBounds(800,250,10,20);
	ttglbayar.setForeground(Color.WHITE);
	
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat ("dd-MM-yyyy") ;
	itglbayar = new JTextField(sdf.format(date));
	itglbayar.setBounds(820,250,120,20);
	itglbayar.setEditable(false);
	
	
	angsuranke = new JLabel("ANGSURAN KE");
	angsuranke.setBounds(650,290,200,20);
	angsuranke.setForeground(Color.WHITE);
	
	tangsuranke = new JLabel(":");
	tangsuranke.setBounds(800,290,10,20);
	tangsuranke.setForeground(Color.WHITE);
	
	iangsuranke = new JTextField();
	iangsuranke.setBounds(820,290,120,20);
	iangsuranke.setEditable (false);
	
	iangsuranke2 = new JTextField();
	
	telat = new JLabel ("TERLAMBAT");
	telat.setBounds(650,330,200,20);
	telat.setForeground(Color.WHITE);
	
	ttelat = new JLabel (":");
	ttelat.setBounds(800,330,10,20);
	ttelat.setForeground(Color.WHITE);
	
	thari = new JLabel ("HARI");
	thari.setBounds(950,330,50,20);
	thari.setForeground(Color.WHITE);
	
	itelat = new JTextField();
	itelat.setBounds(820,330,120,20);
	itelat.setEditable(false);
	
	denda = new JLabel ("DENDA");
	denda.setBounds(650,370,200,20);
	denda.setForeground(Color.WHITE);
	
	tdenda = new JLabel (":");
	tdenda.setBounds(800,370,10,20);
	tdenda.setForeground(Color.WHITE);
	
	idenda = new JTextField();
	idenda.setBounds(820,370,120,20);
	idenda.setEditable(false);
	
	total = new JLabel ("TOTAL PEMBAYARAN");
	total.setBounds(650,410,200,20);
	total.setForeground(Color.WHITE);
	
	ttotal = new JLabel (":");
	ttotal.setBounds(800,410,10,20);
	ttotal.setForeground(Color.WHITE);
	
	itotal = new JTextField();
	itotal.setBounds(820,410,120,20);
	itotal.setEditable(false);
	
	bayar = new JLabel ("BAYAR");
	bayar.setBounds(650,450,200,20);
	bayar.setForeground(Color.WHITE);
	
	tbayar = new JLabel (":");
	tbayar.setBounds(800,450,10,20);
	tbayar.setForeground(Color.WHITE);
	
	ibayar = new JTextField();
	ibayar.setBounds(820,450,120,20);
	
	kembalian = new JLabel("KEMBALI");
	kembalian.setBounds(650,490,200,20);
	kembalian.setForeground(Color.WHITE);
	
	tkembalian = new JLabel(":");
	tkembalian.setBounds(800,490,10,20);
	tkembalian.setForeground(Color.WHITE);
	
	ikembalian = new JTextField();
	ikembalian.setBounds(820,490,120,20);

	ibunga = new JTextField();
	ibunga.setBounds(820,520,120,20);
	cont.add(ibunga);
	
	JTextField ia = new JTextField();
	ia.setBounds(820,560,120,20);
	cont.add(ia);
	
	btn_cari = new JButton("CARI");
	btn_cari.setBounds(465,150,65,20);
	btn_cari.setToolTipText("MENCARI DATA PEMBELI");
	btn_cari.setBackground(Color.RED);
	btn_cari.setForeground(Color.WHITE);
	cont.add(btn_cari);
	
	btn_hitung = new JButton("HITUNG");
	btn_hitung.setBounds(940,450,80,20);
	btn_hitung.setToolTipText("MENGHITUNG KEMBALIAN");
	btn_hitung.setBackground(Color.RED);
	btn_hitung.setForeground(Color.WHITE);
	cont.add(btn_hitung);
	
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
	cont.add(nopem);
	cont.add(tnopem);
	cont.add(inopem);
	cont.add(nama);
	cont.add(tnama);
	cont.add(inama);
	cont.add(nomotor);
	cont.add(tnomotor);
	cont.add(inomotor);
	cont.add(tglbeli);
	cont.add(ttglbeli);
	cont.add(itglbeli);
	cont.add(harga);
	cont.add(tharga);
	cont.add(iharga);
	cont.add(carabayar);
	cont.add(tcarabayar);
	cont.add(icarabayar);
	cont.add(uangmuka);
	cont.add(tuangmuka);
	cont.add(iuangmuka);
	cont.add(angsuran);
	cont.add(tangsuran);
	cont.add(iangsuran);
	cont.add(sisalama);
	cont.add(tsisalama);
	cont.add(isisalama);
	cont.add(sisa_angsuran);
	cont.add(tsisa_angsuran);
	cont.add(isisa_angsuran);
	cont.add(ket);
	cont.add(tket);
	cont.add(iket);
	
	cont.add(tglbayar);
	cont.add(ttglbayar);
	cont.add(itglbayar);
	cont.add(pembayaran);
	cont.add(ijenis1);
	cont.add(ijenis2);
	cont.add(ijenis3);
	cont.add(angsuranke);
	cont.add(tangsuranke);
	cont.add(iangsuranke);
	cont.add(telat);
	cont.add(ttelat);
	cont.add(thari);
	cont.add(itelat);
	cont.add(denda);
	cont.add(tdenda);
	cont.add(idenda);
	cont.add(total);
	cont.add(ttotal);
	cont.add(itotal);
	cont.add(bayar);
	cont.add(tbayar);
	cont.add(ibayar);
	cont.add(kembalian);
	cont.add(tkembalian);
	cont.add(ikembalian);

	cont.add(btn_simpan);
	cont.add(btn_reset);
	cont.add(btn_exit);
	setVisible(true);
		

btn_simpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){	
			
			if (ijenis1.isSelected()){
				int sisalama, a, b, z;
				int x = 1;
				int sisaang, bayar;
				String hasillama, hasilang;
						
				sisalama = Integer.valueOf(isisalama.getText());
				sisaang = Integer.valueOf(isisa_angsuran.getText());
				bayar = Integer.valueOf(iharga.getText());
						
				a = sisalama - x ;
				hasillama = String.valueOf (a);
				isisalama.setText(hasillama);
						
				b = sisaang - bayar ;
				hasilang = String.valueOf (b);
				isisa_angsuran.setText(hasilang);
				
				z = Integer.valueOf(isisalama.getText());
				if (z == 0) { iket.setText("LUNAS"); }
			}
			
				else if (ijenis2.isSelected()){ 
					int sisalama, a, b, d, c, z;
					int x = 1;
					
					int sisaang, angke;
					String hasillama, hasilang, hasilangke;
					
					angke = Integer.valueOf(iangsuranke.getText());
					sisalama = Integer.valueOf(isisalama.getText());
					sisaang = Integer.valueOf(isisa_angsuran.getText());
					c = Integer.valueOf(iuangmuka.getText());
					
					a = sisalama - x ;
					hasillama = String.valueOf(a);
					isisalama.setText(hasillama);
					
					b = sisaang - c ;
					hasilang = String.valueOf(b);
					isisa_angsuran.setText(hasilang); 
					
					d = angke + x;
					hasilangke = String.valueOf(d);
					iangsuranke2.setText(hasilangke);
					
					z = Integer.valueOf(isisalama.getText());
					if (z == 0) { iket.setText("LUNAS"); }
				}
					
					else if (ijenis3.isSelected()){ 
						
						int sisalama, a, d, z;
						int x = 1;
						int angke2;
						
						String hasillama, hasilangke;
						angke2 = Integer.valueOf(iangsuranke.getText());
						sisalama = Integer.valueOf(isisalama.getText());
						
						a = sisalama - x ;
						hasillama = String.valueOf (a);
						isisalama.setText (hasillama);
						
						d = angke2 + x;
						hasilangke = String.valueOf(d);
						iangsuranke2.setText(hasilangke);
						
						
						int sisaang = Integer.valueOf(isisa_angsuran.getText());
						int dbayar = Integer.valueOf(iangsuran.getText());
						int bunga = Integer.valueOf(ibunga.getText());
						String hasilang, mm;
						int b;
						
						b = dbayar - bunga ;
						mm = String.valueOf (b);
						ia.setText(mm);
						
						int c = sisaang - b ;
							hasilang = String.valueOf (c);
							isisa_angsuran.setText(hasilang);
	
						z = Integer.valueOf(isisalama.getText());
						if (z == 0) { iket.setText("LUNAS"); }
						
					}
					
					
					String p_nopem, p_nama, p_nomotor, p_harga, p_tglbeli, p_bayar, p_angsuran, p_sisalama, p_sisa_ang, p_ket, p_angke;
					p_nopem= inopem.getText();
					p_nama = inama.getText();
					p_nomotor = inomotor.getText();
					p_harga = iharga.getText();
					p_tglbeli = itglbeli.getText();
					p_bayar = icarabayar.getText();;
					p_angsuran = iangsuran.getText();
					p_sisalama = isisalama.getText();
					p_sisa_ang = isisa_angsuran.getText();
					p_ket = iket.getText();
					p_angke = iangsuranke2.getText();
					
					try {
					ResultSet data = getData("SELECT * FROM data_pembeli WHERE xnopem = '" + p_nopem + "'");
					if(data.next()) {
						String sql = "UPDATE data_pembeli SET xnopem = '" + p_nopem + "', xnama = '" + p_nama + "', xkode_mtr = '" + p_nomotor + "', xharga = '" + p_harga + "', xtgl_beli = '" + p_tglbeli + "', xangsuran = '" + p_bayar + "', xkredit = '" + p_angsuran + "', xangke = '" + p_angke + "',  xsisa = '" + p_sisalama + "',  xket = '" + p_sisa_ang + "', xketerangan = '" + p_ket+ "'  WHERE xnopem = '" + p_nopem + "'";
						try {
							Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
							koneksi.createStatement().execute(sql);
							JOptionPane.showMessageDialog(null, "Berhasil Edit Data");	
						} 
						catch (Exception sqlerror) {
							JOptionPane.showMessageDialog(null, sqlerror);
						}
					}
						else {
						JOptionPane.showMessageDialog(null, "Data tidak ada");
						}
					}
					catch(Exception nodata) {
						JOptionPane.showMessageDialog(null, "Data tidak ada");	
						}
						
				
			try {
					Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
					String sql = "SELECT  max(id)FROM data_transaksi ORDER BY id";
					Statement stat = koneksi.createStatement();
					ResultSet res = stat.executeQuery(sql);
					
					String x_tgl, x_nopem, x_nama, x_nomtr, x_pembayaran, x_nominal, x_bunga, x_denda;
					x_tgl= itglbayar.getText();
					x_nopem = inopem.getText();
					x_nama = inama.getText();
					x_nomtr = inomotor.getText();
					x_pembayaran="";
					if (ijenis1.isSelected()){ x_pembayaran = "CASH";}
					else if (ijenis2.isSelected()){ x_pembayaran = "UANG MUKA";}
						else if (ijenis3.isSelected()){ 
					String a = iangsuranke.getText();
					x_pembayaran = "Angsuran Ke-" + a ;}
					x_nominal = "";
					if (ijenis1.isSelected()){ x_nominal = iharga.getText();}
					else if (ijenis2.isSelected()){ x_nominal = iuangmuka.getText();}
						else if (ijenis3.isSelected()){ x_nominal = iangsuran.getText();}
					x_bunga = "";
					if (ijenis1.isSelected()){ x_bunga = "0";}
					else if (ijenis2.isSelected()){ x_bunga = "0";}
						else if (ijenis3.isSelected()){ x_bunga= ibunga.getText();}
					x_denda = idenda.getText();
					koneksi.createStatement().execute("INSERT INTO data_transaksi (ttgl, tnopem, tnama, tnomtr, tpembayaran, tnominal, tbunga, tdenda) VALUES ('" + x_tgl + "', '" + x_nopem + "', '" + x_nama + "', '" + x_nomtr + "', '" + x_pembayaran + "', '" + x_nominal+ "', '" + x_bunga + "', '" + x_denda + "')");
					JOptionPane.showMessageDialog(rootPane, "DATA BERHASIL DISIMPAN", "SUKSES", JOptionPane.INFORMATION_MESSAGE);
					
					res.close();
					koneksi.close();	
				}
				catch (SQLException x){
						JOptionPane.showMessageDialog(rootPane, x, "SIMPAN DATA TRANSAKSI ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}
				
					inopem.setText("");
					inama.setText("");
					inomotor.setText("");
					itglbeli.setText("");
					iharga.setText("");
					icarabayar.setText("");
					iuangmuka.setText("");
					iangsuran.setText("");
					isisalama.setText("");
					isisa_angsuran.setText("");
					iket.setText("");
			
					ijenis1.setSelected(false);
					ijenis2.setSelected(false);
					ijenis3.setSelected(false);
					itelat.setText("");
					iangsuranke.setText("");
					itotal.setText("");
					ibayar.setText("");
					ikembalian.setText("");
					ibunga.setText("");
					ia.setText("");
	}			
});
	
btn_hitung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){	
				double nilaix, nilaiy, jumlah;
				String hasil;
				nilaix = Double.parseDouble(ibayar.getText ());
				nilaiy = Double.parseDouble(itotal.getText ()) ;
				if (nilaix < nilaiy)	{
						JOptionPane.showMessageDialog (null , "UANG ANDA TIDAK CUKUP!!!"); }
				else {			
					jumlah = nilaix - nilaiy ;
					hasil = String.valueOf(jumlah);
					ikembalian.setText(hasil);
				}
	}
});

		
btn_cari.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			Connection connection = null;
			
				try{
				Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
				Statement stat = koneksi.createStatement();
				String sql = "Select * from data_pembeli where xnopem like '%" + inopem.getText() + "%'";
				ResultSet res = stat.executeQuery(sql);
					

					while(res.next()){
						String tampilnopem = res.getString("xnopem");
						String tampilnama = res.getString("xnama");
						String tampilkodemtr = res.getString("xkode_mtr");
						String tampiltglbeli = res.getString("xtgl_beli");
						String tampilharga = res.getString("xharga");
						String tampilcarabayar = res.getString("xangsuran");
						String tampilangsuran = res.getString("xkredit");
						String tampilsisalama = res.getString("xsisa");
						String tampilsisa_angsuran = res.getString("xket");
						String tampilket = res.getString("xketerangan");
						String tampilangke = res.getString("xangke");
						String tampilbunga = res.getString("xbunga");
						String tampildp = res.getString("xdp");
						
						if(tampilket.equals("LUNAS")) { JOptionPane.showMessageDialog(null, "PEMBELI SUDAH LUNAS"); }
						else {
							inopem.setText(tampilnopem);
							inama.setText(tampilnama);
							inomotor.setText(tampilkodemtr);
							itglbeli.setText(tampiltglbeli);
							iharga.setText(tampilharga);
							icarabayar.setText(tampilcarabayar);
							iangsuran.setText(tampilangsuran);
							isisalama.setText(tampilsisalama);
							isisa_angsuran.setText(tampilsisa_angsuran);
							iket.setText(tampilket);
							iangsuranke.setText(tampilangke);
							ibunga.setText(tampilbunga);
							iuangmuka.setText(tampildp);
						}
					}
					
				res.close();
				koneksi.close();
			} 
			catch(SQLException x){
						JOptionPane.showMessageDialog(rootPane, x, "AMBIL CARI ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
					}
			
			try{	
				String tgla = itglbeli.getText();
				String tglak = itglbayar.getText();
				
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				
				//Konversi dari string ke tanggal
				Date TanggalBeli = (Date) df.parse(tgla);
				Date TanggalBayar = (Date) df.parse(tglak);

				//Tgl di konversi ke milidetik
				long bedaHari = Math.abs(TanggalBeli.getTime() - TanggalBayar.getTime()); 
				itelat.setText("" + TimeUnit.MILLISECONDS.toDays(bedaHari));
			} 
			catch (ParseException d){
				d.printStackTrace();
			}
				
			double a = 0.2;
			double b = 100;
			double ddenda, dtotal;
			String hasildenda, hasiltotal, hasilangsur;
			
			int dtelat = Integer.valueOf(itelat.getText());
			
		
			if (ijenis1.isSelected()){ 
				String total = iharga.getText();
				itotal.setText(total);
			}
					else if (ijenis2.isSelected()){
						String dp = iuangmuka.getText();
						itotal.setText(dp);
					}
						else if (ijenis3.isSelected()){
								if (dtelat > 1) {
									double dharga = Double.parseDouble(iangsuran.getText());
									ddenda = dharga * a / b;
									
									dtotal = ddenda + dharga;
									
									hasildenda = String.valueOf(ddenda);
									idenda.setText(hasildenda);
									
									hasiltotal = String.valueOf(dtotal);
									itotal.setText(hasiltotal);
								}
								else { 
									hasilangsur = iangsuran.getText();
									itotal.setText(hasilangsur);
								} 
							}
			
			
			
	}
});
		
btn_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					inopem.setText("");
					inama.setText("");
					inomotor.setText("");
					itglbeli.setText("");
					iharga.setText("");
					icarabayar.setText("");
					iuangmuka.setText("");
					iangsuran.setText("");
					isisalama.setText("");
					isisa_angsuran.setText("");
					iket.setText("");
			
					ijenis1.setSelected(false);
					ijenis2.setSelected(false);
					ijenis3.setSelected(false);
					itelat.setText("");
					iangsuranke.setText("");
					ibayar.setText("");
					ikembalian.setText("");
					ibunga.setText("");
					ia.setText("");
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
	kredit dit= new kredit();
	utama utm = new utama();	
	dit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}