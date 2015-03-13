package com.gxuts.wss.dms.controller.sys;

import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxuts.wss.dms.entity.Json;

@Controller
@RequestMapping(value = "/upload")
@ResponseBody
public class UploadController {
	@RequestMapping(value="/some",method={RequestMethod.POST,RequestMethod.GET})
	public Json some(HttpServletRequest req,HttpServletResponse response){
		System.out.println("file upload++++++++++++");
		String savePath = req.getSession().getServletContext().getRealPath("");
	       savePath = savePath + "\\files\\";
	       //把文件上传到服务器指定位置，并向前台返回文件名
	       if(req.getParameter("up")!=null){
	     	DiskFileItemFactory fac = new DiskFileItemFactory();
	       ServletFileUpload upload = new ServletFileUpload(fac);
	       upload.setHeaderEncoding("utf-8");
	       List fileList = null;
	       try {
	      //文件类型解析req
	    	 fileList = (List<FileItem>)upload.parseRequest(req); 
	       } catch (FileUploadException ex) {
	         //终止文件上传，此处抛出异常
	        ex.printStackTrace();
	       }
	       Iterator it = fileList.iterator();
	       while (it.hasNext()) {
	         String  extName ="";
	          FileItem item = (FileItem) it.next();
	          if (!item.isFormField()) {
	          	String  name = item.getName();
	           String type = item.getContentType();
	           if (item.getName() == null || item.getName().trim().equals("")) {
	            continue;
	           }
	           File file = new File(savePath+name);
	           try {
	          	 //将文件存入本地服务器
	          item.write(file); 
	          //向前台返回文件名
//	          PrintWriter pw = response.getWriter();
//	          pw.print(new Json());
//	          pw.close();
//	          pw.flush();
	        } catch (Exception e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	        }
	         }
	        }
		
		
	}
	       return new Json();
}
	
}
