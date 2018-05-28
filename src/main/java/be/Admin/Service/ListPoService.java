package be.Admin.Service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import be.Admin.Model.ListPo;
import be.Admin.Model.OrderHead;
@Component
public interface ListPoService {
	public Page<ListPo> getOrderpo(int pageNumber, int pagesize);

}
