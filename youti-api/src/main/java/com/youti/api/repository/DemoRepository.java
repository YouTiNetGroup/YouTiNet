package com.youti.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youti.api.bean.DemoBean;

@Repository
public interface DemoRepository extends JpaRepository<DemoBean,Integer>{
	//CrudRepository，PagingAndSortingRepository，SimpleJpaRepository，等大量接口
	//JpaRepository接口（继承了CrudRepository接口QueryDslJpaRepository
}
