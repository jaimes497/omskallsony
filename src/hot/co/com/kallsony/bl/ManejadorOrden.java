package co.com.kallsony.bl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.model.DataModel;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import co.com.kallsony.bl.entidad.Orden;
import co.com.kallsony.bl.entidad.OrdenTotal;
import co.com.kallsony.dal.controlador.FachadaServicio;
import co.com.kallsony.dal.utilitarios.PaginationHelper;

@Name("manejadorOrden")
@Scope(ScopeType.CONVERSATION)
public class ManejadorOrden implements IManejadorOrden {
	
	private FachadaServicio servicio;
	private Orden orden;
	private Orden ordenConsultada;
	private List<Orden> ordenes;
	private List<OrdenTotal> ordenesTotal;
	private String ordid = "";
	private String prodId = "";
	private Date fechaIni;
	private Date fechaFin;
	private boolean flag;
	private boolean flag2;
	
	public ManejadorOrden(){	
		servicio = FachadaServicio.getInstance();
		flag = false;
		flag2 = false;
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorOrden#cancelarOrden(co.com.kallsony.bl.entidad.Orden)
	 */
	@Override
	public boolean cancelarOrden(Orden orden){
		return servicio.obtenerOrdenServicio().cancelar(orden);
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorOrden#eliminarOrden(co.com.kallsony.bl.entidad.Orden)
	 */
	@Override
	public boolean eliminarOrden(Orden orden){
		return servicio.obtenerOrdenServicio().eliminar(orden);
	}
	
	public void consultarOrdenesPorID(String ordid) {
		Orden ord = new Orden();
		ord.setOrdid(ordid);
		ordenConsultada = (Orden) servicio.obtenerOrdenServicio().consultarPorId(ord);
		flag = true;
		this.ordid = "";
	}
	
	@SuppressWarnings("unchecked")
	public void consultarOrdenes() {
		Calendar ini = Calendar.getInstance();
		Calendar fin = Calendar.getInstance();
		ini.setTime(fechaIni);
		fin.setTime(fechaFin);
		
		ordenesTotal = (List<OrdenTotal>) servicio.obtenerOrdenServicio().consultarPorMes(ini, fin);
	}
	
	public void recreate() {
		servicio.obtenerOrdenServicio().setProdId(prodId);
		servicio.obtenerOrdenServicio().recreateModel();
		flag2 = true;
		this.prodId = "";
	}
	
	public void consultar() {
		if (this.ordid != null && !this.ordid.isEmpty()) {
			consultarOrdenesPorID(ordid);
		} else if (this.prodId != null && !this.prodId.isEmpty()) {
			recreate();
		}
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorOrden#consultarRankingOrdensAbiertas()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Orden> consultarRankingOrdensAbiertas(){
		this.ordenes = (List<Orden>) servicio.obtenerOrdenServicio().rankingOrdenesAbiertas();
		return this.ordenes;
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorOrden#consultarRankingOrdensCerradas()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void consultarRankingOrdensCerradas(){
		Calendar ini = Calendar.getInstance();
		Calendar fin = Calendar.getInstance();
		ini.setTime(fechaIni);
		fin.setTime(fechaFin);
		
		this.ordenes = (List<Orden>) servicio.obtenerOrdenServicio().rankingOrdenesCerradas(ini, fin);
	}
	
	public String asignar(Orden orden){
		this.orden=orden;
		this.ordenConsultada = null;
		flag = false;
		flag2 = false;
		return "/orden/OrdenEdit.xhtml";
	}
	
	public String listar(){
		return "/orden/ListaOrden.xhtml";
	}
		
	public boolean parametrosValidos() {
		if ((this.fechaIni != null && this.fechaFin != null)) {
			return true;
		}
		return false;
	}
	
	public PaginationHelper getPagination() {
		return servicio.obtenerOrdenServicio().getPagination();
	}

	public DataModel getItems() {
		return servicio.obtenerOrdenServicio().getItems();
	}

	public String next() {
		return servicio.obtenerOrdenServicio().next();
	}

	public String previous() {
		return servicio.obtenerOrdenServicio().previous();
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}
	
	public String getOrdid() {
		return ordid;
	}

	public void setOrdid(String ordid) {
		this.ordid = ordid;
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

	public Orden getOrdenConsultada() {
		return ordenConsultada;
	}

	public List<Orden> getOrdenes() {
		return ordenes;
	}

	public List<OrdenTotal> getOrdenesTotal() {
		return ordenesTotal;
	}

	public boolean getFlag() {
		return flag;
	}	
	
	public boolean getFlag2() {
		return flag2;
	}

}
