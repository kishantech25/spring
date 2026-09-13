package com.records.RecordsJava17DemoOther;

import com.records.RecordsJava17DemoOther.loader.CustomClassLoaderA;
import com.records.RecordsJava17DemoOther.loader.CustomClassLoaderB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class RecordsJava17DemoOtherApplication {

	public static void main(String[] args) throws Exception {


		ApplicationContext context =SpringApplication.run(RecordsJava17DemoOtherApplication.class, args);

          CustomClassLoaderA laoderA= context.getBean(CustomClassLoaderA.class);
		//find duplicate Elements in List
//		List<Integer> list = Arrays.asList(1,2,3,4,6,1,9,5,6,7,8,9);
//
//		Set<Integer> unique =new HashSet<>();
//		list.stream()
//				.filter(n->!unique.add(n))
//				.forEach(System.out::println);


		Path baseDirectory =
				Path.of("target/classes");

		CustomClassLoaderA loaderA =
				new CustomClassLoaderA(baseDirectory);

		Class<?> userClassA =
				loaderA.loadClass(
						"com.records.RecordsJava17DemoOther.util.User"
				);

		System.out.println(
				"Loaded class = " + userClassA
		);

		System.out.println(
				"ClassLoader = " +
						userClassA.getClassLoader()
		);



	}
}
