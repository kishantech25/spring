package com.tourplanner.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tourplanner.config.RootConfig;
import com.tourplanner.service.TripService;

public class TourPlannerTest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
		TripService tripService = context.getBean(TripService.class);

//		TripDto tripDto = TripDto.builder().source("Hyderabad").destination("Jaipur").tripName("Jaipur Trip")
//				.plannedDate(LocalDate.of(2022, 10, 29)).estimatedCost(150000).days(7).build();
//		int tripNo = tripService.newTrip(tripDto);
//		System.out.println("tripNo : " + tripNo);
//		TripDto tripDto = tripService.findTrip(2);
//		System.out.println(tripDto);
		// tripService.deleteTrip(2);
		// tripService.getAllTrips().forEach(System.out::println);
		// tripService.getAllTrips(5, 1).forEach(System.out::println);
		tripService.getTrips("days").forEach(System.out::println);
	}
}
