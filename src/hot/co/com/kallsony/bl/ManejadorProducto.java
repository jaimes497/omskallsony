package co.com.kallsony.bl;

import java.util.List;

import co.com.kallsony.bl.entidad.Producto;
import co.com.kallsony.dal.controlador.FachadaServicio;

public class ManejadorProducto implements IManejadorProducto {

	private FachadaServicio servicio;
	
	public ManejadorProducto(){	
		servicio = FachadaServicio.getInstance();
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorProducto#crearProducto(co.com.kallsony.bl.entidad.Producto)
	 */
	@Override
	public boolean crearProducto(Producto producto){
		return servicio.obtenerProductoServicio().crear(producto);
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorProducto#eliminarProducto(co.com.kallsony.bl.entidad.Producto)
	 */
	@Override
	public boolean eliminarProducto(Producto producto){
		return servicio.obtenerProductoServicio().eliminar(producto);
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorProducto#modificarProducto(co.com.kallsony.bl.entidad.Producto)
	 */
	@Override
	public boolean modificarProducto(Producto producto){
		return servicio.obtenerProductoServicio().modificar(producto);
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorProducto#consultarProductos()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Producto> consultarProductos(){
		return (List<Producto>) servicio.obtenerProductoServicio().consultarProductos();
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorProducto#consultarProductoPorCodigo(co.com.kallsony.bl.entidad.Producto)
	 */
	@Override
	public Producto consultarProductoPorCodigo(Producto producto){
		return (Producto) servicio.obtenerProductoServicio().consultarPorCodigo(producto);
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorProducto#consultarProductoPorNombre(co.com.kallsony.bl.entidad.Producto)
	 */
	@Override
	public Producto consultarProductoPorNombre(Producto producto){
		return (Producto) servicio.obtenerProductoServicio().consultarPorNombre(producto);
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorProducto#consultarProductoPorDescripcion(co.com.kallsony.bl.entidad.Producto)
	 */
	@Override
	public Producto consultarProductoPorDescripcion(Producto producto){
		return (Producto) servicio.obtenerProductoServicio().consultarPorDescripcion(producto);
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorProducto#consultarRankingProductosMasVendidos()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Producto> consultarRankingProductosMasVendidos(){
		return (List<Producto>) servicio.obtenerProductoServicio().rankingProductosMasVendidos();
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorProducto#consultarRankingCategoriaMasVendidas()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Producto> consultarRankingCategoriaMasVendidas(){
		return (List<Producto>) servicio.obtenerProductoServicio().rankingCategoriaMasVendidas();
	}
	
}
