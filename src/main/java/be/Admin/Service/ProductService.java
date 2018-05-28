package be.Admin.Service;

import java.util.Set;

import org.springframework.data.domain.Page;

import be.Admin.Model.EventItem;
import be.Admin.Model.Product;
import be.Admin.Model.ProductCategory;

public interface ProductService {

	public Page<Product> getProductLog(int pageNumber, int pagesize);
	Product getProductById(Long id);
	Product saveProduct(Product product);
	void deleteProduct(Long id);
	public void updaTeProduct(Set<EventItem> eventItem,int stat);
//	public void updaTeProduct(Set<EventItem> eventItem, int stat);
	
}
