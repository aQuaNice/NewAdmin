package be.Admin.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import be.Admin.Model.OrderDetail;
import be.Admin.Model.OrderHead;
public interface OrderDetRepo extends JpaRepository<OrderHead, Long> {

//	OrderHead findOne(int id); 
	}