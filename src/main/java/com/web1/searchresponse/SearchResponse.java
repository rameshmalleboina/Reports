package com.web1.searchresponse;

public class SearchResponse {

	private String name;
	private long mobile;
	private String email;
	private Character gender;
	private Long ssn;
	
	public SearchResponse() {
		super();
	}
	public SearchResponse(String name, long mobile, String email, Character gender, Long ssn) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.gender = gender;
		this.ssn = ssn;
	}
	@Override
	public String toString() {
		return "SearchResponse [name=" + name + ", mobile=" + mobile + ", email=" + email + ", gender=" + gender
				+ ", ssn=" + ssn + "]";
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
	
}
