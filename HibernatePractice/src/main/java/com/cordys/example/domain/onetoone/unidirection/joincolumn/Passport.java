package com.cordys.example.domain.onetoone.unidirection.joincolumn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "Passport_EM")
@Table(name = "Passport_PK")
@NamedQueries({
	@NamedQuery(name = "Passport.all", query="from Passport_EM"),
	@NamedQuery(name = "Passport.findById", query = "from Passport_EM p where p.passportId = :id")
})
public class Passport {
	
	@Id
	private int passportId;
	
	@Column(name = "No")
	private String passportNo;
	
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
