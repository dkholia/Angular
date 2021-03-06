package orm;
// Generated Oct 24, 2015 11:26:17 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ChCustomerAuditView generated by hbm2java
 */
@Entity
@Table(name = "CH_CUSTOMER_AUDIT_VIEW", schema = "SCHOOL")
public class ChCustomerAuditView implements java.io.Serializable {

	private ChCustomerAuditViewId id;

	public ChCustomerAuditView() {
	}

	public ChCustomerAuditView(ChCustomerAuditViewId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "hostCustomerId", column = @Column(name = "HOST_CUSTOMER_ID", length = 4000) ),
			@AttributeOverride(name = "hostCustomerName", column = @Column(name = "HOST_CUSTOMER_NAME", length = 4000) ),
			@AttributeOverride(name = "hostId", column = @Column(name = "HOST_ID", length = 4000) ),
			@AttributeOverride(name = "action", column = @Column(name = "ACTION", length = 4000) ),
			@AttributeOverride(name = "status", column = @Column(name = "STATUS", length = 200) ),
			@AttributeOverride(name = "createdBy", column = @Column(name = "CREATED_BY", length = 4000) ),
			@AttributeOverride(name = "createdDateTime", column = @Column(name = "CREATED_DATE_TIME") ) })
	public ChCustomerAuditViewId getId() {
		return this.id;
	}

	public void setId(ChCustomerAuditViewId id) {
		this.id = id;
	}

}
