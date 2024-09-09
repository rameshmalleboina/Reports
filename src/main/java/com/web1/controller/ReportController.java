package com.web1.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web1.searchrequest.SearchRequest;
import com.web1.searchresponse.SearchResponse;
import com.web1.service.ReportsService;

@RestController
public class ReportController {


	@Autowired
	private ReportsService service;
	
	@GetMapping("/plans")
	public ResponseEntity<List<String>> getPlanName(){
		List<String> uniqueplanNames = service.getuniquePlanName();
		return new ResponseEntity<List<String>>(uniqueplanNames,HttpStatus.OK);	
	}
	
	@GetMapping("/statuses")
	public ResponseEntity<List<String>> getPlanStatus(){
		
		List<String> uniquestatuses = service.getuniquePlanStatus();
		return new ResponseEntity<List<String>>(uniquestatuses,HttpStatus.OK);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<SearchResponse>> search(@RequestBody SearchRequest request){
		
		List<SearchResponse> response = service.search(request);
		return new ResponseEntity<List<SearchResponse>>(response,HttpStatus.OK);
	}
	
	@GetMapping("/excel")
	public void excelReport(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/octet-stream");
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=data.xls";
		
		response.setHeader(headerKey, headerValue);
		
		service.generateExcel(response);
	}
	
	@GetMapping("/pdf")
	public void pdfReport(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=data.pdf";
		
		response.setHeader(headerKey, headerValue);
		
		service.generatePdf(response);
	}

}




