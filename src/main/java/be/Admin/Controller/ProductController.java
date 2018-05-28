package be.Admin.Controller;

//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

//import org.apache.catalina.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import be.Admin.Handler.GeneralHandler;
import be.Admin.Handler.MainHandler;
//import be.Admin.Model.FileUpload;
import be.Admin.Model.KategoryModel;
import be.Admin.Model.PcsModel;
//import be.Admin.Implement.ProductImpl;
//import be.Admin.Model.Contact;
import be.Admin.Model.Product;
//import be.Admin.Model.ProductCategory;
import be.Admin.Model.QtyModel;
//import be.Admin.Model.ProductCategory;
import be.Admin.Model.Result;
import be.Admin.Model.ReturnMessage;
import be.Admin.Model.VolModel;
import be.Admin.Service.GeneralService;
//import be.Admin.Repository.ProductRepo;
import be.Admin.Service.ProductService;
//import be.dashmon.domain.HeadTrans;
//import ch.qos.logback.core.net.SyslogOutputStream;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
public class ProductController {

	// private static final int BUTTONS_TO_SHOW = 5;
	// private static final int INITIAL_PAGE = 1;
	private static final int INITIAL_PAGE_SIZE = 10;

	private static String UPLOADED_FOLDER = "E://temp//";
//	private final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	@Autowired
	GeneralService generalService;
	
	@Autowired
	GeneralHandler generalHandler;

	@Autowired
	MainHandler handler;
	
	@RequestMapping(value = "/gen-product/{pageNumber}", method = RequestMethod.GET)
	public ModelAndView GeneralProd(@PathVariable Integer pageNumber) throws Exception {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("activePage", "Product/index");
		modelAndView.addObject("Title", "General Product");
		modelAndView.addObject("subTitle", "list all product");
		modelAndView.addObject("Pageuse", "gen-product");
		
	
			Page<Product> page = productService.getProductLog(pageNumber, INITIAL_PAGE_SIZE);
			
//		Result result = new Result();
			int current = page.getNumber() + 1;
			int begin = Math.max(1, current - 5);
			int end = Math.min(begin + 10, page.getTotalPages());
			// handler.getMainData(result);
//			 for (Product prod : page) {
//			 System.out.println(prod.getDeschead()+"------------"+prod.getItmprice()+"------------"+prod.getItemicon());
//			 System.err.println(prod.getProductCategory().getDesc());
//			 }
			 
//			 page.getTotalPages()
//			System.err.println(current);
			modelAndView.addObject("Page", page);
			modelAndView.addObject("CurrentIndex", current);
			modelAndView.addObject("beginIndex", begin);
			modelAndView.addObject("endIndex", end);
			// modelAndView.addObject("newPack", result.getRsltArray());
		
		return modelAndView;
	}

	@RequestMapping(value = { "/get-template" }, method = RequestMethod.GET)
	public ModelAndView gettemp(Product product) throws Exception {
		ModelAndView modelAndView = new ModelAndView("Product/crud");
		// modelAndView.addObject("Page", page);
		List<PcsModel> lcpcs = generalService.getAllPcs();
		List<VolModel> lcvol = generalService.getAllvol();
		List<KategoryModel> lckat = generalService.getAllkat();
		List<QtyModel> lcqty = generalService.getAllqty();
		modelAndView.addObject("Pcs", lcpcs);
		modelAndView.addObject("Vol", lcvol);
		modelAndView.addObject("Kat", lckat);
		modelAndView.addObject("Qty", lcqty);
		return modelAndView;
	}

	@RequestMapping(value = { "/add-product" }, method = RequestMethod.POST)
	public ResponseEntity<?> AddProduct(@Valid @ModelAttribute Product model, BindingResult bindingResult) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		ReturnMessage respon = new ReturnMessage();
		if (bindingResult.hasErrors()) {
			generalHandler.SetResponse(respon,"RE-0400");
			return new ResponseEntity<>(mapper.writeValueAsString(respon),HttpStatus.BAD_REQUEST);
		}
		try {
			saveUploadedFiles(model.getFiles(), model);
			generalHandler.SetResponse(respon,"RS-0000");
		} catch (IOException e) {
			generalHandler.SetResponse(respon,"RE-0400");
			return new ResponseEntity<>(mapper.writeValueAsString(respon),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(mapper.writeValueAsString(respon), HttpStatus.OK);
	}

	// @RequestMapping(value = "/update", method = RequestMethod.POST)
	// public String updateContact(Contact contact) {
	// System.out.println("Contact ID: " + contact.getId());
	// this.contactService.saveContact(contact);
	// return "redirect:/contacts/view/" + contact.getId();
	// }
	//

	@RequestMapping(value = { "/update-product" }, method = RequestMethod.POST)
	public String EditProd(Product product) throws Exception {

		System.out.println("product ID: " + product.getId());
		productService.saveProduct(product);
		// ModelAndView modelAndView = new ModelAndView("index");
		// modelAndView.addObject("activePage", "dashboard/dashboardmain");
		// Result result = new Result();
		// return modelAndView;
		return "";
	}

	// @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	// public String deleteContact(@PathVariable Integer id) {
	// this.contactService.deleteContact(id);
	// return "redirect:/contacts";
	// }

	@RequestMapping(value = { "/del-product/{id}" }, method = RequestMethod.GET)
	public String DeleteProd() throws Exception {
		// ModelAndView modelAndView = new ModelAndView("index");
		// modelAndView.addObject("activePage", "dashboard/dashboardmain");
		// Result result = new Result();
		// return modelAndView;
		return "";
	}

	@RequestMapping(value = { "/find-product" }, method = RequestMethod.POST)
	public String FindProd() throws Exception {
		// ModelAndView modelAndView = new ModelAndView("index");
		// modelAndView.addObject("activePage", "dashboard/dashboardmain");
//		Result result = new Result();
		// return modelAndView;
		return "";
	}
	
	
	private void saveUploadedFiles(MultipartFile files, Product model) throws IOException {
		// for (MultipartFile file : files) {

		// if (files.isEmpty()) {
		// continue; //next pls
		// }
		byte[] bytes = files.getBytes();
		Path path = Paths.get(UPLOADED_FOLDER + files.getOriginalFilename());
		model.setItemicon(files.getOriginalFilename());
		Files.write(path, bytes);
		productService.saveProduct(model);

		// }

	}

}
