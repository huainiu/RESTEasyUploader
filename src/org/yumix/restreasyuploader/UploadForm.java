package org.yumix.restreasyuploader;

import java.io.InputStream;

import javax.ws.rs.FormParam;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class UploadForm {
	@FormParam("file")
	@PartType("application/octet-stream")
	private InputStream file;
	
	@FormParam("filename")
	@PartType("text/plain")
	private String fileName;
	
	@FormParam("send")
	@PartType("text/plain")
	private String send;

	public InputStream getFile() {
		return file;
	}

	public void setFile(InputStream file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSend() {
		return send;
	}

	public void setSend(String send) {
		this.send = send;
	}
	
}
