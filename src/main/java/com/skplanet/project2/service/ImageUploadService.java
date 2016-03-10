package com.skplanet.project2.service;

import org.springframework.web.multipart.MultipartFile;

import com.skplanet.project2.model.ImageFile;

interface ImageUploadService {

	void init();

	ImageFile get(String id);

	ImageFile save(MultipartFile multipartFile);
}
