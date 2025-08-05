package com.hana7.springdemo.jpa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UploadResponseDTO {
	private String originalFileName;
	private String fileName;
	private boolean isImage;

	public String getLink() {
		if (isImage) {
			return "thumb_" + fileName;
		}
		return fileName;
	}
}