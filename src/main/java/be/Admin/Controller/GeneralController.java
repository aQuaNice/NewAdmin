package be.Admin.Controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import be.Admin.Handler.GeneralHandler;
import be.Admin.Model.ListPo;
import be.Admin.Model.PcsModel;
import be.Admin.Model.Product;
import be.Admin.Model.ReturnMessage;
import be.Admin.Service.GeneralService;

@RestController
public class GeneralController {
	@Autowired
	GeneralHandler generalHandler;
	
	@Autowired
	GeneralService generalService;
	
//	@RequestMapping(value = { "/gen-po" }, method = RequestMethod.GET)
//	public ResponseEntity<?> GetPo(@Valid @ModelAttribute ListPo model, BindingResult bindingResult) throws IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		ReturnMessage respon = new ReturnMessage();
//		if (bindingResult.hasErrors()) {
//			generalHandler.SetResponse(respon,"RE-0400");
//			return new ResponseEntity<>(mapper.writeValueAsString(respon),HttpStatus.BAD_REQUEST);
//		}
//		
//		//sendAndroidNotification(to,body,title,id);
//		try {
//			List<ListPo> lcpo = generalService.getAllPoProduct(model.getTglord(), model.getTglexp());
//			//saveUploadedFiles(model.getFiles(), model);
//			generalHandler.SetResponse(respon,"RS-0000");
//		} catch (IOException e) {
//			generalHandler.SetResponse(respon,"RE-0400");
//			return new ResponseEntity<>(mapper.writeValueAsString(respon),HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity(mapper.writeValueAsString(respon), HttpStatus.OK);
//	}
	
	
}
