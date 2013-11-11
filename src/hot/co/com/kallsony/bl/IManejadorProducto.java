package co.com.kallsony.bl;

import java.util.List;

import javax.faces.model.DataModel;

import co.com.kallsony.bl.entidad.Producto;
import co.com.kallsony.dal.utilitarios.PaginationHelper;

public interface IManejadorProducto {

	public boolean registrarProducto(Producto producto);

	public boolean eliminarProducto(Producto producto);

	public List<Producto> consultarProductos();

	public Producto consultarProductoPorCodigo(Producto producto);

	public Producto consultarProductoPorNombre(Producto producto);

	public Producto consultarProductoPorDescripcion(Producto producto);

	public List<Producto> consultarRankingProductosMasVendidos();

	public List<Producto> consultarRankingCategoriaMasVendidas();
	public PaginationHelper getPagination();
	public DataModel getItems();
	public String next();
	public String previous();
	public String getNombre();
	public void setNombre(String nombre);
	public String getDescripcion();
	public void setDescripcion(String descripcion);
	public String getProdId();
	public void setProdId(String prodId);
	public boolean parametrosValidos();

}