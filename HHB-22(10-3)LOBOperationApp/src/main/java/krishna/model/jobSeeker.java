package krishna.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class jobSeeker implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer jsId;
	private String jsName;
	private String jsAddress;
	@Lob
	private char[] reusme;
	@Lob
	private byte[] photo;
	@Override
	public String toString() {
		return "jobSeeker [jsId=" + jsId + ", jsName=" + jsName + ", jsAddress=" + jsAddress + ", reusme="
				+ Arrays.toString(reusme) + ", photo=" + Arrays.toString(photo) + "]";
	}
	public Integer getJsId() {
		return jsId;
	}
	public void setJsId(Integer jsId) {
		this.jsId = jsId;
	}
	public String getJsName() {
		return jsName;
	}
	public void setJsName(String jsName) {
		this.jsName = jsName;
	}
	public String getJsAddress() {
		return jsAddress;
	}
	public void setJsAddress(String jsAddress) {
		this.jsAddress = jsAddress;
	}
	public char[] getReusme() {
		return reusme;
	}
	public void setReusme(char[] reusme) {
		this.reusme = reusme;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}
