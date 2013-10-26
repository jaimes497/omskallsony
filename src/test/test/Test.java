package test;

import co.com.kallsony.bl.FachadaManejador;
import co.com.kallsony.bl.entidad.Orden;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FachadaManejador negocio = FachadaManejador.getInstance();
		
		System.out.println("--> Prueba");
		System.out.println("cancelarOrden=" + negocio.cancelarOrden(new Orden()));

	}

}
