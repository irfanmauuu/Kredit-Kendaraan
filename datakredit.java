import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.sql.Connection ;
import java.sql.DriverManager ;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableModel;

public class datakredit extends JFrame{
	
	JFrame frame = new JFrame("APLIKASI KREDIT MOTOR");
	String[] judultabel1 ={"TANGGAL TRANSAKSI","KODE PEMBELI","NAMA PEMBELI","KODE MOTOR","JENIS PEMBAYARAN","ANGSURAN POKOK", "BUNGA ANGSURAN","DENDA"};
	
// KEBUTUHAN DATA TERSEDIA
	private JButton btn_cari, btn_dready,btn_exit;
	private JLabel title1;
	private JTextField cari, iket;
	private DefaultTableModel data_ready;
	
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
	
public datakredit(){

	super ("APLIKASI KREDIT MOTOR");
	this.setExtendedState(MAXIMIZED_BOTH);
	setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("unsika.png"));

	Container cont = getContentPane();
	cont.setLayout(null);
	cont.setBackground(Color.BLACK);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
// DATA MOTOR TERSEDIA

	title1 = new JLabel("DATA  TRANSAKSI  PEMBAYARAN");
	title1.setBounds(475,-40,550,200);
	title1.setFont(new Font("! PEPSI !",2,30));
	title1.setForeground(Color.WHITE);
	cont.add(title1);
	
	iket = new JTextField("READY");
	iket.setBounds(520,150,200,20);
	iket.setEditable (false);
	
	cari = new JTextField();
	cari.setBounds(200,130,300,30);
	cari.setForeground(Color.BLACK);
	cont.add(cari);
	
	btn_cari = new JButton("CARI");
	btn_cari.setBounds(500,130,80,30);
	btn_cari.setToolTipText("MENAMPILKAN DATA YANG DIBUTUHKAN");
	btn_cari.setBackground(Color.RED);
	btn_cari.setForeground(Color.WHITE);
	cont.add(btn_cari);

	btn_exit = new JButton("EXIT");
	btn_exit.setBounds(1250,10,75,30);
	btn_exit.setToolTipText("MENUJU HALAMAN UTAMA");
	btn_exit.setBackground(Color.RED);
	btn_exit.setForeground(Color.WHITE);
	cont.add(btn_exit);
	
	JTable tabel = new JTable();
	JScrollPane skrol = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	data_ready = new DefaultTableModel(null,judultabel1);
	tabel.setEnabled (false);
	tabel.setModel(data_ready);
	skrol.getViewport().add(tabel);
	skrol.setBounds(30,200,1300,500);
	cont.add(skrol) ;
//
	
	
	try
				{
					Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
					Statement stat = koneksi.createStatement();
					String sql = "SELECT  ttgl, tnopem, tnama, tnomtr, tpembayaran, tnominal, tbunga, tdenda FROM data_transaksi ORDER BY id";
					ResultSet res = stat.executeQuery(sql);
					
				
					while(res.next())
					{
						String tampiltgl = res.getString("ttgl");
						String tampilnopem = res.getString("tnopem");
						String tampilnama = res.getString("tnama");
						String tampilnomtr = res.getString("tnomtr");
						String tampilpembayaran = res.getString("tpembayaran");
						String tampilnominal = res.getString("tnominal");
						String tampilbunga = res.getString("tbunga");
						String tampildenda = res.getString("tdenda");
						String[] data = {tampiltgl,tampilnopem,tampilnama,tampilnomtr,tampilpembayaran,tampilnominal,tampilbunga,tampildenda};
						data_ready.addRow(data);						
					}
			
					res.close();
					koneksi.close();	
				} 
				catch(SQLException x){
						JOptionPane.showMessageDialog(rootPane, x, "TAMPIL DATA ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}	



btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					utama utm = new utama();
					utm.setVisible(true);
					dispose();
			}
		});					
				
