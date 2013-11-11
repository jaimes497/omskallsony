package co.com.kallsony.dal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.faces.model.DataModel;

import modelowebservice.ProductoServicePortTypeProxy;

import org.jboss.seam.jsf.ListDataModel;

import co.com.kallsony.bl.entidad.Cliente;
import co.com.kallsony.bl.entidad.Orden;
import co.com.kallsony.dal.utilitarios.PaginationHelperOrden;

public class OrdenServicio implements IOrdenServicio {
	private PaginationHelperOrden pagination;
	private DataModel items = null;
	private ProductoServicePortTypeProxy productoServicePortTypeProxy;
	private String ordid = "";
	private String prodId = "";
	private Calendar fechaIni;
	private Calendar fechaFin;
	
	public OrdenServicio() {
		productoServicePortTypeProxy = new ProductoServicePortTypeProxy();
	}

	@Override
	public boolean cancelar(Orden orden) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Orden orden) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object consultarOrdenes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object consultarPorId(Orden orden) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object consultarPorProducto(Orden orden) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object consultarPorMes(String mes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object rankingOrdenesAbiertas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object rankingOrdenesCerradas() {
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
	public PaginationHelperOrden getPagination() {
		if (pagination == null) {
			pagination = new PaginationHelperOrden(25);
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
			Orden orden;
			for (int i = 0; i < 10; i++) {
				orden = new Orden("0"+i,new Cliente("0"+i),new Date(),new BigDecimal(i*1000),"A","Comment"+i);
				list.add(orden);
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
	public String getOrdid() {
		return ordid;
	}

	@Override
	public void setOrdid(String ordid) {
		this.ordid = ordid;
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
