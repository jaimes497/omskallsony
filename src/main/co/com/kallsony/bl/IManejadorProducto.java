package co.com.kallsony.bl;

import java.util.List;

import co.com.kallsony.bl.entidad.Producto;

public interface IManejadorProducto {

	public boolean crearProducto(Producto producto);

	public boolean eliminarProducto(Producto producto);

	public boolean modificarProducto(Producto producto);

	public List<Producto> consultarProductos();

	public Producto consultarProductoPorCodigo(Producto producto);

	public Producto consultarProductoPorNombre(Producto producto);

	public Producto consultarProductoPorDescripcion(Producto producto);

	public List<Producto> consultarRankingProductosMasVendidos();

	public List<Producto> consultarRankingCategoriaMasVendidas();

}