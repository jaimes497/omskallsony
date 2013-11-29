package co.com.kallsony.dal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.model.DataModel;

import modelowebserviceorders.OrdenCantidadTotal;
import modelowebserviceorders.OrderRanking;
import modelowebserviceorders.OrderServicePortProxy;
import modelowebserviceorders.Orders;
import modelowebserviceservientrega.ServientregaServiceProxy;

import org.jboss.seam.jsf.ListDataModel;

import com.pica.www.DHLService.DHLServicePortTypeProxy;

import co.com.kallsonics.Servicios.Negocio.Orden.wsdl.AdministracionOrden.AdministracionOrdenPortTypeProxy;
import co.com.kallsonics.Servicios.Negocio.Orden.xsd.cambiarEstadoOrden.CambiarEstadoOrdenEntradaType;
import co.com.kallsonics.Servicios.Negocio.Orden.xsd.cambiarEstadoOrden.CambiarEstadoOrdenSalidaType;
import co.com.kallsony.bl.entidad.Cliente;
import co.com.kallsony.bl.entidad.Orden;
import co.com.kallsony.bl.entidad.OrdenTotal;
import co.com.kallsony.dal.utilitarios.PaginationHelperOrden;
import co.com.kallsony.dal.utilitarios.Tranformador;

public class OrdenServicio implements IOrdenServicio {
	
	private static final int WS_JAVA = 0;
	private static final int WS_BROKER = 1; 
	private int tipo = 0;
	private OrderServicePortProxy orderServicePortProxy2;
	private AdministracionOrdenPortTypeProxy orderServicePortProxy;
	
	private PaginationHelperOrden pagination;
	private DataModel items = null;
	private String prodId = "";
		
	public OrdenServicio() {
		orderServicePortProxy2 = new OrderServicePortProxy();
	}

