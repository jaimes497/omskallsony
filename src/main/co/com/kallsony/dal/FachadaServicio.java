package co.com.kallsony.dal;

public class FachadaServicio {
	
	private static FachadaServicio instance = null;
	
	private FachadaServicio() {}
	
	public static FachadaServicio getInstance() {
		if (instance == null) {
			instance = new FachadaServicio();
		}
		return instance;
	}
	
	public ICampaniaServicio obtenerCampaniaServicio(){
		return new CampaniaServicio();
	}
	
	public IClienteServicio obtenerClienteServicio(){
		return new ClienteServicio();
	}
	
	public IOrdenServicio obtenerOrdenServicio(){
		return new OrdenServicio();
	}
	
	public IProductoServicio obtenerProductoServicio(){
		return new ProductoServicio();
	}

}
