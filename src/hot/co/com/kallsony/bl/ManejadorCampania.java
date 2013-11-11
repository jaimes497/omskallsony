package co.com.kallsony.bl;

import java.util.List;

import javax.faces.model.DataModel;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import co.com.kallsony.bl.entidad.Campania;
import co.com.kallsony.bl.entidad.Producto;
import co.com.kallsony.dal.controlador.FachadaServicio;
import co.com.kallsony.dal.utilitarios.PaginationHelper;
@Name("manejadorCampania")
@Scope(ScopeType.CONVERSATION)
public class ManejadorCampania implements IManejadorCampania {
	
	private FachadaServicio servicio;
	private Campania campania;
	
	public ManejadorCampania(){	
		servicio = FachadaServicio.getInstance();
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorCampania#crearCampania(co.com.kallsony.bl.entidad.Campania)
	 */
	@Override
	public boolean registrarCampania(Campania campania){
		return servicio.obtenerCampaniaServicio().crearModificar(campania);
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorCampania#eliminarCampania(co.com.kallsony.bl.entidad.Campania)
	 */
	@Override
	public boolean eliminarCampania(Campania campania){
		return servicio.obtenerCampaniaServicio().eliminar(campania);
	}
	
	public String asignar(Campania campania){
		this.campania = campania;
		return "/campania/CampaniaEdit.xhtml";
	}
	
	public String listar(){
		return "/campania/ListaCampania.xhtml";
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

	public Campania getCampania() {
		return campania;
	}

	public void setCampania(Campania campania) {
		this.campania = campania;
	}
	
	public void recreateModel(){
		servicio.obtenerCampaniaServicio().recreateModel();
	}
	
	public boolean parametrosValidos() {
		return servicio.obtenerCampaniaServicio().parametrosValidos();
	}
	
	public String getCampaniaId() {
		return servicio.obtenerCampaniaServicio().getCampaniaId();
	}

	public void setCampaniaId(String campaniaId) {
		 servicio.obtenerCampaniaServicio().setCampaniaId(campaniaId);		
	}
		

}
