package com.second.service.impl;

import java.util.Map;

import com.second.dto.SaleRecordDto;


public interface SaleService {

	Map<Integer, SaleRecordDto> getAll();
}
