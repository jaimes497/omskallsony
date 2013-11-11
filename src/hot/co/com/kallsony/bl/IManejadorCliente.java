package co.com.kallsony.bl;

import java.util.List;

import javax.faces.model.DataModel;

import co.com.kallsony.bl.entidad.Cliente;
import co.com.kallsony.dal.utilitarios.PaginationHelper;

public interface IManejadorCliente {

	public boolean registrarCliente(Cliente cliente);

	public List<Cliente> consultarClientes();

	public boolean parametrosValidos();

	public PaginationHelper getPagination();

	public DataModel getItems();

	public String next();

	public String previous();

}