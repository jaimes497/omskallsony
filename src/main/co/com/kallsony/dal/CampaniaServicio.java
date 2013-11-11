package co.com.kallsony.dal;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.DataModel;

import modelowebservicecampania.CampaniaServiceProxy;

import org.jboss.seam.jsf.ListDataModel;

import co.com.kallsony.bl.entidad.Campania;
import co.com.kallsony.dal.utilitarios.PaginationHelperCampania;
import co.com.kallsony.dal.utilitarios.Tranformador;

public class CampaniaServicio implements ICampaniaServicio {
	private PaginationHelperCampania pagination;
	private DataModel items = null;
	private CampaniaServiceProxy campaniaServiceProxy;
	private String campaniaId = "";
	
	public CampaniaServicio() {
		campaniaServiceProxy = new CampaniaServiceProxy();
	}

	@Override
	public boolean crearModificar(Campania campania) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Campania campania) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Campania> consultarCampanias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaginationHelperCampania getPagination() {
		if (pagination == null) {
			pagination = new PaginationHelperCampania(25);
			pagination.setTamano(this.contarRegistros());
		}
		return pagination;
	}

	public int contarRegistros() {
		try {
			return getCampaniaServiceProxy().getCampaniaService_PortType().findCampaniasCount();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public DataModel paginarCampanias() {
		try {
//			modelowebservicecampania.Campanna[] list = getProductoServicePortTypeProxy()
//					.findProductoPorParametrosRange(
//							new int[] {
//									this.getPagination().getPageFirstItem(),
//									this.getPagination().getPageFirstItem()
//											+ this.getPagination()
//													.getPageSize() }, nombre,
//							descripcion, prodId);
			ArrayList<Object> list = new ArrayList<Object>();
			if (list != null) {
				
				return new ListDataModel(Tranformador.convertirListaProducto(list));
			}
			return null;
		} catch (Exception e) {//catch (RemoteException e) {
			// TODO Auto-generated catch block
			return new ListDataModel();
		}

	}

	@Override
	public DataModel getItems() {
		if (items == null) {
			items = this.getPagination()
					.createPageDataModel(paginarCampanias());
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

	public CampaniaServiceProxy getCampaniaServiceProxy() {
		return campaniaServiceProxy;
	}

	public void setCampaniaServiceProxy(
			CampaniaServiceProxy campaniaServiceProxy) {
		this.campaniaServiceProxy = campaniaServiceProxy;
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
	public String getCampaniaId() {
		return campaniaId;
	}

	@Override
	public void setCampaniaId(String campaniaId) {
		this.campaniaId = campaniaId;
	}
	

}
