package co.com.kallsony.dal;

import co.com.kallsony.bl.entidad.Cliente;

public interface IClienteServicio {
	
	public boolean crear(Cliente cliente);
	public boolean modificar(Cliente cliente);
	public Object consultarClientes();

}
