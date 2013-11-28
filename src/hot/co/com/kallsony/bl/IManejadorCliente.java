package co.com.kallsony.bl;

import co.com.kallsony.bl.entidad.Cliente;

public interface IManejadorCliente {

	boolean registrarCliente(Cliente cliente);

	void consultarRankingFacturacion();
}