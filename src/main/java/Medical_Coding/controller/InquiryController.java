package Medical_Coding.controller;

import Medical_Coding.model.Inquiry;
import Medical_Coding.model.InquiryRequestDTO;
import Medical_Coding.service.InquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inquiry")
@RequiredArgsConstructor
public class InquiryController {

    private final InquiryService inquiryService;

    // Submit Inquiry
    @PostMapping("/submit")
    public ResponseEntity<String> submitInquiry(@RequestBody InquiryRequestDTO dto) {
        try {
            inquiryService.saveInquiry(dto);
            return ResponseEntity.ok("Inquiry submitted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to submit inquiry");
        }
    }

    // Fetch All Inquiries
    @GetMapping("/all")
    public ResponseEntity<List<Inquiry>> getAllInquiries() {
        List<Inquiry> inquiries = inquiryService.getAllInquiries();
        return ResponseEntity.ok(inquiries);
    }
}
