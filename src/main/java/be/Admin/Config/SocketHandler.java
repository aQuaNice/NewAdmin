//package be.Admin.Config;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import com.google.gson.Gson;
//
//@Component
//public class SocketHandler extends TextWebSocketHandler {
//	
//	 @Override
//	    public void handleTextMessage(WebSocketSession session, TextMessage message) {
//		 
//		 
////	        try {
////				Thread.sleep(3000);
////			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
////				e.printStackTrace();
////			} // simulated delay
//		 
//		 System.out.println("mySession : "+ session);
//	        TextMessage msg = new TextMessage("Hello, " + message.getPayload() + "!");
//	        try {
//				session.sendMessage(msg);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	    }
//	
////	List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
////
////	@Override
////	public void handleTextMessage(WebSocketSession session, TextMessage message)
////			throws InterruptedException, IOException {
////		for(WebSocketSession webSocketSession : sessions) {
////			Map<String, String> value = new Gson().fromJson(message.getPayload(), Map.class);
////			webSocketSession.sendMessage(new TextMessage("Hello " + value.get("name") + " !"));
////		}
////	}
////	
////	@Override
////	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
////		//the messages will be broadcasted to all users.
////		sessions.add(session);
////	}
//
//}