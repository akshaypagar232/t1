package com.second.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.second.dto.SaleRecordDto;
import com.second.service.impl.SaleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/sale")
public class SaleController {

	@Autowired
	private SaleService saleService;


	@GetMapping()
	public ResponseEntity<Map<Integer,SaleRecordDto>> getAll(){
			
		log.info("Initiated request pass service for get all the details");

		Map<Integer, SaleRecordDto> all = saleService.getAll();
		
		log.info("Completed request for get all the User details");

		return new ResponseEntity<Map<Integer,SaleRecordDto>>(all, HttpStatus.FOUND);
	}

	
}