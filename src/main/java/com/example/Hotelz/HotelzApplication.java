package com.example.Hotelz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HotelzApplication {
	public static void main(String[] args) {
		SpringApplication.run(HotelzApplication.class, args);
	}

}
