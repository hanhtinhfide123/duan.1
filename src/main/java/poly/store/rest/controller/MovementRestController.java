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

import poly.store.entity.Movement;
import poly.store.service.MovementService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/movements")
public class MovementRestController {
	
	@Autowired
	MovementService movementService;
	
	@GetMapping()
	public List<Movement> getAll() {
		return movementService.findAll();
	}
	
	@GetMapping("{id}")
	public Movement getOne(@PathVariable("id")Integer id) {
		return movementService.findById(id);
	}
	@PostMapping()
	public Movement create(@RequestBody Movement movement) {
		return movementService.create(movement);
	}
	@PutMapping("{id}")
	public Movement put(@PathVariable("id")Integer id,@RequestBody Movement movement) {
		return movementService.update(movement);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id")Integer id) {
		movementService.delete(id);
	}


}
