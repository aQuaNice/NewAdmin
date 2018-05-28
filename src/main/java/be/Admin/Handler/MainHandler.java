package be.Admin.Handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.Admin.Model.Result;
import be.Admin.Service.MainService;
//import be.dashmon.service.CheckService;

@Component
public class MainHandler {
	
////	@Autowired
	private MainService mainserv;
	@Autowired
	public MainHandler(MainService mainserv) {
		this.mainserv = mainserv;
	}	
	
	public void getMainData(Result result) throws Exception{
//		mainserv.getDataNewOrder(result);
		mainserv.getDataNewMember(result);
//		mainserv.getDataNewOrder(result);
	}

}
