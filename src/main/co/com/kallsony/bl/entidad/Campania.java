package co.com.kallsony.bl.entidad;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class Campania {
	
	private BigDecimal campaniaid;
	private BigInteger prodid;
	private String url;
	private Date fecIni;
	private Date fecFin;
	
	public Campania(){
	}
	
	public Campania(BigDecimal campaniaid, BigInteger prodid) {
		this.campaniaid = campaniaid;
		this.prodid = prodid;
	}
	
	public Campania(BigDecimal campaniaid, BigInteger prodid, String url,
			Date fecIni, Date fecFin) {
		this.campaniaid = campaniaid;
		this.prodid = prodid;
		this.url = url;
		this.fecIni = fecIni;
		this.fecFin = fecFin;
	}
	
	public BigDecimal getCampaniaid() {
		return campaniaid;
	}
	
	public void setCampaniaid(BigDecimal campaniaid) {
		this.campaniaid = campaniaid;
	}
	
	public BigInteger getProdid() {
		return prodid;
	}
	
	public void setProdid(BigInteger prodid) {
		this.prodid = prodid;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Date getFecIni() {
		return fecIni;
	}
	
	public void setFecIni(Date fecIni) {
		this.fecIni = fecIni;
	}
	
	public Date getFecFin() {
		return fecFin;
	}
	
	public void setFecFin(Date fecFin) {
		this.fecFin = fecFin;
	}

	public String toString() {
		return "Campania [campaniaid=" + campaniaid + ", prodid=" + prodid
				+ ", url=" + url + ", fecIni=" + fecIni + ", fecFin=" + fecFin
				+ "]";
	}

}
