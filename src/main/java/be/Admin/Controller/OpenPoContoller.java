package be.Admin.Controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import be.Admin.Handler.GeneralHandler;
import be.Admin.Model.ListPo;
import be.Admin.Model.OrderHead;
import be.Admin.Model.Product;
import be.Admin.Model.ReturnMessage;
import be.Admin.Service.GeneralService;
import be.Admin.Service.ListPoService;

@RestController
public class OpenPoContoller {
	@Autowired
	GeneralHandler generalHandler;
	
	@Autowired
	GeneralService generalService;
	
	@Autowired	
	ListPoService listPoService;
	
	private static final int INITIAL_PAGE_SIZE = 10;
	@RequestMapping(value = "/gen-po/{pageNumber}", method = RequestMethod.GET)
	public ModelAndView GeneralProd(@PathVariable Integer pageNumber) throws Exception {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("activePage", "Openpo/index");
		modelAndView.addObject("Title", "Open po");
		modelAndView.addObject("subTitle", "list all order today");
		ObjectMapper mapper = new ObjectMapper();
		
	
			Page<ListPo> page = listPoService.getOrderpo(pageNumber, INITIAL_PAGE_SIZE);
			int current = page.getNumber() + 1;
			int begin = Math.max(1, current - 5);
			int end = Math.min(begin + 10, page.getTotalPages());
			// handler.getMainData(result);
//			 for (Product prod : page) {
//			 System.out.println(prod.getDeschead()+"------------"+prod.getItmprice()+"------------"+prod.getItemicon());
//			 System.err.println(prod.getProductCategory().getDesc());
//			 }
			
			System.out.println(mapper.writeValueAsString(page));
			 
//			 page.getTotalPages()
//			System.err.println(current);
			modelAndView.addObject("Page", page);
			modelAndView.addObject("CurrentIndex", current);
			modelAndView.addObject("beginIndex", begin);
			modelAndView.addObject("endIndex", end);
			// modelAndView.addObject("newPack", result.getRsltArray());
		
		return modelAndView;
	}
	
//	@RequestMapping(value = { "/gen-po" }, method = RequestMethod.GET)
//	 public ModelAndView viewOrder(@Valid @ModelAttribute ListPo model, BindingResult bindingResult,@PathVariable Long id) {
//		ModelAndView modelAndView = new ModelAndView("Openpo/crud");
//		ObjectMapper mapper = new ObjectMapper();
//		ReturnMessage respon = new ReturnMessage();
//		
//		List<ListPo> lcpo = generalService.getAllPoProduct(model.getTglord());
//		String ActionTodo="";
//		return modelAndView;
//		
//	 }
	
	
	
}
