package be.Admin.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.Admin.Model.EventSell;
import be.Admin.Model.Product;
import be.Admin.Repository.EventRepo;
import be.Admin.Service.EventService;

@Service
@Transactional
public class EventServiceImpement implements EventService{

	@Autowired
	EventRepo eventRepo;
	
	
	
	@Override
	public Page<EventSell> getEventPack(int pageNumber,int size) {
		   PageRequest request =  new PageRequest(pageNumber - 1, size, Sort.Direction.ASC, "id");
	        return eventRepo.findAll(request);
	}



	@Override
	public EventSell saveEvent(EventSell eventSell) {
		return eventRepo.save(eventSell);
	}



	@Override
	public EventSell getEventDetailById(Long dataid) {
		return eventRepo.findOne(dataid);
	}


}
