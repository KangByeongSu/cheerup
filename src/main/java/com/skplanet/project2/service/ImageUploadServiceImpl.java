package com.skplanet.project2.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.skplanet.project2.model.ImageFile;

@Service
public class ImageUploadServiceImpl implements ImageUploadService {

	private static final Logger logger = LoggerFactory.getLogger(ImageUploadServiceImpl.class);

	private Map<String, ImageFile> imageFilesMap;

	public ImageUploadServiceImpl() {
		init();
	}

	@Override
	public void init() {
		imageFilesMap = new HashMap<String, ImageFile>();
	}

	@Override
	public ImageFile get(String id) {
		return imageFilesMap.get(id);
	}

	@Override
	public ImageFile save(MultipartFile multipartFile) {

		logger.info("File size is {}.", multipartFile.getSize());
		String genId = UUID.randomUUID().toString();
		ImageFile imageFile = null;

		try {

			String savedFileName = saveToFile(multipartFile, genId);
			logger.info("File Name is {}.", savedFileName);

			imageFile = new ImageFile(genId, multipartFile.getContentType(), (int) multipartFile.getSize(),
					savedFileName);

			imageFilesMap.put(genId, imageFile);
		} catch (IOException e) {
			logger.error("Error detection in middle of File Save");
			e.printStackTrace();
		}

		return imageFile;
	}

	private String saveToFile(MultipartFile src, String id) throws IOException {

		String fileName = src.getOriginalFilename();
		byte[] bytes = src.getBytes();
		String saveFileName = id + "." + getExtension(fileName);
		String savePath = ImageFile.IMAGE_DIR + saveFileName;
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(savePath));
		bos.write(bytes);
		bos.flush();
		bos.close();

		return saveFileName;
	}

	private String getExtension(String fileName) {
		int dotPosition = fileName.lastIndexOf('.');

		if (-1 != dotPosition && fileName.length() - 1 > dotPosition) {
			return fileName.substring(dotPosition + 1);
		} else {
			return "";
		}
	}

}
