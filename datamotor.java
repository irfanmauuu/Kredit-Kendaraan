import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.sql.Connection ;
import java.sql.DriverManager ;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableModel;

public class datamotor extends JFrame{
	
	JFrame frame = new JFrame("APLIKASI KREDIT MOTOR");
	String[] judultabel1 ={"NO","NO POLISI","MEREK","TAHUN","TYPE","JENIS","HARGA","UANG MUKA","ANGSURAN 6X","ANGSURAN 9X","ANGSURAN 12X", "KETERANGAN", "A", "B", "C", "D", "E"};
	
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
	
public datamotor(){

	super ("APLIKASI KREDIT MOTOR");
	this.setExtendedState(MAXIMIZED_BOTH);
	setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("unsika.png"));

	Container cont = getContentPane();
	cont.setLayout(null);
	cont.setBackground(Color.BLACK);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
// DATA MOTOR TERSEDIA

	title1 = new JLabel("DATA MOTOR TERSEDIA");
	title1.setBounds(500,-40,500,200);
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
	btn_cari.setToolTipText("MENAMPILKAN DATA MOTOR YANG TERSEDIA");
	btn_cari.setBackground(Color.RED);
	btn_cari.setForeground(Color.WHITE);
	cont.add(btn_cari);

	btn_exit = new JButton("EXIT");
	btn_exit.setBounds(1250,10,75,30);
	btn_exit.setToolTipText("MENAMPILKAN DATA MOTOR YANG TERSEDIA");
	btn_exit.setBackground(Color.RED);
	btn_exit.setForeground(Color.WHITE);
	cont.add(btn_exit);
	
	JTable tabel = new JTable();
	JScrollPane skrol = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	data_ready = new DefaultTableModel(null,judultabel1);
	tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
					String sql = "Select * from data_motor where mketerangan like '%" + iket.getText() + "%'";
					ResultSet res = stat.executeQuery(sql);
					
				
					while(res.next())
					{
						String tampilkode = res.getString("mkode");
						String tampilnopol = res.getString("mnopol");
						String tampilmerek = res.getString("mmerek");
						String tampiltahun = res.getString("mtahun");
						String tampiltype = res.getString("mtype");
						String tampiljenis = res.getString("mjenis");
						String tampilharga = res.getString("mharga");
						String tampilang11x = res.getString ("ma_11x") ;
						String tampilang23x = res.getString ("ma_23x") ;
						String tampilang35x = res.getString ("ma_35x") ;
						String tampildp = res.getString ("mdp") ;
						String tampilangket = res.getString ("mketerangan") ;
						String[] data = {tampilkode,tampilnopol,tampilmerek,tampiltahun,tampiltype,tampiljenis,tampilharga,tampildp,tampilang11x,tampilang23x,tampilang35x, tampilangket};
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
					login log = new login();
					log.setVisible(true);
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
				String sql = "Select * from data_motor where mkode like '%" + cari.getText() + "%'";
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
						String tampilang23x = res.getString ("ma_23x") ;
						String tampilang35x = res.getString ("ma_35x") ;
						String tampildp = res.getString ("mdp") ;
					String[] data = {tampilkode,tampilnopol,tampilmerek,tampiltahun,tampiltype,tampiljenis,tampilharga,tampildp,tampilang11x,tampilang23x,tampilang35x};
					data_ready.addRow(data);					
					
			}
			res.close();
			koneksi.close();
			} 
			catch(SQLException x){
						JOptionPane.showMessageDialog(rootPane, x, "CARI DATA MKODE ADA YANG EROR!!!", JOptionPane.ERROR_MESSAGE);
				}	
			
			try{
				Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/kredit_motor", "root", "");
				Statement stat = koneksi.createStatement();
				String sql = "Select * from data_motor where mtype like '%" + cari.getText() + "%'";
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
						String tampilang23x = res.getString ("ma_23x") ;
						String tampilang35x = res.getString ("ma_35x") ;
						String tampildp = res.getString ("mdp") ;
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
				String sql = "Select * from data_motor where mmerek like '%" + cari.getText() + "%'";
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
					String tampilang23x = res.getString ("ma_23x") ;
					String tampilang35x = res.getString ("ma_35x") ;
					String tampildp = res.getString ("mdp") ;
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
				String sql = "Select * from data_motor where mjenis like '%" + cari.getText() + "%'";
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
						String tampilang23x = res.getString ("ma_23x") ;
						String tampilang35x = res.getString ("ma_35x") ;
						String tampildp = res.getString ("mdp") ;
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
				String sql = "Select * from data_motor where mtahun like '%" + cari.getText() + "%'";
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
						String tampilang23x = res.getString ("ma_23x") ;
						String tampilang35x = res.getString ("ma_35x") ;
						String tampildp = res.getString ("mdp") ;
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
	login log = new login();
	datamotor motor = new datamotor();
	motor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}