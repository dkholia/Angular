package orm;
// Generated Oct 24, 2015 11:26:17 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CrwCaRspnsAuditId generated by hbm2java
 */
@Embeddable
public class CrwCaRspnsAuditId implements java.io.Serializable {

	private long txnid;
	private String imagetype;

	public CrwCaRspnsAuditId() {
	}

	public CrwCaRspnsAuditId(long txnid, String imagetype) {
		this.txnid = txnid;
		this.imagetype = imagetype;
	}

	@Column(name = "TXNID", nullable = false, precision = 18, scale = 0)
	public long getTxnid() {
		return this.txnid;
	}

	public void setTxnid(long txnid) {
		this.txnid = txnid;
	}

	@Column(name = "IMAGETYPE", nullable = false, length = 8)
	public String getImagetype() {
		return this.imagetype;
	}

	public void setImagetype(String imagetype) {
		this.imagetype = imagetype;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CrwCaRspnsAuditId))
			return false;
		CrwCaRspnsAuditId castOther = (CrwCaRspnsAuditId) other;

		return (this.getTxnid() == castOther.getTxnid())
				&& ((this.getImagetype() == castOther.getImagetype()) || (this.getImagetype() != null
						&& castOther.getImagetype() != null && this.getImagetype().equals(castOther.getImagetype())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getTxnid();
		result = 37 * result + (getImagetype() == null ? 0 : this.getImagetype().hashCode());
		return result;
	}

}