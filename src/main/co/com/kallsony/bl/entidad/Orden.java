package co.com.kallsony.bl.entidad;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Orden {
	
	private String ordid;
	private Cliente cust;
	private Date orderdate;
	private BigDecimal price;
	private String status;
	private String comments;
	private Set<DetalleOrden> items = new HashSet<DetalleOrden>(0);

	public Orden() {
	}

	public Orden(String ordid, Cliente cust) {
		this.ordid = ordid;
		this.cust = cust;
	}
	
	public Orden(String ordid, Cliente cust, Date orderdate,
			BigDecimal price, String status, String comments) {
		this.ordid = ordid;
		this.cust = cust;
		this.orderdate = orderdate;
		this.price = price;
		this.status = status;
		this.comments = comments;
	}
	
	public Orden(String ordid, Cliente cust, Date orderdate,
			BigDecimal price, String status, String comments, Set<DetalleOrden> items) {
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

	public Set<DetalleOrden> getItems() {
		return items;
	}

	public void setItems(Set<DetalleOrden> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Orden [ordid=" + ordid + ", cust=" + cust + ", orderdate="
				+ orderdate + ", price=" + price + ", status=" + status
				+ ", comments=" + comments + ", items=" + items + "]";
	}

}
