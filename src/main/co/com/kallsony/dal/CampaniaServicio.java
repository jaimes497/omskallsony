package co.com.kallsony.dal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelowebservicecampania.CampaniaServiceProxy;
import co.com.kallsonics.Servicios.Negocio.Campana.wsdl.AdministracionCampana.AdministracionCampanaPortTypeProxy;
import co.com.kallsonics.Servicios.Negocio.Campana.xsd.actualizarCampana.ActualizarEntradaType;
import co.com.kallsonics.Servicios.Negocio.Campana.xsd.actualizarCampana.ActualizarSalidaType;
import co.com.kallsonics.Servicios.Negocio.Campana.xsd.consultarCampana.ConsultaEntradaType;
import co.com.kallsonics.Servicios.Negocio.Campana.xsd.consultarCampana.InfoCampanna;
import co.com.kallsonics.Servicios.Negocio.Campana.xsd.eliminarCampana.EliminarEntradaType;
import co.com.kallsonics.Servicios.Negocio.Campana.xsd.eliminarCampana.EliminarSalidaType;
import co.com.kallsony.bl.entidad.Campania;
import co.com.kallsony.dal.utilitarios.Tranformador;

public class CampaniaServicio implements ICampaniaServicio {
	
	private static final int WS_JAVA = 0;
	private static final int WS_BROKER = 1;
	private int tipo = 1;
	
	private CampaniaServiceProxy campaniaServiceProxy2; 
	private AdministracionCampanaPortTypeProxy campaniaServiceProxy; 
		
	public CampaniaServicio() {
		if (tipo == WS_JAVA) {
			campaniaServiceProxy2 = new CampaniaServiceProxy();
		} else if (tipo == WS_BROKER) {
			campaniaServiceProxy = new AdministracionCampanaPortTypeProxy();
		}
	}

	@Override
	public boolean crearModificar(Campania campania) {
		// Actualiza una campania		
		try {
			if (tipo == WS_JAVA) {
				String res = campaniaServiceProxy2.createUpdateCampania(campania.getCampaniaid(), campania.getProdid(), campania.getUrl(), campania.getFecIni(), campania.getFecFin());
				if (res.equalsIgnoreCase("guardo")){
					return true;
				} else {
					return false;
				}
			} else if (tipo == WS_BROKER) {
				ActualizarEntradaType input = new ActualizarEntradaType();
				input = (ActualizarEntradaType) Tranformador.convertirCampania(campania, input);
				ActualizarSalidaType actualizarSalidaType = campaniaServiceProxy.actualizarCampana(input);
				if (actualizarSalidaType != null){
					if (actualizarSalidaType.getRespuesta().equalsIgnoreCase("guardo")){
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean eliminar(Campania campania) {
		// Elimina una campania
		try {
			if (tipo == WS_JAVA) {
				String res = campaniaServiceProxy2.eliminarCampania(campania.getCampaniaid());
				if (res.equalsIgnoreCase("guardo")){
					return true;
				} else {
					return false;
				}
			} else if (tipo == WS_BROKER) {
				EliminarEntradaType input = new EliminarEntradaType();
				input = (EliminarEntradaType) Tranformador.convertirCampania(campania, input);
				EliminarSalidaType eliminarSalidaType = campaniaServiceProxy.eliminarCampana(input);
				if (eliminarSalidaType != null){
					if (eliminarSalidaType.getRespuesta().equalsIgnoreCase("guardo")){
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Campania> consultarCampanias() {
		// Consulta todas las campanias
		try {
			if (tipo == WS_JAVA) {
				if (campaniaServiceProxy2.findCampanias() != null && campaniaServiceProxy2.findCampanias().length > 0) {
					return Tranformador.convertirListaCampania(campaniaServiceProxy2.findCampanias());
				} else {
					return new ArrayList<Campania>();
				}
			} else if (tipo == WS_BROKER) {
				ConsultaEntradaType input = new ConsultaEntradaType();
				InfoCampanna[] respuesta = campaniaServiceProxy.consultaCampana(input);
				if (respuesta != null && respuesta.length > 0){
					return Tranformador.convertirListaCampania(respuesta);
				} else {
					return new ArrayList<Campania>();
				}
			} else {
				List<Campania> c = new ArrayList<Campania>();
				Campania ca = new Campania(new BigDecimal("1"), new BigInteger("1"),"",new Date(), new Date());
				c.add(ca);
				return c;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Campania>();
		}
	}

}
