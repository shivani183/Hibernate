package in.ineuron.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProgrammerProjINFO implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProgrammerProjID id;
	private String pname;
	private String projName;
	private Integer deptNo;

	public ProgrammerProjID getId() {
		return id;
	}

	public void setId(ProgrammerProjID id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getProjName() {
		return projName;
	}

	@Override
	public String toString() {
		return "ProgrammerProjINFO [id=" + id + ", pname=" + pname + ", projName=" + projName + ", deptNo=" + deptNo
				+ "]";
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public Integer getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
}
