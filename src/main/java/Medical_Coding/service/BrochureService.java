package Medical_Coding.service;

import org.springframework.core.io.Resource;

public interface BrochureService {

    Resource saveLeadAndGetBrochure(String email, String phone);
}
