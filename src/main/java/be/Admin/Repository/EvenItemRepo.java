package be.Admin.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.Admin.Model.EventItem;
//import be.Admin.Model.EventSell;

public interface EvenItemRepo  extends JpaRepository<EventItem, Long> {
	
//	public List<EventItem> findAllByOrderByIdAsc();

	public List<EventItem> findByIdevent(Long dataid);
}


