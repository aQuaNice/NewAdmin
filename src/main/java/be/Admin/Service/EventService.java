package be.Admin.Service;

import org.springframework.data.domain.Page;

import be.Admin.Model.EventSell;

public interface EventService {

	Page<EventSell> getEventPack(int pageNumber, int pagesize);
	EventSell saveEvent(EventSell eventSell);
	EventSell getEventDetailById(Long dataid);
}
