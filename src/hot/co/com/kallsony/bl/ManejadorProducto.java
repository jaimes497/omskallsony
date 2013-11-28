package co.com.kallsony.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.model.DataModel;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;

import co.com.kallsony.bl.entidad.Producto;
import co.com.kallsony.bl.entidad.ProductoTotal;
import co.com.kallsony.dal.controlador.FachadaServicio;
import co.com.kallsony.dal.utilitarios.PaginationHelper;
import co.com.kallsony.imagen.ArchivoImagen;
import co.com.kallsony.imagen.ArchivoLogo;

@Name("manejadorProducto")
@Scope(ScopeType.CONVERSATION)
public class ManejadorProducto implements IManejadorProducto {

	private FachadaServicio servicio;
	private Producto producto;
	private String nombre = "";
	private String descripcion = "";
	private String prodId = "";
	private Date fechaIni;
	private Date fechaFin;
	private List<ProductoTotal> productos;
	
	@In(create = true)
	ArchivoImagen		archivoImagen;
	@In(create = true)
	ArchivoLogo		archivoLogo;
	@In
	FacesMessages	facesMessages;
	
	public ManejadorProducto() {
		servicio = FachadaServicio.getInstance();
		producto = new Producto();
	}

	@Override
	public boolean registrarProducto(Producto producto) {
		try {
			String rutaImagen = "c:" + System.getProperty("file.separator") + "Temp" + System.getProperty("file.separator") + "images";
			String rutaLogo = "c:" + System.getProperty("file.separator") + "Temp" + System.getProperty("file.separator") + "logo";
			String respuesta = archivoImagen.guardar(rutaImagen, producto.getName(), null);
			if (respuesta == null){
				return false;
			}
			System.out.println("archivo: " + respuesta);
			System.out.println("ruta: " + "/Content/Thumbnail/" + respuesta);
			producto.setImageurl("/Content/Thumbnail/" + producto.getProdid() + "_" + respuesta);
			respuesta = archivoLogo.guardar(rutaLogo, producto.getName(), null);
			if (respuesta == null){
				return false;
			}
			System.out.println("archivo: " + respuesta);
			System.out.println("ruta: " + "/Content/Images/" + respuesta);
			producto.setImageurl("/Content/Images/" + producto.getProdid() + "_" + respuesta);
			boolean ok = servicio.obtenerProductoServicio().crearModificar(producto);
			if (ok) {
				this.facesMessages.clear();
				this.facesMessages.add(Severity.INFO, "EL REGISTRO DEL PRODUCTO HA SIDO EXITOSO! :-)");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.facesMessages.add(Severity.ERROR, "LA CARGA NO HA SIDO EXITOSA! :-)");
		return false;
	}

	@Override
	public boolean eliminarProducto(Producto producto) {
		return servicio.obtenerProductoServicio().eliminar(producto);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void consultarRankingProductosMasVendidos() {
		Calendar ini = Calendar.getInstance();
		Calendar fin = Calendar.getInstance();
		ini.setTime(fechaIni);
		fin.setTime(fechaFin);
		
		productos = (List<ProductoTotal>) servicio.obtenerProductoServicio().rankingProductosMasVendidos(ini, fin);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void consultarRankingCategoriaMasVendidas() {
		Calendar ini = Calendar.getInstance();
		Calendar fin = Calendar.getInstance();
		ini.setTime(fechaIni);
		fin.setTime(fechaFin);
		
		productos = (List<ProductoTotal>) servicio.obtenerProductoServicio().rankingCategoriaMasVendidas(ini, fin);
	}

	public String asignar(Object producto) {
		if (producto instanceof Producto){
			this.producto = (Producto) producto;
		} else if (producto instanceof ProductoTotal){
			ProductoTotal pt = (ProductoTotal) producto;
			this.producto = new Producto(new BigDecimal(pt.getTotal()), pt.getNombre());
			this.producto.setListPrice(pt.getPrice());
		}
		return "/producto/ProductoEdit.xhtml";
	}

	public String listar() {
		return "/producto/Producto.xhtml";
	}

	public PaginationHelper getPagination() {
		return servicio.obtenerProductoServicio().getPagination();
	}

	public DataModel getItems() {
		return servicio.obtenerProductoServicio().getItems();
	}

	public String next() {
		return servicio.obtenerProductoServicio().next();
	}

	public String previous() {
		return servicio.obtenerProductoServicio().previous();
	}
	
	public boolean parametrosValidos() {
		if ((this.nombre != null && !this.nombre.isEmpty())
				|| (this.descripcion != null && !this.descripcion.isEmpty())
				|| (this.prodId != null && !this.prodId.isEmpty())
				|| (this.fechaIni != null)
				|| (this.fechaFin != null)) {
			System.out.println("-->parametrosValidos()");
			System.out.println("-->nombre " + nombre);
			System.out.println("-->descripcion " + descripcion);
			System.out.println("-->prodId " + prodId);
			System.out.println("-->fechaIni " + fechaIni.toString());
			System.out.println("-->fechaIni " + fechaFin.toString());
			return true;
		}
		return false;
	}
	
	public void recreateModel() {
		servicio.obtenerProductoServicio().setDescripcion(descripcion);
		servicio.obtenerProductoServicio().setNombre(nombre);
		servicio.obtenerProductoServicio().setProdId(prodId);
		servicio.obtenerProductoServicio().recreateModel();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public List<ProductoTotal> getProductos() {
		return productos;		
	}

}
