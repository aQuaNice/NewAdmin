package be.Admin.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import be.Admin.Model.VolModel;

public interface GeneralRepositoryVol extends JpaRepository<VolModel, Long> {
	
	public List<VolModel> findAllByOrderByIdAsc();
}


//public interface GeneralRepository extends JpaRepository<PcsModel, Long> { }