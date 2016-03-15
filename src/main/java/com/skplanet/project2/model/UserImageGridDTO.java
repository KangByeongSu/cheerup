package com.skplanet.project2.model;

import java.util.List;

public class UserImageGridDTO extends Result{

	private List<ImageGridDTO> imageGridDTO;

	public List<ImageGridDTO> getImageGridDTO() {
		return imageGridDTO;
	}

	public void setImageGridDTO(List<ImageGridDTO> imageGridDTO) {
		this.imageGridDTO = imageGridDTO;
	}
	
}