package co.com.kallsony.dal.utilitarios;

import java.math.BigDecimal;
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
	
	public static List<co.com.kallsony.bl.entidad.Producto> convertirListaProducto(Object producto){
		
		Producto productoConvertir[]= (Producto [])producto;
		List<co.com.kallsony.bl.entidad.Producto>listadoProducto=new ArrayList<co.com.kallsony.bl.entidad.Producto>();
		for(Producto produc:productoConvertir){
			listadoProducto.add(new co.com.kallsony.bl.entidad.Producto(produc.getProdid(),produc.getName(),produc.getDescription(),produc.getCategory(),produc.getListPrice(),produc.getProducer(),produc.getImageurl(),produc.getSmallImageurl()));
		}
		return listadoProducto;
		
	}

	public Campania convertirCampania(){
		return null;
	}


}
