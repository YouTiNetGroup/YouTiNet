package com.youti.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.youti.api.bean.DemoBean;

@Repository
public interface DemoRepository extends CrudRepository<DemoBean,Integer>{
	//CrudRepository，PagingAndSortingRepository，SimpleJpaRepository，QueryDslJpaRepository等大量接口
}
