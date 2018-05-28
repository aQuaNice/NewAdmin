//package be.Admin.Controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
//
//import be.Admin.Model.Batsman;
//import be.Admin.Service.LiveScoreService;
//
//
//@Controller
//public class WebSocket {
//    
//    @Autowired
//    private LiveScoreService service;
//    
//    @MessageMapping("/score")
//    @SendTo("/topic/myscores")
//    public List<Batsman> getScores() {
//        
//        List<Batsman> scoresList = service.getScore();
//        
//        return scoresList;
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////
////
////import java.io.IOException;
////
////import javax.annotation.PostConstruct;
////import javax.websocket.OnClose;
////import javax.websocket.OnMessage;
////import javax.websocket.OnOpen;
////import javax.websocket.Session;
////import javax.websocket.server.ServerEndpoint;
////
////import org.springframework.stereotype.Component;
////import org.springframework.web.context.support.SpringBeanAutowiringSupport;
////
////
////@ServerEndpoint("/websocket")
////public class WebSocket {
////
////	@PostConstruct
////	public void init(){
////	    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
////	}
////	
////	@OnMessage
////	  public void onMessage(String message, Session session) 
////	    throws IOException, InterruptedException {
////	  
////	    // Print the client message for testing purposes
////	    System.out.println("Received: " + message);
////	  
////	    // Send the first message to the client
////	    session.getBasicRemote().sendText("This is the first server message");
////	  
////	    // Send 3 messages to the client every 5 seconds
////	    int sentMessages = 0;
////	    while(sentMessages < 3){
////	      Thread.sleep(5000);
////	      session.getBasicRemote().
////	        sendText("This is an intermediate server message. Count: " 
////	          + sentMessages);
////	      sentMessages++;
////	    }
////	  
////	    // Send a final message to the client
////	    session.getBasicRemote().sendText("This is the last server message");
////	  }
////	  
////	  @OnOpen
////	  public void onOpen() {
////	    System.out.println("Client connected");
////	  }
////
////	  @OnClose
////	  public void onClose() {
////	    System.out.println("Connection closed");
////	  }
////	
////}
