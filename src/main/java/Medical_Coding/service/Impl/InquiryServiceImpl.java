package Medical_Coding.service.Impl;

import Medical_Coding.model.InquiryRequestDTO;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class InquiryServiceImpl {

    private static final String GOOGLE_SCRIPT_URL =
            "https://script.google.com/macros/s/AKfycbyCf6VbtebubmkzZ7U5tTmETNb16F8-dSTgEdjeoeuQvZMn4BptAtK02rNrH35mCfIc/exec";

    private final RestTemplate restTemplate = new RestTemplate();

    public void submitInquiry(InquiryRequestDTO dto) {

        Map<String, Object> payload = new HashMap<>();
        payload.put("name", dto.getName());
        payload.put("phone", dto.getPhone());

        // VERY IMPORTANT: match Apps Script field name
        payload.put("enquiry", dto.getInquiryType());

        payload.put("message", dto.getMessage());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(payload, headers);

        restTemplate.postForEntity(
                GOOGLE_SCRIPT_URL,
                request,
                String.class
        );
    }
}
