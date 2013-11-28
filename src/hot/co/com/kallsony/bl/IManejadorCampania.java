package co.com.kallsony.bl;

import java.util.List;

import co.com.kallsony.bl.entidad.Campania;

public interface IManejadorCampania {
	
	String pathVirtual = "c:" + System.getProperty("file.separator") + "Temp" + System.getProperty("file.separator") + "images";

	boolean registrarCampania(Campania campania);

	boolean eliminarCampania(Campania campania);

	List<Campania> consultarCampanias();
	
}