package co.com.kallsony.bl;

import java.util.List;

import co.com.kallsony.bl.entidad.Cliente;

public interface IManejadorCliente {

	public boolean crearCliente(Cliente cliente);

	public boolean modificarCliente(Cliente cliente);

	public List<Cliente> consultarClientes();

}