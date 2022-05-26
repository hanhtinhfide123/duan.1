package poly.store.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.store.entity.Gender;
import poly.store.service.GenderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/genders")
public class GenderRestController {

	@Autowired
	GenderService genderService;
	
	@GetMapping
	public List<Gender> getAll(){
		return genderService.findAll();
		
	}
	
}
