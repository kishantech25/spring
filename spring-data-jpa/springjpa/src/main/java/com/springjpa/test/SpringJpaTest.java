package com.springjpa.test;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springjpa.config.RootConfig;
import com.springjpa.entities.Bus;
import com.springjpa.service.BusService;

public class SpringJpaTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
		BusService busService = context.getBean(BusService.class);

		Bus bus = Bus.builder().chasisNo("c0383").engineNo("e93893").rtaRegistrationNo("TS09BQ9383")
				.manufacturer("Benz").model("semisleeper").price(2400000).dateOfRegistration(LocalDate.now()).build();
		int busNo = busService.addBus(bus);
		System.out.println("busNo: " + busNo);
	}
}
