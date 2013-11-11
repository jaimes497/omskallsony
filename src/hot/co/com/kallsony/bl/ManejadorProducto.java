package co.com.kallsony.bl;

import java.util.Calendar;
import java.util.List;

import javax.faces.model.DataModel;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import co.com.kallsony.bl.entidad.Producto;
import co.com.kallsony.dal.controlador.FachadaServicio;
import co.com.kallsony.dal.utilitarios.PaginationHelper;

@Name("manejadorProducto")
@Scope(ScopeType.CONVERSATION)
public class ManejadorProducto implements IManejadorProducto {

	private FachadaServicio servicio;
	private Producto producto;
	
	public ManejadorProducto(){	
		servicio = FachadaServicio.getInstance();
	}
	
	@Override
	public boolean registrarProducto(Producto producto){
		return servicio.obtenerProductoServicio().crearModificar(producto);
	}
	
	@Override
	public boolean eliminarProducto(Producto producto){
		return servicio.obtenerProductoServicio().eliminar(producto);
	}
	
	public String asignar(Producto producto){
		this.producto=producto;
		return "/producto/ProductoEdit.xhtml";
	}
	
	public String listar(){
		return "/producto/ListaProducto.xhtml";
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

	@Override
	public PaginationHelper getPagination() {
		return servicio.obtenerProductoServicio().getPagination();
	}

	@Override
	public DataModel getItems() {
		return servicio.obtenerProductoServicio().getItems();
	}

	@Override
	public String next() {
	  return servicio.obtenerProductoServicio().next();
	}
	

	@Override
	public String previous() {
		return servicio.obtenerProductoServicio().previous();
	}

	@Override
	public String getNombre() {
		return servicio.obtenerProductoServicio().getNombre();
	}

	@Override
	public void setNombre(String nombre) {
	    servicio.obtenerProductoServicio().setNombre(nombre);
		
	}
	
	public void recreateModel(){
		servicio.obtenerProductoServicio().recreateModel();
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return servicio.obtenerProductoServicio().getDescripcion();
	}

	@Override
	public void setDescripcion(String descripcion) {
		servicio.obtenerProductoServicio().setDescripcion(descripcion);
		
	}

	@Override
	public String getProdId() {
		// TODO Auto-generated method stub
		return servicio.obtenerProductoServicio().getProdId();
	}

	@Override
	public void setProdId(String prodId) {
		 servicio.obtenerProductoServicio().setProdId(prodId);
		
	}
	
	public Calendar getFechaIni() {
		return servicio.obtenerProductoServicio().getFechaIni();
	}

	public void setFechaIni(Calendar fechaIni) {
		servicio.obtenerProductoServicio().setFechaIni(fechaIni);
	}

	public Calendar getFechaFin() {
		return servicio.obtenerProductoServicio().getFechaIni();
	}

	public void setFechaFin(Calendar fechaFin) {
		servicio.obtenerProductoServicio().setFechaFin(fechaFin);
	}

	@Override
	public boolean parametrosValidos() {
		return servicio.obtenerProductoServicio().parametrosValidos();
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
}
