package co.com.kallsony.bl;

import java.util.Calendar;
import java.util.List;

import javax.faces.model.DataModel;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import co.com.kallsony.bl.entidad.Orden;
import co.com.kallsony.dal.controlador.FachadaServicio;
import co.com.kallsony.dal.utilitarios.PaginationHelper;

@Name("manejadorOrden")
@Scope(ScopeType.CONVERSATION)
public class ManejadorOrden implements IManejadorOrden {
	
	private FachadaServicio servicio;
	private Orden orden;
	
	public ManejadorOrden(){	
		servicio = FachadaServicio.getInstance();
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
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorOrden#consultarOrdenes()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Orden> consultarOrdenes(){
		return (List<Orden>) servicio.obtenerOrdenServicio().consultarOrdenes();
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorOrden#consultarOrdenPorNumero(co.com.kallsony.bl.entidad.Orden)
	 */
	@Override
	public Orden consultarOrdenPorNumero(Orden orden){
		return (Orden) servicio.obtenerOrdenServicio().consultarPorId(orden);
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorOrden#consultarOrdenPorFecha(int, java.lang.String)
	 */
	@Override
	public Orden consultarOrdenPorFecha(int tipoConsulta, String filtro){
		if (tipoConsulta == 1) {
			return (Orden) servicio.obtenerOrdenServicio().consultarPorMes(filtro);
		} else {
			System.out.println("Opcion no soportada");
			return null;
		}
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorOrden#consultarRankingOrdensAbiertas()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Orden> consultarRankingOrdensAbiertas(){
		return (List<Orden>) servicio.obtenerOrdenServicio().rankingOrdenesAbiertas();
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorOrden#consultarRankingOrdensCerradas()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Orden> consultarRankingOrdensCerradas(){
		return (List<Orden>) servicio.obtenerOrdenServicio().rankingOrdenesCerradas();
	}
	
	public String asignar(Orden orden){
		this.orden=orden;
		return "/orden/OrdenEdit.xhtml";
	}
	
	public String listar(){
		return "/orden/ListaOrden.xhtml";
	}
	
	@Override
	public PaginationHelper getPagination() {
		return servicio.obtenerOrdenServicio().getPagination();
	}

	@Override
	public DataModel getItems() {
		return servicio.obtenerOrdenServicio().getItems();
	}

	@Override
	public String next() {
	  return servicio.obtenerOrdenServicio().next();
	}
	

	@Override
	public String previous() {
		return servicio.obtenerOrdenServicio().previous();
	}
	
	public void recreateModel(){
		servicio.obtenerOrdenServicio().recreateModel();
	}
	
	@Override
	public boolean parametrosValidos() {
		return servicio.obtenerOrdenServicio().parametrosValidos();
	}

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}
	
	public String getOrdid() {
		return servicio.obtenerOrdenServicio().getOrdid();
	}

	public void setOrdid(String ordid) {
		servicio.obtenerOrdenServicio().setOrdid(ordid);
	}

	public String getProdId() {
		return servicio.obtenerOrdenServicio().getProdId();
	}

	public void setProdId(String prodId) {
		servicio.obtenerOrdenServicio().setProdId(prodId);
	}
	
	public Calendar getFechaIni() {
		return servicio.obtenerOrdenServicio().getFechaIni();
	}

	public void setFechaIni(Calendar fechaIni) {
		servicio.obtenerOrdenServicio().setFechaIni(fechaIni);
	}

	public Calendar getFechaFin() {
		return servicio.obtenerOrdenServicio().getFechaIni();
	}

	public void setFechaFin(Calendar fechaFin) {
		servicio.obtenerOrdenServicio().setFechaFin(fechaFin);
	}

}
