package com.gxuts.wss.drug.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.catalina.filters.RemoteIpFilter.XForwardedRequest;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlException;
import org.junit.Test;

public class TestOfficeFile {
	//2003版
	@Test
	public void createExcel() throws IOException{
		HSSFWorkbook wb=new HSSFWorkbook();
		FileOutputStream fos=new FileOutputStream("F:/test.xls");
		HSSFSheet sheet1= wb.createSheet("工作表一");
		HSSFRow row=sheet1.createRow(0);
		row.createCell(0).setCellValue("dd");
		wb.write(fos);
		fos.close();
	}
	//2007
	@Test
	public void createXExcel() throws IOException{
		XSSFWorkbook xb=new XSSFWorkbook();
		FileOutputStream fos =new FileOutputStream("F:/test.xlsx");
		xb.write(fos);
		fos.close();
	}
	//word2003读取
	@Test
	public void testWrod() throws IOException{
		FileInputStream fis=new FileInputStream("F:/test.docx");
		WordExtractor we=new WordExtractor(fis);
		System.out.println(we.getText());
	}
	
	//word创建
	@Test
	public void testCreateWrod() throws IOException, XmlException, OpenXML4JException{
        XWPFDocument doc = new XWPFDocument();
        XWPFParagraph para= doc.createParagraph();
        XWPFRun run = para.createRun();
        run.setText("内容2");
        File file = new File( "F:/xxx.doc");
        FileOutputStream out = new FileOutputStream(file);
        doc.write(out);
        out.close();
	}
	//word2007
	@Test
	public void testXWrod() throws IOException, XmlException, OpenXML4JException{
		String file="F:/test.docx";
		XWPFWordExtractor wpf=new XWPFWordExtractor(OPCPackage.open(file));
		System.out.println(wpf.getText());
	}
	

}
