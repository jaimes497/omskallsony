package co.com.kallsony.dal;

import co.com.kallsony.bl.entidad.Orden;

public interface IOrdenServicio {
	
	public boolean cancelar(Orden orden);
	public boolean eliminar(Orden orden);
	public Object consultarOrdenes();
	public Object consultarPorId(Orden orden);
	public Object consultarPorProducto(Orden orden);
	public Object consultarPorMes(String mes);
	public Object rankingOrdenesAbiertas();
	public Object rankingOrdenesCerradas();

}
