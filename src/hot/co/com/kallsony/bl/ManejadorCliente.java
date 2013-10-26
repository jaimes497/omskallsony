package co.com.kallsony.bl;

import java.util.List;

import co.com.kallsony.bl.entidad.Cliente;
import co.com.kallsony.dal.controlador.FachadaServicio;

public class ManejadorCliente implements IManejadorCliente {
	
	private FachadaServicio servicio;
	
	public ManejadorCliente(){	
		servicio = FachadaServicio.getInstance();
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorCliente#crearCliente(co.com.kallsony.bl.entidad.Cliente)
	 */
	@Override
	public boolean crearCliente(Cliente cliente){
		return servicio.obtenerClienteServicio().crear(cliente);
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorCliente#modificarCliente(co.com.kallsony.bl.entidad.Cliente)
	 */
	@Override
	public boolean modificarCliente(Cliente cliente){
		return servicio.obtenerClienteServicio().modificar(cliente);
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorCliente#consultarClientes()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> consultarClientes(){
		return (List<Cliente>) servicio.obtenerClienteServicio().consultarClientes();
	}

}
