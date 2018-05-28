package be.Admin.Handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import be.Admin.Model.ProccessOrder;
import be.Admin.Model.ReturnMessage;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Component
public class GeneralHandler {

	Properties prop = new Properties();
	String propFileName = "General.properties";
	InputStream inputStream;
	
	@Autowired
	PdfGenaratorUtil pdfGenaratorUtil;
	
	public void SetResponse(ReturnMessage respon, String lcProp) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		prop.load(inputStream);		
//		Enumeration keys = prop.keys();
//			while (keys.hasMoreElements()) {
//			    String key = (String)keys.nextElement();
//			    String value = (String)prop.get(key);			    
//			    if(key.equals(lcProp)){
//			    	respon.setRsltcode(key);
//			    	respon.setRsltmsg(value);
//			    	//System.out.println(key + ": " + value);
//			    	continue ;
//			    }
//			}			
		respon.setRsltcode(lcProp);
		respon.setRsltmsg(prop.getProperty(lcProp));;
//		respon.setRsltmsg(lcstatcd);		
//		mylog.setLogReg(LogNm, lcmethod,reqCode, lcParam, lcCode, mapper.writeValueAsString(respon), respon.getRsltcode(),respon.getRsltmsg(),1);
	}
	
	
//	sendAndroidNotification(to,body,title,id);
	
	
	
	public void sendAndroidNotification(ProccessOrder model) throws IOException {
//		String deviceToken,String message,String title,String cloudId;
		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		prop.load(inputStream);		
		String NotUrl = prop.getProperty("NotUrl");
		String Notkey =  prop.getProperty("Notkey");
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject obj = new JSONObject();
        JSONObject msgObject = new JSONObject();
        JSONObject msgdata = new JSONObject();
        
        int statGcm = 0;
        String statMustbe = "01";
        if(model.getStat() < 3){
        	statMustbe ="01";
        }else{
        	statMustbe ="02";
        }
//        "title": {"locKey": "push_app_title"}
        
        
        
        JSONObject LcAdditionObj = new JSONObject();
        JSONArray LcAdditionArray = new JSONArray();
        
        
        msgObject.put("force-start","1");
        msgObject.put("orderId",model.getId());
        msgObject.put("summaryText","There are %n% notifications");
        msgObject.put("priority","hight");
        msgObject.put("style","inbox");
        msgObject.put("locKey","push_app_title");
        msgObject.put("id",statMustbe);
        msgObject.put("notId",model.getId());
//        LcAdditionArray.add(LcAdditionObj);
      
        msgObject.put("sound", "default");
        msgObject.put("message", model.getOrdstat());
//        msgObject.put("additionalData", LcAdditionObj);
        
        
//        msgObject.put("title", msgObject.put("locKey", "push_app_title"));
//        msgObject.put("message",model.getOrdstat());
//        msgObject.put("sound", "default");
//        msgObject.put("priority", "hight");
//        msgObject.put("style", "inbox");
//        msgObject.put("summaryText", "There are %n% notifications");
//        msgObject.put("force-start", 1);
//        msgObject.put("notId", model.getId());
//        msgObject.put("id", statMustbe);
//        msgObject.put("orderId", model.getId());       
       
        
        obj.put("to", model.getGcmcode());
        obj.put("data",msgObject);
        System.err.println(obj);

        RequestBody body = RequestBody.create(mediaType, obj.toString());
        Request request = new Request.Builder().url(NotUrl).post(body)
                .addHeader("content-type", "application/json")
                .addHeader("authorization", "key="+Notkey).build();
        Response response = client.newCall(request).execute();
        System.out.println("Notification response >>>" +response.body().string());
    }


	public void getPrintThis(ProccessOrder model) throws IOException {
		Map<String,String> data = new HashMap<String,String>();
	    data.put("name","James");
//	    try {
//	    	createPdf("greeting",data);
	    	
		try {
			pdfGenaratorUtil.createPdf("greeting",data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
