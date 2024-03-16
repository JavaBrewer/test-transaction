package com.example.demoipget;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserIPRepository userIPRepository;

    @GetMapping("/api")
    public ResponseEntity<String> myApi(HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr();

        UserIP userIP = new UserIP();
        userIP.setIpAddress(ipAddress);
        userIPRepository.save(userIP);

        return  ResponseEntity.ok("API 호출이 완료되었습니다.");
    }
}
