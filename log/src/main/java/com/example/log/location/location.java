package com.example.log.location;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class location {

    @GetMapping("/get-location")
    public Map<String, Object> getUserLocation(HttpServletRequest request) {
        String ipAddress = getPublicIp();  // Get external IP

        if (ipAddress == null || ipAddress.isEmpty()) {
            ipAddress = getClientIp(request); // Fallback to request IP
        }

        String url = "http://ip-api.com/json/" + ipAddress;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Map.class);
    }

    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    private String getPublicIp() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject("https://checkip.amazonaws.com", String.class).trim();
        } catch (Exception e) {
            return null;  // Return null if request fails
        }
    }
}
