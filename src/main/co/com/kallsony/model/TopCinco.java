package co.com.kallsony.model;
// Generated 20/10/2013 05:27:07 PM by Hibernate Tools 3.2.4.GA

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.NotNull;

/**
 * TopCinco generated by hbm2java
 */
@Entity
@Table(name = "TOP_CINCO")
public class TopCinco implements java.io.Serializable {

	private BigDecimal prodid;
	private BigDecimal prodidTop1;
	private BigDecimal prodidTop2;
	private BigDecimal prodidTop3;
	private BigDecimal prodidTop4;
	private BigDecimal prodidTop5;

	public TopCinco() {
	}

	public TopCinco(BigDecimal prodid) {
		this.prodid = prodid;
	}
	public TopCinco(BigDecimal prodid, BigDecimal prodidTop1,
			BigDecimal prodidTop2, BigDecimal prodidTop3,
			BigDecimal prodidTop4, BigDecimal prodidTop5) {
		this.prodid = prodid;
		this.prodidTop1 = prodidTop1;
		this.prodidTop2 = prodidTop2;
		this.prodidTop3 = prodidTop3;
		this.prodidTop4 = prodidTop4;
		this.prodidTop5 = prodidTop5;
	}

	@Id
	@Column(name = "PRODID", unique = true, nullable = false, precision = 22, scale = 0)
	@NotNull
	public BigDecimal getProdid() {
		return this.prodid;
	}

	public void setProdid(BigDecimal prodid) {
		this.prodid = prodid;
	}

	@Column(name = "PRODID_TOP_1", precision = 22, scale = 0)
	public BigDecimal getProdidTop1() {
		return this.prodidTop1;
	}

	public void setProdidTop1(BigDecimal prodidTop1) {
		this.prodidTop1 = prodidTop1;
	}

	@Column(name = "PRODID_TOP_2", precision = 22, scale = 0)
	public BigDecimal getProdidTop2() {
		return this.prodidTop2;
	}

	public void setProdidTop2(BigDecimal prodidTop2) {
		this.prodidTop2 = prodidTop2;
	}

	@Column(name = "PRODID_TOP_3", precision = 22, scale = 0)
	public BigDecimal getProdidTop3() {
		return this.prodidTop3;
	}

	public void setProdidTop3(BigDecimal prodidTop3) {
		this.prodidTop3 = prodidTop3;
	}

	@Column(name = "PRODID_TOP_4", precision = 22, scale = 0)
	public BigDecimal getProdidTop4() {
		return this.prodidTop4;
	}

	public void setProdidTop4(BigDecimal prodidTop4) {
		this.prodidTop4 = prodidTop4;
	}

	@Column(name = "PRODID_TOP_5", precision = 22, scale = 0)
	public BigDecimal getProdidTop5() {
		return this.prodidTop5;
	}

	public void setProdidTop5(BigDecimal prodidTop5) {
		this.prodidTop5 = prodidTop5;
	}

}