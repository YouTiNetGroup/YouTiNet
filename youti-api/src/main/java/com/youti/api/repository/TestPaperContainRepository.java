package com.youti.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youti.api.bean.TestPaperContainBean;

@Repository
public interface TestPaperContainRepository extends JpaRepository<TestPaperContainBean,Integer> {

}
