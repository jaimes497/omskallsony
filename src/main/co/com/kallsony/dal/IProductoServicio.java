package co.com.kallsony.dal;

import java.util.Calendar;

import javax.faces.model.DataModel;

import co.com.kallsony.bl.entidad.Producto;
import co.com.kallsony.dal.utilitarios.PaginationHelper;

public interface IProductoServicio {
	
	boolean crearModificar(Producto producto);
	boolean eliminar(Producto producto);
	Object rankingProductosMasVendidos(Calendar fechaIni, Calendar fechaFin);
	Object rankingCategoriaMasVendidas(Calendar fechaIni, Calendar fechaFin);
	PaginationHelper getPagination();
	DataModel getItems();
	String next();
	String previous();
	void recreateModel();
	String getNombre();
	void setNombre(String nombre);
	String getDescripcion();
	void setDescripcion(String descripcion);
	String getProdId();
	void setProdId(String prodId);

}
