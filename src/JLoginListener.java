import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class JLoginListener implements ActionListener {

	private JLoginDialog m_loginDlg;
	
	public JLoginListener(JLoginDialog login_dlg) {
		// TODO Auto-generated constructor stub
		m_loginDlg = login_dlg;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String strUsrName = m_loginDlg.GetUsrName();
		if ( strUsrName.isEmpty() ) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "Please input your user name!", "USER-ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		String strPassword = m_loginDlg.GetPassword();
		if ( strPassword.isEmpty() ) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "Please input your password!", "PASSWORD-ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}
	
		m_loginDlg.SetEnable(false);
		JLogin jlgn = new JLogin(strUsrName, strPassword);
		if ( !jlgn.SignIn() ) {
			JOptionPane.showMessageDialog(null, "Login failed ! -_-", "LOGIN-ERROR", JOptionPane.ERROR_MESSAGE);
			m_loginDlg.SetEnable(true);
			return;
		}

		JOptionPane.showMessageDialog(null, "Login successfully! ^_^", "TIPS", JOptionPane.INFORMATION_MESSAGE);
	}

}
