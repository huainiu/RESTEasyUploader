package org.yumix.restreasyuploader;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@Path("/upload")
public class FileUploaderResource {
	// Change following path for the runtime environment
	final String home = System.getenv("USERPROFILE");
	final String downloads = "Downloads";
	
	@POST
	@Consumes("multipart/form-data")
	@Produces("text/plain")
	public String upload(@MultipartForm UploadForm form) {
		try {
			System.out.println(form.getFileName());
			Files.copy(form.getFile(), Paths.get(home, downloads, form.getFileName()), REPLACE_EXISTING);
			return String.format("File [%s] is uploaded", form.getFileName());
		} catch (IOException e) {
			throw new WebApplicationException(e, 500);
		}
	}
}
