package co.com.kallsony.bl;

import java.util.List;

import javax.faces.model.DataModel;

import co.com.kallsony.bl.entidad.Campania;
import co.com.kallsony.dal.utilitarios.PaginationHelper;

public interface IManejadorCampania {

	public boolean registrarCampania(Campania campania);

	public boolean eliminarCampania(Campania campania);

	public List<Campania> consultarCampanias();
	public PaginationHelper getPagination();
	public DataModel getItems();
	public String next();
	public String previous();

}