package be.Admin.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.Admin.Model.QtyModel;
import be.Admin.Model.VolModel;

//public class GeneralRepositoryQty extends JpaRepository<QtyModel, Long> {
//
//}


public interface GeneralRepositoryQty extends JpaRepository<QtyModel, Long> {
	
	public List<QtyModel> findAllByOrderByIdAsc();
}
