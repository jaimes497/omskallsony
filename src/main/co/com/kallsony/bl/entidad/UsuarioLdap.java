package co.com.kallsony.bl.entidad;

public class UsuarioLdap {
	
	private String login;
	private String pwd;
	private String perfil;
	
	public UsuarioLdap() {}

	public UsuarioLdap(String login, String pwd) {
		this.login = login;
		this.pwd = pwd;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
		
	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "UsuarioLdap [l=" + login + ", p=" + pwd + ", r=" + perfil + "]";
	}

}
