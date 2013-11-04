package co.com.kallsony.bl.entidad;

import java.math.BigDecimal;

public class Producto {
	
	
	
		    public Producto( BigDecimal prodid, String name,
			String description, String category, BigDecimal listPrice,
			String producer, String imageurl, String smallImageurl) {
		super();
		
		this.prodid = prodid;
		this.name = name;
		this.description = description;
		this.category = category;
		this.listPrice = listPrice;
		this.producer = producer;
		this.imageurl = imageurl;
		this.smallImageurl = smallImageurl;
	}


	
	 
	    private BigDecimal prodid;
	  
	    private String name;
	
	    private String description;
	 
	   
	    private String category;
	   
	    private BigDecimal listPrice;
	
	    private String producer;
	  
	  
	    private String imageurl;
	
	  
	    private String smallImageurl;


	


		public BigDecimal getProdid() {
			return prodid;
		}


		public void setProdid(BigDecimal prodid) {
			this.prodid = prodid;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public String getCategory() {
			return category;
		}


		public void setCategory(String category) {
			this.category = category;
		}


		public BigDecimal getListPrice() {
			return listPrice;
		}


		public void setListPrice(BigDecimal listPrice) {
			this.listPrice = listPrice;
		}


		public String getProducer() {
			return producer;
		}


		public void setProducer(String producer) {
			this.producer = producer;
		}


		public String getImageurl() {
			return imageurl;
		}


		public void setImageurl(String imageurl) {
			this.imageurl = imageurl;
		}


		public String getSmallImageurl() {
			return smallImageurl;
		}


		public void setSmallImageurl(String smallImageurl) {
			this.smallImageurl = smallImageurl;
		}
	    
	    
	    
	    
}
