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

import poly.store.entity.Collection;
import poly.store.entity.Material;
import poly.store.service.CollectionService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/collections")
public class CollectionRestController {
	
	@Autowired
	CollectionService collectionService;
	
	@GetMapping()
	public List<Collection> getAll() {
		return collectionService.findAll();
	}

	@GetMapping("{id}")
	public Collection getOne(@PathVariable("id")Integer id) {
		return collectionService.findById(id);
	}
	@PostMapping()
	public Collection create(@RequestBody Collection collection) {
		return collectionService.create(collection);
	}
	@PutMapping("{id}")
	public Collection put(@PathVariable("id")Integer id,@RequestBody Collection collection) {
		return collectionService.update(collection);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id")Integer id) {
		collectionService.delete(id);
	}
}
