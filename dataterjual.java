import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.sql.Connection ;
import java.sql.DriverManager ;
import javax.swing.table.DefaultTableModel;

public class dataterjual extends JFrame{
	
	JFrame frame = new JFrame("APLIKASI KREDIT MOTOR");
	String[] judultabel1 ={"NO","NO POLISI","MEREK","TAHUN","TYPE","JENIS","HARGA","UANG MUKA","ANGSURAN 6X","ANGSURAN 9X","ANGSURAN 12X"};
	String[] judultabel2 ={"NO","NO POLISI","MEREK","TAHUN","TYPE","JENIS","HARGA","UANG MUKA","ANGSURAN 6X","ANGSURAN 9X","ANGSURAN 12X"};
	
// KEBUTUHAN DATA TERSEDIA
	private JButton btn_cari, btn_dready, btn_djual, btn_exit;
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
	
public dataterjual(){

	super ("APLIKASI KREDIT MOTOR");
	this.setExtendedState(MAXIMIZED_BOTH);
	setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("unsika.png"));

	Container cont = getContentPane();
	cont.setLayout(null);
	cont.setBackground(Color.BLACK);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
// DATA MOTOR TERSEDIA

	title1 = new JLabel("DATA MOTOR TERJUAL");
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
	btn_cari.setToolTipText("MENAMPILKAN DATA MOTOR YANG DICARI");
	btn_cari.setBackground(Color.RED);
	btn_cari.setForeground(Color.WHITE);
	cont.add(btn_cari);
	
	btn_djual = new JButton("DATA MOTOR TERSEDIA");
	btn_djual.setBounds(1050,10,180,30);
	btn_djual.setToolTipText("MENAMPILKAN DATA MOTOR YANG TERSEDIA");
	btn_djual.setBackground(Color.RED);
	btn_djual.setForeground(Color.WHITE);
	cont.add(btn_djual);

	btn_exit = new JButton("EXIT");
	btn_exit.setBounds(1250,10,75,30);
	btn_exit.setToolTipText("MENUJU MENU UTAMA");
	btn_exit.setBackground(Color.RED);
	btn_exit.setForeground(Color.WHITE);
	cont.add(btn_exit);
	
	JTable tabel = new JTable();
	JScrollPane skrol = new JScrollPane();
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
					iket = new JTextField("TERJUAL");
					String sql = "Select * from data_terjual where nketerangan like '%" + iket.getText() + "%'";
					ResultSet res = stat.executeQuery(sql);
					
				
					while(res.next()){
					String tampilkode = res.getString("nkode");
						String tampilnopol = res.getString("nnopol");
						String tampilmerek = res.getString("nmerek");
						String tampiltahun = res.getString("ntahun");
						String tampiltype = res.getString("ntype");
						String tampiljenis = res.getString("njenis");
						String tampilharga = res.getString("nharga");
						String tampilang11x = res.getString ("na_11x") ;
						String tampilang23x = res.getString ("na_23x") ;
						String tampilang35x = res.getString ("na_35x") ;
						String tampildp = res.getString ("ndp") ;
					String[] data = {tampilkode,tampilnopol,tampilmerek,tampiltahun,tampiltype,tampiljenis,tampilharga,tampildp,tampilang11x,tampilang23x,tampilang35x};
					data_ready.addRow(data);									
					}
			
