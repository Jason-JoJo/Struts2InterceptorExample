package com.journaldev.struts2.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport{

	
	private static final long serialVersionUID = -4523017150100193077L;
	private InputStream fileInputStream;
	public InputStream getInputStream() {
		return fileInputStream;
	}
	
	public String execute() throws Exception {
//		String path ="D:\\temp\\download.txt";
		String path ="/file/download.txt";
		System.out.println("in downloadAction path = "+path);
		File file = new File(path);
		fileInputStream = new FileInputStream(file); 
		return "success";
	}

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}
	
	
}
