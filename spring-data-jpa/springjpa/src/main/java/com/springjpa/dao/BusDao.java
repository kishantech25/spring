package com.springjpa.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;

import com.springjpa.entities.Bus;

@Repository
public class BusDao {
	@Autowired
	private JpaTemplate jpaTemplate;

	public int saveBus(Bus bus) {
		jpaTemplate.persist(bus);
		return bus.getBusNo();
	}

	public Bus findBus(int busNo) {
		return jpaTemplate.find(Bus.class, busNo);
	}

	public List<Bus> findBusesByManufacturer(String manufacturer) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("manufacturer", manufacturer);
		return jpaTemplate.find("from Bus bus where bus.manufacturer = :manufacturer", paramMap);
	}

}
