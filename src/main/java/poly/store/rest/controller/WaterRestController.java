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
import poly.store.entity.Water;
import poly.store.service.WaterService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/water")
public class WaterRestController {

	@Autowired
	WaterService waterService;
	
	@GetMapping
	public List<Water> getAll(){
		return waterService.findAll();
		
	}
	@GetMapping("{id}")
	public Water getOne(@PathVariable("id")Integer id) {
		return waterService.findById(id);
	}
	@PostMapping()
	public Water create(@RequestBody Water water) {
		return waterService.create(water);
	}
	@PutMapping("{id}")
	public Water put(@PathVariable("id")Integer id,@RequestBody Water water) {
		return waterService.update(water);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id")Integer id) {
		waterService.delete(id);
	}
}
