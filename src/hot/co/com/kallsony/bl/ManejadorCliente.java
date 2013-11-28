package co.com.kallsony.bl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.model.DataModel;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;

import co.com.kallsony.bl.entidad.Cliente;
import co.com.kallsony.bl.entidad.ClienteTotal;
import co.com.kallsony.dal.controlador.FachadaServicio;
import co.com.kallsony.dal.utilitarios.PaginationHelper;

@Name("manejadorCliente")
@Scope(ScopeType.CONVERSATION)
public class ManejadorCliente implements IManejadorCliente {
	
	private FachadaServicio servicio;
	private Cliente cliente;
	private Cliente clienteConsultado;
	private List<ClienteTotal> clienteTotal;
	private String prodId = "";
	private String identificacion = "";
	private Date fechaIni;
	private Date fechaFin;
	private boolean flag;
	private boolean flag2;
	
	@In
	FacesMessages facesMessages;
	
	public ManejadorCliente(){	
		servicio = FachadaServicio.getInstance();
		flag = false;
		flag2 = false;
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorCliente#crearCliente(co.com.kallsony.bl.entidad.Cliente)
	 */
	@Override
	public boolean registrarCliente(Cliente cliente){
		//return servicio.obtenerClienteServicio().crearModificar(cliente);
		try {
			boolean ok = servicio.obtenerClienteServicio().crearModificar(cliente);
			if (ok) {
				this.facesMessages.clear();
				this.facesMessages.add(Severity.INFO, "EL REGISTRO DEL CLIENTE HA SIDO EXITOSO! :-)");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.facesMessages.add(Severity.ERROR, "EL REGISTRO NO HA SIDO EXITOSO! :-)");
		return false;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void consultarRankingFacturacion(){
		Calendar ini = Calendar.getInstance();
		Calendar fin = Calendar.getInstance();
		ini.setTime(fechaIni);
		fin.setTime(fechaFin);
		
		this.clienteTotal = (List<ClienteTotal>) servicio.obtenerClienteServicio().rankingFacturacion(ini, fin);
	}
	
	public void consultarClientePorID(String custid) {
		Cliente cliente = new Cliente();
		cliente.setCustid(custid);
		clienteConsultado = (Cliente) servicio.obtenerClienteServicio().consultarClientePorId(cliente);
		flag = true;
		this.identificacion = "";
	}
	
	public void consultar() {
		if (this.identificacion != null && !this.identificacion.isEmpty()) {
			consultarClientePorID(identificacion);
		} else if (this.prodId != null && !this.prodId.isEmpty()) {
			recreateModel();
		}
	}
		
	public String asignar(Cliente cliente){
		this.cliente=cliente;
		return "/cliente/ClienteEdit.xhtml";
	}
	
	public String listar(){
		return "/cliente/ListaCliente.xhtml";
	}
	
	public PaginationHelper getPagination() {
		return servicio.obtenerClienteServicio().getPagination();
	}

	public DataModel getItems() {
		return servicio.obtenerClienteServicio().getItems();
	}

	public String next() {
	  return servicio.obtenerClienteServicio().next();
	}
	
	public String previous() {
		return servicio.obtenerClienteServicio().previous();
	}
	
	public void recreateModel(){
		servicio.obtenerClienteServicio().setProdId(prodId);
		servicio.obtenerClienteServicio().recreateModel();
		flag2 = true;
		this.prodId = "";
	}
	
	public boolean parametrosValidos() {
		if ((this.identificacion != null && !this.identificacion.isEmpty()) ||
			(this.prodId != null && !this.prodId.isEmpty()) ||	
			(this.fechaIni != null && this.fechaFin != null)) {
			return true;
		}
		return false;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
	
	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	
	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	
	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public List<ClienteTotal> getClienteTotal() {
		return clienteTotal;
	}

	public Cliente getClienteConsultado() {
		return clienteConsultado;
	}

	public void setClienteConsultado(Cliente clienteConsultado) {
		this.clienteConsultado = clienteConsultado;
	}
	
	public boolean getFlag() {
		return flag;
	}	
	
	public boolean getFlag2() {
		return flag2;
	}
	
}
