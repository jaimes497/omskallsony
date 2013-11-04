package co.com.kallsony.dal;

import javax.faces.model.DataModel;

import co.com.kallsony.bl.entidad.Campania;
import co.com.kallsony.dal.utilitarios.PaginationHelper;

public interface ICampaniaServicio {
	
	public boolean crear(Campania campania);
	public boolean modificar(Campania campania);
	public boolean eliminar(Campania campania);
	public Object consultarCampanias();
	public PaginationHelper getPagination();
	public DataModel getItems();
	public String next();
	public String previous();
	

}
