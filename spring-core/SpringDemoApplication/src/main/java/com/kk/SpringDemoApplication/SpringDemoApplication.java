package com.kk.SpringDemoApplication;

import com.kk.SpringDemoApplication.model.Alien;
import com.kk.SpringDemoApplication.model.Dekstop;
import com.kk.SpringDemoApplication.model.Laptop;
import com.kk.SpringDemoApplication.repository.MoneyTransferRepository;
import com.kk.SpringDemoApplication.service.LaptopService;
import com.kk.SpringDemoApplication.service.MoneyTransferService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context =SpringApplication.run(SpringDemoApplication.class);

		Alien obj =context.getBean(Alien.class);
		Laptop laptop =context.getBean(Laptop.class);
		Dekstop dekstop =context.getBean(Dekstop.class);
		LaptopService lapService =context.getBean(LaptopService.class);

		//create the Money Transfer Service
		MoneyTransferService service =context.getBean(MoneyTransferService.class);
		service.transferMoney(1001,1002,10000.0);

		System.out.println();
		lapService.addLaptop(laptop);
		obj.code();
		System.out.println(obj.getAge());
		laptop.compile();
		dekstop.compile();
	}

}
