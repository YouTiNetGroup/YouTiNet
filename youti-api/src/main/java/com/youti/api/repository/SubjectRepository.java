package com.youti.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youti.api.bean.SubjectBean;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectBean, Integer> {

}
