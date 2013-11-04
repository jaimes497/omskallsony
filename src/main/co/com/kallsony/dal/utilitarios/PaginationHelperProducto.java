package co.com.kallsony.dal.utilitarios;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.model.DataModel;

import org.jboss.seam.jsf.ListDataModel;

public class PaginationHelperProducto extends PaginationHelper {
private int tamaño;
	public PaginationHelperProducto(int pageSize) {
		super(pageSize);
		// TODO Auto-generated constructor stub
	}

	 @Override
     public int getItemsCount() {
   				return tamaño;
	   }

     @Override
     public DataModel createPageDataModel(DataModel data) {
  			return data;
     	       
     }


	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}
     
     
}
