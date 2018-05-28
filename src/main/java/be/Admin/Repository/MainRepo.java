package be.Admin.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import be.Admin.Model.Member;

//import be.dashmon.domain.Check;

@Repository
public interface MainRepo extends PagingAndSortingRepository<Member, Long> {

}

