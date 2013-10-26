package co.com.kallsony.bl;

import java.util.List;

import co.com.kallsony.bl.entidad.Campania;
import co.com.kallsony.bl.entidad.Cliente;
import co.com.kallsony.bl.entidad.Orden;
import co.com.kallsony.bl.entidad.Producto;


public class FachadaManejador {
	
	private static FachadaManejador instance = null;
	private IManejadorCampania iCampania;
	private IManejadorCliente iCliente;
	private IManejadorOrden iOrden;
	private IManejadorProducto iProducto;
	
	private FachadaManejador() {}
	
	public static FachadaManejador getInstance() {
		if (instance == null) {
			instance = new FachadaManejador();
		}
		return instance;
	}
	
	public boolean crearCampania(Campania campania){
		return iCampania.crearCampania(campania);
	}
	
	public boolean modificarCampania(Campania campania){
		return iCampania.modificarCampania(campania);
	}
	
	public boolean eliminarCampania(Campania campania){
		return iCampania.eliminarCampania(campania);
	}
	
	public List<Campania> consultarCampanias(){
		return iCampania.consultarCampanias();
	}
	
	public boolean crearCliente(Cliente cliente){
		return iCliente.crearCliente(cliente);
	}

	public boolean modificarCliente(Cliente cliente){
		return iCliente.modificarCliente(cliente);
	}

	public List<Cliente> consultarClientes(){
		return iCliente.consultarClientes();
	}

	public boolean cancelarOrden(Orden orden){
		return iOrden.cancelarOrden(orden);
	}

	public boolean eliminarOrden(Orden orden){
		return iOrden.eliminarOrden(orden);
	}

	public List<Orden> consultarOrdenes(){
		return iOrden.consultarOrdenes();
	}

	public Orden consultarOrdenPorNumero(Orden orden){
		return iOrden.consultarOrdenPorNumero(orden);
	}

	public Orden consultarOrdenPorFecha(String filtro){
		return iOrden.consultarOrdenPorFecha(IManejadorOrden.CONSULTAR_MES, filtro);
	}

	public List<Orden> consultarRankingOrdensAbiertas(){
		return iOrden.consultarRankingOrdensAbiertas();
	}

	public List<Orden> consultarRankingOrdensCerradas(){
		return iOrden.consultarRankingOrdensCerradas();
	}

	public boolean crearProducto(Producto producto){
		return iProducto.crearProducto(producto);
	}

	public boolean eliminarProducto(Producto producto){
		return iProducto.eliminarProducto(producto);
	}

	public boolean modificarProducto(Producto producto){
		return iProducto.modificarProducto(producto);
	}

	public List<Producto> consultarProductos(){
		return iProducto.consultarProductos();
	}

	public Producto consultarProductoPorCodigo(Producto producto){
		return iProducto.consultarProductoPorCodigo(producto);
	}

	public Producto consultarProductoPorNombre(Producto producto){
		return iProducto.consultarProductoPorNombre(producto);
	}

	public Producto consultarProductoPorDescripcion(Producto producto){
		return iProducto.consultarProductoPorDescripcion(producto);
	}

	public List<Producto> consultarRankingProductosMasVendidos(){
		return iProducto.consultarRankingProductosMasVendidos();
	}

	public List<Producto> consultarRankingCategoriaMasVendidas(){
		return iProducto.consultarRankingCategoriaMasVendidas();
	}

}
