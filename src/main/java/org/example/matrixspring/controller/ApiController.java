package org.example.matrixspring.controller;

import lombok.RequiredArgsConstructor;
import org.example.matrixspring.service.CustomerService;
import org.example.matrixspring.service.OtpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final OtpService otpService;
    private final CustomerService customerService;

    @PostMapping("/generate-otp")
    public ResponseEntity<String> generateOtp(@RequestParam String email) {
        String otp = otpService.generateOtp(email);
        return ResponseEntity.ok("OTP has been sent to your email.");
    }

    @GetMapping("/customers")
    public ResponseEntity<?> getCustomers(@RequestHeader(value = "otp", required = false) String otpCode) {
        if (otpCode == null || !otpService.isValidOtp(otpCode)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Invalid or expired OTP");
        }
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
}
