package poly.store.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.store.entity.Strap;
import poly.store.service.StrapService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/straps")
public class StrapRestController {
	
	@Autowired
	StrapService strapService;
	
	@GetMapping
	public List<Strap> getAll(){
		return strapService.findAll();
		
	}
	
	@GetMapping("{id}")
	public Strap getOne(@PathVariable("id")Integer id) {
		return strapService.findById(id);
	}
	@PostMapping()
	public Strap create(@RequestBody Strap strap) {
		return strapService.create(strap);
	}
	@PutMapping("{id}")
	public Strap put(@PathVariable("id")Integer id,@RequestBody Strap strap) {
		return strapService.update(strap);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id")Integer id) {
		strapService.delete(id);
	}

}
