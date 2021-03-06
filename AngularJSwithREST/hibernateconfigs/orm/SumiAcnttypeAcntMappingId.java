package orm;
// Generated Oct 24, 2015 11:26:17 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SumiAcnttypeAcntMappingId generated by hbm2java
 */
@Embeddable
public class SumiAcnttypeAcntMappingId implements java.io.Serializable {

	private int acnttypeid;
	private BigDecimal channelCustId;

	public SumiAcnttypeAcntMappingId() {
	}

	public SumiAcnttypeAcntMappingId(int acnttypeid, BigDecimal channelCustId) {
		this.acnttypeid = acnttypeid;
		this.channelCustId = channelCustId;
	}

	@Column(name = "ACNTTYPEID", nullable = false, precision = 5, scale = 0)
	public int getAcnttypeid() {
		return this.acnttypeid;
	}

	public void setAcnttypeid(int acnttypeid) {
		this.acnttypeid = acnttypeid;
	}

	@Column(name = "CHANNEL_CUST_ID", nullable = false, scale = 0)
	public BigDecimal getChannelCustId() {
		return this.channelCustId;
	}

	public void setChannelCustId(BigDecimal channelCustId) {
		this.channelCustId = channelCustId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SumiAcnttypeAcntMappingId))
			return false;
		SumiAcnttypeAcntMappingId castOther = (SumiAcnttypeAcntMappingId) other;

		return (this.getAcnttypeid() == castOther.getAcnttypeid())
				&& ((this.getChannelCustId() == castOther.getChannelCustId())
						|| (this.getChannelCustId() != null && castOther.getChannelCustId() != null
								&& this.getChannelCustId().equals(castOther.getChannelCustId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getAcnttypeid();
		result = 37 * result + (getChannelCustId() == null ? 0 : this.getChannelCustId().hashCode());
		return result;
	}

}
