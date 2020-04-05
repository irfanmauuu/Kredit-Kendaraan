import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.sql.Connection ;
import java.sql.DriverManager ;
import java.text.*;

public class tambahmotor extends JFrame{
	private JButton btn_reset, btn_simpan, btn_exit, btn_hitung;
	private JLabel no, nopol, merek, tahun, type, jenis, harga, angsuran11x, angsuran23x, angsuran35x, uangmuka, bunga, b11, b23,  b35;
	private JLabel tno, tnopol, tmerek, ttahun, ttype, tjenis, tharga, tangsuran11x, tangsuran23x, tangsuran35x, tuangmuka, tbunga, tb11, tb23, tb35;
	private JLabel title = new JLabel ("TAMBAH  DATA  MOTOR");
	private JTextField ino, inopol, itahun, itype, iharga, i11x, i23x, i35x, iuangmuka, iket,ibunga, ib11, ib23,ib35, ih11, ih23, ih35;
	private JRadioButton ijenis1, ijenis2, ijenis3, ijenis4, ijenis5;
	private JComboBox imerek;

	public void CloseJframe() { super.dispose();}
	
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
	
public tambahmotor(){
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
	
	iket = new JTextField("READY");
	iket.setBounds(190,200,200,20);
	
	no = new JLabel("NO");
	no.setBounds(190,200,100,20);
	no.setForeground(Color.WHITE);
	
	tno = new JLabel(":");
	tno.setBounds(290,200,10,20);
	tno.setForeground(Color.WHITE);
	
	ino = new JTextField();
	ino.setBounds(320,200,200,20);
	ino.setEditable (false);
	
	nopol = new JLabel("NO POLISI");
	nopol.setBounds(190,240,200,20);
	nopol.setForeground(Color.WHITE);
	
	tnopol = new JLabel(":");
	tnopol.setBounds(290,240,10,20);
	tnopol.setForeground(Color.WHITE);
	
	inopol = new JTextField();
	inopol.setBounds(320,240,200,20);
	
	merek = new JLabel ("MEREK");
	merek.setBounds(190,280,200,20);
	merek.setForeground(Color.WHITE);
	
	tmerek = new JLabel (":");
	tmerek.setBounds(290,280,10,20);
	tmerek.setForeground(Color.WHITE);
	
	imerek = new JComboBox();
	imerek.setBounds(320,280,200,20);
	try {
			ResultSet des = null; 
			des = getData ("SELECT * FROM data_merek");     
            while (des.next()) {                
                imerek.addItem(des.getString("merek"));
            }
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Tidak Masuk ke Database");
        }
	
	tahun = new JLabel("TAHUN");
	tahun.setBounds(190,320,200,20);
	tahun.setForeground(Color.WHITE);
	
	ttahun = new JLabel(":");
	ttahun.setBounds(290,320,10,20);
	ttahun.setForeground(Color.WHITE);
	
	itahun = new JTextField();
	itahun.setBounds(320,320,200,20);
	
	type = new JLabel ("TYPE");
	type.setBounds(190,360,200,20);
	type.setForeground(Color.WHITE);
	
	ttype = new JLabel (":");
	ttype.setBounds(290,360,200,20);
	ttype.setForeground(Color.WHITE);
	
	itype = new JTextField();
	itype.setBounds(320,360,200,20);

	jenis = new JLabel ("JENIS");
	jenis.setBounds(190,400,200,20);
	jenis.setForeground(Color.WHITE);
	
	tjenis = new JLabel (":");
	tjenis.setBounds(290,400,50,20);
	tjenis.setForeground(Color.WHITE);
	
	ijenis1 = new JRadioButton("BEBEK");
	ijenis1.setBounds(320,400,70,20);
	ijenis1.setBackground(Color.BLACK);
	ijenis1.setForeground(Color.WHITE);
	
	ijenis2 = new JRadioButton("MATIC");
	ijenis2.setBounds(390,400,70,20);
	ijenis2.setBackground(Color.BLACK);
	ijenis2.setForeground(Color.WHITE);
	
	ijenis3 = new JRadioButton("TRAIL");
	ijenis3.setBounds(460,400,70,20);
	ijenis3.setBackground(Color.BLACK);
	ijenis3.setForeground(Color.WHITE);
	
	ijenis4 = new JRadioButton("SPORT");
	ijenis4.setBounds(320,435,70,20);
	ijenis4.setBackground(Color.BLACK);
	ijenis4.setForeground(Color.WHITE);
	
	ijenis5 = new JRadioButton("ROAD BIKE");
	ijenis5.setBounds(390,435,100,20);
	ijenis5.setBackground(Color.BLACK);
	ijenis5.setForeground(Color.WHITE);
	
	
	harga = new JLabel ("HARGA");
	harga.setBounds(670,200,200,20);
	harga.setForeground(Color.WHITE);
	
	tharga = new JLabel (":");
	tharga.setBounds(790,200,200,20);
	tharga.setForeground(Color.WHITE);
	
	iharga = new JTextField();
	iharga.setBounds(820,200,120,20);
	
	uangmuka = new JLabel ("UANG MUKA");
	uangmuka.setBounds(670,240,200,20);
	uangmuka.setForeground(Color.WHITE);
	
	tuangmuka = new JLabel (":");
	tuangmuka.setBounds(790,240,200,20);
	tuangmuka.setForeground(Color.WHITE);
	
	iuangmuka = new JTextField();
	iuangmuka.setBounds(820,240,200,20);
	iuangmuka.setEditable(false);

	bunga = new JLabel ("SUKU BUNGA (%)");
	bunga.setBounds(670,280,200,20);
	bunga.setForeground(Color.WHITE);
	
	tbunga = new JLabel (":");
	tbunga.setBounds(790,280,200,20);
	tbunga.setForeground(Color.WHITE);
	
	ibunga = new JTextField();
	ibunga.setBounds(820,280,200,20);
	ibunga.setEditable(false);
	
	angsuran11x = new JLabel ("ANGSURAN 11X");
	angsuran11x.setBounds(670,320,200,20);
	angsuran11x.setForeground(Color.WHITE);
	
	tangsuran11x = new JLabel (":");
	tangsuran11x.setBounds(790,320,200,20);
	tangsuran11x.setForeground(Color.WHITE);
	
	i11x = new JTextField();
	i11x.setBounds(820,320,200,20);
	i11x.setEditable (true);
	
	b11 = new JLabel ("BUNGA ANGSURAN 11X");
	b11.setBounds(670,360,200,20);
	b11.setForeground(Color.WHITE);
	
	tb11 = new JLabel (":");
	tb11.setBounds(790,360,200,20);
	tb11.setForeground(Color.WHITE);
	
	ib11 = new JTextField();
	ib11.setBounds(820,360,200,20);
	ib11.setEditable(true);
	
	angsuran23x = new JLabel ("ANGSURAN 23X");
	angsuran23x.setBounds(670, 400,200,20);
	angsuran23x.setForeground(Color.WHITE);
	
	tangsuran23x = new JLabel (":");
	tangsuran23x.setBounds(790,400,200,20);
	tangsuran23x.setForeground(Color.WHITE);
	
	i23x = new JTextField();
	i23x.setBounds(820,400,200,20);
	i23x.setEditable (true);
	
	b23 = new JLabel ("BUNGA ANGSURAN 23X");
	b23.setBounds(670,440,200,20);
	b23.setForeground(Color.WHITE);
	
	tb23 = new JLabel (":");
	tb23.setBounds(790,440,200,20);
	tb23.setForeground(Color.WHITE);
	
	ib23 = new JTextField();
	ib23.setBounds(820,440,200,20);
	ib23.setEditable(true);
	
	angsuran35x = new JLabel ("ANGSURAN 35X");
	angsuran35x.setBounds(670,480,200,20);
	angsuran35x.setForeground(Color.WHITE);
	
	tangsuran35x = new JLabel (":");
	tangsuran35x.setBounds(790,480,200,20);
	tangsuran35x.setForeground(Color.WHITE);
	
	i35x = new JTextField();
	i35x.setBounds(820,480,200,20);
	i35x.setEditable (true);
	
	b35 = new JLabel ("BUNGA ANGSURAN 35X");
	b35.setBounds(670,520,200,20);
	b35.setForeground(Color.WHITE);
	
	tb35 = new JLabel (":");
	tb35.setBounds(790,520,200,20);
	tb35.setForeground(Color.WHITE);
	
	ib35 = new JTextField();
	ib35.setBounds(820,520,200,20);
	ib35.setEditable(true);
	
	ih11 = new JTextField();
	ih23 = new JTextField();
	ih35 = new JTextField();
	
	btn_hitung = new JButton("HITUNG");
	btn_hitung.setBounds(940,200,80,20);
	btn_hitung.setToolTipText("MENGHITUNG ANGSURAN");
	btn_hitung.setBackground(Color.RED);
	btn_hitung.setForeground(Color.WHITE);
	cont.add(btn_hitung);
	
	btn_simpan = new JButton ("SIMPAN");
	btn_simpan.setBounds(1200,200,100,40);
	btn_simpan.setToolTipText("MENYIMPAN DATA");
	btn_simpan.setBackground(Color.RED);
	btn_simpan.setForeground(Color.WHITE);
	
	btn_reset = new JButton ("RESET");
	btn_reset.setBounds(1200,300,100,40);
	btn_reset.setToolTipText("MERESET DATA");
	btn_reset.setBackground(Color.RED);
	btn_reset.setForeground(Color.WHITE);
	
	btn_exit = new JButton ("EXIT");
	btn_exit.setBounds(1200,400,100,40);
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
	cont.add(uangmuka);
	cont.add(b11);
	cont.add(b23);
	cont.add(b35);
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
	cont.add(tuangmuka);
	cont.add(tb11);
	cont.add(tb23);
	cont.add(tb35);
	cont.add(ino);
	cont.add(inopol);
	cont.add(imerek);
	cont.add(itype);
	cont.add(ijenis1);
	cont.add(ijenis2);
	cont.add(ijenis3);
	cont.add(ijenis4);
	cont.add(ijenis5);
	cont.add(itahun);
	cont.add(iharga);
	cont.add(i11x);
	cont.add(i23x);
	cont.add(i35x);
	cont.add(iuangmuka);
	cont.add(bunga);
	cont.add(tbunga);
	cont.add(ibunga);
	cont.add(ib11);
	cont.add(ib23);
	cont.add(ib35);
	cont.add(btn_simpan);
	cont.add(btn_reset);
	cont.add(btn_exit);
	setVisible(true);
	
		try	{
					Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
					String sql = "SELECT  max(id)FROM data_motor ORDER BY id";
					Statement stat = koneksi.createStatement();
					ResultSet res = stat.executeQuery(sql);
					
					while (res.next()) 
					{
						int a = res.getInt (01) ;
						ino.setText ("M00" + Integer.toString (a+01));
					}
					
					res.close();
					koneksi.close();
				}
				catch (SQLException ex){
						JOptionPane.showMessageDialog(rootPane, ex, "ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}
    
		try {						
				Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
				Statement stat = koneksi.createStatement();
				String sql = "SELECT  hdp, hbunga FROM data_hitungan ORDER BY hdp";
				ResultSet res = stat.executeQuery(sql);
					
					while(res.next()){
					String tampildp = res.getString("hdp");
					String tampilbunga = res.getString("hbunga");
					
					iuangmuka.setText(tampildp);
					ibunga.setText(tampilbunga);
					}
				res.close();
				koneksi.close();
			}
				
			catch(SQLException x){
						JOptionPane.showMessageDialog(rootPane, x, "ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
						}	
						
btn_hitung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){	
			
				DecimalFormat df = new DecimalFormat("#.###");
				
				double a,b,c, x,y,z, jumlah1,jumlah2,jumlah3;
				String hasil11, hasil23,hasil35, p,q,r;
				x = Double.parseDouble(iharga.getText());
				y = Double.parseDouble(iuangmuka.getText());
				z = Double.parseDouble(ibunga.getText());
				
				a = ((x - y) * ( z * 1) / 100) / 11;
				jumlah1 = (((x-y)/11));
				p = String.valueOf(df.format(a));
				ib11.setText(p);
				hasil11 = String.valueOf(df.format(jumlah1));
				i11x.setText(hasil11);
				
				b = ((x - y) * ( z * 2) / 100) / 23 ;
				jumlah2 = jumlah1 = (((x-y)/23));
				q = String.valueOf(df.format(b));
				ib23.setText(q);
				hasil23 = String.valueOf(df.format(jumlah2));
				i23x.setText(hasil23);
				
				c = ((x - y) * ( z * 3) / 100) / 35 ;
				jumlah3 = jumlah1 = (((x-y)/35));
				r = String.valueOf(df.format(c));
				ib35.setText(r);
				hasil35 = String.valueOf(df.format(jumlah3));
				i35x.setText(hasil35);
				
	}
});
						
btn_simpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){	
			
			int a, p, x;
			String hasil1;
			
			a = Integer.valueOf(i11x.getText());
			p = Integer.valueOf(ib11.getText());
			
			x = a + p;
			hasil1 = String.valueOf(x);
			ih11.setText(hasil1);
			
			int b, q, y;
			String hasil2;
			
			b = Integer.valueOf(i23x.getText());
			q = Integer.valueOf(ib11.getText());
			
			y = b + q;
			hasil2 = String.valueOf(y);
			ih23.setText(hasil2);
			
			int c, r, z;
			String hasil3;
			
			c = Integer.valueOf(i11x.getText());
			r = Integer.valueOf(ib11.getText());
			
			z = c + r;
			hasil3 = String.valueOf(z);
			ih35.setText(hasil3);
			
			
			if(ino.getText().equals("") || inopol.getText().equals("") || imerek.getSelectedItem().equals(null) || itahun.getText().equals("") || iharga.getText().equals("") || i11x.getText().equals("") || i23x.getText().equals("") || i35x.getText().equals("") )
				{JOptionPane.showMessageDialog (null, "DATA TIDAK BOLEH ADA YANG KOSONG !");}
			else {
				try {
					Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
					String sql = "SELECT  max(id)FROM data_motor ORDER BY id";
					Statement stat = koneksi.createStatement();
					ResultSet res = stat.executeQuery(sql);
					
					String x_no, x_nopol, x_merek, x_tahun, x_type, x_harga, x_11x, x_23x, x_35x, x_jenis, x_dp, x_bunga, x_ket, x_b11, x_b23, x_b35;
					x_no= ino.getText();
					x_nopol = inopol.getText();
					x_merek = (String) imerek.getSelectedItem();
					x_tahun = itahun.getText();
					x_type = itype.getText();
					x_jenis="";
					if (ijenis1.isSelected()){ x_jenis = "BEBEK";}
					else if (ijenis2.isSelected()){ x_jenis = "MATIC";}
						else if (ijenis3.isSelected()){ x_jenis = "TRAIL";}
							else if (ijenis4.isSelected()){ x_jenis = "SPORT";}
								else if (ijenis5.isSelected()){ x_jenis = "ROAD BIKE";}
					x_harga = iharga.getText();
					x_11x = ih11.getText();
					x_b11 = ib11.getText();
					x_23x = ih23.getText();
					x_b23 = ib23.getText();
					x_35x = ih35.getText();
					x_b35 = ib35.getText();
					x_dp = iuangmuka.getText();
					x_bunga = ibunga.getText();
					x_ket = iket.getText();
					koneksi.createStatement().execute("INSERT INTO data_motor (mkode, mnopol, mmerek, mtahun, mtype, mjenis, mharga, ma_11x, mbunga11, ma_23x, mbunga23, ma_35x, mbunga35, mdp, mbunga, mketerangan) VALUES ('" + x_no + "', '" + x_nopol + "', '" + x_merek + "', '" + x_tahun + "', '" + x_type + "', '" + x_jenis + "', '" + x_harga + "', '" + x_11x + "', '" + x_b11 + "', '" + x_23x +"', '" + x_b23+ "', '" + x_35x + "', '" + x_b35 + "', '" + x_dp + "', '" + x_bunga+ "', '" + x_ket+ "')");
					JOptionPane.showMessageDialog(rootPane, "DATA BERHASIL DISIMPAN", "SUKSES", JOptionPane.INFORMATION_MESSAGE);
					
					res.close();
					koneksi.close();
					
					inopol.setText("");
					imerek.setSelectedItem(null);
					itahun.setText("");
					ijenis1.setSelected(false);
					ijenis2.setSelected(false);
					ijenis3.setSelected(false);
					ijenis4.setSelected(false);
					ijenis5.setSelected(false);
					itype.setText("");
					iharga.setText("");
					i11x.setText("");
					i23x.setText("");
					i35x.setText("");
					
				}catch (SQLException m){
						JOptionPane.showMessageDialog(rootPane, m, "ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}
						
				try
				{
					Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
					String sql = "SELECT  max(id)FROM data_motor ORDER BY id";
					Statement stat = koneksi.createStatement();
					ResultSet res = stat.executeQuery(sql);
					
					while (res.next()) 
					{
						int an = res.getInt (1) ;
						ino.setText ("M00" + Integer.toString (an+1));
					}
					
					res.close();
					koneksi.close();
				}
				catch (SQLException ex){
						JOptionPane.showMessageDialog(rootPane, ex, "ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
						}
				}		
			}
		});
		
btn_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					inopol.setText("");
					imerek.setSelectedItem(null);
					itahun.setText("");
					ijenis1.setSelected(false);
					ijenis2.setSelected(false);
					ijenis3.setSelected(false);
					ijenis4.setSelected(false);
					ijenis5.setSelected(false);
					itype.setText("");
					iharga.setText("");
					i11x.setText("");
					i23x.setText("");
					i35x.setText("");
					iuangmuka.setText("2000000");
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
	tambahmotor motor = new tambahmotor();
	utama utm = new utama();	
	motor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}