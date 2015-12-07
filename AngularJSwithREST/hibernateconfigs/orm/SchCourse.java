package orm;
// Generated Oct 24, 2015 11:26:17 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * SchCourse generated by hbm2java
 */
@Entity
@Table(name = "SCH_COURSE", schema = "SCHOOL")
public class SchCourse implements java.io.Serializable {

	private BigDecimal courseid;
	private String coursename;
	private Set<SchUser> schUsers = new HashSet<SchUser>(0);

	public SchCourse() {
	}

	public SchCourse(BigDecimal courseid) {
		this.courseid = courseid;
	}

	public SchCourse(BigDecimal courseid, String coursename, Set<SchUser> schUsers) {
		this.courseid = courseid;
		this.coursename = coursename;
		this.schUsers = schUsers;
	}

	@Id

	@Column(name = "COURSEID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCourseid() {
		return this.courseid;
	}

	public void setCourseid(BigDecimal courseid) {
		this.courseid = courseid;
	}

	@Column(name = "COURSENAME", length = 100)
	public String getCoursename() {
		return this.coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "schCourses")
	public Set<SchUser> getSchUsers() {
		return this.schUsers;
	}

	public void setSchUsers(Set<SchUser> schUsers) {
		this.schUsers = schUsers;
	}

}