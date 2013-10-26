package co.com.kallsony.bl;

import java.util.List;

import co.com.kallsony.bl.entidad.Campania;

public interface IManejadorCampania {

	public boolean crearCampania(Campania campania);

	public boolean modificarCampania(Campania campania);

	public boolean eliminarCampania(Campania campania);

	public List<Campania> consultarCampanias();

}