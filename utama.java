import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class utama extends JFrame implements ActionListener{
	private JButton btn_tambahpembeli,btn_tambahmotor,btn_kredit,btn_datapembeli,btn_datamotor, btn_datakredit, btnexit;
	private JLabel title = new JLabel ("MENU APLIKASI");
		
public utama(){
	super ("APLIKASI KREDIT MOTOR");
	this.setExtendedState(MAXIMIZED_BOTH);
	setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("unsika.png"));
	
	Container cont = getContentPane();
	cont.setLayout(null);
	cont.setBackground(Color.BLACK);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	btn_tambahpembeli = new JButton("TAMBAH DATA PEMBELI");
	btn_tambahpembeli.addActionListener(this);
	btn_tambahpembeli.setBounds(270,200,220,75);
	btn_tambahpembeli.setToolTipText("MENAMBAHKAN DATA MOTOR BARU");
	btn_tambahpembeli.setBackground(Color.RED);
	btn_tambahpembeli.setForeground(Color.WHITE);
	
	btn_tambahmotor = new JButton("TAMBAH DATA MOTOR");
	btn_tambahmotor.addActionListener(this);
	btn_tambahmotor.setBounds(570,200,220,75);
	btn_tambahmotor.setToolTipText("MENAMBAHKAN DATA MOTOR BARU");
	btn_tambahmotor.setBackground(Color.RED);
	btn_tambahmotor.setForeground(Color.WHITE);
	
	btn_kredit = new JButton("PEMBAYARAN KREDIT MOTOR");
	btn_kredit.addActionListener(this);
	btn_kredit.setBounds(870,200,220,75);
	btn_kredit.setToolTipText("PEMBAYARAN KREDIT DAN CASH MOTOR");
	btn_kredit.setBackground(Color.RED);
	btn_kredit.setForeground(Color.WHITE);
	
	btn_datapembeli = new JButton("DATA PEMBELI");
	btn_datapembeli.addActionListener(this);
	btn_datapembeli.setBounds(270,300,220,75);
	btn_datapembeli.setToolTipText("DATA PEMBELI MOTOR");
	btn_datapembeli.setBackground(Color.RED);
	btn_datapembeli.setForeground(Color.WHITE);
	
	btn_datamotor = new JButton("DATA MOTOR");
	btn_datamotor.addActionListener(this);
	btn_datamotor.setBounds(570,300,220,75);
	btn_datamotor.setToolTipText("DATA MOTOR");
	btn_datamotor.setBackground(Color.RED);
	btn_datamotor.setForeground(Color.WHITE);
	
	btn_datakredit = new JButton("DATA KREDIT");
	btn_datakredit.addActionListener(this);
	btn_datakredit.setBounds(870,300,220,75);
	btn_datakredit.setToolTipText("DATA PEMBAYARAN KREDIT DAN CASH");
	btn_datakredit.setBackground(Color.RED);
	btn_datakredit.setForeground(Color.WHITE);
	
	btnexit = new JButton("EXIT");
	btnexit.addActionListener(this);
	btnexit.setBounds(570,400,220,75);
	btnexit.setIcon(new ImageIcon("/D:/new/exit.png"));
	btnexit.setToolTipText("Kembali ke Menu Login");
	btnexit.setBackground(Color.RED);
	btnexit.setForeground(Color.WHITE);
	
	
	title.setBounds(500,0,500,200);
	title.setFont(new Font("! PEPSI !",1,40));
	title.setForeground(Color.WHITE);
	
	cont.add(title);
	cont.add(btn_tambahpembeli);
	cont.add(btn_tambahmotor);
	cont.add(btn_kredit);
	cont.add(btn_datapembeli);
	cont.add(btn_datamotor);
	cont.add(btn_datakredit);
	cont.add(btnexit);
	}
public void actionPerformed(ActionEvent e){
	utama utm = new utama();
	if (e.getSource() == btn_tambahpembeli){
	tambahpembeli pembeli = new tambahpembeli();
	pembeli.show();
	this.hide();
	}
		if (e.getSource() == btn_tambahmotor){
		tambahmotor motor = new tambahmotor ();
		motor.show();
		this.hide();
		}
			if (e.getSource() == btn_kredit){
			kredit bayar = new kredit();
			bayar.show();
			this.hide();
			}
				if (e.getSource() == btn_datapembeli){
				datapembeli pem = new datapembeli();
				pem.show();
				this.hide();
				}
					if (e.getSource() == btn_datamotor){
					datamtr mtr = new datamtr();
					mtr.show();
					this.hide();
					}
						if (e.getSource() == btn_datakredit){
						datakredit krdt = new datakredit();
						krdt.show();
						this.hide();
						}
							if (e.getSource() == btnexit){
							int confirm = JOptionPane.showConfirmDialog(null,"ANDA YAKIN INGIN KELUAR?", "KONFIRMASI",JOptionPane.YES_NO_OPTION);
									if (confirm == JOptionPane.YES_OPTION) {
										login log = new login();
										log.show();
										this.hide();
										}
										else {
											utama utma = new utama();
											utma.show();
											this.hide();
											}
							}
}

public static void main (String args[]) {
	login log = new login();
	tambahmotor motor = new tambahmotor();
	tambahpembeli pembeli = new tambahpembeli();
	kredit bayar = new kredit();
	datapembeli pem = new datapembeli(); 
	datamtr mtr = new datamtr();
	datakredit krdt = new datakredit(); 
	utama utm = new utama();	
	utm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}