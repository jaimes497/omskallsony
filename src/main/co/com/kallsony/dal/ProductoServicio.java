package co.com.kallsony.dal;

import java.rmi.RemoteException;
import java.util.Arrays;

import javax.faces.model.DataModel;

import modelowebservice.ProductoServicePortTypeProxy;

import org.jboss.seam.jsf.ListDataModel;

import co.com.kallsony.bl.entidad.Producto;
import co.com.kallsony.dal.utilitarios.PaginationHelperProducto;
import co.com.kallsony.dal.utilitarios.Tranformador;

public class ProductoServicio implements IProductoServicio {
	private PaginationHelperProducto pagination;
	private DataModel items = null;
	private ProductoServicePortTypeProxy productoServicePortTypeProxy;
	private String nombre = "";
	private String descripcion = "";
	private String prodId = "";

	public ProductoServicio() {
		productoServicePortTypeProxy = new ProductoServicePortTypeProxy();
	}

	@Override
	public boolean crear(Producto producto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Producto producto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Producto producto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object consultarProductos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object consultarPorCodigo(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object consultarPorNombre(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object consultarPorDescripcion(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object rankingProductosMasVendidos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object rankingCategoriaMasVendidas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaginationHelperProducto getPagination() {
		if (pagination == null) {
			pagination = new PaginationHelperProducto(25);
			pagination.setTamaño(this.contarRegistros());
		}
		return pagination;
	}

	public int contarRegistros() {
		try {
			return getProductoServicePortTypeProxy()
					.findProductoCountParametros(nombre, descripcion, prodId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public DataModel paginarProductos() {
		try {
			modelowebservice.Producto[] list = getProductoServicePortTypeProxy()
					.findProductoPorParametrosRange(
							new int[] {
									this.getPagination().getPageFirstItem(),
									this.getPagination().getPageFirstItem()
											+ this.getPagination()
													.getPageSize() }, nombre,
							descripcion, prodId);
			if (list != null) {
				
				return new ListDataModel(Tranformador.convertirListaProducto(list));
			}
			return null;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			return new ListDataModel();
		}

	}

	@Override
	public DataModel getItems() {
		if (items == null) {
			items = this.getPagination()
					.createPageDataModel(paginarProductos());
		}
		return items;
	}

	@Override
	public void recreateModel() {
		this.pagination = null;
		this.items = null;
	}

	private void recreate() {
		items = null;
	}

	@Override
	public String next() {
		getPagination().nextPage();
		recreate();
		return null;
	}

	@Override
	public String previous() {
		getPagination().previousPage();
		recreate();
		return null;
	}

	public ProductoServicePortTypeProxy getProductoServicePortTypeProxy() {
		return productoServicePortTypeProxy;
	}

	public void setProductoServicePortTypeProxy(
			ProductoServicePortTypeProxy productoServicePortTypeProxy) {
		this.productoServicePortTypeProxy = productoServicePortTypeProxy;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String getDescripcion() {
		return this.descripcion;
	}

	@Override
	public String getProdId() {
		return this.prodId;
	}

	@Override
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public boolean parametrosValidos() {
		if ((this.nombre != null && !this.nombre.isEmpty())
				|| (this.descripcion != null && !this.descripcion.isEmpty())
				|| (this.prodId != null && !this.prodId.isEmpty())) {
			return true;
		}
		return false;
	}

}
