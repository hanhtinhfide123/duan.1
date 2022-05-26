package poly.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import poly.store.entity.Material;
import poly.store.service.BrandService;
import poly.store.service.CategoryService;
import poly.store.service.CollectionService;
import poly.store.service.GenderService;
import poly.store.service.GlassService;
import poly.store.service.MaterialService;
import poly.store.service.MovementService;
import poly.store.service.StatusService;
import poly.store.service.StrapService;
import poly.store.service.WaterService;


@Component
public class GlobalInterceptor implements HandlerInterceptor{
	@Autowired
	CategoryService categoryService;
	@Autowired
	MovementService movementService;
	@Autowired
	CollectionService collectionService;
	@Autowired
	GlassService glassService;
	@Autowired
	StrapService strapService;
	@Autowired
	StatusService statusService;
	@Autowired
	WaterService waterService;
	@Autowired
	MaterialService materialService;
	@Autowired
	BrandService brandService;
	
	@Autowired
	GenderService genderService;


	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.setAttribute("cates", categoryService.findAll());
		request.setAttribute("moves", movementService.findAll());
		request.setAttribute("colls", collectionService.findAll());
		request.setAttribute("glas", glassService.findAll());
		request.setAttribute("wats", waterService.findAll());

		request.setAttribute("stas", strapService.findAll());
		request.setAttribute("stus", statusService.findAll());
		request.setAttribute("mats", materialService.findAll());
		request.setAttribute("bras", brandService.findAll());
		request.setAttribute("gens", genderService.findAll());


		
	}
	
	
}
