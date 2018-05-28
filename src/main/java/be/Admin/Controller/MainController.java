package be.Admin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
//import javax.validation.Valid;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.WebSocketSession;
//import be.Admin.Config.SocketHandler;
import be.Admin.Handler.MainHandler;
import be.Admin.Model.Result;
import be.Admin.Service.LiveScoreService;

import org.springframework.web.socket.TextMessage;


import org.springframework.web.socket.WebSocketHandler;
//import be.dashmon.domain.Register;

import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@RestController
public class MainController {
	
	@Autowired
	MainHandler handler;
	
//	   @Autowired
//	    private SimpMessagingTemplate template;	 
//	   @Autowired
//	    LiveScoreService service;
	
	@RequestMapping(value = { "", "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView AppMain() throws Exception{
//        template.convertAndSend("/topic/myscores", service.getScore());
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("activePage", "dashboard/dashboardmain");
		Result result = new Result();
		handler.getMainData(result);		
		
//		WebSocketSession session = null ;
//		TextMessage message = new TextMessage("data");		
//		skthand.handleTextMessage(session, message);
//		System.out.println(result.getResultmsg());
		modelAndView.addObject("newPack", result.getRsltArray());
		return modelAndView;
	}

	@RequestMapping(value = {"/product" }, method = RequestMethod.GET)
	public ModelAndView Product() throws Exception{
//        template.convertAndSend("/topic/myscores", service.getScore());
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("activePage", "dashboard/dashboardmain");
		Result result = new Result();
		handler.getMainData(result);		
		
//		WebSocketSession session = null ;
//		TextMessage message = new TextMessage("data");		
//		skthand.handleTextMessage(session, message);
//		System.out.println(result.getResultmsg());
		modelAndView.addObject("newPack", result.getRsltArray());
		return modelAndView;
	}
	
	@RequestMapping(value = {"/Order" }, method = RequestMethod.GET)
	public ModelAndView Order() throws Exception{
//        template.convertAndSend("/topic/myscores", service.getScore());
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("activePage", "dashboard/dashboardmain");
		Result result = new Result();
		handler.getMainData(result);		
		
//		WebSocketSession session = null ;
//		TextMessage message = new TextMessage("data");		
//		skthand.handleTextMessage(session, message);
//		System.out.println(result.getResultmsg());
		modelAndView.addObject("newPack", result.getRsltArray());
		return modelAndView;
	}
	
	
}
