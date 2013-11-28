package co.com.kallsony.dal;

import co.com.kallsony.bl.entidad.UsuarioLdap;

public interface ISeguridadServicio {

	String validarLogin(UsuarioLdap usuario);

	Object obtenerPerfiles(UsuarioLdap usuario);

}