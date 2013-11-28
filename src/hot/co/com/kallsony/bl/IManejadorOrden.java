package co.com.kallsony.bl;

import java.util.List;

import co.com.kallsony.bl.entidad.Orden;

public interface IManejadorOrden {
	
	int CONSULTAR_ID = 1;
	int CONSULTAR_PRODUCTOS = 2;
	int CONSULTAR_MES = 3;

	boolean cancelarOrden(Orden orden);

	boolean eliminarOrden(Orden orden);

	List<Orden> consultarRankingOrdensAbiertas();

	void consultarRankingOrdensCerradas();

}