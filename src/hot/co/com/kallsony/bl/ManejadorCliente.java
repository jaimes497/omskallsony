package co.com.kallsony.bl;

import java.util.Calendar;
import java.util.List;

import javax.faces.model.DataModel;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import co.com.kallsony.bl.entidad.Cliente;
import co.com.kallsony.dal.controlador.FachadaServicio;
import co.com.kallsony.dal.utilitarios.PaginationHelper;

@Name("manejadorCliente")
@Scope(ScopeType.CONVERSATION)
public class ManejadorCliente implements IManejadorCliente {
	
	private FachadaServicio servicio;
	private Cliente cliente;
	
	public ManejadorCliente(){	
		servicio = FachadaServicio.getInstance();
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorCliente#crearCliente(co.com.kallsony.bl.entidad.Cliente)
	 */
	@Override
	public boolean registrarCliente(Cliente cliente){
		return servicio.obtenerClienteServicio().crearModificar(cliente);
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorCliente#consultarClientes()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> consultarClientes(){
		return (List<Cliente>) servicio.obtenerClienteServicio().consultarClientes();
	}
	
	public String asignar(Cliente cliente){
		this.cliente=cliente;
		return "/cliente/ClienteEdit.xhtml";
	}
	
	public String listar(){
		return "/cliente/ListaCliente.xhtml";
	}
	
	@Override
	public PaginationHelper getPagination() {
		return servicio.obtenerClienteServicio().getPagination();
	}

	@Override
	public DataModel getItems() {
		return servicio.obtenerClienteServicio().getItems();
	}

	@Override
	public String next() {
	  return servicio.obtenerClienteServicio().next();
	}
	

	@Override
	public String previous() {
		return servicio.obtenerClienteServicio().previous();
	}
	
	public void recreateModel(){
		servicio.obtenerClienteServicio().recreateModel();
	}
	
	@Override
	public boolean parametrosValidos() {
		return servicio.obtenerClienteServicio().parametrosValidos();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
	
	public String getIdentificacion() {
		return servicio.obtenerClienteServicio().getIdentificacion();
	}

	public void setIdentificacion(String identificacion) {
		servicio.obtenerClienteServicio().setIdentificacion(identificacion);
	}
	
	public String getProdId() {
		return servicio.obtenerClienteServicio().getProdId();
	}

	public void setProdId(String prodId) {
		servicio.obtenerClienteServicio().setProdId(prodId);
	}
	
	public Calendar getFechaIni() {
		return servicio.obtenerClienteServicio().getFechaIni();
	}

	public void setFechaIni(Calendar fechaIni) {
		servicio.obtenerClienteServicio().setFechaIni(fechaIni);
	}
	
	public Calendar getFechaFin() {
		return servicio.obtenerClienteServicio().getFechaFin();
	}

	public void setFechaFin(Calendar fechaFin) {
		servicio.obtenerClienteServicio().setFechaFin(fechaFin);
	}
	
}
