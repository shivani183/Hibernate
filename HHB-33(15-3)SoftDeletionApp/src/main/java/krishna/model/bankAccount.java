package krishna.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "bank")
@SQLDelete(sql="UPDATE bank SET status='closed' WHERE accno=?")
@Where(clause="status not in ('closed', 'blocked')")
public class bankAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer accno;
	private String holderName;
	private String status;
	private Float balance;

	static {
		System.out.println("BankAccount.class file is loaded..");
	}

	public bankAccount() {
		System.out.println("bankAccount object is created");
	}

	public Integer getAccno() {
		return accno;
	}

	public void setAccno(Integer accno) {
		this.accno = accno;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "bankAccount [accno=" + accno + ", holderName=" + holderName + ", status=" + status + ", balance="
				+ balance + "]";
	}

}
