package com.example.Hotelz.Service;

import com.example.Hotelz.DTO.EmailRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "EmailService", url = "http://localhost:8080")
public interface EmailClient {
    @PostMapping("/email/send")
    void sendEmail(@RequestBody EmailRequest emailRequest);
}
