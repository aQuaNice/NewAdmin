package be.Admin.Service;

import org.springframework.data.domain.Page;

import be.Admin.Model.OrderDetail;
import be.Admin.Model.OrderHead;
public interface OrderDetService {

//	public Page<OrderHead> getOrderLog(int pageNumber, int pagesize);
	OrderHead getOrderDetailById(Long id);
//	Product saveProduct(Product product);
//	void deleteProduct(Long id);
	
}
