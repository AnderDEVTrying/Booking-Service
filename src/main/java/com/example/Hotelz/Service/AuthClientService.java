package com.example.Hotelz.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "Auth-Service", url = "http://localhost:8082")
public interface AuthClientService {
        @GetMapping("/auth/validate")
        ResponseEntity<String> validateTokenAndGetCustomer(@RequestHeader("Authorization") String token);

}
