package Medical_Coding.controller;

import Medical_Coding.model.LeadRequestDTO;
import Medical_Coding.service.LeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/leads")
@RequiredArgsConstructor
public class LeadController {
    private final LeadService leadService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitLead(
            @RequestBody LeadRequestDTO dto) {

        leadService.saveLeadAndNotifyAdmin(dto);
        return ResponseEntity.ok("Details submitted successfully");
    }
}