btn_cari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			for( int i = data_ready.getRowCount() - 1; i >= 0; i-- )	{
				data_ready.removeRow(i);
				}
				
			Connection connection = null;
			
				try{
				Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
				Statement stat = koneksi.createStatement();
				String sql = "Select * from data_transaksi where ttgl like '%" + cari.getText() + "%'";
				ResultSet res = stat.executeQuery(sql);
					

					while(res.next()){
					String tampiltgl = res.getString("ttgl");
						String tampilnopem = res.getString("tnopem");
						String tampilnama = res.getString("tnama");
						String tampilnomtr = res.getString("tnomtr");
						String tampilpembayaran = res.getString("tpembayaran");
						String tampilnominal = res.getString("tnominal");
						String tampilbunga = res.getString("tbunga");
						String tampildenda = res.getString("tdenda");
						String[] data = {tampiltgl,tampilnopem,tampilnama,tampilnomtr,tampilpembayaran,tampilnominal,tampilbunga,tampildenda};
						data_ready.addRow(data);											
					
			}
			res.close();
			koneksi.close();
			} 
			catch(SQLException x){
						JOptionPane.showMessageDialog(rootPane, x, "CARI DATA TANGGAL ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}	
			
			try{
				Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
				Statement stat = koneksi.createStatement();
				String sql = "Select * from data_transaksi where tnopem like '%" + cari.getText() + "%'";
				ResultSet res = stat.executeQuery(sql);
					
					while(res.next()){
					String tampiltgl = res.getString("ttgl");
						String tampilnopem = res.getString("tnopem");
						String tampilnama = res.getString("tnama");
						String tampilnomtr = res.getString("tnomtr");
						String tampilpembayaran = res.getString("tpembayaran");
						String tampilnominal = res.getString("tnominal");
						String tampilbunga = res.getString("tbunga");
						String tampildenda = res.getString("tdenda");
						String[] data = {tampiltgl,tampilnopem,tampilnama,tampilnomtr,tampilpembayaran,tampilnominal,tampilbunga,tampildenda};
						data_ready.addRow(data);											
					}
			res.close();
			koneksi.close();
			}
			catch(SQLException x){
				JOptionPane.showMessageDialog(rootPane, x, "cari mtype ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}	
			
			try{
				Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
				Statement stat = koneksi.createStatement();
				String sql = "Select * from data_transaksi where tnama like '%" + cari.getText() + "%'";
				ResultSet res = stat.executeQuery(sql);
					
				while(res.next()){
					String tampiltgl = res.getString("ttgl");
						String tampilnopem = res.getString("tnopem");
						String tampilnama = res.getString("tnama");
						String tampilnomtr = res.getString("tnomtr");
						String tampilpembayaran = res.getString("tpembayaran");
						String tampilnominal = res.getString("tnominal");
						String tampilbunga = res.getString("tbunga");
						String tampildenda = res.getString("tdenda");
						String[] data = {tampiltgl,tampilnopem,tampilnama,tampilnomtr,tampilpembayaran,tampilnominal,tampilbunga,tampildenda};
						data_ready.addRow(data);																			
				} 
				
			res.close();
			koneksi.close();
			}
			catch(SQLException x){
						JOptionPane.showMessageDialog(rootPane, x, "cari mmerek ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}	
			
			try{
				Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
				Statement stat = koneksi.createStatement();
				String sql = "Select * from data_transaksi where tnomtr like '%" + cari.getText() + "%'";
				ResultSet res = stat.executeQuery(sql);
					

					while(res.next()){
					String tampiltgl = res.getString("ttgl");
						String tampilnopem = res.getString("tnopem");
						String tampilnama = res.getString("tnama");
						String tampilnomtr = res.getString("tnomtr");
						String tampilpembayaran = res.getString("tpembayaran");
						String tampilnominal = res.getString("tnominal");
						String tampilbunga = res.getString("tbunga");
						String tampildenda = res.getString("tdenda");
						String[] data = {tampiltgl,tampilnopem,tampilnama,tampilnomtr,tampilpembayaran,tampilnominal,tampilbunga,tampildenda};
						data_ready.addRow(data);											
					}
			res.close();
			koneksi.close();
			} 
			catch(SQLException x){
						JOptionPane.showMessageDialog(rootPane, x, "cari mjenis ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}	
			
			try{
				Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
				Statement stat = koneksi.createStatement();
				String sql = "Select * from data_transaksi where tpembayaran like '%" + cari.getText() + "%'";
				ResultSet res = stat.executeQuery(sql);
					

					while(res.next()){
					String tampiltgl = res.getString("ttgl");
						String tampilnopem = res.getString("tnopem");
						String tampilnama = res.getString("tnama");
						String tampilnomtr = res.getString("tnomtr");
						String tampilpembayaran = res.getString("tpembayaran");
						String tampilnominal = res.getString("tnominal");
						String tampilbunga = res.getString("tbunga");
						String tampildenda = res.getString("tdenda");
						String[] data = {tampiltgl,tampilnopem,tampilnama,tampilnomtr,tampilpembayaran,tampilnominal,tampilbunga,tampildenda};
						data_ready.addRow(data);											
					}
			res.close();
			koneksi.close();
			} 
			catch(SQLException x){
						JOptionPane.showMessageDialog(rootPane, x, "cari mtahun ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}	
		}
		
});
}
	
public static void main (String args[]) {
	datakredit kredit = new datakredit();
	kredit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}