package co.com.kallsony.dal;

import co.com.kallsony.bl.entidad.UsuarioLdap;
import modelowebserviceseguridad.SeguridadServiceProxy;

public class SeguridadServicio implements ISeguridadServicio {
	
	private SeguridadServiceProxy proxy2;

	public SeguridadServicio() {
		proxy2 = new SeguridadServiceProxy();
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.dal.ISeguridad#validarLogin(co.com.kallsony.bl.entidad.UsuarioLdap)
	 */
	@Override
	public String validarLogin(UsuarioLdap usuario) {
		try {
			String res = proxy2.autenticacionAutorizacionLdap(usuario.getLogin(), usuario.getPwd());
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return "-";
		}	
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.dal.ISeguridad#obtenerPerfiles(co.com.kallsony.bl.entidad.UsuarioLdap)
	 */
	@Override
	public Object obtenerPerfiles(UsuarioLdap usuario) {
		try {
			return proxy2.listadoMenusPerfil(usuario.getPerfil());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
