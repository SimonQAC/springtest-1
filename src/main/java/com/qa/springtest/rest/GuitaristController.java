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

import com.qa.springtest.dto.GuitaristDTO;
import com.qa.springtest.service.GuitaristService;

@RestController
@RequestMapping("/guitarist")
public class GuitaristController {

	
	public GuitaristService service;

	@Autowired
	public GuitaristController(GuitaristService service) {
		super();
		this.service = service;
	}

	
	//create
	@PostMapping("/create")
	public ResponseEntity<GuitaristDTO> create(@RequestBody GuitaristDTO guitaristDTO){
		GuitaristDTO created = this.service.createGuitarist(guitaristDTO);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	//readall
	@GetMapping("/readall")
	public ResponseEntity<List<GuitaristDTO>> getAllGuitarists(){
		return ResponseEntity.ok(this.service.read());
	}
	
	//readbyid
	@GetMapping("/read/{id}")
	public ResponseEntity<GuitaristDTO> getGuitaristById(@PathVariable Long id){
		return ResponseEntity.ok(this.service.getGuitaristById(id));
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<GuitaristDTO> updateGuitarist(@PathVariable Long id,@RequestBody GuitaristDTO guitaristDTO){
		GuitaristDTO updated = this.service.update(guitaristDTO, id);
		return new ResponseEntity<>(updated, HttpStatus.ACCEPTED);
	}
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<GuitaristDTO> delete(@PathVariable Long id){
		return this.service.delete(id)
				? new ResponseEntity<>(HttpStatus.NO_CONTENT)
						: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
