package co.com.kallsony.dal.utilitarios;

import java.util.ArrayList;
import java.util.List;

import modelowebservicecampania.Campanna;

import co.com.kallsony.bl.entidad.Campania;

public class Tranformador {

	public Object convertirOrden(){
		return null;
	}

	public Object convertirCliente(){
		return null;
	}
	
	public Object convertirProducto(){
		return null;
	}

	public static List<Campania> convertirListaCampania(Object campania){
		
		Campanna campaniaConvertir[]= (Campanna [])campania;
		List<Campania>listadoCampania=new ArrayList<Campania>();
		for(Campanna campana:campaniaConvertir){
			listadoCampania.add(new Campania(campana.getCampannaid(),campana.getProdid(),campana.getUrl(),campana.getFecIni(),campana.getFecFin()));
		}
		return listadoCampania;
		
	}
	public Campania convertirCampania(){
		return null;
	}


}
