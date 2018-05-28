package be.Admin.Repository;
//import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import be.Admin.Model.OrderHead;
public interface OrderRepo extends JpaRepository<OrderHead, Long> {

	Page<OrderHead> findByStat(int sTat, Pageable pageable);
	
//	Page<PSubject> findByType(String type, Pageable pageable);

//	Page<OrderHead> findByStat(int sTat,Pageable pageable); 
	
	
	}