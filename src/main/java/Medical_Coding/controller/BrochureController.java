package Medical_Coding.controller;

import Medical_Coding.service.BrochureService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brochure")
public class BrochureController {

    private final BrochureService brochureService;

    public BrochureController(BrochureService brochureService) {
        this.brochureService = brochureService;
    }

    @PostMapping("/download")
    public ResponseEntity<Resource> downloadBrochure(
            @RequestParam String email,
            @RequestParam String phone) {

        Resource brochure = brochureService.saveLeadAndGetBrochure(email, phone);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=course-brochure.pdf")
                .body(brochure);
    }
}
