package com.gxuts.wss.dms.controller.sys;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.gxuts.wss.dms.entity.hr.UserInfo;
import com.gxuts.wss.dms.entity.sys.AttaFile;
import com.gxuts.wss.dms.entity.sys.AttaEditor;

@Controller
@RequestMapping(value = "/upload")
@ResponseBody
public class UploadController {
	@RequestMapping(value = "/some", method = { RequestMethod.POST,RequestMethod.GET })
	public AttaFile some(HttpServletRequest req, HttpServletResponse rep,HttpSession session) {
		String userNo=((UserInfo)session.getAttribute("loginUser")).getNo();
		AttaFile fr=new AttaFile();
		String savePath = req.getSession().getServletContext().getRealPath("");
		String webPath = "\\files\\" + userNo+new Date().getTime()+"\\";
		savePath = savePath + webPath;
		File filePath =new File(savePath);
		filePath.mkdir();
		// 把文件上传到服务器指定位置，并向前台返回文件名
		if (req.getParameter("up") != null) {
			DiskFileItemFactory fac = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fac);
			List fileList = null;
			try {
				// 文件类型解析req
				fileList = (List<FileItem>) upload.parseRequest(req);
			} catch (FileUploadException ex) {
				// 终止文件上传，此处抛出异常
				ex.printStackTrace();
			}
			Iterator it = fileList.iterator();
			while (it.hasNext()) {
				FileItem item = (FileItem) it.next();
				if (!item.isFormField()) {
					String name = item.getName();
					String type = item.getContentType();
					if (item.getName() == null
							|| item.getName().trim().equals("")) {
						continue;
					}
					File file = new File(savePath + name);
					try {
						// 将文件存入本地服务器
						item.write(file);
						fr.setFileType(name.substring(name.indexOf(".")));
						fr.setWebPath(webPath+name);
						fr.setFileName(name);
						fr.setOk(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return fr;
	}
	@RequestMapping(value = "/one", method = { RequestMethod.POST,RequestMethod.GET })
	public String tableUpload(HttpServletRequest req, HttpServletResponse rep,HttpSession session) {
		String userNo=((UserInfo)session.getAttribute("loginUser")).getNo();
		AttaFile fr=new AttaFile();
		String savePath = req.getSession().getServletContext().getRealPath("");
		String webPath = "/files/" + userNo+new Date().getTime()+"/";
		savePath = savePath + webPath;
		File filePath =new File(savePath);
		filePath.mkdir();
		String name = null;
		// 把文件上传到服务器指定位置，并向前台返回文件名
		if (req.getParameter("up") != null) {
			DiskFileItemFactory fac = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fac);
			List fileList = null;
			try {
				// 文件类型解析req
				fileList = (List<FileItem>) upload.parseRequest(req);
			} catch (FileUploadException ex) {
				// 终止文件上传，此处抛出异常
				ex.printStackTrace();
			}
			Iterator it = fileList.iterator();
			while (it.hasNext()) {
				FileItem item = (FileItem) it.next();
				if (!item.isFormField()) {
					 name = item.getName();
					if (item.getName() == null
							|| item.getName().trim().equals("")) {
						continue;
					}
					File file = new File(savePath + name);
					try {
						// 将文件存入本地服务器
						item.write(file);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return "{\"id\":\"1\",\"fileName\":\""+name+"\",\"attachmentPath\":\""+webPath+name+"\",\"attachmentSize\":\"300\"}";
	}
	@RequestMapping(value = "/editor", method = { RequestMethod.POST,RequestMethod.GET })
	public AttaEditor image(HttpServletRequest req, HttpServletResponse rep,HttpSession session) {
		String userNo=((UserInfo)session.getAttribute("loginUser")).getNo();
		AttaEditor fr=new AttaEditor();
		String savePath = req.getSession().getServletContext().getRealPath("");
		String webPath = "/files/" + userNo+new Date().getTime()+"/";
		savePath = savePath + webPath;
		File filePath =new File(savePath);
		filePath.mkdir();
		// 把文件上传到服务器指定位置，并向前台返回文件名
		if (req.getParameter("up") != null) {
			DiskFileItemFactory fac = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fac);
			List fileList = null;
			try {
				// 文件类型解析req
				fileList = (List<FileItem>) upload.parseRequest(req);
			} catch (FileUploadException ex) {
				// 终止文件上传，此处抛出异常
				ex.printStackTrace();
			}
			Iterator it = fileList.iterator();
			while (it.hasNext()) {
				FileItem item = (FileItem) it.next();
				if (!item.isFormField()) {
					String name = item.getName();
					String type = item.getContentType();
					if (item.getName() == null
							|| item.getName().trim().equals("")) {
						continue;
					}
					File file = new File(savePath + name);
					try {
						// 将文件存入本地服务器
						item.write(file);
						fr.setMsg(webPath.substring(1)+name);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return fr;
	}
	@RequestMapping("/file")
	@ResponseBody
	public AttaFile uploadFile(DefaultMultipartHttpServletRequest multipartRequest, HttpSession session) {
		AttaFile returnFile=new AttaFile();
		if (multipartRequest != null) {
			Iterator<String> iterator = multipartRequest.getFileNames();
			while (iterator.hasNext()) {
				MultipartFile file = multipartRequest.getFile((String) iterator.next());
				if (!file.isEmpty()) {
					System.out.println(file.getContentType());// 获取文件MIME类型
					System.out.println(file.getName());// 获取表单中文件组件的名字
					System.out.println(file.getOriginalFilename());// 获取上传文件的原名
					System.out.println(file.getSize());// 获取文件的字节大小，单位byte
					try {
						// 文件保存路径
						String filePath = session.getServletContext().getRealPath("/") + File.separator;
						File uploadFile = new File(filePath + file.getOriginalFilename());
						uploadFile.mkdirs();
						file.transferTo(uploadFile);// 保存到一个目标文件中。
					} catch (Exception e) {
						returnFile.setFileName("文件上传失败");
						returnFile.setOk(false);
						System.out.println(e.getLocalizedMessage());
						e.printStackTrace();
					}
				}
			}
		}
		return returnFile;
	}
	@RequestMapping("/diskList")
	public String personFile(HttpSession session, Integer currentPage, Integer row, Model model) {
		UserInfo user= (UserInfo)session.getAttribute("loginUser");
		return "diskListDialog";
	}
	
	@RequestMapping(value="/formUpload", method = { RequestMethod.POST,RequestMethod.GET})
	public String handleFormUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file,HttpServletRequest req) throws IOException {
		// MultipartFile是对当前上传的文件的封装，当要同时上传多个文件时，可以给定多个MultipartFile参数
		if (!file.isEmpty()) {
			String savePath = req.getSession().getServletContext().getRealPath("/files/"+System.currentTimeMillis()+"/");
			String filename = file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			FileUtils.writeByteArrayToFile(new File(savePath,filename), bytes);
			System.out.println("上传成功");
			return null;
		} else {
			System.out.println("上传失败");
			return null;
		}
	} 
}
