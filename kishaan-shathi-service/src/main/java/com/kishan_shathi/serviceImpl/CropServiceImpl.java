package com.kishan_shathi.serviceImpl;

import java.sql.Blob;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.kishan_shathi.dto.CropDto;
import com.kishan_shathi.entity.Crop;
import com.kishan_shathi.repository.CropRepository;
import com.kishan_shathi.service.CropService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CropServiceImpl implements CropService {
	private CropRepository cropRepo;

	public CropServiceImpl(CropRepository cropRepo) {
		this.cropRepo = cropRepo;
	}

//	@Override
//	public CropDto addCrop(CropDto cropDto) {
//		log.info("addcrop method in crop service entered");
//		cropDto.setCropId(randomString());
//		log.info("cropId : {}", cropDto.getCropId());
//		Crop crop = new Crop();
//		log.info("crop1 : {}", crop);
//		BeanUtils.copyProperties(cropDto, crop);
//		log.info("crop2 : {}", crop);
//		Crop savedCrop = cropRepo.save(crop);
//		log.info("savedCrop : {}", savedCrop);
//		if (savedCrop != null) {
//			return cropDto;
//		} else {
//			return null;
//		}
//	}



	@Override
	public CropDto addCrop(CropDto cropDto) {
		log.info("addCrop method in crop service entered");

		// Generate unique cropId
		cropDto.setCropId(randomString());
		log.info("cropId: {}", cropDto.getCropId());

		// Convert byte[] image directly to cropImage
		byte[] cropImageData = cropDto.getCropImage(); // Already byte[] in DTO

		Crop crop = new Crop();
		log.info("Creating Crop entity with ID: {}", cropDto.getCropId());
		BeanUtils.copyProperties(cropDto, crop);
		crop.setCropImage(cropImageData); // Set byte[] image data directly

		Crop savedCrop = cropRepo.save(crop);
		//log.info("Saved Crop: {}", savedCrop);

		return savedCrop != null ? cropDto : null;
	}

	@Override
	public CropDto findCropDetails(String cropId) {
		Crop crop = cropRepo.findById(cropId).orElseThrow(()->new RuntimeException("\"Invalid Crop Id!!\""));
		log.info("findCropDetails crop:{}", crop);
		CropDto cropDto = new CropDto();
		BeanUtils.copyProperties(crop, cropDto);
		log.info("findCropDetails cropDto:{}", cropDto);
		return cropDto;
	}

	@Override
	public CropDto udateCropDetails(String cropId, CropDto cropDto) {
		Crop crop = cropRepo.findById(cropId).orElse(null);

		if (crop != null) {
			crop.setCropName(cropDto.getCropName());
			crop.setCropSeason(cropDto.getCropSeason());
			crop.setCropType(cropDto.getCropType());
			crop.setDescription(cropDto.getDescription());
			crop.setIrrigationType(cropDto.getIrrigationType());
			crop.setQualityGrade(cropDto.getQualityGrade());
			crop.setSoilType(cropDto.getSoilType());
			cropRepo.save(crop);
			return cropDto;

		} else {
			throw new RuntimeException("Invalid Crop Id!!");
		}

	}

	@Override
	public List<CropDto> findAllCrops() {
		List<Crop> cropList = cropRepo.findAll();
		return cropList.stream().map(crop -> {
			CropDto cropDto = new CropDto();
			BeanUtils.copyProperties(crop, cropDto);
			return cropDto;
		}).collect(Collectors.toList());
	}

	private static String randomString() {
		return UUID.randomUUID().toString().replace("-", "").trim();
	}

}
