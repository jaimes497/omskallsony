package co.com.kallsony.bl;

import java.util.List;

import co.com.kallsony.bl.entidad.Orden;
import co.com.kallsony.dal.FachadaServicio;

public class ManejadorOrden implements IManejadorOrden {
	
private FachadaServicio servicio;
	
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

}
