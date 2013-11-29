package co.com.kallsony.dal;

import java.util.Calendar;

import javax.faces.model.DataModel;

import co.com.kallsony.bl.entidad.Orden;
import co.com.kallsony.dal.utilitarios.PaginationHelperOrden;

public interface IOrdenServicio {
	
	boolean cancelar(Orden orden);
	boolean eliminar(Orden orden);
	Object consultarPorId(Orden orden);
	Object consultarPorMes(Calendar fechaIni, Calendar fechaFin);
	Object rankingOrdenesAbiertas();
	Object rankingOrdenesCerradas(Calendar fechaIni, Calendar fechaFin);
	Object actualizarEstado(Orden orden);
	Object consultarDetalle(Orden orden); 
	PaginationHelperOrden getPagination();
	DataModel getItems();
	void recreateModel();
	String next();
	String previous();
	void setProdId(String prodId);

}
