package com.qa.springtest.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springtest.persistence.domain.Band;

@Repository
public interface BandRepository extends JpaRepository<Band, Long> {

} 
