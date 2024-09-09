package com.web1.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Eligibility_dtls {

	@Id
	private Integer elig_ID;
	private String name;
	private long mobile;
	private String email;
	private Character gender;
	private Long ssn;
	private String plan_name;
	private String plan_status;
	private LocalDate plan_start_date;
	private LocalDate plan_end_date;
	private LocalDate create_date;
	private LocalDate update_date;
	private LocalDate created_by;
	private LocalDate update_by;

	public Eligibility_dtls() {
		super();
	}

	public Eligibility_dtls(Integer elig_ID, String name, long mobile, String email, Character gender, Long ssn,
			String plan_name, String plan_status, LocalDate plan_start_date, LocalDate plan_end_date,
			LocalDate create_date, LocalDate update_date, LocalDate created_by, LocalDate update_by) {
		super();
		this.elig_ID = elig_ID;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.gender = gender;
		this.ssn = ssn;
		this.plan_name = plan_name;
		this.plan_status = plan_status;
		this.plan_start_date = plan_start_date;
		this.plan_end_date = plan_end_date;
		this.create_date = create_date;
		this.update_date = update_date;
		this.created_by = created_by;
		this.update_by = update_by;
	}

	@Override
	public String toString() {
		return "Eligibility_dtls [elig_ID=" + elig_ID + ", name=" + name + ", mobile=" + mobile + ", email=" + email
				+ ", gender=" + gender + ", ssn=" + ssn + ", plan_name=" + plan_name + ", plan_status=" + plan_status
				+ ", plan_start_date=" + plan_start_date + ", plan_end_date=" + plan_end_date + ", create_date="
				+ create_date + ", update_date=" + update_date + ", created_by=" + created_by + ", update_by="
				+ update_by + "]";
	}

	public Integer getElig_ID() {
		return elig_ID;
	}

	public void setElig_ID(Integer elig_ID) {
		this.elig_ID = elig_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public String getPlan_name() {
		return plan_name;
	}

	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}

	public String getPlan_status() {
		return plan_status;
	}

	public void setPlan_status(String plan_status) {
		this.plan_status = plan_status;
	}

	public LocalDate getPlan_start_date() {
		return plan_start_date;
	}

	public void setPlan_start_date(LocalDate plan_start_date) {
		this.plan_start_date = plan_start_date;
	}

	public LocalDate getPlan_end_date() {
		return plan_end_date;
	}

	public void setPlan_end_date(LocalDate plan_end_date) {
		this.plan_end_date = plan_end_date;
	}

	public LocalDate getCreate_date() {
		return create_date;
	}

	public void setCreate_date(LocalDate create_date) {
		this.create_date = create_date;
	}

	public LocalDate getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(LocalDate update_date) {
		this.update_date = update_date;
	}

	public LocalDate getCreated_by() {
		return created_by;
	}

	public void setCreated_by(LocalDate created_by) {
		this.created_by = created_by;
	}

	public LocalDate getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(LocalDate update_by) {
		this.update_by = update_by;
	}

	

	
	

	

}
