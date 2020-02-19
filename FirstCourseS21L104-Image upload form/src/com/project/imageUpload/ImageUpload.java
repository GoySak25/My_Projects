package com.project.imageUpload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.project.dao.FilesDAO;
import com.project.entity.Files;


/**
 * Servlet implementation class ImageUpload
 */
@WebServlet("/ImageUpload")
public class ImageUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String path="C:/Users/eejay/Desktop/Image_Folder/";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String string= request.getParameter("action");
		if(string.equals("listingPage")) {
			listingPage(request, response);
		}
		else if(string.equals("viewImage")) {
			
			viewImage(request, response);
		}
		else if(string.equals("deleteImage")) {
			deleteImage(request, response);
		}
		else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String string= request.getParameter("action");
		if(string.equals("fileUpload")) {
			fileUpload(request, response);
		}
		else if(string.equals("updateImformation")) {
			updateImformation(request, response);
		}
		else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	private void deleteImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id= Integer.parseInt(request.getParameter("fileId"));
		Files file= new FilesDAO().view(id);
		//Logic to delete the file from the database
		
		new FilesDAO().delete(id);
		
		
		//Logic to delete file from the file system
		
		File fileOnDisk= new File(path+file.getFileName());
		if(fileOnDisk.delete()) {
			System.out.println("File deleted from the folder");
		}
		else {
			System.out.println("Sorr! file couldn't get deleted from the folder");
		}
		listingPage(request, response);
	}
	
	private void viewImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub\
		int id= Integer.parseInt(request.getParameter("fileId"));
		Files file= new FilesDAO().view(id);
		request.setAttribute("files", file);
		request.setAttribute("path", path);
		request.getRequestDispatcher("viewImage.jsp").forward(request, response);
		System.out.println(file);
	}
	
	private void updateImformation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int fileId= Integer.parseInt(request.getParameter("fileId"));
		String caption= request.getParameter("caption");
		String label= request.getParameter("label");
		String fileName= request.getParameter("fileName");
		Files file= new Files(fileId, fileName, label, caption);
		new FilesDAO().update(fileId, caption, label);;
		listingPage(request, response);
	}
	private void listingPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		request.setAttribute("files", new FilesDAO().getFiles());
		request.setAttribute("path", path);
		request.getRequestDispatcher("listingPage.jsp").forward(request, response);
	}

	public void fileUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletFileUpload upload= new ServletFileUpload(new DiskFileItemFactory());
		try {
			
			List<FileItem> images= upload.parseRequest(request);
			for(FileItem item: images) {
				String image= item.getName();
				int index= image.lastIndexOf("\\")+1;
				try{image=image.substring(index);}catch(Exception e) {
					// TODO: handle exception
				}
				File file= new File(path+image);
				if(!file.exists()) {
					new FilesDAO().addFilesDetails(new Files(image));
					item.write(file);
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listingPage(request, response);
	}
}
