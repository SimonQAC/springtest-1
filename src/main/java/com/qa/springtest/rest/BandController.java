package com.qa.springtest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qa.springtest.dto.BandDTO;
import com.qa.springtest.persistence.domain.Band;
import com.qa.springtest.service.BandService;

@RestController
@RequestMapping("/band")
public class BandController {

	
	public BandService service;

	@Autowired
	public BandController(BandService service) {
		super();
		this.service = service;
	}

	
	//create
    @PostMapping("/create")
    public ResponseEntity<BandDTO> create(@RequestBody Band band) {
        BandDTO created = this.service.create(band);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
		
	//readall
	@GetMapping("/readall")
	public ResponseEntity<List<BandDTO>> getAllBands(){
		return ResponseEntity.ok(this.service.read());
	}
	
	//readbyid
	@GetMapping("/read/{id}")
	public ResponseEntity<BandDTO> getBandById(@PathVariable Long id){
		return ResponseEntity.ok(this.service.read(id));
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<BandDTO> updateBand(@PathVariable Long id,@RequestBody BandDTO bandDTO){
		BandDTO updated = this.service.update(bandDTO, id);
		return new ResponseEntity<>(updated, HttpStatus.ACCEPTED);
	}
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<BandDTO> delete(@PathVariable Long id){
		return this.service.delete(id)
				? new ResponseEntity<>(HttpStatus.NO_CONTENT)
						: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}