package be.Admin.Service;

import org.springframework.data.domain.Page;

import be.Admin.Model.OrderDetail;
import be.Admin.Model.OrderHead;
import be.Admin.Model.ReturnMessage;
public interface OrderService {

	public Page<OrderHead> getOrderLog(int pageNumber, int pagesize);
	public Page<OrderHead> getOrderPack(int pageNumber, int pagesize,int sTat);
//	public void updateOrder(Long id);
//	OrderDetail getOrderDetailById(Long id);
//	Product saveProduct(Product product);
//	void deleteProduct(Long id);
//	public void updateOrder(Long id, ReturnMessage respon);
	void updateOrder(Long id, int lcstat, int lcgroup, ReturnMessage respon);
	
}
