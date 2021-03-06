package orm;
// Generated Oct 24, 2015 11:26:17 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ChServicesAuditView generated by hbm2java
 */
@Entity
@Table(name = "CH_SERVICES_AUDIT_VIEW", schema = "SCHOOL")
public class ChServicesAuditView implements java.io.Serializable {

	private ChServicesAuditViewId id;

	public ChServicesAuditView() {
	}

	public ChServicesAuditView(ChServicesAuditViewId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "serviceAccessName", column = @Column(name = "SERVICE_ACCESS_NAME", length = 4000) ),
			@AttributeOverride(name = "serviceAccessDescription", column = @Column(name = "SERVICE_ACCESS_DESCRIPTION", length = 4000) ),
			@AttributeOverride(name = "servicesId", column = @Column(name = "SERVICES_ID", length = 4000) ),
			@AttributeOverride(name = "action", column = @Column(name = "ACTION", length = 4000) ),
			@AttributeOverride(name = "status", column = @Column(name = "STATUS", length = 200) ),
			@AttributeOverride(name = "createdBy", column = @Column(name = "CREATED_BY", length = 4000) ),
			@AttributeOverride(name = "createdDateTime", column = @Column(name = "CREATED_DATE_TIME") ) })
	public ChServicesAuditViewId getId() {
		return this.id;
	}

	public void setId(ChServicesAuditViewId id) {
		this.id = id;
	}

}
