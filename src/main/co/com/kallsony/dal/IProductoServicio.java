package co.com.kallsony.dal;

import java.math.BigDecimal;

import javax.faces.model.DataModel;

import co.com.kallsony.bl.entidad.Producto;
import co.com.kallsony.dal.utilitarios.PaginationHelper;

public interface IProductoServicio {
	
	public boolean crear(Producto producto);
	public boolean eliminar(Producto producto);
	public boolean modificar(Producto producto);
	public Object consultarProductos();
	public Object consultarPorCodigo(Producto producto);
	public Object consultarPorNombre(Producto producto);
	public Object consultarPorDescripcion(Producto producto);
	public Object rankingProductosMasVendidos();
	public Object rankingCategoriaMasVendidas();
	public PaginationHelper getPagination();
	public DataModel getItems();
	public String next();
	public String previous();
	public void recreateModel();
	public String getNombre();
	public void setNombre(String nombre);
	public String getDescripcion();
	public void setDescripcion(String descripcion);
	public String getProdId();
	public void setProdId(String prodId);
	public boolean parametrosValidos();

}
