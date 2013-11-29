package co.com.kallsony.bl.entidad;

import java.math.BigDecimal;


public class DetalleOrden {

	private String itemid;
	private BigDecimal prodid;
	private String productname;
	private String partnum;
	private BigDecimal price;
	private Integer quantity;
	
	public DetalleOrden() {
	}

	public DetalleOrden(String itemid) {
		this.itemid = itemid;
	}
	
	public DetalleOrden(String itemid, BigDecimal prodid,
			String productname, String partnum, BigDecimal price,
			Integer quantity) {
		this.itemid = itemid;
		this.prodid = prodid;
		this.productname = productname;
		this.partnum = partnum;
		this.price = price;
		this.quantity = quantity;
	}

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public BigDecimal getProdid() {
		return prodid;
	}

	public void setProdid(BigDecimal prodid) {
		this.prodid = prodid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getPartnum() {
		return partnum;
	}

	public void setPartnum(String partnum) {
		this.partnum = partnum;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "DetalleOrden [itemid=" + itemid
				+ ", prodid=" + prodid + ", productname=" + productname
				+ ", partnum=" + partnum + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	
}
