package co.com.kallsony.bl;

import java.util.List;

import javax.faces.model.DataModel;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import co.com.kallsony.bl.entidad.Campania;
import co.com.kallsony.dal.controlador.FachadaServicio;
import co.com.kallsony.dal.utilitarios.PaginationHelper;
@Name("manejadorCampania")
@Scope(ScopeType.CONVERSATION)
public class ManejadorCampania implements IManejadorCampania {
	
	private FachadaServicio servicio;
	
	public ManejadorCampania(){	
		servicio = FachadaServicio.getInstance();
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorCampania#crearCampania(co.com.kallsony.bl.entidad.Campania)
	 */
	@Override
	public boolean crearCampania(Campania campania){
		return servicio.obtenerCampaniaServicio().crear(campania);
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorCampania#modificarCampania(co.com.kallsony.bl.entidad.Campania)
	 */
	@Override
	public boolean modificarCampania(Campania campania){
		return servicio.obtenerCampaniaServicio().modificar(campania);
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorCampania#eliminarCampania(co.com.kallsony.bl.entidad.Campania)
	 */
	@Override
	public boolean eliminarCampania(Campania campania){
		return servicio.obtenerCampaniaServicio().eliminar(campania);
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorCampania#consultarCampanias()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Campania> consultarCampanias(){
		return (List<Campania>) servicio.obtenerCampaniaServicio().consultarCampanias();
	}

	@Override
	public PaginationHelper getPagination() {
		// TODO Auto-generated method stub
		return servicio.obtenerCampaniaServicio().getPagination();
	}

	@Override
	public DataModel getItems() {
		// TODO Auto-generated method stub
		return servicio.obtenerCampaniaServicio().getItems();
	}

	@Override
	public String next() {
		// TODO Auto-generated method stub
		return servicio.obtenerCampaniaServicio().next();
	}

	@Override
	public String previous() {
		// TODO Auto-generated method stub
		return servicio.obtenerCampaniaServicio().previous();
	}

}
