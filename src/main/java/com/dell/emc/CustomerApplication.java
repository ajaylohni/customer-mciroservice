package com.dell.emc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@EnableEurekaClient


@SpringBootApplication
public class CustomerApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
  }
  
  
}
