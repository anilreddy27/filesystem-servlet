package com.filesystem.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "List The Already Uploaded Files", urlPatterns = { "/uploadedFilesServlet" })
public class UploadedFilesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String UPLOAD_DIR = "C:/Directory1/documents";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}

	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FileUtils fileUtils = new FileUtils();
		String uploadPath = fileUtils.getPropValues(getServletContext()).getProperty("filepath");

		File fileUploadDirectory = new File(uploadPath);
		if (!fileUploadDirectory.exists()) {
			fileUploadDirectory.mkdirs();
		}

		DownloadDetail details = null;
		File[] allFiles = fileUploadDirectory.listFiles();
		List<DownloadDetail> fileList = new ArrayList<DownloadDetail>();		

		for (File file : allFiles) {
			details = new DownloadDetail();
			details.setFileName(file.getName());
			details.setFileSize(file.length() / 1024);
			fileList.add(details);
		}

		request.setAttribute("uploadedFiles", fileList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/allfiles.jsp");
		dispatcher.forward(request, response);
	}
}