	@Override
	public boolean cancelar(Orden orden) {
		// TODO Auto-generated method stub
		try {
			if (tipo == WS_JAVA){
				String res = orderServicePortProxy2.cambiarEstadoOrden(orden.getOrdid(), "CANCELADO");
				if (res.equalsIgnoreCase("guardo")){
					return true;
				} else {
					return false;
				}
			} else if (tipo == WS_BROKER) {
				CambiarEstadoOrdenEntradaType input = new CambiarEstadoOrdenEntradaType(orden.getOrdid(), "CANCELADO");  
				CambiarEstadoOrdenSalidaType cambiarEstadoOrdenSalidaType = orderServicePortProxy.cambiarEstadoOrden(input);
				if (cambiarEstadoOrdenSalidaType != null){
					if (cambiarEstadoOrdenSalidaType.getRespuesta().equalsIgnoreCase("guardo")){
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean eliminar(Orden orden) {
		// TODO Auto-generated method stub
		try {
			if (tipo == WS_JAVA){
				String res = orderServicePortProxy2.cambiarEstadoOrden(orden.getOrdid(), "CANCELADO");
				if (res.equalsIgnoreCase("guardo")){
					return true;
				} else {
					return false;
				}
			} else if (tipo == WS_BROKER) {
				CambiarEstadoOrdenEntradaType input = new CambiarEstadoOrdenEntradaType(orden.getOrdid(), "CANCELADO");  
				CambiarEstadoOrdenSalidaType cambiarEstadoOrdenSalidaType = orderServicePortProxy.cambiarEstadoOrden(input);
				if (cambiarEstadoOrdenSalidaType != null){
					if (cambiarEstadoOrdenSalidaType.getRespuesta().equalsIgnoreCase("guardo")){
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Object consultarPorId(Orden orden) {
		// TODO Auto-generated method stub
		try {
			if (tipo == WS_JAVA){
				Orders orders = orderServicePortProxy2.findOrden(orden.getOrdid());
				Orden o = new Orden();
				if (orders != null){
					o = (Orden) Tranformador.convertirOrden(orders, orders);
					return o;
				} else {
					return new Orden();
				}
			} else if (tipo == WS_BROKER) {
				return new Orden();
			} else {
				Orden orden2 = new Orden("101", new Cliente("101"), new Date(), new BigDecimal(1000), "ABIERTA", "PRUEBA", "");
				return orden2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public PaginationHelperOrden getPagination() {
		System.out.println("-->getPagination() " + pagination);
		int tamano = contarRegistros();
		if (pagination == null) {
			pagination = new PaginationHelperOrden(25);
			pagination.setTamano(tamano);
		}
		System.out.println("-->getPagination()* tamano " + pagination.getItemsCount());
		return pagination;
	}

	public int contarRegistros() {
		try {
			if (tipo == WS_JAVA) {
				return orderServicePortProxy2.findOrderProdIdCount(new BigDecimal(prodId));				
			} else if (tipo == WS_BROKER) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public DataModel paginarProductos() {
		System.out.println("-->paginarProductos() ");
		DataModel model = new ListDataModel();
		try {
			if (tipo == WS_JAVA) {
				Orders[] list = orderServicePortProxy2.findOrderProdId(
						new int[] {pagination.getPageFirstItem(), pagination.getPageFirstItem() + pagination.getPageSize()}, new BigDecimal(prodId));
				
				if (list != null) {				
					model = new ListDataModel(Tranformador.convertirListaOrden(list));
				}
			} else if (tipo == WS_BROKER) {
				
			} else {
				Orden orden2 = new Orden("101", new Cliente("101"), new Date(), new BigDecimal(1000), "ABIERTA", "PRUEBA", "");
				List<Orden> o = new ArrayList<Orden>();
				o.add(orden2);
				model = new ListDataModel(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-->paginarProductos()* ");
		return model;
	}

	@Override
	public DataModel getItems() {
		System.out.println("-->getItems() " + items);
		if (items == null) {
			pagination = getPagination();
			if (pagination.getItemsCount() > 0){
				items = pagination.createPageDataModel(paginarProductos());
			} else {
				items = new ListDataModel();
			}
		}
		System.out.println("-->getItems()* conteo " + items.getRowCount());
		return items;
	}

	@Override
	public void recreateModel() {
		System.out.println("-->recreateModel()");
		this.pagination = null;
		this.items = null;
	}

	private void recreate() {
		items = null;
	}

	@Override
	public String next() {
		System.out.println("-->next()");
		pagination.nextPage();
		recreate();
		return null;
	}

	@Override
	public String previous() {
		System.out.println("-->previous()");
		pagination.previousPage();
		recreate();
		return null;
	}

	@Override
	public Object consultarPorMes(Calendar fechaIni, Calendar fechaFin) {
		// TODO Auto-generated method stub
		List<OrdenTotal> ordenes;
		try {
			if (tipo == WS_JAVA){
				OrdenCantidadTotal ord = orderServicePortProxy2.findOrdenTiempoCerradas(fechaIni.getTime(), fechaFin.getTime());
				if (ord != null){
					ordenes = Tranformador.convertirListaOrdenTotal(ord);
					return ordenes;
				} else {
					return false;
				}
			} else if (tipo == WS_BROKER) {
				return false;
			} else {
				OrdenTotal or = new OrdenTotal(4, new BigDecimal(10000000l));
				List<OrdenTotal> l = new ArrayList<OrdenTotal>();
				l.add(or);
				return l;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Orden>();
		}
	}
	
	@Override
	public Object consultarDetalle(Orden orden) {
		// TODO Auto-generated method stub
		try {
			if (tipo == WS_JAVA){
				Orders ord = orderServicePortProxy2.findOrden(orden.getOrdid());
				Orden orden1;
				if (ord != null){
					orden1 = (Orden) Tranformador.convertirDetalleOrden(ord);
					return orden1;
				} else {
					return false;
				}
			} else if (tipo == WS_BROKER) {
				return false;
			} else {
				return new Orden();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Orden>();
		}
	}

	@Override
	public Object rankingOrdenesAbiertas() {
		// TODO Auto-generated method stub
		List<Orden> ordenes;
		try {
			if (tipo == WS_JAVA){
				OrderRanking[] ord = orderServicePortProxy2.findRankingTiempoAbiertas();
				if (ord != null && ord.length > 0){
					ordenes = Tranformador.convertirListaOrden(ord);
					return ordenes;
				} else {
					return new ArrayList<Orden>();
				}
			} else if (tipo == WS_BROKER) {
				return false;
			} else {
				Orden or = new Orden("101", new Cliente("101"), new Date(), new BigDecimal(1000), "Activa", "Prueba", "");
				List<Orden> l = new ArrayList<Orden>();
				l.add(or);
				return l;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Orden>();
		}
	}

	@Override
	public Object rankingOrdenesCerradas(Calendar fechaIni, Calendar fechaFin) {
		// TODO Auto-generated method stub
		List<Orden> ordenes;
		try {
			if (tipo == WS_JAVA){
				OrderRanking[] ord = orderServicePortProxy2.findRankingOrdenesDinero(fechaIni.getTime(), fechaFin.getTime());
				if (ord != null && ord.length > 0){
					ordenes = Tranformador.convertirListaOrden(ord);
					return ordenes;
				} else {
					return new ArrayList<Orden>();
				}
			} else if (tipo == WS_BROKER) {
				return false;
			} else {
				Orden or = new Orden("101", new Cliente("101"), new Date(), new BigDecimal(1000), "Activa", "Prueba", "");
				List<Orden> l = new ArrayList<Orden>();
				l.add(or);
				return l;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Orden>();
		}
	}
	
	public String verificarEstadoDhl(Orden orden) {
		// 
		try {
			DHLServicePortTypeProxy dhlServicePortTypeProxy = new DHLServicePortTypeProxy();
			return dhlServicePortTypeProxy.checkShipmentStatus(orden.getOrdid());
		} catch (Exception e) {
			e.printStackTrace();
			return "-";
		}
	}
	
	public String verificarEstadoDeprisa(Orden orden) {
		// 
		try {
			ServientregaServiceProxy proxy = new ServientregaServiceProxy();
			return proxy.obtenerEstadoOrden(orden.getOrdid());
		} catch (Exception e) {
			e.printStackTrace();
			return "-";
		}
	}
	
	@Override
	public Object actualizarEstado(Orden orden) {
		try {
			Orden nuevaOrden = orden;
			String nuevoEstado = "";
			if (orden.getSupplier().equalsIgnoreCase("DHL")){
				nuevoEstado = verificarEstadoDhl(orden);
			} else if (orden.getSupplier().equalsIgnoreCase("SERVIENTREGA")){
				nuevoEstado = verificarEstadoDeprisa(orden);
			}
			nuevaOrden.setStatus(nuevoEstado);
			return nuevaOrden;
		} catch (Exception e) {
			e.printStackTrace();
			return orden;
		}
		
	}

	@Override
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}	
		
}
