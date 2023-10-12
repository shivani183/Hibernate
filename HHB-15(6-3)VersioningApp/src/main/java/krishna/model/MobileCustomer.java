package krishna.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class MobileCustomer {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer cno;
	private String cname;
	private String callerTune;
	private Long mobileNo;
	
	@Version
	private Integer versionCount;
	
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public Integer getVersionCount() {
		return versionCount;
	}
	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCallerTune() {
		return callerTune;
	}
	public void setCallerTune(String callerTune) {
		this.callerTune = callerTune;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	

}
