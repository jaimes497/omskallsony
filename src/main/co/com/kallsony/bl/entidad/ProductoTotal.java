package co.com.kallsony.bl.entidad;

import java.math.BigDecimal;

public class ProductoTotal {
	
	private String nombre;
	private int total;
	private BigDecimal price;
	
	public ProductoTotal(){}
	
	public ProductoTotal(String nombre, int total, BigDecimal price){
		this.total = total;
		this.price = price;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return "ProductoTotal [total=" + total + ", nombre=" + nombre + ", price=" + price + "]";
	}

}
