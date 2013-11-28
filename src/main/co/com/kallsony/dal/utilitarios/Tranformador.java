package co.com.kallsony.dal.utilitarios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import modelowebservice.Producto;
import modelowebservice.RankingProducto;
import modelowebservicecampania.Campanna;
import modelowebservicecliente.CustomerRanking;
import modelowebserviceorders.Customer;
import modelowebserviceorders.OrdenCantidadTotal;
import modelowebserviceorders.OrderRanking;
import modelowebserviceorders.Orders;
import co.com.kallsonics.Servicios.Negocio.Campana.xsd.actualizarCampana.ActualizarEntradaType;
import co.com.kallsonics.Servicios.Negocio.Campana.xsd.consultarCampana.InfoCampanna;
import co.com.kallsonics.Servicios.Negocio.Campana.xsd.eliminarCampana.EliminarEntradaType;
import co.com.kallsony.bl.entidad.Campania;
import co.com.kallsony.bl.entidad.Cliente;
import co.com.kallsony.bl.entidad.ClienteTotal;
import co.com.kallsony.bl.entidad.Orden;
import co.com.kallsony.bl.entidad.OrdenTotal;
import co.com.kallsony.bl.entidad.ProductoTotal;

public class Tranformador {

	public static Object convertirOrden(Object orden, Object tipo) {
		if (tipo instanceof Orders) {
			Orders ord =  (Orders)orden;
			Cliente cliente = (Cliente) convertirCliente(ord.getCustid(), ord.getCustid());
			return new Orden(ord.getOrdid(), cliente, ord.getOrderdate(), ord.getPrice(), ord.getStatus(), ord.getComments());
		}else {
			return null;
		}
	}

	public static Object convertirCliente(Object cliente, Object tipo) {	
		if (tipo instanceof Customer) {
			Customer cust =  (Customer)cliente;
			return new Cliente(cust.getCustid());
		} else if (tipo instanceof modelowebservicecliente.Customer) {
			Customer cust =  (Customer)cliente;
			return new Cliente(cust.getCustid(), cust.getFname(), cust.getLname(), cust.getPassword(), cust.getEmail(), cust.getStatus());
		}else {
			return null;
		}
	}
	
	public static Object convertirProducto(Object producto, Object tipo) {
		if (tipo instanceof Producto) {
			Producto prod =  (Producto)producto;
			return new co.com.kallsony.bl.entidad.Producto(prod.getId(),prod.getName(),prod.getDescription(),prod.getCategory(),prod.getListPrice(),prod.getProducer(),prod.getImageurl(),prod.getSmallImageurl());
		}else {
			return null;
		}
	}
	
	public static Object convertirCampania(Object campania, Object tipo) {
		Campania campana =  (Campania)campania;
		
		if (tipo instanceof ActualizarEntradaType){
			return new ActualizarEntradaType(campana.getCampaniaid(),campana.getProdid(),campana.getUrl(),campana.getFecIni(),campana.getFecFin());
		} if (tipo instanceof EliminarEntradaType){
			return new EliminarEntradaType(campana.getCampaniaid());
		} else {
			return null;
		}
		
	}

	public static List<Campania> convertirListaCampania(Object campania){
		List<Campania>listadoCampania = new ArrayList<Campania>();
		
		if (campania instanceof InfoCampanna[]) {
			InfoCampanna[] campaniaConvertir = (InfoCampanna[]) campania;
			for(InfoCampanna campana:campaniaConvertir){
				if (campana != null && campana.getIdCamp() != null) {
					listadoCampania.add(new Campania(new BigDecimal(campana.getIdCamp()),campana.getIdProd(),campana.getImagePrd(),campana.getFechaIni(),campana.getFechaFin()));
				}
			}
		} else if (campania instanceof Campanna[]) {
			Campanna[] campaniaConvertir = (Campanna[]) campania;
			for(Campanna campana:campaniaConvertir){
				listadoCampania.add(new Campania(campana.getCampannaid(),campana.getProdid(),campana.getUrl(),campana.getFecIni(),campana.getFecFin()));
			}
		}
		return listadoCampania;		
	}
	
