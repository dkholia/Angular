package orm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "\"user\"")
@XmlRootElement(name="user") 
public class User implements Serializable {

	private static final long serialVersionUID = 633480351347670802L;
	
	private String userid;
	private String uname;
	private String upwd;
	private boolean isactive;
	
	@Id
	@Column(name = "\"userid\"", unique = true, nullable = false, length = 32)
	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Column(name = "\"uname\"",  nullable = false, length = 40)
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	@Column(name = "\"upwd\"",  nullable = false, length = 200)
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	
	@Column(name = "\"isactive\"")
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	
	@Override
	public String toString() {
		StringBuffer toStringBuffer = new StringBuffer("User Details  = {\n");
		toStringBuffer.append("\tUser ID :" + this.userid +"\n");
		toStringBuffer.append("\tUser Name :" + this.uname +"\n");
		toStringBuffer.append("\tisActive  :" + this.isactive +"\n}");
		return toStringBuffer.toString();
	}
	
}
