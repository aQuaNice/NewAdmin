package be.Admin.Implement;

//import java.awt.print.Pageable;
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.Admin.Model.OrderDetail;
import be.Admin.Model.OrderHead;
import be.Admin.Model.ReturnMessage;
import be.Admin.Repository.OrderRepo;
import be.Admin.Service.OrderService;
//import be.dashmon.domain.GetparamDetail;
//import be.dashmon.domain.ResponServ;
@Service
@Transactional
public class OrderImpl implements OrderService{
	@Autowired
	JdbcTemplate jTemplate;
    @Autowired
    OrderRepo orderRepo;
    public Page<OrderHead> getOrderLog(int pageNumber,int size) {
        PageRequest request =  new PageRequest(pageNumber - 1, size, Sort.Direction.ASC, "id");
        
        return orderRepo.findAll(request);
    }
//    
    public Page<OrderHead> getOrderPack(int pageNumber,int size, int sTat) {
		Pageable pageable = (Pageable) new PageRequest(pageNumber - 1, size, Sort.Direction.ASC, "id");        
        return orderRepo.findByStat(sTat,pageable);
    }
    
    
    
    
	@Override
	public void updateOrder(Long id,int lcstat,int lcgroup, ReturnMessage respon) {
		
		// @Override
//		public void orderCancel(GetparamDetail lcdata, ResponServ respon) {
			int SuccessStat =0;
			String sql ="UPDATE tbm_h_order SET stat = ?,grouped = ? WHERE  id = ?";
			Object[] args = new Object[]{lcstat,lcgroup,id};
		
					try{
						SuccessStat = jTemplate.update(sql, args);
					}catch(Exception e){
					}
//		}
		
	}
    
    
//	@Override
//	public Product getProductById(Long id){
//		return productRepo.findOne(id);
//	}
//	@Override
//	public Product saveProduct(Product product) {
//		// TODO Auto-generated method stub
//		return  productRepo.save(product);
//	}
//	@Override
//	public void deleteProduct(Long id) {
//		productRepo.delete(id);
//	}
//	@Override
//	public OrderDetail getOrderDetailById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
