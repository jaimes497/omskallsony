package co.com.kallsony.dal;

import co.com.kallsony.bl.entidad.Producto;

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

}
