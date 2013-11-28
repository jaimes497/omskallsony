package co.com.kallsony.bl;

import co.com.kallsony.bl.entidad.Producto;

public interface IManejadorProducto {

	boolean registrarProducto(Producto producto);

	boolean eliminarProducto(Producto producto);

	void consultarRankingProductosMasVendidos();

	void consultarRankingCategoriaMasVendidas();
	
}