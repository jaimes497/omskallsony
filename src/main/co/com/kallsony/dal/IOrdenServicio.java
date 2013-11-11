package co.com.kallsony.dal;

import java.util.Calendar;

import javax.faces.model.DataModel;

import co.com.kallsony.bl.entidad.Orden;
import co.com.kallsony.dal.utilitarios.PaginationHelper;

public interface IOrdenServicio {
	
	boolean cancelar(Orden orden);
	boolean eliminar(Orden orden);
	Object consultarOrdenes();
	Object consultarPorId(Orden orden);
	Object consultarPorProducto(Orden orden);
	Object consultarPorMes(String mes);
	Object rankingOrdenesAbiertas();
	Object rankingOrdenesCerradas();
	PaginationHelper getPagination();
	DataModel getItems();
	String next();
	String previous();
	void recreateModel();
	boolean parametrosValidos();
	String getOrdid();
	void setOrdid(String ordid);
	String getProdId();
	void setProdId(String prodId);	
	Calendar getFechaIni();
	void setFechaIni(Calendar fechaIni);
	Calendar getFechaFin();
	void setFechaFin(Calendar fechaFin);

}
