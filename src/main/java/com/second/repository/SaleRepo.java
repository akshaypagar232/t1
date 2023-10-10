package com.second.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.second.entity.SaleRecord;

public interface SaleRepo extends JpaRepository<SaleRecord, Long> {

}
