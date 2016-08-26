
public class JLogin {

	private String m_usrName;
	private String m_password;
	
	public JLogin(String usr_name, String pwd) {
		m_usrName  = usr_name;
		m_password = pwd;
	}
	
	public boolean SignIn() {
		return (m_usrName.equals(m_password));
	}
	
	public String ErrMessage() {
		return "Login ERROR!";
	}
	
}
