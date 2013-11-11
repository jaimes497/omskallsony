package co.com.kallsony.dal;

import javax.faces.model.DataModel;

import co.com.kallsony.bl.entidad.Campania;
import co.com.kallsony.dal.utilitarios.PaginationHelper;

public interface ICampaniaServicio {
	
	boolean crearModificar(Campania campania);
	boolean eliminar(Campania campania);
	Object consultarCampanias();
	PaginationHelper getPagination();
	DataModel getItems();
	String next();
	String previous();
	void recreateModel();
	boolean parametrosValidos();
	String getCampaniaId();
	void setCampaniaId(String campaniaId);

}
