package co.com.kallsony.bl;

import java.util.Date;
import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;

import co.com.kallsony.bl.entidad.Campania;
import co.com.kallsony.dal.controlador.FachadaServicio;
import co.com.kallsony.imagen.ArchivoLogo;
@Name("manejadorCampania")
@Scope(ScopeType.CONVERSATION)
public class ManejadorCampania implements IManejadorCampania {
	
	private FachadaServicio servicio;
	private Campania campania;
	private Date fechaIni;
	private Date fechaFin;
	
	@In(create = true)
	ArchivoLogo		archivoLogo;
	@In
	FacesMessages	facesMessages;
	
	public ManejadorCampania(){	
		servicio = FachadaServicio.getInstance();
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorCampania#crearCampania(co.com.kallsony.bl.entidad.Campania)
	 */
	@Override
	public boolean registrarCampania(Campania campania){
		//return servicio.obtenerCampaniaServicio().crearModificar(campania);
		try {
			String rutaLogo = IManejadorCampania.pathVirtual + System.getProperty("file.separator") +
					"Content" + System.getProperty("file.separator") + "Thumbnail";
			String respuesta = archivoLogo.guardar(rutaLogo, campania.getProdid().toString(), null);
			if (respuesta == null){
				return false;
			}
			System.out.println("archivo: " + respuesta);
			System.out.println("ruta: " + "/Content/Thumbnail/" + respuesta);
			campania.setUrl("/Content/Thumbnail/" + campania.getProdid() + "_" + respuesta);
			boolean ok = servicio.obtenerCampaniaServicio().crearModificar(campania);
			if (ok) {
				this.facesMessages.clear();
				this.facesMessages.add(Severity.INFO, "EL REGISTRO DEL PRODUCTO HA SIDO EXITOSO! :-)");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.facesMessages.add(Severity.ERROR, "LA CARGA NO HA SIDO EXITOSA! :-)");
		return false;
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorCampania#eliminarCampania(co.com.kallsony.bl.entidad.Campania)
	 */
	@Override
	public boolean eliminarCampania(Campania campania){
		//return servicio.obtenerCampaniaServicio().eliminar(campania);
		try {
			boolean ok = servicio.obtenerCampaniaServicio().eliminar(campania);
			if (ok) {
				this.facesMessages.clear();
				this.facesMessages.add(Severity.INFO, "EL REGISTRO DEL PRODUCTO HA SIDO EXITOSO! :-)");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.facesMessages.add(Severity.ERROR, "LA CARGA NO HA SIDO EXITOSA! :-)");
		return false;
	}
	
	/* (non-Javadoc)
	 * @see co.com.kallsony.bl.IManejadorCampania#consultarCampanias()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Campania> consultarCampanias(){
		return (List<Campania>) servicio.obtenerCampaniaServicio().consultarCampanias();
	}
	
	public String asignar(Campania campania){
		this.campania = campania;
		return "/campania/CampaniaEdit.xhtml";
	}
	
	public String agregar(){
		this.campania = new Campania();
		return "/campania/CampaniaEdit.xhtml";
	}
	
	public String listar(){
		return "/campania/ListaCampania.xhtml";
	}
	
	public Campania getCampania() {
		return campania;
	}

	public void setCampania(Campania campania) {
		this.campania = campania;
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
	
}
