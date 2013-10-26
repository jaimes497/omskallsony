package co.com.kallsony.dal;

import co.com.kallsony.bl.entidad.Campania;

public interface ICampaniaServicio {
	
	public boolean crear(Campania campania);
	public boolean modificar(Campania campania);
	public boolean eliminar(Campania campania);
	public Object consultarCampanias();

}
