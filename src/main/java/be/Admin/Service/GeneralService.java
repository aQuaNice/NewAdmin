package be.Admin.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import be.Admin.Model.EventItem;
import be.Admin.Model.KategoryModel;
import be.Admin.Model.ListPo;
import be.Admin.Model.ListeventEdit;
import be.Admin.Model.PcsModel;
import be.Admin.Model.Product;
import be.Admin.Model.VolModel;
import be.Admin.Model.ProductCategory;
import be.Admin.Model.QtyModel;

public interface GeneralService {

//	
//	public Page<Product> getProductLog(int pageNumber, int pagesize);
	public List<VolModel> getAllvol();
	public List<PcsModel> getAllPcs();
	public List<KategoryModel> getAllkat();
	public List<QtyModel> getAllqty();
	public List<Product> getAllprod();
	public List<Product> getAll();
	public List<EventItem> getAllEvent(Long dataid);
	public List<ListeventEdit> getAllEventProduct(Long dataid);
//	List<ListPo> getAllPoProduct(Date orddate);
	
//	void deleteProduct(Long id);
}
