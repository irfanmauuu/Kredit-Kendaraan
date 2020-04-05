import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class login extends JFrame implements ActionListener {
	private JLabel un, pw, title;
	private JTextField txtuser;
	private JPasswordField pwdpass;
	private JButton btnlogin, btnexit, btnutama, btndata;

public login() {
	super ("APLIKASI KREDIT MOTOR");
	this.setExtendedState(MAXIMIZED_BOTH);
	setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("unsika.png"));
	
	Container cont = getContentPane();
	cont.setLayout(null);
	cont.setBackground(Color.BLACK);
	
	title = new JLabel ("MUSTIKA  JAYA  MOTOR");
	title.setFont(new Font("! PEPSI !",4,60));
	title.setBounds(350,50,800,200);
	title.setForeground(Color.WHITE);
	
	un = new JLabel ("Username : ");
	un.setBounds(650,245,200,20);
	un.setForeground(Color.WHITE);
	
	pw = new JLabel ("Password : ");
	pw.setBounds(650,305,200,20);
	pw.setForeground(Color.WHITE);
	
	txtuser = new JTextField (20);
	txtuser.setBounds(580,270,200,20);
	txtuser.setToolTipText("Masukkan Username Anda");
	
	pwdpass = new JPasswordField(20);
	pwdpass.setBounds(580,330,200,20);
	pwdpass.setToolTipText("Masukkan Password Anda");

	btnlogin = new JButton ("Login");
	btnlogin.setBounds(550,400,100,40);
	btnlogin.setToolTipText("Menuju Tampilan Utama");
	btnlogin.addActionListener(this);
	btnlogin.setBackground(Color.RED);
	btnlogin.setForeground(Color.WHITE);
	
	btndata = new JButton ("Data Motor");
	btndata.setBounds(720,400,100,40);
	btndata.setToolTipText("Menuju Data Motor");
	btndata.addActionListener(this);
	btndata.setBackground(Color.RED);
	btndata.setForeground(Color.WHITE);
	
	btnexit = new JButton ("Exit");
	btnexit.setBounds(636,480,100,40);
	btnexit.setToolTipText("Keluar Dari Program");
	btnexit.addActionListener(this);
	btnexit.setBackground(Color.RED);
	btnexit.setForeground(Color.WHITE);
	
	
	cont.add(un);
	cont.add(txtuser);
	cont.add(pw);
	cont.add(title);
	cont.add(pwdpass);
	cont.add(btnlogin);
	cont.add(btndata);
	cont.add(btnexit);
	setVisible(true);
}

private String user = "", pass = "";

public void actionPerformed(ActionEvent e) {
	if (e.getSource() == btnlogin) {
	user = txtuser.getText();
	pass = pwdpass.getText();
	if (user.equals("") || pass.equals("")) {JOptionPane.showMessageDialog(null, "ISI PASSWORD DAN USERNAME ANDA");}
		else if (user.equals("admin") && pass.equals("admin")) {
			JOptionPane.showMessageDialog(null, "LOGIN SUKSES");
			this.hide();
			utama utm = new utama();
			utm.show();
		} 
			else if (user.equals("cihuy") && pass.equals("cihuy")) {
				JOptionPane.showMessageDialog(null, "LOGIN SUKSES");
				this.hide();
				utama utm = new utama();
				utm.show();
			} 
				else {
					JOptionPane.showMessageDialog(null, "USERNAME DAN PASSWORD ANDA SALAH ! SILAHKAN COBA LAGI ^_^");
					txtuser.setText("");
					pwdpass.setText("");
					txtuser.requestFocus(true);
					}
	}
	
		else if (e.getSource() == btndata){
			this.hide();
			datamotor data = new datamotor();
			data.show();
		}
	
			else if (e.getSource() == btnexit){
			
			int confirm = JOptionPane.showConfirmDialog(null,"ANDA YAKIN INGIN KELUAR?", "KONFIRMASI",JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null,"TERIMA KASIH");
				System.exit(0);
				}
				else {
					this.hide();
					login log = new login();
					log.show();
					}
			}
}

public static void main (String args[]) {
	login log = new login();
	datamotor data = new datamotor();
	utama utm = new utama();	
	log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
