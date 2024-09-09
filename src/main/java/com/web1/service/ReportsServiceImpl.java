package com.web1.service;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.web1.entity.Eligibility_dtls;
import com.web1.repo.Eligiblerepo;
import com.web1.searchrequest.SearchRequest;
import com.web1.searchresponse.SearchResponse;

@Service
public class ReportsServiceImpl implements ReportsService{
	
	@Autowired
	private Eligiblerepo repo;

	@Override
	public List<String> getuniquePlanName() {
		return repo.findPlanName();
	}

	@Override
	public List<String> getuniquePlanStatus() {
		return repo.findPlanStatus();
	}

	@Override
	public List<SearchResponse> search(SearchRequest request) {
		
		List<SearchResponse> response = new ArrayList<>();
		
		Eligibility_dtls queryBuilder = new Eligibility_dtls();
		
		String plan_name = request.getPlan_name();
		
		if(plan_name !=null && !plan_name.equals("")) {
			
			queryBuilder.setPlan_name(plan_name);
		}
        String plan_status = request.getPlan_status();
		
		if(plan_status !=null && !plan_status.equals("")) {
			
			queryBuilder.setPlan_status(plan_status);
		}
		
		LocalDate plan_start_date = request.getPlan_start_date();
		
		if(plan_start_date !=null ) {
			queryBuilder.setPlan_start_date(plan_start_date);
			
		}
       LocalDate plan_end_date = request.getPlan_end_date();
		
		if(plan_end_date !=null) {
			queryBuilder.setPlan_end_date(plan_end_date);
		}
		
		Example<Eligibility_dtls> example = Example.of(queryBuilder);
		
		List<Eligibility_dtls> entities = repo.findAll();
		for (Eligibility_dtls entity : entities) {
			
			SearchResponse sr = new SearchResponse();
			BeanUtils.copyProperties(entity, sr);
			response.add(sr);
		}
		return response;
	}

	@Override
	public void generateExcel(HttpServletResponse response) throws Exception {
		
	List<Eligibility_dtls> entities = repo.findAll();
	HSSFWorkbook workBook = new HSSFWorkbook();
	
	HSSFSheet sheet =workBook.createSheet();
	HSSFRow headRow = sheet.createRow(0);
	
	headRow.createCell(0).setCellValue("Name");
	headRow.createCell(1).setCellValue("Email");
	headRow.createCell(2).setCellValue("Gender");
	headRow.createCell(3).setCellValue("MobileNo");
	headRow.createCell(4).setCellValue("SSN");
	
	for(Eligibility_dtls entity: entities) {
		
		int i =1;
		HSSFRow dataRow = sheet.createRow(i);
		dataRow.createCell(0).setCellValue(entity.getName());
		System.out.println("name=======" +entity.getName());
		dataRow.createCell(1).setCellValue(entity.getEmail());
		dataRow.createCell(2).setCellValue(String.valueOf(entity.getGender()));
		dataRow.createCell(3).setCellValue(entity.getMobile());
		dataRow.createCell(4).setCellValue(entity.getSsn());
		i++;
	}
	
		 ServletOutputStream outputstream= response.getOutputStream();
		 workBook.write(outputstream);
		 workBook.close();
	}

	@Override
	public void generatePdf(HttpServletResponse response)  throws Exception {
	
        List<Eligibility_dtls> entities = repo.findAll();
		
		Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("List of Users", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);
         
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
        
        font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
        
        cell.setPhrase(new Phrase("Name",font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Email",font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Phno",font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Gender",font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("SSN",font));
        table.addCell(cell);
        
        for(Eligibility_dtls entity : entities) {
        	table.addCell(entity.getName());
        	table.addCell(entity.getEmail());
        	table.addCell(String.valueOf(entity.getMobile()));
        	table.addCell(String.valueOf(entity.getGender()));
        	table.addCell(String.valueOf(entity.getSsn()));
        }
        
        document.add(table);
        
        document.close();
         
	}
//Ramesh
	
	}


