package orm;
// Generated Oct 24, 2015 11:26:17 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SmtbVUserAcnttypeMappingId generated by hbm2java
 */
@Embeddable
public class SmtbVUserAcnttypeMappingId implements java.io.Serializable {

	private String username;
	private int accounttypeid;
	private String accounttypename;

	public SmtbVUserAcnttypeMappingId() {
	}

	public SmtbVUserAcnttypeMappingId(String username, int accounttypeid, String accounttypename) {
		this.username = username;
		this.accounttypeid = accounttypeid;
		this.accounttypename = accounttypename;
	}

	@Column(name = "USERNAME", nullable = false, length = 400)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "ACCOUNTTYPEID", nullable = false, precision = 5, scale = 0)
	public int getAccounttypeid() {
		return this.accounttypeid;
	}

	public void setAccounttypeid(int accounttypeid) {
		this.accounttypeid = accounttypeid;
	}

	@Column(name = "ACCOUNTTYPENAME", nullable = false, length = 40)
	public String getAccounttypename() {
		return this.accounttypename;
	}

	public void setAccounttypename(String accounttypename) {
		this.accounttypename = accounttypename;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SmtbVUserAcnttypeMappingId))
			return false;
		SmtbVUserAcnttypeMappingId castOther = (SmtbVUserAcnttypeMappingId) other;

		return ((this.getUsername() == castOther.getUsername()) || (this.getUsername() != null
				&& castOther.getUsername() != null && this.getUsername().equals(castOther.getUsername())))
				&& (this.getAccounttypeid() == castOther.getAccounttypeid())
				&& ((this.getAccounttypename() == castOther.getAccounttypename())
						|| (this.getAccounttypename() != null && castOther.getAccounttypename() != null
								&& this.getAccounttypename().equals(castOther.getAccounttypename())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result + this.getAccounttypeid();
		result = 37 * result + (getAccounttypename() == null ? 0 : this.getAccounttypename().hashCode());
		return result;
	}

}