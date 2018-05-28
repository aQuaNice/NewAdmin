package be.Admin.Util;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Component
public class AdminUtil {
	
//	private static String ANDROID_NOTIFICATION_URL = "https://fcm.googleapis.com/fcm/send";
//	private static String ANDROID_NOTIFICATION_KEY = "AIzaSyC4BLgqAj4e2XwCE0Bsaq1wva4iLABlYnM";
	
//	private static void sendAndroidNotification(String deviceToken,String message,String title) throws IOException {
//        OkHttpClient client = new OkHttpClient();
//        MediaType mediaType = MediaType.parse("application/json");
//        JSONObject obj = new JSONObject();
//        JSONObject msgObject = new JSONObject();
//        
//        JSONObject msgdata = new JSONObject();
//        
//        
//        msgObject.put("title", "My Title");
//        msgObject.put("message", "My second message 4");
////        msgObject.put("sound", "default");
////        msgObject.put("priority", "hight");
//        msgObject.put("style", "inbox");
//        msgObject.put("summaryText", "There are %n% notifications");
//        msgObject.put("notId", 2);
//        
////        msgObject.put("icon", "https://pbs.twimg.com/profile_images/837060031895896065/VHIQ4oUf_400x400.jpg");
////        msgObject.put("color", "red");
////        msgObject.put("image",  "https://pbs.twimg.com/profile_images/837060031895896065/VHIQ4oUf_400x400.jpg");
////        msgObject.put("image-type", "circular");
////        message.addData('image-type', 'circular');
//       
//        obj.put("to", deviceToken);
//        obj.put("data",msgObject);
//        
//        System.out.println(obj);
//
//        RequestBody body = RequestBody.create(mediaType, obj.toString());
//        Request request = new Request.Builder().url(ANDROID_NOTIFICATION_URL).post(body)
//                .addHeader("content-type", "application/json")
//                .addHeader("authorization", "key="+ANDROID_NOTIFICATION_KEY).build();
//
//        Response response = client.newCall(request).execute();
//        System.out.println("Notification response >>>" +response.body().string());
//    }

}
