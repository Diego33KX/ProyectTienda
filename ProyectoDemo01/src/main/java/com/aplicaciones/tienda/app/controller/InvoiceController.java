package com.aplicaciones.tienda.app.controller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicaciones.tienda.app.service.VentaService;
import com.aplicaciones.tienda.app.service.VentaServiceImplements;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
@Controller
@RequestMapping("/api/pdf")
public class InvoiceController {
	@Autowired
	private VentaService ventaService;
	
	@GetMapping
	public ResponseEntity<byte[]> generatedPdf() throws FileNotFoundException, JRException {

		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource((Collection<?>) ventaService.findAll());
		JasperReport compileReport = JasperCompileManager
				.compileReport(new FileInputStream("src/main/resources/invoice.jrxml"));

		HashMap<String, Object>map = new HashMap<>();
		JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport,map, beanCollectionDataSource);

		//JasperExportManager.exportReportToPdfFile(jasperPrint,
		//System.currentTimeMillis() + ".pdf");
		
		byte data[] = JasperExportManager.exportReportToPdf(jasperPrint);

		System.err.println(data);

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=contigopereport.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
	}

}