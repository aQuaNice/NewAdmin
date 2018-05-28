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
import be.Admin.Handler.MainHandler;
import be.Admin.Handler.PdfGenaratorUtil;
import be.Admin.Model.KategoryModel;
import be.Admin.Model.OrderDetail;
import be.Admin.Model.OrderHead;
//import be.Admin.Model.OrderHead;
import be.Admin.Model.PcsModel;
import be.Admin.Model.ProccessOrder;
import be.Admin.Model.Product;
import be.Admin.Model.QtyModel;
//import be.Admin.Model.Result;
import be.Admin.Model.ReturnMessage;
import be.Admin.Model.VolModel;
import be.Admin.Service.GeneralService;
import be.Admin.Service.OrderDetService;
import be.Admin.Service.OrderService;
//import be.Admin.Service.OrderService;
//import be.Admin.Service.ProductService;
@RestController
public class OrderController {

	// private static final int BUTTONS_TO_SHOW = 5;
	// private static final int INITIAL_PAGE = 1;
	private static final int INITIAL_PAGE_SIZE = 10;
//	private final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
 

	@Autowired
	OrderService orderService;

	@Autowired
	OrderDetService orderdetservice;
	
	@Autowired
	GeneralService generalService;
	
	@Autowired
	GeneralHandler generalHandler;

	@Autowired
	MainHandler handler;
	
	@Autowired
	PdfGenaratorUtil pdfGenaratorUtil;
	
//	@RequestMapping(value = "/gen-order/{pageNumber}", method = RequestMethod.GET)
//	public ModelAndView GeneralOrder(@PathVariable Integer pageNumber) throws Exception {
//		ModelAndView modelAndView = new ModelAndView("index");
//		modelAndView.addObject("activePage", "Order/index");
//		modelAndView.addObject("Title", "General Order");
//		modelAndView.addObject("subTitle", "list all Order");
//		modelAndView.addObject("Pageuse", "gen-order");
//		
//		
//		Page<OrderHead> page = orderService.getOrderLog(pageNumber, INITIAL_PAGE_SIZE);
//		
//		
//		int current = page.getNumber() + 1;
//		int begin = Math.max(0, current - 5);
//		int end = Math.min(begin + 10, page.getTotalPages());
////		 for (OrderHead prod : page) {
////		 System.out.println(prod.getDeschead()+"------------"+prod.getItmprice()+"------------"+prod.getItemicon());
////		 System.err.println(prod.getInvoorder());
////		 System.err.println(prod.getMember().getUserid());
////		 }
//		modelAndView.addObject("Page", page);
//		modelAndView.addObject("beginIndex", begin);
//		modelAndView.addObject("endIndex", end);
//		// modelAndView.addObject("newPack", result.getRsltArray());
//		return modelAndView;
//	}
	
	
	@RequestMapping(value = "/gen-pack/{pageNumber}/{sTat}", method = RequestMethod.GET)
	public ModelAndView ByPackOrder(@PathVariable Integer sTat,@PathVariable Integer pageNumber) throws Exception {
		System.out.println(sTat +"---"+ pageNumber);
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("activePage", "Order/index");
		modelAndView.addObject("Title", "Packing Order");
		modelAndView.addObject("subTitle", "list all Packing Order");
		Page<OrderHead> page = orderService.getOrderPack(pageNumber, INITIAL_PAGE_SIZE,sTat);
		int current = page.getNumber() + 1;
		int begin = Math.max(0, current - 5);
		int end = Math.min(begin + 10, page.getTotalPages());		
//		String ActionTodo="";
//		 for (OrderHead prod : page) {
//////		 System.out.println(prod.getDeschead()+"------------"+prod.getItmprice()+"------------"+prod.getItemicon());
////		 System.err.println(prod.getInvoorder());
////		 System.err.println(prod.getMember().getUserid());
//			if(prod.getStat() == 0){
//				ActionTodo = "Packing";
//			}else if(prod.getStat() == 1){
//				ActionTodo = "Sending";
//			}else if(prod.getStat() == 2){
//				ActionTodo = "Sending";
//			};
//		 }
//		 System.err.println(current);
		modelAndView.addObject("Page", page);
		modelAndView.addObject("CurrentIndex", current);
		modelAndView.addObject("beginIndex", begin);
		modelAndView.addObject("endIndex", end);
//		modelAndView.addObject("endIndex", end);
//		modelAndView.addObject("endIndex", end);
		// modelAndView.addObject("newPack", result.getRsltArray());
		return modelAndView;
	}
	
//	@RequestMapping(value = { "/get-ordtpl" }, method = RequestMethod.GET)
//	public ModelAndView GettempOrd(Product product) throws Exception {
//		ModelAndView modelAndView = new ModelAndView("Order/crud");
//		// modelAndView.addObject("Page", page);
//		List<PcsModel> lcpcs = generalService.getAllPcs();
//		List<VolModel> lcvol = generalService.getAllvol();
//		List<KategoryModel> lckat = generalService.getAllkat();
//		List<QtyModel> lcqty = generalService.getAllqty();
//		modelAndView.addObject("Pcs", lcpcs);
//		modelAndView.addObject("Vol", lcvol);
//		modelAndView.addObject("Kat", lckat);
//		modelAndView.addObject("Qty", lcqty);
//		return modelAndView;
//	}
	
