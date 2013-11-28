package co.com.kallsony.dal;

import java.util.Calendar;

import javax.faces.model.DataModel;

import co.com.kallsony.bl.entidad.Cliente;
import co.com.kallsony.dal.utilitarios.PaginationHelper;

public interface IClienteServicio {
	
	boolean crearModificar(Cliente cliente);
	PaginationHelper getPagination();
	DataModel getItems();
	String next();
	String previous();
	void recreateModel();
	void setProdId(String prodId);
	Object rankingFacturacion(Calendar fechaIni, Calendar fechaFin);
	Object consultarClientePorId(Cliente cliente);

}
