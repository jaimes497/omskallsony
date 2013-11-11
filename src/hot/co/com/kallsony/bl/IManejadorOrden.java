package co.com.kallsony.bl;

import java.util.List;

import javax.faces.model.DataModel;

import co.com.kallsony.bl.entidad.Orden;
import co.com.kallsony.dal.utilitarios.PaginationHelper;

public interface IManejadorOrden {
	
	public int CONSULTAR_MES = 1;

	public boolean cancelarOrden(Orden orden);

	public boolean eliminarOrden(Orden orden);

	public List<Orden> consultarOrdenes();

	public Orden consultarOrdenPorNumero(Orden orden);

	public Orden consultarOrdenPorFecha(int tipoConsulta, String filtro);

	public List<Orden> consultarRankingOrdensAbiertas();

	public List<Orden> consultarRankingOrdensCerradas();
	
	public boolean parametrosValidos();

	public PaginationHelper getPagination();

	public DataModel getItems();

	public String next();

	public String previous();

}