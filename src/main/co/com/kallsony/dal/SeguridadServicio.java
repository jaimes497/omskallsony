package co.com.kallsony.dal;

import java.util.Arrays;

import modelowebserviceseguridad.SeguridadServiceProxy;
import co.com.kallsonics.Servicios.Negocio.Consulta.wsdl.Autenticacion.AutenticacionPortTypeProxy;
import co.com.kallsonics.Servicios.Negocio.Consulta.xsd.consultaMenu.MenuEntradaType;
import co.com.kallsonics.Servicios.Negocio.Consulta.xsd.consultarUsuario.ConsultaEntradaType;
import co.com.kallsonics.Servicios.Negocio.Consulta.xsd.consultarUsuario.ConsultaSalidaType;
import co.com.kallsony.bl.entidad.UsuarioLdap;

public class SeguridadServicio implements ISeguridadServicio {
	
	private static final int WS_JAVA = 0;
	private static final int WS_BROKER = 1; 
	private int tipo = WS_BROKER;
	
	private SeguridadServiceProxy proxy2;
	private AutenticacionPortTypeProxy autenticacionPortTypeProxy;

	public SeguridadServicio() {
		proxy2 = new SeguridadServiceProxy();
		autenticacionPortTypeProxy = new AutenticacionPortTypeProxy();
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.dal.ISeguridad#validarLogin(co.com.kallsony.bl.entidad.UsuarioLdap)
	 */
	@Override
	public String validarLogin(UsuarioLdap usuario) {
		try {
			if (tipo == WS_JAVA){
				String res = proxy2.autenticacionAutorizacionLdap(usuario.getLogin(), usuario.getPwd());
				return res;
			} else {
				ConsultaEntradaType input = new ConsultaEntradaType(usuario.getLogin(), usuario.getPwd());
				ConsultaSalidaType salida = autenticacionPortTypeProxy.usuario(input);
				String res =  salida.getRespuesta();
				return res;
			}
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
			if (tipo == WS_JAVA){
				return Arrays.asList(proxy2.listadoMenusPerfil(usuario.getPerfil()));
			} else {
				MenuEntradaType input = new MenuEntradaType(usuario.getPerfil());
				return Arrays.asList(autenticacionPortTypeProxy.menu(input));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