					res.close();
					koneksi.close();	
				} 
				catch(SQLException x){
						JOptionPane.showMessageDialog(rootPane, x, "TAMPIL DATA TERJUAL ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}	
			
btn_djual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					datamtr mtr = new datamtr();	
					mtr.setVisible(true);
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
					
			for( int i = data_ready.getRowCount() - 1; i >= 0; i-- )	{
				data_ready.removeRow(i);
				}
				
			Connection connection = null;
			
				try{
				Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
				Statement stat = koneksi.createStatement();
				String sql = "Select * from data_terjual where nkode like '%" + cari.getText() + "%'";
				ResultSet res = stat.executeQuery(sql);
					

					while(res.next()){
					String tampilkode = res.getString("nkode");
						String tampilnopol = res.getString("nnopol");
						String tampilmerek = res.getString("nmerek");
						String tampiltahun = res.getString("ntahun");
						String tampiltype = res.getString("ntype");
						String tampiljenis = res.getString("njenis");
						String tampilharga = res.getString("nharga");
						String tampilang11x = res.getString ("na_11x") ;
						String tampilang23x = res.getString ("na_23x") ;
						String tampilang35x = res.getString ("na_35x") ;
						String tampildp = res.getString ("ndp") ;
					String[] data = {tampilkode,tampilnopol,tampilmerek,tampiltahun,tampiltype,tampiljenis,tampilharga,tampildp,tampilang11x,tampilang23x,tampilang35x};
					data_ready.addRow(data);									
					}
					
			res.close();
			koneksi.close();
			} 
			catch(SQLException x){
						JOptionPane.showMessageDialog(rootPane, x, "ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}	
			
			try{
				Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
				Statement stat = koneksi.createStatement();
				String sql = "Select * from data_terjual where ntype like '%" + cari.getText() + "%'";
				ResultSet res = stat.executeQuery(sql);
					
					while(res.next()){
					String tampilkode = res.getString("nkode");
						String tampilnopol = res.getString("nnopol");
						String tampilmerek = res.getString("nmerek");
						String tampiltahun = res.getString("ntahun");
						String tampiltype = res.getString("ntype");
						String tampiljenis = res.getString("njenis");
						String tampilharga = res.getString("nharga");
						String tampilang11x = res.getString ("na_11x") ;
						String tampilang23x = res.getString ("na_23x") ;
						String tampilang35x = res.getString ("na_35x") ;
						String tampildp = res.getString ("ndp") ;
					String[] data = {tampilkode,tampilnopol,tampilmerek,tampiltahun,tampiltype,tampiljenis,tampilharga,tampildp,tampilang11x,tampilang23x,tampilang35x};
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
				String sql = "Select * from data_terjual where nmerek like '%" + cari.getText() + "%'";
				ResultSet res = stat.executeQuery(sql);
					
				while(res.next()){
					String tampilkode = res.getString("nkode");
						String tampilnopol = res.getString("nnopol");
						String tampilmerek = res.getString("nmerek");
						String tampiltahun = res.getString("ntahun");
						String tampiltype = res.getString("ntype");
						String tampiljenis = res.getString("njenis");
						String tampilharga = res.getString("nharga");
						String tampilang11x = res.getString ("na_11x") ;
						String tampilang23x = res.getString ("na_23x") ;
						String tampilang35x = res.getString ("na_35x") ;
						String tampildp = res.getString ("ndp") ;
					String[] data = {tampilkode,tampilnopol,tampilmerek,tampiltahun,tampiltype,tampiljenis,tampilharga,tampildp,tampilang11x,tampilang23x,tampilang35x};
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
				String sql = "Select * from data_terjual where njenis like '%" + cari.getText() + "%'";
				ResultSet res = stat.executeQuery(sql);
					
					while(res.next()){
					String tampilkode = res.getString("nkode");
						String tampilnopol = res.getString("nnopol");
						String tampilmerek = res.getString("nmerek");
						String tampiltahun = res.getString("ntahun");
						String tampiltype = res.getString("ntype");
						String tampiljenis = res.getString("njenis");
						String tampilharga = res.getString("nharga");
						String tampilang11x = res.getString ("na_11x") ;
						String tampilang23x = res.getString ("na_23x") ;
						String tampilang35x = res.getString ("na_35x") ;
						String tampildp = res.getString ("ndp") ;
					String[] data = {tampilkode,tampilnopol,tampilmerek,tampiltahun,tampiltype,tampiljenis,tampilharga,tampildp,tampilang11x,tampilang23x,tampilang35x};
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
				String sql = "Select * from data_terjual where ntahun like '%" + cari.getText() + "%'";
				ResultSet res = stat.executeQuery(sql);
					
					while(res.next()){
					String tampilkode = res.getString("nkode");
						String tampilnopol = res.getString("nnopol");
						String tampilmerek = res.getString("nmerek");
						String tampiltahun = res.getString("ntahun");
						String tampiltype = res.getString("ntype");
						String tampiljenis = res.getString("njenis");
						String tampilharga = res.getString("nharga");
						String tampilang11x = res.getString ("na_11x") ;
						String tampilang23x = res.getString ("na_23x") ;
						String tampilang35x = res.getString ("na_35x") ;
						String tampildp = res.getString ("ndp") ;
					String[] data = {tampilkode,tampilnopol,tampilmerek,tampiltahun,tampiltype,tampiljenis,tampilharga,tampildp,tampilang11x,tampilang23x,tampilang35x};
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
	datamtr mtr = new datamtr();
	utama utm = new utama();
	dataterjual motor = new dataterjual();
	motor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}