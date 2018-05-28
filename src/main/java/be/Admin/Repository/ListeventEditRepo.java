package be.Admin.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.Admin.Model.ListeventEdit;


public interface ListeventEditRepo extends JpaRepository<ListeventEdit, Long> {

	List<ListeventEdit> findByEvenstatOrEvenstat(Long dataid, Object object);

//	public List<VolModel> findAllByOrderByIdAsc();
	
}


