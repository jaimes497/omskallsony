package co.com.kallsony.bl.entidad;

import java.math.BigDecimal;

public class OrdenTotal {
	
	private int total;
	private BigDecimal price;
	
	public OrdenTotal(){}
	
	public OrdenTotal(int total, BigDecimal price){
		this.total = total;
		this.price = price;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Override
	public String toString(){
		return "OrdenTotal [total=" + total + ", price=" + price + "]";
	}

}