	public static List<co.com.kallsony.bl.entidad.Producto> convertirListaProducto(Object producto){
		List<co.com.kallsony.bl.entidad.Producto>listadoProducto=new ArrayList<co.com.kallsony.bl.entidad.Producto>();
		
		if (producto instanceof Producto[]) {
			Producto[] productoConvertir= (Producto[])producto;
			for(Producto produc:productoConvertir){
				listadoProducto.add(new co.com.kallsony.bl.entidad.Producto(produc.getProdid(),produc.getName(),produc.getDescription(),produc.getCategory(),produc.getListPrice(),produc.getProducer(),produc.getImageurl(),produc.getSmallImageurl()));
			}
		}
		return listadoProducto;
		
	}

	public static List<Cliente> convertirListaCliente(Object cliente){
		List<Cliente>listadoCliente = new ArrayList<Cliente>();
		
		if (cliente instanceof Customer[]){
			Customer campaniaConvertir[]= (Customer[])cliente;
			for(Customer cli:campaniaConvertir){
				listadoCliente.add(new Cliente(cli.getCustid(), cli.getFname(), cli.getLname(), cli.getPhonenumber(), cli.getEmail(), cli.getPassword(), cli.getCreditcardtype(), cli.getCreditcardnumber(), cli.getStatus()));
			}
		}
		return listadoCliente;	
	}
	
	public static List<Orden> convertirListaOrden(Object orden){
		List<Orden>listadoOrden = new ArrayList<Orden>();
		
		if (orden instanceof Orders[]){
			Orders[] ordenConvertir = (Orders[]) orden;
			Cliente cliente = new Cliente();
			for(Orders ord:ordenConvertir){
				cliente = (Cliente) convertirCliente(ord.getCustid(), ord.getCustid());
				listadoOrden.add(new Orden(ord.getOrdid(), cliente, ord.getOrderdate(), ord.getPrice(), ord.getStatus(), ord.getComments()));
			}
		} else if(orden instanceof OrderRanking[]){
			OrderRanking[] ordenConvertir = (OrderRanking[]) orden;
			for(OrderRanking ord:ordenConvertir){
				listadoOrden.add(new Orden(ord.getOrdid(), new Cliente(), ord.getOrderdate(), ord.getPrice(), ord.getStatus(), ""));
			}
		}
		return listadoOrden;
	}
	
	public static List<OrdenTotal> convertirListaOrdenTotal(Object orden){
		List<OrdenTotal>listadoOrden = new ArrayList<OrdenTotal>();
		
		if (orden instanceof OrdenCantidadTotal){
			OrdenCantidadTotal ordenConvertir = (OrdenCantidadTotal) orden;
			listadoOrden.add(new OrdenTotal(ordenConvertir.getCantidad(), ordenConvertir.getTotal()));
		}
		return listadoOrden;
	}
	
	public static List<ProductoTotal> convertirListaProductoTotal(Object producto){
		List<ProductoTotal>listadoProducto = new ArrayList<ProductoTotal>();
		
		if (producto instanceof RankingProducto){
			RankingProducto prodConvertir = (RankingProducto) producto;
			listadoProducto.add(new ProductoTotal(prodConvertir.getName(), prodConvertir.getId().intValue(), prodConvertir.getValor()));
		}
		return listadoProducto;
	}
	
	public static List<ClienteTotal> convertirListaClienteTotal(Object cliente){
		List<ClienteTotal>listadoProducto = new ArrayList<ClienteTotal>();
		
		if (cliente instanceof CustomerRanking){
			CustomerRanking cliConvertir = (CustomerRanking) cliente;
			listadoProducto.add(new ClienteTotal(cliConvertir.getCustid(), cliConvertir.getName(), cliConvertir.getValor()));
		}
		return listadoProducto;
	}

}
