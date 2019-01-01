package com.youti.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youti.api.bean.TestPaperBean;

@Repository
public interface TestPaperRepository extends JpaRepository<TestPaperBean, Integer> {

}
