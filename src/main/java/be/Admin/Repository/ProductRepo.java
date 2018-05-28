package be.Admin.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import be.Admin.Model.Product;
import be.Admin.Model.ProductCategory;

public interface ProductRepo extends JpaRepository<Product, Long> {

	List<Product> findByEventuse(int i); 
	}