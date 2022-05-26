package poly.store.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.store.entity.Product;
import poly.store.service.ProductService;


@Controller
public class ProductController {
		
	@Autowired
	ProductService productService;

//	
//	@RequestMapping("/product/list")
//	public String list(Model model, @RequestParam("cid")Optional<String> cid) {
//		if(cid.isPresent()) {
//			List<Product> list = productService.findByCategoryId(cid.get());
//			
//			model.addAttribute("items",list);
//		}else {
//		List<Product> list = productService.findAll();
//
//
// 		model.addAttribute("items",list);
//		
//		}
//		return "product/list";
//	}
	

	
//	@GetMapping("/page/{pageNo}")
//	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, Model model) {
//		int pageSize = 10;
//		
//		Page<Product> page = productService.findPaginated(pageNo, pageSize);
//		List<Product> list = page.getContent();
//		
//		model.addAttribute("currentPage", pageNo);
//		model.addAttribute("totalPages", page.getTotalPages());
//		model.addAttribute("totalItems", page.getTotalElements());
//		model.addAttribute("items", list);
//		return "product/list";
//		
//		
//	}
//	
	@RequestMapping("/product/list")
	public String list(Model model, @RequestParam("cid")Optional<Integer> cid) {
		if(cid.isPresent()) {
			List<Product> list = productService.findByBrandId(cid.get());
			
			model.addAttribute("items",list);
		}else {
		List<Product> list = productService.findAll();


 		model.addAttribute("items",list);
		
		}
		return "product/list";
	}
	@RequestMapping("/product/collections")
	public String list1(Model model, @RequestParam("cid")Optional<Integer> cid) {
		if(cid.isPresent()) {
			List<Product> list = productService.findByCollectionId(cid.get());
			
			model.addAttribute("items",list);
		}else {
		List<Product> list = productService.findAll();


 		model.addAttribute("items",list);
		
		}
		return "product/list";
	}
	
	
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id")Integer id) {
		Product item = productService.findById(id);
		model.addAttribute("item",item);
		return "product/detail";
	}
	
	@RequestMapping("/product/sort/name")
	public String sortName(Model model) {
		List<Product> list = productService.sortByName();
		model.addAttribute("items",list);
		return "product/list";
		
	}
	@RequestMapping("/product/gender/female")
	public String Female(Model model) {
		List<Product> list = productService.female();
		model.addAttribute("items",list);
		return "product/list";
		
	}
	@RequestMapping("/product/gender/male")
	public String Male(Model model) {
		List<Product> list = productService.male();
		model.addAttribute("items",list);
		return "product/list";
		
	}
	@RequestMapping("/product/sort/priceASC")
	public String sortPriceASC(Model model) {
		List<Product> list = productService.sortByPriceASC();
		model.addAttribute("items",list);
		return "product/list";
		
	}
	@RequestMapping("/product/sort/priceDESC")
	public String sortPriceDESC(Model model) {
		List<Product> list = productService.sortByPriceDESC();
		model.addAttribute("items",list);
		return "product/list";
		
	}
	@RequestMapping("/product/search")
	public String name(Model model, @Param("keyword")String keyword) {					
		//List<Product> items = dao.findByKeyword("%"+name+"%");
		List<Product> list = productService.findByKeyword(keyword);
		model.addAttribute("items", list);			
		return "product/list";	
	}
}
