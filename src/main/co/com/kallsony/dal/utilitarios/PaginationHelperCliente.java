package co.com.kallsony.dal.utilitarios;

import javax.faces.model.DataModel;

public class PaginationHelperCliente extends PaginationHelper {
private int tamano;
	public PaginationHelperCliente(int pageSize) {
		super(pageSize);
		// TODO Auto-generated constructor stub
	}

	 @Override
     public int getItemsCount() {
   				return tamano;
	   }

     @Override
     public DataModel createPageDataModel(DataModel data) {
  			return data;
     	       
     }


	public void setTamano(int tamano) {
		this.tamano = tamano;
	}
     
     
}
