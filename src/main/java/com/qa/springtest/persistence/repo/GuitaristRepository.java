package com.qa.springtest.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springtest.persistence.domain.Guitarist;

@Repository
public interface GuitaristRepository extends JpaRepository<Guitarist, Long> {

} 
