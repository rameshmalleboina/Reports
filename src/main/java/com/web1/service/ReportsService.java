package com.web1.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.web1.searchresponse.SearchResponse;
import com.web1.searchrequest.SearchRequest;

public interface ReportsService {

	public List<String> getuniquePlanName();
	
	public List<String> getuniquePlanStatus();
	
    public List<SearchResponse> search(SearchRequest request);
    
    public void generateExcel(HttpServletResponse response)throws Exception;
    
    public void generatePdf(HttpServletResponse response)  throws Exception;


    
}
