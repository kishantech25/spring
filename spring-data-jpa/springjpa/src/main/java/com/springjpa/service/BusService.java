package com.springjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springjpa.dao.BusDao;
import com.springjpa.entities.Bus;

@Service
public class BusService {
	@Autowired
	private BusDao busDao;

	@Transactional(readOnly = false)
	public int addBus(Bus bus) {
		return busDao.saveBus(bus);
	}
}
