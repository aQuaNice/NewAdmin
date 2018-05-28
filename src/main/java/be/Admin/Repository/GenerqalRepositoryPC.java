package be.Admin.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.Admin.Model.KategoryModel;
//import be.Admin.Model.ProductCategory;

//import be.Admin.Model.VolModel;
//
//public class GenerqalRepositoryPC {
//
//}


public interface GenerqalRepositoryPC extends JpaRepository<KategoryModel, Long> {
	
	public List<KategoryModel> findAllByOrderByIdAsc();
}

