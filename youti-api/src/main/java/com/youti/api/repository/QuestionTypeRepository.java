package com.youti.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youti.api.bean.QuestionTypeBean;

@Repository
public interface QuestionTypeRepository extends JpaRepository<QuestionTypeBean, Integer> {

}
