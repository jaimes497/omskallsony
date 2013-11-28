package co.com.kallsony.bl.entidad;

import java.math.BigDecimal;

public class ClienteTotal {
	
	private String custid;

    private String name;

    private BigDecimal valor;
    
    public ClienteTotal(){}
	
	public ClienteTotal(String custid, String name, BigDecimal valor){
		this.custid = custid;
		this.name = name;
		this.valor = valor;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString(){
		return "ClienteTotal [custId=" + custid + ", nombre=" + name + ", valor=" + valor + "]";
	}

}
