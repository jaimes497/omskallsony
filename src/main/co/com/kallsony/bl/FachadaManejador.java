package co.com.kallsony.bl;

import java.util.List;

import co.com.kallsony.bl.entidad.Campania;
import co.com.kallsony.bl.entidad.Cliente;
import co.com.kallsony.bl.entidad.Orden;
import co.com.kallsony.bl.entidad.Producto;


public class FachadaManejador {
	
	private static FachadaManejador instance = null;
	private ManejadorCampania mCampania;
	private ManejadorCliente mCliente;
	private ManejadorOrden mOrden;
	private ManejadorProducto mProducto;
	
	private FachadaManejador() {
		mCampania = new ManejadorCampania();
		mCliente = new ManejadorCliente();
		mOrden = new ManejadorOrden();
		mProducto = new ManejadorProducto();
	}
	
	public static FachadaManejador getInstance() {
		if (instance == null) {
			instance = new FachadaManejador();
		}
		return instance;
	}
	
	public boolean crearCampania(Campania campania){
		return mCampania.crearCampania(campania);
	}
	
	public boolean modificarCampania(Campania campania){
		return mCampania.modificarCampania(campania);
	}
	
	public boolean eliminarCampania(Campania campania){
		return mCampania.eliminarCampania(campania);
	}
	
	public List<Campania> consultarCampanias(){
		return mCampania.consultarCampanias();
	}
	
	public boolean crearCliente(Cliente cliente){
		return mCliente.crearCliente(cliente);
	}

	public boolean modificarCliente(Cliente cliente){
		return mCliente.modificarCliente(cliente);
	}

	public List<Cliente> consultarClientes(){
		return mCliente.consultarClientes();
	}

	public boolean cancelarOrden(Orden orden){
		return mOrden.cancelarOrden(orden);
	}

	public boolean eliminarOrden(Orden orden){
		return mOrden.eliminarOrden(orden);
	}

	public List<Orden> consultarOrdenes(){
		return mOrden.consultarOrdenes();
	}

	public Orden consultarOrdenPorNumero(Orden orden){
		return mOrden.consultarOrdenPorNumero(orden);
	}

	public Orden consultarOrdenPorFecha(String filtro){
		return mOrden.consultarOrdenPorFecha(IManejadorOrden.CONSULTAR_MES, filtro);
	}

	public List<Orden> consultarRankingOrdensAbiertas(){
		return mOrden.consultarRankingOrdensAbiertas();
	}

	public List<Orden> consultarRankingOrdensCerradas(){
		return mOrden.consultarRankingOrdensCerradas();
	}

	public boolean crearProducto(Producto producto){
		return mProducto.crearProducto(producto);
	}

	public boolean eliminarProducto(Producto producto){
		return mProducto.eliminarProducto(producto);
	}

	public boolean modificarProducto(Producto producto){
		return mProducto.modificarProducto(producto);
	}

	public List<Producto> consultarProductos(){
		return mProducto.consultarProductos();
	}

	public Producto consultarProductoPorCodigo(Producto producto){
		return mProducto.consultarProductoPorCodigo(producto);
	}

	public Producto consultarProductoPorNombre(Producto producto){
		return mProducto.consultarProductoPorNombre(producto);
	}

	public Producto consultarProductoPorDescripcion(Producto producto){
		return mProducto.consultarProductoPorDescripcion(producto);
	}

	public List<Producto> consultarRankingProductosMasVendidos(){
		return mProducto.consultarRankingProductosMasVendidos();
	}

	public List<Producto> consultarRankingCategoriaMasVendidas(){
		return mProducto.consultarRankingCategoriaMasVendidas();
	}

}
