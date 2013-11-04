package co.com.kallsony.dal;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.model.DataModel;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.jsf.ListDataModel;

import modelowebservicecampania.CampaniaServiceProxy;
import modelowebservicecampania.Campanna;

import co.com.kallsony.bl.entidad.Campania;
import co.com.kallsony.dal.utilitarios.PaginationHelper;
import co.com.kallsony.dal.utilitarios.Tranformador;

public class CampaniaServicio implements ICampaniaServicio {
	 private PaginationHelper pagination;
	 private DataModel items = null;
	 private CampaniaServiceProxy campaniaServiceProxy; 
	 
	 
	 public CampaniaServicio(){
		 campaniaServiceProxy=new CampaniaServiceProxy();
		 
	 }
	 
	   
	
	    public DataModel getItems() {
	        if (items == null) {
	            items = null;
	        }
	        return items;
	    }

	    private void recreateModel() {
	        items = null;
	    }

	    private void recreatePagination() {
	        pagination = null;
	    }

	    public String next() {
	        getPagination().nextPage();
	        recreateModel();
	        return null;
	    }

	    public String previous() {
	        getPagination().previousPage();
	        recreateModel();
	        return null;
	    }

	 
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
    		
    	return Tranformador.convertirListaCampania(campaniaServiceProxy.findCampanias());
    		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public CampaniaServiceProxy getCampaniaServiceProxy() {
			return campaniaServiceProxy;
	}

	public void setCampaniaServiceProxy(CampaniaServiceProxy campaniaServiceProxy) {
		this.campaniaServiceProxy = campaniaServiceProxy;
	}



	@Override
	public PaginationHelper getPagination() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
