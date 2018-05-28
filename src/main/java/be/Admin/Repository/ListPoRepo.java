package be.Admin.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.Admin.Model.ListPo;
import be.Admin.Model.ListeventEdit;


public interface ListPoRepo extends JpaRepository<ListPo, Long> {

	List<ListPo> findByTglord(Date orddate);

//	void findAll(ListPoRepo listPoRepo);

	//List<ListeventEdit> findByEvenstatOrEvenstat(Long dataid, Object object);

//	public List<VolModel> findAllByOrderByIdAsc();
	
}


