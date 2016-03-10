package com.skplanet.project2.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.skplanet.project2.model.ImageFile;

@Service
public class ImageUploadServiceImpl implements ImageUploadService {

	private Map<String, ImageFile> imageFilesMap;

	public ImageUploadServiceImpl() {
		init();
	}

	/**
	 * 초기화
	 */
	@Override
	public void init() {
		imageFilesMap = new HashMap<String, ImageFile>();

	}

	/**
	 * ID로 이미지 파일 가져오기
	 */
	@Override
	public ImageFile get(String id) {
		return imageFilesMap.get(id);
	}

	@Override
	public ImageFile save(MultipartFile multipartFile) {
		// UUID로 유일할 것 같은 값 생성.. 낮은 확률로 중복 가능성이 있음

		System.out.println(multipartFile.getSize());
		String genId = UUID.randomUUID().toString();   // 파일이름 난수 생성
		ImageFile imageFile = null;

		try {
			System.out.println("Service Start");
			System.out.println("Gen ID = " + genId);
			
			String savedFileName = saveToFile(multipartFile, genId); // 서버에 경로 및 파일이름 생성 + 저장
		
			System.out.println("saved File Name = " + savedFileName);
		
			imageFile = new ImageFile(genId, multipartFile.getContentType(), (int) multipartFile.getSize(),
					savedFileName);  //Model의 이미지파일 객체에 정보 삽입

			imageFilesMap.put(genId, imageFile);  // 데이터베이스에 안넣고 해시에 캐싱
		} catch (IOException e) {
			System.out.println("catch bye");
			e.printStackTrace();
		}

		return imageFile;
	}

	private String saveToFile(MultipartFile src, String id) throws IOException {

		// 경로 지정
		String fileName = src.getOriginalFilename();

		System.out.println(" File Name = " + fileName);
		byte[] bytes = src.getBytes();
		String saveFileName = id + "." + getExtension(fileName);
		System.out.println(" saveFileName Name = " + saveFileName);
		String savePath = ImageFile.IMAGE_DIR + saveFileName;
		System.out.println(" savePath = " + savePath);
		/* 서버에 파일 저장 */
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
