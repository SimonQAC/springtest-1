package com.qa.springtest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springtest.dto.BandDTO;
import com.qa.springtest.exception.BandNotFoundException;
import com.qa.springtest.persistence.domain.Band;
import com.qa.springtest.persistence.repo.BandRepository;
import com.qa.springtest.utils.SpringBeanUtils;



@Service
public class BandService {

	private BandRepository repo;
	
	private ModelMapper mapper;

	@Autowired
	public BandService(BandRepository repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private BandDTO mapToDTO(Band band) {
		return this.mapper.map(band, BandDTO.class);
	}
		
	private Band mapFromDTO(BandDTO bandDTO) {
		return this.mapper.map(bandDTO,  Band.class);
	}
	
	//create
	public BandDTO createBand(BandDTO bandDTO) {
		Band toSave = this.mapFromDTO(bandDTO);
		Band saved = this.repo.save(toSave);
		return this.mapToDTO(saved);
	}
	
	//read
	public List<BandDTO> read(){
		return this.repo.findAll()
				.stream()
				.map(this::mapToDTO)
				.collect(Collectors.toList());
	}
	
	//readbyid
	public BandDTO getBandById(Long id) {
		Band found =(this
				.repo
				.findById(id)
				.orElseThrow(BandNotFoundException::new));
		return this.mapToDTO(found);
	}
	
	//update
	public BandDTO update(BandDTO bandDTO, Long id) {
		Band toUpdate = this.repo.findById(id).orElseThrow(BandNotFoundException::new);
		SpringBeanUtils.mergeObject(bandDTO, toUpdate);
		return this.mapToDTO(this.repo.save(toUpdate));
	}
	
	//delete
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
	
	
}
