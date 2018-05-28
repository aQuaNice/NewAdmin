package be.Admin.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.Admin.Model.OrderDetail;
import be.Admin.Model.OrderHead;
import be.Admin.Repository.OrderDetRepo;
import be.Admin.Repository.OrderRepo;
import be.Admin.Service.OrderDetService;
import be.Admin.Service.OrderService;
@Service
@Transactional
public class OrderdetImpl implements OrderDetService{
	@Autowired
	JdbcTemplate jTemplate;
    @Autowired
    OrderDetRepo orderdetRepo;
	@Override
	public OrderHead getOrderDetailById(Long id) {
		return orderdetRepo.findOne(id);
		}
}
