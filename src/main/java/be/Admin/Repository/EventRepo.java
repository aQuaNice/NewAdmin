package be.Admin.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.Admin.Model.EventSell;

public interface EventRepo  extends JpaRepository<EventSell, Long> {
	
//	public List<VolModel> findAllByOrderByIdAsc();
}
