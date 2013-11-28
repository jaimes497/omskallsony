package co.com.kallsony.dal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.model.DataModel;

import modelowebservice.ProductoServicePortTypeProxy;
import modelowebservice.RankingProducto;

import org.jboss.seam.jsf.ListDataModel;

import co.com.kallsony.bl.entidad.Orden;
import co.com.kallsony.bl.entidad.Producto;
import co.com.kallsony.bl.entidad.ProductoTotal;
import co.com.kallsony.dal.utilitarios.PaginationHelperProducto;
import co.com.kallsony.dal.utilitarios.Tranformador;

public class ProductoServicio implements IProductoServicio {
	private static final int WS_JAVA = 0;
	private static final int WS_BROKER = 1; 
	private int tipo;	
	
	private PaginationHelperProducto pagination;
	private DataModel items = null;
	private ProductoServicePortTypeProxy productoServicePortTypeProxy2;
	private String nombre = "";
	private String descripcion = "";
	private String prodId = "";	

	public ProductoServicio() {
		productoServicePortTypeProxy2 = new ProductoServicePortTypeProxy();
		tipo = 2;
	}

	@Override
	public boolean crearModificar(Producto producto) {
		// TODO Auto-generated method stub
		try {
			if (tipo == WS_JAVA) {
				String res = productoServicePortTypeProxy2.createUpdateProducto(producto.getProdid(), producto.getName(), producto.getDescription(), producto.getCategory(), producto.getListPrice(), producto.getProducer(), producto.getImageurl(), producto.getSmallImageurl());
				if (res.equalsIgnoreCase("guardo")){
					return true;
				} else {
					return false;
				}
			} else if (tipo == WS_BROKER) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean eliminar(Producto producto) {
		// Elimina una campania
		try {
			if (tipo == WS_JAVA) {
				String res = productoServicePortTypeProxy2.eliminarProducto(producto.getProdid());
				if (res.equalsIgnoreCase("guardo")){
					return true;
				} else {
					return false;
				}
			} else if (tipo == WS_BROKER) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Object rankingProductosMasVendidos(Calendar fechaIni, Calendar fechaFin) {
		// 
		List<ProductoTotal> productos;
		try {
			if (tipo == WS_JAVA){
				RankingProducto[] prd = productoServicePortTypeProxy2.findRankingProducto(fechaIni.getTime(), fechaFin.getTime());
				if (prd != null && prd.length > 0){
					productos = Tranformador.convertirListaProductoTotal(prd);
					return productos;
				} else {
					return new ArrayList<Orden>();
				}
			} else if (tipo == WS_BROKER) {
				return false;
			} else {
				ProductoTotal pr = new ProductoTotal("Prod1", 101, new BigDecimal(1000));
				productos = new ArrayList<ProductoTotal>();
				productos.add(pr);
				return productos;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Orden>();
		}
	}

	@Override
	public Object rankingCategoriaMasVendidas(Calendar fechaIni, Calendar fechaFin) {
		// 
		List<ProductoTotal> productos;
		try {
			if (tipo == WS_JAVA){
				RankingProducto[] prd = productoServicePortTypeProxy2.findRankingCategoriaProducto(fechaIni.getTime(), fechaFin.getTime());
				if (prd != null && prd.length > 0){
					productos = Tranformador.convertirListaProductoTotal(prd);
					return productos;
				} else {
					return new ArrayList<Orden>();
				}
			} else if (tipo == WS_BROKER) {
				return false;
			} else {
				ProductoTotal pr = new ProductoTotal("Cat1", 101, new BigDecimal(1000));
				productos = new ArrayList<ProductoTotal>();
				productos.add(pr);
				return productos;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Orden>();
		}
	}

	@Override
	public PaginationHelperProducto getPagination() {
		System.out.println("-->getPagination() " + pagination);
		int tamano = contarRegistros();
		if (pagination == null) {
			pagination = new PaginationHelperProducto(25);
			pagination.setTamano(tamano);
		}
		System.out.println("-->getPagination()* tamano " + pagination.getItemsCount());
		return pagination;
	}

	public int contarRegistros() {
		try {
			if (tipo == WS_JAVA) {
				return productoServicePortTypeProxy2.findProductoCountParametros(nombre, descripcion, prodId);
			} else if (tipo == WS_BROKER) {
				return 0;
			} else {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public DataModel paginarProductos() {
		System.out.println("-->paginarProductos() ");
		DataModel model = new ListDataModel();
		try {
			if (tipo == WS_JAVA) {
				modelowebservice.Producto[] list = productoServicePortTypeProxy2.findProductoPorParametrosRange(
						new int[] {pagination.getPageFirstItem(), pagination.getPageFirstItem() + pagination.getPageSize()}, 
						nombre, descripcion, prodId);
				if (list != null) {				
					model = new ListDataModel(Tranformador.convertirListaProducto(list));
				}
			} else if (tipo == WS_BROKER) {
				return new ListDataModel(new ArrayList<Object>());
			} else {
				Producto prod2 = new Producto(new BigDecimal(101), "Producto1", "Desc1", "Cat1", new BigDecimal(10000), "Pro1", "url", "surl");
				List<Producto> p = new ArrayList<Producto>();
				p.add(prod2);
				model = new ListDataModel(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-->paginarProductos()* ");
		return model;
	}

	@Override
	public DataModel getItems() {
		System.out.println("-->getItems() " + items);
		if (items == null) {
			pagination = getPagination();
			if (pagination.getItemsCount() > 0){
				items = pagination.createPageDataModel(paginarProductos());
			} else {
				items = new ListDataModel();
			}
		}
		System.out.println("-->getItems()* conteo " + items.getRowCount());
		return items;
	}

	@Override
	public void recreateModel() {
		System.out.println("-->recreateModel()");
		this.pagination = null;
		this.items = null;
	}

	private void recreate() {
		items = null;
	}

	@Override
	public String next() {
		System.out.println("-->next()");
		pagination.nextPage();
		recreate();
		return null;
	}

	@Override
	public String previous() {
		System.out.println("-->previous()");
		pagination.previousPage();
		recreate();
		return null;
	}
	
	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String getProdId() {
		return prodId;
	}

	@Override
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

}
