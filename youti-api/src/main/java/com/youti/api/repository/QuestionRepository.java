package com.youti.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youti.api.bean.QuestionBean;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionBean, Integer> {

}
