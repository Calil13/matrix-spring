package org.example.matrixspring.service;

import lombok.RequiredArgsConstructor;
import org.example.matrixspring.dao.entity.OTP;
import org.example.matrixspring.dao.repository.OtpRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OtpService {

    private final OtpRepository otpRepository;
    private final JavaMailSender mailSender;

    @Value("${otp.expire.minutes:1}")
    private long otpExpireMinutes;

    public String generateOtp(String email) {

        String code = String.valueOf((int)(Math.random() * 900000) + 100000);


        OTP otp = new OTP();
        otp.setCode(code);
        otp.setExpiryTime(LocalDateTime.now().plusMinutes(otpExpireMinutes));
        otpRepository.save(otp);

        sendOtpEmail(email, code);

        return code;
    }

    public boolean isValidOtp(String code) {
        Optional<OTP> otpOptional = otpRepository.findByCode(code);
        if (otpOptional.isEmpty()) return false;

        OTP otp = otpOptional.get();
        if (otp.getExpiryTime().isBefore(LocalDateTime.now())) {
            return false;
        }

        return true;
    }

    private void sendOtpEmail(String toEmail, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Your OTP Code");
        message.setText("Your OTP code is: " + code + "\nIt is valid for " + otpExpireMinutes + " minute(s).");

        mailSender.send(message);
    }
}
