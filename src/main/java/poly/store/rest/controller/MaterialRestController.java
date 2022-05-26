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

import poly.store.entity.Material;
import poly.store.service.MaterialService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/materials")
public class MaterialRestController {

	@Autowired
	MaterialService materialService;
	
	@GetMapping
	public List<Material> getAll(){
		return materialService.findAll();
		
	}
	
	@GetMapping("{id}")
	public Material getOne(@PathVariable("id")Integer id) {
		return materialService.findById(id);
	}
	@PostMapping()
	public Material create(@RequestBody Material material) {
		return materialService.create(material);
	}
	@PutMapping("{id}")
	public Material put(@PathVariable("id")Integer id,@RequestBody Material material) {
		return materialService.update(material);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id")Integer id) {
		materialService.delete(id);
	}
}
