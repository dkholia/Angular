package orm;
// Generated Oct 24, 2015 11:26:17 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * SumiAcntgrpAcntMapping generated by hbm2java
 */
@Entity
@Table(name = "SUMI_ACNTGRP_ACNT_MAPPING", schema = "SCHOOL")
public class SumiAcntgrpAcntMapping implements java.io.Serializable {

	private SumiAcntgrpAcntMappingId id;

	public SumiAcntgrpAcntMapping() {
	}

	public SumiAcntgrpAcntMapping(SumiAcntgrpAcntMappingId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "acntgroupid", column = @Column(name = "ACNTGROUPID", nullable = false, precision = 5, scale = 0) ),
			@AttributeOverride(name = "channelCustId", column = @Column(name = "CHANNEL_CUST_ID", nullable = false, scale = 0) ) })
	public SumiAcntgrpAcntMappingId getId() {
		return this.id;
	}

	public void setId(SumiAcntgrpAcntMappingId id) {
		this.id = id;
	}

}
