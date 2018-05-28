package be.Admin.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.Admin.Model.ListPo;
import be.Admin.Repository.ListPoRepo;
import be.Admin.Repository.ListeventEditRepo;
import be.Admin.Service.ListPoService;

@Service
@Transactional
public class ListPoImpl implements ListPoService {
	 @Autowired	 
	 ListPoRepo listPoRepo;
	 
	@Override
	public Page<ListPo> getOrderpo(int pageNumber, int size) {
	PageRequest request =  new PageRequest(pageNumber - 1, size, Sort.Direction.ASC, "id");
//	        return productRepo.findAll(request);
//		listPoRepo.findAll(request);
		// TODO Auto-generated method stub
		return listPoRepo.findAll(request);
	}

}
