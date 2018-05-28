package be.Admin.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//@Service
//import org.springframework.stereotype.Service;

import be.Admin.Model.Result;
public  interface MainService {
	
	void getDataNewMember(Result result) throws Exception;
	void getDataNewOrder(Result result);
	void getDataPacking(Result result);
	void getDataPendingDelivery(Result result);

	
}
