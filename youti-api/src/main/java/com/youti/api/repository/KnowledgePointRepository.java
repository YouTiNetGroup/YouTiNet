package com.youti.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youti.api.bean.KnowledgePointBean;

@Repository
public interface KnowledgePointRepository extends JpaRepository<KnowledgePointBean, Integer> {

}
