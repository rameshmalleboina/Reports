package com.web1.searchrequest;

import java.time.LocalDate;

public class SearchRequest {

	private String plan_name;
	private String plan_status;
	private LocalDate plan_start_date;
	private LocalDate plan_end_date;
	public SearchRequest() {
		super();
	}
	public SearchRequest(String plan_name, String plan_status, LocalDate plan_start_date, LocalDate plan_end_date) {
		super();
		this.plan_name = plan_name;
		this.plan_status = plan_status;
		this.plan_start_date = plan_start_date;
		this.plan_end_date = plan_end_date;
	}
	@Override
	public String toString() {
		return "SearchRequest [plan_name=" + plan_name + ", plan_status=" + plan_status + ", plan_start_date="
				+ plan_start_date + ", plan_end_date=" + plan_end_date + "]";
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
	
}
