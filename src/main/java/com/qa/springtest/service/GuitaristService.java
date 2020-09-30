package com.qa.springtest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springtest.dto.GuitaristDTO;
import com.qa.springtest.exception.GuitaristNotFoundException;
import com.qa.springtest.persistence.domain.Guitarist;
import com.qa.springtest.persistence.repo.GuitaristRepository;
import com.qa.springtest.utils.SpringBeanUtils;



@Service
public class GuitaristService {

	private GuitaristRepository repo;
	
	private ModelMapper mapper;

	@Autowired
	public GuitaristService(GuitaristRepository repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private GuitaristDTO mapToDTO(Guitarist guitarist) {
		return this.mapper.map(guitarist, GuitaristDTO.class);
	}
		
	private Guitarist mapFromDTO(GuitaristDTO guitaristDTO) {
		return this.mapper.map(guitaristDTO,  Guitarist.class);
	}
	
	//create
    public GuitaristDTO create(Guitarist guitarist) {
        Guitarist created = this.repo.save(guitarist);
        GuitaristDTO mapped = this.mapToDTO(created);
        return mapped;
    }
	
	//read
    public List<GuitaristDTO> read() {
        List<Guitarist> found = this.repo.findAll();
        List<GuitaristDTO> streamed = found.stream().map(this::mapToDTO).collect(Collectors.toList());
        return streamed;
    }
    
	//readbyid
    public GuitaristDTO read(Long id) {
        Guitarist found = this.repo.findById(id).orElseThrow(GuitaristNotFoundException::new);
        return this.mapToDTO(found);
    }
	
	//update
	public GuitaristDTO update(GuitaristDTO guitaristDTO, Long id) {
		Guitarist toUpdate = this.repo.findById(id).orElseThrow(GuitaristNotFoundException::new);
		SpringBeanUtils.mergeObject(guitaristDTO, toUpdate);
		return this.mapToDTO(this.repo.save(toUpdate));
	}
	
	//delete
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
	
	
}
