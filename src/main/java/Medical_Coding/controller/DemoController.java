package Medical_Coding.controller;

import Medical_Coding.model.DemoForm;
import Medical_Coding.service.Impl.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/form") // allow frontend
public class DemoController {
    private final DemoService demoService;

    @PostMapping("/submit")
    public DemoForm saveDemo(@RequestBody DemoForm form) {
        return demoService.saveForm(form);
    }
}