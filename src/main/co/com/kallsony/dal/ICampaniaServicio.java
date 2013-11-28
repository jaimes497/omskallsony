package co.com.kallsony.dal;

import co.com.kallsony.bl.entidad.Campania;

public interface ICampaniaServicio {
	
	boolean crearModificar(Campania campania);
	boolean eliminar(Campania campania);
	Object consultarCampanias();
	
}
