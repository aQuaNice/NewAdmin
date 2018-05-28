package be.Admin.Implement;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.Admin.Model.EventItem;
import be.Admin.Model.KategoryModel;
import be.Admin.Model.ListPo;
import be.Admin.Model.ListeventEdit;
import be.Admin.Model.PcsModel;
import be.Admin.Model.Product;
import be.Admin.Model.ProductCategory;
import be.Admin.Model.QtyModel;
import be.Admin.Model.VolModel;
import be.Admin.Repository.EvenItemRepo;
import be.Admin.Repository.GeneralRepositoryPcs;
import be.Admin.Repository.GeneralRepositoryQty;
import be.Admin.Repository.GeneralRepositoryVol;
import be.Admin.Repository.GenerqalRepositoryPC;
import be.Admin.Repository.ListPoRepo;
import be.Admin.Repository.ListeventEditRepo;
import be.Admin.Repository.ProductRepo;
import be.Admin.Service.GeneralService;
@Service
@Transactional
public class GeneralServiceImpl implements GeneralService{

	
	 @Autowired
	 GeneralRepositoryPcs GeneralRepositorypcs;
	 
	 @Autowired	 
	 GeneralRepositoryVol 	 GeneralRepositoryvol;
	 
	 @Autowired	 
	 GenerqalRepositoryPC 	 GenerqalRepositorypc;
	 
	 @Autowired	 
	 GeneralRepositoryQty 	 GeneralRepositoryqty;
	 
	 @Autowired	 
	 EvenItemRepo GeneralEvenItemRepo;
	 
	 @Autowired	 
	 ListeventEditRepo GeneralListeventEditRepo;
	 
//	 @Autowired	 
//	 ListPoRepo listPoRepo;
	 
	 @Autowired	 
	 ProductRepo GeneralRepoproduct;
	 
	@Override
	public List<VolModel> getAllvol() {
//		PageRequest request =  new PageRequest(pageNumber - 1, size, Sort.Direction.ASC, "id");
	return GeneralRepositoryvol.findAll();

	}
	
	
	@Override
	public List<PcsModel> getAllPcs() {
		// TODO Auto-generated method stub
		return GeneralRepositorypcs.findAll();
	}


	@Override
	public List<KategoryModel> getAllkat() {
		// TODO Auto-generated method stub
		return GenerqalRepositorypc.findAll();
	}


	@Override
	public List<QtyModel> getAllqty() {
		// TODO Auto-generated method stub
		return GeneralRepositoryqty.findAll();
	}


	@Override
	public List<Product> getAllprod() {
		// TODO Auto-generated method stub
		return GeneralRepoproduct.findByEventuse(0);
	}


	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return GeneralRepoproduct.findAll();
	}


	@Override
	public List<EventItem> getAllEvent(Long dataid) {
		// TODO Auto-generated method stub
		return GeneralEvenItemRepo.findByIdevent(dataid);
	}


	@Override
	public List<ListeventEdit> getAllEventProduct(Long dataid) {
		// TODO Auto-generated method stub
		return GeneralListeventEditRepo.findByEvenstatOrEvenstat(dataid,null);
	}
	
//	@Override
//	public List<ListPo> getAllPoProduct(Date orddate) {
//		// TODO Auto-generated method stub
//		return listPoRepo.findByTglord(orddate);
//	}

}
