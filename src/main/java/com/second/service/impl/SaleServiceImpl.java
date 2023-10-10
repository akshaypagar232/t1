package com.second.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.dto.SaleRecordDto;
import com.second.entity.SaleRecord;
import com.second.repository.SaleRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleRepo saleRepo;

	@Override
	public Map<Integer,SaleRecordDto> getAll() {

		log.info("Initiated request for get all details in database");

		List<SaleRecord> findAll = saleRepo.findAll();

		Map<Integer, SaleRecordDto> allMap = new HashMap<>();

		findAll.forEach(i -> {

			int customerId = i.getCustomerId();
			Double revenue = i.getProductPrice() * i.getQuantity();

			SaleRecordDto dto = SaleRecordDto.builder()
					.customerName(i.getCustomerName())
					.totalRevenue(revenue)
					.build();

			allMap.put(customerId, dto);

		});
		
		log.info("Completed request for get all details in database");


		return allMap;
	}

}
