package Medical_Coding.service.Impl;

import Medical_Coding.model.Inquiry;
import Medical_Coding.model.InquiryRequestDTO;
import Medical_Coding.repository.InquiryRepository;
import Medical_Coding.service.InquiryService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InquiryServiceImpl implements InquiryService {

    private static final String GOOGLE_SCRIPT_URL =
            "https://script.google.com/macros/s/AKfycbyCf6VbtebubmkzZ7U5tTmETNb16F8-dSTgEdjeoeuQvZMn4BptAtK02rNrH35mCfIc/exec";

    private final InquiryRepository inquiryRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    // ✅ Constructor injection
    public InquiryServiceImpl(InquiryRepository inquiryRepository) {
        this.inquiryRepository = inquiryRepository;
    }

    @Override
    public void saveInquiry(InquiryRequestDTO dto) {
        // Save in MongoDB
        Inquiry inquiry = new Inquiry();
        inquiry.setName(dto.getName());
        inquiry.setPhone(dto.getPhone());
        inquiry.setInquiryType(dto.getInquiryType());
        inquiry.setMessage(dto.getMessage());
        inquiry.setCreatedAt(LocalDateTime.now());

        inquiryRepository.save(inquiry);

        // Optional: send to Google Sheets
        Map<String, Object> payload = new HashMap<>();
        payload.put("name", dto.getName());
        payload.put("phone", dto.getPhone());
        payload.put("enquiry", dto.getInquiryType());
        payload.put("message", dto.getMessage());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(payload, headers);

        restTemplate.postForEntity(GOOGLE_SCRIPT_URL, request, String.class);
    }

    @Override
    public List<Inquiry> getAllInquiries() {
        return inquiryRepository.findAll();
    }
}
