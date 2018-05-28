package be.Admin.Model;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
//	 @Transient
//	  private MultipartFile file;
//		public MultipartFile getFile() {
//			return file;
//		}
//	
//		public void setFile(MultipartFile file) {
//			this.file = file;
//		}
	
	 @NotEmpty(message = "Description is required")
	  private String extraField;

	    public String getExtraField() {
		return extraField;
	}

	public void setExtraField(String extraField) {
		this.extraField = extraField;
	}

//	public MultipartFile[] getFiles() {
//		return files;
//	}
//
//	public void setFiles(MultipartFile[] files) {
//		this.files = files;
//	}
//	 @NotEmpty(message = "Description is required")

		private MultipartFile files;

		public MultipartFile getFiles() {
			return files;
		}

		public void setFiles(MultipartFile files) {
			this.files = files;
		}
}
