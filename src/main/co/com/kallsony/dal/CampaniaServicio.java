package co.com.kallsony.dal;

import java.rmi.RemoteException;
import java.util.List;

import modelowebservicecampania.CampaniaServiceProxy;

import co.com.kallsony.bl.entidad.Campania;
import co.com.kallsony.dal.utilitarios.Tranformador;

public class CampaniaServicio implements ICampaniaServicio {

	@Override
	public boolean crear(Campania campania) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Campania campania) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Campania campania) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Campania> consultarCampanias() {
		
    	try {
    		CampaniaServiceProxy campaniaServiceProxy=new CampaniaServiceProxy();
    	return Tranformador.convertirListaCampania(campaniaServiceProxy.findCampanias());
    		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
