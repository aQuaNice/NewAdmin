package be.Admin.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import be.Admin.Model.PcsModel;
import be.Admin.Model.VolModel;

public interface GeneralRepositoryPcs extends JpaRepository<PcsModel, Long> { 
	
	public List<PcsModel> findAllByOrderByIdAsc();
}


//public interface GeneralRepository extends JpaRepository<PcsModel, Long> { }