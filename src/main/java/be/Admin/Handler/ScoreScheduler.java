//package be.Admin.Handler;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import be.Admin.Service.LiveScoreService;
//
//
//@Configuration
////@EnableScheduling
//public class ScoreScheduler {
//        
//    @Autowired
//    private SimpMessagingTemplate template;
//    
//    @Autowired
//    LiveScoreService service;
//
////    @Scheduled(fixedRate = 5000)
//    public void publishUpdates(){
//    	
////
//		ObjectMapper mapper = new ObjectMapper();
//    	try {
//			System.err.println("test score is :"+mapper.writeValueAsString(service.getScore()));
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//    	
//        template.convertAndSend("/topic/myscores", service.getScore());
//       
//    }
// 
//}