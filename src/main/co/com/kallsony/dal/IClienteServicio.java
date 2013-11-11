package co.com.kallsony.dal;

import java.util.Calendar;

import javax.faces.model.DataModel;

import co.com.kallsony.bl.entidad.Cliente;
import co.com.kallsony.dal.utilitarios.PaginationHelper;

public interface IClienteServicio {
	
	boolean crearModificar(Cliente cliente);
	Object consultarClientes();
	PaginationHelper getPagination();
	DataModel getItems();
	String next();
	String previous();
	void recreateModel();
	boolean parametrosValidos();
	String getIdentificacion();
	void setIdentificacion(String identificacion);
	String getProdId();
	void setProdId(String prodId);
	Calendar getFechaIni();
	void setFechaIni(Calendar fechaIni);
	Calendar getFechaFin();
	void setFechaFin(Calendar fechaFin);

}
