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

import poly.store.entity.Glass;
import poly.store.entity.Material;
import poly.store.service.GlassService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/glasses")
public class GlassRestController {
	
	@Autowired
	GlassService glassService;
	
	@GetMapping
	public List<Glass> getAll(){
		return glassService.findAll();
		
	}
	
	@GetMapping("{id}")
	public Glass getOne(@PathVariable("id")Integer id) {
		return glassService.findById(id);
	}
	@PostMapping()
	public Glass create(@RequestBody Glass glass) {
		return glassService.create(glass);
	}
	@PutMapping("{id}")
	public Glass put(@PathVariable("id")Integer id,@RequestBody Glass glass) {
		return glassService.update(glass);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id")Integer id) {
		glassService.delete(id);
	}

}
