import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JLoginDialog {

	private JFrame m_dialog;
	private JTextField m_usrName;
	private JPasswordField m_password;
	private JButton m_login;

	public JLoginDialog() {
		Init();
	}
	
	// 初始化
	private void Init() {
		m_dialog = new JFrame("Client login");

		InitPanel();

		m_dialog.setSize(300, 200);
		m_dialog.setResizable(false);
		
		// 位置在屏幕中央
		LocationInCenter();

//		m_dialog.pack();
		m_dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_dialog.setVisible(true);
	}
	
	// 调整位置到中央
	private void LocationInCenter() {
		int width  = m_dialog.getWidth();
		int height = m_dialog.getHeight();
		
		Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
		width  = screen_size.width / 2 - width / 2;
		height = screen_size.height / 2 - height / 2;
		
		m_dialog.setLocation(width, height);
	}
	
	private void InitPanel() {
		m_dialog.setLayout(null);

		int height = 30;
		int width_lbl_usr = 50;
		int width_tf_usr  = 120;
		int width_lbl_pwd = 100;
		int x_lbl_usr = 45;
		int y_lbl_usr = 30;
		
		JLabel jlbl_usr = new JLabel("USER", JLabel.CENTER);
		jlbl_usr.setSize(width_lbl_usr, height);
		jlbl_usr.setLocation(x_lbl_usr, y_lbl_usr);
		m_dialog.add(jlbl_usr);

		int x_tf_usr = x_lbl_usr + width_lbl_usr + width_lbl_usr / 2;
		m_usrName = new JTextField();
		m_usrName.setSize(width_tf_usr, height);
		m_usrName.setLocation(x_tf_usr, y_lbl_usr);
		m_dialog.add(m_usrName);
		
		int y_lbl_pwd = y_lbl_usr + height + height / 3;
		JLabel jlbl_pwd = new JLabel("PASSWORD", JLabel.LEFT);
		jlbl_pwd.setSize(width_lbl_pwd, height);
		jlbl_pwd.setLocation(x_lbl_usr, y_lbl_pwd);
		m_dialog.add(jlbl_pwd);
		
		m_password = new JPasswordField();
		m_password.setSize(width_tf_usr, height);
		m_password.setLocation(x_tf_usr, y_lbl_pwd);
		m_dialog.add(m_password);

		int width_btn_login  = 80;
		int height_btn_login = 30;
		int x_btn_login = x_lbl_usr + (x_tf_usr + width_tf_usr - x_lbl_usr) / 2 - width_btn_login / 2;
		int y_btn_login = y_lbl_pwd + height + height_btn_login * 2 / 3;
		m_login = new JButton("LOGIN");
		m_login.setSize(width_btn_login, height_btn_login);
		m_login.setLocation(x_btn_login, y_btn_login);
		
		InitLogin();
		m_dialog.add(m_login);
	}
	
	private void InitLogin() {
		m_login.addActionListener(new JLoginListener(this));
	}
	
	public String GetUsrName() {
		return m_usrName.getText();
	}
	
	public String GetPassword() {
		return String.valueOf(m_password.getPassword());
	}
	
	public void SetEnable(boolean b) {
		m_usrName.setEnabled(b);
		m_password.setEnabled(b);
		m_login.setEnabled(b);
	}
	
}
