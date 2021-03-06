package com.spring.jpa.domain.onetoone.unidirection.joincolumn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity(name = "Passport_EM")
@Table(name = "Passport")
@NamedQueries({
	@NamedQuery(name = "Passport.all", query="from Passport_EM"),
	@NamedQuery(name = "Passport.findById", query = "from Passport_EM p where p.passportId = :id")
})
public class Passport {
	
	@Id
	private int passportId;
	
	@Column(name = "No")
	private String passportNo;
	
	@Version
	@Column(name = "Opt_Lock_Version")
	private int version;
	
	public int getPassportId() {
		return passportId;
	}

	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	

}
