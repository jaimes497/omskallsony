package co.com.kallsony.dal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.model.DataModel;

import modelowebservicecliente.ClienteServicePortProxy;
import modelowebservicecliente.Customer;
import modelowebservicecliente.CustomerRanking;

import org.jboss.seam.jsf.ListDataModel;

import co.com.kallsony.bl.entidad.Cliente;
import co.com.kallsony.bl.entidad.ClienteTotal;
import co.com.kallsony.bl.entidad.Orden;
import co.com.kallsony.dal.utilitarios.PaginationHelperCliente;
import co.com.kallsony.dal.utilitarios.Tranformador;

public class ClienteServicio implements IClienteServicio {
	
	private static final int WS_JAVA = 0;
	private static final int WS_BROKER = 1;
	private int tipo = 2;
	private ClienteServicePortProxy clienteServicePortProxy2;
	
	private PaginationHelperCliente pagination;
	private DataModel items = null;

	private String prodId = "";
	
	public ClienteServicio() {
		clienteServicePortProxy2 = new ClienteServicePortProxy();
	}

	@Override
	public boolean crearModificar(Cliente cliente) {
		// 
		try {
			if (tipo == WS_JAVA) {
				String res = clienteServicePortProxy2.createUpdateCustomer(cliente.getCustid(), cliente.getFname(), 
						cliente.getLname(), cliente.getPhonenumber(), cliente.getEmail(), cliente.getPassword(), 
						cliente.getCreditcardtype(), cliente.getCreditcardnumber(), cliente.getStatus(), null);
						//createUpdateCampania(campania.getCampaniaid(), campania.getProdid(), campania.getUrl(), campania.getFecIni(), campania.getFecFin());
				if (res.equalsIgnoreCase("guardo")){
					return true;
				} else {
					return false;
				}
			} else if (tipo == WS_BROKER) {
				return true;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PaginationHelperCliente getPagination() {
		System.out.println("-->getPagination() " + pagination);
		int tamano = contarRegistros();
		if (pagination == null) {
			pagination = new PaginationHelperCliente(25);
			pagination.setTamano(tamano);
		}
		System.out.println("-->getPagination()* tamano " + pagination.getItemsCount());
		return pagination;
	}

	public int contarRegistros() {
		try {
			if (tipo == WS_JAVA) {
				return clienteServicePortProxy2.findClienteCompraProductoCount(new BigDecimal(prodId));				
			} else if (tipo == WS_BROKER) {
				return 0;
			} else {
				return 10;
			}
		} catch (Exception e) {//catch (RemoteException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public DataModel paginarClientes() {
		System.out.println("-->paginarProductos() ");
		DataModel model = new ListDataModel();
		try {
			if (tipo == WS_JAVA) {
				modelowebservicecliente.Customer[] list = clienteServicePortProxy2.findClienteCompraProducto(
						new int[] {pagination.getPageFirstItem(), pagination.getPageFirstItem() + pagination.getPageSize()}, 
						new BigDecimal(prodId));
				if (list != null) {				
					model = new ListDataModel(Tranformador.convertirListaCliente(list));
				}
			} else if (tipo == WS_BROKER) {
				
			} else {
				ArrayList<Object> list = new ArrayList<Object>();
				Cliente cliente;
				for (int i = 0; i < 10; i++) {
					cliente = new Cliente("0"+i, "nombre"+i, "apellido"+i, "1111111", "@", "E"+1);
					list.add(cliente);
				}			
				model = new ListDataModel(list);
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
				items = pagination.createPageDataModel(paginarClientes());
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
	public Object rankingFacturacion(Calendar fechaIni, Calendar fechaFin) {
		// TODO Auto-generated method stub
		List<ClienteTotal> clientes;
		try {
			if (tipo == WS_JAVA){
				CustomerRanking[] cr = clienteServicePortProxy2.findClienteFacturacion(fechaIni.getTime(), fechaFin.getTime());
				if (cr != null && cr.length > 0){
					clientes = Tranformador.convertirListaClienteTotal(cr);
					return clientes;
				} else {
					return new ArrayList<Orden>();
				}
			} else if (tipo == WS_BROKER) {
				return false;
			} else {
				List<ClienteTotal> l = new ArrayList<ClienteTotal>();
				ClienteTotal ct = new ClienteTotal("101", "nom1", new BigDecimal(1000));
				l.add(ct);
				return l;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Orden>();
		}
	}
	
	@Override
	public Object consultarClientePorId(Cliente cliente) {
		// 
		try {
			if (tipo == WS_JAVA){
				Customer cr = clienteServicePortProxy2.findCustomer(cliente.getCustid());
				if (cr != null){
					return (Cliente) Tranformador.convertirCliente(cr, cr);
				} else {
					return new ArrayList<Orden>();
				}
			} else if (tipo == WS_BROKER) {
				return false;
			} else {
				Cliente c = new Cliente("100000","nom1","app1","5551234","cust@mail","DORADO");
				return c;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Orden>();
		}
	}
	
	@Override
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
}
