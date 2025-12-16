package Medical_Coding.controller;

import Medical_Coding.model.InquiryRequestDTO;
import Medical_Coding.service.Impl.InquiryServiceImpl;
import Medical_Coding.service.InquiryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inquiry")
@RequiredArgsConstructor
public class InquiryController {

    private final InquiryServiceImpl inquiryService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitInquiry(@RequestBody InquiryRequestDTO dto) {
        try {
            // Save inquiry (could be DB or forward to Google Sheets)
            inquiryService.submitInquiry(dto);

            return ResponseEntity.ok("Inquiry submitted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to submit inquiry");
        }
    }
}
