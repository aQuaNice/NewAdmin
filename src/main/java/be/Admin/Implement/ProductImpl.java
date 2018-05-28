package be.Admin.Implement;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.Admin.Model.EventItem;
import be.Admin.Model.Product;
import be.Admin.Repository.ProductRepo;
import be.Admin.Service.ProductService;
@Service
@Transactional
public class ProductImpl implements ProductService{
	@Autowired
	JdbcTemplate jTemplate;
    @Autowired
	ProductRepo productRepo;
    public Page<Product> getProductLog(int pageNumber,int size) {
        PageRequest request =  new PageRequest(pageNumber - 1, size, Sort.Direction.ASC, "id");
        return productRepo.findAll(request);
    }
	@Override
	public Product getProductById(Long id){
		return productRepo.findOne(id);
	}
	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return  productRepo.save(product);
	}
	@Override
	public void deleteProduct(Long id) {
		productRepo.delete(id);
	}
	
	
	@Override
	public void updaTeProduct(Set<EventItem> eventItem, int stat) {
		
		 for(EventItem listPrice : eventItem){
			 
			 int SuccessStat =0;
				String sql ="UPDATE tbm_item SET eventuse = ? WHERE id = ?";
				Object[] args = new Object[]{stat,listPrice.getIditem()};
			
						try{
							jTemplate.update(sql, args);
//							respon.setRsltcode("22");
						}catch(Exception e){
							e.printStackTrace();
//							SuccessStat = 0;
//							respon.setRsltcode("23");
						}
//			 listPrice.setEveprice((float) (listPrice.getEveprice() - (listPrice.getEveprice()*lcSeteve)));
		 }
		// TODO Auto-generated method stub
		
	}
}
