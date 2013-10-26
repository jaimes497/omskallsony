package co.com.kallsony.bl.entidad;


public class Cliente {
	
	private String custid;
	private String fname;
	private String lname;
	private String phonenumber;
	private String email;
	private String password;
	private String creditcardtype;
	private String creditcardnumber;
	private String status;
	
	public Cliente() {
	}

	public Cliente(String custid) {
		this.custid = custid;
	}
	
	public Cliente(String custid, String fname, String lname,
			String phonenumber, String email, String password,
			String creditcardtype, String creditcardnumber, String status) {
		this.custid = custid;
		this.fname = fname;
		this.lname = lname;
		this.phonenumber = phonenumber;
		this.email = email;
		this.password = password;
		this.creditcardtype = creditcardtype;
		this.creditcardnumber = creditcardnumber;
		this.status = status;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreditcardtype() {
		return creditcardtype;
	}

	public void setCreditcardtype(String creditcardtype) {
		this.creditcardtype = creditcardtype;
	}

	public String getCreditcardnumber() {
		return creditcardnumber;
	}

	public void setCreditcardnumber(String creditcardnumber) {
		this.creditcardnumber = creditcardnumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String toString() {
		return "Cliente [custid=" + custid + ", fname=" + fname + ", lname="
				+ lname + ", phonenumber=" + phonenumber + ", email=" + email
				+ ", password=" + password + ", creditcardtype="
				+ creditcardtype + ", creditcardnumber=" + creditcardnumber
				+ ", status=" + status + "]";
	}

}
