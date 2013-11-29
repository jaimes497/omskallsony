package co.com.kallsony.bl.entidad;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Orden {
	
	private String ordid;
	private Cliente cust;
	private Date orderdate;
	private BigDecimal price;
	private String status;
	private String comments;
	private String supplier;
	private List<DetalleOrden> items = new ArrayList<DetalleOrden>(0);

	public Orden() {
	}

	public Orden(String ordid, Cliente cust) {
		this.ordid = ordid;
		this.cust = cust;
	}
	
	public Orden(String ordid, Cliente cust, Date orderdate,
			BigDecimal price, String status, String comments, String supplier) {
		this.ordid = ordid;
		this.cust = cust;
		this.orderdate = orderdate;
		this.price = price;
		this.status = status;
		this.comments = comments;
		this.supplier = supplier;
	}
	
	public Orden(String ordid, Cliente cust, Date orderdate,
			BigDecimal price, String status, String comments, List<DetalleOrden> items) {
		this.ordid = ordid;
		this.cust = cust;
		this.orderdate = orderdate;
		this.price = price;
		this.status = status;
		this.comments = comments;
		this.items = items;
	}

	public String getOrdid() {
		return ordid;
	}

	public void setOrdid(String ordid) {
		this.ordid = ordid;
	}

	public Cliente getCust() {
		return cust;
	}

	public void setCust(Cliente cust) {
		this.cust = cust;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public List<DetalleOrden> getItems() {
		return items;
	}

	public void setItems(List<DetalleOrden> items) {
		this.items = items;
	}
	
	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "Orden [ordid=" + ordid + ", cust=" + cust + ", orderdate="
				+ orderdate + ", price=" + price + ", status=" + status
				+ ", comments=" + comments + ", items=" + items + "]";
	}

}
