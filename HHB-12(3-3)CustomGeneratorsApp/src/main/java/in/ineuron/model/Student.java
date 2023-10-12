package in.ineuron.model;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Student {

	@Id
	@GenericGenerator(name="gen1", strategy="/HHB-12(3-3)CustomGeneratorsApp/src/main/java/in/ineuron/idgenerator/StudentGenerator.java")
	@GeneratedValue(generator="gen1")
	private String sid;
	
	private String sname;
	
	private String saddress;
	
	private Integer sage;

	public Student() {
		System.out.println("Hibernate uses Zero argument constructor internally");
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", sage=" + sage + "]";
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public Integer getSage() {
		return sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

}
