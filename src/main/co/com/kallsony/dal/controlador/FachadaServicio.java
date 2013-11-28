package co.com.kallsony.dal.controlador;

import co.com.kallsony.dal.CampaniaServicio;
import co.com.kallsony.dal.ClienteServicio;
import co.com.kallsony.dal.ICampaniaServicio;
import co.com.kallsony.dal.IClienteServicio;
import co.com.kallsony.dal.IOrdenServicio;
import co.com.kallsony.dal.IProductoServicio;
import co.com.kallsony.dal.ISeguridadServicio;
import co.com.kallsony.dal.OrdenServicio;
import co.com.kallsony.dal.ProductoServicio;
import co.com.kallsony.dal.SeguridadServicio;

public class FachadaServicio {

	private static FachadaServicio instance = null;
	private CampaniaServicio campaniaServicio;
	private ProductoServicio productoServicio;
	private ClienteServicio clienteServicio;
	private OrdenServicio ordenServicio;
	private SeguridadServicio seguridadServicio;

	private FachadaServicio() {
	}

	public static FachadaServicio getInstance() {
		if (instance == null) {
			instance = new FachadaServicio();
		}
		return instance;
	}

	public ICampaniaServicio obtenerCampaniaServicio() {
		if (campaniaServicio == null) {
			campaniaServicio = new CampaniaServicio();
		}
		return campaniaServicio;
	}

	public IClienteServicio obtenerClienteServicio() {
		if (clienteServicio == null) {
			clienteServicio = new ClienteServicio();
		}
		return clienteServicio;
	}

	public IOrdenServicio obtenerOrdenServicio() {
		if (ordenServicio == null) {
			ordenServicio = new OrdenServicio();
		}
		return ordenServicio;
	}

	public IProductoServicio obtenerProductoServicio() {
		if (productoServicio == null) {
			productoServicio = new ProductoServicio();
		}
		return productoServicio;
	}
	
	public ISeguridadServicio obtenerSeguridadServicio() {
		if (seguridadServicio == null) {
			seguridadServicio = new SeguridadServicio();
		}
		return seguridadServicio;
	}

}