	@RequestMapping(value = "/view-order/{id}")
    public ModelAndView viewOrder(OrderHead lcDetail,@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("Order/crud");
		lcDetail = orderdetservice.getOrderDetailById(id);	
		String ActionTodo="";

//			lcDetail.getStat()		
//		 for (OrderHead prod : page) {
////		 System.out.println(prod.getDeschead()+"------------"+prod.getItmprice()+"------------"+prod.getItemicon());
//		 System.err.println(prod.getInvoorder());
//		 System.err.println(prod.getMember().getUserid());
//		lcDetail.getMember().getId()
		
		
			if(lcDetail.getStat() == 0){
				ActionTodo = "Packing";
			}else if(lcDetail.getStat() == 1){
				ActionTodo = "Sending";
			}else if(lcDetail.getStat() == 2){
				ActionTodo = "Confirm Receive";
			}else if(lcDetail.getStat() == 3){
				ActionTodo = "Confirm Payment";
			}
			
			modelAndView.addObject("OrdDet", lcDetail);
			modelAndView.addObject("OrdStat", ActionTodo);
		return modelAndView;
    }

	
	@RequestMapping(value = { "/proccess-order" }, method = RequestMethod.POST)
	public ResponseEntity<?> ProcOrder(@Valid @ModelAttribute ProccessOrder model, BindingResult bindingResult) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		ReturnMessage respon = new ReturnMessage();

		
		System.err.println(mapper.writeValueAsString(model));
				
		int lcUp = 0 ;
		int lcGroup =1; 
		String lcMsg ="";	
		if (bindingResult.hasErrors()) {
			generalHandler.SetResponse(respon,"RE-0400");
			return new ResponseEntity<>(mapper.writeValueAsString(respon),HttpStatus.BAD_REQUEST);
		}				
		if(model.getStat() < 1){
			lcUp = 1;
			lcGroup = 2;
			lcMsg = "Pesanan anda sedang dalam pengepakan";
			/*lcGroup = 1;*/
		}else{
			if(model.getStat() == 1){
				lcUp = 2;
				lcGroup = 2;
				lcMsg = "Pesanan anda sedang dalam Pengiriman";
			}else if(model.getStat() == 2){
				lcUp = 3;
				lcGroup = 3;
				lcMsg = "Komformasi penerimaan pesanan";
			}else if(model.getStat() == 3){
				lcUp = 4;
				lcGroup = 3;
				lcMsg = "Konfirmasi pembayaran berhasil";
			}
//			else if(model.getStat() == 4){
//				lcUp = 5;
//				lcGroup = 3;
//			}
		};
		model.setOrdstat(lcMsg);
		model.setStat(lcGroup);
//		System.err.println(mapper.writeValueAsString(model));
		
	
//		
		try {
			orderService.updateOrder(model.getId(),lcUp, lcGroup, respon);
			generalHandler.SetResponse(respon,"RS-0000");
		} catch (IOException e) {
			generalHandler.SetResponse(respon,"RE-0400");
			return new ResponseEntity<>(mapper.writeValueAsString(respon),HttpStatus.BAD_REQUEST);
		}
		
//		model.getMember().getGcmcode();
		generalHandler.sendAndroidNotification(model);
		
		return new ResponseEntity(mapper.writeValueAsString(respon), HttpStatus.OK);
		
	}
	
	
	
	
//	@RequestMapping(value = { "/proccess-order" }, method = RequestMethod.POST)
//	public ResponseEntity<?> AddProduct(@Valid @ModelAttribute Product model, BindingResult bindingResult) throws IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		ReturnMessage respon = new ReturnMessage();
//		if (bindingResult.hasErrors()) {
//			generalHandler.SetResponse(respon,"RE-0400");
//			return new ResponseEntity<>(mapper.writeValueAsString(respon),HttpStatus.BAD_REQUEST);
//		}
//	sendAndroidNotification(to,body,title,id);
////		try {
////			saveUploadedFiles(model.getFiles(), model);
////			generalHandler.SetResponse(respon,"RS-0000");
////		} catch (IOException e) {
////			generalHandler.SetResponse(respon,"RE-0400");
////			return new ResponseEntity<>(mapper.writeValueAsString(respon),HttpStatus.BAD_REQUEST);
////		}
//		return new ResponseEntity(mapper.writeValueAsString(respon), HttpStatus.OK);
//	}
	
}
