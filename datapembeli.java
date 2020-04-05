import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.sql.Connection ;
import java.sql.DriverManager ;
import javax.swing.table.DefaultTableModel;

public class datapembeli extends JFrame{
	
	JFrame frame = new JFrame("APLIKASI KREDIT MOTOR");
	String[] judultabel1 ={"NO","NAMA","NO IDENTITAS","ALAMAT","NO HP","TANGGAL BELI","KODE MOTOR","HARGA","NOMINAL KREDIT","CARA BAYAR","SISA LAMA BAYAR", "SISA BAYAR"};
	
// KEBUTUHAN DATA PEMBELI
	private JButton btn_cari, btn_dready, btn_djual, btn_exit;
	private JLabel title1;
	private JTextField cari, iket;
	private DefaultTableModel data_pembeli;
	
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
	
public datapembeli(){

	super ("APLIKASI KREDIT MOTOR");
	this.setExtendedState(MAXIMIZED_BOTH);
	setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("unsika.png"));

	Container cont = getContentPane();
	cont.setLayout(null);
	cont.setBackground(Color.BLACK);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
// DATA MOTOR TERSEDIA

	title1 = new JLabel("DATA PEMBELI");
	title1.setBounds(500,-40,500,200);
	title1.setFont(new Font("! PEPSI !",2,30));
	title1.setForeground(Color.WHITE);
	cont.add(title1);
	
	cari = new JTextField();
	cari.setBounds(200,130,300,30);
	cari.setForeground(Color.BLACK);
	cont.add(cari);
	
	btn_cari = new JButton("CARI");
	btn_cari.setBounds(500,130,80,30);
	btn_cari.setToolTipText("MENAMPILKAN DATA MOTOR YANG TERSEDIA");
	btn_cari.setBackground(Color.RED);
	btn_cari.setForeground(Color.WHITE);
	cont.add(btn_cari);
	
	btn_djual = new JButton("DATA PEMBELI LUNAS");
	btn_djual.setBounds(1050,10,180,30);
	btn_djual.setToolTipText("MENAMPILKAN DATA MOTOR YANG TERSEDIA");
	btn_djual.setBackground(Color.RED);
	btn_djual.setForeground(Color.WHITE);
	cont.add(btn_djual);

	btn_exit = new JButton("EXIT");
	btn_exit.setBounds(1250,10,75,30);
	btn_exit.setToolTipText("MENAMPILKAN DATA MOTOR YANG TERSEDIA");
	btn_exit.setBackground(Color.RED);
	btn_exit.setForeground(Color.WHITE);
	cont.add(btn_exit);
	
	JTable tabel = new JTable();
	JScrollPane skrol = new JScrollPane();
	data_pembeli = new DefaultTableModel(null,judultabel1);
	tabel.setEnabled (false);
	tabel.setModel(data_pembeli);
	skrol.getViewport().add(tabel);
	skrol.setBounds(30,200,1300,500);
	cont.add(skrol) ;
	
//
	
				try	{
					Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
					Statement stat = koneksi.createStatement();
					iket = new JTextField("BELUM LUNAS");
					String sql = "Select * from data_pembeli where xketerangan like '%" + iket.getText() + "%'";
					ResultSet res = stat.executeQuery(sql);
					
				
					while(res.next())
					{
						String tampilkode = res.getString("xnopem");
						String tampilnama = res.getString("xnama");
						String tampilnoiden = res.getString("xno_iden");
						String tampilalamat = res.getString("x_alamat");
						String tampilnohp = res.getString("x_nohp");
						String tampiltglbeli = res.getString("xtgl_beli");
						String tampilkdmotor = res.getString("xkode_mtr");
						String tampilharga = res.getString ("xharga") ;
						String tampilkredit = res.getString ("xkredit") ;
						String tampilangsuran = res.getString ("xangsuran") ;
						String tampilsisa = res.getString ("xsisa") ;
						String tampilket = res.getString ("xket") ;
						String[] data = {tampilkode,tampilnama,tampilnoiden,tampilalamat,tampilnohp,tampiltglbeli,tampilkdmotor,tampilharga,tampilkredit,tampilangsuran,tampilsisa,tampilket};
						data_pembeli.addRow(data);						
					}
			
					res.close();
					koneksi.close();	
				} 
				catch(SQLException x){
						JOptionPane.showMessageDialog(rootPane, x, "TAMPIL DATA ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}	
	
			
btn_djual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					datapembelilunas jual = new datapembelilunas();	
					jual.setVisible(true);
					dispose();
			}
		});

btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					utama utm = new utama();	
					utm.setVisible(true);
					dispose();
			}
		});					
				
btn_cari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			for( int i = data_pembeli.getRowCount() - 1; i >= 0; i-- )	{
				data_pembeli.removeRow(i);
				}
				
			Connection connection = null;
			
				try{
				Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
				Statement stat = koneksi.createStatement();
				String sql = "Select * from data_pembeli where xnopem like '%" + cari.getText() + "%'";
				ResultSet res = stat.executeQuery(sql);
					

					while(res.next())
					{
						String tampilkode = res.getString("xnopem");
						String tampilnama = res.getString("xnama");
						String tampilnoiden = res.getString("xno_iden");
						String tampilalamat = res.getString("x_alamat");
						String tampilnohp = res.getString("x_nohp");
						String tampiltglbeli = res.getString("xtgl_beli");
						String tampilkdmotor = res.getString("xkode_mtr");
						String tampilharga = res.getString ("xharga") ;
						String tampilkredit = res.getString ("xkredit") ;
						String tampilangsuran = res.getString ("xangsuran") ;
						String tampilsisa = res.getString ("xsisa") ;
						String tampilket = res.getString ("xket") ;
						String[] data = {tampilkode,tampilnama,tampilnoiden,tampilalamat,tampilnohp,tampiltglbeli,tampilkdmotor,tampilharga,tampilkredit,tampilangsuran,tampilsisa,tampilket};
						data_pembeli.addRow(data);						
					}				
					
			
			res.close();
			koneksi.close();
			}
			catch(SQLException x){
						JOptionPane.showMessageDialog(rootPane, x, "CAEI KODE pembeli ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}	
			
			try{
				Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
				Statement stat = koneksi.createStatement();
				String sql = "Select * from data_pembeli where xnama like '%" + cari.getText() + "%'";
				ResultSet res = stat.executeQuery(sql);
					
					while(res.next())
					{
						String tampilkode = res.getString("xnopem");
						String tampilnama = res.getString("xnama");
						String tampilnoiden = res.getString("xno_iden");
						String tampilalamat = res.getString("x_alamat");
						String tampilnohp = res.getString("x_nohp");
						String tampiltglbeli = res.getString("xtgl_beli");
						String tampilkdmotor = res.getString("xkode_mtr");
						String tampilharga = res.getString ("xharga") ;
						String tampilkredit = res.getString ("xkredit") ;
						String tampilangsuran = res.getString ("xangsuran") ;
						String tampilsisa = res.getString ("xsisa") ;
						String tampilket = res.getString ("xket") ;
						String[] data = {tampilkode,tampilnama,tampilnoiden,tampilalamat,tampilnohp,tampiltglbeli,tampilkdmotor,tampilharga,tampilkredit,tampilangsuran,tampilsisa,tampilket};
						data_pembeli.addRow(data);						
					}		
								
				
			res.close();
			koneksi.close();
			}
			catch(SQLException x){
				JOptionPane.showMessageDialog(rootPane, x, "cari nama pembeli ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}	
			
			try{
				Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
				Statement stat = koneksi.createStatement();
				String sql = "Select * from data_pembeli where xtgl_beli like '%" + cari.getText() + "%'";
				ResultSet res = stat.executeQuery(sql);
					
				while(res.next())
					while(res.next())
					{
						String tampilkode = res.getString("xnopem");
						String tampilnama = res.getString("xnama");
						String tampilnoiden = res.getString("xno_iden");
						String tampilalamat = res.getString("x_alamat");
						String tampilnohp = res.getString("x_nohp");
						String tampiltglbeli = res.getString("xtgl_beli");
						String tampilkdmotor = res.getString("xkode_mtr");
						String tampilharga = res.getString ("xharga") ;
						String tampilkredit = res.getString ("xkredit") ;
						String tampilangsuran = res.getString ("xangsuran") ;
						String tampilsisa = res.getString ("xsisa") ;
						String tampilket = res.getString ("xket") ;
						String[] data = {tampilkode,tampilnama,tampilnoiden,tampilalamat,tampilnohp,tampiltglbeli,tampilkdmotor,tampilharga,tampilkredit,tampilangsuran,tampilsisa,tampilket};
						data_pembeli.addRow(data);						
					}
				
			res.close();
			koneksi.close();
			}
			catch(SQLException x){
						JOptionPane.showMessageDialog(rootPane, x, "cari tgl beli ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}	
			
			try{
				Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
				Statement stat = koneksi.createStatement();
				String sql = "Select * from data_pembeli where xkode_mtr like '%" + cari.getText() + "%'";
				ResultSet res = stat.executeQuery(sql);
					

					while(res.next())
					{
						String tampilkode = res.getString("xnopem");
						String tampilnama = res.getString("xnama");
						String tampilnoiden = res.getString("xno_iden");
						String tampilalamat = res.getString("x_alamat");
						String tampilnohp = res.getString("x_nohp");
						String tampiltglbeli = res.getString("xtgl_beli");
						String tampilkdmotor = res.getString("xkode_mtr");
						String tampilharga = res.getString ("xharga") ;
						String tampilkredit = res.getString ("xkredit") ;
						String tampilangsuran = res.getString ("xangsuran") ;
						String tampilsisa = res.getString ("xsisa") ;
						String tampilket = res.getString ("xket") ;
						String[] data = {tampilkode,tampilnama,tampilnoiden,tampilalamat,tampilnohp,tampiltglbeli,tampilkdmotor,tampilharga,tampilkredit,tampilangsuran,tampilsisa,tampilket};
						data_pembeli.addRow(data);						
					}
					
			res.close();
			koneksi.close();
			} 
			catch(SQLException x){
						JOptionPane.showMessageDialog(rootPane, x, "cari kode motor ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}	
			
			try{
				Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
				Statement stat = koneksi.createStatement();
				String sql = "Select * from data_pembeli where xno_iden like '%" + cari.getText() + "%'";
				ResultSet res = stat.executeQuery(sql);
					

					while(res.next())
					{
						String tampilkode = res.getString("xnopem");
						String tampilnama = res.getString("xnama");
						String tampilnoiden = res.getString("xno_iden");
						String tampilalamat = res.getString("x_alamat");
						String tampilnohp = res.getString("x_nohp");
						String tampiltglbeli = res.getString("xtgl_beli");
						String tampilkdmotor = res.getString("xkode_mtr");
						String tampilharga = res.getString ("xharga") ;
						String tampilkredit = res.getString ("xkredit") ;
						String tampilangsuran = res.getString ("xangsuran") ;
						String tampilsisa = res.getString ("xsisa") ;
						String tampilket = res.getString ("xket") ;
						String[] data = {tampilkode,tampilnama,tampilnoiden,tampilalamat,tampilnohp,tampiltglbeli,tampilkdmotor,tampilharga,tampilkredit,tampilangsuran,tampilsisa,tampilket};
						data_pembeli.addRow(data);						
					}
					
			res.close();
			koneksi.close();
			} 
			catch(SQLException x){
						JOptionPane.showMessageDialog(rootPane, x, "cari no identitas ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}

			try{
				Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
				Statement stat = koneksi.createStatement();
				String sql = "Select * from data_pembeli where xket like '%" + cari.getText() + "%'";
				ResultSet res = stat.executeQuery(sql);
					
					while(res.next())
					{
						String tampilkode = res.getString("xnopem");
						String tampilnama = res.getString("xnama");
						String tampilnoiden = res.getString("xno_iden");
						String tampilalamat = res.getString("x_alamat");
						String tampilnohp = res.getString("x_nohp");
						String tampiltglbeli = res.getString("xtgl_beli");
						String tampilkdmotor = res.getString("xkode_mtr");
						String tampilharga = res.getString ("xharga") ;
						String tampilkredit = res.getString ("xkredit") ;
						String tampilangsuran = res.getString ("xangsuran") ;
						String tampilsisa = res.getString ("xsisa") ;
						String tampilket = res.getString ("xket") ;
						String[] data = {tampilkode,tampilnama,tampilnoiden,tampilalamat,tampilnohp,tampiltglbeli,tampilkdmotor,tampilharga,tampilkredit,tampilangsuran,tampilsisa,tampilket};
						data_pembeli.addRow(data);						
					}
					
			res.close();
			koneksi.close();
			} 
			catch(SQLException x){
						JOptionPane.showMessageDialog(rootPane, x, "cari keterangan ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}
			
		}	
});
}
	
public static void main (String args[]) {
	datapembeli beli = new datapembeli();
	utama utma = new utama();
	datapembelilunas mtr = new datapembelilunas();
	beli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}