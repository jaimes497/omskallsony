package co.com.kallsony.dal.utilitarios;

import java.util.ArrayList;
import java.util.List;

import modelowebservice.Producto;
import modelowebservicecampania.Campanna;
import co.com.kallsony.bl.entidad.Campania;

public class Tranformador {

	public Object convertirOrden(){
		return null;
	}

	public Object convertirCliente(){
		return null;
	}
	
	public Object convertirProducto(Object producto){
		Producto produc =  (Producto)producto;
		return new co.com.kallsony.bl.entidad.Producto(produc.getProdid(),produc.getName(),produc.getDescription(),produc.getCategory(),produc.getListPrice(),produc.getProducer(),produc.getImageurl(),produc.getSmallImageurl());
	}
	
	public Object convertirCampania(Object campania){
		Campanna campana =  (Campanna)campania;
		return new Campania(campana.getCampannaid(),campana.getProdid(),campana.getUrl(),campana.getFecIni(),campana.getFecFin());
	}

	public static List<Campania> convertirListaCampania(Object campania){
		
		Campanna campaniaConvertir[]= (Campanna [])campania;
		List<Campania>listadoCampania=new ArrayList<Campania>();
		for(Campanna campana:campaniaConvertir){
			listadoCampania.add(new Campania(campana.getCampannaid(),campana.getProdid(),campana.getUrl(),campana.getFecIni(),campana.getFecFin()));
		}
		return listadoCampania;
		
	}
	
	public static List<co.com.kallsony.bl.entidad.Producto> convertirListaProducto(Object producto){
		
		Producto productoConvertir[]= (Producto [])producto;
		List<co.com.kallsony.bl.entidad.Producto>listadoProducto=new ArrayList<co.com.kallsony.bl.entidad.Producto>();
		for(Producto produc:productoConvertir){
			listadoProducto.add(new co.com.kallsony.bl.entidad.Producto(produc.getProdid(),produc.getName(),produc.getDescription(),produc.getCategory(),produc.getListPrice(),produc.getProducer(),produc.getImageurl(),produc.getSmallImageurl()));
		}
		return listadoProducto;
		
	}

	public static List<Campania> convertirListaCliente(Object cliente){
		
		Campanna campaniaConvertir[]= (Campanna [])cliente;
		List<Campania>listadoCampania=new ArrayList<Campania>();
		for(Campanna campana:campaniaConvertir){
			listadoCampania.add(new Campania(campana.getCampannaid(),campana.getProdid(),campana.getUrl(),campana.getFecIni(),campana.getFecFin()));
		}
		return listadoCampania;
		
	}
	
	public static List<Campania> convertirListaOrden(Object orden){
		
		Campanna campaniaConvertir[]= (Campanna [])orden;
		List<Campania>listadoCampania=new ArrayList<Campania>();
		for(Campanna campana:campaniaConvertir){
			listadoCampania.add(new Campania(campana.getCampannaid(),campana.getProdid(),campana.getUrl(),campana.getFecIni(),campana.getFecFin()));
		}
		return listadoCampania;
		
	}


}
