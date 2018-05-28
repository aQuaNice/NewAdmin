package be.Admin.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.data.solr.core.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import be.Admin.Handler.GeneralHandler;
import be.Admin.Model.EventItem;
import be.Admin.Model.EventSell;
import be.Admin.Model.KategoryModel;
import be.Admin.Model.ListeventEdit;
import be.Admin.Model.OrderHead;
import be.Admin.Model.PcsModel;
import be.Admin.Model.Product;
import be.Admin.Model.QtyModel;
import be.Admin.Model.ReturnMessage;
import be.Admin.Model.VolModel;
import be.Admin.Service.EventService;
import be.Admin.Service.GeneralService;
import be.Admin.Service.ProductService;

@RestController
public class EventController {
	
	@Autowired
	EventService eventService;
	@Autowired
	GeneralHandler generalHandler;
	@Autowired
	GeneralService generalService;
	@Autowired
	ProductService productService;
	
	private static final int INITIAL_PAGE_SIZE = 10;
//	private eventItem lcItem;
	@RequestMapping(value="/eve-pack/{pageNumber}", method = RequestMethod.GET)
	public ModelAndView EventGen(@PathVariable Integer pageNumber){
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("activePage", "Event/index");
		modelAndView.addObject("Title", "Event Selling");
		modelAndView.addObject("subTitle", "list all Event Sell");		
		Page<EventSell> page = eventService.getEventPack(pageNumber, INITIAL_PAGE_SIZE);
		int current = page.getNumber() + 1;
		int begin = Math.max(0, current - 5);
		int end = Math.min(begin + 10, page.getTotalPages());	
		modelAndView.addObject("Page", page);
		modelAndView.addObject("CurrentIndex", current);
		modelAndView.addObject("beginIndex", begin);
		modelAndView.addObject("endIndex", end);		
		return modelAndView;		
	}
	
	
	@RequestMapping(value = { "/get-tem-event" }, method = RequestMethod.GET)
	public ModelAndView gettemp(EventSell eventSell) throws Exception {
		ModelAndView modelAndView = new ModelAndView("Event/crud");
		List<Product> lcprod = generalService.getAllprod();
		modelAndView.addObject("products", lcprod);
		
	
		return modelAndView;
	}
	
	@RequestMapping(value = "/view-event")
    public ModelAndView viewEvent(EventSell eventSell ,@RequestParam("dataId") Long dataid) {
		ModelAndView modelAndView = new ModelAndView("Event/crud");
		 eventSell = eventService.getEventDetailById(dataid);
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
		 String dtst = simpleDateFormat.format(eventSell.getEvestart());
		 String dted = simpleDateFormat.format(eventSell.getEveend());
		 eventSell.setDatestart(dtst);
		 eventSell.setDateend(dted);
		 
		 
//		 List<Product> lcprod = generalService.getAllprod();
		 List<ListeventEdit> lcmain = generalService.getAllEventProduct(dataid);
//		 List<EventItem> lcused = generalService.getAll();
//		 List<EventItem> lcevent = generalService.getAllEvent(dataid);
		 modelAndView.addObject("products", lcmain);
//		 modelAndView.addObject("itemevent", lcevent);
			
//		 for(EventItem listitem : lcevent){
//			 System.out.println(listitem.getIditem());
//////			 listPrice.setEveprice((float) (listPrice.getEveprice() - (listPrice.getEveprice()*lcSeteve)));
//		 }
		 
		 System.out.println(eventSell.getStat());
		 
		 
			modelAndView.addObject("eventSell", eventSell);
			

		return modelAndView;
    }
	
	
	@RequestMapping(value = { "/add-event" }, method = RequestMethod.POST)
//	public ResponseEntity<?> AddEvent(@Valid @ModelAttribute EventSell model, BindingResult bindingResult,@RequestParam("eventItem") String lcitem) throws IOException {
//	this.lcItem = lcItem;
	public ResponseEntity<?> AddEvent(@Valid @RequestBody EventSell model, BindingResult bindingResult) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		ReturnMessage respon = new ReturnMessage();
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		 double lcSeteve = (model.getEveset() / 100);
		 for(EventItem listPrice : model.getEventItem()){
			 listPrice.setEveprice((float) (listPrice.getEveprice() - (listPrice.getEveprice()*lcSeteve)));
		 }
		 
		 System.out.println(model.getId());
		 
		 
		 
		 try {
			 Date dtst = simpleDateFormat.parse( model.getDatestart());
			 Date dted = simpleDateFormat.parse(model.getDateend());
			 model.setEvestart(dtst);
			 model.setEveend(dted);
		} catch (ParseException e1){
			e1.printStackTrace();
		}
//		 System.out.println(mapper.writeValueAsString(model));

		if (bindingResult.hasErrors()) {
			generalHandler.SetResponse(respon,"RE-0400");
			return new ResponseEntity<>(mapper.writeValueAsString(respon),HttpStatus.BAD_REQUEST);
		}
		try {
			
			System.out.println("data from client : "+mapper.writeValueAsString(model));
			eventService.saveEvent(model);
//			if(model.getStat() == 1){
				productService.updaTeProduct(model.getEventItem(),model.getStat());
//			}			
			generalHandler.SetResponse(respon,"RS-0000");
		}catch (IOException e) {
			generalHandler.SetResponse(respon,"RE-0400");
			return new ResponseEntity<>(mapper.writeValueAsString(respon),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(mapper.writeValueAsString(respon), HttpStatus.OK);
	}
	
	
}
