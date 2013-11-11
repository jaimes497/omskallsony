package co.com.kallsony.dal;

import java.util.ArrayList;
import java.util.Calendar;

import javax.faces.model.DataModel;

import modelowebservice.ProductoServicePortTypeProxy;

import org.jboss.seam.jsf.ListDataModel;

import co.com.kallsony.bl.entidad.Cliente;
import co.com.kallsony.dal.utilitarios.PaginationHelperCliente;

public class ClienteServicio implements IClienteServicio {
	private PaginationHelperCliente pagination;
	private DataModel items = null;
	private ProductoServicePortTypeProxy productoServicePortTypeProxy;
	private String identificacion = "";
	private String prodId = "";
	private Calendar fechaIni;
	private Calendar fechaFin;
	
	public ClienteServicio() {
		productoServicePortTypeProxy = new ProductoServicePortTypeProxy();
	}

	@Override
	public boolean crearModificar(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object consultarClientes() {
		// TODO Auto-generated method stub
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
	public PaginationHelperCliente getPagination() {
		if (pagination == null) {
			pagination = new PaginationHelperCliente(25);
			pagination.setTamano(this.contarRegistros());
		}
		return pagination;
	}

	public int contarRegistros() {
		try {
			//return getProductoServicePortTypeProxy().findProductoCountParametros(nombre, descripcion, prodId);
			return 10;
		} catch (Exception e) {//catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public DataModel paginarClientes() {
		try {
//			modelowebservice.Producto[] list = getProductoServicePortTypeProxy()
//					.findProductoPorParametrosRange(
//							new int[] {
//									this.getPagination().getPageFirstItem(),
//									this.getPagination().getPageFirstItem()
//											+ this.getPagination()
//													.getPageSize() }, identificacion,
//							prodId);
			ArrayList<Object> list = new ArrayList<Object>();
			Cliente cliente;
			for (int i = 0; i < 10; i++) {
				cliente = new Cliente("0"+i, "nombre"+i, "apellido"+i, "1111111", "@", "E"+1);
				list.add(cliente);
			}			
			return new ListDataModel(list);
//			if (list != null) {
//				
//				return new ListDataModel(Tranformador.convertirListaCliente(list));
//			}
//			return null;
		} catch (Exception e) {//catch (RemoteException e) {
			// TODO Auto-generated catch block
			return new ListDataModel();
		}

	}

	@Override
	public DataModel getItems() {
		if (items == null) {
			items = this.getPagination()
					.createPageDataModel(paginarClientes());
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
	
	@Override
	public boolean parametrosValidos() {
//		if ((this.nombre != null && !this.nombre.isEmpty())
//				|| (this.descripcion != null && !this.descripcion.isEmpty())
//				|| (this.prodId != null && !this.prodId.isEmpty())) {
//			return true;
//		}
//		return false;
		return true;
	}

	@Override
	public String getIdentificacion() {
		return identificacion;
	}

	@Override
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	@Override
	public String getProdId() {
		return prodId;
	}

	@Override
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	@Override
	public Calendar getFechaIni() {
		return fechaIni;
	}

	@Override
	public void setFechaIni(Calendar fechaIni) {
		this.fechaIni = fechaIni;
	}

	@Override
	public Calendar getFechaFin() {
		return fechaFin;
	}

	@Override
	public void setFechaFin(Calendar fechaFin) {
		this.fechaFin = fechaFin;
	}

}
