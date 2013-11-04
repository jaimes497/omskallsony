package co.com.kallsony.dal.controlador;

import co.com.kallsony.dal.CampaniaServicio;
import co.com.kallsony.dal.ClienteServicio;
import co.com.kallsony.dal.ICampaniaServicio;
import co.com.kallsony.dal.IClienteServicio;
import co.com.kallsony.dal.IOrdenServicio;
import co.com.kallsony.dal.IProductoServicio;
import co.com.kallsony.dal.OrdenServicio;
import co.com.kallsony.dal.ProductoServicio;

public class FachadaServicio {
	
	private static FachadaServicio instance = null;
	 private static  CampaniaServicio campaniaServicio;
	 private ProductoServicio productoServicio;
	private FachadaServicio() {}
	
	public static FachadaServicio getInstance() {
		if (instance == null) {
			instance = new FachadaServicio();
			
		}
		return instance;
	}
	
	public ICampaniaServicio obtenerCampaniaServicio(){
		if(campaniaServicio==null)
		{ 
			campaniaServicio=new CampaniaServicio();
		}
		return campaniaServicio;
	}
	
	public IClienteServicio obtenerClienteServicio(){
		return new ClienteServicio();
	}
	
	public IOrdenServicio obtenerOrdenServicio(){
		return new OrdenServicio();
	}
	
	public IProductoServicio obtenerProductoServicio(){
		if(productoServicio==null)
		{ 
			productoServicio=new ProductoServicio();
		}
		return productoServicio;
	}

}
